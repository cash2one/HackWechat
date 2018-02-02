package com.tencent.mm.plugin.webview.fts;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.bc.l;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

class b$2 implements f {
    final /* synthetic */ String fgU;
    final /* synthetic */ String iTD;
    final /* synthetic */ b tlF;
    final /* synthetic */ ThreeDotsLoadingView tlG;
    final /* synthetic */ ImageView tlH;
    final /* synthetic */ String tlI;

    b$2(b bVar, String str, ThreeDotsLoadingView threeDotsLoadingView, ImageView imageView, String str2, String str3) {
        this.tlF = bVar;
        this.iTD = str;
        this.tlG = threeDotsLoadingView;
        this.tlH = imageView;
        this.tlI = str2;
        this.fgU = str3;
    }

    public final void q(View view, int i) {
        x.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", this.iTD, Integer.valueOf(i));
        b.a(this.tlF, i);
        switch (i) {
            case 0:
                this.tlG.setVisibility(0);
                this.tlH.setVisibility(4);
                b.a(this.tlF).cJ(this.tlI, 1);
                return;
            case 1:
                this.tlG.ajm();
                this.tlG.setVisibility(4);
                b.a(this.tlF).cJ(this.tlI, 3);
                b.bPe();
                l.E(this.fgU, false);
                return;
            case 4:
                this.tlG.setVisibility(4);
                this.tlH.setVisibility(4);
                this.tlG.ajm();
                b.bPe();
                l.E(this.fgU, true);
                b.a(this.tlF).cJ(this.tlI, 2);
                return;
            default:
                b.bPe();
                l.E(this.fgU, false);
                this.tlG.ajm();
                this.tlG.setVisibility(4);
                if (i == 2) {
                    b.a(this.tlF).cJ(this.tlI, 4);
                    return;
                } else {
                    b.a(this.tlF).cJ(this.tlI, 3);
                    return;
                }
        }
    }
}
