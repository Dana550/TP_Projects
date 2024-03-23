package org.example.Interface;

import org.example.Model.Monomial;
import org.example.Model.Operations;
import org.example.Model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI extends JFrame{
    Pattern pattern=Pattern.compile("(\\+[0-9]{1,}x\\^[0-9]{1,})|(-[0-9]{1,}x\\^[0-9]{1,})");

    public Polynomial parsStringToPolynomial(String string){
        Polynomial result=new Polynomial();
        //daca string ul exista
        if(!string.equals("")){
            Matcher matcher= pattern.matcher(string);
            String stringAux="";
            while(matcher.find()){
                String matchGroup= matcher.group();//grupul la care se afla
                stringAux=stringAux+matchGroup;
                Scanner scaner;
                scaner = new Scanner(matchGroup);
                scaner.useDelimiter("x\\^");
                double saveCoeff;
                int saveExp;
                saveCoeff=scaner.nextDouble();
                saveExp=scaner.nextInt();
                result.addMonomToPolynom(new Monomial(saveExp,saveCoeff));
            }
            if(!stringAux.equals(string)){
                JOptionPane.showMessageDialog(this,"Wrong Input");
                return new Polynomial();
            }
            return result;
        }else{
            JOptionPane.showMessageDialog(this,"You have to add something");
            return new Polynomial();
        }
    }
    public JPanel panel;
    public JPanel panel2;
    public JButton   bAdd;
    public JButton   bSub;
    public JButton   bMul;
    public JButton   bDiv ;
    public JButton   bDeriv ;
    public JButton   bInteg;
    public JButton   bCancel;

    public JTextField firstPolynom;
    public JTextField secondPolynom;
    public JLabel nullSpace;
    public JLabel labelFirstPolynom;
    public JLabel labelSecondPolynom;
    public JLabel result;
    public JLabel resultText;


    public GUI(){
        super("POLYNOMIAL CALCULATOR");
        setSize(500,500);

        panel = new JPanel();
        panel2= new JPanel();
        bAdd  = new JButton("+");
        bSub = new JButton("-");
        bMul= new JButton("*");
        bDiv    = new JButton(":");
        bDeriv  = new JButton("'");
        bInteg = new JButton("/");
        bCancel=new JButton("CE");
        firstPolynom= new JTextField("+2x^3-1x^0");
        secondPolynom= new JTextField("-2x^1-1x^0");
        labelFirstPolynom=new JLabel("First Polynomial: ");
        labelFirstPolynom.setFont(new Font("Arial", Font.BOLD, 25));
        labelSecondPolynom=new JLabel("Second Polynomial: ");
        labelSecondPolynom.setFont(new Font("Arial", Font.BOLD, 25));
        result=new JLabel("");
        nullSpace=new JLabel("");
        resultText=new JLabel("RESULT:");
        resultText.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));


        firstPolynom.setSize(30,30);
        secondPolynom.setSize(30,30);
        // bAdd.setText("+");
        //bSub.setText("-");
        //bSub.setText("*");
        //bSub.setText("/");
        //bDeriv.setText("'");
        //bInteg.setText("|");
        result.setSize(30,30);

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial pol1,pol2,res;
                pol1=new Polynomial();
                pol2=new Polynomial();
                res=new Polynomial();
                pol1=parsStringToPolynomial(firstPolynom.getText());
                pol2=parsStringToPolynomial(secondPolynom.getText());
                res= Operations.add(pol1,pol2);
                result.setText(res.toString());
            }
        });
        bSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial pol1,pol2,res;
                pol1=new Polynomial();
                pol2=new Polynomial();
                res=new Polynomial();
                pol1=parsStringToPolynomial(firstPolynom.getText());
                pol2=parsStringToPolynomial(secondPolynom.getText());
                res= Operations.sub(pol1,pol2);
                result.setText(res.toString());
            }
        });
        bMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial pol1,pol2,res;
                pol1=new Polynomial();
                pol2=new Polynomial();
                res=new Polynomial();
                pol1=parsStringToPolynomial(firstPolynom.getText());
                pol2=parsStringToPolynomial(secondPolynom.getText());
                res= Operations.mul(pol1,pol2);
                result.setText(res.toString());
            }
        });
        bDeriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial pol1,pol2,res;
                pol1=new Polynomial();
                pol2=new Polynomial();
                res=new Polynomial();
                pol1=parsStringToPolynomial(firstPolynom.getText());
                pol2=parsStringToPolynomial(secondPolynom.getText());
                res= Operations.deriv(pol1);
                result.setText(res.toString());
            }
        });

        bInteg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial pol1,pol2,res;
                pol1=new Polynomial();
                pol2=new Polynomial();
                res=new Polynomial();
                pol1=parsStringToPolynomial(firstPolynom.getText());
                pol2=parsStringToPolynomial(secondPolynom.getText());
                res= Operations.integ(pol1);
                result.setText(res.toString());
            }
        });
        bCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstPolynom.setText("");
                secondPolynom.setText("");
                result.setText("");
            }
        });

        panel.add(labelFirstPolynom);
        panel.add(firstPolynom);
        panel.add(labelSecondPolynom);
        panel.add(secondPolynom);
        panel.add(bAdd);
        panel.add(bSub);
        panel.add(bMul);
        panel.add(bDiv);
        panel.add(bDeriv);
        panel.add(bInteg);
        panel.add(bCancel);
        panel.add(nullSpace);
        panel.add(resultText);
        panel.add(result);

        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(0,2));
        add(panel);

        setVisible(true);
        ImageIcon image = new ImageIcon("LOGO.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(Color.blue);

    }

}
