package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scan=new Scanner(System.in);
    static Llibreta llibreta;


    public static void main(String[] args) {

        //llibreta.cargaYaml();
        Index index=new Index();
        String comanda="index";

        while (true){
            if (comanda.equals("tanca")){
                // mostrar revers llibreta
                break;
            }else if (comanda.equals("index")){
                index.carrega();
                String hola=index.mostra();
                if (hola.equals("res")){
                    comanda=scan.nextLine();
                }else{
                    comanda=hola;
                }



            }else if (comanda.equals("crear")){
                comanda=llibreta.crearPag();
                //llibreta.guardaYaml();
            }else{
                // buscar una id amb aquesta comanda
                if (llibreta.buscaLaComanda(comanda)){
                    llibreta.mostra(comanda);

                    comanda= llibreta.opcions(comanda);
                }else{
                    System.out.println("Comanda erronea. Tornant a index...");
                    comanda="index";
                }


            }

            // mostrem l'index. podem anar directament a una pagina de l'index. podem avançar i tirar enrere pagines
            // mostra llista de tot el que hi ha a la llibreta  INDEX
            // comandes.carrega();
            // comandes.troba()



        }
        //llibreta.guardaYaml();
        System.out.println("Tancat!");

    }
}
