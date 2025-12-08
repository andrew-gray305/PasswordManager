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


    }

    public class ActionListenerGeneratePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordGenerator passwordGenerator = new PasswordGenerator();

            view.setPassword(passwordGenerator.generatePassword());

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
}
