package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2;
import com.tencent.mm.ui.base.h.c;

class VoiceTransTextUI$2$1 implements c {
    final /* synthetic */ 2 rZx;

    VoiceTransTextUI$2$1(2 2) {
        this.rZx = 2;
    }

    public final void jl(int i) {
        if (i == 0 && VoiceTransTextUI.a(this.rZx.rZw) != null && VoiceTransTextUI.b(this.rZx.rZw) != null) {
            VoiceTransTextUI.a(this.rZx.rZw).setText(VoiceTransTextUI.b(this.rZx.rZw).getText());
        }
    }
}
