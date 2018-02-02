package com.tencent.mm.pluginsdk.ui.websearch;

class WebSearchVoiceInputLayoutImpl$7 implements Runnable {
    final /* synthetic */ int vmm;
    final /* synthetic */ WebSearchVoiceInputLayoutImpl vzr;

    WebSearchVoiceInputLayoutImpl$7(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl, int i) {
        this.vzr = webSearchVoiceInputLayoutImpl;
        this.vmm = i;
    }

    public final void run() {
        WebSearchVoiceInputLayoutImpl.b(this.vzr).BS(this.vmm);
    }
}
