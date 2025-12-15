import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PasswordView {

    private JFrame jFrame;

    // Home Screen
    private JPanel homePanel;
    private JPanel homeButtonPanel;
    private JButton generatePass;
    private JButton storePass;
    private JButton checkPass;
    private JButton getPass;
    private JButton getStats;;
    private JTextArea statsOutput;



    // Generate password Page
    private JPanel genPassPanel;
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
    private JButton storePassword;
    private JLabel serviceLabel;
    private JLabel usernameLabel;
    private JLabel enterPassLabel;
    private JLabel enterMasterPassLabel;
    private JTextField enterService;
    private JTextField enterUsername;
    private JTextField enterPasswordToStore;
    private JTextField enterMasterPassword;
    private JButton backButtonStore;

    // get stored passwords page
    private JPanel getPassPanel;
    private JLabel enterMasPasLabel;
    private JTextField enterMasterPasswordOutput;
    private JButton getPasswords;
    private JTextArea passwordOutput;
    private JButton backButtonGet;
    private JScrollPane scrollPane;
    private JTextField searchBar;
    private JButton searchButton;
    private JButton sortByService;
    private JButton sortByUsername;






    public PasswordView(){

        jFrame = new JFrame("Andrew's Password Manager");

        // Home
        homeButtonPanel = new JPanel();
        homePanel = new JPanel();
        generatePass = new JButton("Generate Passwords");
        storePass = new JButton("Store Passwords");
        checkPass = new JButton("Check Password Strength");
        getPass = new JButton("Get Your Stored Passwords");
        getStats = new JButton("Get Password Manager Stats");
        statsOutput = new JTextArea();






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
        enterService = new JTextField(60);
        enterUsername = new JTextField(50);
        enterPasswordToStore = new JTextField(50);
        enterMasterPassword = new JTextField(50);
        serviceLabel = new JLabel("Enter Service:");
        usernameLabel = new JLabel("Enter Username:");
        enterPassLabel = new JLabel("Enter Password to Store:");
        enterMasterPassLabel = new JLabel("Enter Master Password:");
        storePassword = new JButton("Store Your Password");
        backButtonStore = new JButton("Back to Home Page");

        // get passwords
        getPassPanel = new JPanel();
        enterMasPasLabel = new JLabel("Enter Master Password:");
        enterMasterPasswordOutput = new JTextField(30);
        passwordOutput = new JTextArea(20,50);
        getPasswords = new JButton("Get Your Stored Passwords");
        backButtonGet = new JButton("Back to Home Page");
        scrollPane = new JScrollPane(passwordOutput,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        searchBar = new JTextField(60);
        searchButton = new JButton("Search");
        sortByService = new JButton("Sort By Service");
        sortByUsername = new JButton("Sort by Username");






    }




    public void initializeUI(){
        //home
        homePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.add(generatePass);
        homeButtonPanel.add(checkPass);
        homeButtonPanel.add(storePass);
        homeButtonPanel.add(getPass);
        homePanel.add(homeButtonPanel, BorderLayout.CENTER);
        homePanel.add(getStats, BorderLayout.NORTH);
        homePanel.add(statsOutput,BorderLayout.SOUTH);
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
        storePassPanel.add(serviceLabel);
        storePassPanel.add(enterService);
        storePassPanel.add(usernameLabel);
        storePassPanel.add(enterUsername);
        storePassPanel.add(enterPassLabel);
        storePassPanel.add(enterPasswordToStore);
        storePassPanel.add(enterMasterPassLabel);
        storePassPanel.add(enterMasterPassword);
        storePassPanel.add(storePassword);
        storePassPanel.add(backButtonStore);

        //get
        getPassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        getPassPanel.add(enterMasPasLabel);
        getPassPanel.add(enterMasterPasswordOutput);
        getPassPanel.add(getPasswords);
        getPassPanel.add(searchBar);
        getPassPanel.add(searchButton);
        getPassPanel.add(scrollPane);
        getPassPanel.add(backButtonGet);
        getPassPanel.add(sortByService);
        getPassPanel.add(sortByUsername);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(700, 700);
        jFrame.setVisible(true);


    }


    // buttons


    public void addActionListenerGeneratePass(ActionListener Listener){
        genPassword.addActionListener(Listener);
    }

    public void addActionListenerCheckPassword(ActionListener Listener){
        checkPassword.addActionListener(Listener);
    }

    public void addActionListenerStorePassword(ActionListener Listener){
        storePassword.addActionListener(Listener);
    }

    public void addActionListenerGetPasswords(ActionListener Listener){
        getPasswords.addActionListener(Listener);
    }

    public void addActionListenerSearch(ActionListener Listener){
        searchButton.addActionListener(Listener);
    }

    public void addActionListenerGetStats(ActionListener Listener){
        getStats.addActionListener(Listener);
    }

    public void addActionListenerSetLength(ActionListener Listener){
        setLengthButton.addActionListener(Listener);
    }

    public void addActionListenerSortByService(ActionListener Listener){
        sortByService.addActionListener(Listener);
    }

    public void addActionListenerSortByUsername(ActionListener Listener){
        sortByUsername.addActionListener(Listener);
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

    public void addActionListenerGoToGetPass(ActionListener Listener){
        getPass.addActionListener(Listener);
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


    public void addActionListenerGoToHomeGet(ActionListener Listener){
        backButtonGet.addActionListener(Listener);
    }

    public void addActionListenerClosePopUp(ActionListener Listener){
        backButtonGet.addActionListener(Listener);
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

    public JTextField getSearchBar() {
        return searchBar;
    }

    public void setPassword(String text) {
        this.password.setText(text);
    }

    public void setPasswordOutput(ArrayList<PasswordStorage.DecryptedPassword> passwords) {
        String text = "";

        for (PasswordStorage.DecryptedPassword dp : passwords) {
            text += dp;
        }

        passwordOutput.setText(text);
    }


    public void setStrengthOutput(String text) {
        this.strengthOutput.setText(text);
    }

    public void setStatsOutput(String text) {
        this.statsOutput.setText(text);
    }

    public JTextField getEnterMasterPassword() {
        return enterMasterPassword;
    }

    public JTextField getEnterUsername() {
        return enterUsername;
    }


    public JTextField getEnterMasterPasswordOutput() {
        return enterMasterPasswordOutput;
    }

    public JTextField getEnterService() {
        return enterService;
    }

    public JTextField getEnterPasswordToStore() {
        return enterPasswordToStore;
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

    public void switchGetPassPanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(getPassPanel);
        jFrame.revalidate();
        jFrame.repaint();

    }

    public void switchHomePanel(){
        jFrame.getContentPane().removeAll();
        jFrame.add(homePanel);
        jFrame.revalidate();
        jFrame.repaint();

        clearAllTextFields();

    }


    public void clearAllTextFields() {
        enterService.setText("");
        enterUsername.setText("");
        enterPasswordToStore.setText("");
        enterMasterPassword.setText("");
        enterMasterPasswordOutput.setText("");
        enterPassword.setText("");

        passwordOutput.setText("");
        password.setText("");
        strengthOutput.setText("");
        recommendations.setText("");
        searchBar.setText("");
        statsOutput.setText("");
    }

}

