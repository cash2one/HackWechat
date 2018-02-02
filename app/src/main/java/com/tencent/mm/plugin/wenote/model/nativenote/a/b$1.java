package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.CharacterStyle;
import java.util.Comparator;

class b$1 implements Comparator<CharacterStyle> {
    final /* synthetic */ Spanned tSm;

    b$1(Spanned spanned) {
        this.tSm = spanned;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        CharacterStyle characterStyle = (CharacterStyle) obj;
        CharacterStyle characterStyle2 = (CharacterStyle) obj2;
        int spanStart = this.tSm.getSpanStart(characterStyle);
        int spanStart2 = this.tSm.getSpanStart(characterStyle2);
        if (spanStart != spanStart2) {
            return spanStart - spanStart2;
        }
        spanStart = this.tSm.getSpanEnd(characterStyle);
        spanStart2 = this.tSm.getSpanEnd(characterStyle2);
        return spanStart != spanStart2 ? spanStart2 - spanStart : characterStyle.getClass().getName().compareTo(characterStyle2.getClass().getName());
    }
}
