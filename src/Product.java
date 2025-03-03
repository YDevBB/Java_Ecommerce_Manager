public class Product {
private String SKU;
private String Namn;
private String Beskrivning;
private String Pris;

public Product(String SKU, String Namn, String Beskrivning, String Pris){
    this.SKU = SKU;
    this.Namn = Namn;
    this.Beskrivning = Beskrivning;
    this.Pris = Pris;
}

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getNamn() {
        return Namn;
    }

    public void setNamn(String namn) {
        Namn = namn;
    }

    public String getBeskrivning() {
        return Beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        Beskrivning = beskrivning;
    }

    public String getPris() {
        return Pris;
    }

    public void setPris(String pris) {
        Pris = pris;
    }

    @Override
    public String toString() {
        return "SKU: " + SKU + "\n" + "Namn: " + Namn + "\n" + "Beskrivning: " + Beskrivning + "\n" +
                "Pris: " + Pris;
    }
}
