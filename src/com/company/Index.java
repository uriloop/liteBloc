package com.company;

import java.util.ArrayList;

public class Index {
    String titol= "Index:";
    ArrayList<String> llista= new ArrayList<>();

    void carrega(){
        llista.clear();
        llista.add("index");
        llista.add("crear");
        Main.llibreta.cargaYaml();

        for (Pagina i: Main.llibreta.pagina){
            llista.add(i.id);
        }
        Main.llibreta.guardaYaml();
    }

    public String mostra() {
        String comand="res";
        System.out.println(titol);
        int alternador=0;
        int sum=0;

        ArrayList<String> index=new ArrayList<>();

        // si hi ha més de x linies, creem una segona pagina de index
        // haurem de fer una nova comanda anomenada index2 o index3   index passa a ser un arrayList
        StringBuilder a= new StringBuilder();

        for (String i: llista){
            a.append("-");
            a.append(i).append("    ");
            sum++;

                if (sum == llista.size()) {
                    index.add(a.toString());
                }else if (alternador<3) {
                    alternador++;
                }else {
                    index.add(a.toString());
                    a = new StringBuilder();
                    alternador =0;
                }


        }
        String comanda="";
        int liniesXindex=2;
        if (index.size()>liniesXindex){
            int numIndexs=index.size()/liniesXindex;
            int zeroUnDos=0;
            for (int j = 0; j < index.size();) {

                System.out.println(index.get(j));
                if(j+1<index.size()){
                    System.out.println(index.get(j+1));
                }
                if (j>1&&j<(index.size())-1){
                    System.out.println("-less    -more");
                    comanda=Main.scan.nextLine();
                    zeroUnDos=0;
                }else if (j<2){
                    System.out.println("-more");
                    comanda=Main.scan.nextLine();
                    zeroUnDos=1;
                }else{
                    System.out.println("-less");
                    comanda=Main.scan.nextLine();
                    zeroUnDos=2;
                }


                if (comanda.equals("more")&&zeroUnDos<2){
                    j+=2;
                }else if (comanda.equals("less")&&zeroUnDos!=1){
                    j-=2;
                }else{
                    comand=comanda;
                    break;
                }
            }


        }else{
            for (String f: index){
                System.out.println(f);
            }
        }


        return comand;
    }


}
