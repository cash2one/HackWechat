package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMProgressBar extends LinearLayout {
    private int max = 100;
    private ak oVT = new ak(new 1(this), false);
    private TextView quS;
    private int yck = 0;
    private int ycl = 0;
    private TextView ycm;
    public a ycn;

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        TextView textView = mMProgressBar.ycm;
        int width = (mMProgressBar.getWidth() * mMProgressBar.yck) / mMProgressBar.max;
        if (width < b.b(mMProgressBar.getContext(), 20.0f)) {
            width = b.b(mMProgressBar.getContext(), 20.0f);
        }
        textView.setWidth(width);
        if (mMProgressBar.ycn != null) {
            mMProgressBar.ycn.yq(i);
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), h.gXU, this);
        this.ycm = (TextView) findViewById(g.gVP);
        this.quS = (TextView) findViewById(g.gVQ);
    }

    public final void setProgress(int i) {
        if (i > this.max) {
            i = this.max;
        }
        this.ycl = i;
        if (this.oVT.cfK()) {
            ml(true);
        }
    }

    public final void ml(boolean z) {
        if (z) {
            this.oVT.J(40, 40);
        } else {
            this.oVT.TG();
        }
    }
}
