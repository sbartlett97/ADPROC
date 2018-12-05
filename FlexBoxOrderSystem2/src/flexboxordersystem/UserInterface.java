/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexboxordersystem;

/**
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class UserInterface extends JFrame
{
    private final JLabel currTotalCost;
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
    
    //temp stores for variables used in creation of classes
    private int heightTemp, widthTemp, lengthTemp, quantityTemp, gradeTemp, 
                colourTemp;
    private boolean bottomTemp, cornerTemp, sealableTemp = false;
    private final ArrayList<CardboardBox> objArr;
    private final ArrayList<JTextField> textFields = new ArrayList<>();

    
    
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
    private double[] gradeMultiplyers = {0.00055, 0.00065, 0.0082, 0.00098, 0.0015};

    // End of variables declaration   
   
    /**
     *User interface constructor class - adds items to JFrame
     */
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
        jLabel10 = new javax.swing.JLabel();
        quantityInp = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        sealableTop = new javax.swing.JCheckBox();
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
        
        //Shorthand for adding an action listener to the buttons
        jButtonAdd.addActionListener(this::addToOrder);
        jButtonExit.addActionListener(this::closeWindow);
        jButtonReset.addActionListener(this::resetOrder);
        /*  Add a lsitener to the grade combobox so that when a grade is selected,
            Only valid options for the other inputs are avaialble */
        gradeInp.addActionListener(this::gradeSelected);
        gradeInp.setSelectedIndex(0);
       
        
        //Focus listeners added to text inputs - clears input when focussed
        initilaiseItemsForFOucsListeners();

        textFields.forEach((item) -> addFocusListener(item));

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
                                        )
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
                    )
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
    
    /**
     * Method for toggling the colour options on the user interface.
     * Handles an action event from the clicked radio button and performs checks
     * to make sure there is always a single item selected.
     */
    private void colourSelected(java.awt.event.ActionEvent e){
        if (e.getSource() == noColourButton){
            if(oneColourButton.isSelected() == false && twoColourButton.isSelected() == false ){
                noColourButton.setSelected(true);
            }
            oneColourButton.setSelected(false);
            twoColourButton.setSelected(false);
        }else if (e.getSource() == oneColourButton){
            if(noColourButton.isSelected() == false && twoColourButton.isSelected() == false ){
                oneColourButton.setSelected(true);
            }
            noColourButton.setSelected(false);
            twoColourButton.setSelected(false);
        }else{
            if(oneColourButton.isSelected() == false && noColourButton.isSelected() == false ){
                twoColourButton.setSelected(true);
            }
            noColourButton.setSelected(false);
            oneColourButton.setSelected(false);
        } 
        checkReinforcementOptions();
    }
    private void checkReinforcementOptions(){
        int currentGrade = Integer.parseInt(cardboardGrades[gradeInp.getSelectedIndex()]);
        if(currentGrade == 1){
            cornerReinforcement.setEnabled(false);
            bottomReinforcement.setEnabled(false);
        }else if(currentGrade == 2){
            if(noColourButton.isSelected() || oneColourButton.isSelected()){
                cornerReinforcement.setEnabled(false);
                bottomReinforcement.setEnabled(false);
            }else{
                bottomReinforcement.setEnabled(true);
            }
        }else if(currentGrade == 3){
            if(noColourButton.isSelected() || oneColourButton.isSelected()){
                cornerReinforcement.setEnabled(false);
                bottomReinforcement.setEnabled(false);
            }else{
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(true);
            }
        }else if (currentGrade == 4){
            if(oneColourButton.isSelected()){
                cornerReinforcement.setEnabled(false);
                bottomReinforcement.setEnabled(false);
            }else{
                bottomReinforcement.setEnabled(true);
                cornerReinforcement.setEnabled(true);
            }
        }else if (currentGrade == 5){
            bottomReinforcement.setEnabled(true);
            cornerReinforcement.setEnabled(true);
        }
    }
    /**
     * Determines what options are available to the user based on what cardboard grade they have selected. 
     * Handles an action event from the grade combo box and activates/deactivates items 
     * based on whether or not that grade of cardboard is allowed them. 
     */
    private void gradeSelected(java.awt.event.ActionEvent e){
        {
        JComboBox cb = (JComboBox)e.getSource();
        int gradeIndex = cb.getSelectedIndex();
        switch (gradeIndex){
            case 0: //grade 1
                oneColourButton.setEnabled(false);
                twoColourButton.setEnabled(false);
                noColourButton.setSelected(true);
                break;
            case 1: //grade 2
                noColourButton.setEnabled(true);
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                break;
            case 2: //grade 3
                oneColourButton.setEnabled(true);
                twoColourButton.setEnabled(true);
                noColourButton.setEnabled(true);
                break;
            case 3: //grade 4
                oneColourButton.setEnabled(true);
                noColourButton.setSelected(false);
                oneColourButton.setSelected(true);
                twoColourButton.setSelected(false);
                twoColourButton.setEnabled(true);
                noColourButton.setEnabled(false);
                break;
            case 4: //grade 5
                oneColourButton.setEnabled(false);
                twoColourButton.setEnabled(true);
                twoColourButton.setSelected(true);
                noColourButton.setEnabled(false);
                noColourButton.setSelected(false);
                oneColourButton.setSelected(false);
                break;
            default:
                bottomReinforcement.setEnabled(false);
                cornerReinforcement.setEnabled(false);
                oneColourButton.setEnabled(false);
                twoColourButton.setEnabled(false);
                noColourButton.setSelected(true);        
        }
        }
        checkReinforcementOptions();

    }
    
    /**
     * Method that clears the text inputs when they are focused.
     */
    private void clearText(java.awt.event.FocusEvent e){
        JTextField textField = (JTextField)e.getSource(); 
        textField.setText("");
        
    }
    /**
     * Method for closing the window when the Exit button is pressed. 
     */
    private void closeWindow(java.awt.event.ActionEvent e){
        System.exit(0);
    }
    
    /**
     * Method for reseting the entire order and clears the text fields.
     * 
     */
    private void resetOrder(java.awt.event.ActionEvent e){
        objArr.clear();
        totalCostStringUpdate();
        textFields.forEach((item) -> item.setText("          "));
    }
    /**
     * Method for adding items to the order when the Add button is pressed.
     * Performs all necessary checks on the user inputs to ensure that valid 
     * inputs and selections have been made, then adds the item to the order and 
     * updates the total cost etc.
     */
    private void addToOrder(java.awt.event.ActionEvent event) {                               
        // TODO add your handling code here:
        String[] testValues = {heightInp.getText(), widthInp.getText(), lengthInp.getText(), quantityInp.getText()};
        
        if(event.getSource() == jButtonAdd)
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
                
                if(Integer.parseInt(quantityInp.getText()) >= 1 && Integer.parseInt(quantityInp.getText())<= 5000)
                {
                    quantityTemp = Integer.parseInt(quantityInp.getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Minimum orders are of 1 box, maximum of 5000.");
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
                System.out.println(typeTemp);
                switch (typeTemp)
                {
                    case 1:
                        TypeI box = new TypeI(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp, gradeMultiplyers[gradeTemp -1]);
                        objArr.add(box);
                        totalCostStringUpdate();
                        break;
                    case 2:
                        TypeII box2 = new TypeII(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp, gradeMultiplyers[gradeTemp -1]);
                        objArr.add(box2);
                        totalCostStringUpdate();
                        break;
                    case 3:
                        TypeIII box3 = new TypeIII(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp, gradeMultiplyers[gradeTemp -1]);
                        objArr.add(box3);
                        totalCostStringUpdate();
                        break;
                    case 4:
                        TypeIV box4 = new TypeIV(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp, gradeMultiplyers[gradeTemp -1]);
                        objArr.add(box4);
                        totalCostStringUpdate();
                        break;
                    case 5:
                        TypeV box5 = new TypeV(heightTemp, widthTemp, lengthTemp, 
                            quantityTemp, gradeTemp, colourTemp, bottomTemp, 
                            cornerTemp, sealableTemp, gradeMultiplyers[gradeTemp -1]);
                            objArr.add(box5);
                        totalCostStringUpdate();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Flexbox does not produce a box to these specifications");
                        break;
                }
            }
    }                              
    
    /**
     * Method that takes the user inputs and determines the type of box best suited for the order. 
     * @param cardboardGradeInp grade of the cardboard selected
     * @param colourPrintInp colour printing option selected
     * @param reinforcedBottomInp selected value for reinforced bottom
     * @param reinforcedCornersInp selected value for reinforced corners
     * @return returns an integer representing the type of box to be used
     */
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
    /**
     * Method for making sure the user has entered a valid sizes for the box dimensions
     * @param sizeInp value of the current size input being checked
     * @return returns a boolean of whether or not the input is valid
     */
    public boolean getValidSize(int sizeInp)
    {
        if(sizeInp >= 100 && sizeInp <= 5000)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Method used for getting the total cost of the current order
     * @param list array list containing all items in the current order
     * @return returns the calculated cost of all items in the order
     */
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
    
    /**
     * 
     */
    public void totalCostStringUpdate()
    {
            double test = getTotalCost(objArr);
            if (test == 0.0){
                currTotalCost.setText("Current total cost: £0.00");
            }else{
                currTotalCost.setText("Current total cost: £" + df.format(getTotalCost(objArr)));
            }
        
    }
    
    private void initilaiseItemsForFOucsListeners(){
        textFields.add(quantityInp);
        textFields.add(heightInp);
        textFields.add(widthInp);
        textFields.add(lengthInp);
    }
    
    private void addFocusListener(JTextField item){
        item.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearText(evt);
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }
    
}
