package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;

public class MMTagPanelScrollView extends ScrollView {
    private Runnable mvt = new 1(this);
    private int mvv = 0;
    private a yee = new a();
    public int yef = 2;

    private static class a implements Runnable {
        public MMTagPanel yeh;

        private a() {
        }

        public final void run() {
            if (this.yeh != null) {
                this.yeh.cpF();
            }
            this.yeh = null;
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof MMTagPanel)) {
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            boolean cpE = mMTagPanel.cpE();
            if (mMTagPanel.xXN.size() == this.yef) {
                this.mvv = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(e.bvT);
            }
            if (mMTagPanel.xXN.size() >= this.yef) {
                int size = MeasureSpec.getSize(i);
                x.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[]{Integer.valueOf(Math.max(mMTagPanel.Eo(this.yef), this.mvv))});
                setMeasuredDimension(size, r3);
                if (cpE) {
                    this.yee.yeh = mMTagPanel;
                    removeCallbacks(this.yee);
                    post(this.yee);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
    }
}
