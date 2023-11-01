package com.mycompany.testfigurasgeometricas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class ThreeDArraySphere{
    private static final int SIZE = 20; // Tamaño de la matriz
    private static final char SPHERE_CHAR = '*'; // Carácter para representar la esfera
    private static final char EMPTY_CHAR = ' '; // Carácter para representar el espacio vacío

    public static void main(String[] args) throws InterruptedException {
        char[][] grid = new char[SIZE][SIZE];

        // Inicializar la matriz con espacios vacíos
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = EMPTY_CHAR;
            }
        }

        // Calcular el radio y el centro de la esfera
        int radius = SIZE / 2;
        int centerX = SIZE / 2;
        int centerY = SIZE / 2;

        double rotationAngle = 0;
        int numRotations = 0;
        while (numRotations < 2) {
            // Rasterizar la esfera en la matriz
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    double distance = Math.sqrt(Math.pow(i - centerX, 2) + Math.pow(j - centerY, 2));
                    if (distance <= radius) {
                        grid[i][j] = SPHERE_CHAR;
                    } else {
                        grid[i][j] = EMPTY_CHAR;
                    }
                }
            }

            // Imprimir la matriz en la consola
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }

            // Actualizar el ángulo de rotación
            rotationAngle += Math.PI / 16; // Ajusta la velocidad de rotación modificando el incremento angular

            // Rotar el centro de la esfera
            centerX = (int) (SIZE / 2 + radius * Math.cos(rotationAngle));
            centerY = (int) (SIZE / 2 + radius * Math.sin(rotationAngle));

            // Limpiar la consola
            Thread.sleep(1000); // Ajusta el tiempo de espera entre cada iteración
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Contar las vueltas completadas
            if (rotationAngle >= 2 * Math.PI) {
                numRotations++;
                rotationAngle = 0;
            }
        }
    }/*
    private static final int SIZE = 40; // Tamaño de la matriz
    private static final char[] SPHERE_CHARS = {' ', '.', ':', '!', '*', 'o', 'O', '@'}; // Caracteres para representar la esfera
    
    public static void main(String[] args) throws InterruptedException {
        char[][] grid = new char[SIZE][SIZE];

        // Inicializar la matriz con caracteres vacíos
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }

        // Calcular el radio y el centro de la esfera
        int radius = SIZE / 2;
        int centerX = SIZE / 2;
        int centerY = SIZE / 2;

        double rotationAngle = 0;
        int numRotations = 0;
        while (numRotations < 2) {
            // Rasterizar la esfera en la matriz
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    double distance = Math.sqrt(Math.pow(i - centerX, 2) + Math.pow(j - centerY, 2));
                    int charIndex = (int) (distance / radius * (SPHERE_CHARS.length - 1));
                    grid[i][j] = SPHERE_CHARS[charIndex - 2];
                }
            }

            // Imprimir la matriz en la consola
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }

            // Actualizar el ángulo de rotación
            rotationAngle += Math.PI / 16; // Ajusta la velocidad de rotación modificando el incremento angular

            // Rotar el centro de la esfera
            centerX = (int) (SIZE / 2 + radius * Math.cos(rotationAngle));
            centerY = (int) (SIZE / 2 + radius * Math.sin(rotationAngle));

            // Limpiar la consola
            Thread.sleep(1000); // Ajusta el tiempo de espera entre cada iteración
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Contar las vueltas completadas
            if (rotationAngle >= 2 * Math.PI) {
                numRotations++;
                rotationAngle = 0;
            }
        }
    }
*/
}
