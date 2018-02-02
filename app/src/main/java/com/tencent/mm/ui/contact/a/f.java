package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;

public final class f extends a {
    private CharSequence qef;
    private b yVs = new b(this);
    a yVt = new a(this);

    public f(int i) {
        super(5, i);
    }

    public final void bH(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.mMb.mLC) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(d.a.mOB), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.qef = TextUtils.concat(new CharSequence[]{context.getString(h.qfL), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(h.qfL)});
    }

    public final b WQ() {
        return this.yVs;
    }

    protected final a WR() {
        return this.yVt;
    }
}
