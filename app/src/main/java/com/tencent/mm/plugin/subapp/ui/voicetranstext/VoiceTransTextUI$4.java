package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$4 implements a {
    final /* synthetic */ int rVr;
    final /* synthetic */ VoiceTransTextUI rZw;

    VoiceTransTextUI$4(VoiceTransTextUI voiceTransTextUI, int i) {
        this.rZw = voiceTransTextUI;
        this.rVr = i;
    }

    public final boolean uF() {
        if (!VoiceTransTextUI.m(this.rZw)) {
            x.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[]{Integer.valueOf(this.rVr)});
            VoiceTransTextUI.c(this.rZw, VoiceTransTextUI.a.rZF);
        }
        return false;
    }
}
