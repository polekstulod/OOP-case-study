import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class CaseStudy_1 extends Applet implements ActionListener{

    Label lbl1 = new Label("Your Height");    
    Label lbl2 = new Label("Your Weight");
    TextField TFheight = new TextField(5);
    TextField TFweight = new TextField(5);
    Label lbl3 = new Label("meters");
    Label lbl4 = new Label("kilograms"); 
    Button click = new Button("Compute BMI");
    FlowLayout Fl = new FlowLayout(FlowLayout.CENTER);

    JFrame frame = new JFrame();
    Label lbl5 = new Label("Your BMI is");
    TextField TFbmi = new TextField();
    Label lbl6 = new Label();

    public void init() {
        setLayout(Fl);
        add(lbl1);
        add(TFheight);
        add(lbl3);
        add(lbl2);      
        add(TFweight);
        add(lbl4);
        add(click);
        click.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double height = Double.parseDouble(TFheight.getText());
        double weight = Double.parseDouble(TFweight.getText());
        double bmi = weight/(Math.pow(height, 2));

        TFbmi.setText(String.format("%.2f", bmi));
        if(bmi >= 18.5 && bmi <= 24.9){
            lbl6.setText("Congratulations! You are healthy!!!");
        }else{
            lbl6.setText("Start a healthy diet! Exercise!!!");
        }
        TFbmi.setEditable(false);
        
        frame.setSize(225, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(lbl5);
        frame.add(TFbmi);
        frame.add(lbl6);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}

/* 
<applet code="CaseStudy_1.class" width="250" height="100"> 
</applet> 
*/  