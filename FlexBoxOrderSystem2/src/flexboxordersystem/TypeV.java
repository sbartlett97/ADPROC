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
public class TypeV extends CardboardBox
{
    // constructor - default
    public TypeV()
    {
        
    }
    
    // constructor including initialisation of instance variables
    public TypeV(int heightIn, int widthIn, int lengthIn, int quantityIn, 
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
        cost = calcCost(boxQuantity, boxSurfaceArea, cardboardGrade, 
                        colourPrint, reinforcedBottom, reinforcedCorners, 
                        sealableTop);
    }
    
    // calculates and returns cost based on params
    // ** note that currCost is initialised with 0 as if the switch statement
    // doesnt execute properly then currCost will not be given a value **
    public double calcCost(int quantity, int surfaceArea, int cardboardGrade, 
                          int colourPrint, boolean reinforcedBottom, 
                          boolean reinforcedCorners, boolean sealableTop)
    {
        double currCost = 0;
        double surfArea = (double) surfaceArea;
        
        switch(cardboardGrade)
        {
            case 1: currCost = surfArea * 0.00055;
                    break;
            case 2: currCost = surfArea * 0.00065;
                    break;
            case 3: currCost = surfArea * 0.00082;
                    break;
            case 4: currCost = surfArea * 0.00098;
                    break;
            case 5: currCost = surfArea * 0.0015;
                    break;
        }
        
        currCost *= quantity;
        
        switch(colourPrint)
        {
            case 1: currCost *= 1.12;
                    break;
            case 2: currCost *= 1.15;
                    break;
        }
        
        if(reinforcedBottom == true)
        {
            currCost *= 1.13;
        }
        
        if(reinforcedCorners == true)
        {
            currCost *= 1.12;
        }
        
        if(sealableTop == true)
        {
            currCost *= 1.1;
        }
        
        return currCost / 1000;
    }
}
