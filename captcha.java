import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class captcha extends JFrame{
    private JLabel captchaLabel;
    private JTextField captchaTextfield;
    private JButton generateButton;
    private String generatedCaptcha;

    public captcha() {
        setTitle("Captcha Generator");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLabel = new JLabel();
        captchaLabel.setFont(new Font("Arial",Font.BOLD,20));
        captchaLabel.setForeground(Color.GRAY);
        captchaTextfield = new JTextField(10);
        generateButton = new JButton("Generate Captcha");
        generateButton.setForeground(Color.BLUE);
        generateButton.setFont(new Font("Arial", Font.BOLD,20));

        generateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                generatedCaptcha = generateCaptcha();
                captchaLabel.setText(generatedCaptcha);
            }
        });


        JPanel panel = new JPanel();
        panel.add(captchaLabel);
        panel.add(captchaTextfield);
        panel.add(generateButton);

        add(panel);
    }

    private String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i<6; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            captcha.append(c);
        }

        return captcha.toString();
    }
       
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                new captcha().setVisible(true);
            }
        });    
    }
        
    }
    
