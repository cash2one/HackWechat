package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class FtsWebDotPercentIndicator extends LinearLayout {
    private LayoutInflater DF;
    private int jrQ;

    public FtsWebDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FtsWebDotPercentIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.DF = LayoutInflater.from(context);
    }

    public final void bQj() {
        this.jrQ = 8;
        removeAllViews();
        for (int i = 0; i < this.jrQ; i++) {
            addView((ImageView) this.DF.inflate(R.i.djk, this, false));
        }
    }

    public final void X(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (f >= 0.0f) {
            f3 = f;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        x.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[]{Float.valueOf(f2), Integer.valueOf((int) Math.rint((double) (((float) this.jrQ) * f2)))});
        int i = 0;
        while (i < r3 && i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.g.bCz);
            i++;
        }
        while (i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.g.bCy);
            i++;
        }
    }
}
