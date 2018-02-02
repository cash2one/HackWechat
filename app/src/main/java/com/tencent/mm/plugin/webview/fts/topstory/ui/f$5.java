package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements OnClickListener {
    final /* synthetic */ f tpL;

    f$5(f fVar) {
        this.tpL = fVar;
    }

    public final void onClick(View view) {
        if (g.bQd().tpZ) {
            d.Oc(f.e(this.tpL).sey);
            if (g.bQd().bQg()) {
                g.bQd().bxv();
                f.f(this.tpL).bQq();
                f.f(this.tpL).bQt();
            } else {
                g.bQd().bEA();
                f.f(this.tpL).bQr();
                f.f(this.tpL).bQs();
            }
            this.tpL.bPO();
            return;
        }
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "no video play now");
    }
}
