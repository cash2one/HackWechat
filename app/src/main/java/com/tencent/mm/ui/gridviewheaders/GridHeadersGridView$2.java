package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.e;

class GridHeadersGridView$2 implements Runnable {
    final /* synthetic */ GridHeadersGridView zfe;
    final /* synthetic */ View zff;
    final /* synthetic */ e zfg;

    GridHeadersGridView$2(GridHeadersGridView gridHeadersGridView, View view, e eVar) {
        this.zfe = gridHeadersGridView;
        this.zff = view;
        this.zfg = eVar;
    }

    public final void run() {
        this.zfe.YQ = -1;
        this.zff.setPressed(false);
        this.zfe.setPressed(false);
        if (!this.zfe.xYe) {
            this.zfg.run();
        }
    }
}
