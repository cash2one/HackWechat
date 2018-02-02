package com.tencent.mm.pluginsdk.ui.websearch;

class WebSearchVoiceInputLayoutImpl$4 implements Runnable {
    final /* synthetic */ boolean vml;
    final /* synthetic */ WebSearchVoiceInputLayoutImpl vzr;

    WebSearchVoiceInputLayoutImpl$4(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl, boolean z) {
        this.vzr = webSearchVoiceInputLayoutImpl;
        this.vml = z;
    }

    public final void run() {
        WebSearchVoiceInputLayoutImpl.b(this.vzr).kU(this.vml);
    }
}
