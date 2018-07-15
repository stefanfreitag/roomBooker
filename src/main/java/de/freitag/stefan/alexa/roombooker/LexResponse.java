package de.freitag.stefan.alexa.roombooker;

import lombok.Getter;

@Getter
public class LexResponse {

    private DialogAction dialogAction;

    LexResponse(final DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

}
