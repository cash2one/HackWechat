package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.h;

final class n$b extends h {
    private final int jXV;
    private final int jXW;
    final /* synthetic */ n jXX;

    n$b(n nVar, int i, int i2) {
        this.jXX = nVar;
        super(i, i2);
        this.jXV = i;
        this.jXW = i2;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = 0;
        if (h.du(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.jXW) + h.du(charSequence.subSequence(i, i2).toString(), this.jXW) > this.jXV) {
            i5 = 1;
        }
        if (i5 != 0) {
            charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.jXV - (spanned.length() - (i4 - i3)), i2)));
        }
        if (i5 != 0 && bh.M(charSequence)) {
            EditText editText = this.jXX.znN == null ? null : (EditText) this.jXX.znN.get();
            a aVar = this.jXX.znR;
            if (!(editText == null || aVar == null)) {
                editText.post(new 1(this, aVar));
            }
        }
        return charSequence;
    }
}
