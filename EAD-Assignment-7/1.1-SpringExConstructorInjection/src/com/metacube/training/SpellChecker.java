package com.metacube.training;

/**
 * @author Prakalpa-Rathore
 *
 */
public class SpellChecker {

    private boolean status;

    
    /**
     * constructor
     * @param status
     */
    public SpellChecker(boolean status) {
        
        this.status = status;
    }


    /**
     * getter method for status
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }
    
}
