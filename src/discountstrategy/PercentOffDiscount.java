/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class PercentOffDiscount implements Discount {

    private double percentOff;
    
    public PercentOffDiscount(double percentOff) {
        this.percentOff = percentOff;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        return unitPrice * qty * (percentOff / 100.0);
    }
    
}
