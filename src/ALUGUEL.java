
public class ALUGUEL extends IMOVEL{

    private double valorAluguel;
    private int meses;



    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }



    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }



    public double calculaAluguel(int meses, double valoralguel) {


        double total = valoralguel * meses;

        return total;
    }

}
