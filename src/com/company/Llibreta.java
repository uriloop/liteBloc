package com.company;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Llibreta {

    List<Pagina> pagina;

    boolean buscaLaComanda(String comanda){
        for (Pagina i: Main.llibreta.pagina){
            if (i.id.equals(comanda)){
                return true;
            }
        }
        return false;
    }

    public String crearPag() {
        String siono;
        Pagina crear= new Pagina();
        while(true) {
            System.out.println("escriu un nom");
            crear.nom = Main.scan.nextLine();
            System.out.println("escriu un cognom");
            crear.cognom = Main.scan.nextLine();
            // comproba si estan repetits
            boolean torna=false;
            for (Pagina i : Main.llibreta.pagina) {
                if (i.id.equals(crear.nom + " " + crear.cognom)) {
                    System.out.println("Aquest nom ja existeix! Torna a començar");
                    torna=true;
                }
            }
            if (!torna){
                System.out.println("Vols desar aquest nom i cognom? "+crear.nom+" "+crear.cognom);
                System.out.println("si / no");
                siono=Main.scan.nextLine();
                if (siono.equals("si")){
                    break;
                }
            }
        }
            System.out.println("Escriu el contingut");
            crear.contingut=Main.scan.nextLine();
            crear.id=crear.nom+" "+crear.cognom;



        Main.llibreta.pagina.add(crear);
        return crear.id;
    }

    public void mostra(String id) {
        for (Pagina i : Main.llibreta.pagina){
            if (i.id.equals(id)){
                System.out.println("Nom i cognom: "+i.nom+" "+i.cognom+" ");
                System.out.println("Contingut: "+i.contingut);
            }
        }
    }

    public String opcions(String comanda) {
        System.out.println("-index       -editar        -eliminar");
        String scaner=Main.scan.nextLine();
        if (scaner.equals("index")){
            return "index";
        }else if (scaner.equals("eliminar")){
            System.out.println("estas segur?     si / no");
            scaner=Main.scan.nextLine();
            if (scaner.equals("si")){
                int index=0;
                for (Pagina i: Main.llibreta.pagina){
                    if (i.id.equals(comanda)){
                        index=pagina.indexOf(i);
                    }
                }
                Main.llibreta.pagina.remove(index);
                System.out.println("Pagina arrancada!");
                return "index";
            }else if (scaner.equals("no")){
                System.out.println("No s'ha eliminat!");
                return  comanda;
            }else{
                System.out.println("Comanda erronea. Tornant a index...");
                return "index";
            }
        }else if (scaner.equals("editar")){
            System.out.println("estas segur?     si / no");
            scaner=Main.scan.nextLine();
            if (scaner.equals("si")){
                int index=0;
                for (Pagina i: Main.llibreta.pagina){
                    if (i.id.equals(comanda)){
                        index=pagina.indexOf(i);
                    }
                }
                Main.llibreta.pagina.remove(index);

                String id = crearPag();
                return id;
            }else {
                System.out.println("No s'ha editat!");
                return comanda;
            }
        }else{

                System.out.println("Comanda erronea");
                return comanda;


        }
    }

    void cargaYaml(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Main.llibreta = mapper.readValue(new File("com.company/pagines.yaml"), Llibreta.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void guardaYaml()  {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            objectMapper.writeValue(new File("com.company/pagines.yaml"), Main.llibreta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
