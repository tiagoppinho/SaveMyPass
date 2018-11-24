package app;

import handlers.KeyboardHandler;
import handlers.DatabaseHandler;
import utils.Customization;
import utils.Constants;
import crypto.Hasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 * @author Tiago Pinho
 */
public class NewPin extends javax.swing.JFrame {

    private int index;

    // Virtual keyboard handler.
    private boolean isKeyboardOpen = false;
    private JLabel[] keyboardButtons;

    private String currentMasterPin = null, currentSalt = null;

    private Connection connection;

    // Variables declaration - do not modify
    // DO NOT convert any of the components variables to a local variable or field.
    private javax.swing.JLabel backToLogin;
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnCloseKeyboard;
    private javax.swing.JLabel btnFinishNewPin;
    private javax.swing.JLabel btnMainClose;
    private javax.swing.JLabel btnNextOrFinish;
    private javax.swing.JLabel btnSecondaryClose;
    private javax.swing.JPanel changePINPanel;
    private javax.swing.JLabel gotoLogin;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel keyboardHeaderPanel;
    private javax.swing.JPanel keyboardMainPanel;
    private javax.swing.JLabel lblNum0;
    private javax.swing.JLabel lblNum1;
    private javax.swing.JLabel lblNum2;
    private javax.swing.JLabel lblNum3;
    private javax.swing.JLabel lblNum4;
    private javax.swing.JLabel lblNum5;
    private javax.swing.JLabel lblNum6;
    private javax.swing.JLabel lblNum7;
    private javax.swing.JLabel lblNum8;
    private javax.swing.JLabel lblNum9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel separator;
    private javax.swing.JLabel separator2;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JPasswordField txtConfirmationMasterPin;
    private javax.swing.JPasswordField txtConfirmationNewMasterPin;
    private javax.swing.JPasswordField txtCurrentPin;
    private javax.swing.JPasswordField txtMasterPin;
    private javax.swing.JPasswordField txtNewMasterPin;
    // End of variables declaration

    // 0 - Forgot PIN
    // 1 - First Time
    // 2 - Change PIN
    public NewPin(int index) {
        this.index = index;
        this.connection = DatabaseHandler.getConnection();
        Customization.applyCustomIcons(this);
        initComponents();
        this.keyboardButtons =
                new JLabel[] { btnClear, lblNum0, lblNum1, lblNum2, lblNum3, lblNum4, lblNum5, lblNum6, lblNum7, lblNum8,
                        lblNum9 };
        changePINPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Init components">
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMainClose = new javax.swing.JLabel();
        keyboardMainPanel = new javax.swing.JPanel();
        btnCloseKeyboard = new javax.swing.JLabel();
        lblNum1 = new javax.swing.JLabel();
        lblNum2 = new javax.swing.JLabel();
        lblNum3 = new javax.swing.JLabel();
        lblNum4 = new javax.swing.JLabel();
        lblNum5 = new javax.swing.JLabel();
        lblNum6 = new javax.swing.JLabel();
        lblNum7 = new javax.swing.JLabel();
        lblNum8 = new javax.swing.JLabel();
        lblNum9 = new javax.swing.JLabel();
        lblNum0 = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        keyboardHeaderPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnSecondaryClose = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        txtMasterPin = new javax.swing.JPasswordField();
        title1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtConfirmationMasterPin = new javax.swing.JPasswordField();
        btnNextOrFinish = new javax.swing.JLabel();
        backToLogin = new javax.swing.JLabel();
        separator = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        changePINPanel = new javax.swing.JPanel();
        txtNewMasterPin = new javax.swing.JPasswordField();
        title2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtConfirmationNewMasterPin = new javax.swing.JPasswordField();
        btnFinishNewPin = new javax.swing.JLabel();
        separator2 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        txtCurrentPin = new javax.swing.JPasswordField();
        gotoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SaveMyPass - New PIN");
        setMinimumSize(new java.awt.Dimension(377, 409));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(377, 409));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown();
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerPanelMouseClicked();
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", Font.BOLD, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SaveMyPass");

        jLabel2.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password Manager");

        jLabel3.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Privacy_48px_white.png")));

        btnMainClose.setFont(new java.awt.Font("Arial", Font.PLAIN, 22));
        btnMainClose.setForeground(new java.awt.Color(255, 255, 255));
        btnMainClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel_24px_white.png")));
        btnMainClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMainClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMainCloseMousePressed();
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        headerPanelLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel3).addGap(8, 8, 8)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerPanelLayout.createSequentialGroup().addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101,
                                                        Short.MAX_VALUE).addComponent(btnMainClose).addGap(18, 18, 18)).addGroup(
                                                headerPanelLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(jLabel2)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)))));
        headerPanelLayout.setVerticalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addGroup(
                        headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                headerPanelLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(
                                        headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3).addGroup(
                                                headerPanelLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(jLabel1)
                                                        .addGap(2, 2, 2).addComponent(jLabel2)))).addGroup(
                                headerPanelLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(btnMainClose)))
                        .addContainerGap(43, Short.MAX_VALUE)));

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 380, 120);

        keyboardMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnCloseKeyboard.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        btnCloseKeyboard.setForeground(new java.awt.Color(51, 153, 255));
        btnCloseKeyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Back To_24px.png")));
        btnCloseKeyboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCloseKeyboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCloseKeyboardMousePressed();
            }
        });

        lblNum1.setBackground(new java.awt.Color(51, 153, 255));
        lblNum1.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum1.setForeground(new java.awt.Color(255, 255, 255));
        lblNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1.setText("1");
        lblNum1.setOpaque(true);

        lblNum2.setBackground(new java.awt.Color(51, 153, 255));
        lblNum2.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum2.setForeground(new java.awt.Color(255, 255, 255));
        lblNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2.setText("2");
        lblNum2.setOpaque(true);

        lblNum3.setBackground(new java.awt.Color(51, 153, 255));
        lblNum3.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum3.setForeground(new java.awt.Color(255, 255, 255));
        lblNum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum3.setText("3");
        lblNum3.setOpaque(true);

        lblNum4.setBackground(new java.awt.Color(51, 153, 255));
        lblNum4.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum4.setForeground(new java.awt.Color(255, 255, 255));
        lblNum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum4.setText("4");
        lblNum4.setOpaque(true);

        lblNum5.setBackground(new java.awt.Color(51, 153, 255));
        lblNum5.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum5.setForeground(new java.awt.Color(255, 255, 255));
        lblNum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum5.setText("5");
        lblNum5.setOpaque(true);

        lblNum6.setBackground(new java.awt.Color(51, 153, 255));
        lblNum6.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum6.setForeground(new java.awt.Color(255, 255, 255));
        lblNum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum6.setText("6");
        lblNum6.setOpaque(true);

        lblNum7.setBackground(new java.awt.Color(51, 153, 255));
        lblNum7.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum7.setForeground(new java.awt.Color(255, 255, 255));
        lblNum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum7.setText("7");
        lblNum7.setOpaque(true);

        lblNum8.setBackground(new java.awt.Color(51, 153, 255));
        lblNum8.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum8.setForeground(new java.awt.Color(255, 255, 255));
        lblNum8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum8.setText("8");
        lblNum8.setOpaque(true);

        lblNum9.setBackground(new java.awt.Color(51, 153, 255));
        lblNum9.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum9.setForeground(new java.awt.Color(255, 255, 255));
        lblNum9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum9.setText("9");
        lblNum9.setOpaque(true);

        lblNum0.setBackground(new java.awt.Color(51, 153, 255));
        lblNum0.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        lblNum0.setForeground(new java.awt.Color(255, 255, 255));
        lblNum0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum0.setText("0");
        lblNum0.setOpaque(true);

        btnClear.setBackground(new java.awt.Color(51, 153, 255));
        btnClear.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClear.setText("Clear");
        btnClear.setOpaque(true);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClearMousePressed();
            }
        });

        javax.swing.GroupLayout keyboardMainPanelLayout = new javax.swing.GroupLayout(keyboardMainPanel);
        keyboardMainPanel.setLayout(keyboardMainPanelLayout);
        keyboardMainPanelLayout.setHorizontalGroup(
                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        keyboardMainPanelLayout.createSequentialGroup().addGroup(
                                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCloseKeyboard).addGroup(
                                        keyboardMainPanelLayout.createSequentialGroup().addGap(54, 54, 54).addGroup(
                                                keyboardMainPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                        keyboardMainPanelLayout.createSequentialGroup()
                                                                .addComponent(lblNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                                        keyboardMainPanelLayout.createSequentialGroup()
                                                                .addComponent(lblNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                                        keyboardMainPanelLayout.createSequentialGroup()
                                                                .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addGap(10, 10, 10)
                                                                .addComponent(lblNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                                        keyboardMainPanelLayout.createSequentialGroup()
                                                                .addComponent(lblNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(55, Short.MAX_VALUE)));
        keyboardMainPanelLayout.setVerticalGroup(
                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        keyboardMainPanelLayout.createSequentialGroup().addGap(48, 48, 48).addGroup(
                                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(
                                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(
                                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(
                                keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCloseKeyboard).addContainerGap(46, Short.MAX_VALUE)));

        getContentPane().add(keyboardMainPanel);
        keyboardMainPanel.setBounds(380, 120, 240, 290);

        keyboardHeaderPanel.setBackground(new java.awt.Color(0, 39, 255));

        jLabel9.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Virtual Keyboard");

        btnSecondaryClose.setFont(new java.awt.Font("Arial", Font.PLAIN, 22));
        btnSecondaryClose.setForeground(new java.awt.Color(255, 255, 255));
        btnSecondaryClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel_24px_white.png")));
        btnSecondaryClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSecondaryClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSecondaryCloseMousePressed();
            }
        });

        javax.swing.GroupLayout keyboardHeaderPanelLayout = new javax.swing.GroupLayout(keyboardHeaderPanel);
        keyboardHeaderPanel.setLayout(keyboardHeaderPanelLayout);
        keyboardHeaderPanelLayout.setHorizontalGroup(
                keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                keyboardHeaderPanelLayout.createSequentialGroup().addContainerGap().addGroup(
                                        keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(keyboardHeaderPanelLayout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE).addComponent(btnSecondaryClose))
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 210,
                                                        Short.MAX_VALUE)).addGap(20, 20, 20)));
        keyboardHeaderPanelLayout.setVerticalGroup(
                keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                keyboardHeaderPanelLayout.createSequentialGroup().addGap(19, 19, 19)
                                        .addComponent(btnSecondaryClose)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(jLabel9).addContainerGap()));

        getContentPane().add(keyboardHeaderPanel);
        keyboardHeaderPanel.setBounds(380, 0, 240, 120);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMinimumSize(new java.awt.Dimension(380, 265));
        mainPanel.setPreferredSize(new java.awt.Dimension(380, 265));
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed();
            }
        });
        mainPanel.setLayout(null);

        txtMasterPin.setEditable(false);
        txtMasterPin.setBackground(new java.awt.Color(255, 255, 255));
        txtMasterPin.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        txtMasterPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMasterPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMasterPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMasterPinMousePressed();
            }
        });
        mainPanel.add(txtMasterPin);
        txtMasterPin.setBounds(103, 61, 173, 27);

        title1.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        title1.setForeground(new java.awt.Color(51, 153, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title1.setText("New master PIN");
        mainPanel.add(title1);
        title1.setBounds(103, 38, 170, 17);

        jLabel10.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        jLabel10.setForeground(new java.awt.Color(51, 153, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Confirm master PIN");
        mainPanel.add(jLabel10);
        jLabel10.setBounds(103, 118, 173, 17);

        txtConfirmationMasterPin.setEditable(false);
        txtConfirmationMasterPin.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirmationMasterPin.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        txtConfirmationMasterPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmationMasterPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtConfirmationMasterPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtConfirmationMasterPinMousePressed();
            }
        });
        mainPanel.add(txtConfirmationMasterPin);
        txtConfirmationMasterPin.setBounds(103, 141, 173, 27);

        btnNextOrFinish.setBackground(new java.awt.Color(51, 153, 255));
        btnNextOrFinish.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        btnNextOrFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnNextOrFinish.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNextOrFinish.setText("Finish");
        btnNextOrFinish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextOrFinish.setMaximumSize(new java.awt.Dimension(61, 37));
        btnNextOrFinish.setMinimumSize(new java.awt.Dimension(61, 37));
        btnNextOrFinish.setOpaque(true);
        btnNextOrFinish.setPreferredSize(new java.awt.Dimension(61, 37));
        btnNextOrFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextOrFinishMousePressed();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextOrFinishMouseExited();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextOrFinishMouseEntered();
            }
        });
        mainPanel.add(btnNextOrFinish);
        btnNextOrFinish.setBounds(154, 186, 61, 37);

        backToLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        backToLogin.setForeground(new java.awt.Color(51, 153, 255));
        backToLogin.setText("Back to login");
        backToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToLoginMousePressed();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backToLoginMouseExited();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backToLoginMouseEntered();
            }
        });
        mainPanel.add(backToLogin);
        backToLogin.setBounds(21, 255, 91, 15);

        separator.setBackground(new java.awt.Color(255, 255, 255));
        separator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separator.setOpaque(true);
        mainPanel.add(separator);
        separator.setBounds(366, 12, 2, 266);

        jLabel4.setFont(new java.awt.Font("Arial", Font.PLAIN, 11));
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("6-Digit Pin");
        mainPanel.add(jLabel4);
        jLabel4.setBounds(103, 92, 57, 14);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 120, 380, 290);

        changePINPanel.setBackground(new java.awt.Color(255, 255, 255));
        changePINPanel.setMinimumSize(new java.awt.Dimension(380, 265));
        changePINPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePINPanelMousePressed();
            }
        });

        txtNewMasterPin.setEditable(false);
        txtNewMasterPin.setBackground(new java.awt.Color(255, 255, 255));
        txtNewMasterPin.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        txtNewMasterPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNewMasterPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNewMasterPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNewMasterPinMousePressed();
            }
        });

        title2.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        title2.setForeground(new java.awt.Color(51, 153, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title2.setText("New master PIN");

        jLabel11.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        jLabel11.setForeground(new java.awt.Color(51, 153, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Confirm master PIN");

        txtConfirmationNewMasterPin.setEditable(false);
        txtConfirmationNewMasterPin.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirmationNewMasterPin.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        txtConfirmationNewMasterPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmationNewMasterPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtConfirmationNewMasterPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtConfirmationNewMasterPinMousePressed();
            }
        });

        btnFinishNewPin.setBackground(new java.awt.Color(51, 153, 255));
        btnFinishNewPin.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        btnFinishNewPin.setForeground(new java.awt.Color(255, 255, 255));
        btnFinishNewPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFinishNewPin.setText("Finish");
        btnFinishNewPin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinishNewPin.setMaximumSize(new java.awt.Dimension(61, 37));
        btnFinishNewPin.setMinimumSize(new java.awt.Dimension(61, 37));
        btnFinishNewPin.setOpaque(true);
        btnFinishNewPin.setPreferredSize(new java.awt.Dimension(61, 37));
        btnFinishNewPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFinishNewPinMousePressed();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinishNewPinMouseExited();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinishNewPinMouseEntered();
            }
        });

        separator2.setBackground(new java.awt.Color(255, 255, 255));
        separator2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separator2.setOpaque(true);

        title3.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        title3.setForeground(new java.awt.Color(51, 153, 255));
        title3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title3.setText("Current PIN");

        txtCurrentPin.setEditable(false);
        txtCurrentPin.setBackground(new java.awt.Color(255, 255, 255));
        txtCurrentPin.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        txtCurrentPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCurrentPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCurrentPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCurrentPinMousePressed();
            }
        });

        gotoLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        gotoLogin.setForeground(new java.awt.Color(51, 153, 255));
        gotoLogin.setText("Go to login");
        gotoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gotoLoginMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                gotoLoginMouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                gotoLoginMousePressed();
            }
        });

        javax.swing.GroupLayout changePINPanelLayout = new javax.swing.GroupLayout(changePINPanel);
        changePINPanel.setLayout(changePINPanelLayout);
        changePINPanelLayout.setHorizontalGroup(
                changePINPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        changePINPanelLayout.createSequentialGroup().addGroup(
                                changePINPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                        changePINPanelLayout.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
                                                .addGroup(changePINPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                changePINPanelLayout.createSequentialGroup().addGap(52, 52, 52)
                                                                        .addComponent(btnFinishNewPin,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(60, 60, 60))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePINPanelLayout
                                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtNewMasterPin,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(
                                                                        changePINPanelLayout.createSequentialGroup()
                                                                                .addGap(1, 1, 1).addComponent(jLabel11,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(txtConfirmationNewMasterPin,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtCurrentPin,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(93, 93, 93)).addGroup(
                                        changePINPanelLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(gotoLogin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        changePINPanelLayout.setVerticalGroup(changePINPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changePINPanelLayout.createSequentialGroup().addContainerGap().addGroup(
                        changePINPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(separator2, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                changePINPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(title3)
                                        .addGap(6, 6, 6).addComponent(txtCurrentPin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(title2).addGap(6, 6, 6)
                                        .addComponent(txtNewMasterPin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(jLabel11).addGap(6, 6, 6)
                                        .addComponent(txtConfirmationNewMasterPin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(btnFinishNewPin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4).addComponent(gotoLogin).addGap(8, 8, 8))).addContainerGap()));

        getContentPane().add(changePINPanel);
        changePINPanel.setBounds(0, 120, 380, 290);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void formComponentShown() {
        Customization.applyDraggability(headerPanel, this);
        Customization.underlineText(backToLogin);
        Customization.underlineText(gotoLogin);
        KeyboardHandler.applyVirtualKeyboardButtonsProperties(keyboardButtons);
        KeyboardHandler.generateNewNumbersForKeyboard(keyboardButtons);

        // If it's first time
        if (index == 1) {
            title1.setText("Create a master PIN");
            btnNextOrFinish.setText("Next");
            this.setTitle("SaveMyPass - First-time setup");
            this.setSize(Constants.NEW_PIN_DEFAULT_SIZE_FIRST_TIME);
            backToLogin.setVisible(false);
        } else if (index == 2) {
            mainPanel.setVisible(false);
            changePINPanel.setVisible(true);
            this.setTitle("SaveMyPass - Change PIN");
            loadCurrentPin();
        }

        // Adds the event listener of clicking on the virtual keyboard buttons.
        /*  Only applies the event listener when i > 0, because the first
        element of the array is the clear button.  */
        int i = 0;
        for (JLabel keyboardButton : keyboardButtons) {
            if (i > 0) {
                keyboardButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        keyboardButtonsMousePressed(evt);
                    }
                });
            }
            i++;
        }
    }

    private void headerPanelMouseClicked() {
        closeVirtualKeyboard();
    }

    private void btnNextOrFinishMouseEntered() {
        btnNextOrFinish.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void btnNextOrFinishMouseExited() {
        btnNextOrFinish.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }

    private void btnMainCloseMousePressed() {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    private void btnSecondaryCloseMousePressed() {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    private void mainPanelMousePressed() {
        closeVirtualKeyboard();
    }

    private void btnClearMousePressed() {
        clearPinFields();
    }

    private void btnCloseKeyboardMousePressed() {
        closeVirtualKeyboard();
    }

    private void txtMasterPinMousePressed() {
        openVirtualKeyboard();
    }

    private void txtConfirmationMasterPinMousePressed() {
        if (getCurrentPin(txtMasterPin).length() == 6)
            openVirtualKeyboard();
    }

    private void btnNextOrFinishMousePressed() {
        String pin = getCurrentPin(txtMasterPin).trim(), confirmationPin = getCurrentPin(txtConfirmationMasterPin).trim(), salt =
                Hasher.generateSalt(), hashedPin = Hasher.hashPin(pin, salt);

        if (pin.isEmpty() || confirmationPin.isEmpty())
            Customization.displayWarningMessage("Please fill both PIN fields.", "Empty PIN field(s)!");
        else if (!pin.equals(confirmationPin)) {
            // If pin and confirmationPin don't match.
            Customization.displayWarningMessage("The PINs don't match.", "Invalid!");
            clearPinFields();
        } else if (index == 0) {
            // If user forgot his pin.
            updatePinOnDatabase(hashedPin, salt);
            // Proceed to login.
            goToLogin();
        } else {
            // If it's the first time setup.
            Setup firstTimeSetup = new Setup(hashedPin, salt);
            firstTimeSetup.setVisible(true);
            this.dispose();
        }
    }

    private void backToLoginMousePressed() {
        goToLogin();
    }

    private void backToLoginMouseEntered() {
        backToLogin.setForeground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void backToLoginMouseExited() {
        backToLogin.setForeground(Constants.BUTTONS_DEFAULT_COLOR);
    }

    private void txtNewMasterPinMousePressed() {
        if (getCurrentPin(txtCurrentPin).length() == 6)
            openVirtualKeyboard();
    }

    private void txtConfirmationNewMasterPinMousePressed() {
        if (getCurrentPin(txtNewMasterPin).length() == 6)
            openVirtualKeyboard();
    }

    private void changePINPanelMousePressed() {
        closeVirtualKeyboard();
    }

    private void txtCurrentPinMousePressed() {
        openVirtualKeyboard();
    }

    private void btnFinishNewPinMousePressed() {
        String currentPin = getCurrentPin(txtCurrentPin).trim(), newMasterPin = getCurrentPin(txtNewMasterPin).trim(),
                confirmationNewMasterPin = getCurrentPin(txtConfirmationNewMasterPin).trim(), hashedCurrentPin =
                Hasher.hashPin(currentPin, currentSalt), newSalt = Hasher.generateSalt(), hashedNewPin =
                Hasher.hashPin(newMasterPin, newSalt);

        if (currentPin.isEmpty() || newMasterPin.isEmpty() || confirmationNewMasterPin.isEmpty())
            Customization.displayWarningMessage("Please fill all PIN fields.", "Empty PIN field(s)!");
        else if (!hashedCurrentPin.equals(currentMasterPin)) {
            // If the current pin doesn't match the database.
            Customization.displayWarningMessage("The current pin is wrong.", "Invalid!");
            clearPinFields();
        } else if (!newMasterPin.equals(confirmationNewMasterPin)) {
            // If new master pin doesn't match the confirmation.
            Customization.displayWarningMessage("The new pins don't match.", "Invalid!");
            clearPinFields();
        } else {
            // Send data to database.
            updatePinOnDatabase(hashedNewPin, newSalt);
            // Proceed to login.
            goToLogin();
        }
    }

    private void btnFinishNewPinMouseExited() {
        btnFinishNewPin.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }

    private void btnFinishNewPinMouseEntered() {
        btnFinishNewPin.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void gotoLoginMouseEntered() {
        gotoLogin.setForeground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void gotoLoginMouseExited() {
        gotoLogin.setForeground(Constants.BUTTONS_DEFAULT_COLOR);
    }

    private void gotoLoginMousePressed() {
        goToLogin();
    }

    /**
     * If the virtual keyboard is closed, opens it.
     * Sets different window sizes on opening, depending on the index.
     */
    private void openVirtualKeyboard() {
        if (!isKeyboardOpen) {
            isKeyboardOpen = true;
            // If is first time.
            if (index == 1)
                this.setSize(Constants.NEW_PIN_SIZE_WITH_KEYBOARD_FIRST_TIME);
            else
                this.setSize(Constants.NEW_PIN_SIZE_WITH_KEYBOARD);

            btnMainClose.setVisible(false);

            if (index != 2)
                separator.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_OPEN);
            else
                separator2.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_OPEN);

            KeyboardHandler.generateNewNumbersForKeyboard(keyboardButtons);
        }
    }

    /**
     * If the virtual keyboard is opened, closes it.
     * Sets different window sizes on closing, depending on the index.
     */
    private void closeVirtualKeyboard() {
        if (isKeyboardOpen) {
            isKeyboardOpen = false;
            // If is first time.
            if (index == 1)
                this.setSize(Constants.NEW_PIN_DEFAULT_SIZE_FIRST_TIME);
            else
                this.setSize(Constants.NEW_PIN_DEFAULT_SIZE);

            btnMainClose.setVisible(true);

            if (index != 2)
                separator.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_CLOSE);
            else
                separator2.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_CLOSE);
        }
    }

    /**
     * Handles the mouse pressed event of the keyboard buttons.
     * Acts differently according to the index.
     *
     * @param evt MouseEvent
     */
    private void keyboardButtonsMousePressed(java.awt.event.MouseEvent evt) {
        JLabel button = (JLabel) evt.getComponent();
        String buttonNumber = button.getText();

        // Checks if the next number can fit into the 6-digit pin.
        // Passes to the next field when the previous is full.
        // Closes virtual keyboard when every field is full.
        if (index != 2) {
            int pinCurrentLength = getCurrentPin(txtMasterPin).length();
            int confirmPinCurrentLength = getCurrentPin(txtConfirmationMasterPin).length();

            if (pinCurrentLength + 1 <= 6)
                addNumberToPin(buttonNumber, txtMasterPin);
            else if (confirmPinCurrentLength + 1 < 6)
                addNumberToPin(buttonNumber, txtConfirmationMasterPin);
            else if (confirmPinCurrentLength + 1 == 6) {
                addNumberToPin(buttonNumber, txtConfirmationMasterPin);
                closeVirtualKeyboard();
            } else
                closeVirtualKeyboard();
        } else {
            int currentPinFieldLength = getCurrentPin(txtCurrentPin).length();
            int newPinFieldLength = getCurrentPin(txtNewMasterPin).length();
            int confirmNewPinFieldLength = getCurrentPin(txtConfirmationNewMasterPin).length();

            if (currentPinFieldLength + 1 <= 6)
                addNumberToPin(buttonNumber, txtCurrentPin);
            else if (newPinFieldLength + 1 <= 6)
                addNumberToPin(buttonNumber, txtNewMasterPin);
            else if (confirmNewPinFieldLength + 1 < 6) {
                addNumberToPin(buttonNumber, txtConfirmationNewMasterPin);
            } else if (confirmNewPinFieldLength + 1 == 6) {
                addNumberToPin(buttonNumber, txtConfirmationNewMasterPin);
                closeVirtualKeyboard();
            } else
                closeVirtualKeyboard();
        }
    }

    /**
     * Adds the new number entered by the virtual keyboard to the given pin field.
     *
     * @param number        Number to be added to the pin field.
     * @param passwordField Pin field to receive the number.
     */
    private void addNumberToPin(String number, JPasswordField passwordField) {
        String currentPin = getCurrentPin(passwordField);
        passwordField.setText(currentPin + number);
    }

    /**
     * Gets the current pin of a given pin field and returns it as a string.
     *
     * @param passwordField Pin field to get the current pin.
     * @return String
     */
    private String getCurrentPin(JPasswordField passwordField) {
        return String.valueOf(passwordField.getPassword()).trim();
    }

    /**
     * Sets the pin fields text as null.
     * Acts in different pin fields according to the index.
     */
    private void clearPinFields() {
        if (index == 2) {
            txtCurrentPin.setText(null);
            txtNewMasterPin.setText(null);
            txtConfirmationNewMasterPin.setText(null);
        } else {
            txtMasterPin.setText(null);
            txtConfirmationMasterPin.setText(null);
        }
    }

    /**
     * Sends the user to Login Frame.
     */
    private void goToLogin() {
        new Login();
        this.dispose();
    }

    /**
     * Updates the master pin and salt on database.
     *
     * @param pin  New master pin.
     * @param salt New salt.
     */
    private void updatePinOnDatabase(String pin, String salt) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET pin = ?, salt = ?");
            statement.setString(1, pin);
            statement.setString(2, salt);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads the current master pin and salt on database.
     */
    private void loadCurrentPin() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pin, salt FROM User");
            resultSet.next();
            this.currentMasterPin = resultSet.getString("pin");
            this.currentSalt = resultSet.getString("salt");
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        /* Set the theme look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
    }

}
