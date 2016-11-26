package jhu.edu.WebStore.Helpers;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.TextField;


//taken from:
//http://ramontalaverasuarez.blogspot.com/2014/06/vaadin-7-detect-enter-key-in-textfield.html

public abstract class OnEnterKeyHandler {

    final ShortcutListener enterShortCut = new ShortcutListener(
            "EnterOnTextAreaShorcut", ShortcutAction.KeyCode.ENTER, null) {
        @Override
        public void handleAction(Object sender, Object target) {
            onEnterKeyPressed();
        }
    };

    public void installOn(final TextField component)
    {
        component.addFocusListener(
                new FieldEvents.FocusListener() {

                    @Override
                    public void focus(FieldEvents.FocusEvent event
                    ) {
                        component.addShortcutListener(enterShortCut);
                    }

                }
        );

        component.addBlurListener(
                new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event
                    ) {
                        component.removeShortcutListener(enterShortCut);
                    }

                }
        );
    }

    public abstract void onEnterKeyPressed();

}
