package app;

import crypto.Encryptor;
import handlers.PasswordGenerator;
import handlers.DatabaseHandler;
import utils.Customization;
import utils.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * @author Tiago Pinho
 */
public class Card extends javax.swing.JFrame {
    
    private Dashboard dashboard = null;
    private int cardIdentifier = -1, index = 0;
    private final Encryptor encryptor = new Encryptor();
    
    private ArrayList<String> cardTitles = new ArrayList<>(),
                              cardUsernames = new ArrayList<>();
    
    private final String[] VALUES_COLUMNS = {"title", "username", "password"};
    
    //View mode only.
    private String[] oldValues = new String[3];
    private String oldCardTitle, oldCardUsername, oldCardPassword;
       
    public Card(Dashboard dashboard, int cardIdentifier) {
        if(dashboard != null){
            this.dashboard = dashboard;
            
            if(cardIdentifier == -1){
                this.index = 0;
            } else {
                this.index = 1;
                this.cardIdentifier = cardIdentifier;
            }
            
            dashboard.setEnabled(false);
            initComponents();
            load();
            this.setVisible(true);
        } else {
            throw new IllegalArgumentException("Dashboard instance is required.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCardTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        showHidePassword = new javax.swing.JLabel();
        generatePassword = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        btnAddOrSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SaveMyPass - New Card");
        setMinimumSize(new java.awt.Dimension(379, 348));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(379, 348));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("New Card");

        btnCancel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/img/Cancel_24px_white.png"))); // NOI18N
        btnCancel.setToolTipText("Close/Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setMaximumSize(new java.awt.Dimension(61, 37));
        btnCancel.setMinimumSize(new java.awt.Dimension(61, 37));
        btnCancel.setPreferredSize(new java.awt.Dimension(61, 37));
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 380, 50);

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 128, 255));
        jLabel2.setText("Card Title / Service");

        txtCardTitle.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 128, 255));
        jLabel3.setText("Username / Email");

        txtUsername.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 128, 255));
        jLabel4.setText("Password");

        txtPassword.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        showHidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/img/Eye_24px.png"))); // NOI18N
        showHidePassword.setToolTipText("Show Password");
        showHidePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showHidePassword.setName("Show"); // NOI18N
        showHidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showHidePasswordMousePressed(evt);
            }
        });

        generatePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/img/Restart_20px.png"))); // NOI18N
        generatePassword.setToolTipText("Generate Password");
        generatePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generatePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                generatePasswordMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCardTitle)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showHidePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generatePassword)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCardTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(generatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showHidePassword))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 50, 380, 230);

        footerPanel.setBackground(new java.awt.Color(250, 250, 250));

        btnAddOrSave.setBackground(new java.awt.Color(51, 153, 255));
        btnAddOrSave.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnAddOrSave.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddOrSave.setText("Add");
        btnAddOrSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddOrSave.setMaximumSize(new java.awt.Dimension(61, 37));
        btnAddOrSave.setMinimumSize(new java.awt.Dimension(61, 37));
        btnAddOrSave.setOpaque(true);
        btnAddOrSave.setPreferredSize(new java.awt.Dimension(61, 37));
        btnAddOrSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddOrSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddOrSaveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddOrSaveMousePressed(evt);
            }
        });

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnAddOrSave, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddOrSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(footerPanel);
        footerPanel.setBounds(0, 280, 380, 70);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showHidePasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHidePasswordMousePressed
        if(showHidePassword.getName().equals("Show")) {
            ImageIcon img = new ImageIcon(getClass().getResource("img/Hide_24px.png"));
            showHidePassword.setIcon(img);
            txtPassword.setEchoChar((char)0);
            showHidePassword.setName("Hide");
            showHidePassword.setToolTipText("Hide Password");
        } else {
            ImageIcon img = new ImageIcon(getClass().getResource("img/Eye_24px.png"));
            showHidePassword.setIcon(img);
            txtPassword.setEchoChar('\u25cf');
            showHidePassword.setName("Show");
            showHidePassword.setToolTipText("Show Password");
        }
    }//GEN-LAST:event_showHidePasswordMousePressed

    private void btnCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMousePressed
        close();
    }//GEN-LAST:event_btnCancelMousePressed

    private void btnAddOrSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMouseEntered
        btnAddOrSave.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnAddOrSaveMouseEntered

    private void btnAddOrSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMouseExited
        btnAddOrSave.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnAddOrSaveMouseExited

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
        
        if(index == 1){
            this.setTitle("SaveMyPass - View Card");
            title.setText("View Card");
            btnAddOrSave.setText("Save");
        }
    }//GEN-LAST:event_formComponentShown

    private void btnAddOrSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMousePressed
        String cardTitle = txtCardTitle.getText().trim(), username = txtUsername.getText().trim(),
                   password = String.valueOf(txtPassword.getPassword()).trim();
        
        if(cardTitle.isEmpty() || username.isEmpty() || password.isEmpty()){
            Customization.displayWarningMessage(
                "Please fill all the card fields.",
                "Empty field(s)!"
            );
        }else if(exists(cardTitle, username)){
            Customization.displayWarningMessage(
                "This card already exists. Make sure you're inserting the right values.",
                "Duplicated card!"
            );
        } else {
            if(index == 0){
                Connection connection = DatabaseHandler.getConnection();

                try{
                    PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Cards (title, username, password) VALUES (?, ?, ?)"
                    );
                    statement.setString(1, encryptor.encrypt(cardTitle));
                    statement.setString(2, encryptor.encrypt(username));
                    statement.setString(3, encryptor.encrypt(password));
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
                dashboard.addNewTableRow(
                    dashboard.getAllCardsTableModel(),
                    new String[]{cardTitle, username},
                    true
                );
            } else {
                String[] values = {cardTitle, username, password};
                Connection connection = DatabaseHandler.getConnection();
                PreparedStatement statement;
                
                for(int i = 0; i < values.length; i++){
                    if(!values[i].equals(oldValues[i])){
                        try {
                            statement = connection.prepareStatement(
                                "UPDATE Cards SET " + VALUES_COLUMNS[i] + " = ? WHERE ID = ?"
                            );
                            statement.setString(1, encryptor.encrypt(values[i]));
                            statement.setInt(2, cardIdentifier);
                            statement.executeUpdate();
                            statement.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                
                try{
                    connection.close();
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            dashboard.loadCards();
            close();
        }
    }//GEN-LAST:event_btnAddOrSaveMousePressed

    private void generatePasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generatePasswordMousePressed
        String generatedPassword = new PasswordGenerator().generateRandomSecurePassword();
        txtPassword.setText(generatedPassword);
    }//GEN-LAST:event_generatePasswordMousePressed

    /**
     * Closes this frame and enables dashboard.
     */
    private void close(){
        this.dispose();
        dashboard.setEnabled(true);
        dashboard.requestFocus();
    }
    
    /**
     * Checks if card already exist based on it's title and username.
     * Helps preventing duplicated cards.
     */
    private boolean exists(String title, String username){
        boolean titleExists = false, usernameExists = false;
        
        for (String cardTitle : cardTitles){
            if(cardTitle.equals(title)){
                titleExists = true;
                break;
            }
        }
    
        for(String cardUsername : cardUsernames){
            if(cardUsername.equals(username)){
                usernameExists = true;
                break;
            }
        }
        
        return titleExists && usernameExists;
    }
    
    /**
     * Loads all the needed data to compare with new values.
     */
    private void load(){
        Connection connection = DatabaseHandler.getConnection();
        
        try{
            if(index == 0){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT title, username FROM Cards");
                
                while(resultSet.next()){
                    cardTitles.add(encryptor.decrypt(resultSet.getString("title")));
                    cardUsernames.add(encryptor.decrypt(resultSet.getString("username")));
                }
                
                resultSet.close();
                statement.close();
            } else {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT title, username FROM Cards WHERE ID <> ?"
                );
                statement.setInt(1, cardIdentifier);
                
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    cardTitles.add(encryptor.decrypt(resultSet.getString("title")));
                    cardUsernames.add(encryptor.decrypt(resultSet.getString("username")));
                }
                
                resultSet.close();
                statement.close();
                
                statement = connection.prepareStatement("SELECT title, username, password FROM Cards WHERE ID = ?");
                statement.setInt(1, cardIdentifier);
                
                resultSet = statement.executeQuery();
                
                for(int i = 0; i < oldValues.length; i++)
                    oldValues[i] = encryptor.decrypt(resultSet.getString(VALUES_COLUMNS[i]));
                                
                txtCardTitle.setText(oldValues[0]);
                txtUsername.setText(oldValues[1]);
                txtPassword.setText(oldValues[2]);
                
                resultSet.close();
                statement.close();
            }
            
            connection.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public static void main(String args[]) {
        /* Set the theme look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddOrSave;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel generatePassword;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel showHidePassword;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtCardTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
