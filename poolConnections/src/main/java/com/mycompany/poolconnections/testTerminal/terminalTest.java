/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poolconnections.testTerminal;

/**
 *
 * @author truji
 */
public class terminalTest {
    public static void main(String[] args){
          try {
            // Comando y argumentos para abrir la terminal
            String os = System.getProperty("os.name").toLowerCase();
            String command = "";
            if (os.contains("win")) {
                command = "cmd.exe";
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                command = "bash";
            } else {
                System.out.println("No se pudo determinar el sistema operativo compatible.");
                return;
            }
            
            // Crear un proceso y configurarlo con el comando de la terminal
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Iniciar el proceso
            Process process = processBuilder.start();

            // Obtener el flujo de salida del proceso para escribir en la terminal
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            // Escribir comandos en la terminal
            writer.write("echo 'Hola Mundo'"); // Ejecuta el comando 'echo' para imprimir 'Hola Mundo'
            writer.newLine();
            writer.write("touch archivo.txt"); // Ejecuta el comando 'touch' para crear un archivo llamado 'archivo.txt'
            writer.newLine();
            writer.write("exit"); // Cierra la terminal
            writer.newLine();
            writer.flush();

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }  
    }
}
