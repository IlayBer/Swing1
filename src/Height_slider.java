import javax.swing.*;
public class Height_slider extends JFrame{
    public Height_slider(){
        JSlider height = new JSlider(JSlider.VERTICAL, 140, 190, 140);
        height.setMinorTickSpacing(2);
        height.setMajorTickSpacing(10);
        height.setPaintTicks(true);
        height.setPaintLabels(true);

        JPanel panel=new JPanel();
        panel.add(height);
        add(panel);
    }
    public static void main(String s[]){
        Height_slider slider=new Height_slider();
        slider.pack();
        slider.setVisible(true);
    }
}
