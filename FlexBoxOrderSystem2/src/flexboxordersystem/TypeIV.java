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
public class TypeIV extends CardboardBox
{   
    /**
     * Default constructor used for instantiation - takes no arguments,
     */
    public TypeIV()
    {
        
    }
    /**
     * Constructor for a box of type IV as determined by the UI Class
     * @param heightIn the height of the box to be created
     * @param widthIn   the width of the box to be created
     * @param lengthIn  the length of the box to be created
     * @param quantityIn the quantity of boxes ordered
     * @param cardboardGradeIn the grade of cardboard for the box
     * @param colourPrintIn the colour printing value for the box
     * @param reinforcedBottomIn value for the reinforced bottom variable of the box
     * @param sealableTopIn value for whether or not the boxes can be sealed
     * @param reinforcedCornersIn value for the reinforced corners variable for the box
     * @param gradeMultiplierIn value for cost multiplier
     */
    public TypeIV(int heightIn, int widthIn, int lengthIn, int quantityIn, 
                        int cardboardGradeIn, int colourPrintIn, 
                        boolean reinforcedBottomIn, boolean reinforcedCornersIn, 
                        boolean sealableTopIn, double gradeMultiplierIn)
    {
        gradeMultiplier = gradeMultiplierIn;
        boxHeight = heightIn;
        boxWidth = widthIn;
        boxLength = lengthIn;
        boxQuantity = quantityIn;
        boxSurfaceArea = calcSurfaceArea(heightIn, widthIn, lengthIn);
        cardboardGrade = cardboardGradeIn;
        colourPrint = colourPrintIn;
        reinforcedBottom = reinforcedBottomIn;
        reinforcedCorners = reinforcedCornersIn;
        sealableTop = sealableTopIn;
        baseCost = boxSurfaceArea * gradeMultiplier;
        cost = calcCost(boxQuantity, baseCost, 
                        colourPrint, reinforcedBottom, reinforcedCorners, 
                        sealableTop);
    }
    
    /**
     * Method inherited from super class for calculating the cost of the box
     * @param quantity quantity of boxes ordered    
     * @param baseCost calculated value using the surface area of the box and a multiplier provided by manufacturer
     * @param colourPrint the colour print value of the box    
     * @param reinforcedBottom reinforced bottom value for the box    
     * @param reinforcedCorners reinforced corner value for the box    
     * @param sealableTop boolean value for whether or not the top of the boxes can be sealed      
     * @return      
     */
    @Override
        public double calcCost(int quantity, double baseCost, int colourPrint, boolean reinforcedBottom, boolean reinforcedCorners, boolean sealableTop){
        double cost = super.calcCost(quantity, baseCost, colourPrint, reinforcedBottom, reinforcedCorners, sealableTop);
            return cost / 1000;
    }
}
