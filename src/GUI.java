import javax.swing.*;
import java.io.*;

public class GUI {
    private JButton NYTTButton;
    private JButton sparaButton;
    private JButton openButton;
    private JButton sökButton;
    private JButton timerButton;
    private JRadioButton restartRadioButton;
    private JRadioButton pressOpenRadioButton;
    private JRadioButton setClockRadioButton;
    private JButton startStopButton;
    private JPanel Panel1;
    private JTextArea textArea1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public GUI() {
        String filename = "info.txt";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            textArea1.setText("");
            return;
        }
        String nextLine = null;
        try {
            nextLine = in.readLine();
            while (nextLine != null) {
                assert textArea1 != null;
                textArea1.append(nextLine +"\n");
                nextLine = in.readLine();
            }
        } catch (IOException ex) {
            textArea1.setText("");
        }


        filename = "text.txt";
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Failed to Save!");
        }
        out.println("Hello World");
        out.flush();
        out.close();
    }
}

