package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.g.a.kf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$5 extends c<kf> {
    final /* synthetic */ VoiceTransTextUI rZw;

    VoiceTransTextUI$5(VoiceTransTextUI voiceTransTextUI) {
        this.rZw = voiceTransTextUI;
        this.xen = kf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kf kfVar = (kf) bVar;
        x.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
        if (VoiceTransTextUI.n(this.rZw) != null && !VoiceTransTextUI.m(this.rZw) && (kfVar instanceof kf) && kfVar.fBz.fBA == VoiceTransTextUI.n(this.rZw).rZe) {
            x.i("MicroMsg.VoiceTransTextUI", "");
            if (VoiceTransTextUI.o(this.rZw)) {
                x.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                VoiceTransTextUI.p(this.rZw);
            } else {
                new af(this.rZw.getMainLooper()).post(new 1(this));
            }
        }
        return false;
    }
}
