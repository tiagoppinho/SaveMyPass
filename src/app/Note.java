package app;

import crypto.Encryptor;
import handlers.DatabaseHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Constants;
import utils.Customization;

/**
 *
 * @author Tiago Pinho
 */
public class Note extends javax.swing.JFrame {

    private Dashboard dashboard = null;
    private int noteIdentifier = -1, index = 0;
    private final Encryptor encryptor = new Encryptor();
    
    private ArrayList<String> noteTitles = new ArrayList<>();
    
    private final String[] VALUES_COLUMNS = {"title", "description"};
    
    //View mode only.
    private String[] oldValues = new String[2];
    private String oldNoteTitle, oldNoteDescription;
       
    public Note(Dashboard dashboard, int noteIdentifier) {
        if(dashboard != null){
            this.dashboard = dashboard;
            
            if(noteIdentifier == -1){
                this.index = 0;
            } else {
                this.index = 1;
                this.noteIdentifier = noteIdentifier;
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
        jLabel5 = new javax.swing.JLabel();
        txtNoteTitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoteDescription = new javax.swing.JTextArea();
        footerPanel = new javax.swing.JPanel();
        btnAddOrSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SaveMyPass - New Note");
        setMinimumSize(new java.awt.Dimension(379, 348));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("New Note");

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
                .addContainerGap(21, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setName(""); // NOI18N

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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoteTitle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        footerPanel.setBackground(new java.awt.Color(250, 250, 250));
        footerPanel.setMinimumSize(new java.awt.Dimension(380, 70));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(footerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 49, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMousePressed
        close();
    }//GEN-LAST:event_btnCancelMousePressed

    private void btnAddOrSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMouseEntered
        btnAddOrSave.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnAddOrSaveMouseEntered

    private void btnAddOrSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMouseExited
        btnAddOrSave.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnAddOrSaveMouseExited

    private void btnAddOrSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrSaveMousePressed
        String noteTitle = txtNoteTitle.getText(), description = txtNoteDescription.getText();
        
        if(noteTitle.isEmpty() || description.isEmpty()){
            Customization.displayWarningMessage(
                "Please fill all the note fields.",
                "Empty field(s)!"
            );
        }else if(exists(noteTitle)){
            Customization.displayWarningMessage(
                "This note already exists. Make sure you're inserting the right values.",
                "Duplicated note!"
            );
        } else {
            if(index == 0){
                Connection connection = DatabaseHandler.getConnection();

                try{
                    PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Notes (title, description) VALUES (?, ?)"
                    );
                    statement.setString(1, encryptor.encrypt(noteTitle));
                    statement.setString(2, encryptor.encrypt(description));
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
                dashboard.addNewTableRow(
                    dashboard.getNotesTableModel(),
                    new String[]{noteTitle, description},
                    true
                );
            } else {
                String[] values = {noteTitle, description};
                Connection connection = DatabaseHandler.getConnection();
                PreparedStatement statement;
                
                for(int i = 0; i < values.length; i++){
                    if(!values[i].equals(oldValues[i])){
                        try {
                            statement = connection.prepareStatement(
                                "UPDATE Notes SET " + VALUES_COLUMNS[i] + " = ? WHERE ID = ?"
                            );
                            statement.setString(1, encryptor.encrypt(values[i]));
                            statement.setInt(2, noteIdentifier);
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
            close();
        }
        dashboard.loadNotes();
    }//GEN-LAST:event_btnAddOrSaveMousePressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
        
        if(index == 1){
            this.setTitle("SaveMyPass - View Note");
            title.setText("View Note");
            btnAddOrSave.setText("Save");
        }
    }//GEN-LAST:event_formComponentShown

    /**
     * Closes this frame and enables dashboard.
     */
    private void close(){
        this.dispose();
        dashboard.setEnabled(true);
        dashboard.requestFocus();
    }
    
    /**
     * Checks if note already exist based on it's title.
     * Helps preventing duplicated notes.
     */
    private boolean exists(String title){
        boolean titleExists = false;
        
        for (String noteTitle : noteTitles){
            if(title.equals(noteTitle)){
                titleExists = true;
                break;
            }
        }
        
        return titleExists;
    }
    
    /**
     * Loads all the needed data to compare with new values.
     */
    private void load(){
        Connection connection = DatabaseHandler.getConnection();
        
        try{
            if(index == 0){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT title FROM Notes");
                
                while(resultSet.next()){
                    noteTitles.add(encryptor.decrypt(resultSet.getString("title")));
                }
                
                resultSet.close();
                statement.close();
            } else {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT title FROM Notes WHERE ID <> ?"
                );
                statement.setInt(1, noteIdentifier);
                
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    noteTitles.add(encryptor.decrypt(resultSet.getString("title")));
                }
                
                resultSet.close();
                statement.close();
                
                statement = connection.prepareStatement("SELECT title, description FROM Notes WHERE ID = ?");
                statement.setInt(1, noteIdentifier);
                
                resultSet = statement.executeQuery();
                
                for(int i = 0; i < oldValues.length; i++)
                    oldValues[i] = encryptor.decrypt(resultSet.getString(VALUES_COLUMNS[i]));
                                
                txtNoteTitle.setText(oldValues[0]);
                txtNoteDescription.setText(oldValues[1]);
                
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
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddOrSave;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea txtNoteDescription;
    private javax.swing.JTextField txtNoteTitle;
    // End of variables declaration//GEN-END:variables
}
