import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JPanel {
    private double weight;
    private double height;
    private double age;
    private double slimness;

    public Frame(int x, int y, int width, int ht){
        this.setLayout(null);
        this.setBounds(x, y , width, ht);
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(20, 60, 90 , 20);
        this.add(labelName);

        TextField NameText = new TextField("");
        NameText.setBounds(120, 60, 90, 20);
        this.add(NameText);



        JLabel FNLabel = new JLabel("Family_name");
        FNLabel.setBounds(20, 160, 90 , 20);
        this.add(FNLabel);

        TextField FNText = new TextField("");
        FNText.setBounds(120, 160, 90, 20);
        this.add(FNText);

        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(20, 260, 90 , 20);
        this.add(labelAge);
        TextField AgeText = new TextField("");
        AgeText.setBounds(120, 260, 90, 20);
        this.add(AgeText);
        AgeText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    double value = Double.parseDouble(AgeText.getText());
                    if(value<=0){
                        System.out.println("0 is not a valid number");
                        AgeText.setText("");
                        value = Double.parseDouble(AgeText.getText());
                    }
                    age = value;
                    System.out.println("Age is "+age);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    AgeText.setText("");
                }
            }
        });

        JLabel g=new JLabel("Genders");
        g.setBounds(220,170,90,20);
        this.add(g);

        String genders[]={"Other", "Male", "Female"};
        JComboBox gender=new JComboBox(genders);
        gender.setBounds(220,200,90,20);
        this.add(gender);

        JLabel H=new JLabel("height");
        H.setBounds(320,50,90,20);
        this.add(H);

        JSlider h=new JSlider(JSlider.VERTICAL,140,210,170);
        h.setMinorTickSpacing(2);
        h.setMajorTickSpacing(10);
        h.setPaintTicks(true);
        h.setPaintLabels(true);
        h.setBounds(320,100,50,200);
        h.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                height=h.getValue();
            }
        });
        this.add(h);


        JLabel W=new JLabel("Weight");
        W.setBounds(400,120,90,20);
        this.add(W);

        JTextField w=new JTextField();
        w.setBounds(400,150,90,20);
        w.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    double value1 = Double.parseDouble(w.getText());
                    if(value1<=0){
                        System.out.println("0 is not a valid number");
                        w.setText("");
                        value1 = Double.parseDouble(w.getText());
                    }
                    weight = value1;
                    System.out.println("Weight is "+weight);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    w.setText("");
                }
            }
        });
        this.add(w);

        JLabel s=new JLabel("Slimness");
        s.setBounds(400,180,90,20);
        this.add(s);

        String type[] ={"0.9","1","1.1"};
        JComboBox slim=new JComboBox<>(type);
        slim.setBounds(400,210,90,20);
        slim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=(String) (slim.getItemAt(slim.getSelectedIndex()));
                slimness=Double.parseDouble(value);
            }
        });
        this.add(slim);
        double bmi=BMI_algorithm.calc(height,weight);
        String status=BMI_algorithm.status(height,weight);
        double idealw=BMI_algorithm.idealWeight(height,weight,age,slimness);

        JButton calc=new JButton("calculate");
        calc.setBounds(120,300,90,20);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(height>0&&weight>0&&age>0&&slimness>0){
                    JOptionPane.showMessageDialog(null,"Your BMI is "+bmi+ " , and your status is "+status+ ". Your ideal weight is "+idealw+" while your current weight is "+weight);
                }else {
                    JOptionPane.showMessageDialog(null,"invalid numbers");
                }
            }
        });
        this.add(calc);
    }
    public boolean isEmpty(String text){
        if(text.equals("")){
            return true;
        }else{
            return false;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}