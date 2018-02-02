package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.pluginsdk.ui.tools.p$a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$2 implements p$a {
    private ak ldQ = new ak(ar.Dm().oAt.getLooper(), new 1(this), false);
    final /* synthetic */ b yHl;
    String yyw = "";

    b$2(b bVar) {
        this.yHl = bVar;
    }

    public final void ass() {
    }

    public final void ast() {
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    public final void Xs() {
    }

    public final void Xr() {
        x.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
        if (this.yHl.yHf != null) {
            this.yHl.yHf.onFinish();
        }
    }

    public final void oL(String str) {
        if (!this.yyw.equals(str)) {
            this.yyw = str;
            this.ldQ.TG();
            this.ldQ.J(500, 500);
        }
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void Xt() {
    }

    public final void Xu() {
        x.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
    }
}
