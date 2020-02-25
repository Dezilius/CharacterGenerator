/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

//import java.awt.List;
import java.util.List;
import java.util.ArrayList;
import util.Tools;
import util.AttrChar;
import util.QuerryUtil;

/**
 *
 * @author dezilius
 */
public class GeneratorUI extends javax.swing.JFrame {

    /**
     * Creates new form GeneratorUI
     */
    public GeneratorUI() {
        initComponents();
    }
        
private static final String QUERY_NUMBER_OF_ROWS_FIRST_NAME="from FirstName where id = (select count(*) from FirstName)";
private static final String QUERY_NUMBER_OF_ROWS_LAST_NAME="from LastName where id = (select count(*) from LastName)";
private static final String QUERY_NUMBER_OF_ROWS_PROFESSION="from Profession where id = (select count(*) from Profession)";
    
private void runAllQueries() {
    List result = QuerryUtil.executeHQLQueryNumberOfFirstName(QUERY_NUMBER_OF_ROWS_FIRST_NAME);
    displayResultFirstName(result);
    
    result = QuerryUtil.executeHQLQueryNumberOfLastName(QUERY_NUMBER_OF_ROWS_LAST_NAME);
    displayResultLastName(result);
    
    result = QuerryUtil.executeHQLQueryNumberOfProfession(QUERY_NUMBER_OF_ROWS_PROFESSION);
    displayResultProfession(result);
}

private void displayResultFirstName(List result) {
       
    for (Object o : result) {
        callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName)o;
        firstNameField.setText(name.getFirstName());
        sexField.setText(name.getSex());
    }
}
private void displayResultLastName(List result) {
       
    for (Object o : result) {
        callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName)o;
        lastNameField.setText(name.getLastName());
    }
}
private void displayResultProfession(List result) {
    aggregateSkillFields();
            
    for (Object o : result) {
        callofcthulhuDB.entity.Profession profession = (callofcthulhuDB.entity.Profession)o;
        util.SkillChar.mapSkillFields(profession, skillFields);
        int age = util.InfoChar.randomAge(profession);
        ageField.setText(Integer.toString(age));
    }
}

private void randomAttributes() {
    aggregateAttributesFields();
    for (javax.swing.JTextField iter : attributesFields) {
        int value = 0;
        
        if (iter.equals(sizeField) || 
            iter.equals(intelligenceField) ||
            iter.equals(educationField)) {
            for (int i = 0; i < 2; i++) {
                value += util.Tools.roll(1,6);
            }
            value += util.Tools.roll(6,6);
        }
        else {
            for (int i = 0; i < 3; i++) {
                value += util.Tools.roll(1,6);
            }
        }
        value *= 5;
        iter.setText(Integer.toString(value));
    }
} 
private void setMoveRate() {
    short moveRate = 0;
    short dex = (short) Integer.parseInt(dexterityField.getText());
    short str = (short) Integer.parseInt(strengthField.getText());
    short siz = (short) Integer.parseInt(sizeField.getText());
    
    if ((dex < siz) && (str < siz)) {
        moveRate = 7;
    }
    else if ((dex > siz) && (str > siz)) {
        moveRate = 9;
    }
    else if ((dex >= siz) || (str >= siz)) {
        moveRate = 8;
    }
    moveRateField.setText(Short.toString(moveRate));
}
private void adjustAttributesByCharacterAge() {
    short age = Short.parseShort(ageField.getText());
    
    if (age >= 15 && age < 20) {
        AttrChar.remove2Args(strengthField, sizeField, 5);
        Tools.removePoint(educationField, 5);
    }
    
    else if (age >= 20 && age < 40) {
        Tools.improvementValue(educationField, 1);
    }
    
    else if (age >= 40 && age < 50) {
        Tools.improvementValue(educationField, 2);
        AttrChar.remove3Args(logArea, strengthField, conditionField, dexterityField, 5);
        Tools.removePoint(appearanceField, 5);
    }
    
    else if (age >= 50 && age < 60) {
        Tools.improvementValue(educationField, 3);
        AttrChar.remove3Args(logArea,strengthField, conditionField, dexterityField, 10);
        Tools.removePoint(appearanceField, 10);
    }
    
    else if (age >= 60 && age < 70) {
        Tools.improvementValue(educationField, 4);
        AttrChar.remove3Args(logArea, strengthField, conditionField, dexterityField, 20);
        Tools.removePoint(appearanceField, 15);
    }
    
    else if (age >= 70 && age < 80) {
        Tools.improvementValue(educationField, 4);
        AttrChar.remove3Args(logArea, strengthField, conditionField, dexterityField, 40);
        Tools.removePoint(appearanceField, 20);
    }
    
    else if (age >= 80 && age < 90) {
        Tools.improvementValue(educationField, 4);
        AttrChar.remove3Args(logArea, strengthField, conditionField, dexterityField, 80);
        Tools.removePoint(appearanceField, 25);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        anthropologyField = new javax.swing.JTextField();
        anthropologyLabel = new javax.swing.JLabel();
        appraiseLabel = new javax.swing.JLabel();
        appraiseField = new javax.swing.JTextField();
        archeologyLabel = new javax.swing.JLabel();
        archeologyField = new javax.swing.JTextField();
        craftLabel = new javax.swing.JLabel();
        craftField = new javax.swing.JTextField();
        charmLabel = new javax.swing.JLabel();
        charmField = new javax.swing.JTextField();
        climbLabel = new javax.swing.JLabel();
        climbField = new javax.swing.JTextField();
        disguiseLabel = new javax.swing.JLabel();
        disguiseField = new javax.swing.JTextField();
        electricalRepairLabel = new javax.swing.JLabel();
        electricalRepairField = new javax.swing.JTextField();
        accountingField = new javax.swing.JTextField();
        accountingLabel = new javax.swing.JLabel();
        dodgeLabel = new javax.swing.JLabel();
        dodgeField = new javax.swing.JTextField();
        craft2ndLabel = new javax.swing.JLabel();
        craft2ndField = new javax.swing.JTextField();
        craft3rdLabel = new javax.swing.JLabel();
        craft3rdField = new javax.swing.JTextField();
        creditRatingLabel = new javax.swing.JLabel();
        creditRatingField = new javax.swing.JTextField();
        cthulhuMythosLabel = new javax.swing.JLabel();
        cthulhuMythosField = new javax.swing.JTextField();
        driveLabel = new javax.swing.JLabel();
        driveField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        handgunLabel = new javax.swing.JLabel();
        rifleField = new javax.swing.JTextField();
        rifleLabel = new javax.swing.JLabel();
        historyField = new javax.swing.JTextField();
        historyLabel = new javax.swing.JLabel();
        intimidateField = new javax.swing.JTextField();
        intimidateLabel = new javax.swing.JLabel();
        jumpLabel = new javax.swing.JLabel();
        jumpField = new javax.swing.JTextField();
        languageOtherField = new javax.swing.JTextField();
        languageOtherLabel = new javax.swing.JLabel();
        languageOwnField = new javax.swing.JTextField();
        languageOwn = new javax.swing.JLabel();
        firstAidField = new javax.swing.JTextField();
        firstAidLabel = new javax.swing.JLabel();
        fastTalkLabel = new javax.swing.JLabel();
        fastTalkField = new javax.swing.JTextField();
        fightingLabel = new javax.swing.JLabel();
        fightingField = new javax.swing.JTextField();
        handgunField = new javax.swing.JTextField();
        fightinh2ndLabel = new javax.swing.JLabel();
        fighting2ndField = new javax.swing.JTextField();
        fighting3rdField = new javax.swing.JTextField();
        fighting3rdLabel = new javax.swing.JLabel();
        rifle2ndField = new javax.swing.JTextField();
        rifle2ndLabel = new javax.swing.JLabel();
        languageOther2ndField = new javax.swing.JTextField();
        languageOther2ndLabel = new javax.swing.JLabel();
        languageOther3rdLabel = new javax.swing.JLabel();
        languageOther3rdField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lawField = new javax.swing.JTextField();
        lawLabel = new javax.swing.JLabel();
        libraryUseField = new javax.swing.JTextField();
        libraryUseLabel = new javax.swing.JLabel();
        listenField = new javax.swing.JTextField();
        listenLabel = new javax.swing.JLabel();
        locksmithingLabel = new javax.swing.JLabel();
        locksmithingField = new javax.swing.JTextField();
        mechanicalRepairLabel = new javax.swing.JLabel();
        mechanicalRepairField = new javax.swing.JTextField();
        medicineLabel = new javax.swing.JLabel();
        medicineField = new javax.swing.JTextField();
        persuadeLabel = new javax.swing.JLabel();
        persuadeField = new javax.swing.JTextField();
        pilotLabel = new javax.swing.JLabel();
        pilotField = new javax.swing.JTextField();
        opHvMachineLabel = new javax.swing.JLabel();
        opHvMachineField = new javax.swing.JTextField();
        psychoanalysisField = new javax.swing.JTextField();
        psychoanalysisLabel = new javax.swing.JLabel();
        ridingField = new javax.swing.JTextField();
        ridingLabel = new javax.swing.JLabel();
        occultField = new javax.swing.JTextField();
        occultLabel = new javax.swing.JLabel();
        naturalWorldLabel = new javax.swing.JLabel();
        naturalWorldField = new javax.swing.JTextField();
        navigateField = new javax.swing.JTextField();
        navigateLabel = new javax.swing.JLabel();
        psychologyLabel = new javax.swing.JLabel();
        psychologyField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        scienceField = new javax.swing.JTextField();
        scienceLabel = new javax.swing.JLabel();
        science2ndField = new javax.swing.JTextField();
        science2ndLabel = new javax.swing.JLabel();
        science3rdField = new javax.swing.JTextField();
        science3rdLabel = new javax.swing.JLabel();
        sleightOfHandLabel = new javax.swing.JLabel();
        sleightOfHandField = new javax.swing.JTextField();
        spotHiddenLabel = new javax.swing.JLabel();
        spotHiddenField = new javax.swing.JTextField();
        stealthField = new javax.swing.JTextField();
        stealthLabel = new javax.swing.JLabel();
        survivalLabel = new javax.swing.JLabel();
        survivalField = new javax.swing.JTextField();
        swimLabel = new javax.swing.JLabel();
        swimField = new javax.swing.JTextField();
        throwLabel = new javax.swing.JLabel();
        throwField = new javax.swing.JTextField();
        trackLabel = new javax.swing.JLabel();
        trackField = new javax.swing.JTextField();
        other1stLabel = new javax.swing.JLabel();
        other1stField = new javax.swing.JTextField();
        other2ndLabel = new javax.swing.JLabel();
        other2ndField = new javax.swing.JTextField();
        other3rdLabel = new javax.swing.JLabel();
        other3rdField = new javax.swing.JTextField();
        other4thLabel = new javax.swing.JLabel();
        other4thField = new javax.swing.JTextField();
        other5thField = new javax.swing.JTextField();
        other5thLabel = new javax.swing.JLabel();
        generateNewButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        appearanceLabel = new javax.swing.JLabel();
        powerLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        educationLabel = new javax.swing.JLabel();
        moveRateLabel = new javax.swing.JLabel();
        strengthField = new javax.swing.JTextField();
        dexterityField = new javax.swing.JTextField();
        intelligenceField = new javax.swing.JTextField();
        conditionField = new javax.swing.JTextField();
        appearanceField = new javax.swing.JTextField();
        powerField = new javax.swing.JTextField();
        sizeField = new javax.swing.JTextField();
        educationField = new javax.swing.JTextField();
        moveRateField = new javax.swing.JTextField();
        dexterityLabel = new javax.swing.JLabel();
        strengthLabel = new javax.swing.JLabel();
        intelligenceLabel = new javax.swing.JLabel();
        conditionLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        professionField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        sexField = new javax.swing.JTextField();
        sexLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        professionLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Generator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1350, 785));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        anthropologyField.setEditable(false);
        anthropologyField.setColumns(2);
        anthropologyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anthropologyFieldActionPerformed(evt);
            }
        });

        anthropologyLabel.setText("Anthropology");

        appraiseLabel.setText("Appraise");

        appraiseField.setEditable(false);
        appraiseField.setColumns(2);
        appraiseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appraiseFieldActionPerformed(evt);
            }
        });

        archeologyLabel.setText("Archeology");

        archeologyField.setEditable(false);
        archeologyField.setColumns(2);
        archeologyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archeologyFieldActionPerformed(evt);
            }
        });

        craftLabel.setText("Craft");

        craftField.setEditable(false);
        craftField.setColumns(2);
        craftField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                craftFieldActionPerformed(evt);
            }
        });

        charmLabel.setText("Charm");

        charmField.setEditable(false);
        charmField.setColumns(2);
        charmField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charmFieldActionPerformed(evt);
            }
        });

        climbLabel.setText("Climb");

        climbField.setEditable(false);
        climbField.setColumns(2);
        climbField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                climbFieldActionPerformed(evt);
            }
        });

        disguiseLabel.setText("Disguise");

        disguiseField.setEditable(false);
        disguiseField.setColumns(2);
        disguiseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disguiseFieldActionPerformed(evt);
            }
        });

        electricalRepairLabel.setText("Electrical Repair");

        electricalRepairField.setEditable(false);
        electricalRepairField.setColumns(2);
        electricalRepairField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electricalRepairFieldActionPerformed(evt);
            }
        });

        accountingField.setEditable(false);
        accountingField.setColumns(2);
        accountingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountingFieldActionPerformed(evt);
            }
        });

        accountingLabel.setText("Accounting");

        dodgeLabel.setText("Dodge (half DEX)");

        dodgeField.setEditable(false);
        dodgeField.setColumns(2);
        dodgeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodgeFieldActionPerformed(evt);
            }
        });

        craft2ndField.setEditable(false);
        craft2ndField.setColumns(2);
        craft2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                craft2ndFieldActionPerformed(evt);
            }
        });

        craft3rdField.setEditable(false);
        craft3rdField.setColumns(2);
        craft3rdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                craft3rdFieldActionPerformed(evt);
            }
        });

        creditRatingLabel.setText("Credit Rating");

        creditRatingField.setEditable(false);
        creditRatingField.setColumns(2);
        creditRatingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditRatingFieldActionPerformed(evt);
            }
        });

        cthulhuMythosLabel.setText("Cthulhu Mythos");

        cthulhuMythosField.setEditable(false);
        cthulhuMythosField.setColumns(2);
        cthulhuMythosField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cthulhuMythosFieldActionPerformed(evt);
            }
        });

        driveLabel.setText("Drive");

        driveField.setEditable(false);
        driveField.setColumns(2);
        driveField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driveFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(cthulhuMythosLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cthulhuMythosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(creditRatingLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(creditRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(craft3rdLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(craft3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(craft2ndLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(craft2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(accountingLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(accountingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(anthropologyLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(anthropologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(appraiseLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(appraiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(archeologyLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(archeologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(craftLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(craftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(charmLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(charmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(climbLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(climbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(electricalRepairLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(electricalRepairField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(disguiseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(disguiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dodgeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dodgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(driveLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(driveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accountingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountingLabel))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anthropologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(anthropologyLabel)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appraiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appraiseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(archeologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archeologyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(craftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(craftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(craft2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(craft2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(craft3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(craft3rdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(charmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(charmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(climbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(climbLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditRatingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cthulhuMythosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cthulhuMythosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disguiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disguiseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driveLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(electricalRepairField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(electricalRepairLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        handgunLabel.setText("Handgun");

        rifleField.setEditable(false);
        rifleField.setColumns(2);
        rifleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rifleFieldActionPerformed(evt);
            }
        });

        rifleLabel.setText("Rifle");

        historyField.setEditable(false);
        historyField.setColumns(2);
        historyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyFieldActionPerformed(evt);
            }
        });

        historyLabel.setText("History");

        intimidateField.setEditable(false);
        intimidateField.setColumns(2);
        intimidateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intimidateFieldActionPerformed(evt);
            }
        });

        intimidateLabel.setText("Intimidate");

        jumpLabel.setText("Jump");

        jumpField.setEditable(false);
        jumpField.setColumns(2);
        jumpField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpFieldActionPerformed(evt);
            }
        });

        languageOtherField.setEditable(false);
        languageOtherField.setColumns(2);
        languageOtherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageOtherFieldActionPerformed(evt);
            }
        });

        languageOtherLabel.setText("Language (Other)");

        languageOwnField.setEditable(false);
        languageOwnField.setColumns(2);
        languageOwnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageOwnFieldActionPerformed(evt);
            }
        });

        languageOwn.setText("Language (Own)(EDU)");

        firstAidField.setEditable(false);
        firstAidField.setColumns(2);
        firstAidField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstAidFieldActionPerformed(evt);
            }
        });

        firstAidLabel.setText("First Aid");

        fastTalkLabel.setText("Fast Talk");

        fastTalkField.setEditable(false);
        fastTalkField.setColumns(2);
        fastTalkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastTalkFieldActionPerformed(evt);
            }
        });

        fightingLabel.setText("Fighting (Brawl)");

        fightingField.setEditable(false);
        fightingField.setColumns(2);
        fightingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fightingFieldActionPerformed(evt);
            }
        });

        handgunField.setEditable(false);
        handgunField.setColumns(2);
        handgunField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handgunFieldActionPerformed(evt);
            }
        });

        fighting2ndField.setEditable(false);
        fighting2ndField.setColumns(2);
        fighting2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fighting2ndFieldActionPerformed(evt);
            }
        });

        fighting3rdField.setEditable(false);
        fighting3rdField.setColumns(2);
        fighting3rdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fighting3rdFieldActionPerformed(evt);
            }
        });

        rifle2ndField.setEditable(false);
        rifle2ndField.setColumns(2);
        rifle2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rifle2ndFieldActionPerformed(evt);
            }
        });

        languageOther2ndField.setEditable(false);
        languageOther2ndField.setColumns(2);
        languageOther2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageOther2ndFieldActionPerformed(evt);
            }
        });

        languageOther3rdField.setEditable(false);
        languageOther3rdField.setColumns(2);
        languageOther3rdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageOther3rdFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(fastTalkLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fastTalkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(fightingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fightingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(handgunLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(handgunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(rifleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rifleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(firstAidLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstAidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(historyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(historyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(intimidateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(intimidateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jumpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jumpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(languageOtherLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageOtherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(languageOwn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageOwnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(fightinh2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fighting2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(fighting3rdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fighting3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(rifle2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rifle2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(languageOther2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageOther2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(languageOther3rdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageOther3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fastTalkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fastTalkLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fightingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fightingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fighting2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fightinh2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fighting3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fighting3rdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handgunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(handgunLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rifleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rifleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rifle2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rifle2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstAidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstAidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intimidateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intimidateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumpLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageOtherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageOtherLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageOther2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageOther2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageOther3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageOther3rdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageOwnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageOwn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lawField.setEditable(false);
        lawField.setColumns(2);
        lawField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lawFieldActionPerformed(evt);
            }
        });

        lawLabel.setText("Law");

        libraryUseField.setEditable(false);
        libraryUseField.setColumns(2);
        libraryUseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryUseFieldActionPerformed(evt);
            }
        });

        libraryUseLabel.setText("Library use");

        listenField.setEditable(false);
        listenField.setColumns(2);
        listenField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenFieldActionPerformed(evt);
            }
        });

        listenLabel.setText("Listen");

        locksmithingLabel.setText("Locksmithing");

        locksmithingField.setEditable(false);
        locksmithingField.setColumns(2);
        locksmithingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locksmithingFieldActionPerformed(evt);
            }
        });

        mechanicalRepairLabel.setText("Mechanical Repair");

        mechanicalRepairField.setEditable(false);
        mechanicalRepairField.setColumns(2);
        mechanicalRepairField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mechanicalRepairFieldActionPerformed(evt);
            }
        });

        medicineLabel.setText("Medicine");

        medicineField.setEditable(false);
        medicineField.setColumns(2);
        medicineField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineFieldActionPerformed(evt);
            }
        });

        persuadeLabel.setText("Persuade");

        persuadeField.setEditable(false);
        persuadeField.setColumns(2);
        persuadeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persuadeFieldActionPerformed(evt);
            }
        });

        pilotLabel.setText("Pilot");

        pilotField.setEditable(false);
        pilotField.setColumns(2);
        pilotField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilotFieldActionPerformed(evt);
            }
        });

        opHvMachineLabel.setText("Op.Hv.Machine");

        opHvMachineField.setEditable(false);
        opHvMachineField.setColumns(2);
        opHvMachineField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opHvMachineFieldActionPerformed(evt);
            }
        });

        psychoanalysisField.setEditable(false);
        psychoanalysisField.setColumns(2);
        psychoanalysisField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psychoanalysisFieldActionPerformed(evt);
            }
        });

        psychoanalysisLabel.setText("Psychoanalysis");

        ridingField.setEditable(false);
        ridingField.setColumns(2);
        ridingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ridingFieldActionPerformed(evt);
            }
        });

        ridingLabel.setText("Riding");

        occultField.setEditable(false);
        occultField.setColumns(2);
        occultField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occultFieldActionPerformed(evt);
            }
        });

        occultLabel.setText("Occult");

        naturalWorldLabel.setText("Natural World");

        naturalWorldField.setEditable(false);
        naturalWorldField.setColumns(2);
        naturalWorldField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naturalWorldFieldActionPerformed(evt);
            }
        });

        navigateField.setEditable(false);
        navigateField.setColumns(2);
        navigateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateFieldActionPerformed(evt);
            }
        });

        navigateLabel.setText("Navigate");

        psychologyLabel.setText("Psychology");

        psychologyField.setEditable(false);
        psychologyField.setColumns(2);
        psychologyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psychologyFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ridingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ridingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(psychologyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(psychologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pilotLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pilotField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(naturalWorldLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(naturalWorldField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(navigateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(navigateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(occultLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(occultField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(opHvMachineLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opHvMachineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(persuadeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(persuadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(psychoanalysisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(psychoanalysisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(medicineLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(medicineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lawLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lawField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(libraryUseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(libraryUseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(listenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(locksmithingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locksmithingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(mechanicalRepairLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mechanicalRepairField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lawField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lawLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libraryUseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libraryUseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locksmithingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locksmithingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mechanicalRepairField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mechanicalRepairLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicineLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(naturalWorldField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(naturalWorldLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(navigateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navigateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occultField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(occultLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opHvMachineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opHvMachineLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(persuadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(persuadeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilotField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilotLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psychologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psychologyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psychoanalysisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psychoanalysisLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ridingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ridingLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        scienceField.setEditable(false);
        scienceField.setColumns(2);
        scienceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scienceFieldActionPerformed(evt);
            }
        });

        scienceLabel.setText("Science");

        science2ndField.setEditable(false);
        science2ndField.setColumns(2);
        science2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                science2ndFieldActionPerformed(evt);
            }
        });

        science3rdField.setEditable(false);
        science3rdField.setColumns(2);
        science3rdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                science3rdFieldActionPerformed(evt);
            }
        });

        sleightOfHandLabel.setText("Sleight of Hand");

        sleightOfHandField.setEditable(false);
        sleightOfHandField.setColumns(2);
        sleightOfHandField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleightOfHandFieldActionPerformed(evt);
            }
        });

        spotHiddenLabel.setText("Spot Hidden");

        spotHiddenField.setEditable(false);
        spotHiddenField.setColumns(2);
        spotHiddenField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spotHiddenFieldActionPerformed(evt);
            }
        });

        stealthField.setEditable(false);
        stealthField.setColumns(2);
        stealthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealthFieldActionPerformed(evt);
            }
        });

        stealthLabel.setText("Stealth");

        survivalLabel.setText("Survival");

        survivalField.setEditable(false);
        survivalField.setColumns(2);
        survivalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                survivalFieldActionPerformed(evt);
            }
        });

        swimLabel.setText("Swim");

        swimField.setEditable(false);
        swimField.setColumns(2);
        swimField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swimFieldActionPerformed(evt);
            }
        });

        throwLabel.setText("Throw");

        throwField.setEditable(false);
        throwField.setColumns(2);
        throwField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                throwFieldActionPerformed(evt);
            }
        });

        trackLabel.setText("Track");

        trackField.setEditable(false);
        trackField.setColumns(2);
        trackField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackFieldActionPerformed(evt);
            }
        });

        other1stField.setEditable(false);
        other1stField.setColumns(2);
        other1stField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other1stFieldActionPerformed(evt);
            }
        });

        other2ndField.setEditable(false);
        other2ndField.setColumns(2);
        other2ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other2ndFieldActionPerformed(evt);
            }
        });

        other3rdField.setEditable(false);
        other3rdField.setColumns(2);
        other3rdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other3rdFieldActionPerformed(evt);
            }
        });

        other4thField.setEditable(false);
        other4thField.setColumns(2);
        other4thField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other4thFieldActionPerformed(evt);
            }
        });

        other5thField.setEditable(false);
        other5thField.setColumns(2);
        other5thField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other5thFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(science3rdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(science3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(science2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(science2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(scienceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scienceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other5thLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(other5thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other3rdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(other3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(other2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other1stLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(other1stField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(swimLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(swimField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(trackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(survivalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(survivalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(stealthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stealthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(sleightOfHandLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sleightOfHandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(spotHiddenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spotHiddenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(throwLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(throwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other4thLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(other4thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scienceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scienceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(science2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(science2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(science3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(science3rdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sleightOfHandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sleightOfHandLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spotHiddenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spotHiddenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stealthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stealthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(survivalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(survivalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(swimField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swimLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(throwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(throwLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trackLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other1stField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other1stLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other2ndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other3rdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other4thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other4thLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other5thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(other5thLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        generateNewButton.setText("Generate NEW!");
        generateNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateNewButtonMouseClicked(evt);
            }
        });
        generateNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateNewButtonActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        appearanceLabel.setText("APP");

        powerLabel.setText("POW");

        sizeLabel.setText("SIZ");

        educationLabel.setText("EDU");

        moveRateLabel.setText("Move Rate");
        moveRateLabel.setToolTipText("");

        strengthField.setEditable(false);
        strengthField.setColumns(5);

        dexterityField.setEditable(false);
        dexterityField.setColumns(5);

        intelligenceField.setEditable(false);
        intelligenceField.setColumns(5);

        conditionField.setEditable(false);
        conditionField.setColumns(5);

        appearanceField.setEditable(false);
        appearanceField.setColumns(5);

        powerField.setEditable(false);
        powerField.setColumns(5);
        powerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerFieldActionPerformed(evt);
            }
        });

        sizeField.setEditable(false);
        sizeField.setColumns(5);

        educationField.setEditable(false);
        educationField.setColumns(5);

        moveRateField.setEditable(false);
        moveRateField.setColumns(5);
        moveRateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveRateFieldActionPerformed(evt);
            }
        });

        dexterityLabel.setText("DEX");

        strengthLabel.setText("STR");

        intelligenceLabel.setText("INT");

        conditionLabel.setText("CON");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strengthLabel)
                    .addComponent(conditionLabel)
                    .addComponent(sizeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conditionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dexterityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dexterityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(intelligenceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intelligenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(appearanceLabel)
                            .addComponent(educationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(appearanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(powerLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(moveRateLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moveRateField)
                            .addComponent(powerField))))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dexterityLabel)
                    .addComponent(strengthLabel)
                    .addComponent(intelligenceLabel)
                    .addComponent(intelligenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dexterityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(powerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(powerLabel)
                    .addComponent(appearanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appearanceLabel)
                    .addComponent(conditionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conditionLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moveRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(educationLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        firstNameField.setEditable(false);
        firstNameField.setColumns(8);
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        lastNameField.setEditable(false);
        lastNameField.setColumns(8);

        professionField.setEditable(false);
        professionField.setColumns(10);

        ageField.setEditable(false);
        ageField.setColumns(3);

        sexField.setEditable(false);
        sexField.setColumns(5);
        sexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexFieldActionPerformed(evt);
            }
        });

        sexLabel.setText("Sex");

        nameLabel.setText("Name");

        professionLabel.setText("Profession");

        ageLabel.setText("Age");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(professionLabel)
                    .addComponent(nameLabel)
                    .addComponent(ageLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(professionField))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexLabel)
                    .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        firstNameField.getAccessibleContext().setAccessibleName("firstNameField");
        lastNameField.getAccessibleContext().setAccessibleName("LastNameField");
        professionField.getAccessibleContext().setAccessibleName("professionField");
        professionField.getAccessibleContext().setAccessibleDescription("");
        ageField.getAccessibleContext().setAccessibleName("ageField");
        sexField.getAccessibleContext().setAccessibleName("mfField");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        jButton1.setText("Open DB Management");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generateNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(378, 378, 378))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void handgunFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handgunFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_handgunFieldActionPerformed

    private void rifleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rifleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rifleFieldActionPerformed

    private void electricalRepairFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_electricalRepairFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_electricalRepairFieldActionPerformed

    private void historyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historyFieldActionPerformed

    private void ridingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ridingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ridingFieldActionPerformed

    private void languageOtherFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageOtherFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageOtherFieldActionPerformed

    private void libraryUseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryUseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libraryUseFieldActionPerformed

    private void languageOwnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageOwnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageOwnFieldActionPerformed

    private void medicineFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicineFieldActionPerformed

    private void listenFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listenFieldActionPerformed

    private void scienceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scienceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scienceFieldActionPerformed

    private void navigateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navigateFieldActionPerformed

    private void accountingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountingFieldActionPerformed

    private void occultFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occultFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occultFieldActionPerformed

    private void mechanicalRepairFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mechanicalRepairFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mechanicalRepairFieldActionPerformed

    private void naturalWorldFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naturalWorldFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_naturalWorldFieldActionPerformed

    private void firstAidFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstAidFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstAidFieldActionPerformed

    private void pilotFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilotFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilotFieldActionPerformed

    private void swimFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swimFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_swimFieldActionPerformed

    private void stealthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stealthFieldActionPerformed

    private void lawFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lawFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lawFieldActionPerformed

    private void psychologyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psychologyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psychologyFieldActionPerformed

    private void driveFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driveFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driveFieldActionPerformed

    private void survivalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_survivalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_survivalFieldActionPerformed

    private void throwFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_throwFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_throwFieldActionPerformed

    private void locksmithingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locksmithingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locksmithingFieldActionPerformed

    private void persuadeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persuadeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_persuadeFieldActionPerformed

    private void dodgeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodgeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dodgeFieldActionPerformed

    private void generateNewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateNewButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_generateNewButtonMouseClicked

    private void anthropologyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anthropologyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anthropologyFieldActionPerformed

    private void appraiseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appraiseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appraiseFieldActionPerformed

    private void archeologyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archeologyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_archeologyFieldActionPerformed

    private void craftFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_craftFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_craftFieldActionPerformed

    private void charmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_charmFieldActionPerformed

    private void climbFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_climbFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_climbFieldActionPerformed

    private void disguiseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disguiseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disguiseFieldActionPerformed

    private void fastTalkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastTalkFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fastTalkFieldActionPerformed

    private void fightingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fightingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fightingFieldActionPerformed

    private void intimidateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intimidateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intimidateFieldActionPerformed

    private void jumpFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumpFieldActionPerformed

    private void opHvMachineFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opHvMachineFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opHvMachineFieldActionPerformed

    private void psychoanalysisFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psychoanalysisFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psychoanalysisFieldActionPerformed

    private void sleightOfHandFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sleightOfHandFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sleightOfHandFieldActionPerformed

    private void spotHiddenFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spotHiddenFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spotHiddenFieldActionPerformed

    private void trackFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trackFieldActionPerformed

    private void craft2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_craft2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_craft2ndFieldActionPerformed

    private void craft3rdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_craft3rdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_craft3rdFieldActionPerformed

    private void creditRatingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditRatingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditRatingFieldActionPerformed

    private void cthulhuMythosFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cthulhuMythosFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cthulhuMythosFieldActionPerformed

    private void fighting2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fighting2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fighting2ndFieldActionPerformed

    private void fighting3rdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fighting3rdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fighting3rdFieldActionPerformed

    private void rifle2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rifle2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rifle2ndFieldActionPerformed

    private void languageOther2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageOther2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageOther2ndFieldActionPerformed

    private void languageOther3rdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageOther3rdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageOther3rdFieldActionPerformed

    private void science2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_science2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_science2ndFieldActionPerformed

    private void science3rdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_science3rdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_science3rdFieldActionPerformed

    private void other1stFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other1stFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other1stFieldActionPerformed

    private void other2ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other2ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other2ndFieldActionPerformed

    private void other3rdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other3rdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other3rdFieldActionPerformed

    private void other4thFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other4thFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other4thFieldActionPerformed

    private void other5thFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other5thFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other5thFieldActionPerformed

    private void sexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexFieldActionPerformed

    private void powerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_powerFieldActionPerformed

    private void moveRateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveRateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moveRateFieldActionPerformed

    private void generateNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateNewButtonActionPerformed
        randomAttributes(); 
        aggregateCharacterFields();
        setMoveRate();
        runAllQueries();
        adjustAttributesByCharacterAge();
    }//GEN-LAST:event_generateNewButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DBManagementUI.start();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratorUI().setVisible(true);
            }
        });
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountingField;
    private javax.swing.JLabel accountingLabel;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField anthropologyField;
    private javax.swing.JLabel anthropologyLabel;
    private javax.swing.JTextField appearanceField;
    private javax.swing.JLabel appearanceLabel;
    private javax.swing.JTextField appraiseField;
    private javax.swing.JLabel appraiseLabel;
    private javax.swing.JTextField archeologyField;
    private javax.swing.JLabel archeologyLabel;
    private javax.swing.JTextField charmField;
    private javax.swing.JLabel charmLabel;
    private javax.swing.JTextField climbField;
    private javax.swing.JLabel climbLabel;
    private javax.swing.JTextField conditionField;
    private javax.swing.JLabel conditionLabel;
    private javax.swing.JTextField craft2ndField;
    private javax.swing.JLabel craft2ndLabel;
    private javax.swing.JTextField craft3rdField;
    private javax.swing.JLabel craft3rdLabel;
    private javax.swing.JTextField craftField;
    private javax.swing.JLabel craftLabel;
    private javax.swing.JTextField creditRatingField;
    private javax.swing.JLabel creditRatingLabel;
    private javax.swing.JTextField cthulhuMythosField;
    private javax.swing.JLabel cthulhuMythosLabel;
    private javax.swing.JTextField dexterityField;
    private javax.swing.JLabel dexterityLabel;
    private javax.swing.JTextField disguiseField;
    private javax.swing.JLabel disguiseLabel;
    private javax.swing.JTextField dodgeField;
    private javax.swing.JLabel dodgeLabel;
    private javax.swing.JTextField driveField;
    private javax.swing.JLabel driveLabel;
    private javax.swing.JTextField educationField;
    private javax.swing.JLabel educationLabel;
    private javax.swing.JTextField electricalRepairField;
    private javax.swing.JLabel electricalRepairLabel;
    private javax.swing.JTextField fastTalkField;
    private javax.swing.JLabel fastTalkLabel;
    private javax.swing.JTextField fighting2ndField;
    private javax.swing.JTextField fighting3rdField;
    private javax.swing.JLabel fighting3rdLabel;
    private javax.swing.JTextField fightingField;
    private javax.swing.JLabel fightingLabel;
    private javax.swing.JLabel fightinh2ndLabel;
    private javax.swing.JTextField firstAidField;
    private javax.swing.JLabel firstAidLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton generateNewButton;
    private javax.swing.JTextField handgunField;
    private javax.swing.JLabel handgunLabel;
    private javax.swing.JTextField historyField;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JTextField intelligenceField;
    private javax.swing.JLabel intelligenceLabel;
    private javax.swing.JTextField intimidateField;
    private javax.swing.JLabel intimidateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumpField;
    private javax.swing.JLabel jumpLabel;
    private javax.swing.JTextField languageOther2ndField;
    private javax.swing.JLabel languageOther2ndLabel;
    private javax.swing.JTextField languageOther3rdField;
    private javax.swing.JLabel languageOther3rdLabel;
    private javax.swing.JTextField languageOtherField;
    private javax.swing.JLabel languageOtherLabel;
    private javax.swing.JLabel languageOwn;
    private javax.swing.JTextField languageOwnField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField lawField;
    private javax.swing.JLabel lawLabel;
    private javax.swing.JTextField libraryUseField;
    private javax.swing.JLabel libraryUseLabel;
    private javax.swing.JTextField listenField;
    private javax.swing.JLabel listenLabel;
    private javax.swing.JTextField locksmithingField;
    private javax.swing.JLabel locksmithingLabel;
    private javax.swing.JTextArea logArea;
    private javax.swing.JTextField mechanicalRepairField;
    private javax.swing.JLabel mechanicalRepairLabel;
    private javax.swing.JTextField medicineField;
    private javax.swing.JLabel medicineLabel;
    private javax.swing.JTextField moveRateField;
    private javax.swing.JLabel moveRateLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField naturalWorldField;
    private javax.swing.JLabel naturalWorldLabel;
    private javax.swing.JTextField navigateField;
    private javax.swing.JLabel navigateLabel;
    private javax.swing.JTextField occultField;
    private javax.swing.JLabel occultLabel;
    private javax.swing.JTextField opHvMachineField;
    private javax.swing.JLabel opHvMachineLabel;
    private javax.swing.JTextField other1stField;
    private javax.swing.JLabel other1stLabel;
    private javax.swing.JTextField other2ndField;
    private javax.swing.JLabel other2ndLabel;
    private javax.swing.JTextField other3rdField;
    private javax.swing.JLabel other3rdLabel;
    private javax.swing.JTextField other4thField;
    private javax.swing.JLabel other4thLabel;
    private javax.swing.JTextField other5thField;
    private javax.swing.JLabel other5thLabel;
    private javax.swing.JTextField persuadeField;
    private javax.swing.JLabel persuadeLabel;
    private javax.swing.JTextField pilotField;
    private javax.swing.JLabel pilotLabel;
    private javax.swing.JTextField powerField;
    private javax.swing.JLabel powerLabel;
    private javax.swing.JTextField professionField;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JTextField psychoanalysisField;
    private javax.swing.JLabel psychoanalysisLabel;
    private javax.swing.JTextField psychologyField;
    private javax.swing.JLabel psychologyLabel;
    private javax.swing.JTextField ridingField;
    private javax.swing.JLabel ridingLabel;
    private javax.swing.JTextField rifle2ndField;
    private javax.swing.JLabel rifle2ndLabel;
    private javax.swing.JTextField rifleField;
    private javax.swing.JLabel rifleLabel;
    private javax.swing.JTextField science2ndField;
    private javax.swing.JLabel science2ndLabel;
    private javax.swing.JTextField science3rdField;
    private javax.swing.JLabel science3rdLabel;
    private javax.swing.JTextField scienceField;
    private javax.swing.JLabel scienceLabel;
    private javax.swing.JTextField sexField;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JTextField sizeField;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField sleightOfHandField;
    private javax.swing.JLabel sleightOfHandLabel;
    private javax.swing.JTextField spotHiddenField;
    private javax.swing.JLabel spotHiddenLabel;
    private javax.swing.JTextField stealthField;
    private javax.swing.JLabel stealthLabel;
    private javax.swing.JTextField strengthField;
    private javax.swing.JLabel strengthLabel;
    private javax.swing.JTextField survivalField;
    private javax.swing.JLabel survivalLabel;
    private javax.swing.JTextField swimField;
    private javax.swing.JLabel swimLabel;
    private javax.swing.JTextField throwField;
    private javax.swing.JLabel throwLabel;
    private javax.swing.JTextField trackField;
    private javax.swing.JLabel trackLabel;
    // End of variables declaration//GEN-END:variables

    private ArrayList<javax.swing.JTextField> characterFields;
    private javax.swing.JTextField[] attributesFields;
    private ArrayList<javax.swing.JTextField> skillFields;
    
    private void aggregateAttributesFields() {
        attributesFields = new javax.swing.JTextField[] {
            strengthField,
            dexterityField,
            intelligenceField,
            conditionField,
            appearanceField,
            powerField,
            educationField,
            sizeField
        };
    }   
    private void aggregateSkillFields() {
        skillFields = new ArrayList<>();
        skillFields.add(accountingField);
        skillFields.add(anthropologyField);
        skillFields.add(appraiseField);
        skillFields.add(archeologyField);
        skillFields.add(craftField);
        skillFields.add(craft2ndField);
        skillFields.add(craft3rdField);
        skillFields.add(charmField);
        skillFields.add(climbField);
        skillFields.add(creditRatingField);
        skillFields.add(cthulhuMythosField);
        skillFields.add(disguiseField);
        skillFields.add(dodgeField);
        skillFields.add(driveField);
        skillFields.add(electricalRepairField);
        skillFields.add(fastTalkField);
        skillFields.add(fightingField);
        skillFields.add(fighting2ndField);
        skillFields.add(fighting3rdField);
        skillFields.add(handgunField);
        skillFields.add(rifleField);
        skillFields.add(rifle2ndField);
        skillFields.add(firstAidField);
        skillFields.add(historyField);
        skillFields.add(intimidateField);
        skillFields.add(jumpField);
        skillFields.add(languageOtherField);
        skillFields.add(languageOther2ndField);
        skillFields.add(languageOther3rdField);
        skillFields.add(languageOwnField);
        skillFields.add(lawField);
        skillFields.add(libraryUseField);
        skillFields.add(listenField);
        skillFields.add(locksmithingField);
        skillFields.add(mechanicalRepairField);
        skillFields.add(medicineField);
        skillFields.add(naturalWorldField);
        skillFields.add(navigateField);
        skillFields.add(occultField);
        skillFields.add(opHvMachineField);
        skillFields.add(persuadeField);
        skillFields.add(pilotField);
        skillFields.add(psychologyField);
        skillFields.add(psychoanalysisField);
        skillFields.add(ridingField);
        skillFields.add(scienceField);
        skillFields.add(science2ndField);
        skillFields.add(science3rdField);
        skillFields.add(sleightOfHandField);
        skillFields.add(spotHiddenField);
        skillFields.add(stealthField);
        skillFields.add(survivalField);
        skillFields.add(swimField);
        skillFields.add(throwField);
        skillFields.add(trackField);
        skillFields.add(other1stField);
        skillFields.add(other2ndField);
        skillFields.add(other3rdField);
        skillFields.add(other4thField);
        skillFields.add(other5thField);
        skillFields.add(professionField);
    }
    private void aggregateCharacterFields() {
        characterFields = new ArrayList<>();
        characterFields.add(firstNameField);
        characterFields.add(lastNameField);
        characterFields.add(sexField);
        characterFields.add(ageField);
        characterFields.add(professionField);
    }
}

    
