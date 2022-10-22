import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseStudy_2 extends Applet implements ActionListener{
    int sign = 0;
    TextField txtIn1 = new TextField("0.0", 10);
    Button btnPlus = new Button("+");
    Button btnMinus = new Button("-");
    Button btnTimes = new Button("x");
    Button btnDivide = new Button("/");
    TextField txtIn2 = new TextField("0.0", 10);
    Button btnEquals = new Button("=");
    TextField txtResult = new TextField("", 10);
    Button btnOff = new Button("OFF");
    Button btnOn = new Button("ON");
    Button btnClear = new Button("CLEAR");
    GridLayout G1 = new GridLayout(6, 1, 10, 10);
    GridLayout G2 = new GridLayout(1, 6, 10, 10);
    GridLayout G3 = new GridLayout(1, 5, 10, 10);
    Panel P1 = new Panel();
    Panel P2 = new Panel();
    Font txtFont = new Font("Arial", Font.PLAIN, 20);

    public void init() {
        setLayout(G1);
        add(txtIn1);
        P1.setLayout(G2);
        P1.add(btnPlus);
        P1.add(btnMinus);
        P1.add(btnTimes); 
        P1.add(btnDivide);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnTimes.addActionListener(this);
        btnDivide.addActionListener(this);
        btnPlus.setEnabled(false);
        btnMinus.setEnabled(false);
        btnTimes.setEnabled(false);
        btnDivide.setEnabled(false);

        add(P1);
        add(txtIn2); 

        add(btnEquals); 
        btnEquals.addActionListener(this);
        btnEquals.setEnabled(false);

        txtResult.setEditable(false);
        add(txtResult);

        P2.setLayout(G3);
        P2.add(btnOn);
        P2.add(btnOff);
        btnOff.setEnabled(false);
        P2.add(btnClear);
        btnClear.setEnabled(false);
        add(P2);

        btnOn.addActionListener(this);
        btnOff.addActionListener(this);
        btnClear.addActionListener(this);

        txtIn1.setFont(txtFont);
        txtIn2.setFont(txtFont);
        txtResult.setFont(txtFont);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double txtField1 = Double.parseDouble(txtIn1.getText());
        double txtField2 = Double.parseDouble(txtIn2.getText());

        String eventAction = e.getActionCommand();

        if(eventAction == btnPlus.getActionCommand()) sign = 1;
        if(eventAction == btnMinus.getActionCommand()) sign = 2;
        if(eventAction == btnTimes.getActionCommand()) sign = 3;
        if(eventAction == btnDivide.getActionCommand()) sign = 4;

        if(eventAction == btnOn.getActionCommand()){
            btnPlus.setEnabled(true);
            btnMinus.setEnabled(true);
            btnTimes.setEnabled(true);
            btnDivide.setEnabled(true);
            btnEquals.setEnabled(true);
            btnOff.setEnabled(true);
            btnClear.setEnabled(true);
            btnOn.setEnabled(false);
        }
        if(eventAction == btnOff.getActionCommand()){
            btnPlus.setEnabled(false);
            btnMinus.setEnabled(false);
            btnTimes.setEnabled(false);
            btnDivide.setEnabled(false);
            btnEquals.setEnabled(false);
            btnOff.setEnabled(false);
            btnClear.setEnabled(false);
            btnOn.setEnabled(true);
        }

        if(eventAction == btnEquals.getActionCommand()){
            if(sign == 1) txtResult.setText(Double.toString(txtField1+txtField2));
            else if(sign == 2) txtResult.setText(Double.toString(txtField1-txtField2));
            else if(sign == 3) txtResult.setText(Double.toString(txtField1*txtField2));
            else if(sign == 4) txtResult.setText(Double.toString(txtField1/txtField2));
            else txtResult.setText("0.0");
        }

        if(eventAction == btnClear.getActionCommand()){
            txtIn1.setText("0.0");
            txtIn2.setText("0.0");
            txtResult.setText("");
            sign = 0;
        }
    }
}

/*
 * <applet code="CaseStudy_2.class" width="300" height="300"> </applet>
 */