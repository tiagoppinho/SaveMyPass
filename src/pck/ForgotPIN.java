package pck;

import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Pinho
 */
public class ForgotPIN extends javax.swing.JFrame {

    public ForgotPIN() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        setMinimumSize(new java.awt.Dimension(377, 430));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(377, 430));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SaveMyPass");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password Manager");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Privacy_48px_white.png"))); // NOI18N

        close.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Cancel_24px_white.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(close)
                        .addGap(19, 19, 19))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2))))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(close)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 380, 120);

        securityQuestionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        securityQuestionsPanel.setMinimumSize(new java.awt.Dimension(380, 310));
        securityQuestionsPanel.setPreferredSize(new java.awt.Dimension(380, 310));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 153, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("1 - Security question:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Answer:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Answer:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 153, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("2 - Security question:");

        btnNext.setBackground(new java.awt.Color(51, 153, 255));
        btnNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextMousePressed(evt);
            }
        });

        txtSecondSecurityQuestion.setEditable(false);
        txtSecondSecurityQuestion.setText("Second security question");

        txtFirstSecurityQuestion.setEditable(false);
        txtFirstSecurityQuestion.setText("First security question");

        gotoLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gotoLogin.setForeground(new java.awt.Color(51, 153, 255));
        gotoLogin.setText("Back to login");
        gotoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gotoLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gotoLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gotoLoginMousePressed(evt);
            }
        });

        javax.swing.GroupLayout securityQuestionsPanelLayout = new javax.swing.GroupLayout(securityQuestionsPanel);
        securityQuestionsPanel.setLayout(securityQuestionsPanelLayout);
        securityQuestionsPanelLayout.setHorizontalGroup(
            securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                .addGroup(securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gotoLogin))
                    .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, securityQuestionsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSecurityAnswer2)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSecurityAnswer1)
                                .addComponent(txtSecondSecurityQuestion)
                                .addComponent(txtFirstSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        securityQuestionsPanelLayout.setVerticalGroup(
            securityQuestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecurityAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecondSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecurityAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gotoLogin)
                .addContainerGap())
        );

        getContentPane().add(securityQuestionsPanel);
        securityQuestionsPanel.setBounds(0, 120, 380, 310);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
        Customization.underlineText(gotoLogin);
        /*
            Get data from database:
              - First security question.
              - Second security question.
        
            Apply data to the fields.
        */
    }//GEN-LAST:event_formComponentShown

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        btnNext.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        btnNext.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnNextMouseExited

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        System.exit(0);
    }//GEN-LAST:event_closeMousePressed

    private void btnNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMousePressed
        String firstSecurityAnswer = txtSecurityAnswer1.getText().trim();
        String secondSecurityAnswer = txtSecurityAnswer2.getText().trim();
        
        if(firstSecurityAnswer.length() == 0 || secondSecurityAnswer.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please fill both answers.", "Empty answer(s)!", JOptionPane.WARNING_MESSAGE);
        } else {
            /*
                If they don't match the database answers:
                    Tell user that one or more answers are not correct.
                    JOptionPane.showMessageDialog(null, "Please check your answers and try again!", "Wrong answer(s)!", JOptionPane.WARNING_MESSAGE);
            */
            NewPIN forgotNewPIN = new NewPIN(0);
            forgotNewPIN.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnNextMousePressed

    private void gotoLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoLoginMousePressed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gotoLoginMousePressed

    private void gotoLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoLoginMouseEntered
        gotoLogin.setForeground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_gotoLoginMouseEntered

    private void gotoLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoLoginMouseExited
        gotoLogin.setForeground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_gotoLoginMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the theme look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
