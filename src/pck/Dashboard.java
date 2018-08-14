package pck;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiago Pinho
 */
public class Dashboard extends javax.swing.JFrame {

    private final String[] TITLES = new String[]{"All cards", "Favourites", "Notes", "Settings"};
    private JLabel[] titleButtons = new JLabel[4];
        
    /* -------------------- Side Panel Buttons -------------- */
    private Component[] sidePanelButtons = new JPanel[4];
    private JLabel[] sidePanelButtonsMarker = new JLabel[4];
    private Component activeSidePanelButton;
    /* ------------------------------------------------------ */
    
    /* -------------------- Main Panels --------------------- */
    private JPanel[] mainPanels = new JPanel[4];
    /* ------------------------------------------------------ */
    
    //All cards table model.
    private final DefaultTableModel customModelAllCards = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            /*switch(columnIndex){
                case 1:
                    return ImageIcon.class;
                default:
                    return String.class;
            } */
            return String.class;
        }
    };
    
    //Notes table model.
    private final DefaultTableModel customModelNotes = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            return String.class;
        }
    };
    
    public Dashboard() {
        initComponents();
        this.sidePanelButtons = new Component[]{btnAllCards, btnFavourites, btnNotes, btnSettings};
        this.sidePanelButtonsMarker = new JLabel[]{
            btnAllCardsMarker, btnFavouritesMarker, btnNotesMarker, btnSettingsMarker
        };
        this.mainPanels = new JPanel[]{allCardsPanel, favouritesPanel, notesPanel, settingsPanel};
        this.titleButtons = new JLabel[]{btnAddNewCard, null, btnAddNewNote, null};
        this.activeSidePanelButton = sidePanelButtons[0];
        btnAddNewNote.setVisible(false);
        scrollPaneAllCardsTable.getViewport().setBackground(Color.WHITE);
        scrollPaneNotesTable.getViewport().setBackground(Color.WHITE);
        String tableHeaders[] = {""/*, ""*/};
        customModelAllCards.setColumnIdentifiers(tableHeaders);
        customModelNotes.setColumnIdentifiers(tableHeaders);
        allCardsTable.setDefaultEditor(Object.class, null);
        allCardsTable.setRowHeight(55);
        notesTable.setDefaultEditor(Object.class, null);
        notesTable.setRowHeight(55);
        allCardsTable.setModel(customModelAllCards);
        notesTable.setModel(customModelNotes);
        //allCardsTable.getColumnModel().getColumn(0).setMinWidth(620);
        loadData();
        btnSaveSettings.setVisible(false);
    }
    
    /**
     * Loads all the data from database needed for Dashboard.
     */
    private void loadData(){
        Connection connection = DatabaseHandler.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title, username FROM Cards");
            while(resultSet.next()){
                addNewTableRow(customModelAllCards, new String[]{
                    resultSet.getString("title"), resultSet.getString("username")
                });
            }
            resultSet.close();
            resultSet = statement.executeQuery("SELECT * FROM Notes");
            String title, description;
            while(resultSet.next()){
                title = resultSet.getString("title");
                description = resultSet.getString("description");
                addNewTableRow(customModelNotes, new String[]{
                    title,
                    (description.length() > 60) ? description.substring(0, 61) + "..." : description
                });
            }
            resultSet.close();
            resultSet = statement.executeQuery("SELECT * FROM Settings");
            resultSet.next();
            lengthSlider.setValue(resultSet.getInt("passwordLength"));
            uppercaseCharacters.setSelected(resultSet.getBoolean("passwordUppercase"));
            lowercaseCharacters.setSelected(resultSet.getBoolean("passwordLowercase"));
            numberCharacters.setSelected(resultSet.getBoolean("passwordNumbers"));
            specialCharacters.setSelected(resultSet.getBoolean("passwordSpecialCharacters"));
            autoLogoutEnabled.setSelected(resultSet.getBoolean("autoLogoutEnabled"));
            autoLogoutTimerComboBox.setSelectedIndex(resultSet.getInt("autoLogoutTimerIndex"));
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAllCards = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnAllCardsMarker = new javax.swing.JLabel();
        btnFavourites = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnFavouritesMarker = new javax.swing.JLabel();
        btnNotes = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnNotesMarker = new javax.swing.JLabel();
        btnSettings = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnSettingsMarker = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        btnAddNewCard = new javax.swing.JLabel();
        btnAddNewNote = new javax.swing.JLabel();
        allCardsPanel = new javax.swing.JPanel();
        scrollPaneAllCardsTable = new javax.swing.JScrollPane();
        allCardsTable = new javax.swing.JTable();
        noCardsInfo = new javax.swing.JLabel();
        favouritesPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        notesPanel = new javax.swing.JPanel();
        scrollPaneNotesTable = new javax.swing.JScrollPane();
        notesTable = new javax.swing.JTable();
        noNotesInfo = new javax.swing.JLabel();
        settingsPanel = new javax.swing.JPanel();
        passwordGeneratorTitle = new javax.swing.JLabel();
        autoLogOffTitle = new javax.swing.JLabel();
        accountTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lengthSlider = new javax.swing.JSlider();
        sliderValue = new javax.swing.JLabel();
        uppercaseCharacters = new javax.swing.JCheckBox();
        lowercaseCharacters = new javax.swing.JCheckBox();
        numberCharacters = new javax.swing.JCheckBox();
        specialCharacters = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        security = new javax.swing.JLabel();
        autoLogoutEnabled = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        autoLogoutTimerComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnChangeMasterPin = new javax.swing.JLabel();
        btnSaveSettings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteAllData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveMyPass - Dashboard");
        setMinimumSize(new java.awt.Dimension(909, 637));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setLayout(null);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Logout Rounded Left_24px.png"))); // NOI18N
        btnLogout.setToolTipText("Logout");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutMousePressed(evt);
            }
        });
        headerPanel.add(btnLogout);
        btnLogout.setBounds(806, 10, 24, 24);

        jPanel1.setBackground(new java.awt.Color(0, 39, 255));
        headerPanel.add(jPanel1);
        jPanel1.setBounds(0, 0, 240, 40);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Cancel_24px.png"))); // NOI18N
        btnClose.setToolTipText("Close");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCloseMousePressed(evt);
            }
        });
        headerPanel.add(btnClose);
        btnClose.setBounds(870, 10, 24, 24);

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Minus_24px.png"))); // NOI18N
        btnMinimize.setToolTipText("Minimize");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizeMousePressed(evt);
            }
        });
        headerPanel.add(btnMinimize);
        btnMinimize.setBounds(840, 10, 20, 24);

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 910, 40);

        sidePanel.setBackground(new java.awt.Color(0, 39, 255));
        sidePanel.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Privacy_48px_white.png"))); // NOI18N
        sidePanel.add(jLabel3);
        jLabel3.setBounds(20, 20, 48, 48);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SaveMyPass");
        sidePanel.add(jLabel2);
        jLabel2.setBounds(70, 20, 131, 26);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password Manager");
        sidePanel.add(jLabel8);
        jLabel8.setBounds(88, 50, 110, 15);

        btnAllCards.setBackground(new java.awt.Color(51, 144, 255));
        btnAllCards.setName("0"); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("All cards");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Data Grid_30px.png"))); // NOI18N

        btnAllCardsMarker.setBackground(new java.awt.Color(255, 255, 255));
        btnAllCardsMarker.setName("btnAllCardsMarker"); // NOI18N
        btnAllCardsMarker.setOpaque(true);

        javax.swing.GroupLayout btnAllCardsLayout = new javax.swing.GroupLayout(btnAllCards);
        btnAllCards.setLayout(btnAllCardsLayout);
        btnAllCardsLayout.setHorizontalGroup(
            btnAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAllCardsLayout.createSequentialGroup()
                .addComponent(btnAllCardsMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(29, 29, 29)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnAllCardsLayout.setVerticalGroup(
            btnAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAllCardsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(btnAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(btnAllCardsMarker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePanel.add(btnAllCards);
        btnAllCards.setBounds(0, 150, 240, 68);

        btnFavourites.setBackground(new java.awt.Color(0, 39, 255));
        btnFavourites.setName("1"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Favorites");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Star Filled_30px.png"))); // NOI18N

        btnFavouritesMarker.setBackground(new java.awt.Color(255, 255, 255));
        btnFavouritesMarker.setName("btnFavouritesMarker"); // NOI18N

        javax.swing.GroupLayout btnFavouritesLayout = new javax.swing.GroupLayout(btnFavourites);
        btnFavourites.setLayout(btnFavouritesLayout);
        btnFavouritesLayout.setHorizontalGroup(
            btnFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnFavouritesLayout.createSequentialGroup()
                .addComponent(btnFavouritesMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(29, 29, 29)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnFavouritesLayout.setVerticalGroup(
            btnFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFavouritesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(btnFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(btnFavouritesMarker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePanel.add(btnFavourites);
        btnFavourites.setBounds(0, 230, 240, 68);

        btnNotes.setBackground(new java.awt.Color(0, 39, 255));
        btnNotes.setName("2"); // NOI18N

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Notes");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Edit Property_30px.png"))); // NOI18N

        btnNotesMarker.setBackground(new java.awt.Color(255, 255, 255));
        btnNotesMarker.setName("btnNotesMarker"); // NOI18N

        javax.swing.GroupLayout btnNotesLayout = new javax.swing.GroupLayout(btnNotes);
        btnNotes.setLayout(btnNotesLayout);
        btnNotesLayout.setHorizontalGroup(
            btnNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNotesLayout.createSequentialGroup()
                .addComponent(btnNotesMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(29, 29, 29)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnNotesLayout.setVerticalGroup(
            btnNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNotesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(btnNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(btnNotesMarker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePanel.add(btnNotes);
        btnNotes.setBounds(0, 310, 240, 68);

        btnSettings.setBackground(new java.awt.Color(0, 39, 255));
        btnSettings.setName("3"); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Settings");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Settings_30px.png"))); // NOI18N

        btnSettingsMarker.setBackground(new java.awt.Color(255, 255, 255));
        btnSettingsMarker.setName("btnNotesMarker"); // NOI18N

        javax.swing.GroupLayout btnSettingsLayout = new javax.swing.GroupLayout(btnSettings);
        btnSettings.setLayout(btnSettingsLayout);
        btnSettingsLayout.setHorizontalGroup(
            btnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSettingsLayout.createSequentialGroup()
                .addComponent(btnSettingsMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(29, 29, 29)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnSettingsLayout.setVerticalGroup(
            btnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSettingsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(btnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(btnSettingsMarker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePanel.add(btnSettings);
        btnSettings.setBounds(0, 390, 240, 68);

        getContentPane().add(sidePanel);
        sidePanel.setBounds(0, 40, 240, 600);

        titlePanel.setBackground(new java.awt.Color(51, 144, 255));
        titlePanel.setLayout(null);

        mainTitle.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        mainTitle.setForeground(new java.awt.Color(255, 255, 255));
        mainTitle.setText("All cards");
        titlePanel.add(mainTitle);
        mainTitle.setBounds(110, 50, 245, 33);

        btnAddNewCard.setBackground(new java.awt.Color(255, 255, 255));
        btnAddNewCard.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAddNewCard.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewCard.setText("Add new card...");
        btnAddNewCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddNewCardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddNewCardMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddNewCardMousePressed(evt);
            }
        });
        titlePanel.add(btnAddNewCard);
        btnAddNewCard.setBounds(553, 93, 107, 17);

        btnAddNewNote.setBackground(new java.awt.Color(255, 255, 255));
        btnAddNewNote.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAddNewNote.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewNote.setText("Add new note...");
        btnAddNewNote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddNewNoteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddNewNoteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddNewNoteMousePressed(evt);
            }
        });
        titlePanel.add(btnAddNewNote);
        btnAddNewNote.setBounds(553, 93, 108, 17);

        getContentPane().add(titlePanel);
        titlePanel.setBounds(240, 40, 670, 120);

        allCardsPanel.setBackground(new java.awt.Color(255, 255, 255));
        allCardsPanel.setName(""); // NOI18N
        allCardsPanel.setLayout(null);

        scrollPaneAllCardsTable.setBorder(null);

        allCardsTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        allCardsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allCardsTable.setGridColor(new java.awt.Color(0, 0, 0));
        allCardsTable.setIntercellSpacing(new java.awt.Dimension(10, 4));
        allCardsTable.setName(""); // NOI18N
        allCardsTable.setRowHeight(100);
        allCardsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        allCardsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        allCardsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        allCardsTable.setShowVerticalLines(false);
        allCardsTable.getTableHeader().setResizingAllowed(false);
        allCardsTable.getTableHeader().setReorderingAllowed(false);
        allCardsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allCardsTableMousePressed(evt);
            }
        });
        scrollPaneAllCardsTable.setViewportView(allCardsTable);

        allCardsPanel.add(scrollPaneAllCardsTable);
        scrollPaneAllCardsTable.setBounds(0, -10, 670, 490);

        noCardsInfo.setBackground(new java.awt.Color(255, 255, 255));
        noCardsInfo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        noCardsInfo.setForeground(new java.awt.Color(51, 153, 255));
        noCardsInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCardsInfo.setText("You don't have any card yet.");
        noCardsInfo.setToolTipText("");
        noCardsInfo.setOpaque(true);
        allCardsPanel.add(noCardsInfo);
        noCardsInfo.setBounds(0, 0, 670, 270);

        getContentPane().add(allCardsPanel);
        allCardsPanel.setBounds(240, 160, 670, 480);

        favouritesPanel.setBackground(new java.awt.Color(255, 255, 255));
        favouritesPanel.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Coming soon...");
        jLabel5.setToolTipText("");
        favouritesPanel.add(jLabel5);
        jLabel5.setBounds(0, -2, 670, 310);

        getContentPane().add(favouritesPanel);
        favouritesPanel.setBounds(240, 160, 670, 480);

        notesPanel.setBackground(new java.awt.Color(255, 255, 255));
        notesPanel.setLayout(null);

        scrollPaneNotesTable.setBorder(null);

        notesTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        notesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notesTable.setGridColor(new java.awt.Color(0, 0, 0));
        notesTable.setIntercellSpacing(new java.awt.Dimension(10, 4));
        notesTable.setName(""); // NOI18N
        notesTable.setRowHeight(100);
        notesTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        notesTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        notesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        notesTable.setShowVerticalLines(false);
        notesTable.getTableHeader().setResizingAllowed(false);
        notesTable.getTableHeader().setReorderingAllowed(false);
        scrollPaneNotesTable.setViewportView(notesTable);

        notesPanel.add(scrollPaneNotesTable);
        scrollPaneNotesTable.setBounds(0, -10, 670, 500);

        noNotesInfo.setBackground(new java.awt.Color(255, 255, 255));
        noNotesInfo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        noNotesInfo.setForeground(new java.awt.Color(51, 153, 255));
        noNotesInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noNotesInfo.setText("You don't have any note yet.");
        noNotesInfo.setToolTipText("");
        noNotesInfo.setOpaque(true);
        notesPanel.add(noNotesInfo);
        noNotesInfo.setBounds(0, 0, 670, 270);

        getContentPane().add(notesPanel);
        notesPanel.setBounds(240, 160, 670, 480);

        settingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        settingsPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                settingsPanelComponentShown(evt);
            }
        });

        passwordGeneratorTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        passwordGeneratorTitle.setForeground(new java.awt.Color(51, 153, 255));
        passwordGeneratorTitle.setText("Password Generator");

        autoLogOffTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        autoLogOffTitle.setForeground(new java.awt.Color(51, 153, 255));
        autoLogOffTitle.setText("Auto Logout");

        accountTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        accountTitle.setForeground(new java.awt.Color(51, 153, 255));
        accountTitle.setText("Account");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setLabelFor(lengthSlider);
        jLabel4.setText("Length:");

        lengthSlider.setBackground(new java.awt.Color(255, 255, 255));
        lengthSlider.setMajorTickSpacing(56);
        lengthSlider.setMaximum(64);
        lengthSlider.setMinimum(8);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setSnapToTicks(true);
        lengthSlider.setValue(18);
        lengthSlider.setFocusable(false);
        lengthSlider.setRequestFocusEnabled(false);
        lengthSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lengthSliderStateChanged(evt);
            }
        });

        sliderValue.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sliderValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sliderValue.setText("18");

        uppercaseCharacters.setBackground(new java.awt.Color(255, 255, 255));
        uppercaseCharacters.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        uppercaseCharacters.setSelected(true);
        uppercaseCharacters.setText("A - Z  ");
        uppercaseCharacters.setFocusable(false);
        uppercaseCharacters.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        uppercaseCharacters.setMargin(new java.awt.Insets(2, 0, 2, 2));
        uppercaseCharacters.setName("0"); // NOI18N
        uppercaseCharacters.setRequestFocusEnabled(false);

        lowercaseCharacters.setBackground(new java.awt.Color(255, 255, 255));
        lowercaseCharacters.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lowercaseCharacters.setSelected(true);
        lowercaseCharacters.setText("a - z  ");
        lowercaseCharacters.setFocusable(false);
        lowercaseCharacters.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lowercaseCharacters.setMargin(new java.awt.Insets(2, 0, 2, 2));
        lowercaseCharacters.setName("1"); // NOI18N
        lowercaseCharacters.setRequestFocusEnabled(false);

        numberCharacters.setBackground(new java.awt.Color(255, 255, 255));
        numberCharacters.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        numberCharacters.setSelected(true);
        numberCharacters.setText("0 - 9  ");
        numberCharacters.setFocusable(false);
        numberCharacters.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        numberCharacters.setMargin(new java.awt.Insets(2, 0, 2, 2));
        numberCharacters.setName("2"); // NOI18N
        numberCharacters.setRequestFocusEnabled(false);

        specialCharacters.setBackground(new java.awt.Color(255, 255, 255));
        specialCharacters.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        specialCharacters.setSelected(true);
        specialCharacters.setText("Special Characters  ");
        specialCharacters.setFocusable(false);
        specialCharacters.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        specialCharacters.setMargin(new java.awt.Insets(2, 0, 2, 2));
        specialCharacters.setName("3"); // NOI18N
        specialCharacters.setRequestFocusEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setLabelFor(lengthSlider);
        jLabel6.setText("Security:");

        security.setBackground(new java.awt.Color(255, 255, 255));
        security.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        security.setForeground(java.awt.Color.green);
        security.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        security.setLabelFor(lengthSlider);
        security.setText("Strong");
        security.setOpaque(true);

        autoLogoutEnabled.setBackground(new java.awt.Color(255, 255, 255));
        autoLogoutEnabled.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        autoLogoutEnabled.setSelected(true);
        autoLogoutEnabled.setText("Enabled  ");
        autoLogoutEnabled.setFocusable(false);
        autoLogoutEnabled.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        autoLogoutEnabled.setMargin(new java.awt.Insets(2, 0, 2, 2));
        autoLogoutEnabled.setRequestFocusEnabled(false);
        autoLogoutEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoLogoutEnabledActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setLabelFor(lengthSlider);
        jLabel9.setText("Timer:");

        autoLogoutTimerComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        autoLogoutTimerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 min", "5 min", "10 min", "15 min", "20 min" }));
        autoLogoutTimerComboBox.setFocusable(false);
        autoLogoutTimerComboBox.setRequestFocusEnabled(false);
        autoLogoutTimerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoLogoutTimerComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("Security options for the generated password.");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText("When the app is not being used for the amount of time set, it will automatically logout.");

        btnChangeMasterPin.setBackground(new java.awt.Color(230, 230, 230));
        btnChangeMasterPin.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnChangeMasterPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChangeMasterPin.setText("Change master PIN");
        btnChangeMasterPin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        btnChangeMasterPin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeMasterPin.setMaximumSize(new java.awt.Dimension(61, 37));
        btnChangeMasterPin.setMinimumSize(new java.awt.Dimension(61, 37));
        btnChangeMasterPin.setOpaque(true);
        btnChangeMasterPin.setPreferredSize(new java.awt.Dimension(61, 37));
        btnChangeMasterPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnChangeMasterPinMousePressed(evt);
            }
        });

        btnSaveSettings.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveSettings.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnSaveSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveSettings.setText("Save");
        btnSaveSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveSettings.setMaximumSize(new java.awt.Dimension(61, 37));
        btnSaveSettings.setMinimumSize(new java.awt.Dimension(61, 37));
        btnSaveSettings.setOpaque(true);
        btnSaveSettings.setPreferredSize(new java.awt.Dimension(61, 37));
        btnSaveSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveSettingsMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DANGER ZONE: (deletes all database, use for emergencies only)");

        btnDeleteAllData.setBackground(new java.awt.Color(230, 230, 230));
        btnDeleteAllData.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnDeleteAllData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteAllData.setText("Delete all data");
        btnDeleteAllData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        btnDeleteAllData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAllData.setMaximumSize(new java.awt.Dimension(61, 37));
        btnDeleteAllData.setMinimumSize(new java.awt.Dimension(61, 37));
        btnDeleteAllData.setOpaque(true);
        btnDeleteAllData.setPreferredSize(new java.awt.Dimension(61, 37));
        btnDeleteAllData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(btnDeleteAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(autoLogoutEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(autoLogoutTimerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(autoLogOffTitle)
                            .addComponent(passwordGeneratorTitle)
                            .addComponent(accountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, settingsPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lengthSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, settingsPanelLayout.createSequentialGroup()
                                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(uppercaseCharacters))
                                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                            .addGap(82, 82, 82)
                                            .addComponent(lowercaseCharacters)
                                            .addGap(84, 84, 84)
                                            .addComponent(numberCharacters)
                                            .addGap(66, 66, 66)
                                            .addComponent(specialCharacters))
                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(security, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnChangeMasterPin, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(48, Short.MAX_VALUE))))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(passwordGeneratorTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberCharacters)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(uppercaseCharacters)
                                .addComponent(lowercaseCharacters)
                                .addComponent(specialCharacters)))
                        .addGap(18, 18, 18)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(security, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(autoLogOffTitle))
                    .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoLogoutEnabled)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoLogoutTimerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(accountTitle)
                .addGap(18, 18, 18)
                .addComponent(btnChangeMasterPin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(settingsPanel);
        settingsPanel.setBounds(240, 160, 670, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        int i = 0;
        
        Customization.applyDraggability(headerPanel, this);
        Customization.underlineText(btnAddNewCard);
        Customization.underlineText(btnAddNewNote);
        
        //Sets all the main panels off, except the default active.
        for(JPanel mainPanel : mainPanels) {
            if(i != Integer.valueOf(activeSidePanelButton.getName()))
                mainPanel.setVisible(false);
            i++;
        }
        
        //Adds mouse events to the side panel buttons.
        for(Component sidePanelButton : sidePanelButtons) {
            sidePanelButton.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    sidePanelButtonMouseEntered(evt);
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    sidePanelButtonMouseExited(evt);
                }
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    sidePanelButtonMousePressed(evt);
                }
            });
        }
    }//GEN-LAST:event_formComponentShown

    private void btnCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnCloseMousePressed

    private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
        logout();
    }//GEN-LAST:event_btnLogoutMousePressed

    private void btnMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMousePressed
        this.setState(Dashboard.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMousePressed

    private void lengthSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lengthSliderStateChanged
        int value = lengthSlider.getValue();
        
        sliderValue.setText(String.valueOf(value));
        
        //activateSaveSettingsButton();
    }//GEN-LAST:event_lengthSliderStateChanged

    private void autoLogoutEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoLogoutEnabledActionPerformed
        if(autoLogoutEnabled.isSelected())
            autoLogoutTimerComboBox.setEnabled(true);
        else
            autoLogoutTimerComboBox.setEnabled(false);
        
        //activateSaveSettingsButton();
    }//GEN-LAST:event_autoLogoutEnabledActionPerformed

    private void settingsPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_settingsPanelComponentShown
        
    }//GEN-LAST:event_settingsPanelComponentShown

    private void accountButtonsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonsMouseEntered
        evt.getComponent().setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_accountButtonsMouseEntered

    private void accountButtonsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonsMouseExited
        evt.getComponent().setBackground(new Color(230, 230, 230));
    }//GEN-LAST:event_accountButtonsMouseExited

    private void btnChangeMasterPinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMasterPinMousePressed
        int confirm = JOptionPane.showConfirmDialog(null, "If you proceed you'll be logged out." +
                                                " Are you sure you want to proceed?", 
                                                "Change master PIN", JOptionPane.YES_NO_OPTION,
                                                JOptionPane.WARNING_MESSAGE);
        if(confirm == JOptionPane.YES_OPTION){
            NewPin changePin = new NewPin(2);
            changePin.setVisible(true);
            changePin.requestFocusInWindow();
            this.dispose();
        }
    }//GEN-LAST:event_btnChangeMasterPinMousePressed

    private void btnSaveSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveSettingsMousePressed
        /*
            Save new settings to database.
            Apply changes.
            Inform the user that settings have been saved.
        */
    }//GEN-LAST:event_btnSaveSettingsMousePressed

    private void allCardsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allCardsTableMousePressed
        //System.out.println(allCardsTable.getSelectedColumn());
    }//GEN-LAST:event_allCardsTableMousePressed

    private void buttonsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsMouseEntered
        evt.getComponent().setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_buttonsMouseEntered

    private void buttonsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsMouseExited
        evt.getComponent().setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_buttonsMouseExited

    private void autoLogoutTimerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoLogoutTimerComboBoxActionPerformed
        System.out.println(autoLogoutTimerComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_autoLogoutTimerComboBoxActionPerformed

    private void btnAddNewCardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCardMouseEntered
        btnAddNewCard.setForeground(Constants.TITLE_BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnAddNewCardMouseEntered

    private void btnAddNewCardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCardMouseExited
        btnAddNewCard.setForeground(Constants.TITLE_BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnAddNewCardMouseExited

    private void btnAddNewCardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCardMousePressed
        addNewItem(0);
    }//GEN-LAST:event_btnAddNewCardMousePressed

    private void btnAddNewNoteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewNoteMouseEntered
        btnAddNewNote.setForeground(Constants.TITLE_BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnAddNewNoteMouseEntered

    private void btnAddNewNoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewNoteMouseExited
        btnAddNewNote.setForeground(Constants.TITLE_BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnAddNewNoteMouseExited

    private void btnAddNewNoteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewNoteMousePressed
        addNewItem(1);
    }//GEN-LAST:event_btnAddNewNoteMousePressed
     
    /**
     * Sends the user to Login frame.
     */
    private void logout() {
        Login login = new Login();
        login.setState(this.getState());
        this.dispose();
    }
    
    /**
     * Pops up the Add New frame.
     * @param index Integer.
     * <br>
     * 0 - New Card.
     * <br>
     * 1 - New Note.
     */
    private void addNewItem(int index) {
        try{
            AddNew newCard = new AddNew(index, this);
            newCard.setVisible(true);
        } catch(IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
       
    /**
     * Adds new styled data to a table model and sends the new row of data to the top.
     * @param model Table model to add data.
     * @param data Data to be added.
     */
    public static void addNewTableRow(DefaultTableModel model, String[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><font color=\"#3399ff\"><b>");
        sb.append(data[0]);
        sb.append("</b></font><br><br>");
        sb.append(data[1]).append("</html>");
        String finalData = sb.toString();/*
        ImageIcon img = new ImageIcon(new Dashboard().getClass().getResource("img/Star_Filled_30px_gold.png"));*/
        model.addRow(new Object[]{finalData/*, img*/});
        if(model.getRowCount() > 1)
            model.moveRow(model.getRowCount() - 1, model.getRowCount() - 1, 0);
    }
    
    /**
     * Returns the "All Cards" table model.
     * @return DefaultTableModel
     */
    public static DefaultTableModel getAllCardsTableModel() {
        return  (DefaultTableModel) allCardsTable.getModel();
    }
    
    /**
     * Returns the "Notes" table model.
     * @return DefaultTableModel
     */
    public static DefaultTableModel getNotesTableModel() {
        return (DefaultTableModel) notesTable.getModel();
    }
    
    /**
     * Sets the save settings button visible.
     */
    private void activateSaveSettingsButton() {
        if(!btnSaveSettings.isVisible())
            btnSaveSettings.setVisible(true);
    }
    
    /**
     * 
     */
    private void deactivateSaveSettingsButton(){
        if(btnSaveSettings.isVisible())
            btnSaveSettings.setVisible(false);
    }
    
    /**
     * Handles the mouse entered event of the side panel buttons.
     * @param evt MouseEvent
     */
    private void sidePanelButtonMouseEntered(java.awt.event.MouseEvent evt) {
        Component button = evt.getComponent();
        
        if(!button.getName().equals(activeSidePanelButton.getName()))
            button.setBackground(Constants.SIDE_PANEL_BUTTONS_COLOR_ON_MOUSE_HOVER);
    }
    
    /**
     * Handles the mouse exited event of the side panel buttons.
     * @param evt MouseEvent
     */
    private void sidePanelButtonMouseExited(java.awt.event.MouseEvent evt) {
        Component button = evt.getComponent();
        
        if(!button.getName().equals(activeSidePanelButton.getName()))
            button.setBackground(Constants.SIDE_PANEL_BUTTONS_DEFAULT_COLOR);
    }
    
    /**
     * Handles the mouse pressed event of the side panel buttons.
     * @param evt MouseEvent
     */
    private void sidePanelButtonMousePressed(java.awt.event.MouseEvent evt) {
        Component button = evt.getComponent();
        
        if(!button.getName().equals(activeSidePanelButton.getName())) {
            closeActiveSidePanelButton();
            activateNewSidePanelButton(button);
        }
    }
    
    /**
     * Closes the active side panel button, based on it's number.
     * Removes the respective properties of an active side panel button.
     */
    private void closeActiveSidePanelButton() {
        int activeSidePanelNumber = Integer.valueOf(activeSidePanelButton.getName());
        
        mainPanels[activeSidePanelNumber].setVisible(false);
        sidePanelButtons[activeSidePanelNumber].setBackground(Constants.SIDE_PANEL_BUTTONS_DEFAULT_COLOR);
        sidePanelButtonsMarker[activeSidePanelNumber].setOpaque(false);
        if(titleButtons[activeSidePanelNumber] != null)
            titleButtons[activeSidePanelNumber].setVisible(false);
    }
    
    /**
     * Activates a new side panel button with a given component (button), based on it's number.
     * Applies the respective properties of an active side panel button.
     * @param button Given button to set as active.
     */
    private void activateNewSidePanelButton(Component button) {
        int buttonNumber = Integer.valueOf(button.getName());
        
        mainTitle.setText(TITLES[buttonNumber]);
        mainPanels[buttonNumber].setVisible(true);
        sidePanelButtons[buttonNumber].setBackground(Constants.SIDE_PANEL_BUTTONS_COLOR_ON_MOUSE_CLICK);
        sidePanelButtonsMarker[buttonNumber].setOpaque(true);
        if(titleButtons[buttonNumber] != null)
            titleButtons[buttonNumber].setVisible(true);
        
        activeSidePanelButton = button;
    }
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountTitle;
    private javax.swing.JPanel allCardsPanel;
    private static javax.swing.JTable allCardsTable;
    private javax.swing.JLabel autoLogOffTitle;
    private javax.swing.JCheckBox autoLogoutEnabled;
    private javax.swing.JComboBox<String> autoLogoutTimerComboBox;
    private javax.swing.JLabel btnAddNewCard;
    private javax.swing.JLabel btnAddNewNote;
    private javax.swing.JPanel btnAllCards;
    private javax.swing.JLabel btnAllCardsMarker;
    private javax.swing.JLabel btnChangeMasterPin;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnDeleteAllData;
    private javax.swing.JPanel btnFavourites;
    private javax.swing.JLabel btnFavouritesMarker;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JPanel btnNotes;
    private javax.swing.JLabel btnNotesMarker;
    private javax.swing.JLabel btnSaveSettings;
    private javax.swing.JPanel btnSettings;
    private javax.swing.JLabel btnSettingsMarker;
    private javax.swing.JPanel favouritesPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider lengthSlider;
    private javax.swing.JCheckBox lowercaseCharacters;
    private javax.swing.JLabel mainTitle;
    private static javax.swing.JLabel noCardsInfo;
    private static javax.swing.JLabel noNotesInfo;
    private javax.swing.JPanel notesPanel;
    private static javax.swing.JTable notesTable;
    private javax.swing.JCheckBox numberCharacters;
    private javax.swing.JLabel passwordGeneratorTitle;
    private static javax.swing.JScrollPane scrollPaneAllCardsTable;
    private static javax.swing.JScrollPane scrollPaneNotesTable;
    private javax.swing.JLabel security;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel sliderValue;
    private javax.swing.JCheckBox specialCharacters;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JCheckBox uppercaseCharacters;
    // End of variables declaration//GEN-END:variables
}