package enums;

public enum TipoCarro {


    POPULAR(1),
    SEDAN(2),
    SUV(3),
    CAMINHONETE(4);

    private int tipoCarro;

    TipoCarro(int tipoCarro){
        this.tipoCarro = tipoCarro;
    }

    public int getTipoCarro() {
        return tipoCarro;
    }

}
