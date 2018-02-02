package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.bg.e.b;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchLayout$4 implements b {
    final /* synthetic */ VoiceSearchLayout vmL;

    public VoiceSearchLayout$4(VoiceSearchLayout voiceSearchLayout) {
        this.vmL = voiceSearchLayout;
    }

    public final void UT() {
        VoiceSearchLayout.k(this.vmL);
        VoiceSearchLayout.l(this.vmL);
        if (VoiceSearchLayout.m(this.vmL) != null) {
            VoiceSearchLayout.m(this.vmL).TG();
        }
    }

    public final void a(String[] strArr, long j) {
        try {
            x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
            if (strArr != null) {
                x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                for (String str : strArr) {
                    x.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
                }
            }
            this.vmL.reset();
            VoiceSearchLayout.n(this.vmL).a(true, strArr, j);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
        }
    }

    public final void US() {
        this.vmL.reset();
        VoiceSearchLayout.n(this.vmL).a(false, null, -1);
    }
}
