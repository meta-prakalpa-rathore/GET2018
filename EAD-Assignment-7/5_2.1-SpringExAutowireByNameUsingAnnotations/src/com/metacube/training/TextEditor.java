package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Prakalpa-Rathore
 */
public class TextEditor {

    @Autowired
    private SpellChecker spellChecker;

    /**
     * @return the spellChecker
     */
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    
    
    /**
     * @param spellChecker the spellChecker to set
     */
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }


    /**
     * method to show whether spellChecker is on or of
     */
    public void showStatus(){
     
        System.out.print("Spell checker is ");
        
        if(spellChecker.isStatus())
            System.out.println("on");
        else
            System.out.println("off");
    }
    
}
