package com.tencent.mm.ui.gridviewheaders;

import android.view.View;

class GridHeadersGridView$a extends GridHeadersGridView$f implements Runnable {
    final /* synthetic */ GridHeadersGridView zfe;

    private GridHeadersGridView$a(GridHeadersGridView gridHeadersGridView) {
        this.zfe = gridHeadersGridView;
        super(gridHeadersGridView);
    }

    public final void run() {
        View GD = this.zfe.GD(this.zfe.zfc);
        if (GD != null) {
            boolean z;
            GridHeadersGridView.a(this.zfe, this.zfe.zfc);
            if (!cxq() || this.zfe.xYe) {
                z = false;
            } else {
                GridHeadersGridView gridHeadersGridView = this.zfe;
                if (gridHeadersGridView.zeY != null) {
                    z = gridHeadersGridView.zeY.cxo();
                } else {
                    z = false;
                }
                if (z) {
                    if (GD != null) {
                        GD.sendAccessibilityEvent(2);
                    }
                    gridHeadersGridView.performHapticFeedback(0);
                }
            }
            if (z) {
                this.zfe.YQ = -2;
                this.zfe.setPressed(false);
                GD.setPressed(false);
                return;
            }
            this.zfe.YQ = 2;
        }
    }
}
