import javax.swing.*;
import javax.swing.event.ChangeListener;
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
    private JButton setLengthButton;
    private JTextArea password;
    private JSlider lengthSlider;
    private JLabel lengthValLabel;


    // Check Password Strength Page
    private JPanel checkPassPanel;
    private JLabel cTitle;
    private JTextField enterPassword;
    private JButton checkPassword;
    private JButton backButtonCheck;
    private JTextArea strengthOutput;
    private JTextArea recommendations;
    private JLabel recLabel;
    private JLabel strengthLabel;


    // Store Password Page
    private JPanel storePassPanel;
    private JLabel sTitle;
    private JButton backButtonStore;




    public PasswordView(){

        jFrame = new JFrame("Andrew's Password Manager");

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
        setLengthButton = new JButton("Set Length");
        password = new JTextArea(5,20);
        lengthSlider = new JSlider(8,40,20);
        lengthSlider.setMajorTickSpacing(8);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthValLabel = new JLabel("20");


        //check pass
        checkPassPanel = new JPanel();
        cTitle = new JLabel("Check Password Page");
        enterPassword = new JTextField(40);
        checkPassword = new JButton("Check Password");
        backButtonCheck = new JButton("Back to Home Page");
        strengthOutput = new JTextArea(5,20);
        recommendations = new JTextArea(10,20);
        recLabel = new JLabel("Password Recommendations");
        strengthLabel = new JLabel("Password Strength");






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
        genPassPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        genPassPanel.add(genPassword);
        genPassPanel.add(new JLabel("Length:"));
        genPassPanel.add(lengthSlider);
        genPassPanel.add(lengthValLabel);
        genPassPanel.add(setLengthButton);
        genPassPanel.add(password);
        genPassPanel.add(backButtonGen);
        genPassword.setEnabled(false);

        //check
        checkPassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        checkPassPanel.add(cTitle);
        checkPassPanel.add(enterPassword);
        checkPassPanel.add(checkPassword);
        checkPassPanel.add(strengthLabel);
        checkPassPanel.add(strengthOutput);
        checkPassPanel.add(recLabel);
        checkPassPanel.add(recommendations);
        checkPassPanel.add(backButtonCheck);


        //store
        storePassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        storePassPanel.add(sTitle);
        storePassPanel.add(backButtonStore);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(700, 900);
        jFrame.setVisible(true);


    }


    // buttons


    public void addActionListenerGeneratePass(ActionListener Listener){
        genPassword.addActionListener(Listener);
    }

    public void addActionListenerCheckPassword(ActionListener Listener){
        checkPassword.addActionListener(Listener);
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

    public void addActionListenerSetLength(ActionListener Listener){
        setLengthButton.addActionListener(Listener);
    }


    public void addChangeListenerLengthSlider(ChangeListener Listener){
        lengthSlider.addChangeListener(Listener);
    }


    public JButton getGenPassword() {
        return genPassword;
    }

    public JSlider getLengthSlider() {
        return lengthSlider;
    }

    public JLabel getLengthValLabel() {
        return lengthValLabel;
    }

    public JTextField getEnterPassword() {
        return enterPassword;
    }

    public void setPassword(String text) {
        this.password.setText(text);
    }

    public void setStrengthOutput(String text) {
        this.strengthOutput.setText(text);
    }

    public void setRecommendations(String text) {
        this.recommendations.setText(text);
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

