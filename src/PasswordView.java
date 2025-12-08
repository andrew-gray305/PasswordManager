import javax.swing.*;
import javax.swing.border.Border;
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
    private JLabel title;

    // Generate password Page
    private JPanel genPassPanel;
    private JPanel passButtonPanel;
    private JButton genPassword;
    private JButton backButtonGen;
    private JTextArea password;

    // Check Password Strength Page
    private JPanel checkPassPanel;
    private JLabel cTitle;
    private JButton backButtonCheck;

    // Store Password Page
    private JPanel storePassPanel;
    private JLabel sTitle;
    private JButton backButtonStore;




    public PasswordView(){

        jFrame = new JFrame();

        // Home
        homeButtonPanel = new JPanel();
        homePanel = new JPanel();
        generatePass = new JButton("Generate Passwords");
        storePass = new JButton("Store Passwords");
        checkPass = new JButton("Check Password Strength");
        title = new JLabel("Andrew's Password Manager");

        // Generate Pass
        genPassPanel = new JPanel();
        genPassword = new JButton("Generate Your Secure Password");
        backButtonGen = new JButton("Back to Home Page");
        password = new JTextArea();

        //check pass
        checkPassPanel = new JPanel();
        cTitle = new JLabel("Check Password Page");
        backButtonCheck = new JButton("Back to Home Page");

        //store pass
        storePassPanel = new JPanel();
        sTitle = new JLabel("Store Password page");
        backButtonStore = new JButton("Back to Home Page");




    }

    public void initializeUI(){
        //home
        homePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.add(generatePass);
        homeButtonPanel.add(checkPass);
        homeButtonPanel.add(storePass);
        homePanel.add(title, BorderLayout.NORTH);
        homePanel.add(homeButtonPanel, BorderLayout.CENTER);
        jFrame.add(homePanel);

        //generate
        genPassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        genPassPanel.add(genPassword);
        genPassPanel.add(password);
        genPassPanel.add(backButtonGen);


        //check
        checkPassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        checkPassPanel.add(cTitle);
        checkPassPanel.add(backButtonCheck);


        //store
        storePassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        storePassPanel.add(sTitle);
        storePassPanel.add(backButtonStore);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }


    // buttons

    public void addActionListenerGeneratePass(ActionListener Listener){
        genPassword.addActionListener(Listener);
    }

    // go to buttons

    public void addActionListenerGoToGeneratePass(ActionListener Listener){
        generatePass.addActionListener(Listener);
    }

    public void addActionListenerGoToCheckPass(ActionListener Listener){
        checkPass.addActionListener(Listener);
    }

    public void addActionListenerGoToStorePass(ActionListener Listener){
        storePass.addActionListener(Listener);
    }



    //back buttons
    public void addActionListenerGoToHomeG(ActionListener Listener){
        backButtonGen.addActionListener(Listener);
    }

    public void addActionListenerGoToHomeC(ActionListener Listener){
        backButtonCheck.addActionListener(Listener);
    }

    public void addActionListenerGoToHomeS(ActionListener Listener){
        backButtonStore.addActionListener(Listener);
    }


    public void setPassword(String text) {
        this.password.setText(text);
    }

    public void switchGenPanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(genPassPanel);
        jFrame.revalidate();
        jFrame.repaint();

    }

    public void switchCheckPanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(checkPassPanel);
        jFrame.revalidate();
        jFrame.repaint();

    }

    public void switchStorePanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(storePassPanel);
        jFrame.revalidate();
        jFrame.repaint();

    }

    public void switchHomePanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(homePanel);
        jFrame.revalidate();
        jFrame.repaint();

    }
}

