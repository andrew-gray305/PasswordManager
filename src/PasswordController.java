import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordController {
    private PasswordView view;

    public PasswordController(PasswordView view) {
        this.view = view;
        view.addActionListenerGeneratePass(new ActionListenerGeneratePass());
        view.addActionListenerGoToGeneratePass(new ActionListenerGoToGeneratePass());


    }

    public class ActionListenerGeneratePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordGenerator passwordGenerator = new PasswordGenerator();

            passwordGenerator.generatePassword();

        }
    }

    public class ActionListenerGoToGeneratePass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordGenerator passwordGenerator = new PasswordGenerator();

            passwordGenerator.generatePassword();

        }
    }
}
