import javax.swing.*;

public class App extends JFrame {

    public App(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Calculator");
        this.add(new Frame(0, 0, 700, 400));
        this.setVisible(true);

    }
}

