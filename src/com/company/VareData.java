package com.company;

public class VareData implements java.io.Serializable{
    int antal;
    String vareName;
    double stykPris;



    public VareData(int antal, String vareName, double stykPris){
        this.antal = antal;
        this.vareName = vareName;
        this.stykPris = stykPris;
    }

        public int getAntal() {
            return antal;
        }

        public void setAntal(int antal) {
            this.antal = antal;
        }

        public String getVareName() {
            return vareName;
        }

        public void setVareName(String vareName) {
            this.vareName = vareName;
        }

        public double getStykPris() {
            return stykPris;
        }

        public void setStykPris(double stykPris) {
            this.stykPris = stykPris;
        }
}
