package app;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiago Pinho
 */
public class AddNew extends javax.swing.JFrame {

    private int index = 0;
    private JFrame dashboard = null;
    
    public AddNew() {
        initComponents();
    }
    
    // 0 - New Card.
    // 1 - New Note.
    public AddNew(int index, JFrame dashboard) {
        if(index == 0 || index == 1){
            this.index = index;
            this.dashboard = dashboard;
            dashboard.setEnabled(false);
            initComponents();
            this.setVisible(true);
        } else
            throw new IllegalArgumentException("Index out of range. 0 - New Card. 1 - New Note");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        newCardMainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCardName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        showHidePassword = new javax.swing.JLabel();
        generatePassword = new javax.swing.JLabel();
        newNoteMainPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNoteTitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoteDescription = new javax.swing.JTextArea();
        footerPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SaveMyPass - New Card");
        setMinimumSize(new java.awt.Dimension(379, 348));
        setUndecorated(true);
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

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 380, 50);

        newCardMainPanel.setBackground(new java.awt.Color(250, 250, 250));
        newCardMainPanel.setName("mainPanel"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 128, 255));
        jLabel2.setText("Card Name / Service");

        txtCardName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

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

        javax.swing.GroupLayout newCardMainPanelLayout = new javax.swing.GroupLayout(newCardMainPanel);
        newCardMainPanel.setLayout(newCardMainPanelLayout);
        newCardMainPanelLayout.setHorizontalGroup(
            newCardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCardMainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(newCardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newCardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCardName)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                    .addGroup(newCardMainPanelLayout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showHidePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generatePassword)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        newCardMainPanelLayout.setVerticalGroup(
            newCardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCardMainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCardName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(newCardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newCardMainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(generatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showHidePassword))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(newCardMainPanel);
        newCardMainPanel.setBounds(0, 50, 380, 230);

        newNoteMainPanel.setBackground(new java.awt.Color(250, 250, 250));
        newNoteMainPanel.setName("mainPanel"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 128, 255));
        jLabel5.setText("Note Title");

        txtNoteTitle.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 128, 255));
        jLabel6.setText("Description");

        txtNoteDescription.setColumns(20);
        txtNoteDescription.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNoteDescription.setLineWrap(true);
        txtNoteDescription.setRows(5);
        txtNoteDescription.setTabSize(0);
        txtNoteDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtNoteDescription);

        javax.swing.GroupLayout newNoteMainPanelLayout = new javax.swing.GroupLayout(newNoteMainPanel);
        newNoteMainPanel.setLayout(newNoteMainPanelLayout);
        newNoteMainPanelLayout.setHorizontalGroup(
            newNoteMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newNoteMainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(newNoteMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoteTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        newNoteMainPanelLayout.setVerticalGroup(
            newNoteMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newNoteMainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(newNoteMainPanel);
        newNoteMainPanel.setBounds(0, 50, 380, 230);

        footerPanel.setBackground(new java.awt.Color(250, 250, 250));

        btnCancel.setBackground(new java.awt.Color(153, 153, 153));
        btnCancel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setMaximumSize(new java.awt.Dimension(61, 37));
        btnCancel.setMinimumSize(new java.awt.Dimension(61, 37));
        btnCancel.setOpaque(true);
        btnCancel.setPreferredSize(new java.awt.Dimension(61, 37));
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelMousePressed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setMaximumSize(new java.awt.Dimension(61, 37));
        btnAdd.setMinimumSize(new java.awt.Dimension(61, 37));
        btnAdd.setOpaque(true);
        btnAdd.setPreferredSize(new java.awt.Dimension(61, 37));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMousePressed(evt);
            }
        });

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        btnCancel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        btnCancel.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMousePressed
        this.dispose();
        dashboard.setEnabled(true);
        dashboard.requestFocus();
    }//GEN-LAST:event_btnCancelMousePressed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        btnAdd.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        btnAdd.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnAddMouseExited

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
        
        //If it's a new card.
        if(index == 0) {
            newNoteMainPanel.setVisible(false);
        } else /* If it's a new note */ {
            this.setTitle("SaveMyPass - New Note");
            title.setText("New Note");
            newCardMainPanel.setVisible(false);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        String dataForTable[];
        DefaultTableModel tableModel;
        Connection connection = DatabaseHandler.getConnection();
        PreparedStatement statement;
        
        if(index == 0){
            String cardName = txtCardName.getText(), username = txtUsername.getText(),
                   password = String.valueOf(txtPassword.getPassword());
            
            try{
                statement = connection.prepareStatement("INSERT INTO Cards VALUES (?, ?, ?)");
                statement.setString(1, cardName);
                statement.setString(2, username);
                statement.setString(3, password);
                statement.executeUpdate();
                statement.close();
                connection.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            tableModel = Dashboard.getAllCardsTableModel();
            dataForTable = new String[]{cardName, username};
        } else {
            String noteTitle = txtNoteTitle.getText(), noteDescription = txtNoteDescription.getText();
            
            try{
                statement = connection.prepareStatement("INSERT INTO Notes VALUES (?, ?)");
                statement.setString(1, noteTitle);
                statement.setString(2, noteDescription);
                statement.executeUpdate();
                statement.close();
                connection.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            tableModel = Dashboard.getNotesTableModel();
            dataForTable = new String[]{
                noteTitle,
                (noteDescription.length() > 60) ? noteDescription.substring(0, 61) + "..." : noteDescription
            };
        }
        
        //Add new table row on dashboard.
        Dashboard.addNewTableRow(tableModel, dataForTable);
        //Close this frame and enable dashboard.
        this.dispose();
        dashboard.setEnabled(true);
        dashboard.requestFocus();
    }//GEN-LAST:event_btnAddMousePressed

    private void generatePasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generatePasswordMousePressed
        String generatedPassword = new PasswordGenerator().generateRandomSecurePassword();
        txtPassword.setText(generatedPassword);
    }//GEN-LAST:event_generatePasswordMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNew();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel generatePassword;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel newCardMainPanel;
    private javax.swing.JPanel newNoteMainPanel;
    private javax.swing.JLabel showHidePassword;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtCardName;
    private javax.swing.JTextArea txtNoteDescription;
    private javax.swing.JTextField txtNoteTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
