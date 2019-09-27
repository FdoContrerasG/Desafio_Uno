package com.desafio.nivel1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static com.desafio.nivel1.utilidades.*;

public class principal {

    public static void main(String[] args) {
        // Declaración de variable
        String nmb_archivo_entrada = null, nmb_archivo_salida = null, aux = "";
        if (args.length > 0) {
            nmb_archivo_entrada = "\\resources\\" + args[0];
            nmb_archivo_salida = args[1];
        } else {
            System.out.println("Debe ingresar el nombre del archivo de entrada y de salida, favor volver a intentar.");
            System.exit(0);
            //nmb_archivo_entrada = "\\resources\\gdd.json";
            //nmb_archivo_salida = "resp.json";
        }
        Integer i, j, difM, confirm = 0;
        Calendar fechaCreacion, fechaIntervalo, fechaFin, fechaActual;
        Date fechaAux;
        JSONArray fechas = null;
        ArrayList<String> fechasFaltantes = new ArrayList<>();

        fechaActual = Calendar.getInstance();

        try {
            // Leer archivo JSON
            aux = leerArchivo(nmb_archivo_entrada);

            System.out.println("Lectura de archivo Exotosa!!");

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(aux);
            } catch (JSONException e) {
                System.out.println("A ocurrido un error con el Objeto/Arreglo JSON");
                e.printStackTrace();
            }

            System.out.println("Objeto JSON creado Exitosamente!!");

            fechaCreacion = convertFecha((String) jsonObject.get("fechaCreacion"));
            fechaIntervalo = convertFecha((String) jsonObject.get("fechaCreacion"));
            fechaFin = convertFecha((String) jsonObject.get("fechaFin"));

            System.out.println("Las fechas han sido convertidas con Exito!!");

            difM = calculaMeses(fechaFin, fechaCreacion);

            System.out.println("Cantidad de meses de diferencia: " + difM);

            try {
                fechas = (JSONArray) jsonObject.get("fechas");
            } catch (JSONException e1) {
                System.out.println("A ocurrido un error con el Objeto/Arreglo JSON");
                e1.printStackTrace();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (i = 1; i <= difM; i++) {
                for (j = 0; j < fechas.length(); j++) {
                    try {
                        try {
                            fechaAux = sdf.parse((String) fechas.get(j));
                            fechaActual.setTime(fechaAux);
                        } catch (JSONException e) {
                            System.out.println("A ocurrido un error con el Objeto/Arreglo JSON");
                            e.printStackTrace();
                        }
                    } catch (java.text.ParseException e) {
                        System.out.println("Error en el formato de la cadena");
                        e.printStackTrace();
                    }
                    if (fechaIntervalo.compareTo(fechaActual) == 0) {
                        confirm++;
                    }
                }
                if (confirm == 0) {
                    fechasFaltantes.add(sdf.format(fechaIntervalo.getTime()));
                }
                confirm = 0;
                fechaIntervalo.add(Calendar.MONTH, 1);
            }

            System.out.println("Fin a la busqueda de fechas faltantes");
            
            
            JSONObject jsonObjectResp = new JSONObject();
            try {
                jsonObjectResp.put("id", jsonObject.get("id"));
                jsonObjectResp.put("fechaCreacion", jsonObject.get("fechaCreacion"));
                jsonObjectResp.put("fechaFin", jsonObject.get("fechaFin"));
                jsonObjectResp.put("fechasFaltantes", fechasFaltantes);
            } catch (JSONException e) {
                System.out.println("A ocurrido un error con el Objeto/Arreglo JSON");
                e.printStackTrace();
            }
            
            System.out.println("Archivo JSON de respuesta generado Exitosamente!!");

            escribirArchivo(jsonObjectResp.toString(), nmb_archivo_salida);

        } catch (NullPointerException ex) {
            System.out.println("No se ha creado el objeto de alguna de la variables declaradas");
            ex.printStackTrace();
        } catch (JSONException ex) {
            System.out.println("A ocurrido un error con el Objeto/Arreglo JSON");
            ex.printStackTrace();
        }
        
        System.out.println("Programa finalizado Exitosamente!!");

    }
}
