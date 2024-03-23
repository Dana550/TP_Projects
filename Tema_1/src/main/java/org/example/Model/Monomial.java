package org.example.Model;

public class Monomial {
    private int exponent;
    private double coefficient;

    public Monomial(int exponent, double coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public void addMonom(Monomial monom){

        if(monom.exponent==this.exponent){
            this.coefficient=this.coefficient+monom.coefficient;
        }
    }
    public void subMonom(Monomial monom){

        if(monom.exponent==this.exponent){
            this.coefficient=this.coefficient-monom.coefficient;
        }
    }
    public void mulMonom(Monomial monom){
        if(monom.exponent==this.exponent){
            this.coefficient=this.coefficient*monom.coefficient;
            this.exponent=this.exponent+monom.exponent;
        }
    }

    @Override
    public String toString() {
        if(coefficient>=0)
        {
            return "+"+coefficient+"x^"+exponent;
        }
        return coefficient+"x^"+exponent;
    }
}
