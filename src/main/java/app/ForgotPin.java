package app;

import handlers.DatabaseHandler;
import utils.Customization;
import utils.Constants;
import crypto.Hasher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;

/**
 * @author Tiago Pinho
 */
public class ForgotPin extends javax.swing.JFrame {

    private String firstAnswer = null, secondAnswer = null;

    // Components variables declaration - do not modify
    // DO NOT convert any of the components variables to a local variable or field.
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel close;
    private javax.swing.JLabel gotoLogin;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel securityQuestionsPanel;
    private javax.swing.JTextField txtFirstSecurityQuestion;
    private javax.swing.JTextField txtSecondSecurityQuestion;
    private javax.swing.JTextField txtSecurityAnswer1;
    private javax.swing.JTextField txtSecurityAnswer2;
    // End of components variables declaration

    public ForgotPin() {
        Customization.applyCustomIcons(this);
        initComponents();
        load();
    }

    /**
     * Loads all the needed from database.
     */
    private void load() {
        Connection connection = DatabaseHandler.getConnection();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT firstSecurity, firstAnswer, " + "secondSecurity, secondAnswer FROM User");
            resultSet.next();
            txtFirstSecurityQuestion.setText(resultSet.getString("firstSecurity"));
            this.firstAnswer = resultSet.getString("firstAnswer");
            txtSecondSecurityQuestion.setText(resultSet.getString("secondSecurity"));
            this.secondAnswer = resultSet.getString("secondAnswer");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Init components">
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        securityQuestionsPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSecurityAnswer1 = new javax.swing.JTextField();
        txtSecurityAnswer2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        txtSecondSecurityQuestion = new javax.swing.JTextField();
        txtFirstSecurityQuestion = new javax.swing.JTextField();
        gotoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveMyPass - Forgot PIN");
        setMaximumSize(new java.awt.Dimension(377, 439));
        setMinimumSize(new java.awt.Dimension(377, 439));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(377, 439));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown();
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));

        jLabel1.setFont(new java.awt.Font("Arial", Font.BOLD, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SaveMyPass");

        jLabel2.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password Manager");

        jLabel3.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Privacy_48px_white.png")));

        close.setFont(new java.awt.Font("Arial", Font.PLAIN, 22));
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel_24px_white.png")));
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed();
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup().addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8).addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup().addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addGap(19, 19, 19)).addGroup(
                                        headerPanelLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(jLabel2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
        headerPanelLayout.setVerticalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addGroup(
                        headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                headerPanelLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(
                                        headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(
                                                headerPanelLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(jLabel1)
                                                        .addGap(2, 2, 2).addComponent(jLabel2)))).addGroup(
                                headerPanelLayout.createSequentialGroup().addGap(19, 19, 19)
                                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(43, Short.MAX_VALUE)));

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 380, 120);

        securityQuestionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        securityQuestionsPanel.setMinimumSize(new java.awt.Dimension(380, 310));
        securityQuestionsPanel.setPreferredSize(new java.awt.Dimension(380, 310));

        jLabel12.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        jLabel12.setForeground(new java.awt.Color(51, 153, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("1 - Security question:");

        jLabel13.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Answer:");

        jLabel15.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        jLabel15.setForeground(new java.awt.Color(51, 153, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Answer:");

        jLabel16.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        jLabel16.setForeground(new java.awt.Color(51, 153, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("2 - Security question:");

        btnNext.setBackground(new java.awt.Color(51, 153, 255));
        btnNext.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNext.setText("Next");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setMaximumSize(new java.awt.Dimension(61, 37));
        btnNext.setMinimumSize(new java.awt.Dimension(61, 37));
        btnNext.setOpaque(true);
        btnNext.setPreferredSize(new java.awt.Dimension(61, 37));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextMousePressed();
            }
        });

        txtSecondSecurityQuestion.setEditable(false);

        txtFirstSecurityQuestion.setEditable(false);

        gotoLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        gotoLogin.setForeground(new java.awt.Color(51, 153, 255));
        gotoLogin.setText("Back to login");
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

        javax.swing.GroupLayout securityQuestionsPanelLayout = new javax.swing.GroupLayout(securityQuestionsPanel);
        securityQuestionsPanel.setLayout(securityQuestionsPanelLayout);
        securityQuestionsPanelLayout.setHorizontalGroup(
                securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        securityQuestionsPanelLayout.createSequentialGroup().addGroup(
                                securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup().addGap(60, 60, 60)
                                                .addGroup(securityQuestionsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                securityQuestionsPanelLayout.createSequentialGroup()
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnNext,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(96, 96, 96))
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(
                                                                securityQuestionsPanelLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtSecurityAnswer2).addComponent(jLabel12,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel13,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtSecurityAnswer1)
                                                                        .addComponent(txtSecondSecurityQuestion)
                                                                        .addComponent(txtFirstSecurityQuestion,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 258,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup().addGap(21, 21, 21)
                                                .addComponent(gotoLogin))).addContainerGap(62, Short.MAX_VALUE)));
        securityQuestionsPanelLayout.setVerticalGroup(
                securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        securityQuestionsPanelLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSecurityAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSecondSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSecurityAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(gotoLogin).addContainerGap(17, Short.MAX_VALUE)));

        getContentPane().add(securityQuestionsPanel);
        securityQuestionsPanel.setBounds(0, 120, 380, 320);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void formComponentShown() {
        Customization.applyDraggability(headerPanel, this);
        Customization.underlineText(gotoLogin);
    }

    private void btnNextMouseEntered() {
        btnNext.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void btnNextMouseExited() {
        btnNext.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }

    private void closeMousePressed() {
        System.exit(0);
    }

    private void btnNextMousePressed() {
        String firstSecurityAnswer = txtSecurityAnswer1.getText().trim(), secondSecurityAnswer =
                txtSecurityAnswer2.getText().trim(), hashedFirstSecurityAnswer = Hasher.hashSecurityAnswer(firstSecurityAnswer),
                hashedSecondSecurityAnswer = Hasher.hashSecurityAnswer(secondSecurityAnswer);

        if (firstSecurityAnswer.isEmpty() || secondSecurityAnswer.isEmpty()) {
            Customization.displayWarningMessage("Please fill both answers.", "Empty answer(s)!");
        } else if (!hashedFirstSecurityAnswer.equals(firstAnswer) || !hashedSecondSecurityAnswer.equals(secondAnswer)) {
            Customization.displayWarningMessage("Check your answer(s). They are not correct.", "Invalid answer(s)!");
        } else {
            NewPin forgotNewPIN = new NewPin(0);
            forgotNewPIN.setVisible(true);
            this.dispose();
        }
    }

    private void gotoLoginMousePressed() {
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }

    private void gotoLoginMouseEntered() {
        gotoLogin.setForeground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }

    private void gotoLoginMouseExited() {
        gotoLogin.setForeground(Constants.BUTTONS_DEFAULT_COLOR);
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
            java.util.logging.Logger.getLogger(ForgotPin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
    }

}
