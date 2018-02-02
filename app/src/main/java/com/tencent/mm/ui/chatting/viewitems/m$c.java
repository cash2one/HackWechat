package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ChattingUI.b;
import com.tencent.mm.z.u;
import java.lang.ref.WeakReference;

class m$c implements b {
    private WeakReference<a> yKC;

    m$c() {
    }

    final void z(a aVar) {
        this.yKC = new WeakReference(aVar);
        aVar.a(this);
    }

    public final void csY() {
        if (this.yKC != null) {
            a aVar = (a) this.yKC.get();
            if (aVar != null) {
                ((e) g.h(e.class)).IW().iv(k.bi(aVar));
            }
        }
    }

    public final void csZ() {
        if (this.yKC != null) {
            a aVar = (a) this.yKC.get();
            if (aVar != null) {
                ((e) g.h(e.class)).IW().iw(k.bi(aVar));
            }
        }
    }

    public final void cta() {
        x.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExit, then detach DynamicPageView.");
        if (this.yKC != null) {
            a aVar = (a) this.yKC.get();
            if (aVar != null) {
                u.GK().hy(k.bi(aVar));
                aVar.b(this);
                ((e) g.h(e.class)).ix(k.bi(aVar));
            }
        }
    }
}
