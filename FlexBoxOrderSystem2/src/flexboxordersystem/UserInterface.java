/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexboxordersystem;

/**
 *
 * @author up777815, up831038, up877101, up867692
 */

import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class UserInterface extends JFrame
{
    private final JLabel /*bannerImage, specifyRequirements, boxDimensionsText, 
                         heightWidthLengthText, seperatorHWL1, seperatorHWL2, 
                         cardboardGradeText, colourPrintingText, 
                         reinforcementText, sealableTopText, quantityText, */
                         currTotalCost;
    private String[] cardboardGrades = {"1", "2", "3", "4", "5"};
    private final JTextField heightInp, widthInp, lengthInp, 
                             quantityInp;
    
    //Combo Box for cardboard grades - less scope for errors
    private final JComboBox gradeInp;
    
    //Added a decimal format so that we can present the tostal cost in a nicer way
    private DecimalFormat df = new DecimalFormat("#.00");
    
    
    private final JRadioButton noColourButton, oneColourButton, twoColourButton;
    /*private final ButtonGroup colourPrintingGroup;*/
    private final JCheckBox bottomReinforcement, cornerReinforcement, 
                            sealableTop;
    private final JButton addItemButton;
    
    //temp stores for variables used in creation of classes
    private int heightTemp, widthTemp, lengthTemp, quantityTemp, gradeTemp, 
                colourTemp;
    private boolean bottomTemp, cornerTemp, sealableTemp = false;
    private final ArrayList<CardboardBox> objArr;
    
    
    
    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;

    // End of variables declaration   
   
    //UserInterface constructor  adds components to JFrame
    public UserInterface()
    {        
        super("FlexBox Ordering System");
        setLayout(new FlowLayout());
        
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        widthInp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lengthInp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        heightInp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gradeInp = new javax.swing.JComboBox(cardboardGrades);
        jLabel7 = new javax.swing.JLabel();
        noColourButton = new javax.swing.JRadioButton();
        oneColourButton = new javax.swing.JRadioButton();
        twoColourButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        bottomReinforcement = new javax.swing.JCheckBox();
        cornerReinforcement = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
//        jRadioButtonYes = new javax.swing.JRadioButton();
//        jRadioButtonNo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        quantityInp = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        sealableTop = new javax.swing.JCheckBox();
        addItemButton = new javax.swing.JButton();
        currTotalCost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FlexBox");

        jLabel2.setText("Size of the Box:");

        jLabel3.setText("Width");

        widthInp.setText("Enter Width");

        jLabel4.setText("Length");

        lengthInp.setText("Enter Length");

        jLabel5.setText("Height");

        heightInp.setText("Enter Height");

        jLabel6.setText("Grade of CardBoard:");

        jLabel7.setText("Color Printing:");

        noColourButton.setText("No Color");

        oneColourButton.setText("1 Color");

        twoColourButton.setText("2 Color");

        jLabel8.setText("Bottom and/or corner Reinforcement:");

        bottomReinforcement.setText("Bottom");

        cornerReinforcement.setText("Corner");

        jLabel9.setText("Sealable Top:");
        
        jLabel10.setText("Quantity:");

        quantityInp.setText("Enter number of boxes...");

        jButtonAdd.setText("Add");

        jButtonReset.setText("Reset");

        jButtonSubmit.setText("Submit");

        jButtonExit.setText("Exit");

        sealableTop.setText("Sealable Top");

        addItemButton.setText("Add item to order");
        
        
        //Shorthand for adding an action listener to the buttons
        addItemButton.addActionListener(this::buttonHandler);
        
        /*  Add a lsitener to the grade combobox so that when a grade is selected,
            Only valid options for the other inputs are avaialble */
        gradeInp.addActionListener(this::gradeSelected);
        gradeInp.setSelectedIndex(0);
       
        
        //Focus listeners added to text inputs - clears input when focussed

        quantityInp.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearText(evt);
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        heightInp.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearText(evt);
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        widthInp.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearText(evt);
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        lengthInp.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearText(evt);
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        
        //Listeners to make sure Only one of these items is checked at a time
        noColourButton.addActionListener(this::colourSelected);
        oneColourButton.addActionListener(this::colourSelected);
        twoColourButton.addActionListener(this::colourSelected);
        
        currTotalCost.setText("Total: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(widthInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lengthInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heightInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradeInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noColourButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oneColourButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoColourButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sealableTop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            )
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(addItemButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonAdd)
                                            .addComponent(jButtonSubmit))
                                        .addGap(108, 108, 108)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonReset)
                                            .addComponent(jButtonExit))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottomReinforcement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cornerReinforcement)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currTotalCost)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(widthInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lengthInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(heightInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gradeInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(noColourButton)
                    .addComponent(oneColourButton)
                    .addComponent(twoColourButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bottomReinforcement)
                    .addComponent(cornerReinforcement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                .addComponent(sealableTop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(quantityInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItemButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currTotalCost)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExit)
                    .addComponent(jButtonSubmit))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        objArr = new ArrayList<>();
         
       
         pack();
    }
    
    //toggles selected items so that only the most recently selected is active
    private void colourSelected(java.awt.event.ActionEvent e){
        if (e.getSource() == noColourButton){
            oneColourButton.setSelected(false);
            twoColourButton.setSelected(false);
        }else if (e.getSource() == oneColourButton){
            noColourButton.setSelected(false);
            twoColourButton.setSelected(false);
        }else{
            noColourButton.setSelected(false);
            oneColourButton.setSelected(false);
        }
        
    }
    
    //Determines waht options the suer has based on grade of cardboard
    private void gradeSelected(java.awt.event.ActionEvent e){
        {
        JComboBox cb = (JComboBox)e.getSource();
        int gradeIndex = cb.getSelectedIndex();
        switch (gradeIndex){
            case 0: //grade 1
                bottomReinforcement.setEnabled(false);
                cornerReinforcement.setEnabled(false);
                oneColourButton.setEnabled(false);
                twoColourButton.setEnabled(false);
                noColourButton.setSelected(true);
                break;
            case 1: //grade 2
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(false);
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                break;
            case 2: //grade 3
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(true);
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                noColourButton.setSelected(true);
                break;
            case 3: //grade 4
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(true);
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                noColourButton.setSelected(true);
                break;
            case 4: //grade 5
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(true);
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                noColourButton.setSelected(true);
                break;
            default:
                bottomReinforcement.setEnabled(false);
                cornerReinforcement.setEnabled(false);
                oneColourButton.setEnabled(false);
                twoColourButton.setEnabled(false);
                noColourButton.setSelected(true);        }
        }
    }
    
    //method for clearing the text fields
    private void clearText(java.awt.event.FocusEvent e){
        JTextField textField = (JTextField)e.getSource(); 
        textField.setText("");
        
    }
    private void buttonHandler(java.awt.event.ActionEvent event) {                               
        // TODO add your handling code here:
        String[] testValues = {heightInp.getText(), widthInp.getText(), lengthInp.getText(), quantityInp.getText()};
        
    
        if(event.getSource() == addItemButton)
            {
                int loopInt = 0;
                try
                {
                    do{
                        Integer.parseInt(testValues[loopInt]);
                        loopInt++;
                    }while(loopInt < testValues.length);
                }
                catch(NumberFormatException e)
                {
                    String errorString = "";
                    switch(loopInt){
                        case 0:
                            errorString = "Enter a valid number into height Input"; 
                            break;
                        case 1:
                            errorString = "Enter a valid number into width Input";
                            break;
                        case 2:
                            errorString = "Enter a valid number into lenght Input";
                            break;
                        case 3:
                            errorString = "Enter a valid number into quantity Input";
                            break;
                        default:
                            break;
                    }                  
                    JOptionPane.showMessageDialog(null, errorString);
                }
                
                if(Integer.parseInt(quantityInp.getText()) >= 50 && Integer.parseInt(quantityInp.getText())<= 5000)
                {
                    quantityTemp = Integer.parseInt(quantityInp.getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Minimum orders are of 50 boxes, maximum of 5000.");
                }
                loopInt = 0;
                do{
                    if(getValidSize(Integer.parseInt(testValues[loopInt])) == true)
                {
                    switch(loopInt){
                        case 0:
                            widthTemp = Integer.parseInt(testValues[loopInt]);;
                            break;
                        case 1:
                            lengthTemp = Integer.parseInt(testValues[loopInt]);
                            break;
                        case 2:
                            heightTemp = Integer.parseInt(testValues[loopInt]);
                            break;
                        default:
                            break;
                    
                    }
                }
                else
                {
                    String err = "";
                    switch(loopInt){
                        case 1:
                            err = "Enter a valid number between 100 and 5000 into width Input";
                            break;
                        case 2:
                            err = "Enter a valid number between 100 and 5000 into lenght Input";
                            break;
                        case 3:
                            err = "Enter a valid number between 100 and 5000 into height Input";
                            break;
                        default:
                            break;
                    }                 
                    JOptionPane.showMessageDialog(null, err);
                }
                loopInt++;
                }while(loopInt < testValues.length - 1);
                
                if(noColourButton.isSelected()){
                
                    colourTemp = 0;
                }else if(oneColourButton.isSelected()){
                    colourTemp = 1;
                }
                else if(twoColourButton.isSelected()){
                    colourTemp = 2;
                }
                
                if(bottomReinforcement.isSelected()){
                    bottomTemp = true;
                }
                if(cornerReinforcement.isSelected()){
                    cornerTemp = true;
                }
                if(sealableTop.isSelected()){
                    sealableTemp = true;
                }
                
                //No longer need to error check grade temp as will aslways be valid
                gradeTemp = Integer.parseInt(cardboardGrades[gradeInp.getSelectedIndex()]);
                
                int typeTemp = getValidType(gradeTemp, colourTemp, 
                        bottomTemp, cornerTemp);
                
                switch (typeTemp)
                {
                    case 1:
                        TypeI box = new TypeI(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp);
                        objArr.add(box);
                        totalCostStringUpdate();
                        break;
                    case 2:
                        TypeII box2 = new TypeII(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp);
                        objArr.add(box2);
                        totalCostStringUpdate();
                        break;
                    case 3:
                        TypeIII box3 = new TypeIII(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp);
                        objArr.add(box3);
                        totalCostStringUpdate();
                        break;
                    case 4:
                        TypeIV box4 = new TypeIV(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp);
                        objArr.add(box4);
                        totalCostStringUpdate();
                        break;
                    case 5:
                        TypeV box5 = new TypeV(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp);
                            objArr.add(box5);
                        totalCostStringUpdate();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Flexbox does not produce a box to these specifications");
                        break;
                }
                    
            }
        
    }                              

    
    
    //add methods for doing stuff
    public int getValidType(int cardboardGradeInp, int colourPrintInp, 
                    boolean reinforcedBottomInp, boolean reinforcedCornersInp)
    {
        if((cardboardGradeInp > 0 && cardboardGradeInp < 4) && 
            colourPrintInp == 0 && reinforcedBottomInp == false && 
            reinforcedCornersInp == false)
        {
            return 1;
        }
        else if((cardboardGradeInp > 1 && cardboardGradeInp < 5) && 
                colourPrintInp == 1 && reinforcedBottomInp == false && 
                reinforcedCornersInp == false)
        {
            return 2;
        }
        else if((cardboardGradeInp > 1 && cardboardGradeInp < 6) && 
                colourPrintInp == 2 && reinforcedBottomInp == false && 
                reinforcedCornersInp == false)
        {
            return 3;
        }
        else if((cardboardGradeInp > 1 && cardboardGradeInp < 6) && 
                colourPrintInp == 2 && reinforcedCornersInp == false)
        {
            return 4;
        }
        else if((cardboardGradeInp > 2 && cardboardGradeInp < 6) && 
                colourPrintInp == 2)
        {
            return 5;
        }
        else
        {
            return 0;
        }
    }
        
    public boolean getValidSize(int sizeInp)
    {
        if(sizeInp >= 100 && sizeInp <= 2000)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public double getTotalCost(ArrayList list)
    {
        double totalCost = 0;
        for(int i = 0; i < list.size(); i++)
        {
            Object obj = list.get(i);
            
            if(obj instanceof TypeI)
            {
                TypeI box = (TypeI) obj;
                totalCost += box.getBoxCost();
            }
            else if(obj instanceof TypeII)
            {
                TypeII box = (TypeII) obj;
                totalCost += box.getBoxCost();
            }
            else if(obj instanceof TypeIII)
            {
                TypeIII box = (TypeIII) obj;
                totalCost += box.getBoxCost();
            }
            else if(obj instanceof TypeIV)
            {
                TypeIV box = (TypeIV) obj;
                totalCost += box.getBoxCost();
            }
            else if(obj instanceof TypeV)
            {
                TypeV box = (TypeV) obj;
                totalCost += box.getBoxCost();
            }
        }
        return totalCost;
    }
    
    public void totalCostStringUpdate()
    {
        currTotalCost.setText("Current total cost: £" + df.format(getTotalCost(objArr)));
    }
}
