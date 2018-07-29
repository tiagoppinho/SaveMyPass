package pck;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * @author Tiago Pinho
 */
public class Login extends javax.swing.JFrame {

    //Virtual keyboard handler.
    private boolean isKeyboardOpen = false;
    private JLabel[] keyboardButtons = new JLabel[11];
      
    public Login() {
        if(!isFirstTime()) {
            initComponents();
            this.keyboardButtons = new JLabel[]{btnClear, lblNum0, lblNum1, lblNum2,lblNum3,
                                   lblNum4, lblNum5, lblNum6, lblNum7, lblNum8, lblNum9};
            this.setVisible(true);
        } else {
            NewPIN firstTimeSetup = new NewPIN(1);
            firstTimeSetup.setVisible(true);
        }
    }
    
    //First time executing?
    private boolean isFirstTime() {
        //TEST only.
        //Will work as supposed as soon as database is connected to project.
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMainClose = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        txtPin = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        forgotPin = new javax.swing.JLabel();
        separator = new javax.swing.JLabel();
        keyboardHeaderPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnSecondaryClose = new javax.swing.JLabel();
        keyboardMainPanel = new javax.swing.JPanel();
        closeKeyboard = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveMyPass - Login");
        setMinimumSize(new java.awt.Dimension(317, 320));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        headerPanel.setBackground(new java.awt.Color(0, 39, 255));
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerPanelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SaveMyPass");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password Manager");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Privacy_48px_white.png"))); // NOI18N

        btnMainClose.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        btnMainClose.setForeground(new java.awt.Color(255, 255, 255));
        btnMainClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Cancel_24px_white.png"))); // NOI18N
        btnMainClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMainClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMainCloseMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnMainClose)
                        .addGap(18, 18, 18))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
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
                        .addComponent(btnMainClose)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(headerPanel);
        headerPanel.setBounds(0, 0, 320, 120);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed(evt);
            }
        });

        txtPin.setEditable(false);
        txtPin.setBackground(new java.awt.Color(255, 255, 255));
        txtPin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPinMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Master PIN");

        btnLogin.setBackground(new java.awt.Color(51, 153, 255));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login");

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        forgotPin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forgotPin.setForeground(new java.awt.Color(51, 153, 255));
        forgotPin.setText("Forgot PIN");
        forgotPin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forgotPinMousePressed(evt);
            }
        });

        separator.setBackground(new java.awt.Color(255, 255, 255));
        separator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separator.setOpaque(true);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(forgotPin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(forgotPin))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 120, 320, 200);

        keyboardHeaderPanel.setBackground(new java.awt.Color(0, 39, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Virtual Keyboard");

        btnSecondaryClose.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        btnSecondaryClose.setForeground(new java.awt.Color(255, 255, 255));
        btnSecondaryClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Cancel_24px_white.png"))); // NOI18N
        btnSecondaryClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSecondaryClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSecondaryCloseMousePressed(evt);
            }
        });

        javax.swing.GroupLayout keyboardHeaderPanelLayout = new javax.swing.GroupLayout(keyboardHeaderPanel);
        keyboardHeaderPanel.setLayout(keyboardHeaderPanelLayout);
        keyboardHeaderPanelLayout.setHorizontalGroup(
            keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyboardHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyboardHeaderPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSecondaryClose))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        keyboardHeaderPanelLayout.setVerticalGroup(
            keyboardHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyboardHeaderPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnSecondaryClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        getContentPane().add(keyboardHeaderPanel);
        keyboardHeaderPanel.setBounds(320, 0, 240, 120);

        keyboardMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        closeKeyboard.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        closeKeyboard.setForeground(new java.awt.Color(51, 153, 255));
        closeKeyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pck/img/Back To_24px.png"))); // NOI18N
        closeKeyboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeKeyboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeKeyboardMousePressed(evt);
            }
        });

        lblNum1.setBackground(new java.awt.Color(51, 153, 255));
        lblNum1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum1.setForeground(new java.awt.Color(255, 255, 255));
        lblNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1.setText("1");
        lblNum1.setOpaque(true);

        lblNum2.setBackground(new java.awt.Color(51, 153, 255));
        lblNum2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum2.setForeground(new java.awt.Color(255, 255, 255));
        lblNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2.setText("2");
        lblNum2.setOpaque(true);

        lblNum3.setBackground(new java.awt.Color(51, 153, 255));
        lblNum3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum3.setForeground(new java.awt.Color(255, 255, 255));
        lblNum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum3.setText("3");
        lblNum3.setOpaque(true);

        lblNum4.setBackground(new java.awt.Color(51, 153, 255));
        lblNum4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum4.setForeground(new java.awt.Color(255, 255, 255));
        lblNum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum4.setText("4");
        lblNum4.setOpaque(true);

        lblNum5.setBackground(new java.awt.Color(51, 153, 255));
        lblNum5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum5.setForeground(new java.awt.Color(255, 255, 255));
        lblNum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum5.setText("5");
        lblNum5.setOpaque(true);

        lblNum6.setBackground(new java.awt.Color(51, 153, 255));
        lblNum6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum6.setForeground(new java.awt.Color(255, 255, 255));
        lblNum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum6.setText("6");
        lblNum6.setOpaque(true);

        lblNum7.setBackground(new java.awt.Color(51, 153, 255));
        lblNum7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum7.setForeground(new java.awt.Color(255, 255, 255));
        lblNum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum7.setText("7");
        lblNum7.setOpaque(true);

        lblNum8.setBackground(new java.awt.Color(51, 153, 255));
        lblNum8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum8.setForeground(new java.awt.Color(255, 255, 255));
        lblNum8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum8.setText("8");
        lblNum8.setOpaque(true);

        lblNum9.setBackground(new java.awt.Color(51, 153, 255));
        lblNum9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum9.setForeground(new java.awt.Color(255, 255, 255));
        lblNum9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum9.setText("9");
        lblNum9.setOpaque(true);

        lblNum0.setBackground(new java.awt.Color(51, 153, 255));
        lblNum0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNum0.setForeground(new java.awt.Color(255, 255, 255));
        lblNum0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum0.setText("0");
        lblNum0.setOpaque(true);

        btnClear.setBackground(new java.awt.Color(51, 153, 255));
        btnClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClear.setText("Clear");
        btnClear.setOpaque(true);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClearMousePressed(evt);
            }
        });

        javax.swing.GroupLayout keyboardMainPanelLayout = new javax.swing.GroupLayout(keyboardMainPanel);
        keyboardMainPanel.setLayout(keyboardMainPanelLayout);
        keyboardMainPanelLayout.setHorizontalGroup(
            keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                .addComponent(closeKeyboard)
                .addGap(28, 28, 28)
                .addGroup(keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                        .addComponent(lblNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                        .addComponent(lblNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                        .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                        .addComponent(lblNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        keyboardMainPanelLayout.setVerticalGroup(
            keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyboardMainPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(keyboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyboardMainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeKeyboard)
                .addContainerGap())
        );

        getContentPane().add(keyboardMainPanel);
        keyboardMainPanel.setBounds(320, 120, 240, 200);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Customization.applyDraggability(headerPanel, this);
        Customization.underlineText(forgotPin);
        KeyboardHandler.applyVirtualKeyboardButtonsProperties(keyboardButtons);
        
        //Adds the event listener of clicking on the virtual keyboard buttons.
        /*  Doesn't start on 0 because the first element
        of the array is the clear button and it must NOT have this event listener.  */
        for (int i = 1; i < keyboardButtons.length; i++) {
            if(i > 0) {
                keyboardButtons[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        keyboardButtonsMousePressed(evt);
                    }
                });
            }
        }
    }//GEN-LAST:event_formComponentShown
            
    private void headerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerPanelMouseClicked
        closeVirtualKeyboard();
    }//GEN-LAST:event_headerPanelMouseClicked

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMousePressed
        String pin = getCurrentPin();
        String pinValueFromDatabase = "123456"; //Example for testing.
        if(pin.equals(pinValueFromDatabase)) {
            //Session started, user is logged in.
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            this.dispose();
        } else if(pin.isEmpty()) {
            //Pin field is empty.
            JOptionPane.showMessageDialog(null, "PIN field is empty.", "Empty PIN!", JOptionPane.WARNING_MESSAGE);
        }else{
            //Wrong PIN.
            JOptionPane.showMessageDialog(null, "Wrong PIN. Try again!", "Invalid PIN!", JOptionPane.WARNING_MESSAGE);
            txtPin.setText(null);
        }
    }//GEN-LAST:event_btnLoginMousePressed

    private void closeKeyboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeKeyboardMousePressed
        closeVirtualKeyboard();
    }//GEN-LAST:event_closeKeyboardMousePressed

    private void txtPinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPinMousePressed
        openVirtualKeyboard();
    }//GEN-LAST:event_txtPinMousePressed

    private void forgotPinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPinMousePressed
        ForgotPIN forgot = new ForgotPIN();
        forgot.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgotPinMousePressed

    private void mainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMousePressed
        closeVirtualKeyboard();
    }//GEN-LAST:event_mainPanelMousePressed

    private void btnClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMousePressed
        txtPin.setText(null);
    }//GEN-LAST:event_btnClearMousePressed

    private void btnSecondaryCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSecondaryCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnSecondaryCloseMousePressed

    private void btnMainCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMainCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnMainCloseMousePressed

    private void forgotPinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPinMouseEntered
        forgotPin.setForeground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }//GEN-LAST:event_forgotPinMouseEntered

    private void forgotPinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPinMouseExited
        forgotPin.setForeground(Constants.BUTTONS_DEFAULT_COLOR);
    }//GEN-LAST:event_forgotPinMouseExited
    
    /**
     * If the virtual keyboard is closed, opens it.
     */
    private void openVirtualKeyboard() {
        if(!isKeyboardOpen) {
            this.setSize(Constants.LOGIN_SIZE_WITH_KEYBOARD);
            btnMainClose.setVisible(false);
            separator.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_OPEN);
            KeyboardHandler.generateNewNumbersForKeyboard(keyboardButtons);
            isKeyboardOpen = true;
        }
    }
    
    /**
     * If the virtual keyboard is opened, closes it.
     */
    private void closeVirtualKeyboard() {
        if(isKeyboardOpen) {
            this.setSize(Constants.LOGIN_DEFAULT_SIZE);
            btnMainClose.setVisible(true);
            separator.setBackground(Constants.KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_CLOSE);
            isKeyboardOpen = false;
        }
    }
    
    /**
     * Handles the mouse pressed event of keyboard buttons.
     * @param evt MouseEvent
     */
    private void keyboardButtonsMousePressed(java.awt.event.MouseEvent evt) {
        JLabel button = (JLabel) evt.getComponent();
        String buttonNumber = button.getText();
        int pinCurrentLength = txtPin.getPassword().length;
        
        //Checks if the next number can fit into the 6-digit pin.
        if(pinCurrentLength + 1 < 6)
            addNumberToPin(buttonNumber);
        else if(pinCurrentLength + 1 == 6) {
            addNumberToPin(buttonNumber);
            closeVirtualKeyboard();
        } else
            closeVirtualKeyboard();
    }
    
    /**
     * Adds the new number entered by the virtual keyboard to the pin field.
     * @param number Number to be added (String).
     */
    private void addNumberToPin(String number) {
        String currentPin = getCurrentPin();
        txtPin.setText(currentPin + number);
    }
    
    /**
     * Gets the current pin from the pin field and returns it as a string.
     * @return String
     */
    private String getCurrentPin() {
        return String.valueOf(txtPin.getPassword());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the theme look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If theme (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClear;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel btnMainClose;
    private javax.swing.JLabel btnSecondaryClose;
    private javax.swing.JLabel closeKeyboard;
    private javax.swing.JLabel forgotPin;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
