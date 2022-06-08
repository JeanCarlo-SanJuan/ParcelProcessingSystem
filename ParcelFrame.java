import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class ParcelFrame extends JFrame {
    private final int GAPS = 10;

    public ParcelFrame() {
        initializeComponents();
    }

    private void initializeComponents() {
        setPreferredSize(new Dimension(800, 600));

        getContentPane().setLayout(new GridLayout(0, 2, GAPS, GAPS));
        getRootPane().setBorder(new EmptyBorder(GAPS, GAPS, GAPS, GAPS));

        createLeftPanel();
        createRightPanel();

        pack();
    }

    private void createLeftPanel() {
        JPanel leftPanel = new JPanel(new GridLayout(3, 0, GAPS, GAPS));
        createAddressLines(leftPanel, "Sender");
        createAddressLines(leftPanel, "Receiver");
        createRadioButtons(leftPanel);
        add(leftPanel);
    }

    private void createAddressLines(JPanel whereTo, String titleText) {
        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.PAGE_AXIS));
        JLabel titleLabel = new JLabel(titleText);
        addressPanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int line = 1; line <= 4; line++) {
            JPanel addressLinePanel = new JPanel();
            addressLinePanel.setLayout(new BoxLayout(addressLinePanel, BoxLayout.LINE_AXIS));
            addressLinePanel.add(new JLabel("Line " + line + ": "));
            addressLinePanel.add(new JTextField(25));
            addressPanel.add(addressLinePanel);
        }
        whereTo.add(addressPanel);
    }

    private void createRadioButtons(JPanel whereTo) {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.LINE_AXIS));

        radioPanel.add(Box.createHorizontalGlue());

        JPanel typePanel = new JPanel();
        ButtonGroup typeButtons = new ButtonGroup();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.PAGE_AXIS));
        typePanel.add(Box.createVerticalGlue());
        typePanel.add(new JLabel("Type"));
        JRadioButton typeMailButton = new JRadioButton("Mail");
        typePanel.add(typeMailButton);
        typeButtons.add(typeMailButton);
        JRadioButton typeItemButton = new JRadioButton("Item");
        typePanel.add(typeItemButton);
        typeButtons.add(typeItemButton);
        typePanel.add(Box.createVerticalGlue());
        radioPanel.add(typePanel);

        radioPanel.add(Box.createHorizontalGlue());

        JPanel taxablePanel = new JPanel();
        ButtonGroup taxableButtons = new ButtonGroup();
        taxablePanel.setLayout(new BoxLayout(taxablePanel, BoxLayout.PAGE_AXIS));
        taxablePanel.add(Box.createVerticalGlue());
        taxablePanel.add(new JLabel("Taxable"));
        JRadioButton taxableYesButton = new JRadioButton("Yes");
        taxablePanel.add(taxableYesButton);
        taxableButtons.add(taxableYesButton);
        JRadioButton taxableNoButton = new JRadioButton("No");
        taxablePanel.add(taxableNoButton);
        taxableButtons.add(taxableNoButton);
        taxablePanel.add(Box.createVerticalGlue());
        radioPanel.add(taxablePanel);

        radioPanel.add(Box.createHorizontalGlue());

        JPanel perishablePanel = new JPanel();
        ButtonGroup perishableButtons = new ButtonGroup();
        perishablePanel.setLayout(new BoxLayout(perishablePanel, BoxLayout.PAGE_AXIS));
        perishablePanel.add(Box.createVerticalGlue());
        perishablePanel.add(new JLabel("Perishable"));
        JRadioButton perishableYesButton = new JRadioButton("Yes");
        perishablePanel.add(perishableYesButton);
        perishableButtons.add(perishableYesButton);
        JRadioButton perishableNoButton = new JRadioButton("No");
        perishablePanel.add(perishableNoButton);
        perishableButtons.add(perishableNoButton);
        perishablePanel.add(Box.createVerticalGlue());
        radioPanel.add(perishablePanel);

        radioPanel.add(Box.createHorizontalGlue());

        whereTo.add(radioPanel);
    }

    private void createRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout());

        createRightFields(rightPanel);
        createFinishButtons(rightPanel);

        add(rightPanel);
    }

    private void createRightFields(JPanel whereTo) {
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));

        JPanel parcelNamePanel = new JPanel(new GridLayout(2, 0));
        parcelNamePanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelNamePanel.add(new JLabel("Parcel Name"));
        parcelNamePanel.add(new JTextField());
        fieldsPanel.add(parcelNamePanel);

        JPanel parcelValuePanel = new JPanel(new GridLayout(2, 0));
        parcelValuePanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelValuePanel.add(new JLabel("Parcel Value in PHP"));
        parcelValuePanel.add(new JTextField());
        fieldsPanel.add(parcelValuePanel);

        JPanel parcelWeightPanel = new JPanel(new GridLayout(2, 0));
        parcelWeightPanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelWeightPanel.add(new JLabel("Parcel Weight in KG"));
        parcelWeightPanel.add(new JTextField());
        fieldsPanel.add(parcelWeightPanel);

        JPanel parcelDimensionsPanel = new JPanel(new GridLayout(2, 0));
        parcelDimensionsPanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelDimensionsPanel.add(new JLabel("Parcel Dimensions in CM (Length, Width, Height)"));
        JPanel parcelDimensionsFieldPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        parcelDimensionsFieldPanel.add(new JTextField());
        parcelDimensionsFieldPanel.add(new JTextField());
        parcelDimensionsFieldPanel.add(new JTextField());
        parcelDimensionsPanel.add(parcelDimensionsFieldPanel);
        fieldsPanel.add(parcelDimensionsPanel);

        JPanel parcelRemarksPanel = new JPanel();
        parcelRemarksPanel.setLayout(new BoxLayout(parcelRemarksPanel, BoxLayout.PAGE_AXIS));
        JLabel parcelRemarksLabel = new JLabel("Parcel Remarks");
        parcelRemarksLabel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelRemarksPanel.add(parcelRemarksLabel);
        JTextArea parcelRemarksTextArea = new JTextArea();
        parcelRemarksTextArea.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelRemarksTextArea.setLineWrap(true);
        parcelRemarksTextArea.setRows(10);
        parcelRemarksPanel.add(parcelRemarksTextArea);
        fieldsPanel.add(parcelRemarksPanel);

        whereTo.add(fieldsPanel, BorderLayout.PAGE_START);
    }

    private void createFinishButtons(JPanel whereTo) {
        JPanel buttonPanel = new JPanel();

        JButton classifyButton = new JButton("Classify");
        classifyButton.setPreferredSize(new Dimension(175, 40));
        buttonPanel.add(classifyButton);

        JButton printButton = new JButton("Print");
        printButton.setPreferredSize(new Dimension(175, 40));
        buttonPanel.add(printButton);

        whereTo.add(buttonPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        ParcelFrame frame = new ParcelFrame();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
    }
}
