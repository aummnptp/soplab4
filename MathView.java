package com.example.labvaadin;



import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

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
        result.setReadOnly(true);

        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl = new VerticalLayout();


        hl.add(btnPlus,btnMinus,btnMulti,btnDivide,btnMod,btnMax);
        vl.add(n1,n2,hl,result);
        this.add(vl);

        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out  = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
                result.setValue(out);
        });
        btnMinus.addClickListener(event ->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());

           String out = WebClient.create()
                   .get()
                   .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                   .retrieve()
                   .bodyToMono(String.class)
                   .block();
           result.setValue(out);
        });
        btnMulti.addClickListener(event ->{
            double num1 =Double.parseDouble(n1.getValue());
            double num2 =Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            result.setValue(out);
        });
        btnDivide.addClickListener(event ->{
            double num1 =Double.parseDouble(n1.getValue());
            double num2 =Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            result.setValue(out);
        });
        btnMod.addClickListener(event ->{
            double num1 =Double.parseDouble(n1.getValue());
            double num2 =Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            result.setValue(out);
        });
        btnMax.addClickListener(event ->{
            double num1 =Double.parseDouble(n1.getValue());
            double num2 =Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/max?n1="+num1+"&n2="+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            result.setValue(out);
        });
    }
}