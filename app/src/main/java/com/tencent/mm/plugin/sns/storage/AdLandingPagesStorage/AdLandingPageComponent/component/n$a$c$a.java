package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.x;

class n$a$c$a implements a {
    final /* synthetic */ c rjV;

    private n$a$c$a(c cVar) {
        this.rjV = cVar;
    }

    public final void start() {
    }

    public final void wy(int i) {
        d a = n.a(this.rjV.rjT.rjH);
        d.c cVar = a.xiR;
        if (cVar != null) {
            cVar.sendMessage(Message.obtain(a.xiR, 1, i, 0));
        }
    }

    public final void bus() {
        x.i("LogStateTransitionState", "paused");
        n.a(this.rjV.rjT.rjH).Dh(7);
    }

    public final void but() {
    }

    public final void buu() {
        n.a(this.rjV.rjT.rjH).Dh(9);
    }

    public final void buv() {
        n.a(this.rjV.rjT.rjH).Dh(8);
    }

    public final void buw() {
    }
}
