package org.example;

import org.example.restaurante.Pedido;
import org.example.restaurante.Restaurante;
import org.example.restaurante.TipoMovimento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // intensivao
//        ArrayList<Double> notas = new ArrayList<>();
//
//        Double nota1 = 10.0;
//        Double nota2 = 7.0;
//        Double nota3 = 8.0;
//        Double nota4 = 10.0;
//
//        notas.add(nota1);
//        notas.add(nota2);
//        notas.add(nota3);
//        notas.add(nota4);
//
//        System.out.println(notas);
//
//        Double totalNotas = 0.0;
//
//        for (Double nota : notas) {
//            totalNotas += nota;
//        }
//
//        Double media = totalNotas / notas.size();
//
//
//        System.out.println("Sua média final é:" + media);
//
//
//        Double grausF = 82.4;
//        Double celsius = convertFahrenheitToCelsius(grausF);
//
//        System.out.println("A temperatura em Fahrenheit: " + grausF + " transformada para celsius, ficará:" + celsius + "C");
//
//
//        System.out.println("Numero par: " + IsNumeroPar(new Scanner(System.in).nextInt()));

        List<String> itens1 = new ArrayList<>(Arrays.asList("Item A", "Item B", "Item C"));
        Pedido pedido1 = new Pedido(1, "João Silva", 150.75, itens1);

        List<String> itens2 = new ArrayList<>(Arrays.asList("Item X", "Item Y"));
        Pedido pedido2 = new Pedido(2, "Maria Oliveira", 99.99, itens2);

        var restaurante = new Restaurante(15);
        restaurante.adicionarPedido(pedido1);
        restaurante.adicionarPedido(pedido2);

        restaurante.registrarMovimentoCliente(3, TipoMovimento.CHEGADA);
        System.out.println(restaurante.getQuantidadeClientesPresentes());
        restaurante.registrarMovimentoCliente(14, TipoMovimento.CHEGADA);
        System.out.println(restaurante.getQuantidadeClientesPresentes());
        restaurante.registrarMovimentoCliente(12, TipoMovimento.CHEGADA);
        System.out.println(restaurante.getQuantidadeClientesPresentes());
        restaurante.registrarMovimentoCliente(10, TipoMovimento.PARTIDA);
        System.out.println(restaurante.getQuantidadeClientesPresentes());

        System.out.println(restaurante.getReceitaRestaurante());

        restaurante.removerPedido(2);

        System.out.println(restaurante.getReceitaRestaurante());

        List<Integer> pares = Arrays.asList(2, 4, 6, 8, 10);
        System.out.println(pares.stream().filter(numero -> numero < 6).toList());
    }

    public static Boolean IsNumeroPar(Integer numero) {
        return numero % 2 == 0;
    }

    public static Double convertFahrenheitToCelsius(Double fahrenheit) {
        return 5 * ((fahrenheit - 32) / 9);
    }

//    public static Integer numeroParImpar(){
//        Scanner numero = new Scanner(System.in);
//        num = numero.nextInt();
//        if(num %2 == 0){
//            System.out.println("numero par");
//        }else{
//            System.out.println("numero Ímpar");
//        }
//        return num;
//    }



}