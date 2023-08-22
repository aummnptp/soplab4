package com.example.labvaa;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value="index1")
public class MathView extends FormLayout {

    private TextField n1,n2,result;
    private Button btnPlus ,btnMinus,btnMulti,btnDivide,btnMod,btnMax;

    public MathView(){
        n1 =new TextField("Number1");
        n2 = new TextField("Number2");
        result = new TextField("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("x");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");

        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl = new VerticalLayout();


        hl.add(btnPlus,btnMinus,btnMulti,btnDivide,btnMod,btnMax);
        vl.add(n1,n2,hl,result);
        this.add(vl);

    }
}
