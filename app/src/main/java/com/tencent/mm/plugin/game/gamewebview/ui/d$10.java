package com.tencent.mm.plugin.game.gamewebview.ui;

import android.webkit.WebView.FindListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class d$10 implements FindListener {
    final /* synthetic */ d mZC;

    d$10(d dVar) {
        this.mZC = dVar;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (!(!z || d.G(this.mZC) || bh.ov(d.F(this.mZC).bUS()))) {
            if (i2 == 0) {
                g.pQN.a(608, 3, 1, false);
            } else {
                g.pQN.a(608, 2, 1, false);
            }
            d.a(this.mZC, true);
        }
        d.F(this.mZC).o(i, i2, z);
    }
}
