package de.freitag.stefan.alexa.roombooker;

import lombok.Data;

@Data
class LexResponse {

    private DialogAction dialogAction;

    LexResponse(final DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

}
