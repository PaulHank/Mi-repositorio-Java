package com.liceolapaz.des.pae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

    public static void main(String[] args) throws IOException {
        Process proceso = new ProcessBuilder("C:\\Users\\Pablo Abeijón DAM\\AppData\\Local\\Programs\\Python\\Python310\\python.exe", "C:\\proceso_python\\proceso_python.py").start();
        BufferedReader BOI = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        try {
            proceso.waitFor();
        } catch (InterruptedException e) {
            System.out.println("Error handling process");
            e.printStackTrace();
        }
        int exitSts = proceso.exitValue();
        System.out.println("Retorno "+ BOI.readLine());
        System.out.println("Valor de la salida: " + exitSts);
    }

}