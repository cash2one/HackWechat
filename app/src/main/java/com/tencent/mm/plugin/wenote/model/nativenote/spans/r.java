package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public final class r implements ParagraphStyle {
    public final q tVx;
    public final ParagraphStyle tWe;

    public r(q qVar, ParagraphStyle paragraphStyle) {
        this.tVx = qVar;
        this.tWe = paragraphStyle;
    }

    public final String toString() {
        return this.tVx.name() + " - " + this.tWe.getClass().getSimpleName();
    }
}
