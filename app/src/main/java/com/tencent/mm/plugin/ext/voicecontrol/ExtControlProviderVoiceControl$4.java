package com.tencent.mm.plugin.ext.voicecontrol;

class ExtControlProviderVoiceControl$4 implements Runnable {
    final /* synthetic */ ExtControlProviderVoiceControl mbL;
    final /* synthetic */ a mbM;

    ExtControlProviderVoiceControl$4(ExtControlProviderVoiceControl extControlProviderVoiceControl, a aVar) {
        this.mbL = extControlProviderVoiceControl;
        this.mbM = aVar;
    }

    public final void run() {
        this.mbL.a(this.mbM.mbO, this.mbM.appId, this.mbM.mbP);
    }
}
