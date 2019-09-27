package com.desafio.nivel1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utilidades {

    public utilidades() {
    }
    
    
    
    /* Funciones */
    public static int calculaMeses(Calendar fechaFin, Calendar fechaCreacion) {

        Integer difA, difM;

        difA = fechaFin.get(Calendar.YEAR) - fechaCreacion.get(Calendar.YEAR);
        difM = difA * 12 + fechaFin.get(Calendar.MONTH) - fechaCreacion.get(Calendar.MONTH);

        return difM;

    }

    public static void escribirArchivo(String datos, String nmb_archivo_salida) {
        String aux = nmb_archivo_salida;
        File archivo = new File(aux);

        archivo.delete();

        try {
            archivo.createNewFile();
            try (FileWriter escribir = new FileWriter(nmb_archivo_salida, true)) {
                escribir.write(datos);
                escribir.flush();
            }
        } catch (IOException ioe) {
            System.out.println("Error en la Entrada/Salida del archivo");
            ioe.printStackTrace();
        }

        System.out.println("Archivo de salida creado exitosamente!!");

    }

    public static String leerArchivo(String nmb_archivo) {

        String datos = "", cadena = null, regex = "[\\D]*Desafio", aux = null;
        String a = new File("").getAbsolutePath();

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            a = matcher.group();
        }

        nmb_archivo = a + nmb_archivo;
        nmb_archivo = nmb_archivo.replace("\\", "\\\\");

        System.out.println(nmb_archivo);

        FileReader archivo = null;
        try {
            archivo = new FileReader(nmb_archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader lector = new BufferedReader(archivo);

        try {
            // Almacenar contenido del archivo
            while ((cadena = lector.readLine()) != null) {
                datos = datos + cadena;
            }
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public static Calendar convertFecha(String fecha) {
        Calendar fechaResp = Calendar.getInstance();
        Date fechaAux;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            fechaAux = sdf.parse(fecha);
            fechaResp.setTime(fechaAux);
        } catch (java.text.ParseException e) {
            System.out.println("Error en el formato de la cadena");
            e.printStackTrace();
        }

        return fechaResp;
    }
    
}
