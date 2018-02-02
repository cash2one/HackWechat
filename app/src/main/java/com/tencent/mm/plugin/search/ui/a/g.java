package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.d;

public final class g extends b {
    CharSequence qef;
    private b qeg = new b(this, (byte) 0);
    a qeh = new a(this, (byte) 0);

    public g(int i) {
        super(17, i);
    }

    public final void a(Context context, a aVar, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.mMb.mLC) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(d.a.mOB), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.qef = TextUtils.concat(new CharSequence[]{context.getString(R.l.eJr), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.l.eJq)});
    }

    public final b.b adp() {
        return this.qeg;
    }

    protected final a adq() {
        return this.qeh;
    }
}
