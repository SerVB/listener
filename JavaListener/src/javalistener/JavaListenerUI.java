/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalistener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import jssc.SerialPortException;

/**
 *
 * @author SerVB
 */
public class JavaListenerUI extends javax.swing.JFrame {
    JavaListenerCode jlc = new JavaListenerCode();
    /**
     * Creates new form JavaListener
     * @throws java.io.IOException
     */
    public JavaListenerUI() throws IOException {
        initComponents();
        
        jlc.uiPanelCOM = jPanelCOM;
        jlc.uiPanelSector = jPanelSector;
        jlc.uiPanelSets = jPanelSets;
        jlc.uiPanelLang = jPanelLang;
        jlc.uiPanelRound = jPanelRound;
        jlc.uiPanelOtherSets = jPanelOtherSets;
        jlc.uiPanelParking = jPanelParking;
        jlc.uiPanelButton = jPanelButton;
        jlc.uiPanelStatus = jPanelStatus;    
        jlc.uiPanelStop = jPanelStop;
        
        jlc.uiButtonApplyCOM = jButtonApplyCOM;
        jlc.uiButtonScanningBegin = jButtonScanningBegin;
        jlc.uiButtonLangRus = jButtonLangRus;
        jlc.uiButtonRound = jButtonRound;
        jlc.uiButtonLangEng = jButtonLangEng;
        jlc.uiButtonPark = jButtonPark;
        jlc.uiButtonStopScan = jButtonStopScan;

        jlc.uiLabelCOM = jLabelCOM;
        jlc.uiLabelBaudrate = jLabelBaudrate;
        jlc.uiLabelBaud = jLabelBaud;
        jlc.uiLabelNumOfRep = jLabelNumOfRep;
        jlc.uiLabelMovingType = jLabelMovingType;
        jlc.uiLabelDelay = jLabelDelay;
        jlc.uiLabelMs = jLabelMs;
        jlc.uiLabelInterface = jLabelInterface;
        jlc.uiLabelParkAlt = jLabelParkAlt;
        jlc.uiLabelParkDeg = jLabelParkDeg;
        jlc.uiLabelHor = jLabelHor;
        jlc.uiLabelHorStep = jLabelHorStep;
        jlc.uiLabelVer = jLabelVer;
        jlc.uiLabelVerLine = jLabelVerLine;
        jlc.uiLabelVerUnit = jLabelVerUnit;
        jlc.uiLabelVerAcUnit = jLabelVerAcUnit;
        jlc.uiLabelVerStep = jLabelVerStep;
        jlc.uiLabelTaskHor = jLabelTaskHor;
        jlc.uiLabelTaskHorLine = jLabelTaskHorLine;
        jlc.uiLabelTaskHorStep = jLabelTaskHorStep;
        jlc.uiLabelTaskVer = jLabelTaskVer;
        jlc.uiLabelTaskVerLine = jLabelTaskVerLine;
        jlc.uiLabelTaskVerStep = jLabelTaskVerStep;
        jlc.uiLabelCondition = jLabelCondition;
        jlc.uiLabelRepeatition = jLabelRepeatition; 
        jlc.uiLabelRepOf = jLabelRepOf;
        jlc.uiLabelMeasure = jLabelMeasure;
        jlc.uiLabelMeasOf = jLabelMeasOf;
        jlc.uiLabelSecLittle = jLabelSecLittle;
        jlc.uiLabelSecBig = jLabelSecBig;
        
        jlc.uiLabelPercentBigTitle = jLabelPercentBigTitle;
        jlc.uiLabelPercentLittleTitle = jLabelPercentLittleTitle;
        jlc.uiLabelCurScanLose = jLabelCurScanLose;
        jlc.uiLabelStatus        = jLabelStatus;
        jlc.uiLabelCurRep        = jLabelCurRep;
        jlc.uiLabelTotalRep      = jLabelTotalRep;
        jlc.uiLabelCurMeas       = jLabelCurMeas;
        jlc.uiLabelTotalMeas     = jLabelTotalMeas;
        jlc.uiLabelPercentLittle = jLabelPercentLittle;
        jlc.uiLabelPercentBig    = jLabelPercentBig;
        jlc.uiLabelTaskHorBegin  = jLabelTaskHorBegin;
        jlc.uiLabelTaskHorEnd    = jLabelTaskHorEnd;
        jlc.uiLabelTaskHorAc     = jLabelTaskHorAc;
        jlc.uiLabelTaskVerBegin  = jLabelTaskVerBegin;
        jlc.uiLabelTaskVerEnd    = jLabelTaskVerEnd;
        jlc.uiLabelTaskVerAc     = jLabelTaskVerAc;
        jlc.uiLabelTaskHorUnit   = jLabelTaskHorUnit;
        jlc.uiLabelTaskHorAcUnit = jLabelTaskHorAcUnit;
        jlc.uiLabelTaskVerUnit   = jLabelTaskVerUnit;
        jlc.uiLabelTaskVerAcUnit = jLabelTaskVerAcUnit;
        jlc.uiLabelSBig          = jLabelSBig;
        jlc.uiLabelSLittle       = jLabelSLittle;

        jlc.uiTextBaudrate = jTextFieldBaudrate;
        jlc.uiTextCOM      = jTextFieldCOM;
        jlc.uiTextHorBegin = jTextFieldHorBegin;
        jlc.uiTextHorEnd   = jTextFieldHorEnd;
        jlc.uiTextHorAc    = jTextFieldHorAc;
        jlc.uiTextNumOfRep = jTextFieldNumOfRep;
        jlc.uiTextVerBegin = jTextFieldVerBegin;
        jlc.uiTextVerEnd   = jTextFieldVerEnd;
        jlc.uiTextVerAc    = jTextFieldVerAc;
        jlc.uiTextDelayBeforeMeasure = jTextFieldDelay;
        jlc.uiTextParkAlt = jTextFieldParkAlt;

        jlc.uiComboHorAcUnit  = jComboBoxHorAcUnit;
        jlc.uiComboHorUnit    = jComboBoxHorUnit;
        jlc.uiComboMovingType = jComboBoxMovingType;
        jlc.uiComboSensorType = jComboBoxSensorType;

        jlc.uiProgressBig    = jProgressBarBig;
        jlc.uiProgressLittle = jProgressBarLittle;

        jlc.uiCheckCompareMode = jCheckBoxRadarMode;
        
        jlc.uiPanelCOM = jPanelCOM;
        jlc.uiPanelSector = jPanelSector;
        jlc.uiPanelSets = jPanelSets;
        jlc.uiPanelLang = jPanelLang;
        jlc.uiPanelRound = jPanelRound;
        jlc.uiPanelOtherSets = jPanelOtherSets;
        jlc.uiPanelParking = jPanelParking;
        jlc.uiPanelButton = jPanelButton;
        jlc.uiPanelStatus = jPanelStatus;
        jlc.uiPanelStop = jPanelStop;
        
        jlc.uiButtonApplyCOM = jButtonApplyCOM;
        jlc.uiButtonScanningBegin = jButtonScanningBegin;
        jlc.uiButtonLangRus = jButtonLangRus;
        jlc.uiButtonRound = jButtonRound;
        jlc.uiButtonLangEng = jButtonLangEng;
        jlc.uiButtonPark = jButtonPark;
        jlc.uiButtonStopScan = jButtonStopScan;

        jlc.restoreSettings();
        jlc.changeLang(0);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCOM = new javax.swing.JPanel();
        jLabelCOM = new javax.swing.JLabel();
        jTextFieldCOM = new javax.swing.JTextField();
        jLabelBaudrate = new javax.swing.JLabel();
        jTextFieldBaudrate = new javax.swing.JTextField();
        jLabelBaud = new javax.swing.JLabel();
        jButtonApplyCOM = new javax.swing.JButton();
        jPanelOtherSets = new javax.swing.JPanel();
        jLabelNumOfRep = new javax.swing.JLabel();
        jTextFieldNumOfRep = new javax.swing.JTextField();
        jLabelMovingType = new javax.swing.JLabel();
        jComboBoxMovingType = new javax.swing.JComboBox();
        jLabelDelay = new javax.swing.JLabel();
        jTextFieldDelay = new javax.swing.JTextField();
        jLabelMs = new javax.swing.JLabel();
        jLabelInterface = new javax.swing.JLabel();
        jComboBoxSensorType = new javax.swing.JComboBox();
        jCheckBoxRadarMode = new javax.swing.JCheckBox();
        jButtonScanningBegin = new javax.swing.JButton();
        jPanelLang = new javax.swing.JPanel();
        jButtonLangRus = new javax.swing.JButton();
        jButtonLangEng = new javax.swing.JButton();
        jPanelParking = new javax.swing.JPanel();
        jLabelParkAlt = new javax.swing.JLabel();
        jTextFieldParkAlt = new javax.swing.JTextField();
        jLabelParkDeg = new javax.swing.JLabel();
        jButtonPark = new javax.swing.JButton();
        jPanelSector = new javax.swing.JPanel();
        jPanelSets = new javax.swing.JPanel();
        jLabelHor = new javax.swing.JLabel();
        jTextFieldHorBegin = new javax.swing.JTextField();
        jLabelHorLine = new javax.swing.JLabel();
        jTextFieldHorEnd = new javax.swing.JTextField();
        jComboBoxHorUnit = new javax.swing.JComboBox();
        jComboBoxHorAcUnit = new javax.swing.JComboBox();
        jTextFieldHorAc = new javax.swing.JTextField();
        jLabelHorStep = new javax.swing.JLabel();
        jLabelVer = new javax.swing.JLabel();
        jTextFieldVerBegin = new javax.swing.JTextField();
        jLabelVerLine = new javax.swing.JLabel();
        jTextFieldVerEnd = new javax.swing.JTextField();
        jLabelVerUnit = new javax.swing.JLabel();
        jLabelVerAcUnit = new javax.swing.JLabel();
        jTextFieldVerAc = new javax.swing.JTextField();
        jLabelVerStep = new javax.swing.JLabel();
        jPanelRound = new javax.swing.JPanel();
        jLabelTaskHor = new javax.swing.JLabel();
        jLabelTaskHorBegin = new javax.swing.JLabel();
        jLabelTaskHorLine = new javax.swing.JLabel();
        jLabelTaskHorEnd = new javax.swing.JLabel();
        jLabelTaskHorUnit = new javax.swing.JLabel();
        jLabelTaskHorAcUnit = new javax.swing.JLabel();
        jLabelTaskHorAc = new javax.swing.JLabel();
        jLabelTaskHorStep = new javax.swing.JLabel();
        jLabelTaskVer = new javax.swing.JLabel();
        jLabelTaskVerBegin = new javax.swing.JLabel();
        jLabelTaskVerLine = new javax.swing.JLabel();
        jLabelTaskVerEnd = new javax.swing.JLabel();
        jLabelTaskVerUnit = new javax.swing.JLabel();
        jLabelTaskVerAcUnit = new javax.swing.JLabel();
        jLabelTaskVerAc = new javax.swing.JLabel();
        jLabelTaskVerStep = new javax.swing.JLabel();
        jPanelButton = new javax.swing.JPanel();
        jButtonRound = new javax.swing.JButton();
        jPanelStatus = new javax.swing.JPanel();
        jLabelCondition = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelRepeatition = new javax.swing.JLabel();
        jLabelCurRep = new javax.swing.JLabel();
        jLabelRepOf = new javax.swing.JLabel();
        jLabelTotalRep = new javax.swing.JLabel();
        jLabelMeasure = new javax.swing.JLabel();
        jLabelCurMeas = new javax.swing.JLabel();
        jLabelMeasOf = new javax.swing.JLabel();
        jLabelTotalMeas = new javax.swing.JLabel();
        jProgressBarLittle = new javax.swing.JProgressBar();
        jLabelPercentLittleTitle = new javax.swing.JLabel();
        jLabelPercentLittle = new javax.swing.JLabel();
        jLabelSLittle = new javax.swing.JLabel();
        jLabelSecLittle = new javax.swing.JLabel();
        jProgressBarBig = new javax.swing.JProgressBar();
        jLabelPercentBig = new javax.swing.JLabel();
        jLabelPercentBigTitle = new javax.swing.JLabel();
        jLabelSBig = new javax.swing.JLabel();
        jLabelSecBig = new javax.swing.JLabel();
        jPanelStop = new javax.swing.JPanel();
        jButtonStopScan = new javax.swing.JButton();
        jLabelCurScanLose = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaListener Release");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanelCOM.setBorder(javax.swing.BorderFactory.createTitledBorder("Настройки порта"));

        jLabelCOM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCOM.setText("COM");

        jTextFieldCOM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldCOM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCOM.setText("3");

        jLabelBaudrate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBaudrate.setText(", скорость");

        jTextFieldBaudrate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldBaudrate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBaudrate.setText("250000");

        jLabelBaud.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBaud.setText("бод");

        jButtonApplyCOM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonApplyCOM.setText("Применить настройки порта");
        jButtonApplyCOM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonApplyCOMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCOMLayout = new javax.swing.GroupLayout(jPanelCOM);
        jPanelCOM.setLayout(jPanelCOMLayout);
        jPanelCOMLayout.setHorizontalGroup(
            jPanelCOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCOMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCOM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBaudrate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBaudrate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBaud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonApplyCOM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCOMLayout.setVerticalGroup(
            jPanelCOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCOMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBaudrate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBaudrate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBaud, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonApplyCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelOtherSets.setBorder(javax.swing.BorderFactory.createTitledBorder("Остальные настройки сканирования"));

        jLabelNumOfRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumOfRep.setText("Количество повторов:");

        jTextFieldNumOfRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNumOfRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumOfRep.setText("1");

        jLabelMovingType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMovingType.setText("Преобладание движения:");

        jComboBoxMovingType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxMovingType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "по высоте", "по азимуту", "по высоте, медленно", "по азимуту, медленно" }));

        jLabelDelay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDelay.setText("Задержка перед измерением:");

        jTextFieldDelay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDelay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDelay.setText("80");

        jLabelMs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMs.setText("мс");

        jLabelInterface.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelInterface.setText("Интерфейс подключения датчика:");

        jComboBoxSensorType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxSensorType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "А0,  сред. за 20 мс", "I2C, сред. за 20 мс", "I2C, одно измерение" }));

        jCheckBoxRadarMode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxRadarMode.setText("Режим сравнения");

        jButtonScanningBegin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonScanningBegin.setText("Начать сканирование");
        jButtonScanningBegin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonScanningBeginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelOtherSetsLayout = new javax.swing.GroupLayout(jPanelOtherSets);
        jPanelOtherSets.setLayout(jPanelOtherSetsLayout);
        jPanelOtherSetsLayout.setHorizontalGroup(
            jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOtherSetsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOtherSetsLayout.createSequentialGroup()
                        .addComponent(jLabelDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMs))
                    .addGroup(jPanelOtherSetsLayout.createSequentialGroup()
                        .addComponent(jLabelMovingType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMovingType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOtherSetsLayout.createSequentialGroup()
                        .addComponent(jLabelNumOfRep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumOfRep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOtherSetsLayout.createSequentialGroup()
                            .addComponent(jCheckBoxRadarMode)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonScanningBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOtherSetsLayout.createSequentialGroup()
                            .addComponent(jLabelInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxSensorType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOtherSetsLayout.setVerticalGroup(
            jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOtherSetsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumOfRep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumOfRep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMovingType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMovingType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSensorType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxRadarMode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonScanningBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelLang.setBorder(javax.swing.BorderFactory.createTitledBorder("Язык / Language"));

        jButtonLangRus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLangRus.setText("Русский");
        jButtonLangRus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLangRusMouseClicked(evt);
            }
        });

        jButtonLangEng.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLangEng.setText("English");
        jButtonLangEng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLangEngMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLangLayout = new javax.swing.GroupLayout(jPanelLang);
        jPanelLang.setLayout(jPanelLangLayout);
        jPanelLangLayout.setHorizontalGroup(
            jPanelLangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLangRus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonLangEng)
                .addContainerGap())
        );
        jPanelLangLayout.setVerticalGroup(
            jPanelLangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLangRus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLangEng, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelParking.setBorder(javax.swing.BorderFactory.createTitledBorder("Парковка"));

        jLabelParkAlt.setText("Высота");

        jTextFieldParkAlt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldParkAlt.setText("75");

        jLabelParkDeg.setText("  (градусы)");

        jButtonPark.setText("Запарковать");
        jButtonPark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonParkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelParkingLayout = new javax.swing.GroupLayout(jPanelParking);
        jPanelParking.setLayout(jPanelParkingLayout);
        jPanelParkingLayout.setHorizontalGroup(
            jPanelParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParkingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelParkAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldParkAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelParkDeg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParkingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPark)
                .addContainerGap())
        );
        jPanelParkingLayout.setVerticalGroup(
            jPanelParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParkingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelParkAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldParkAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelParkDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPark, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSets.setBorder(javax.swing.BorderFactory.createTitledBorder("Настройки сектора сканирования"));

        jLabelHor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelHor.setText("Азимут");

        jTextFieldHorBegin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldHorBegin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldHorBegin.setText("0");

        jLabelHorLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelHorLine.setText("-");

        jTextFieldHorEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldHorEnd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldHorEnd.setText("360");

        jComboBoxHorUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxHorUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(градусы)", "(шаги)" }));

        jComboBoxHorAcUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxHorAcUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(градусы)", "(шаги)" }));

        jTextFieldHorAc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldHorAc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldHorAc.setText("10");

        jLabelHorStep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelHorStep.setText("с шагом");

        jLabelVer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVer.setText("Высота");

        jTextFieldVerBegin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldVerBegin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldVerBegin.setText("0");

        jLabelVerLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVerLine.setText("-");

        jTextFieldVerEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldVerEnd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldVerEnd.setText("90");

        jLabelVerUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVerUnit.setText("  (градусы)");

        jLabelVerAcUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVerAcUnit.setText("  (градусы)");

        jTextFieldVerAc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldVerAc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldVerAc.setText("5");

        jLabelVerStep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVerStep.setText("с шагом");

        javax.swing.GroupLayout jPanelSetsLayout = new javax.swing.GroupLayout(jPanelSets);
        jPanelSets.setLayout(jPanelSetsLayout);
        jPanelSetsLayout.setHorizontalGroup(
            jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelSetsLayout.createSequentialGroup()
                            .addComponent(jLabelHorStep)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldHorAc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxHorAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelSetsLayout.createSequentialGroup()
                            .addComponent(jLabelHor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldHorBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelHorLine)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldHorEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxHorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelSetsLayout.createSequentialGroup()
                            .addComponent(jLabelVerStep)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldVerAc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelVerAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelSetsLayout.createSequentialGroup()
                            .addComponent(jLabelVer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldVerBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelVerLine)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelVerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSetsLayout.setVerticalGroup(
            jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHorBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorLine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHorEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHorAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHorAc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorStep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVerBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVerLine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVerAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVerAc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVerStep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRound.setBorder(javax.swing.BorderFactory.createTitledBorder("Округлено до"));

        jLabelTaskHor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHor.setText("Азимут");

        jLabelTaskHorBegin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskHorBegin.setText("?");

        jLabelTaskHorLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorLine.setText("-");

        jLabelTaskHorEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskHorEnd.setText("?");

        jLabelTaskHorUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorUnit.setText("(единицы / units)");

        jLabelTaskHorAcUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorAcUnit.setText("(единицы / units)");

        jLabelTaskHorAc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorAc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskHorAc.setText("?");

        jLabelTaskHorStep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskHorStep.setText("с шагом");

        jLabelTaskVer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVer.setText("Высота");

        jLabelTaskVerBegin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskVerBegin.setText("?");

        jLabelTaskVerLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerLine.setText("-");

        jLabelTaskVerEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskVerEnd.setText("?");

        jLabelTaskVerUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerUnit.setText("(единицы / units)");

        jLabelTaskVerAcUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerAcUnit.setText("(единицы / units)");

        jLabelTaskVerAc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerAc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaskVerAc.setText("?");

        jLabelTaskVerStep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTaskVerStep.setText("с шагом");

        javax.swing.GroupLayout jPanelRoundLayout = new javax.swing.GroupLayout(jPanelRound);
        jPanelRound.setLayout(jPanelRoundLayout);
        jPanelRoundLayout.setHorizontalGroup(
            jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRoundLayout.createSequentialGroup()
                        .addComponent(jLabelTaskHorStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorAc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRoundLayout.createSequentialGroup()
                        .addComponent(jLabelTaskHor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorLine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskHorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRoundLayout.createSequentialGroup()
                        .addComponent(jLabelTaskVer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerLine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRoundLayout.createSequentialGroup()
                        .addComponent(jLabelTaskVerStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerAc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaskVerAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRoundLayout.setVerticalGroup(
            jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaskHor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorLine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaskHorAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorAc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskHorStep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaskVerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVerLine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVerBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaskVerAcUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVerAc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaskVerStep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelButton.setLayout(new java.awt.BorderLayout());

        jButtonRound.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRound.setText("--> Округлить координаты сектора -->");
        jButtonRound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRoundMouseClicked(evt);
            }
        });
        jPanelButton.add(jButtonRound, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelSectorLayout = new javax.swing.GroupLayout(jPanelSector);
        jPanelSector.setLayout(jPanelSectorLayout);
        jPanelSectorLayout.setHorizontalGroup(
            jPanelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSectorLayout.createSequentialGroup()
                .addGroup(jPanelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSectorLayout.createSequentialGroup()
                        .addComponent(jPanelSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelSectorLayout.setVerticalGroup(
            jPanelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSectorLayout.createSequentialGroup()
                .addGroup(jPanelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Статус"));

        jLabelCondition.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCondition.setText("Состояние:");

        jLabelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelStatus.setText("Н/Д / N/A");

        jLabelRepeatition.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRepeatition.setText("Повтор");

        jLabelCurRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCurRep.setText("?");

        jLabelRepOf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRepOf.setText("из");

        jLabelTotalRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTotalRep.setText("?");

        jLabelMeasure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMeasure.setText(", измерение");

        jLabelCurMeas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCurMeas.setText("?");

        jLabelMeasOf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMeasOf.setText("из");

        jLabelTotalMeas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTotalMeas.setText("?");

        jProgressBarLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jProgressBarLittle.setMaximum(10000);

        jLabelPercentLittleTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPercentLittleTitle.setText("текущего повтора, осталось примерно");

        jLabelPercentLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPercentLittle.setText("?");

        jLabelSLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSLittle.setText("?");

        jLabelSecLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSecLittle.setText("с");

        jProgressBarBig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jProgressBarBig.setMaximum(10000);

        jLabelPercentBig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPercentBig.setText("?");

        jLabelPercentBigTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPercentBigTitle.setText("всей задачи, осталось примерно");

        jLabelSBig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSBig.setText("?");

        jLabelSecBig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSecBig.setText("с");

        javax.swing.GroupLayout jPanelStatusLayout = new javax.swing.GroupLayout(jPanelStatus);
        jPanelStatus.setLayout(jPanelStatusLayout);
        jPanelStatusLayout.setHorizontalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStatusLayout.createSequentialGroup()
                        .addComponent(jLabelCondition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatus))
                    .addGroup(jPanelStatusLayout.createSequentialGroup()
                        .addComponent(jLabelRepeatition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCurRep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRepOf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalRep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMeasure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCurMeas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMeasOf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalMeas))
                    .addGroup(jPanelStatusLayout.createSequentialGroup()
                        .addComponent(jProgressBarLittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPercentLittle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPercentLittleTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSLittle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSecLittle))
                    .addGroup(jPanelStatusLayout.createSequentialGroup()
                        .addComponent(jProgressBarBig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPercentBig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPercentBigTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSBig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSecBig)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelStatusLayout.setVerticalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPercentBig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPercentBigTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSBig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSecBig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelStatusLayout.createSequentialGroup()
                        .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelStatusLayout.createSequentialGroup()
                                .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelRepeatition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCurRep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRepOf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTotalRep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCurMeas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMeasOf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTotalMeas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBarLittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelPercentLittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPercentLittleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSLittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSecLittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBarBig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelStop.setBorder(javax.swing.BorderFactory.createTitledBorder("Остановка сканирования"));

        jButtonStopScan.setText("Остановить");
        jButtonStopScan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStopScanMouseClicked(evt);
            }
        });

        jLabelCurScanLose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurScanLose.setText("Текущее измерение будет утеряно");

        javax.swing.GroupLayout jPanelStopLayout = new javax.swing.GroupLayout(jPanelStop);
        jPanelStop.setLayout(jPanelStopLayout);
        jPanelStopLayout.setHorizontalGroup(
            jPanelStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonStopScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCurScanLose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelStopLayout.setVerticalGroup(
            jPanelStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCurScanLose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonStopScan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelOtherSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanelParking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanelStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelParking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanelOtherSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonScanningBeginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonScanningBeginMouseClicked
        try {
            jlc.goScan();
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonScanningBeginMouseClicked

    private void jButtonRoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRoundMouseClicked
        jlc.roundTask();
    }//GEN-LAST:event_jButtonRoundMouseClicked

    private void jButtonApplyCOMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonApplyCOMMouseClicked
        try {
            jlc.newSerial();
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonApplyCOMMouseClicked

    private void jButtonStopScanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStopScanMouseClicked
        try {
            jlc.newSerial();
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonStopScanMouseClicked

    private void jButtonLangRusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLangRusMouseClicked
        try {
            jlc.changeLang(0);
        } catch (IOException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLangRusMouseClicked

    private void jButtonLangEngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLangEngMouseClicked
        try {
            jlc.changeLang(1);
        } catch (IOException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLangEngMouseClicked

    private void jButtonParkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonParkMouseClicked
        try {
            jlc.goPark();
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonParkMouseClicked

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JavaListenerUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JavaListenerUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void setStatus(String s) {
        jLabelStatus.setText(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JButton jButtonApplyCOM;
    private javax.swing.JButton jButtonLangEng;
    private javax.swing.JButton jButtonLangRus;
    private javax.swing.JButton jButtonPark;
    private javax.swing.JButton jButtonRound;
    private javax.swing.JButton jButtonScanningBegin;
    private javax.swing.JButton jButtonStopScan;
    private javax.swing.JCheckBox jCheckBoxRadarMode;
    private javax.swing.JComboBox jComboBoxHorAcUnit;
    private javax.swing.JComboBox jComboBoxHorUnit;
    private javax.swing.JComboBox jComboBoxMovingType;
    private javax.swing.JComboBox jComboBoxSensorType;
    private javax.swing.JLabel jLabelBaud;
    private javax.swing.JLabel jLabelBaudrate;
    private javax.swing.JLabel jLabelCOM;
    private javax.swing.JLabel jLabelCondition;
    private javax.swing.JLabel jLabelCurMeas;
    private javax.swing.JLabel jLabelCurRep;
    private javax.swing.JLabel jLabelCurScanLose;
    private javax.swing.JLabel jLabelDelay;
    private javax.swing.JLabel jLabelHor;
    private javax.swing.JLabel jLabelHorLine;
    private javax.swing.JLabel jLabelHorStep;
    private javax.swing.JLabel jLabelInterface;
    private javax.swing.JLabel jLabelMeasOf;
    private javax.swing.JLabel jLabelMeasure;
    private javax.swing.JLabel jLabelMovingType;
    private javax.swing.JLabel jLabelMs;
    private javax.swing.JLabel jLabelNumOfRep;
    private javax.swing.JLabel jLabelParkAlt;
    private javax.swing.JLabel jLabelParkDeg;
    private javax.swing.JLabel jLabelPercentBig;
    private javax.swing.JLabel jLabelPercentBigTitle;
    private javax.swing.JLabel jLabelPercentLittle;
    private javax.swing.JLabel jLabelPercentLittleTitle;
    private javax.swing.JLabel jLabelRepOf;
    private javax.swing.JLabel jLabelRepeatition;
    private javax.swing.JLabel jLabelSBig;
    private javax.swing.JLabel jLabelSLittle;
    private javax.swing.JLabel jLabelSecBig;
    private javax.swing.JLabel jLabelSecLittle;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTaskHor;
    private javax.swing.JLabel jLabelTaskHorAc;
    private javax.swing.JLabel jLabelTaskHorAcUnit;
    private javax.swing.JLabel jLabelTaskHorBegin;
    private javax.swing.JLabel jLabelTaskHorEnd;
    private javax.swing.JLabel jLabelTaskHorLine;
    private javax.swing.JLabel jLabelTaskHorStep;
    private javax.swing.JLabel jLabelTaskHorUnit;
    private javax.swing.JLabel jLabelTaskVer;
    private javax.swing.JLabel jLabelTaskVerAc;
    private javax.swing.JLabel jLabelTaskVerAcUnit;
    private javax.swing.JLabel jLabelTaskVerBegin;
    private javax.swing.JLabel jLabelTaskVerEnd;
    private javax.swing.JLabel jLabelTaskVerLine;
    private javax.swing.JLabel jLabelTaskVerStep;
    private javax.swing.JLabel jLabelTaskVerUnit;
    private javax.swing.JLabel jLabelTotalMeas;
    private javax.swing.JLabel jLabelTotalRep;
    private javax.swing.JLabel jLabelVer;
    private javax.swing.JLabel jLabelVerAcUnit;
    private javax.swing.JLabel jLabelVerLine;
    private javax.swing.JLabel jLabelVerStep;
    private javax.swing.JLabel jLabelVerUnit;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelCOM;
    private javax.swing.JPanel jPanelLang;
    private javax.swing.JPanel jPanelOtherSets;
    private javax.swing.JPanel jPanelParking;
    private javax.swing.JPanel jPanelRound;
    private javax.swing.JPanel jPanelSector;
    private javax.swing.JPanel jPanelSets;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JPanel jPanelStop;
    private javax.swing.JProgressBar jProgressBarBig;
    private javax.swing.JProgressBar jProgressBarLittle;
    private javax.swing.JTextField jTextFieldBaudrate;
    private javax.swing.JTextField jTextFieldCOM;
    private javax.swing.JTextField jTextFieldDelay;
    private javax.swing.JTextField jTextFieldHorAc;
    private javax.swing.JTextField jTextFieldHorBegin;
    private javax.swing.JTextField jTextFieldHorEnd;
    private javax.swing.JTextField jTextFieldNumOfRep;
    private javax.swing.JTextField jTextFieldParkAlt;
    private javax.swing.JTextField jTextFieldVerAc;
    private javax.swing.JTextField jTextFieldVerBegin;
    private javax.swing.JTextField jTextFieldVerEnd;
    // End of variables declaration//GEN-END:variables
}
