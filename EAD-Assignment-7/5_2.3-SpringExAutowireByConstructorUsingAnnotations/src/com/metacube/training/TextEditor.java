package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Prakalpa-Rathore
 *
 */
public class TextEditor {

    private SpellChecker spellChecker;


    /**
     * @param spellChecker
     */
    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        
        this.spellChecker = spellChecker;
    }


    /**
     * @return the spellChecker
     */
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    
    
    public void showStatus(){
     
        System.out.print("Spell checker is ");
        
        if(spellChecker.isStatus())
            System.out.println("on");
        else
            System.out.println("off");
    }
    
}
