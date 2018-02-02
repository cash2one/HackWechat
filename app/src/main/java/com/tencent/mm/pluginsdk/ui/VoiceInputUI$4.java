package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.a;

class VoiceInputUI$4 implements a {
    final /* synthetic */ VoiceInputUI vmw;

    VoiceInputUI$4(VoiceInputUI voiceInputUI) {
        this.vmw = voiceInputUI;
    }

    public final void kV(boolean z) {
        if (z) {
            VoiceInputUI.e(this.vmw).setVisibility(4);
        } else {
            VoiceInputUI.e(this.vmw).setVisibility(0);
        }
    }

    public final void cax() {
        this.vmw.BU(8);
    }
}
