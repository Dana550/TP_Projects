package org.example.Model;

public class Operations {
    public static Polynomial add(Polynomial pol1, Polynomial pol2){
        Polynomial addResult=new Polynomial();
        addResult=pol1;
        for(Monomial m1: pol2.getMonomials().values()){
            addResult.addMonomToPolynom(m1);
        }
        return addResult;
    }
    public static Polynomial sub(Polynomial pol1, Polynomial pol2){
        Polynomial subResult=new Polynomial();
        subResult=pol1;
        for(Monomial m1: pol2.getMonomials().values()){
            subResult.subMonomToPolynom(m1);
        }
        return subResult;
    }
    public static Polynomial mul(Polynomial pol1, Polynomial pol2){
        Polynomial mulResult=new Polynomial();
        Polynomial mulAux=new Polynomial();
        Monomial mulMonom=new Monomial(1,1);
        for(Monomial m1: pol1.getMonomials().values()){
            for(Monomial m2: pol2.getMonomials().values()){
                mulMonom=new Monomial(m1.getExponent()+ m2.getExponent(),  (int) (m1.getCoefficient()* m2.getCoefficient()));
                mulAux.getMonomials().put(m1.getExponent()+ m2.getExponent(),mulMonom);
            }
            mulResult=Operations.add(mulResult,mulAux);
            mulAux.getMonomials().clear();
        }
        return mulResult;
    }
    public static Polynomial deriv(Polynomial pol1){
        Polynomial derivResult=new Polynomial();
        for(Monomial m1: pol1.getMonomials().values()){
            if(m1.getExponent()!=0){
                m1.setCoefficient(m1.getCoefficient()*m1.getExponent());
                m1.setExponent(m1.getExponent()-1);
                derivResult.addMonomToPolynom(m1);
            }
        }
        return derivResult;
    }
    public static Polynomial integ(Polynomial pol1){
        Polynomial derivResult=new Polynomial();
        for(Monomial m1: pol1.getMonomials().values()){
            if(m1.getExponent()!=0){
                m1.setCoefficient((m1.getCoefficient()/(m1.getCoefficient()+1)));
                m1.setExponent(m1.getExponent()+1);
                derivResult.addMonomToPolynom(m1);
            }else{
                m1.setExponent(m1.getExponent()+1);
                derivResult.addMonomToPolynom(m1);
            }
        }
        return derivResult;
    }


}