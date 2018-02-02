package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.sdk.platformtools.x;

public class AppBrandOptionButton extends FrameLayout {
    private int jVT = i.ixV;
    private ObjectAnimator jVU;
    public boolean jVV = true;
    private View jVW;
    private View jVX;
    private TextView jVY;
    ImageButton jVZ;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.jVW = LayoutInflater.from(context).inflate(h.gWV, this, false);
        this.jVX = this.jVW.findViewById(g.divider);
        this.jVY = (TextView) this.jVW.findViewById(g.bIK);
        this.jVY.setMaxLines(1);
        this.jVY.setClickable(false);
        this.jVY.setBackground(null);
        View findViewById = this.jVW.findViewById(g.gVj);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        addView(this.jVW, new LayoutParams(-2, -1, 17));
        this.jVW.setVisibility(8);
        this.jVZ = new ImageButton(context);
        this.jVZ.setClickable(false);
        this.jVZ.setBackground(null);
        addView(this.jVZ, new LayoutParams(getResources().getDimensionPixelSize(e.bys), -1, 17));
        this.jVU = ObjectAnimator.ofFloat(this.jVZ, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        this.jVU.setDuration(2000);
        this.jVU.setInterpolator(new AccelerateInterpolator());
        this.jVU.setRepeatCount(-1);
        this.jVU.setRepeatMode(1);
    }

    public final void setColor(int i) {
        this.jVY.setTextColor(i);
        this.jVX.setBackgroundColor(b.m(i, 77));
        if (this.jVZ.getDrawable() == null || (this.jVZ.getDrawable() instanceof com.tencent.mm.svg.a.b)) {
            this.jVZ.setImageResource(amr());
            this.jVZ.setColorFilter(i, Mode.SRC_ATOP);
        }
    }

    public final void reset() {
        this.jVV = true;
        this.jVW.setVisibility(8);
        this.jVZ.setVisibility(0);
        if (!(this.jVZ.getDrawable() instanceof com.tencent.mm.svg.a.b)) {
            this.jVZ.setImageResource(amr());
        }
    }

    protected int amr() {
        return this.jVT;
    }

    protected final void a(a aVar, int i) {
        x.i("MicroMsg.AppBrandOptionButton", "setImageButtonStatus status %s", new Object[]{aVar});
        switch (3.jCn[aVar.ordinal()]) {
            case 1:
                this.jVT = i.ixR;
                break;
            case 2:
                this.jVT = i.ixS;
                break;
            case 3:
                this.jVT = i.ixT;
                break;
            case 5:
                this.jVT = i.ixU;
                break;
        }
        this.jVV = true;
        this.jVW.setVisibility(8);
        this.jVZ.setVisibility(0);
        this.jVZ.setImageResource(amr());
        this.jVZ.setColorFilter(i, Mode.SRC_ATOP);
        if (this.jVT == i.ixU) {
            post(new 2(this));
        } else {
            post(new 1(this));
        }
    }
}
