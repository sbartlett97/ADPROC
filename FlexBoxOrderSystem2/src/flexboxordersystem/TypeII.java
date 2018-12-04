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
public class TypeII extends CardboardBox
{
    // constructor - default
    public TypeII()
    {
        
    }
    
    // constructor including initialisation of instance variables
    public TypeII(int heightIn, int widthIn, int lengthIn, int quantityIn, 
                        int cardboardGradeIn, int colourPrintIn, 
                        boolean reinforcedBottomIn, boolean reinforcedCornersIn, 
                        boolean sealableTopIn)
    {
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
        baseCost = boxSurfaceArea * 0.00065;
        cost = calcCost(boxQuantity, baseCost, 
                        colourPrint, reinforcedBottom, reinforcedCorners, 
                        sealableTop);
    }
    
    // calculates and returns cost based on params
    // ** note that currCost is initialised with 0 as if the switch statement
    // doesnt execute properly then currCost will not be given a value **
        public double calcCost(int quantity, double baseCost, int colourPrint, boolean reinforcedBottom, boolean reinforcedCorners, boolean sealableTop){
        double cost = super.calcCost(quantity, baseCost, colourPrint, reinforcedBottom, reinforcedCorners, sealableTop);
            return cost / 1000;
    }
}
