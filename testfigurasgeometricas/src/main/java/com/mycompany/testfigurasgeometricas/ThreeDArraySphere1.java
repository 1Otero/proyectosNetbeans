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

public class ThreeDArraySphere1 extends Application {

    private static final int SPHERE_RADIUS = 100;
    private static final int SUBDIVISIONS = 50;

    @Override
    public void start(Stage primaryStage) {
        TriangleMesh mesh = createSphereMesh();
        MeshView sphere = new MeshView(mesh);
        sphere.setCullFace(CullFace.NONE);
        sphere.setMaterial(new javafx.scene.paint.PhongMaterial(Color.RED));

        Group root = new Group(sphere);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(-400);

        Scene scene = new Scene(root, 800, 600);
        scene.setCamera(camera);

        primaryStage.setTitle("3D Array Sphere");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TriangleMesh createSphereMesh() {
        TriangleMesh mesh = new TriangleMesh();

        float[] points = new float[SUBDIVISIONS * SUBDIVISIONS * 3];
        int[] faces = new int[SUBDIVISIONS * SUBDIVISIONS * 6];

        int pointIndex = 0;
        int faceIndex = 0;

        for (int i = 0; i < SUBDIVISIONS; i++) {
            double phi = Math.PI * 2 * i / SUBDIVISIONS;

            for (int j = 0; j < SUBDIVISIONS; j++) {
                double theta = Math.PI * j / SUBDIVISIONS;

                double x = SPHERE_RADIUS * Math.sin(theta) * Math.cos(phi);
                double y = SPHERE_RADIUS * Math.sin(theta) * Math.sin(phi);
                double z = SPHERE_RADIUS * Math.cos(theta);

                points[pointIndex++] = (float) x;
                points[pointIndex++] = (float) y;
                points[pointIndex++] = (float) z;
            }
        }

        for (int i = 0; i < SUBDIVISIONS - 1; i++) {
            for (int j = 0; j < SUBDIVISIONS - 1; j++) {
                int p1 = i * SUBDIVISIONS + j;
                int p2 = i * SUBDIVISIONS + j + 1;
                int p3 = (i + 1) * SUBDIVISIONS + j;
                int p4 = (i + 1) * SUBDIVISIONS + j + 1;

                faces[faceIndex++] = p1;
                faces[faceIndex++] = p3;
                faces[faceIndex++] = p2;

                faces[faceIndex++] = p2;
                faces[faceIndex++] = p3;
                faces[faceIndex++] = p4;
            }
        }

        mesh.getPoints().setAll(points);
        mesh.getTexCoords().addAll(0, 0);
        mesh.getFaces().setAll(faces);

        return mesh;
    }
    private static final int SIZE = 20; // Tamaño de la matriz
    private static final char SPHERE_CHAR = '*'; // Carácter para representar la esfera
    private static final char EMPTY_CHAR = ' '; // Carácter para representar el espacio vacío

    public static void main(String[] args) {

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

        // Rasterizar la esfera en la matriz
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                double distance = Math.sqrt(Math.pow(i - centerX, 2) + Math.pow(j - centerY, 2));
                if (distance <= radius) {
                    grid[i][j] = SPHERE_CHAR;
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
    }
}
