/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import callofcthulhuDB.util.HibernateUtil;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.DBManagerUtil;

/**
 *
 * @author dezilius
 */
public class DBManagementUI extends javax.swing.JFrame {

    /** Creates new form DBManagementUI */
    public DBManagementUI() {
        initComponents();
    }

    private static final String QUERY_READ_ALL_FIRST_NAME="from FirstName";
    private static final String QUERY_READ_ALL_LAST_NAME="from LastName";
    private static final String QUERY_READ_ALL_PROFESSION="from Profession";
    private static final String QUERY_UPDATE_FIRST_NAME="UPDATE FirstName SET firstName:=name, sex:=mf where id=";
    private static boolean isWindowOpen = false;
    
private void runQueryBasedOnFirstName() {
    executeHQLQueryFirstName(QUERY_READ_ALL_FIRST_NAME);
}
private void executeHQLQueryFirstName(String hql) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(hql);
        List resultList = q.list();
        displayResultFirstName(resultList);
        session.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
}
private void displayResultFirstName(List resultList) {
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders.add("FirstNameId"); 
    tableHeaders.add("FirstName");
    tableHeaders.add("sex");

    for(Object o : resultList) {
        callofcthulhuDB.entity.FirstName name = (callofcthulhuDB.entity.FirstName)o;
        Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(name.getId());
        oneRow.add(name.getFirstName());
        oneRow.add(name.getSex());
        tableData.add(oneRow);
    }
    DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    DbTable.setDefaultEditor(Object.class, null);
}

private void runQueryBasedOnLastName() {
    executeHQLQueryLastName(QUERY_READ_ALL_LAST_NAME);
}
private void executeHQLQueryLastName(String hql) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(hql);
        List resultList = q.list();
        displayResultLastName(resultList);
        session.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
}
private void displayResultLastName(List resultList) {
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders.add("LastNameId"); 
    tableHeaders.add("LastName");

    for(Object o : resultList) {
        callofcthulhuDB.entity.LastName name = (callofcthulhuDB.entity.LastName)o;
        Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(name.getId());
        oneRow.add(name.getLastName());
        tableData.add(oneRow);
    }
    DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    DbTable.setDefaultEditor(Object.class, null);
}

private void runQueryBasedOnProfession() {
    executeHQLQueryProfession(QUERY_READ_ALL_PROFESSION);
}
private void executeHQLQueryProfession(String hql) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(hql);
        List resultList = q.list();
        displayResultProfession(resultList);
        session.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
}
private void displayResultProfession(List resultList) {
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders = DBManagerUtil.mapTable(tableHeaders);

    for(Object o : resultList) {
        callofcthulhuDB.entity.Profession name = (callofcthulhuDB.entity.Profession)o;
        Vector<Object> oneRow = new Vector<Object>();
        DBManagerUtil.fillRow(oneRow, name);
        tableData.add(oneRow);
    }
    DbTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    DbTable.setDefaultEditor(Object.class, null);
}

private void executeHQLQueryCreateFirstName() {
    callofcthulhuDB.entity.FirstName firstName = null;
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        firstName = new callofcthulhuDB.entity.FirstName();
        firstName.setFirstName(textField1.getText());
        firstName.setSex(textField2.getText());
        session.save(firstName);
        session.getTransaction().commit();
        session.close();
    } catch (HibernateException he) {
        he.printStackTrace();
    }    
}
private void executeHQLQueryCreateLastName() {
    callofcthulhuDB.entity.LastName lastName = null;
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        lastName = new callofcthulhuDB.entity.LastName();
        lastName.setLastName(textField1.getText());
        session.save(lastName);
        session.getTransaction().commit();
        session.close();
    } catch (HibernateException he) {
        he.printStackTrace();
    }    
}
private void executeHQLQueryCreateProfession() {
    callofcthulhuDB.entity.Profession profession = null;
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        profession = new callofcthulhuDB.entity.Profession();
        profession.setProfession(textField1.getText());
        profession.setMinAge(Integer.parseInt(textField2.getText()));
        profession.setMaxAge(Integer.parseInt(textField3.getText()));
        session.save(profession);
        session.getTransaction().commit();
        session.close();
    } catch (HibernateException he) {
        he.printStackTrace();
    }    
}

private void executeHQLQueryUpdateFirstName() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to update?", 
            "Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from FirstName where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.FirstName firstName = 
                    (callofcthulhuDB.entity.FirstName) resultList.get(0);
            firstName.setFirstName(textField1.getText());
            firstName.setSex(textField2.getText());
            session.update(firstName);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }       
    } 
}
private void executeHQLQueryUpdateLastName() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to update?", 
            "Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from LastName where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.LastName lastName = 
                    (callofcthulhuDB.entity.LastName) resultList.get(0);
            lastName.setLastName(textField1.getText());
            session.update(lastName);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
private void executeHQLQueryUpdateProfession() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to update?", 
            "Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Profession where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.Profession profession = 
                    (callofcthulhuDB.entity.Profession) resultList.get(0);
            profession.setProfession(textField1.getText());
            profession.setMinAge(Integer.parseInt(textField2.getText()));
            profession.setMaxAge(Integer.parseInt(textField3.getText()));
            session.update(profession);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }  
    }
}

private void executeHQLQueryDeleteFirstName() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to delete?", 
            "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from FirstName where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.FirstName firstName = 
                    (callofcthulhuDB.entity.FirstName) resultList.get(0);
            firstName.setFirstName("");
            firstName.setSex("");
            session.update(firstName);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
private void executeHQLQueryDeleteLastName() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to delete?", 
            "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from LastName where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.LastName lastName = 
                    (callofcthulhuDB.entity.LastName) resultList.get(0);
            lastName.setLastName("");
            session.update(lastName);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
private void executeHQLQueryDeleteProfession() {
    Object[] choice = {"yes", "no"};
    int decision = JOptionPane.showOptionDialog(null,"Are you sure tou want to delete?", 
            "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
    if (decision == 0) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Profession where id=" + (DbTable.getSelectedRow() + 1));
            List resultList = q.list();
            callofcthulhuDB.entity.Profession profession = 
                    (callofcthulhuDB.entity.Profession) resultList.get(0);
            profession.setProfession("");
            profession.setMinAge(0);
            profession.setMaxAge(0);
            session.update(profession);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }  
    }
}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DbTable = new javax.swing.JTable();
        chooseBox = new javax.swing.JComboBox<>();
        readButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        textField3 = new javax.swing.JTextField();
        textField1 = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        DbTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DbTable.setCellSelectionEnabled(true);
        DbTable.setDragEnabled(true);
        jScrollPane1.setViewportView(DbTable);

        chooseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "FirstName", "LastName", "Profession" }));
        chooseBox.setMinimumSize(new java.awt.Dimension(100, 25));
        chooseBox.setName(""); // NOI18N
        chooseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBoxActionPerformed(evt);
            }
        });

        readButton.setText("Read");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.setToolTipText("");
        createButton.setEnabled(false);
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.setToolTipText("");
        updateButton.setEnabled(false);
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setToolTipText("");
        deleteButton.setEnabled(false);
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        textField3.setColumns(6);
        textField3.setEnabled(false);

        textField1.setColumns(6);
        textField1.setEnabled(false);

        textField2.setColumns(6);
        textField2.setEnabled(false);

        label1.setText(" ");

        label2.setText(" ");

        label3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(readButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(label2)
                    .addComponent(label3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        if (chooseBox.getSelectedItem().equals("FirstName")) {
            runQueryBasedOnFirstName();
        }
        else if (chooseBox.getSelectedItem().equals("LastName")) {
            runQueryBasedOnLastName();
        }
        else if (chooseBox.getSelectedItem().equals("Profession")) {
            runQueryBasedOnProfession();
        }
    }//GEN-LAST:event_readButtonActionPerformed

    private void chooseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBoxActionPerformed
        if (chooseBox.getSelectedItem().equals("FirstName")) {
            initFieldsFirstName();
            initLabelsFirstName();
        }
        else if (chooseBox.getSelectedItem().equals("LastName")) {
            initFieldsLastName();
            initLabelsLastName();
        }
        else if (chooseBox.getSelectedItem().equals("Profession")) {
            initFieldsProfession();
            initLabelsProfession();
        }
        else {
            initFieldsDefault();
            initLabelsDefault();
        }
    }//GEN-LAST:event_chooseBoxActionPerformed

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked
        if (chooseBox.getSelectedItem().equals("FirstName")) {
            executeHQLQueryCreateFirstName();
        }
        else if (chooseBox.getSelectedItem().equals("LastName")) {
            executeHQLQueryCreateLastName();
        }
        else if (chooseBox.getSelectedItem().equals("Profession")) {
            executeHQLQueryCreateProfession();
        }
    }//GEN-LAST:event_createButtonMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        if (chooseBox.getSelectedItem().equals("FirstName")) {
            executeHQLQueryUpdateFirstName();
        }
        else if (chooseBox.getSelectedItem().equals("LastName")) {
            executeHQLQueryUpdateLastName();
        }
        else if (chooseBox.getSelectedItem().equals("Profession")) {
            executeHQLQueryUpdateProfession();
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        if (chooseBox.getSelectedItem().equals("FirstName")) {
            executeHQLQueryDeleteFirstName();
        }
        else if (chooseBox.getSelectedItem().equals("LastName")) {
            executeHQLQueryDeleteLastName();
        }
        else if (chooseBox.getSelectedItem().equals("Profession")) {
            executeHQLQueryDeleteProfession();
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        isWindowOpen = false;
    }//GEN-LAST:event_formWindowClosing

    private void initFieldsFirstName() {
        textField1.setEnabled(true);
        textField2.setEnabled(true);
        textField3.setEnabled(false);
        initButtonsOn();
    }
    private void initLabelsFirstName() {
        label1.setText("First Name");
        label2.setText("Sex");
        label3.setText("");
    }
    
    private void initFieldsLastName() {
        textField1.setEnabled(true);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        initButtonsOn();
    }
    private void initLabelsLastName() {
        label1.setText("Last Name");
        label2.setText("");
        label3.setText("");
    }
    
    private void initFieldsProfession() {
        textField1.setEnabled(true);
        textField2.setEnabled(true);
        textField3.setEnabled(true);
        initButtonsOn();
    }
    private void initLabelsProfession() {
        label1.setText("Profession");
        label2.setText("min Age");
        label3.setText("max Age");
    }   
    
    private void initFieldsDefault() {
        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        initButtonsOff();
    }
    private void initLabelsDefault() {
        label1.setText(" ");
        label2.setText(" ");
        label3.setText(" ");
    }      
    
    private void initButtonsOff() {
        createButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    private void initButtonsOn() {
        createButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (!isWindowOpen) {
                    new DBManagementUI().setVisible(true);
                    isWindowOpen = true;
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DbTable;
    private javax.swing.JComboBox<String> chooseBox;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JButton readButton;
    private javax.swing.JTextField textField1;
    private javax.swing.JTextField textField2;
    private javax.swing.JTextField textField3;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
