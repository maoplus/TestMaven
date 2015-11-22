package Test;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LenghtTest {
    
    private JFrame     frame;
    private JTextField textField;
    private JLabel     displayLabel;
                       
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                    LenghtTest window = new LenghtTest();
                    window.frame.setVisible(true);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    window.frame.setLocation(
                            dim.width / 2 - window.frame.getSize().width / 2,
                            dim.height / 2 - window.frame.getSize().height / 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the application.
     */
    public LenghtTest() {
        initialize();
    }
    
    private int getLen(String value) {
        try {
            return value.trim().getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        displayLabel = new JLabel();
        displayLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
        frame = new JFrame();
        frame.setBounds(100, 100, 638, 285);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        textField = new JTextField();
        textField.setBounds(86, 62, 432, 47);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        displayLabel.setText("The actual length is: "
                                + getLen(textField.getText()));
                    }
                });
            }
        });
        displayLabel.setBounds(85, 133, 433, 33);
        frame.getContentPane().add(displayLabel);
    }
}
