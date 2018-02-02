package com.tencent.mm.bx;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;

public final class g implements d {
    private static g xlk;
    private int xlj = 300;

    private g() {
    }

    public static g chg() {
        if (xlk == null) {
            xlk = new g();
        }
        return xlk;
    }

    public final SpannableString b(Context context, CharSequence charSequence, int i) {
        if (charSequence == null || bh.ov(charSequence.toString())) {
            return new SpannableString("");
        }
        if (charSequence == null || bh.ov(charSequence.toString())) {
            return new SpannableString("");
        }
        charSequence = charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
        PInt pInt = new PInt();
        pInt.value = this.xlj;
        return f.chd().a(b.cgX().a(charSequence, i, pInt), i, pInt.value);
    }

    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        if (charSequence == null || bh.ov(charSequence.toString())) {
            return new SpannableString("");
        }
        return b(context, charSequence, (int) f);
    }

    public final boolean x(CharSequence charSequence) {
        return f.chd().Wk(charSequence.toString()) != null;
    }

    public final boolean w(CharSequence charSequence) {
        b.cgX();
        return b.Wi(charSequence.toString());
    }
}
