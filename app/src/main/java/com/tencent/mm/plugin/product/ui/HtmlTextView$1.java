package com.tencent.mm.plugin.product.ui;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.ag.a;

class HtmlTextView$1 implements a {
    private volatile Spanned pfb;
    final /* synthetic */ String pfc;
    final /* synthetic */ HtmlTextView pfd;

    HtmlTextView$1(HtmlTextView htmlTextView, String str) {
        this.pfd = htmlTextView;
        this.pfc = str;
    }

    public final boolean JB() {
        this.pfb = HtmlTextView.a(this.pfd, this.pfc);
        return true;
    }

    public final boolean JC() {
        HtmlTextView.a(this.pfd, this.pfb, BufferType.SPANNABLE);
        this.pfd.setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    public final String toString() {
        return super.toString() + "|setText";
    }
}
