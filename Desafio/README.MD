
        INSTRUCTIVO DE INSTALACIÓN DESAFÍO

    Para realizar la instalación del programa se deben seguir los siguientes pasos listados a continuación:

    1)  Lo primero es verificar la instalación de java en su sistema, para esto puede 
      abrir la terminal o consola y ejecutar el siguiente comando "java -version"
      de no tener la instalación de java en su ambiente puede seguir ver el tutorial
      indicado en la siguiente página web "https://www.java.com/es/download/help/windows_manual_download.xml".

    2)  Ya teniendo verificado la instalación de java en el ambiente de trabajo
      debe descargar el proyecto en cualquier ruta a elección.

    3) Una vez descargado el proyecto debe abrir la terminal y localizar la ruta en 
      donde se a descargado el proyecto ya localizado el proyecto el .jar ejecutable
      se encuentra dentro de la carpeta dist (en caso de mover el archivo .jar debe
      copiar la carpeta resources que contiene el archivo .json que será leído
      por el programa).

    4)  Ya ubicado en la carpeta dist debe de ejecutar el siguiente comando
      "java -jar Desafio.jar nombre_archivo_entrada.json nombre_archivo_salida.json"
      (el nombre del archivo de entrada debe ser el mismo nombre que posee el archivo
      almacenado en la carpeta resources).

    5) Con esto ya se ha de generar el Archivo de salida con el formato JSON según 
      lo pedido (el archivo se generará en el mismo directorio en el que se encuentra
      el archivo .jar).