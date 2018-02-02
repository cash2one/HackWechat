package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

class d$1 implements OnPreDrawListener {
    final /* synthetic */ View tEH;
    final /* synthetic */ d tEL;

    d$1(d dVar, View view) {
        this.tEL = dVar;
        this.tEH = view;
    }

    public final boolean onPreDraw() {
        this.tEH.getViewTreeObserver().removeOnPreDrawListener(this);
        LayoutParams layoutParams = (LayoutParams) this.tEH.getLayoutParams();
        this.tEL.tEk = layoutParams.leftMargin - this.tEL.oHY;
        return true;
    }
}
