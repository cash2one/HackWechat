package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;

final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase {
    private int jYs = 0;
    int jYt = -1;
    private boolean mInLayout = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final c amR() {
        return new ag();
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int min;
            int[] akV;
            if (!j.aS(getContext())) {
                akV = c.akV();
                min = (Math.min(akV[0], akV[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.isE);
            } else if (this.jYt > 0) {
                min = this.jYt;
            } else if (this.jYs > 0) {
                min = this.jYs;
            } else {
                akV = c.akV();
                min = (Math.max(akV[0], akV[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.isE);
                this.jYs = min;
            }
            bV(i, MeasureSpec.makeMeasureSpec(min, 1073741824));
            return;
        }
        bV(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
    }

    public final void setVisibility(int i) {
        mb(i);
        if (i == 0) {
            initView();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = false;
    }

    final boolean amS() {
        if (d.fM(18)) {
            return super.isInLayout();
        }
        return this.mInLayout;
    }
}
