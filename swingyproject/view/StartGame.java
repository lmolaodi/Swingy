package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utilities.characters.Hero;

public class StartGame extends JPanel{

    private Hero hero = null;

    public StartGame(Hero hero)
    {
        initiateStart();
        this.hero = hero;
    }

    private void initiateStart() {
        
        JScrollPane mapScrollPane = new JScrollPane();
        JTextArea mapDisplayArea = new JTextArea();
        JTextArea heroStatsDisplay = new JTextArea();
        JButton northButton = new JButton();
        JButton westButton = new JButton();
        JButton eastButton = new JButton();
        JButton southButton = new JButton();
        JButton mainMenuButton = new JButton();
        JButton heroAttributesButton = new JButton();
        JButton helpButton = new JButton();
        JButton backButton = new JButton();

        mapDisplayArea.setColumns(20);
        mapDisplayArea.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        mapDisplayArea.setRows(5);
        mapScrollPane.setViewportView(mapDisplayArea);

        heroStatsDisplay.setColumns(20);
        heroStatsDisplay.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroStatsDisplay.setRows(5);
        heroStatsDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        northButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        northButton.setText("North");
        northButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        northButton.setMaximumSize(new java.awt.Dimension(165, 30));
        northButton.setMinimumSize(new java.awt.Dimension(165, 30));
        northButton.setPreferredSize(new java.awt.Dimension(165, 30));
        northButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //northButtonActionPerformed(evt);
            }
        });

        westButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        westButton.setText("West");
        westButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        westButton.setMaximumSize(new java.awt.Dimension(165, 30));
        westButton.setMinimumSize(new java.awt.Dimension(165, 30));
        westButton.setPreferredSize(new java.awt.Dimension(165, 30));
        westButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //westButtonActionPerformed(evt);
            }
        });

        eastButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        eastButton.setText("East");
        eastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eastButton.setMaximumSize(new java.awt.Dimension(60, 50));
        eastButton.setMinimumSize(new java.awt.Dimension(60, 50));
        eastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //eastButtonActionPerformed(evt);
            }
        });

        southButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        southButton.setText("South");
        southButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        southButton.setPreferredSize(new java.awt.Dimension(60, 50));
        southButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //southButtonActionPerformed(evt);
            }
        });

        mainMenuButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setMaximumSize(new java.awt.Dimension(165, 30));
        mainMenuButton.setMinimumSize(new java.awt.Dimension(165, 30));
        mainMenuButton.setPreferredSize(new java.awt.Dimension(165, 30));
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //mainMenuButtonActionPerformed(evt);
            }
        });

        heroAttributesButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroAttributesButton.setText("Hero Attributes");
        heroAttributesButton.setMaximumSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.setMinimumSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.setPreferredSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //heroAttributesButtonActionPerformed(evt);
            }
        });

        helpButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        helpButton.setText("Help");
        helpButton.setPreferredSize(new java.awt.Dimension(165, 30));
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //helpButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setPreferredSize(new java.awt.Dimension(165, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mapScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(heroAttributesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(heroStatsDisplay, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(westButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(northButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(southButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heroAttributesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(heroStatsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(northButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(westButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(southButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }
}
