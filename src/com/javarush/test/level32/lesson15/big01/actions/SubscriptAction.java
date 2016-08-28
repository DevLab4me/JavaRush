package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by Artem on 07.06.2016.
 */

public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editorPane = getEditor(e);
        if(editorPane != null){
            MutableAttributeSet attributeSet = getStyledEditorKit(editorPane).getInputAttributes();
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setSubscript(set, !StyleConstants.isSubscript(attributeSet));
            setCharacterAttributes(editorPane, set, false);
        }
    }
}
