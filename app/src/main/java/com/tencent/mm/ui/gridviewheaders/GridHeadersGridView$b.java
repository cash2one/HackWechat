package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.a;

final class GridHeadersGridView$b implements Runnable {
    final /* synthetic */ GridHeadersGridView zfe;

    GridHeadersGridView$b(GridHeadersGridView gridHeadersGridView) {
        this.zfe = gridHeadersGridView;
    }

    public final void run() {
        if (this.zfe.YQ == 0) {
            this.zfe.YQ = 1;
            View GD = this.zfe.GD(this.zfe.zfc);
            if (GD != null && !GD.hasFocusable()) {
                if (this.zfe.xYe) {
                    this.zfe.YQ = 2;
                    return;
                }
                GD.setPressed(true);
                this.zfe.setPressed(true);
                this.zfe.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                if (this.zfe.isLongClickable()) {
                    if (this.zfe.zeL == null) {
                        this.zfe.zeL = new a(this.zfe, (byte) 0);
                    }
                    this.zfe.zeL.cxp();
                    GridHeadersGridView.d(this.zfe).postDelayed(this.zfe.zeL, (long) longPressTimeout);
                    return;
                }
                this.zfe.YQ = 2;
            }
        }
    }
}
