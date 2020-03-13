/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import util.Tools;
import util.AttrChar;
import util.InfoChar;
import util.QuerryUtil;
import util.SkillChar;

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
    
private void randomAll() {
    randomFirstName();
    randomLastName();
    randomProfession();
}
private void randomFirstName() {
    List result = QuerryUtil.executeHQLQueryNumberOfFirstName(QUERY_NUMBER_OF_ROWS_FIRST_NAME);
    InfoChar.displayResultFirstName(result);
}
private void randomLastName() {
    List result = QuerryUtil.executeHQLQueryNumberOfLastName(QUERY_NUMBER_OF_ROWS_LAST_NAME);
    InfoChar.displayResultLastName(result);
}
private void randomProfession() {
    List result = QuerryUtil.executeHQLQueryNumberOfProfession(QUERY_NUMBER_OF_ROWS_PROFESSION);
    InfoChar.displayResultProfession(result);
}
private void randomAttributes() {
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
    setMoveRate();
    InfoChar.setMagicPoints();
    InfoChar.setLuck();
    InfoChar.setHP();
    InfoChar.setSanity();
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
    int movementRate = Integer.parseInt(moveRateField.getText());
    String message = "";
    
    if (age >= 15 && age < 20) {
        AttrChar.remove2Attr(5);
        Tools.removePoint(educationField, 5);
        message = "5 point(s) removed from education";
    }
    
    else if (age >= 20 && age < 40) {
        AttrChar.improvementValue(1);
    }
    
    else if (age >= 40 && age < 50) {
        AttrChar.improvementValue(2);
        AttrChar.remove3Attr(5);
        Tools.removePoint(appearanceField, 5);
        movementRate -= 1;
        message = "5 point(s) removed from appearance\n 1 point(s) removed from movement rate";
    }
    
    else if (age >= 50 && age < 60) {
        AttrChar.improvementValue(3);
        AttrChar.remove3Attr(10);
        Tools.removePoint(appearanceField, 10);
        movementRate -= 2;
        message = "10 point(s) removed from appearance\n 2 point(s) removed from movement rate";
    }
    
    else if (age >= 60 && age < 70) {
        AttrChar.improvementValue(4);
        AttrChar.remove3Attr(20);
        Tools.removePoint(appearanceField, 15);
        movementRate -= 3;
        message = "15 point(s) removed from appearance\n 3 point(s) removed from movement rate";
    }
    
    else if (age >= 70 && age < 80) {
        AttrChar.improvementValue(4);
        AttrChar.remove3Attr(40);
        Tools.removePoint(appearanceField, 20);
        movementRate -= 4;
        message = "20 point(s) removed from appearance\n 4 point(s) removed from movement rate";
    }
    
    else if (age >= 80 && age < 90) {
        AttrChar.improvementValue(4);
        AttrChar.remove3Attr(80);
        Tools.removePoint(appearanceField, 25);
        movementRate -= 5;
        message = "25 point(s) removed from appearance\n 5 point(s) removed from movement rate";
    }
    moveRateField.setText(Integer.toString(movementRate));
    AttrChar.appendLog(message);
}
  
int delay = 100; 
ActionListener refreshSkillFields = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
          SkillChar.fieldsProperCheck();
          SkillChar.availableSkillPoints();
    }
};

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
        jPanel10 = new javax.swing.JPanel();
        generateNewButton = new javax.swing.JButton();
        rollFirstNameButton = new javax.swing.JButton();
        rollLastNameButton = new javax.swing.JButton();
        rollProfessionButton = new javax.swing.JButton();
        rollAttributesButton = new javax.swing.JButton();
        allocateSPButton = new javax.swing.JToggleButton();
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
        sanityLabel = new javax.swing.JLabel();
        HPLabel = new javax.swing.JLabel();
        MPLabel = new javax.swing.JLabel();
        luckLabel = new javax.swing.JLabel();
        HPField = new javax.swing.JTextField();
        sanityField = new javax.swing.JTextField();
        MPField = new javax.swing.JTextField();
        luckField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        openDBMButton = new javax.swing.JButton();
        skillPointsField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Character Generator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1220, 780));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setInheritsPopupMenu(true);

        anthropologyField.setEditable(false);
        anthropologyField.setColumns(2);
        anthropologyField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        anthropologyLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        anthropologyLabel.setText("Anthropology");

        appraiseLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        appraiseLabel.setText("Appraise");

        appraiseField.setEditable(false);
        appraiseField.setColumns(2);
        appraiseField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        archeologyLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        archeologyLabel.setText("Archeology");

        archeologyField.setEditable(false);
        archeologyField.setColumns(2);
        archeologyField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        craftLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        craftLabel.setText("Craft");

        craftField.setEditable(false);
        craftField.setColumns(2);
        craftField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        charmLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        charmLabel.setText("Charm");

        charmField.setEditable(false);
        charmField.setColumns(2);
        charmField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        climbLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        climbLabel.setText("Climb");

        climbField.setEditable(false);
        climbField.setColumns(2);
        climbField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        disguiseLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        disguiseLabel.setText("Disguise");

        disguiseField.setEditable(false);
        disguiseField.setColumns(2);
        disguiseField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        electricalRepairLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        electricalRepairLabel.setText("Electrical Repair");

        electricalRepairField.setEditable(false);
        electricalRepairField.setColumns(2);
        electricalRepairField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        accountingField.setEditable(false);
        accountingField.setColumns(2);
        accountingField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        accountingLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        accountingLabel.setText("Accounting");

        dodgeLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        dodgeLabel.setText("Dodge (half DEX)");

        dodgeField.setEditable(false);
        dodgeField.setColumns(2);
        dodgeField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        craft2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        craft2ndField.setEditable(false);
        craft2ndField.setColumns(2);
        craft2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        craft3rdLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        craft3rdField.setEditable(false);
        craft3rdField.setColumns(2);
        craft3rdField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        creditRatingLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        creditRatingLabel.setText("Credit Rating");

        creditRatingField.setEditable(false);
        creditRatingField.setColumns(2);
        creditRatingField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        cthulhuMythosLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        cthulhuMythosLabel.setText("Cthulhu Mythos");

        cthulhuMythosField.setEditable(false);
        cthulhuMythosField.setColumns(2);
        cthulhuMythosField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        driveLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        driveLabel.setText("Drive");

        driveField.setEditable(false);
        driveField.setColumns(2);
        driveField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(charmLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(craft3rdLabel)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(craft2ndLabel)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(craftLabel)
                                            .addComponent(archeologyLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(creditRatingLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(climbLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cthulhuMythosLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(disguiseLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dodgeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(driveLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(electricalRepairLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(accountingLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(anthropologyLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountingField)
                            .addComponent(anthropologyField)
                            .addComponent(archeologyField)
                            .addComponent(craftField)
                            .addComponent(craft2ndField)
                            .addComponent(craft3rdField)
                            .addComponent(climbField)
                            .addComponent(creditRatingField)
                            .addComponent(cthulhuMythosField)
                            .addComponent(disguiseField)
                            .addComponent(dodgeField)
                            .addComponent(driveField)
                            .addComponent(electricalRepairField)
                            .addComponent(charmField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appraiseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appraiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountingLabel)
                    .addComponent(accountingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anthropologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anthropologyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appraiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appraiseLabel))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(archeologyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archeologyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(craftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(craftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(craft2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(craft3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(craft2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(craft3rdLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                            .addComponent(electricalRepairLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        handgunLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        handgunLabel.setText("Handgun");

        rifleField.setEditable(false);
        rifleField.setColumns(2);
        rifleField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        rifleLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        rifleLabel.setText("Rifle");

        historyField.setEditable(false);
        historyField.setColumns(2);
        historyField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        historyLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        historyLabel.setText("History");

        intimidateField.setEditable(false);
        intimidateField.setColumns(2);
        intimidateField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        intimidateLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        intimidateLabel.setText("Intimidate");

        jumpLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        jumpLabel.setText("Jump");

        jumpField.setEditable(false);
        jumpField.setColumns(2);
        jumpField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOtherField.setEditable(false);
        languageOtherField.setColumns(2);
        languageOtherField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOtherLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        languageOtherLabel.setText("Language (Other)");

        languageOwnField.setEditable(false);
        languageOwnField.setColumns(2);
        languageOwnField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOwn.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        languageOwn.setText("Language (Own)(EDU)");

        firstAidField.setEditable(false);
        firstAidField.setColumns(2);
        firstAidField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        firstAidLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        firstAidLabel.setText("First Aid");

        fastTalkLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        fastTalkLabel.setText("Fast Talk");

        fastTalkField.setEditable(false);
        fastTalkField.setColumns(2);
        fastTalkField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        fightingLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        fightingLabel.setText("Fighting (Brawl)");

        fightingField.setEditable(false);
        fightingField.setColumns(2);
        fightingField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        handgunField.setEditable(false);
        handgunField.setColumns(2);
        handgunField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        fightinh2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        fighting2ndField.setEditable(false);
        fighting2ndField.setColumns(2);
        fighting2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        fighting3rdField.setEditable(false);
        fighting3rdField.setColumns(2);
        fighting3rdField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        fighting3rdLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        rifle2ndField.setEditable(false);
        rifle2ndField.setColumns(2);
        rifle2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        rifle2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOther2ndField.setEditable(false);
        languageOther2ndField.setColumns(2);
        languageOther2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOther2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOther3rdLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        languageOther3rdField.setEditable(false);
        languageOther3rdField.setColumns(2);
        languageOther3rdField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(rifleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rifleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(fastTalkLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fastTalkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(fightingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fightingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fighting2ndField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fighting3rdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(handgunLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(handgunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(languageOther2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(languageOther3rdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fightinh2ndLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fighting3rdLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rifle2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(languageOther3rdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(languageOther2ndLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rifle2ndLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(languageOtherLabel)
                                    .addComponent(jumpLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumpField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(languageOtherField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(intimidateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intimidateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(firstAidLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstAidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(historyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(historyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(languageOwn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(languageOwnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fastTalkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fastTalkLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fightingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fightingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fighting2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fighting3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handgunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(handgunLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rifleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rifleLabel))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fightinh2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rifle2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fighting3rdLabel)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstAidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstAidLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intimidateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intimidateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rifle2ndLabel)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumpLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(languageOtherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(languageOtherLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(languageOther2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(languageOther3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(languageOwnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(languageOwn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languageOther2ndLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languageOther3rdLabel))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lawField.setEditable(false);
        lawField.setColumns(2);
        lawField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        lawLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        lawLabel.setText("Law");

        libraryUseField.setEditable(false);
        libraryUseField.setColumns(2);
        libraryUseField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        libraryUseLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        libraryUseLabel.setText("Library use");

        listenField.setEditable(false);
        listenField.setColumns(2);
        listenField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        listenLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        listenLabel.setText("Listen");

        locksmithingLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        locksmithingLabel.setText("Locksmithing");

        locksmithingField.setEditable(false);
        locksmithingField.setColumns(2);
        locksmithingField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        mechanicalRepairLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        mechanicalRepairLabel.setText("Mechanical Repair");

        mechanicalRepairField.setEditable(false);
        mechanicalRepairField.setColumns(2);
        mechanicalRepairField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        medicineLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        medicineLabel.setText("Medicine");

        medicineField.setEditable(false);
        medicineField.setColumns(2);
        medicineField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        persuadeLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        persuadeLabel.setText("Persuade");

        persuadeField.setEditable(false);
        persuadeField.setColumns(2);
        persuadeField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        pilotLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        pilotLabel.setText("Pilot");

        pilotField.setEditable(false);
        pilotField.setColumns(2);
        pilotField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        opHvMachineLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        opHvMachineLabel.setText("Op.Hv.Machine");

        opHvMachineField.setEditable(false);
        opHvMachineField.setColumns(2);
        opHvMachineField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        psychoanalysisField.setEditable(false);
        psychoanalysisField.setColumns(2);
        psychoanalysisField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        psychoanalysisLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        psychoanalysisLabel.setText("Psychoanalysis");

        ridingField.setEditable(false);
        ridingField.setColumns(2);
        ridingField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        ridingLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        ridingLabel.setText("Riding");

        occultField.setEditable(false);
        occultField.setColumns(2);
        occultField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        occultLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        occultLabel.setText("Occult");

        naturalWorldLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        naturalWorldLabel.setText("Natural World");

        naturalWorldField.setEditable(false);
        naturalWorldField.setColumns(2);
        naturalWorldField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        navigateField.setEditable(false);
        navigateField.setColumns(2);
        navigateField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        navigateLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        navigateLabel.setText("Navigate");

        psychologyLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        psychologyLabel.setText("Psychology");

        psychologyField.setEditable(false);
        psychologyField.setColumns(2);
        psychologyField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lawLabel)
                                    .addComponent(libraryUseLabel)
                                    .addComponent(listenLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pilotLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(psychologyLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(persuadeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(opHvMachineLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(occultLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(navigateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(naturalWorldLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(medicineLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mechanicalRepairLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(locksmithingLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psychologyField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pilotField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(naturalWorldField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(navigateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(occultField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opHvMachineField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(persuadeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medicineField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lawField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(libraryUseField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listenField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locksmithingField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mechanicalRepairField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(ridingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ridingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(psychoanalysisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(psychoanalysisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        scienceField.setEditable(false);
        scienceField.setColumns(2);
        scienceField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        scienceLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        scienceLabel.setText("Science");

        science2ndField.setEditable(false);
        science2ndField.setColumns(2);
        science2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        science2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        science3rdField.setEditable(false);
        science3rdField.setColumns(2);
        science3rdField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        science3rdLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        sleightOfHandLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        sleightOfHandLabel.setText("Sleight of Hand");

        sleightOfHandField.setEditable(false);
        sleightOfHandField.setColumns(2);
        sleightOfHandField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        spotHiddenLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        spotHiddenLabel.setText("Spot Hidden");

        spotHiddenField.setEditable(false);
        spotHiddenField.setColumns(2);
        spotHiddenField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        stealthField.setEditable(false);
        stealthField.setColumns(2);
        stealthField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        stealthLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        stealthLabel.setText("Stealth");

        survivalLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        survivalLabel.setText("Survival");

        survivalField.setEditable(false);
        survivalField.setColumns(2);
        survivalField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        swimLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        swimLabel.setText("Swim");

        swimField.setEditable(false);
        swimField.setColumns(2);
        swimField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        throwLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        throwLabel.setText("Throw");

        throwField.setEditable(false);
        throwField.setColumns(2);
        throwField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        trackLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        trackLabel.setText("Track");

        trackField.setEditable(false);
        trackField.setColumns(2);
        trackField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other1stLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other1stField.setEditable(false);
        other1stField.setColumns(2);
        other1stField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other2ndLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other2ndField.setEditable(false);
        other2ndField.setColumns(2);
        other2ndField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other3rdLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other3rdField.setEditable(false);
        other3rdField.setColumns(2);
        other3rdField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other4thLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other4thField.setEditable(false);
        other4thField.setColumns(2);
        other4thField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other5thField.setEditable(false);
        other5thField.setColumns(2);
        other5thField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        other5thLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(other5thLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(science3rdLabel)
                            .addComponent(science2ndLabel)
                            .addComponent(other3rdLabel)
                            .addComponent(other2ndLabel)
                            .addComponent(other1stLabel)
                            .addComponent(other4thLabel)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sleightOfHandLabel)
                                .addComponent(scienceLabel))
                            .addComponent(spotHiddenLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stealthLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(survivalLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(swimLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(throwLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(trackLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(science3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(science2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scienceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(other5thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(other3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(other2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(other1stField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(swimField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(survivalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stealthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sleightOfHandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spotHiddenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(throwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(other4thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(science2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(science3rdLabel)
                        .addGap(153, 153, 153)
                        .addComponent(other1stLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other2ndLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other3rdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other4thLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scienceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scienceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(science2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(science3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(other1stField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other2ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other3rdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other4thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other5thField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(other5thLabel))
        );

        generateNewButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        generateNewButton.setText("Generate NEW!");
        generateNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateNewButtonActionPerformed(evt);
            }
        });

        rollFirstNameButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        rollFirstNameButton.setText("New First Name");
        rollFirstNameButton.setEnabled(false);
        rollFirstNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollFirstNameButtonActionPerformed(evt);
            }
        });

        rollLastNameButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        rollLastNameButton.setText("New Last Name");
        rollLastNameButton.setEnabled(false);
        rollLastNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollLastNameButtonActionPerformed(evt);
            }
        });

        rollProfessionButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        rollProfessionButton.setText("New Profession");
        rollProfessionButton.setEnabled(false);
        rollProfessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollProfessionButtonActionPerformed(evt);
            }
        });

        rollAttributesButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        rollAttributesButton.setText("Roll Attributes");
        rollAttributesButton.setEnabled(false);
        rollAttributesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollAttributesButtonActionPerformed(evt);
            }
        });

        allocateSPButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        allocateSPButton.setText("Allocate SP");
        allocateSPButton.setEnabled(false);
        allocateSPButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allocateSPButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rollFirstNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(generateNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(allocateSPButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rollAttributesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rollProfessionButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(rollLastNameButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(generateNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollFirstNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollLastNameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollProfessionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollAttributesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allocateSPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {generateNewButton, rollAttributesButton, rollLastNameButton, rollProfessionButton});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        appearanceLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        appearanceLabel.setText("APP");

        powerLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        powerLabel.setText("POW");

        sizeLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        sizeLabel.setText("SIZ");

        educationLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        educationLabel.setText("EDU");

        moveRateLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        moveRateLabel.setText("Move Rate");
        moveRateLabel.setToolTipText("");

        strengthField.setEditable(false);
        strengthField.setColumns(5);
        strengthField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        dexterityField.setEditable(false);
        dexterityField.setColumns(5);
        dexterityField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        intelligenceField.setEditable(false);
        intelligenceField.setColumns(5);
        intelligenceField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        conditionField.setEditable(false);
        conditionField.setColumns(5);
        conditionField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        appearanceField.setEditable(false);
        appearanceField.setColumns(5);
        appearanceField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        powerField.setEditable(false);
        powerField.setColumns(5);
        powerField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        sizeField.setEditable(false);
        sizeField.setColumns(5);
        sizeField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        educationField.setEditable(false);
        educationField.setColumns(5);
        educationField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        moveRateField.setEditable(false);
        moveRateField.setColumns(5);
        moveRateField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        dexterityLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        dexterityLabel.setText("DEX");

        strengthLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        strengthLabel.setText("STR");

        intelligenceLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        intelligenceLabel.setText("INT");

        conditionLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        conditionLabel.setText("CON");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(moveRateLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moveRateField)
                            .addComponent(powerField))))
                .addContainerGap())
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFocusTraversalPolicyProvider(true);

        firstNameField.setEditable(false);
        firstNameField.setColumns(8);
        firstNameField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        lastNameField.setEditable(false);
        lastNameField.setColumns(8);
        lastNameField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        professionField.setEditable(false);
        professionField.setColumns(10);
        professionField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        ageField.setEditable(false);
        ageField.setColumns(3);
        ageField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        sexField.setEditable(false);
        sexField.setColumns(5);
        sexField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        sexLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        sexLabel.setText("Sex");

        nameLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        nameLabel.setText("Name");

        professionLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        professionLabel.setText("Profession");

        ageLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        ageLabel.setText("Age");

        sanityLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        sanityLabel.setText("Sanity");

        HPLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        HPLabel.setText("HP ");

        MPLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        MPLabel.setText("MP");

        luckLabel.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N
        luckLabel.setText("Luck");

        HPField.setEditable(false);
        HPField.setColumns(2);
        HPField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        sanityField.setEditable(false);
        sanityField.setColumns(2);
        sanityField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        MPField.setEditable(false);
        MPField.setColumns(2);
        MPField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        luckField.setEditable(false);
        luckField.setColumns(2);
        luckField.setFont(new java.awt.Font("Droid Serif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(professionLabel)
                    .addComponent(nameLabel)
                    .addComponent(ageLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(HPLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField))
                    .addComponent(professionField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sexLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sanityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sanityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(MPLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(luckLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luckField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sanityLabel)
                    .addComponent(MPLabel)
                    .addComponent(HPLabel)
                    .addComponent(luckLabel)
                    .addComponent(HPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sanityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luckField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        firstNameField.getAccessibleContext().setAccessibleName("firstNameField");
        firstNameField.getAccessibleContext().setAccessibleParent(this);
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        openDBMButton.setFont(new java.awt.Font("Droid Serif", 1, 12)); // NOI18N
        openDBMButton.setText("Open DB Manager");
        openDBMButton.setToolTipText("");
        openDBMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDBMButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(openDBMButton, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openDBMButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        skillPointsField.setFont(new java.awt.Font("Droid Serif", 1, 18)); // NOI18N
        skillPointsField.setText("Skill points available: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(skillPointsField)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skillPointsField)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("CharacterGenerator");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void generateNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateNewButtonActionPerformed
        innitializeStartingConditions();
        randomAll();
        randomAttributes(); 
        adjustAttributesByCharacterAge();
        SkillChar.setDefaultValues(skillFields, educationField, dexterityField);
        SkillChar.setSkillPoints();
        rollFirstNameButton.setEnabled(true);
        rollLastNameButton.setEnabled(true);
        rollProfessionButton.setEnabled(true);
        rollAttributesButton.setEnabled(true);
        allocateSPButton.setEnabled(true);
        new Timer(delay, refreshSkillFields).start();
    }//GEN-LAST:event_generateNewButtonActionPerformed

    private void innitializeStartingConditions() {
        logArea.setText("");
        aggregateCharacterFields();
        aggregateAttrCharFields();
        aggregateAttributesFields();
        aggregateSkillFields();
        AttrChar.initAttrChar(attrCharFields, logArea);
        InfoChar.initInfoChar(characterFields, conditionField, sizeField, powerField);
        SkillChar.initSkillChar(skillPointsField, intelligenceField, skillFields);
    }
    
    private ArrayList<javax.swing.JTextField> characterFields;
    private ArrayList<javax.swing.JTextField> skillFields;
    private ArrayList<javax.swing.JTextField> attrCharFields;
    private javax.swing.JTextField[] attributesFields;
    
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
    private void aggregateAttrCharFields() {
        attrCharFields = new ArrayList<>();
        attrCharFields.add(strengthField);
        attrCharFields.add(sizeField);
        attrCharFields.add(conditionField);
        attrCharFields.add(dexterityField);
        attrCharFields.add(educationField);
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
    }
    private void aggregateCharacterFields() {
        characterFields = new ArrayList<>();
        characterFields.add(firstNameField);
        characterFields.add(lastNameField);
        characterFields.add(sexField);
        characterFields.add(ageField);
        characterFields.add(professionField);
        characterFields.add(HPField);
        characterFields.add(MPField);
        characterFields.add(sanityField);
        characterFields.add(luckField);
    }
    
    private void openDBMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDBMButtonActionPerformed
        DBManagementUI.start();
    }//GEN-LAST:event_openDBMButtonActionPerformed
    
    private void rollFirstNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollFirstNameButtonActionPerformed
        randomFirstName();
    }//GEN-LAST:event_rollFirstNameButtonActionPerformed

    private void rollLastNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollLastNameButtonActionPerformed
        randomLastName();
    }//GEN-LAST:event_rollLastNameButtonActionPerformed

    private void rollProfessionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollProfessionButtonActionPerformed
        randomProfession();
    }//GEN-LAST:event_rollProfessionButtonActionPerformed

    private void rollAttributesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollAttributesButtonActionPerformed
        randomAttributes(); 
        adjustAttributesByCharacterAge();
        SkillChar.setSkillPoints();
    }//GEN-LAST:event_rollAttributesButtonActionPerformed
    
    private void allocateSPButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allocateSPButtonMouseClicked
        
        if (allocateSPButton.isSelected()) {
            SkillChar.setEditableOnSkillFields();
            generateNewButton.setEnabled(false);
            rollFirstNameButton.setEnabled(false);
            rollLastNameButton.setEnabled(false);
            rollProfessionButton.setEnabled(false);
            rollAttributesButton.setEnabled(false);
            openDBMButton.setEnabled(false);
            allocateSPButton.setText("Save");
            SkillChar.setColorGreen();
        }
        else if (!SkillChar.isSkillPointAvailable()){
            SkillChar.setEditableOffSkillFields();
            generateNewButton.setEnabled(true);
            rollFirstNameButton.setEnabled(true);
            rollLastNameButton.setEnabled(true);
            rollProfessionButton.setEnabled(true);
            rollAttributesButton.setEnabled(true);
            openDBMButton.setEnabled(true);
            allocateSPButton.setText("Allocate SP");
            SkillChar.setColorWhite();
        }
        else {
            allocateSPButton.setSelected(true);
            JOptionPane.showMessageDialog(null, "Too many points allocated.", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_allocateSPButtonMouseClicked

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
    private javax.swing.JTextField HPField;
    private javax.swing.JLabel HPLabel;
    private javax.swing.JTextField MPField;
    private javax.swing.JLabel MPLabel;
    private javax.swing.JTextField accountingField;
    private javax.swing.JLabel accountingLabel;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JToggleButton allocateSPButton;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JTextField luckField;
    private javax.swing.JLabel luckLabel;
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
    private javax.swing.JButton openDBMButton;
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
    private javax.swing.JButton rollAttributesButton;
    private javax.swing.JButton rollFirstNameButton;
    private javax.swing.JButton rollLastNameButton;
    private javax.swing.JButton rollProfessionButton;
    private javax.swing.JTextField sanityField;
    private javax.swing.JLabel sanityLabel;
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
    private javax.swing.JLabel skillPointsField;
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
}

    
