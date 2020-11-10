package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner write = new Scanner(System.in);
        AddressBook x = new AddressBook();
        boolean activeMenu = true;
        int choice;
        String nombre, telefono;

        x.load();

        while(activeMenu){
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1) Ver la lista de contactos    2) Crear un contacto    3) Borrar un contacto    0) Salir");
            choice = write.nextInt();

            switch (choice){
                case 1:
                    x.list();
                    System.out.println();
                    break;
                case 2:
                    nombre = "";
                    telefono = "";

                    System.out.println("Ingresa el nombre del nuevo contacto");
                    nombre = write.next();
                    System.out.println("Ingresa el teléfono del nuevo contacto");
                    telefono = write.next();
                    x.create(nombre, telefono);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingresa el teléfono que deseas eliminar");
                    telefono = write.next();
                    x.delete(telefono);
                    System.out.println();
                    break;
                case 0:
                    x.save();
                    System.out.println("Datos guardados con éxito");
                    System.out.println("Adiós!");
                    activeMenu = false;
                    break;
                default:
                    System.out.println("Ingresa un valor correcto.");
                    System.out.println();
                    break;
            }
        }

    }
}
