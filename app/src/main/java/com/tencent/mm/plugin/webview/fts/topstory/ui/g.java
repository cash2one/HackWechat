package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.plugin.topstory.a.a.b;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.d;
import com.tencent.mm.z.d.a;

public final class g {
    static g tpV;
    d tpW = new d();
    TopStoryVideoView tpX;
    c tpY;
    public boolean tpZ;
    boolean tqa;
    h.c tqb = new 1(this);
    a tqc = new 2(this);
    boolean tqd;

    public static g bQd() {
        if (tpV == null) {
            tpV = new g();
        }
        return tpV;
    }

    private g() {
    }

    final void bQe() {
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tnN = this.tpY;
        b bVar = new b();
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tnO = bVar;
        bVar.sev = (long) com.tencent.mm.plugin.webview.fts.topstory.a.d.tnP;
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tnO.sep = System.currentTimeMillis();
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tnP = 2;
    }

    private void bQf() {
        this.tpW.bx(false);
    }

    public final boolean bQg() {
        if (this.tpX != null) {
            return this.tpX.isPlaying();
        }
        return false;
    }

    public final void setMute(boolean z) {
        if (this.tpX != null) {
            this.tpX.setMute(z);
        }
    }

    public final void bEA() {
        if (this.tpX != null) {
            this.tpW.a(this.tqc);
            this.tpX.setKeepScreenOn(true);
            this.tpX.play();
            this.tqa = false;
        }
    }

    public final void bxv() {
        if (this.tpX != null) {
            bQf();
            this.tpX.setKeepScreenOn(false);
            this.tpX.pause();
            this.tqa = true;
        }
    }

    public final void stopPlay() {
        if (this.tpX != null) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewMgr", "stop play");
            bQf();
            ((TopStoryVideoPlayTextureView) this.tpX.kTe).setAlpha(0.0f);
            this.tpX.setKeepScreenOn(false);
            this.tpX.stop();
            this.tpY = null;
            this.tpZ = false;
            this.tqa = false;
            com.tencent.mm.plugin.webview.fts.topstory.a.d.bPs();
        }
    }

    public final int ahk() {
        if (this.tpX != null) {
            return this.tpX.ahk();
        }
        return 0;
    }

    public final int ahi() {
        if (this.tpX != null) {
            return this.tpX.ahi();
        }
        return 0;
    }
}
