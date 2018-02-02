package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.bx.f;
import com.tencent.mm.bx.g;
import com.tencent.mm.pluginsdk.ui.d.i;

public final class a implements com.tencent.mm.plugin.emoji.b.a {
    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        return g.chg().a(context, charSequence, f);
    }

    public final SpannableString b(Context context, CharSequence charSequence, float f) {
        return i.b(context, charSequence, f);
    }

    public final String ce(String str, String str2) {
        g.chg();
        return f.chd().fz(str, str2);
    }

    public final boolean w(CharSequence charSequence) {
        return g.chg().w(charSequence);
    }

    public final boolean x(CharSequence charSequence) {
        return g.chg().x(charSequence);
    }
}
