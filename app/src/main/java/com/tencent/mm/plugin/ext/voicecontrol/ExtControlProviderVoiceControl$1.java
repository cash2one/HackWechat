package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderVoiceControl$1 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ String mbH;
    final /* synthetic */ String mbI;
    final /* synthetic */ String mbJ;
    final /* synthetic */ String mbK;
    final /* synthetic */ ExtControlProviderVoiceControl mbL;

    ExtControlProviderVoiceControl$1(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str, String str2, String str3, String str4, String str5) {
        this.mbL = extControlProviderVoiceControl;
        this.mbH = str;
        this.icE = str2;
        this.mbI = str3;
        this.mbJ = str4;
        this.mbK = str5;
    }

    public final void run() {
        int i = bh.getInt(this.mbH, 4);
        if (i == 1) {
            ExtControlProviderVoiceControl.a(this.mbL, this.icE);
        } else {
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
        if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(this.mbL), i, bh.getInt(this.mbI, 4), bh.getInt(this.mbJ, 16000), bh.getInt(this.mbK, 16), this.icE)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.a(this.mbL, 3504);
            this.mbL.mbD.countDown();
        }
    }
}
