package pck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Tiago Pinho
 */
public class RecoverMethodsSetup extends javax.swing.JFrame {
    
    private String pin = null;

    public RecoverMethodsSetup() {
        initComponents();
    }
    
    public RecoverMethodsSetup(String pin) {
        initComponents();
        this.pin = pin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnFinish = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        securityQuestion1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        securityAnswer1 = new javax.swing.JTextField();
        securityAnswer2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        securityQuestion2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveMyPass - First-time setup");
        setMinimumSize(new java.awt.Dimension(377, 440));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(377, 440));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(close)
                        .addGap(20, 20, 20))
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

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMinimumSize(new java.awt.Dimension(380, 320));
        mainPanel.setPreferredSize(new java.awt.Dimension(380, 320));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("How can you recover your master PIN?");

        btnFinish.setBackground(new java.awt.Color(51, 153, 255));
        btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinishMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinishMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFinishMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Finish");

        javax.swing.GroupLayout btnFinishLayout = new javax.swing.GroupLayout(btnFinish);
        btnFinish.setLayout(btnFinishLayout);
        btnFinishLayout.setHorizontalGroup(
            btnFinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFinishLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btnFinishLayout.setVerticalGroup(
            btnFinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFinishLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 153, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setLabelFor(securityQuestion1);
        jLabel12.setText("1 - Security question:");

        securityQuestion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What was your favorite place to visit as a child?", "Who is your favorite actor, musician, or artist?", "What is the name of your first pet?", "Where were you born?" }));
        securityQuestion1.setMinimumSize(new java.awt.Dimension(700, 100));
        securityQuestion1.setPreferredSize(new java.awt.Dimension(404, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setLabelFor(securityAnswer1);
        jLabel13.setText("Answer:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Answer:");

        securityQuestion2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is the name of your favorite pet?", "What is your favorite movie?", "What is your favorite song?", "What is your favorite book?" }));
        securityQuestion2.setMinimumSize(new java.awt.Dimension(700, 100));
        securityQuestion2.setPreferredSize(new java.awt.Dimension(404, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 153, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setLabelFor(securityQuestion1);
        jLabel16.setText("2 - Security question:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(securityQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(securityAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(securityQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(securityAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(securityQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(securityAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(securityQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(securityAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 120, 380, 320);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
    }//GEN-LAST:event_formComponentShown

    private void btnFinishMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseEntered
        btnFinish.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnFinishMouseEntered

    private void btnFinishMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseExited
        btnFinish.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnFinishMouseExited

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        System.exit(0);
    }//GEN-LAST:event_closeMousePressed

    private void btnFinishMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMousePressed
        String firstSecurityQuestion = String.valueOf(securityQuestion1.getSelectedItem()).trim();
        String secondSecurityQuestion = String.valueOf(securityQuestion2.getSelectedItem()).trim();
        String firstSecurityAnswer = securityAnswer1.getText().trim();
        String secondSecurityAnswer = securityAnswer2.getText().trim();
        
        if(firstSecurityAnswer.isEmpty() || secondSecurityAnswer.isEmpty())
            Customization.displayWarningMessage("Please fill both answers.", "Empty answer(s)!");
        else if(!pin.isEmpty()){
            //Hash data.
            String salt = Hasher.generateSalt(),
                   hashedPin = Hasher.hashPin(pin, salt),
                   hashedFirstSecurityAnswer = Hasher.hashSecurityAnswer(firstSecurityAnswer),
                   hashedSecondSecurityAnswer = Hasher.hashSecurityAnswer(secondSecurityAnswer);
            
            //Send data to database.
            Connection connection = DatabaseHandler.getConnection();
            try{
                PreparedStatement statement = connection.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, hashedPin);
                statement.setString(2, salt);
                statement.setString(3, firstSecurityQuestion);
                statement.setString(4, hashedFirstSecurityAnswer);
                statement.setString(5, secondSecurityQuestion);
                statement.setString(6, hashedSecondSecurityAnswer);
                statement.executeUpdate();
                statement.close();
                connection.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            
            //Proceed to login.
            new Login();
            this.dispose();
        }
    }//GEN-LAST:event_btnFinishMousePressed
    
    
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
            java.util.logging.Logger.getLogger(RecoverMethodsSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecoverMethodsSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecoverMethodsSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecoverMethodsSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecoverMethodsSetup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnFinish;
    private javax.swing.JLabel close;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField securityAnswer1;
    private javax.swing.JTextField securityAnswer2;
    private javax.swing.JComboBox<String> securityQuestion1;
    private javax.swing.JComboBox<String> securityQuestion2;
    // End of variables declaration//GEN-END:variables
}
