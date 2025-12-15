import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordController {
    private PasswordView view;

    public PasswordController(PasswordView view) {
        this.view = view;
        view.addActionListenerGeneratePass(new ActionListenerGeneratePass());
        view.addActionListenerGoToGeneratePass(new ActionListenerGoToGeneratePass());
        view.addActionListenerGoToCheckPass(new ActionListenerGoToCheckPass());
        view.addActionListenerGoToStorePass(new ActionListenerGoToStorePass());
        view.addActionListenerGoToHomeG(new ActionListenerGoToHomeG());
        view.addActionListenerGoToHomeC(new ActionListenerGoToHomeC());
        view.addActionListenerGoToHomeS(new ActionListenerGoToHomeS());
        view.addActionListenerSetLength(new ActionListenerSetLength());
        view.addActionListenerCheckPassword(new ActionListenerCheckPassword());
        view.addActionListenerStorePassword(new ActionListenerStorePassword());
        view.addActionListenerGoToGetPass(new ActionListenerGoToGetPass());
        view.addActionListenerGoToHomeGet(new ActionListenerGoToHomeGet());
        view.addActionListenerGetPasswords(new ActionListenerGetPasswords());



        view.addChangeListenerLengthSlider(new ChangeListenerLengthSlider());


    }

    public class ActionListenerGeneratePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int length = view.getLengthSlider().getValue();

            PasswordGenerator passwordGenerator = new PasswordGenerator();

            view.setPassword(passwordGenerator.generatePassword(length));



        }
    }

    public class ActionListenerGoToGeneratePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.switchGenPanel();


        }
    }

    public class ActionListenerGoToCheckPass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.switchCheckPanel();


        }
    }

    public class ActionListenerGoToStorePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.switchStorePanel();


        }
    }

    public class ActionListenerGoToGetPass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.switchGetPassPanel();

        }
    }

    public class ActionListenerGoToHomeG implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.switchHomePanel();


        }
    }

    public class ActionListenerGoToHomeC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.switchHomePanel();


        }
    }

    public class ActionListenerGoToHomeS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.switchHomePanel();


        }
    }

    public class ActionListenerSetLength implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getGenPassword().setEnabled(true);


        }
    }

    public class ActionListenerCheckPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordStrength passwordStrength = new PasswordStrength();

            var result = passwordStrength.checkPasswordStrength(view.getEnterPassword().getText());

            view.setStrengthOutput(passwordStrength.scoreCalc(result.score()));
            view.setRecommendations(result.recommendations());



        }
    }

    public class ActionListenerStorePassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String service = view.getEnterService().getText();
            String username = view.getEnterUsername().getText();
            String password = view.getEnterPasswordToStore().getText();
            String masterPassword = view.getEnterMasterPassword().getText();

            PasswordStorage passwordStorage = new PasswordStorage();
            passwordStorage.storeUserPassword(service, username, password, masterPassword.toCharArray());

            view.clearAllTextFields();




        }
    }

    public class ActionListenerGoToHomeGet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.switchHomePanel();


        }
    }

    public class ActionListenerGetPasswords implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            PasswordStorage passwordStorage = new PasswordStorage();

            String masterPassword = view.getEnterMasterPasswordOutput().getText();

            view.setPasswordOutput(passwordStorage.decryptAll(masterPassword.toCharArray()));

        }
    }




    public class ChangeListenerLengthSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            view.getLengthValLabel().setText("" + view.getLengthSlider().getValue());
            view.getGenPassword().setEnabled(false);


        }
    }






}
