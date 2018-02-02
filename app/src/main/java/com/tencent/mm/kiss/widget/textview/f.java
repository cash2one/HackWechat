package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class f {
    public Alignment gTC;
    public TruncateAt gTD;
    public boolean gTL = true;
    CharSequence gTM;
    public TextPaint gTN;
    public StaticLayout gTO;
    public int gravity;
    public int maxLength;
    public int maxLines;
    CharSequence text;

    public f(StaticLayout staticLayout) {
        this.gTO = staticLayout;
    }
}
