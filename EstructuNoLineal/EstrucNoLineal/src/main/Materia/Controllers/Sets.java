package main.Materia.Controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public Sets(){
        construirHashSet();
        construirLinkedHashSet();
        construirTreeSet();
        construirTreeSetConComparador();

    }

    //Construir y mostar un HashSet
    public void construirHashSet(){
        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //Duplico, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");
        System.out.println("HashSet: " + conjunto);

        //Eliminar un elemento
        conjunto.remove("Banana");
        System.out.println("HashSet despues de eliminar Banana " + conjunto);

        //Veridicar si un elmento existe
        boolean contieneNaranja = conjunto.contains("Naranja");
        System.out.println("Conjunto contiene naranja " + contieneNaranja);

        //Obtener el tamaño del conjunto
        int tamaño = conjunto.size();
        System.out.println("El tamño del conjunto es " + tamaño);

    }

    //Construir y mostrar un LinkedHashSet
    public void construirLinkedHashSet(){
        LinkedHashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //Duplico, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");
        System.out.println("LinkedHashSet: " + conjunto);

    }
    public void construirTreeSet(){
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //Duplico, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");
        System.out.println("TreeSet: " + conjunto);

    }
    public void construirTreeSetConComparador(){
        //Comparador personalizado que ordenalas cadenas en
        Comparator<String>comparadorOrdenInverso = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
            }
        };
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //Duplico, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");
        System.out.println("TreeSetComparador: " + conjunto);
        
    }

}
