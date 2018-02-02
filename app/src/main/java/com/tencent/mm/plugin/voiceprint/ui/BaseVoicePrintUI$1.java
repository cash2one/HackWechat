package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$1 implements a {
    final /* synthetic */ BaseVoicePrintUI shC;

    BaseVoicePrintUI$1(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final void bFI() {
        p a = BaseVoicePrintUI.a(this.shC);
        if (a.fhJ != null) {
            a.fhJ.vi();
            x.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
        }
        a.fileName = "";
        a.shi = null;
        a.rWC = 0;
        a.myE = 0;
        if (a.hXN != null) {
            a.hXN.zd();
        }
        x.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
        BaseVoicePrintUI.a(this.shC, null);
        BaseVoicePrintUI.b(this.shC);
    }
}
