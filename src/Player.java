
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;


@SuppressWarnings("serial")
public class Player extends javax.swing.JFrame {
    
    @SuppressWarnings("unused")
	private boolean textfieldempty = false;
    boolean playing;
    File choosed;
    Main run = new Main();

    public Player() {
        initComponents();

    }

    @SuppressWarnings("unused")
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblChoose = new javax.swing.JLabel();
        textfield = new javax.swing.JTextField();
        open = new javax.swing.JButton();
        play_pause = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        lblVol = new javax.swing.JLabel();
        volSlider = new javax.swing.JSlider();
        lblOpen = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CODER ACJHP");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/music.png")));

        lblChoose.setText("Choosed File :");

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconEject.png"))); // NOI18N
        open.setToolTipText("Only(.mp3 /.wav/.au/.midi)");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconPlay.png"))); // NOI18N
        play_pause.setText("Play");
        play_pause.setEnabled(false);
        play_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_pauseActionPerformed(evt);
            }
        });

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconStop.png"))); // NOI18N
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        lblVol.setText("Volume : 6%");

        int z=0,x=0;
        volSlider.setForeground(new java.awt.Color(255, 0, 0));
        volSlider.setMajorTickSpacing(1);
        volSlider.setMaximum(z=(int) Math.round(6.0206));
        volSlider.setMinimum(x=(int) Math.round(-80.0));
        volSlider.setValue(6);
        volSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volSliderStateChanged(evt);
            }
        });

        lblOpen.setText(" Open File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(play_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(volSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVol))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(open)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(play_pause)
                            .addComponent(stop)))
                    .addComponent(volSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpen)
                    .addComponent(lblVol))
                .addGap(20, 20, 20))
        );

        volSlider.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
       
        if (evt.getSource() == stop) {
            if (textfield.getText().isEmpty()) {
                textfield.setText("There is Nothing To Stop.");
                textfield.setBackground(new Color(242, 220, 82));
                playing = false;
            } else{
                run.Stop();
                play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconPlay.png"))); // NOI18N
                play_pause.setText("Play");
                textfield.setText(" ");
                textfieldempty = false;
                playing = false;
                choosed = null;
            }
        }
    }//GEN-LAST:event_stopActionPerformed

    @SuppressWarnings("static-access")
	private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        if (evt.getSource() == open) {
            JFileChooser sec = new JFileChooser();
            int result = sec.showOpenDialog(this);
            if (result == sec.APPROVE_OPTION) {
                choosed = sec.getSelectedFile();
                textfield.setText(choosed.getName());
                play_pause.setEnabled(true);
            }
        }
    }//GEN-LAST:event_openActionPerformed

    private void play_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_pauseActionPerformed
        if (evt.getSource() == play_pause) {
            
            if (play_pause.getText().equals("Play")) {
                if (choosed.getName().contains(".wav") || choosed.getName().contains(".mp3")) {
                    textfield.setBackground(new Color(255, 255, 255));
                    play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconPause.png"))); // NOI18N
                    play_pause.setText("Pause");
                    playing = true;
                    try {
                        run.Play(choosed);
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }else{
                    textfield.setBackground(Color.PINK);
                    textfield.setText("File Not Supported!");
                    playing = false;
                }
                
            }else {
                try {
                    run.pause();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                play_pause.setEnabled(true);
                play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconPlay.png"))); // NOI18N
                play_pause.setText("Play");
                playing = false;
            }

        }

    }//GEN-LAST:event_play_pauseActionPerformed

    private void volSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volSliderStateChanged
        if (evt.getSource() == volSlider) {
            run.VolCon(volSlider.getValue());
            lblVol.setText("Volume : " + volSlider.getValue() + "%");
        }
    }//GEN-LAST:event_volSliderStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChoose;
    private javax.swing.JLabel lblOpen;
    private javax.swing.JLabel lblVol;
    private javax.swing.JButton open;
    private javax.swing.JButton play_pause;
    private javax.swing.JButton stop;
    private javax.swing.JTextField textfield;
    private javax.swing.JSlider volSlider;
    // End of variables declaration//GEN-END:variables
}
