package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class FavTagPanelScrollView extends ScrollView {
    private Runnable mvt = new Runnable(this) {
        final /* synthetic */ FavTagPanelScrollView mvw;

        {
            this.mvw = r1;
        }

        public final void run() {
            this.mvw.fullScroll(130);
        }
    };
    private a mvu = new a();
    private int mvv = 0;

    private static class a implements Runnable {
        public FavTagPanel mvx;

        private a() {
        }

        public final void run() {
            if (this.mvx != null) {
                this.mvx.cpF();
            }
            this.mvx = null;
        }
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof FavTagPanel)) {
            FavTagPanel favTagPanel = (FavTagPanel) getChildAt(0);
            boolean cpE = favTagPanel.cpE();
            if (favTagPanel.xXN.size() == 2) {
                this.mvv = favTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(R.f.bvT);
            }
            if (favTagPanel.xXN.size() >= 2) {
                int size = MeasureSpec.getSize(i);
                x.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[]{Integer.valueOf(Math.max(favTagPanel.Eo(2), this.mvv))});
                setMeasuredDimension(size, r3);
                removeCallbacks(this.mvt);
                post(this.mvt);
                if (cpE) {
                    this.mvu.mvx = favTagPanel;
                    removeCallbacks(this.mvu);
                    post(this.mvu);
                }
            }
        }
    }
}
