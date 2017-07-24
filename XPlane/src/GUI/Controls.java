package GUI;


import Tools.Messenger;
import Tools.ByteArrayTool;
import InputDataTools.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamaa
 */
public class Controls extends javax.swing.JFrame {

    /**
     * Creates new form Controls
     */
    public Controls() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pitch = new javax.swing.JSlider();
        roll = new javax.swing.JSlider();
        yaw = new javax.swing.JSlider();
        cPitch = new javax.swing.JButton();
        cRoll = new javax.swing.JButton();
        cYaw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XP-C");

        jLabel1.setText("ELEV");

        jLabel2.setText("AILRN");

        jLabel3.setText("RUDDR");

        jLabel4.setText("NAVIGATION");

        pitch.setForeground(new java.awt.Color(153, 0, 0));
        pitch.setMaximum(200);
        pitch.setMinimum(-310);
        pitch.setOrientation(javax.swing.JSlider.VERTICAL);
        pitch.setValue(0);
        pitch.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                pitchStateChanged(evt);
            }
        });

        roll.setForeground(new java.awt.Color(153, 0, 0));
        roll.setMaximum(260);
        roll.setMinimum(-260);
        roll.setOrientation(javax.swing.JSlider.VERTICAL);
        roll.setValue(0);
        roll.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                rollStateChanged(evt);
            }
        });

        yaw.setForeground(new java.awt.Color(153, 0, 0));
        yaw.setMaximum(600);
        yaw.setMinimum(-600);
        yaw.setOrientation(javax.swing.JSlider.VERTICAL);
        yaw.setValue(0);
        yaw.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                yawStateChanged(evt);
            }
        });

        cPitch.setText("C");
        cPitch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cPitchActionPerformed(evt);
            }
        });

        cRoll.setText("C");
        cRoll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cRollActionPerformed(evt);
            }
        });

        cYaw.setText("C");
        cYaw.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cYawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cPitch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(cRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cYaw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(yaw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yaw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cYaw)
                    .addComponent(cRoll)
                    .addComponent(cPitch))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pitchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pitchStateChanged
        // TODO add your handling code here:
	float sensor = ((float)pitch.getModel().getValue())/10;
        byte[] value = ByteArrayTool.float2ByteArray(sensor);
	byte[] XPData = ByteArrayTool.getXPData("pitch", value);
        System.out.println("Sending PITCH: "+sensor);
	Messenger.sendMessage(XPData);
	//ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_pitchStateChanged

    private void rollStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rollStateChanged
        // TODO add your handling code here:
	float sensor = ((float)roll.getModel().getValue())/10;
        byte[] value = ByteArrayTool.float2ByteArray(sensor);
	byte[] XPData = ByteArrayTool.getXPData("roll", value);
        System.out.println("Sending ROLL: "+sensor);
	Messenger.sendMessage(XPData);
	//ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_rollStateChanged

    private void yawStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yawStateChanged
        // TODO add your handling code here:
        float sensor = ((float)yaw.getModel().getValue())/10;
        byte[] value = ByteArrayTool.float2ByteArray(sensor);
	byte[] XPData = ByteArrayTool.getXPData("yaw", value);
        System.out.println("Sending YAW: "+sensor);
	Messenger.sendMessage(XPData);
	//ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_yawStateChanged

    private void cPitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPitchActionPerformed
        // TODO add your handling code here:
        pitch.setValue(0);
    }//GEN-LAST:event_cPitchActionPerformed

    private void cRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cRollActionPerformed
        // TODO add your handling code here:
        roll.setValue(0);
    }//GEN-LAST:event_cRollActionPerformed

    private void cYawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cYawActionPerformed
        // TODO add your handling code here:
        yaw.setValue(0);
    }//GEN-LAST:event_cYawActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controls().setVisible(true);
            }
        });
	Service.executeService();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cPitch;
    private javax.swing.JButton cRoll;
    private javax.swing.JButton cYaw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider pitch;
    private javax.swing.JSlider roll;
    private javax.swing.JSlider yaw;
    // End of variables declaration//GEN-END:variables
}
