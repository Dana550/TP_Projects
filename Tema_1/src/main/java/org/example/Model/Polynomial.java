package org.example.Model;

import org.example.Model.Monomial;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Monomial> monomials;

    public Polynomial(TreeMap<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    public Polynomial() {
        this.monomials = new TreeMap<Integer, Monomial>() ;

    }

    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(TreeMap<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    public void addMonomToPolynom( Monomial monom){
        if(monom.getCoefficient()!=0) {
            if(monomials.containsKey(monom.getExponent())){
                double coefAux=monomials.get(monom.getExponent()).getCoefficient();
                monomials.remove(monom.getExponent());
                if(coefAux+monom.getCoefficient()!=0) {
                    monomials.put(monom.getExponent(), new Monomial(monom.getExponent(), coefAux + monom.getCoefficient()));
                }
            }
            else{
                monomials.put(monom.getExponent(), new Monomial(monom.getExponent(),  monom.getCoefficient()));
            }
        }

    }
    public void subMonomToPolynom( Monomial monom){
        if(monom.getCoefficient()!=0) {
            if(monomials.containsKey(monom.getExponent())){
                double coefAux=monomials.get(monom.getExponent()).getCoefficient();
                monomials.remove(monom.getExponent());
                if(coefAux-monom.getCoefficient()!=0) {
                    monomials.put(monom.getExponent(), new Monomial(monom.getExponent(), coefAux - monom.getCoefficient()));
                }
            }
            else{
                monomials.put(monom.getExponent(), new Monomial(monom.getExponent(),  -monom.getCoefficient()));
            }
        }
    }

    @Override
    public String toString() {
        String result="";
        for(Monomial monom:monomials.values()){
            result=monom.toString()+result;
        }
        return result;
    }
}
