import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ParcelFrame extends JFrame {
    private final int GAPS = 10;

    private String[] senderAddressLines = new String[4];
    private String[] recipientAddressLines = new String[4];
    private String parcelName;
    private String parcelRemarks;
    private double parcelPrice;
    private double parcelLength;
    private double parcelWidth;
    private double parcelHeight;
    private String parcelType;
    private boolean parcelTaxable;
    private boolean parcelPerishable;

    private JTextField[] senderAddressFields = new JTextField[4];
    private JTextField[] recipientAddressFields = new JTextField[4];

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
            JTextField addressLineField = new JTextField(25);
            addressLinePanel.add(addressLineField);
            addressPanel.add(addressLinePanel);
            if (titleText == "Sender") {
                senderAddressFields[line - 1] = addressLineField;
            } else if (titleText == "Receiver") {
                recipientAddressFields[line - 1] = addressLineField;
            }
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
        SpinnerNumberModel valueModel = new SpinnerNumberModel(0.0, 0.0, 100000.0, 1.0);
        JSpinner valueSpinner = new JSpinner(valueModel);
        parcelValuePanel.add(valueSpinner);
        fieldsPanel.add(parcelValuePanel);

        JPanel parcelWeightPanel = new JPanel(new GridLayout(2, 0));
        parcelWeightPanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelWeightPanel.add(new JLabel("Parcel Weight in KG"));
        SpinnerNumberModel weightModel = new SpinnerNumberModel(0.0, 0.0, 20.0, 1.0);
        JSpinner weightSpinner = new JSpinner(weightModel);
        parcelWeightPanel.add(weightSpinner);
        fieldsPanel.add(parcelWeightPanel);

        JPanel parcelDimensionsPanel = new JPanel(new GridLayout(2, 0));
        parcelDimensionsPanel.setAlignmentX(Container.LEFT_ALIGNMENT);
        parcelDimensionsPanel.add(new JLabel("Parcel Dimensions in CM (Length, Width, Height)"));
        JPanel parcelDimensionsFieldPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        SpinnerNumberModel lengthModel = new SpinnerNumberModel(0.0, 0.0, 30.0, 1.0);
        JSpinner lengthSpinner = new JSpinner(lengthModel);
        SpinnerNumberModel widthModel = new SpinnerNumberModel(0.0, 0.0, 30.0, 1.0);
        JSpinner widthSpinner = new JSpinner(widthModel);
        SpinnerNumberModel heightModel = new SpinnerNumberModel(0.0, 0.0, 30.0, 1.0);
        JSpinner heightSpinner = new JSpinner(heightModel);
        parcelDimensionsFieldPanel.add(lengthSpinner);
        parcelDimensionsFieldPanel.add(widthSpinner);
        parcelDimensionsFieldPanel.add(heightSpinner);
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
        classifyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    for (int i = 0; i < 4; i++) {
                        senderAddressLines[i] = senderAddressFields[i].getText();
                        recipientAddressLines[i] = recipientAddressFields[i].getText();
                    }
                }
            });
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
