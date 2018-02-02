package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.f;

class GridHeadersGridView$e extends f implements Runnable {
    final /* synthetic */ GridHeadersGridView zfe;
    int zfh;

    private GridHeadersGridView$e(GridHeadersGridView gridHeadersGridView) {
        this.zfe = gridHeadersGridView;
        super(gridHeadersGridView, (byte) 0);
    }

    public final void run() {
        if (!this.zfe.xYe && this.zfe.zfb != null && this.zfe.zfb.getCount() > 0 && this.zfh != -1 && this.zfh < this.zfe.zfb.getCount() && cxq()) {
            View GD = this.zfe.GD(this.zfh);
            if (GD != null) {
                GridHeadersGridView gridHeadersGridView = this.zfe;
                GridHeadersGridView.a(this.zfe, this.zfh);
                if (gridHeadersGridView.zeX != null) {
                    gridHeadersGridView.playSoundEffect(0);
                    if (GD != null) {
                        GD.sendAccessibilityEvent(1);
                    }
                    gridHeadersGridView.zeX.cl(GD);
                }
            }
        }
    }
}
