import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private static final int GAPS = 10;
    private ParcelController parcelController;
    private JPanel buttonsPanel;
    private ButtonGroup buttonsGroup;

    public MainFrame(ParcelController parcelController) {
        this.parcelController = parcelController;
        this.initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Parcel Input Form");
        setPreferredSize(new Dimension(1280, 720));

        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.LINE_AXIS));
        getRootPane().setBorder(new EmptyBorder(GAPS, GAPS, GAPS, GAPS));

        createLeft();
        createRight();

        pack();
    }

    private void createLeft() {
        var leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setBorder(new EmptyBorder(GAPS, GAPS, GAPS, GAPS));

        var titleLabel = new JLabel("Processed Parcels: Sorted by ID");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        leftPanel.add(titleLabel);

        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        buttonsPanel = new JPanel();
        var buttonsPanelScroll = new JScrollPane(buttonsPanel);
        buttonsPanelScroll.setBorder(BorderFactory.createEmptyBorder());
        buttonsGroup = new ButtonGroup();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        addParcels();
        leftPanel.add(buttonsPanelScroll);

        add(leftPanel, BorderLayout.LINE_START);
    }

    private void createRight() {
        var rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4, 0, GAPS * 2, GAPS * 2));
        rightPanel.setBorder(new EmptyBorder(GAPS, GAPS, GAPS, GAPS));
        rightPanel.setMaximumSize(new Dimension(75, 32767));

        var newParcelButton = new JButton("New Parcel");
        newParcelButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        newParcelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ParcelFrame frame = new ParcelFrame(parcelController);
                frame.setVisible(true);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshParcels();
                    }
                });

            }
        });
        rightPanel.add(newParcelButton);

        var statusButton = new JButton("Delivery Status");
        statusButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        statusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(statusButton);

        var infoButton = new JButton("Parcel Info");
        infoButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(infoButton);

        var logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.dispose();
            }
        });
        rightPanel.add(logoutButton);

        add(rightPanel, BorderLayout.LINE_END);
    }

    private void addParcels() {
        var parcels = parcelController.getParcels();
        for (int i = 0; i < parcels.size(); i++) {
            var parcel = parcels.get(i);
            var parcelButton = new JRadioButton((i + 1) + ". " + parcel.parcelId);
            parcelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            parcelButton.setActionCommand(parcel.parcelId);
            buttonsPanel.add(parcelButton);
            buttonsGroup.add(parcelButton);
        }
    }
    
    private void refreshParcels() {
        buttonsPanel.removeAll();
        buttonsGroup = new ButtonGroup();
        addParcels();
        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        var parcelController = new ParcelController();
                        var mainFrame = new MainFrame(parcelController);
                        mainFrame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
