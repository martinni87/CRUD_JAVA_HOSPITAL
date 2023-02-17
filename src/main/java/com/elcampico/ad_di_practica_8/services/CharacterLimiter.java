package com.elcampico.ad_di_practica_8.services;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CharacterLimiter extends PlainDocument{
    
    private int limit;
    
    public CharacterLimiter(int limit) {
       super();
       this.limit = limit;
    }
    
    public CharacterLimiter(int limit, boolean upper) {
       super();
       this.limit = limit;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
       if (str == null)
          return;
       if ((getLength() + str.length()) <= limit) {
          super.insertString(offset, str, attr);
       }
    }
}