package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class f$7 implements OnClickListener {
    final /* synthetic */ f tpL;

    f$7(f fVar) {
        this.tpL = fVar;
    }

    public final void onClick(View view) {
        if (d.bPB().nbV) {
            g.pQN.h(791, 10);
            TopStoryVideoItemView.a(this.tpL.getContext(), this.tpL, f.c(this.tpL));
        }
    }
}
