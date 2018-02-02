package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.plugin.ipcall.ui.g.2;

class g$1 implements OnGlobalLayoutListener {
    final /* synthetic */ View nKs;
    final /* synthetic */ g nKt;

    g$1(g gVar, View view) {
        this.nKt = gVar;
        this.nKs = view;
    }

    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.nKs.getWindowVisibleDisplayFrame(rect);
        if (this.nKs.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
            g gVar = this.nKt;
            gVar.kND.postDelayed(new 2(gVar), 100);
        }
    }
}
