/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texteditorconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author george
 */
public class TextEditorConfig {

    @Bean
    public TextEditor textEditor() {
        return new TextEditor(spellChecker());
    }

    @Bean
    @Scope("prototype")
    public SpellChecker spellChecker() {
        return new SpellChecker();
    }

}
