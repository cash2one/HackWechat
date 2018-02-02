package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$4 extends c<pr> {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$4(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
        this.xen = pr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pr prVar = (pr) bVar;
        x.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", new Object[]{Integer.valueOf(this.rvm.hashCode()), prVar.fHu.fus, OnlineVideoView.a(this.rvm), Integer.valueOf(prVar.fHu.fuL), Boolean.valueOf(OnlineVideoView.q(this.rvm))});
        if (prVar.fHu.fuL == 2) {
            OnlineVideoView.a(this.rvm, false);
            this.rvm.bzJ();
            this.rvm.onDestroy();
        } else if (prVar.fHu.fuL == 1) {
            OnlineVideoView.o(this.rvm).post(new 1(this, prVar));
        }
        return false;
    }
}
