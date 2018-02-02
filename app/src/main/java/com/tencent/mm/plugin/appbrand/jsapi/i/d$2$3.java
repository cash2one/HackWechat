package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.i.d.2;
import com.tencent.mm.plugin.appbrand.widget.g.a;

class d$2$3 extends Factory {
    final /* synthetic */ 2 jqm;
    final /* synthetic */ int jqn;

    d$2$3(2 2, int i) {
        this.jqm = 2;
        this.jqn = i;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        Spannable newSpannable = super.newSpannable(charSequence);
        if (!TextUtils.isEmpty(newSpannable)) {
            newSpannable.setSpan(new a((float) this.jqn), 0, newSpannable.length(), 18);
        }
        return newSpannable;
    }
}
