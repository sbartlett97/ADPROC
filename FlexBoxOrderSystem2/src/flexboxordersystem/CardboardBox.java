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
    protected double cost;
    
    // modifier methods
    public void setBoxHeight(int heightIn)
    {
        boxHeight = heightIn;
    }
    
    public void setBoxWidth(int widthIn)
    {
        boxWidth = widthIn;
    }
    
    public void setBoxLength(int lengthIn)
    {
        boxLength = lengthIn;
    }
    
    public void setBoxQuantity(int quantityIn)
    {
        boxQuantity = quantityIn;
    }
    
    public void setCardboardGrade(int cardboardGradeIn)
    {
        cardboardGrade = cardboardGradeIn;
    }
    
    public void setColourPrint(int colourPrintIn)
    {
        colourPrint = colourPrintIn;
    }
    
    public void setReinforcedBottom(boolean reinforcedBottomIn)
    {
        reinforcedBottom = reinforcedBottomIn;
    }
    
    public void setReinforcedCorners(boolean reinforcedCornersIn)
    {
        reinforcedCorners = reinforcedCornersIn;
    }
    
    public void setSealableTop(boolean sealableTopIn)
    {
        sealableTop = sealableTopIn;
    }
    
    // access methods
    public int getBoxHeight()
    {
        return boxHeight;
    }
    
    public int getBoxWidth()
    {
        return boxWidth;
    }
    
    public int getBoxLength()
    {
        return boxLength;
    }
    
    public int getBoxQuantity()
    {
        return boxQuantity;
    }
    
    public int getBoxSurfaceArea()
    {
        return boxSurfaceArea;
    }
    
    public int getCardboardGrade()
    {
        return cardboardGrade;
    }
    
    public int getColourPrint()
    {
        return colourPrint;
    }
    
    public boolean getReinforcedBottom()
    {
        return reinforcedBottom;
    }
    
    public boolean getReinforcedCorners()
    {
        return reinforcedCorners;
    }
    
    public boolean getSealableTop()
    {
        return sealableTop;
    }
    
    public double getBoxCost()
    {
        return cost;
    }
    
    // calculates the outside surface area of the box in millimeters
    public int calcSurfaceArea(int height, int width, int length)
    {
        return 2 * (height * width) + 2 * (height * length) + 
               2 * (width * length);
    }
}
