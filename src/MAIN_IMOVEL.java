


import java.io.IOException;
import java.util.*;







public class MAIN_IMOVEL {

    public static void main(String[] args) throws InterruptedException, IOException {


        Scanner leia = new Scanner (System.in);



        //resultado final  (nome cliente, cpf, telefone, tipo, bairro, valor(metodo), meses) = aluguel
        //                  (nome cliente, cpf, telefone, tipo , bairro, valor) = Venda

        CLIENTE c = new CLIENTE();
        ALUGUEL[] aluguelvet = new ALUGUEL[24];     //tipó, valor, meses, bairro         0-11(casa) 12-23(ap)
        VENDA[] vendavet = new VENDA[24];           //                                     0-11(casa) 12-23(ap)

        List<CLIENTE> listaCLIENTE = new ArrayList<>();
        List<ALUGUEL> listaALUGUEL = new ArrayList<>();
        List<VENDA> listaVENDA = new ArrayList<>();

        VENDA [][] vendaMatrix = new VENDA[100][100];
        ALUGUEL[][] aluguelMatrix = new ALUGUEL[100][100];
        //double casa [] = new double [12];
        //double ap[ ] = new double [12];
        //double aluguels;
        //double vendas;
        //double total=0;

        //vetor compras/aluguel  [0][0]

        //cadastro de imovel  / exibir imovel

        int contV=0;
        int contA = 0;
        String pesquisa;

        int meses;
        String controle = null;
        int op2 = 0;
        byte op;
        String opA ;
        byte op1;

        int segundosDeLatencia = 2;

        String op30;






        String op100;



        do{
            limpa();

            System.out.println(" \n----------------------------------------------\n" +
                    " SEJA BEM VINDO AO SITE DE CADASTRAMENTO\n" +
                    "       DE IMÓVEIS DE BELO HORIZONTE \n" +
                    "----------------------------------------------\n"
                    + "\nCADASTRAR: \n"
                    + "A) - IMOVEL PARA ALUGAR \n"
                    + "B) - IMOVEL PARA VENDER\n"
                    + "0) - AVANÇAR");
            op100 = leia.next().toUpperCase();



 /*   while (!leia.hasNextInt()) {
        System.out.println("\nENTRADA INVÁLIDA! ");

        System.out.println(" \n----------------------------------------------\n" +
                " SEJA BEM VINDO AO CADASTRAMENTO\n" +
                "       DE IMÓVEIS DE BELO HORIZONTE \n" +
                "----------------------------------------------\n"
                + "\nCADASTRAR : \n"
                + "1) - IMOVEL PARA ALUGAR \n"
                + "2) - IMOVEL PARA VENDER");
        leia.next(); // Descarta o valor iInválido digitado pelo usuário
    }
*/

            if(!op100.equalsIgnoreCase("A") && !op100.equalsIgnoreCase("B") && !op100.equalsIgnoreCase("0")) {
                System.out.println("\nENTRADA INVÁLIDA");
                Thread.sleep(segundosDeLatencia * 1000);
            }




            switch (op100) {


                case "A" :





                    ALUGUEL novoaluguel = new ALUGUEL();










                    String bairro;
                    do {
                        limpa();

                        System.out.println("\nDIGITE O BAIRRO QUE DESEJA CADASTRAR O IMOVEL ALUGADO : \n"
                                + " -) SERRA \n"
                                + " -) MANGABEIRAS \n"
                                + " -) SAVASSI \n"
                                + " -) CRUZEIRO");
                        bairro = leia.next();   //[0][0]


                        if(!bairro.equalsIgnoreCase("SERRA") &&!bairro.equalsIgnoreCase("MANGABEIRAS")
                                && !bairro.equalsIgnoreCase("SAVASSI") && !bairro.equalsIgnoreCase("CRUZEIRO")){

                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                        }


                    }while(!bairro.equalsIgnoreCase("SERRA") &&!bairro.equalsIgnoreCase("MANGABEIRAS")
                            && !bairro.equalsIgnoreCase("SAVASSI") && !bairro.equalsIgnoreCase("CRUZEIRO"));

                    novoaluguel.setBairro(bairro);






                    if(novoaluguel.getBairro().equalsIgnoreCase("SERRA")) {



                        int num;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);

                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        num = leia.nextInt();
                        novoaluguel.setNum(num);



                        //[0][1]
                        String tipo;
                        do{


                            System.out.println("\nDESEJA CADASTRAR O ALUGUEL PARA QUAL TIPO DE IMOVEL :"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipo = leia.next();
                            // [0] [1] = tipo
                            if(!tipo.equalsIgnoreCase("CASA") && !tipo.equalsIgnoreCase("APARTAMENTO")){

                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);

                            }
                        }while(!tipo.equalsIgnoreCase("CASA") && !tipo.equalsIgnoreCase("APARTAMENTO"));

                        novoaluguel.setTipo(tipo);

                        double valor;

                        if(novoaluguel.getTipo().equalsIgnoreCase("casa")) {

                            //j++;


                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);

                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");
                                leia.next();
                            }
                            valor = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor);
                            //[0][2] = valor


                        }

                        //	System.out.println(i + " " + j );



                        if(novoaluguel.getTipo().equalsIgnoreCase("APARTAMENTO")) {
                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valor = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor);


                        }

                        listaALUGUEL.add(novoaluguel);

                    }

                    else if(novoaluguel.getBairro().equalsIgnoreCase("MANGABEIRAS")) {
                        int num1;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        num1 = leia.nextInt();
                        novoaluguel.setNum(num1);

                        String tipo1;
                        do{
                            System.out.println("\nDESEJA CADASTRAR O ALUGUEL PARA QUAL TIPO DE IMOVEL : \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipo1 = leia.next();
                            // [0] [1] = tipo
                            if(!tipo1.equalsIgnoreCase("CASA") && !tipo1.equalsIgnoreCase("APARTAMENTO")){

                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                            }
                        }while(!tipo1.equalsIgnoreCase("CASA") && !tipo1.equalsIgnoreCase("APARTAMENTO") );

                        novoaluguel.setTipo(tipo1);



                        double valor1;
                        if(novoaluguel.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);

                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");
                                leia.next();
                            }
                            valor1 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor1);

                        }

                        if(novoaluguel.getTipo().equalsIgnoreCase("APARTAMENTO")) {
                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valor1 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor1);


                        }

                        listaALUGUEL.add(novoaluguel);

                    }





                    else if(novoaluguel.getBairro().equalsIgnoreCase("CRUZEIRO")) {
                        int num2;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        num2 = leia.nextInt();
                        novoaluguel.setNum(num2);
                        String tipo2;
                        do{
                            System.out.println("\nDESEJA CADASTRAR O ALUGUEL PARA QUAL TIPO DE IMOVEL : \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipo2 = leia.next();
                            // [0] [1] = tipo
                            if(!tipo2.equalsIgnoreCase("CASA") && !tipo2.equalsIgnoreCase("APARTAMENTO")){

                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                            }
                        }while(!tipo2.equalsIgnoreCase("CASA") && !tipo2.equalsIgnoreCase("APARTAMENTO") );

                        novoaluguel.setTipo(tipo2);


                        double valor2;
                        if(novoaluguel.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");

                            while(!leia.hasNextInt()){
                                System.out.println("\n");
                                Thread.sleep(segundosDeLatencia * 1000);

                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");
                                leia.next();
                            }
                            valor2 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor2);

                        }

                        if(novoaluguel.getTipo().equalsIgnoreCase("APARTAMENTO")) {


                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valor2 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor2);

                        }

                        listaALUGUEL.add(novoaluguel);

                    }
                    else if(novoaluguel.getBairro().equalsIgnoreCase("SAVASSI")) {
                        int num3;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        num3 = leia.nextInt();
                        novoaluguel.setNum(num3);
                        String tipo4;
                        do{
                            System.out.println("\nDESEJA CADASTRAR O ALUGUEL PARA QUAL TIPO DE IMOVEL : \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipo4 = leia.next();
                            // [0] [1] = tipo
                            if(!tipo4.equalsIgnoreCase("CASA") && !tipo4.equalsIgnoreCase("APARTAMENTO")){

                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                            }
                        }while(!tipo4.equalsIgnoreCase("CASA") && !tipo4.equalsIgnoreCase("APARTAMENTO") );


                        novoaluguel.setTipo(tipo4);

                        double valor4;

                        if(novoaluguel.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSA CASA :");
                                leia.next();
                            }
                            valor4 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor4);
                        }

                        if(novoaluguel.getTipo().equalsIgnoreCase("APARTAMENTO")) {
                            System.out.println("\nDIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DO ALUGUEL PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valor4 = leia.nextDouble();
                            novoaluguel.setValorAluguel(valor4);


                        }



                        listaALUGUEL.add(novoaluguel);




                    }


                    System.out.println("\n--------------------------------------------------------------------\n"
                            + "   	       CADASTRO DO IMOVEL REALIZADO COM SUCESSO!\n"
                            + "--------------------------------------------------------------------\n");

                    Thread.sleep(segundosDeLatencia * 1000);




                    //for i
                    break;


                case "B":


                    VENDA novovenda = new VENDA();



                    String bairrov;
                    do{
                        limpa();

                        System.out.println("\nDIGITE O BAIRRO QUE DESEJA CADASTRAR O IMOVEL PARA VENDA \n"
                                + " - SERRA \n"
                                + " - MANGABEIRAS \n"
                                + " - SAVASSI \n"
                                + " - CRUZEIRO");
                        bairrov = leia.next();

                        if(!bairrov.equalsIgnoreCase("SERRA") && !bairrov.equalsIgnoreCase("MANGABEIRAS")
                                && !bairrov.equalsIgnoreCase("SAVASSI") && !bairrov.equalsIgnoreCase("CRUZEIRO")){

                            System.out.println("\nENTRADA INVÁLIDA");

                            Thread.sleep(segundosDeLatencia * 1000);

                        }



                    }while(!bairrov.equalsIgnoreCase("SERRA") && !bairrov.equalsIgnoreCase("MANGABEIRAS")
                            && !bairrov.equalsIgnoreCase("SAVASSI") && !bairrov.equalsIgnoreCase("CRUZEIRO"));


                    novovenda.setBairro(bairrov);


                    if(novovenda.getBairro().equalsIgnoreCase("SERRA")) {




                        int numv;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        numv = leia.nextInt();
                        novovenda.setNum(numv);



                        String tipov;
                        do {


                            System.out.println("\nDESEJA CADASTRAR A VENDA PARA QUAL TIPO DE IMOVEL \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipov = leia.next();


                            if(!tipov.equalsIgnoreCase("casa") && !tipov.equalsIgnoreCase("apartamento")){
                                System.out.println("\nENTRADA INVÁLIDA!");
                            }

                        }while(!tipov.equalsIgnoreCase("casa") && !tipov.equalsIgnoreCase("apartamento"));

                        novovenda.setTipo(tipov);


                        double valorv;

                        if(novovenda.getTipo().equalsIgnoreCase("casa")) {



                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSA CASA");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSA CASA");
                                leia.next();


                            }
                            valorv = leia.nextDouble();
                            novovenda.setValorCompra(valorv);

                        }

                        if(novovenda.getTipo().equalsIgnoreCase("APARTAMENTO")) {

                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");

                            while(!leia.hasNextInt()) {
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valorv = leia.nextDouble();
                            novovenda.setValorCompra(valorv);


                        }
                        listaVENDA.add(novovenda);
                    }

                    else if(novovenda.getBairro().equalsIgnoreCase("MANGABEIRAS")) {

                        int numv2;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        numv2 = leia.nextInt();
                        novovenda.setNum(numv2);


                        String tipov2;

                        do{


                            System.out.println("\nDESEJA CADASTRAR A VENDA PARA QUAL TIPO DE IMOVEL \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipov2 = leia.next();

                            if(!tipov2.equalsIgnoreCase("CASA") &&!tipov2.equalsIgnoreCase("APARTAMENTO")){
                                System.out.println("\nENTRADA INVÁLIDA!");
                            }
                        }while(!tipov2.equalsIgnoreCase("CASA") &&!tipov2.equalsIgnoreCase("APARTAMENTO"));

                        novovenda.setTipo(tipov2);


                        double valorv2;
                        if(novovenda.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSA CASA");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSA CASA");
                                leia.next();


                            }
                            valorv2 = leia.nextDouble();
                            novovenda.setValorCompra(valorv2);

                        }

                        if(novovenda.getTipo().equalsIgnoreCase("APARTAMENTO")) {

                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");

                            while(!leia.hasNextInt()) {
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valorv2 = leia.nextDouble();
                            novovenda.setValorCompra(valorv2);


                        }
                        listaVENDA.add(novovenda);
                    }
                    else if(novovenda.getBairro().equalsIgnoreCase("CRUZEIRO")) {
                        int numv3;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        numv3 = leia.nextInt();
                        novovenda.setNum(numv3);

                        String tipov3;

                        do{


                            System.out.println("\nDESEJA CADASTRAR A VENDA PARA QUAL TIPO DE IMOVEL \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipov3 = leia.next();

                            if(!tipov3.equalsIgnoreCase("CASA") &&!tipov3.equalsIgnoreCase("APARTAMENTO")){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                            }
                        }while(!tipov3.equalsIgnoreCase("CASA") &&!tipov3.equalsIgnoreCase("APARTAMENTO"));

                        novovenda.setTipo(tipov3);

                        double valorv4;
                        if(novovenda.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSA CASA");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSA CASA");
                                leia.next();


                            }
                            valorv4 = leia.nextDouble();
                            novovenda.setValorCompra(valorv4);

                        }

                        if(novovenda.getTipo().equalsIgnoreCase("APARTAMENTO")) {

                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");

                            while(!leia.hasNextInt()) {
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valorv4 = leia.nextDouble();
                            novovenda.setValorCompra(valorv4);
                        }
                        listaVENDA.add(novovenda);
                    }
                    else if(novovenda.getBairro().equalsIgnoreCase("SAVASSI")) {

                        int numv4;





                        System.out.println("\nDIGITE O NUMERO DO IMOVEL: ");
                        while(!leia.hasNextInt()) {
                            System.out.println("\nENTRADA INVÁLIDA!");
                            Thread.sleep(segundosDeLatencia * 1000);
                            System.out.println("DIGITE O NUMERO DO IMOVEL: ");
                            leia.next();
                        }

                        numv4 = leia.nextInt();
                        novovenda.setNum(numv4);
                        String tipov5;
                        do {


                            System.out.println("\nDESEJA CADASTRAR A VENDA PARA QUAL TIPO DE IMOVEL \n"
                                    + " - CASA \n"
                                    + " - APARTAMENTO");
                            tipov5 = leia.next();


                            if(!tipov5.equalsIgnoreCase("casa") && !tipov5.equalsIgnoreCase("apartamento")){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                            }

                        }while(!tipov5.equalsIgnoreCase("casa") && !tipov5.equalsIgnoreCase("apartamento"));

                        novovenda.setTipo(tipov5);

                        double valorv6;
                        if(novovenda.getTipo().equalsIgnoreCase("CASA")) {


                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSA CASA");

                            while(!leia.hasNextInt()){
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSA CASA");
                                leia.next();


                            }
                            valorv6 = leia.nextDouble();
                            novovenda.setValorCompra(valorv6);

                        }

                        if(novovenda.getTipo().equalsIgnoreCase("APARTAMENTO")) {

                            System.out.println("\nDIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");

                            while(!leia.hasNextInt()) {
                                System.out.println("\nENTRADA INVÁLIDA!");
                                Thread.sleep(segundosDeLatencia * 1000);
                                System.out.println("DIGITE O VALOR DA VENDA PARA ESSE APARTAMENTO");
                                leia.next();
                            }
                            valorv6 = leia.nextDouble();
                            novovenda.setValorCompra(valorv6);

                        }




                        listaVENDA.add(novovenda);


                    }

                    System.out.println("\n--------------------------------------------------------------------\n"
                            + "   	       CADASTRO DO IMOVEL REALIZADO COM SUCESSO!\n"
                            + "--------------------------------------------------------------------\n");

                    Thread.sleep(segundosDeLatencia * 1000);
                    //for i			 //for j
            }





        }while(!op100.equalsIgnoreCase("0"));




        do {
            limpa();
            System.out.println("\nOLA SEJA BEM-VINDO A EMPRESA '1 2 3 IMOVEIS', A FAVORITA NO  \nMERCADO QUANDO SE TRATA DE VENDA && ALUGUEL DE IMOVEIS! \n");

            System.out.println("A) - LOGIN\n"
                    + "B) - CADASTRAR\n"
                    + "0) - SAIR");
            op30 = leia.next();


            if(op30.equalsIgnoreCase("A")) {
                limpa();
                String cpfAut;
                String senhaV2;
                boolean encontrou2 = false;

                System.out.println("\nDIGITE OS CAMPOS ABAIXO PARA ENTRAR EM SEU PERFIL\n");

                System.out.println("CPF: ");
                cpfAut = leia.next();

                System.out.println("\nSENHA: ");
                senhaV2 = leia.next();

                for (CLIENTE cliente : listaCLIENTE) {
                    if(cliente.getCpf().equalsIgnoreCase(cpfAut) && cliente.getSenha().equalsIgnoreCase(senhaV2)) {
                        encontrou2 = true;
                        limpa();




                        System.out.println("\nSEJA BEM-VINDO " + cliente.getNome());
                        System.out.println("DESEJA UM IMOVEL PARA: \n"
                                + "1 - ALUGAR \n"
                                + "2 - COMPRAR");
                        while(!leia.hasNextInt()){
                            System.out.println("\nENTRADA INVÁLIDA");
                            Thread.sleep(segundosDeLatencia * 1000);
                            limpa();
                            System.out.println("DESEJA UM IMOVEL PARA \n"
                                    + "1 - ALUGAR \n"
                                    + "2 - COMPRAR");
                            leia.next();
                        }

                        op = leia.nextByte();

                        if(op == 1) {

                            do{
                                limpa();
                                System.out.println("\nDIGITE A QUANTIDADE DE MESES QUE PERMANECERA NO IMOVEL:");
                                while(!leia.hasNextInt()) {
                                    System.out.println("\nENTRADA INVÁLIDA!");
                                    Thread.sleep(segundosDeLatencia * 1000);
                                    System.out.println("DIGITE A QUANTIDADE DE MESES QUE PERMANECERA NO IMOVEL:");
                                    leia.next();
                                }

                                meses = leia.nextInt();

                                do {
                                    System.out.println("\nDIGITE O BAIRRO QUE DESEJA PROCURAR UM IMOVEL PARA ALUGUEL \n"
                                            + " - SERRA \n"
                                            + " - MANGABEIRAS \n"
                                            + " - SAVASSI \n"
                                            + " - CRUZEIRO ");
                                    pesquisa = leia.next();

                                    if(!pesquisa.equalsIgnoreCase("SERRA") && !pesquisa.equalsIgnoreCase("MANGABEIRAS")
                                            &&	!pesquisa.equalsIgnoreCase("SAVASSI") && !pesquisa.equalsIgnoreCase("CRUZEIRO")) {

                                        System.out.println("\nENTRADA INVÁLIDA!");
                                        Thread.sleep(segundosDeLatencia * 1000);
                                    }
                                    //if(pesquisa.equalsIgnoreCase("SERRA") || )

                                }while(!pesquisa.equalsIgnoreCase("SERRA") && !pesquisa.equalsIgnoreCase("MANGABEIRAS")
                                        &&	!pesquisa.equalsIgnoreCase("SAVASSI") && !pesquisa.equalsIgnoreCase("CRUZEIRO"));

                                limpa();
                                boolean achouAL=false;
                                System.out.println("\n================================\n"
                                        + "    IMOVEIS DISPONIVEIS\n"
                                        + "================================\n");
                                for (ALUGUEL alg : listaALUGUEL) {





                                    if(alg.getBairro().equalsIgnoreCase(pesquisa)) {

                                        achouAL = true;


                                        System.out.println("\nNUMERO DO IMOVEL: " + (alg.getNum()));


                                        System.out.println("BAIRRO: " + alg.getBairro().toUpperCase() + "\n" +
                                                "TIPO DO IMOVEL: " + alg.getTipo().toUpperCase() + "\n" +
                                                "VALOR DO IMOVEL NA SOMA TOTAL DE MESES: " + (alg.getValorAluguel() * meses) + "$ EM "+ meses+" MESES");
                                        System.out.println("------------------------------------------------------");

                                    }









                                }

                                if(!achouAL) {

                                    System.out.println("\nNÃO FOI ACHADO IMOVEL NESSE BAIRRO");
                                    Thread.sleep(segundosDeLatencia * 1000);
                                }
                                do {


                                    System.out.println("\nDESEJA PROCURAR IMOVEL EM OUTRO BAIRRO PARA ALUGAR? ");
                                    controle = leia.next();


                                    if(!controle.equalsIgnoreCase("SIM") && !controle.equalsIgnoreCase("NAO")) {
                                        System.out.println("\nENTRADA INVÁLIDA, DIGITE (SIM) OU (NAO)");
                                        Thread.sleep(segundosDeLatencia * 1000);
                                    }

                                }while(!controle.equalsIgnoreCase("SIM") && !controle.equalsIgnoreCase("NAO"));

                            }while(!controle.equalsIgnoreCase("NAO"));


                            boolean achou10=false;


                            do {





                                System.out.println("QUAL IMOVEL O SR " + cliente.getNome()  + " DESEJA (DIGITE SEU NUMERO): ");

                                while(!leia.hasNextInt()) {
                                    System.out.println("\nENTRADA INVÁLIDA!");
                                    Thread.sleep(segundosDeLatencia * 1000);
                                    System.out.println("QUAL IMOVEL O SR " + cliente.getNome()  + " DESEJA (DIGITE SEU NUMERO): ");
                                    leia.next();
                                }
                                op2 = leia.nextInt();




                                for (ALUGUEL alg : listaALUGUEL) {

                                    if(op2 == alg.getNum()) {
                                        achou10 = true;
                                        limpa();
                                        System.out.println("\nCOMPRA REALIZADA COM SUCESSO! \n"
                                                + "OBRIGADO SR " + cliente.getNome() + " , O SENHOR ACABAR DE FAZER UM OTIMO NEGOCIO \nALUGANDO UM IMOVEL COM A GENTE \n"
                                                + "SIGA O RELATORIO ABAIXO COM AS INFORMARÇÕES DO IMOVEL \n \n"
                                                + "BAIRRO: " + alg.getBairro().toUpperCase() + "\n"
                                                + "TIPO DO IMOVEL : " + alg.getTipo().toUpperCase() + "\n"
                                                + "VALOR DO ALUGUEL NO MES : " + alg.getValorAluguel() + "\n"
                                                + "CPF DO CLIENTE: " + cliente.getCpf() +"\n \n"
                                                + "OBRIGADO MAIS UMA VEZ PELA CONFIANÇA, AGUARDAMOS VOCE PARA \nUMA PROXIMA COMPRA!");
                                    }
                                }

                                if(!achou10) {
                                    System.out.println("\nNUMERO INVÁLIDO, DIGITE NOVAMENTE!");
                                    Thread.sleep(segundosDeLatencia * 1000);
                                }

                            }while(!achou10);

                            System.exit(0);

                        }

                        if(op == 2) {

                            String controle2;

                            do {


                                do {
                                    limpa();
                                    System.out.println("\nDIGITE O BAIRRO QUE DESEJA PROCURAR UM IMOVEL PARA COMPRA \n"
                                            + " - SERRA \n"
                                            + " - MANGABEIRAS \n"
                                            + " - SAVASSI \n"
                                            + " - CRUZEIRO ");
                                    pesquisa = leia.next();

                                    if (!pesquisa.equalsIgnoreCase("SERRA") && !pesquisa.equalsIgnoreCase("MANGABEIRAS")
                                            && !pesquisa.equalsIgnoreCase("SAVASSI") && !pesquisa.equalsIgnoreCase("CRUZEIRO")) {

                                        System.out.println("\nENTRADA INVÁLIDA!");
                                    }
                                    //if(pesquisa.equalsIgnoreCase("SERRA") || )

                                } while (!pesquisa.equalsIgnoreCase("SERRA") && !pesquisa.equalsIgnoreCase("MANGABEIRAS")
                                        && !pesquisa.equalsIgnoreCase("SAVASSI") && !pesquisa.equalsIgnoreCase("CRUZEIRO"));

                                //if(pesquisa.equalsIgnoreCase("SERRA") || )

                                limpa();
                                boolean achou = false;
                                System.out.println("\n================================\n"
                                        + "   IMOVEIS DISPONIVEIS\n"
                                        + "================================\n");
                                for (VENDA vend : listaVENDA) {


                                    if (vend.getBairro().equalsIgnoreCase(pesquisa)) {
                                        achou = true;



                                        System.out.println("\nNUMERO DO IMOVEL: " + (vend.getNum()));


                                        System.out.println("BAIRRO: " + vend.getBairro().toUpperCase() + "\n" +
                                                "TIPO DO IMOVEL: " + vend.getTipo().toUpperCase() + "\n" +
                                                "VALOR DO IMOVEL: " + vend.getValorCompra() + "$");
                                        System.out.println("------------------------------------------------------");

                                    }


                                }




                                if (!achou) {
                                    System.out.println("\nNÃO FOI ACHADO IMOVEL NESSE BAIRRO");
                                }









                                do {


                                    System.out.println("\nDESEJA PROCURAR IMOVEL EM OUTRO BAIRRO PARA VENDER");
                                    controle2= leia.next();


                                    if(!controle2.equalsIgnoreCase("SIM") && !controle2.equalsIgnoreCase("NAO")) {
                                        System.out.println("\nENTRADA INVÁLIDA, DIGITE (SIM) OU (NAO)");
                                        Thread.sleep(segundosDeLatencia * 1000);
                                    }

                                }while(!controle2.equalsIgnoreCase("SIM") && !controle2.equalsIgnoreCase("NAO"));
                            }while(!controle2.equalsIgnoreCase("nao"));



                            boolean achou3 = false;
                            int op20;
                            do {

                                System.out.println("QUAL IMOVEL O SR " + cliente.getNome().toUpperCase()  + " DESEJA (DIGITE SEU NUMERO): ");

                                while(!leia.hasNextInt()) {
                                    System.out.println("ENTRADA INVÁLIDA!");
                                    System.out.println("QUAL IMOVEL O SR " + cliente.getNome().toUpperCase()  + " DESEJA (DIGITE SEU NUMERO): ");
                                    leia.next();

                                }

                                op20 = leia.nextInt();






                                for (VENDA vend : listaVENDA) {

                                    if(op20 == vend.getNum()) {

                                        achou3 = true;
                                        limpa();
                                        System.out.println("================================"
                                                + "\nCOMPRA REALIZADA COM SUCESSO! \n"
                                                + "================================\n"
                                                + "OBRIGADO SR " + cliente.getNome().toUpperCase() + " , O SENHOR ACABAR DE FAZER\nUM OTIMO NEGOCIO COMPRANDO UM IMOVEL COM A NOSSA EMPRESA \n"
                                                + "\nSIGA O RELATORIO ABAIXO COM AS INFORMARÇÕES DO IMOVEL \n "
                                                + "_____________________________________________________\n"
                                                + "\nBAIRRO: " + vend.getBairro().toUpperCase() + "\n"
                                                + "TIPO DO IMOVEL: " + vend.getTipo().toUpperCase() + "\n"
                                                + "VALOR DA COMPRA DO IMOVEL: " + vend.getValorCompra() + "\n"
                                                + "CPF DO CLIENTE: " + cliente.getCpf() +"\n "
                                                + "_____________________________________________________\n"
                                                + "OBRIGADO MAIS UMA VEZ PELA CONFIANÇA, AGUARDAMOS VOCE PARA\nUMA PROXIMA COMPRA!");
                                        Thread.sleep(segundosDeLatencia * 5000);
                                    }
                                }
                                if(!achou3) {
                                    System.out.println("NUMERO INVÁLIDO, DIGITE NOVAMENTE!");
                                }

                            }while(!achou3);
                            System.exit(0);


                        }

                    }

                }







                if(!encontrou2) {

                    System.out.println("\nALGUM CAMPO FOI DIGITADO INCORRETAMENTE, TENTE NOVAMENTE!\n");
                    Thread.sleep(segundosDeLatencia * 1000);
                }
            }

            else if(op30.equalsIgnoreCase("B")) {
                limpa();
                System.out.println("\n"
                        + "================================================\n"
                        + "           MENU CADASTRO DE CLIENTE\n"
                        + "PREENCHA CORRETAMENTE AS INFORMAÇÕES A SEGUIR!\n"
                        + "================================================\n");
                CLIENTE novocliente = new CLIENTE();
                String nome4;
                do {


                    System.out.println("DIGITE SEU NOME:");
                    nome4 = leia.next();
                    if(!nome4.matches("^[A-Za-z]+$")) {
                        System.out.println("\nNOME INVÁLIDO, DIGITE APENAS LETRAS!");
                        Thread.sleep(segundosDeLatencia * 1000);

                    }


                }while(!nome4.matches("^[A-Za-z]+$"));



                novocliente.setNome(nome4.toUpperCase());
                System.out.println("\n");


                String senha;
                System.out.println("DIGITE SUA SENHA:");
                senha= leia.next();
                novocliente.setSenha(senha);

                System.out.println("\n");

                String cpf;
                System.out.println("DIGITE SEU CPF:");

                boolean cpfRepetido;
                //do {
                do {
                    cpf = leia.next();
                    cpfRepetido = false;

                    for (CLIENTE cliente : listaCLIENTE) {
                        if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                            cpfRepetido = true;
                            break;
                        }
                    }

                    if (cpfRepetido) {
                        System.out.println("\nCPF JÁ EXISTENTE!");
                        System.out.println("\nDIGITE NOVAMENTE O CPF CORRETAMENTE");
                        Thread.sleep(segundosDeLatencia * 1000);

                    }
                } while (cpfRepetido);

                novocliente.setCpf(cpf);




                listaCLIENTE.add(novocliente);

                limpa();
                System.out.println("--------------------------------------------------------------------\n"
                        + "   	             CADASTRO REALIZADO COM SUCESSO!\n"
                        + "		          SEJA BEM-VINDO " + novocliente.getNome().toUpperCase() +" \n"
                        + "           AO SITE DE ALUGUEL && VENDA DE IMOVEIS\n"
                        + "--------------------------------------------------------------------\n");
                Thread.sleep(segundosDeLatencia * 1000);


            }

        }while( !op30.equalsIgnoreCase("0"));


































    }
    public static void limpa() throws InterruptedException, IOException {
        new ProcessBuilder ("cmd", "/c",  "cls" ).inheritIO().start().waitFor();

    }
}











