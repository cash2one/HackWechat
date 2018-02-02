package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$3 implements a {
    final /* synthetic */ BaseVoicePrintUI shC;

    BaseVoicePrintUI$3(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final boolean uF() {
        if (BaseVoicePrintUI.a(this.shC) != null) {
            int maxAmplitude;
            p a = BaseVoicePrintUI.a(this.shC);
            if (a.fhJ != null) {
                maxAmplitude = a.fhJ.getMaxAmplitude();
                if (maxAmplitude > p.fmh) {
                    p.fmh = maxAmplitude;
                }
                x.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.fmh + " per:" + ((maxAmplitude * 100) / p.fmh));
                maxAmplitude = (maxAmplitude * 100) / p.fmh;
            } else {
                maxAmplitude = 0;
            }
            BaseVoicePrintUI.a(this.shC, (float) maxAmplitude);
        }
        return true;
    }
}
