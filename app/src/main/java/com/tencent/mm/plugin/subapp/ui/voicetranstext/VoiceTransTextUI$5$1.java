package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.5;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$5$1 implements Runnable {
    final /* synthetic */ 5 rZy;

    VoiceTransTextUI$5$1(5 5) {
        this.rZy = 5;
    }

    public final void run() {
        x.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
        if (VoiceTransTextUI.q(this.rZy.rZw) != null) {
            VoiceTransTextUI.q(this.rZy.rZw).TG();
        }
        VoiceTransTextUI.c(this.rZy.rZw, a.rZF);
    }
}
