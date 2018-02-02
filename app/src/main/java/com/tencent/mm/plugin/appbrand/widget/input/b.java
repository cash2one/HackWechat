package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.b.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.g;
import com.tencent.mm.plugin.appbrand.widget.input.b.g.1;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

enum b {
    ;

    static <Input extends EditText & z> void a(Input input, h hVar) {
        if (input != null && hVar != null) {
            int i;
            if (!(hVar.kbR == null || hVar.kbR.floatValue() == input.getTextSize())) {
                input.setTextSize(hVar.kbR.floatValue());
            }
            if (hVar.kbQ != null) {
                input.setTextColor(hVar.kbQ.intValue());
            }
            if (hVar.kbP == null) {
                input.setBackground(null);
            } else if (!(input.getBackground() != null && (input.getBackground() instanceof ColorDrawable) && ((ColorDrawable) input.getBackground()).getColor() == hVar.kbP.intValue())) {
                input.setBackground(new ColorDrawable(hVar.kbP.intValue()));
            }
            if (!bh.ov(hVar.kbU)) {
                CharSequence spannableStringBuilder = new SpannableStringBuilder(hVar.kbU);
                int length = hVar.kbU.length();
                spannableStringBuilder.setSpan(new StyleSpan(c.va(hVar.kbV).style), 0, length, 18);
                if (hVar.kbX != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(hVar.kbX.intValue()), 0, length, 18);
                }
                if (hVar.kbW != null) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(hVar.kbW.intValue(), false), 0, length, 18);
                }
                input.setHint(spannableStringBuilder);
            }
            if (hVar.kbS != null) {
                Typeface create = Typeface.create("sans-serif", c.va(hVar.kbS).style);
                if (create != null) {
                    input.setTypeface(create);
                }
            }
            g vb = g.vb(hVar.kbO);
            z zVar = (z) input;
            if (zVar != null) {
                switch (1.kco[vb.ordinal()]) {
                    case 1:
                        zVar.anc();
                        break;
                    case 2:
                        zVar.and();
                        break;
                    case 3:
                        zVar.ane();
                        break;
                }
            }
            if (af.e(hVar.kbZ)) {
                i = 8;
            } else {
                i = 0;
            }
            input.setVisibility(i);
            ((z) input).dy(af.e(hVar.kcd));
        }
    }

    static <Input extends EditText & z> void a(Input input, int i, int i2) {
        if (input == null || input.getEditableText() == null) {
            x.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[]{input});
            return;
        }
        int selectionStart;
        if (i <= -2) {
            selectionStart = input.getSelectionStart();
        } else if (i == -1 || i > input.getText().length()) {
            selectionStart = input.getText().length();
        } else {
            selectionStart = i;
        }
        int selectionEnd = i2 <= -2 ? input.getSelectionEnd() : (i2 == -1 || i2 > input.getText().length()) ? input.getText().length() : i2;
        if (selectionStart > selectionEnd) {
            selectionStart = selectionEnd;
        }
        Selection.removeSelection(input.getEditableText());
        input.setSelection(selectionStart, selectionEnd);
    }
}
