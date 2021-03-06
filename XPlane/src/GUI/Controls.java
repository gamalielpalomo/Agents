package GUI;


import Tools.Messenger;
import Tools.ByteArrayTool;
import DREF.DREF_Builders;
import jade.Boot;
import javax.sound.midi.ShortMessage;


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

        jSlider1 = new javax.swing.JSlider();
        Frame_principal = new javax.swing.JInternalFrame();
        cRoll = new javax.swing.JButton();
        cYaw = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eng_throttle = new javax.swing.JSlider();
        yaw = new javax.swing.JSlider();
        pitch = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        cPitch = new javax.swing.JButton();
        roll = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        brakeSwitch = new javax.swing.JToggleButton();
        flapSlider = new javax.swing.JSlider();
        flapClearButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Frame_multiplayer = new javax.swing.JInternalFrame();
        craft = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        mult_elev_slider = new javax.swing.JSlider();
        mult_ail_slider = new javax.swing.JSlider();
        mult_ruddr_slider = new javax.swing.JSlider();
        mult_elev_clear = new javax.swing.JButton();
        mult_ail_clear = new javax.swing.JButton();
        mult_ruddr_clear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        playSim = new javax.swing.JButton();
        loadScenario = new javax.swing.JButton();
        harvestData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XP-C");
        setResizable(false);

        Frame_principal.setVisible(true);

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

        jLabel1.setText("ELEV");

        jLabel4.setText("PRINCIPAL");

        eng_throttle.setOrientation(javax.swing.JSlider.VERTICAL);
        eng_throttle.setValue(0);
        eng_throttle.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                eng_throttleStateChanged(evt);
            }
        });

        yaw.setForeground(new java.awt.Color(153, 0, 0));
        yaw.setMaximum(10);
        yaw.setMinimum(-10);
        yaw.setOrientation(javax.swing.JSlider.VERTICAL);
        yaw.setValue(0);
        yaw.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                yawStateChanged(evt);
            }
        });

        pitch.setForeground(new java.awt.Color(153, 0, 0));
        pitch.setMaximum(10);
        pitch.setMinimum(-10);
        pitch.setOrientation(javax.swing.JSlider.VERTICAL);
        pitch.setValue(0);
        pitch.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                pitchStateChanged(evt);
            }
        });

        jLabel2.setText("AILRN");

        cPitch.setText("C");
        cPitch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cPitchActionPerformed(evt);
            }
        });

        roll.setForeground(new java.awt.Color(153, 0, 0));
        roll.setMaximum(10);
        roll.setMinimum(-10);
        roll.setOrientation(javax.swing.JSlider.VERTICAL);
        roll.setValue(0);
        roll.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                rollStateChanged(evt);
            }
        });

        jLabel6.setText("THROTTLE");

        jLabel3.setText("RUDDR");

        brakeSwitch.setText("BRAKES");
        brakeSwitch.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                brakeSwitchStateChanged(evt);
            }
        });
        brakeSwitch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brakeSwitchActionPerformed(evt);
            }
        });

        flapSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        flapSlider.setPaintLabels(true);
        flapSlider.setValue(0);
        flapSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                flapSliderStateChanged(evt);
            }
        });

        flapClearButton.setText("C");
        flapClearButton.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                flapClearButtonStateChanged(evt);
            }
        });
        flapClearButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                flapClearButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("FLAP");

        javax.swing.GroupLayout Frame_principalLayout = new javax.swing.GroupLayout(Frame_principal.getContentPane());
        Frame_principal.getContentPane().setLayout(Frame_principalLayout);
        Frame_principalLayout.setHorizontalGroup(
            Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_principalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Frame_principalLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel4))
                            .addComponent(brakeSwitch)
                            .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(flapClearButton)
                                .addGroup(Frame_principalLayout.createSequentialGroup()
                                    .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(Frame_principalLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(Frame_principalLayout.createSequentialGroup()
                                            .addComponent(eng_throttle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)))
                                    .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Frame_principalLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(flapSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel11)))))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(Frame_principalLayout.createSequentialGroup()
                        .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Frame_principalLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cPitch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Frame_principalLayout.createSequentialGroup()
                                .addComponent(cRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cYaw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(Frame_principalLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(yaw, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        Frame_principalLayout.setVerticalGroup(
            Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(brakeSwitch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(yaw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(flapSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eng_throttle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Frame_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPitch)
                    .addComponent(cYaw)
                    .addComponent(cRoll)
                    .addComponent(flapClearButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Frame_multiplayer.setVisible(true);

        jLabel5.setText("AIRCRAFT");

        mult_elev_slider.setMaximum(10);
        mult_elev_slider.setMinimum(-10);
        mult_elev_slider.setOrientation(javax.swing.JSlider.VERTICAL);
        mult_elev_slider.setValue(0);
        mult_elev_slider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                mult_elev_sliderStateChanged(evt);
            }
        });

        mult_ail_slider.setMaximum(10);
        mult_ail_slider.setMinimum(-10);
        mult_ail_slider.setOrientation(javax.swing.JSlider.VERTICAL);
        mult_ail_slider.setValue(0);
        mult_ail_slider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                mult_ail_sliderStateChanged(evt);
            }
        });

        mult_ruddr_slider.setMaximum(10);
        mult_ruddr_slider.setMinimum(-10);
        mult_ruddr_slider.setOrientation(javax.swing.JSlider.VERTICAL);
        mult_ruddr_slider.setValue(0);
        mult_ruddr_slider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                mult_ruddr_sliderStateChanged(evt);
            }
        });

        mult_elev_clear.setText("C");
        mult_elev_clear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mult_elev_clearActionPerformed(evt);
            }
        });

        mult_ail_clear.setText("C");
        mult_ail_clear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mult_ail_clearActionPerformed(evt);
            }
        });

        mult_ruddr_clear.setText("C");
        mult_ruddr_clear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mult_ruddr_clearActionPerformed(evt);
            }
        });

        jLabel7.setText("MULTIPLAYER");

        jLabel8.setText("ELEV");

        jLabel9.setText("AILRN");

        jLabel10.setText("RUDDR");

        javax.swing.GroupLayout Frame_multiplayerLayout = new javax.swing.GroupLayout(Frame_multiplayer.getContentPane());
        Frame_multiplayer.getContentPane().setLayout(Frame_multiplayerLayout);
        Frame_multiplayerLayout.setHorizontalGroup(
            Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(craft, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                                .addComponent(mult_elev_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mult_ail_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(mult_ruddr_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(mult_elev_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mult_ail_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mult_ruddr_clear))
                    .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Frame_multiplayerLayout.setVerticalGroup(
            Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_multiplayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(24, 24, 24)
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(craft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(11, 11, 11)
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mult_elev_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mult_ail_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mult_ruddr_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Frame_multiplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mult_elev_clear)
                    .addComponent(mult_ail_clear)
                    .addComponent(mult_ruddr_clear))
                .addContainerGap())
        );

        playSim.setText("Play Sim");
        playSim.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                playSimActionPerformed(evt);
            }
        });

        loadScenario.setText("Load Scenario");

        harvestData.setText("Harvest");
        harvestData.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                harvestDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Frame_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Frame_multiplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadScenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(harvestData, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loadScenario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(harvestData))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Frame_multiplayer)
                        .addComponent(Frame_principal)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_rollStateChanged
    {//GEN-HEADEREND:event_rollStateChanged
        // TODO add your handling code here:
        float sensor = ((float)roll.getModel().getValue())/10;
        byte []XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/roll_ratio[0]", sensor);
        //System.out.println("ROLL ratio: "+sensor);
	//byte []XPData = DREF_Builders.createDREF("sim/multiplayer/controls/yoke_roll_ratio", sensor);
        Messenger.sendMessage(XPData);
        //ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_rollStateChanged

    private void cPitchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cPitchActionPerformed
    {//GEN-HEADEREND:event_cPitchActionPerformed
        // TODO add your handling code here:
        pitch.setValue(0);
    }//GEN-LAST:event_cPitchActionPerformed

    private void pitchStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_pitchStateChanged
    {//GEN-HEADEREND:event_pitchStateChanged
        // TODO add your handling code here:
        float sensor = ((float)pitch.getModel().getValue())/10;
        byte []values = ByteArrayTool.float2ByteArray(sensor);
        byte []XPData = ByteArrayTool.getXPData("pitch", values);
         //byte []XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/pitch_ratio[0]", sensor);
	//byte []XPData = DREF_Builders.createDREF("sim/multiplayer/controls/elevator_trim[0]", sensor);
        //System.out.println("PITCH ratio: "+sensor);
        Messenger.sendMessage(XPData);
        //ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_pitchStateChanged

    private void yawStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_yawStateChanged
    {//GEN-HEADEREND:event_yawStateChanged
        // TODO add your handling code here:
        float sensor = ((float)yaw.getModel().getValue())/10;
        byte[] XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/heading_ratio[0]", sensor);
	//byte []XPData = DREF_Builders.createDREF("sim/multiplayer/controls/yoke_heading_ratio", sensor);
        //System.out.println("Heading ratio: "+sensor);
        Messenger.sendMessage(XPData);
        //ByteArrayTool.printArray(XPData);
    }//GEN-LAST:event_yawStateChanged

    private void eng_throttleStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_eng_throttleStateChanged
    {//GEN-HEADEREND:event_eng_throttleStateChanged
        // TODO add your handling code here:
        float sensor = ((float)eng_throttle.getModel().getValue())/100;
        float []values = new float[]{sensor, sensor, sensor, sensor};
        byte[] XPData = DREF_Builders.createDREF("sim/cockpit2/engine/actuators/throttle_ratio_all[0]", sensor);
        //System.out.println("Throttle: "+sensor*100+"%");
        Messenger.sendMessage(XPData);
    }//GEN-LAST:event_eng_throttleStateChanged

    private void cYawActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cYawActionPerformed
    {//GEN-HEADEREND:event_cYawActionPerformed
        // TODO add your handling code here:
        yaw.setValue(0);
    }//GEN-LAST:event_cYawActionPerformed

    private void cRollActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cRollActionPerformed
    {//GEN-HEADEREND:event_cRollActionPerformed
        // TODO add your handling code here:
        roll.setValue(0);
    }//GEN-LAST:event_cRollActionPerformed

    private void mult_elev_clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mult_elev_clearActionPerformed
    {//GEN-HEADEREND:event_mult_elev_clearActionPerformed
        // TODO add your handling code here:
	mult_elev_slider.setValue(0);
    }//GEN-LAST:event_mult_elev_clearActionPerformed

    private void mult_ail_clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mult_ail_clearActionPerformed
    {//GEN-HEADEREND:event_mult_ail_clearActionPerformed
        // TODO add your handling code here:
	mult_ail_slider.setValue(0);
    }//GEN-LAST:event_mult_ail_clearActionPerformed

    private void mult_ruddr_clearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mult_ruddr_clearActionPerformed
    {//GEN-HEADEREND:event_mult_ruddr_clearActionPerformed
        // TODO add your handling code here:
	mult_ruddr_slider.setValue(0);
    }//GEN-LAST:event_mult_ruddr_clearActionPerformed

    private void mult_elev_sliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_mult_elev_sliderStateChanged
    {//GEN-HEADEREND:event_mult_elev_sliderStateChanged
        // TODO add your handling code here:
	float sensor = ((float)mult_elev_slider.getModel().getValue())/100;
        float []values = new float[]{sensor, sensor, sensor, sensor};
	String drefName = "sim/multiplayer/controls/elevator_trim"+"["+(int)craft.getModel().getValue()+"]";
        byte[] XPData = DREF_Builders.createDREF(drefName, sensor);
        //System.out.println("Heading ratio: "+sensor*100+"%");
        Messenger.sendMessage(XPData);
    }//GEN-LAST:event_mult_elev_sliderStateChanged

    private void mult_ail_sliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_mult_ail_sliderStateChanged
    {//GEN-HEADEREND:event_mult_ail_sliderStateChanged
        // TODO add your handling code here:
	float sensor = ((float)mult_ail_slider.getModel().getValue())/100;
	String drefName = "sim/multiplayer/controls/aileron_trim"+"["+(int)craft.getModel().getValue()+"]";
        byte[] XPData = DREF_Builders.createDREF(drefName, sensor);
        //System.out.println("Heading ratio: "+sensor*100+"%");
        Messenger.sendMessage(XPData);
    }//GEN-LAST:event_mult_ail_sliderStateChanged

    private void playSimActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_playSimActionPerformed
    {//GEN-HEADEREND:event_playSimActionPerformed
        // TODO add your handling code here:
	String []jade_args = {"-gui", "Pilot:JADE.Pilot"};
	//String []jade_args = {"-gui"};
	Boot.main(jade_args);
    }//GEN-LAST:event_playSimActionPerformed

    private void mult_ruddr_sliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_mult_ruddr_sliderStateChanged
    {//GEN-HEADEREND:event_mult_ruddr_sliderStateChanged
        // TODO add your handling code here:
	float sensor = ((float)mult_ruddr_slider.getModel().getValue())/100;
	String drefName = "sim/multiplayer/controls/rudder_trim"+"["+(int)craft.getModel().getValue()+"]";
        byte[] XPData = DREF_Builders.createDREF(drefName, sensor);
        //System.out.println("Heading ratio: "+sensor*100+"%");
        Messenger.sendMessage(XPData);
    }//GEN-LAST:event_mult_ruddr_sliderStateChanged

    private void harvestDataActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_harvestDataActionPerformed
    {//GEN-HEADEREND:event_harvestDataActionPerformed
        // TODO add your handling code here:
	Thread haverstThread = Tools.DataHarvest.Harvest();
	haverstThread.start();
    }//GEN-LAST:event_harvestDataActionPerformed

    private void brakeSwitchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_brakeSwitchActionPerformed
    {//GEN-HEADEREND:event_brakeSwitchActionPerformed
        // TODO add your handling code here:
	String drefName = "sim/multiplayer/controls/parking_brake[0]";
	byte[] XPData;
	if(brakeSwitch.isSelected()){
	    XPData = DREF_Builders.createDREF(drefName, 1f);
	}
	else
	    XPData = DREF_Builders.createDREF(drefName, 0f);
	   
	Messenger.sendMessage(XPData);
    }//GEN-LAST:event_brakeSwitchActionPerformed

    private void brakeSwitchStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_brakeSwitchStateChanged
    {//GEN-HEADEREND:event_brakeSwitchStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_brakeSwitchStateChanged

    private void flapSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_flapSliderStateChanged
    {//GEN-HEADEREND:event_flapSliderStateChanged
        // TODO add your handling code here:
        float sensor = ((float)flapSlider.getModel().getValue())/100;
        byte[] XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/flap_handle_deploy_ratio[0]", sensor);
        //System.out.println("Throttle: "+sensor*100+"%");
        Messenger.sendMessage(XPData);	
    }//GEN-LAST:event_flapSliderStateChanged

    private void flapClearButtonStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_flapClearButtonStateChanged
    {//GEN-HEADEREND:event_flapClearButtonStateChanged
        // TODO add your handling code here
    }//GEN-LAST:event_flapClearButtonStateChanged

    private void flapClearButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_flapClearButtonActionPerformed
    {//GEN-HEADEREND:event_flapClearButtonActionPerformed
        // TODO add your handling code here:
	flapSlider.setValue(0);
    }//GEN-LAST:event_flapClearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void setValues(Float [] values){
	
	//values = {ail,elev,ruddr,throttle,brake} 
	if(values[0]!=-999f)
	    pitch.setValue(values[0].intValue());
	if(values[1]!=-999f)
	    yaw.setValue(values[1].intValue());
	if(values[2]!=-999f)
	    roll.setValue(values[2].intValue());
	if(values[3]!=-999f)
	    eng_throttle.setValue(values[4].intValue());
	if(values[4]!=-999f){
	    Boolean brakeValue=false;
	    if(values[5].floatValue()==0f)brakeValue=false; else brakeValue=true;
	    brakeSwitch.setSelected(brakeValue);
	}
	
    }
    public void updateElevator(float value){this.pitch.setValue((int)value*10);}
    public void updateAileron(float value){this.roll.setValue((int)value*10);}
    public void updateYaw(float value){this.yaw.setValue((int)value*10);}
    public void updateThrottle(float value){this.eng_throttle.setValue((int)value*100);}
    public void updateFlaps(float value){this.flapSlider.setValue((int)value*100);}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Frame_multiplayer;
    private javax.swing.JInternalFrame Frame_principal;
    private javax.swing.JToggleButton brakeSwitch;
    private javax.swing.JButton cPitch;
    private javax.swing.JButton cRoll;
    private javax.swing.JButton cYaw;
    private javax.swing.JSpinner craft;
    public javax.swing.JSlider eng_throttle;
    private javax.swing.JButton flapClearButton;
    public javax.swing.JSlider flapSlider;
    private javax.swing.JButton harvestData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton loadScenario;
    private javax.swing.JButton mult_ail_clear;
    private javax.swing.JSlider mult_ail_slider;
    private javax.swing.JButton mult_elev_clear;
    private javax.swing.JSlider mult_elev_slider;
    private javax.swing.JButton mult_ruddr_clear;
    private javax.swing.JSlider mult_ruddr_slider;
    public javax.swing.JSlider pitch;
    private javax.swing.JButton playSim;
    public javax.swing.JSlider roll;
    public javax.swing.JSlider yaw;
    // End of variables declaration//GEN-END:variables
}
