package view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.SwitchView;
import utilities.CreateHero;
import utilities.ExitGame;
import controler.Main;
import view.GuiFrame;

public class Gui extends javax.swing.JPanel {

    public Gui() {
        initComponents();
    }

    private javax.swing.JButton backButton;
    private javax.swing.JButton loadConsoleButton;

    private void initComponents() {
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel Title = new javax.swing.JLabel();
        JButton startButton = new javax.swing.JButton();
        JButton loadButton = new javax.swing.JButton();
        JButton switchViewButton = new javax.swing.JButton();
        JButton exitButton = new javax.swing.JButton();
        JButton createButton = new javax.swing.JButton();
        JLabel versionLabel = new javax.swing.JLabel();

        ExitGame exitGame = new ExitGame();
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));

        Title.setFont(new java.awt.Font("Courier", 0, 95));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Swingy Game");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        startButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        startButton.setText("Start Game");
        startButton.setMaximumSize(new java.awt.Dimension(165, 30));
        startButton.setMinimumSize(new java.awt.Dimension(165, 30));
        startButton.setPreferredSize(new java.awt.Dimension(165, 30));
        startButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGameFrame startGame = new StartGameFrame();
                startGame.initialiseView();
            }
        });

        loadButton.setFont(new java.awt.Font("Courier", 0, 13));
        loadButton.setText("Load Game");
        loadButton.setMaximumSize(new java.awt.Dimension(165, 30));
        loadButton.setMinimumSize(new java.awt.Dimension(165, 30));
        loadButton.setPreferredSize(new java.awt.Dimension(165, 30));
        loadButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // loadButtonActionPerformed(evt);
            }
        });

        switchViewButton.setFont(new java.awt.Font("Courier", 0, 13));
        switchViewButton.setText("Change View");
        switchViewButton.setMaximumSize(new java.awt.Dimension(165, 30));
        switchViewButton.setMinimumSize(new java.awt.Dimension(165, 30));

        switchViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SwitchViewFrame gui = new SwitchViewFrame();
                    gui.initialiseView();
            }
        });

        exitButton.setFont(new java.awt.Font("Courier", 0, 13));
        exitButton.setText("Exit");
        exitButton.setMaximumSize(new java.awt.Dimension(165, 30));
        exitButton.setMinimumSize(new java.awt.Dimension(165, 30));
        exitButton.setPreferredSize(new java.awt.Dimension(165, 30));
        exitButton.addActionListener(exitGame);

        versionLabel.setFont(new java.awt.Font("Courier", 0, 12));
        versionLabel.setText("v1.1");

        createButton.setFont(new java.awt.Font("Courier", 0, 13));
        createButton.setText("Create Player");
        createButton.setMaximumSize(new java.awt.Dimension(165, 30));
        createButton.setMinimumSize(new java.awt.Dimension(165, 30));
        createButton.setPreferredSize(new java.awt.Dimension(165, 30));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateHeroFrame hero = new CreateHeroFrame();
                hero.initialiseView();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(switchViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(
                                        exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(175, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup()
                                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 700,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(175, 175, 175))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addComponent(versionLabel).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(switchViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42).addComponent(versionLabel).addContainerGap()));
    }
                }
