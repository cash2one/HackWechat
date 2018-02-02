package com.tencent.mm.plugin.webview.fts.c;

import android.view.View;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ FtsWebVideoView trG;
    final /* synthetic */ b trH;

    b$3(b bVar, FtsWebVideoView ftsWebVideoView) {
        this.trH = bVar;
        this.trG = ftsWebVideoView;
    }

    public final void aga() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        x.i("MicroMsg.FtsWebVideoView", "onUIResume");
        ftsWebVideoView.tqR.TE();
    }

    public final void afA() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        x.i("MicroMsg.FtsWebVideoView", "onUIPause");
        ftsWebVideoView.tqR.TD();
    }

    public final void onDestroy() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        x.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
        x.i("MicroMsg.FtsWebVideoView", "clean");
        ftsWebVideoView.stop();
        ftsWebVideoView.tqR.ahl();
        ftsWebVideoView.tqS.onDestroy();
        try {
            ftsWebVideoView.getContext().unregisterReceiver(ftsWebVideoView.trl);
        } catch (Exception e) {
        }
    }

    public final void agt() {
        b bVar = this.trH.trE;
        b.a Ag = bVar.Ag(bVar.jFq);
        float[] fArr = bVar.jFn;
        if (Ag != null && Ag.jFA != null && fArr != null) {
            View view = (View) Ag.jFA.get();
            if (view != null) {
                if (bVar.jFq != bVar.jFm) {
                    b.a Ag2 = bVar.Ag(bVar.jFm);
                    if (!(Ag2 == null || Ag2.jFA == null)) {
                        View view2 = (View) Ag2.jFA.get();
                        if (view2 != null) {
                            bVar.a(bVar.jFm, fArr, view2.getVisibility());
                        }
                    }
                }
                int i = bVar.jFq;
                bVar.jFm = -1;
                bVar.jFq = -1;
                if (bVar.trz != null) {
                    bVar.trz.agt();
                    bVar.trz = null;
                }
                bVar.a(i, fArr, view.getVisibility());
            }
        }
    }

    public final boolean aeG() {
        if (!this.trG.agN()) {
            return false;
        }
        this.trG.kl(false);
        return true;
    }

    public final void bPX() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        if (!ftsWebVideoView.kTc && ftsWebVideoView.bQm() == 0) {
            ftsWebVideoView.setMute(true);
        }
    }

    public final void bQw() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        if (ftsWebVideoView.kTc && ftsWebVideoView.bQm() > 0) {
            ftsWebVideoView.setMute(false);
        }
    }
}
