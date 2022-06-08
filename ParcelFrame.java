import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ParcelFrame extends JFrame {
    ParcelFrame() {
        JPanel mainPanel = new JPanel(new GridLayout(0, 2, 10, 0));

        JPanel leftPanel = new JPanel(new GridLayout(3, 0));
        leftPanel.add(makeAddressLines("Sender"));
        leftPanel.add(makeAddressLines("Recipient"));
        JPanel radioPanel = new JPanel(new GridLayout(0, 3));
        radioPanel.add(makeRadioButtons("Type", new ArrayList<>(Arrays.asList("Mail", "Item"))));
        radioPanel.add(makeRadioButtons("Taxable", new ArrayList<>(Arrays.asList("Yes", "No"))));
        radioPanel.add(makeRadioButtons("Perishable", new ArrayList<>(Arrays.asList("Yes", "No"))));
        leftPanel.add(radioPanel);

        JPanel rightPanel = new JPanel(new GridLayout(4, 0));
        JPanel rightPanelTop = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.ipady = 50;
        c.ipadx = 50;
        rightPanelTop.add(makeBasicField("Item Name"), c);
        rightPanelTop.add(makeBasicField("Value in PHP"), c);
        rightPanelTop.add(makeBasicField("Weight in KG"), c);
        rightPanel.add(rightPanelTop);
        rightPanel.add(makeBasicField("Remarks"));

        JPanel rightPanelBottom = new JPanel(new GridBagLayout());
        c.weightx = 1.0;
        c.ipady = 50;
        c.ipadx = 50;
        rightPanelBottom.add(new JButton("Classify"), c);
        rightPanelBottom.add(new JButton("Print"), c);
        rightPanel.add(rightPanelBottom);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        this.add(mainPanel);
    }

    private JPanel makeAddressLines(String titleText) {
        JPanel addressPanel = new JPanel(new GridLayout(5, 0));
        addressPanel.add(new JLabel(titleText, SwingConstants.CENTER));
        for (int i = 0; i < 3; i++) {
            JPanel line = new JPanel(new GridLayout(2, 0));
            line.add(new JLabel("Line " + (i + 1) + ":"));
            line.add(new JTextField());
            addressPanel.add(line);
        }
        return addressPanel;
    }

    private JPanel makeRadioButtons(String titleText, ArrayList<String> choices) {
        JPanel radioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        radioPanel.add(new JLabel(titleText), c);
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < choices.size(); i++) {
            JRadioButton radioButton = new JRadioButton(choices.get(i));
            c.gridx = 0;
            c.gridy = i + 1;
            buttonGroup.add(radioButton);
            radioPanel.add(radioButton, c);
        }
        return radioPanel;
    }

    private JPanel makeBasicField(String titleText) {
        JPanel fieldPanel = new JPanel(new GridLayout(2, 0));
        fieldPanel.add(new JLabel(titleText));
        fieldPanel.add(new JTextField());
        return fieldPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        ParcelFrame frame = new ParcelFrame();
                        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        frame.setPreferredSize(new Dimension(720, 720));
                        frame.pack();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
    }
}
