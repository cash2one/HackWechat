package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.g.a;

@SuppressLint({"AppCompatCustomView"})
public class f extends TextView implements e {
    public a jUP;
    private boolean jUs;

    public f(Context context) {
        super(context);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new Factory(this) {
            final /* synthetic */ f jUQ;

            {
                this.jUQ = r1;
            }

            public final Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(this.jUQ.jUP == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(this.jUQ.jUP, 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        });
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (bufferType == BufferType.NORMAL) {
            bufferType = BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
    }

    public final boolean afO() {
        return this.jUs;
    }
}
