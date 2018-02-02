package com.tencent.mm.pluginsdk.ui;

class VoiceInputLayoutImpl$7 implements Runnable {
    final /* synthetic */ VoiceInputLayoutImpl vmk;
    final /* synthetic */ int vmm;

    VoiceInputLayoutImpl$7(VoiceInputLayoutImpl voiceInputLayoutImpl, int i) {
        this.vmk = voiceInputLayoutImpl;
        this.vmm = i;
    }

    public final void run() {
        VoiceInputLayoutImpl.a(this.vmk).BS(this.vmm);
    }
}
