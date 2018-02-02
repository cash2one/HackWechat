package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.g.a.sj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class n$8 extends c<sj> {
    final /* synthetic */ n vsx;

    n$8(n nVar) {
        this.vsx = nVar;
        this.xen = sj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sj sjVar = (sj) bVar;
        if (!(sjVar instanceof sj)) {
            x.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
            return false;
        } else if (sjVar == null || sjVar.fKc == null) {
            x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
            return false;
        } else if (n.d(this.vsx)) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
            return false;
        } else if (sjVar.fKc.fKe.equalsIgnoreCase(n.e(this.vsx))) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", new Object[]{Integer.valueOf(sjVar.fKc.action), Integer.valueOf(sjVar.fKc.fKd)});
            if (sjVar.fKc.action == 2) {
                if (sjVar.fKc.fKd == 1) {
                    n.a(this.vsx, true);
                } else {
                    n.a(this.vsx, false);
                }
                n.g(this.vsx).a(n.f(this.vsx), sjVar.fKc.result, false);
                n.g(this.vsx).a(n.f(this.vsx));
                n.g(this.vsx).b(n.f(this.vsx));
                n.h(this.vsx);
                n.i(this.vsx).fullScroll(130);
            } else if (sjVar.fKc.action == 3) {
                if (n.j(this.vsx) != null) {
                    n.j(this.vsx).bTZ();
                }
            } else if (sjVar.fKc.action == 1 || sjVar.fKc.action == 4) {
                if (sjVar.fKc.fKd == 1) {
                    n.a(this.vsx, true);
                } else {
                    n.a(this.vsx, false);
                }
                n.g(this.vsx).a(n.f(this.vsx), sjVar.fKc.result, false);
                n.g(this.vsx).a(n.f(this.vsx));
                n.g(this.vsx).b(n.f(this.vsx));
                n.h(this.vsx);
                n.i(this.vsx).fullScroll(130);
                n.a(this.vsx, sjVar.fKc.action);
            } else {
                this.vsx.reset();
            }
            return true;
        } else {
            x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
            this.vsx.destroy();
            return false;
        }
    }
}
