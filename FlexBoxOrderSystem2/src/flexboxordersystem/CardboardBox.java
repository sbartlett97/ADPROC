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
public abstract class CardboardBox
{
    // instance variables
    protected int boxHeight, boxWidth, boxLength, boxQuantity, boxSurfaceArea, 
                  cardboardGrade, colourPrint;
    protected boolean reinforcedBottom, reinforcedCorners, sealableTop;
    protected double cost, baseCost, gradeMultiplyer;
    
    /**
     *sets the height of the created box
     * @param heightIn an integer representing the height of the box in mm
     */
    public void setBoxHeight(int heightIn)
    {
        boxHeight = heightIn;
    }
    /**
    *sets the width of the created box
    * @param widthIn an integer representing the width of the box in mm
    */
    public void setBoxWidth(int widthIn)
    {
        boxWidth = widthIn;
    }
    /**
    *sets the length of the created box
    * @param lengthIn an integer representing the height of the box in mm
    */
    public void setBoxLength(int lengthIn)
    {
        boxLength = lengthIn;
    }
    /**
    *sets the quantity of boxes ordered
    * @param quantityIn an integer representing the quantity of this type of box ordered
    */
    public void setBoxQuantity(int quantityIn)
    {
        boxQuantity = quantityIn;
    }
    
    public void setCardboardGrade(int cardboardGradeIn)
    {
        cardboardGrade = cardboardGradeIn;
    }
    /**
    *sets the colour printing type for the box
    * @param colourPrintIn an integer representing the amount of colours the box will have 
    */
    public void setColourPrint(int colourPrintIn)
    {
        colourPrint = colourPrintIn;
    }
    /**
    *sets whether or not the box has a reinforced bottom
    * @param reinforcedBottomIn boolean for whether or not the bottom of the box is reinforced
    */
    public void setReinforcedBottom(boolean reinforcedBottomIn)
    {
        reinforcedBottom = reinforcedBottomIn;
    }
    /**
    *sets the reinforcedCorners value of the box
    * @param reinforcedCornersIn boolean for whether or not the corners of the box is reinforced
    */
    public void setReinforcedCorners(boolean reinforcedCornersIn)
    {
        reinforcedCorners = reinforcedCornersIn;
    }
    /**
    *sets the sealableTop value of the created box
    * @param sealableTopIn boolean for whether or not the top of the box is can be sealed
    */
    public void setSealableTop(boolean sealableTopIn)
    {
        sealableTop = sealableTopIn;
    }
    
    /**
     * @retrun Returns the height of the box
     */
    public int getBoxHeight()
    {
        return boxHeight;
    }
    /**
     * @return Returns the width of the box
     */
    public int getBoxWidth()
    {
        return boxWidth;
    }
    /**
     * @return Returns the length of the box
     */
    public int getBoxLength()
    {
        return boxLength;
    }
    /**
     * @return Returns the quantity of the boxes ordered
     */
    public int getBoxQuantity()
    {
        return boxQuantity;
    }
    /**
     * @rteturn Returns the surfaceArea of the box
     */
    public int getBoxSurfaceArea()
    {
        return boxSurfaceArea;
    }
    /**
     * @return Returns the grade of the box
     */
    public int getCardboardGrade()
    {
        return cardboardGrade;
    }
    /**
     * @return Returns the colour printing value of the box
     */
    public int getColourPrint()
    {
        return colourPrint;
    }
    /**
     * @return Returns the reinforcedBottom value of the box
     */
    public boolean getReinforcedBottom()
    {
        return reinforcedBottom;
    }
    /**
     * @return Returns the reinforcedCorner value of the box
     */
    public boolean getReinforcedCorners()
    {
        return reinforcedCorners;
    }
    /**
     * @return Returns the sealbaleTop value of the box
     */
    public boolean getSealableTop()
    {
        return sealableTop;
    }
    /**
     * @return Returns the cost of the box
     */
    public double getBoxCost()
    {
        return cost;
    }
    
    /**
     * method for calculating the surface area of the box
     * @param height the height of the box
     * @param width the width of the box
     * @param length the length of the box
     * @return integer value of the boxes surface area
     */
    public int calcSurfaceArea(int height, int width, int length)
    {
        return 2 * (height * width) + 2 * (height * length) + 
               2 * (width * length);
    }
    
        public double calcCost(int quantity, double baseCost, int colourPrint, boolean reinforcedBottom, boolean reinforcedCorners, boolean sealableTop){
        
        double currCost = baseCost;

        currCost *= quantity;
        switch(colourPrint)
        {
            case 1: currCost *= 1.12;
                    break;
            case 2: currCost *= 1.15;
                    break;
        }
        System.out.println(currCost);
        if(reinforcedBottom == true)
        {
            currCost *= 1.13;
        }
        System.out.println(currCost);
        if(reinforcedCorners == true)
        {
            currCost *= 1.12;
        }
        System.out.println(currCost);
        if(sealableTop == true)
        {
            currCost *= 1.1;
        }
        System.out.println(currCost);
        return currCost;
    }
}
