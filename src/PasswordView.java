import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PasswordView {

    private JFrame jFrame;

    // Home Screen
    private JPanel homePanel;
    private JPanel homeButtonPanel;
    private JButton generatePass;
    private JButton storePass;
    private JButton checkPass;

    // Generate password Page
    private JPanel genPassPanel;
    private JPanel passButtonPanel;
    private JButton genPassword;
    private JButton backButtonGen;
    private JTextArea password;



    public PasswordView(){

        jFrame = new JFrame();

        // Home
        homeButtonPanel = new JPanel();
        generatePass = new JButton("Generate Passwords");
        storePass = new JButton("Store Passwords");
        checkPass = new JButton("Check Password Strength");

        // Generate Pass
        genPassPanel = new JPanel();
        genPassword = new JButton("Generate Your Secure Password");
        backButtonGen = new JButton("Back to Home Page");
        password = new JTextArea();






    }

    public void initializeUI(){
        //home
        homePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.add(generatePass);
        homeButtonPanel.add(checkPass);
        homeButtonPanel.add(storePass);
        homePanel.add(homeButtonPanel, BorderLayout.CENTER);

        //generate
        genPassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        genPassPanel.add(genPassword);



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }

    public void addActionListenerGoToGeneratePass(ActionListener Listener){
        generatePass.addActionListener(Listener);
    }

    public void addActionListenerGeneratePass(ActionListener Listener){
        genPassword.addActionListener(Listener);
    }

    public void setPassword(JTextArea password) {
        this.password = password;
    }
}

