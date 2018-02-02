package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.bg.e;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchLayout$1 implements a {
    final /* synthetic */ VoiceSearchLayout vmL;

    VoiceSearchLayout$1(VoiceSearchLayout voiceSearchLayout) {
        this.vmL = voiceSearchLayout;
    }

    public final boolean uF() {
        if (VoiceSearchLayout.a(this.vmL) != null) {
            if (VoiceSearchLayout.b(this.vmL) < VoiceSearchLayout.caK().length) {
                VoiceSearchLayout.a(this.vmL, VoiceSearchLayout.caK()[VoiceSearchLayout.c(this.vmL)]);
            } else {
                e a = VoiceSearchLayout.a(this.vmL);
                x.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.hYo);
                int i = a.hYo;
                a.hYo = 0;
                if (i > e.fmh) {
                    e.fmh = i;
                }
                x.d("getMaxAmplitude", " map: " + i + " max:" + e.fmh + " per:" + ((i * 100) / e.fmh));
                int i2 = (i * 100) / e.fmh;
                x.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i2);
                i = VoiceSearchLayout.d(this.vmL);
                if (VoiceSearchLayout.d(this.vmL) == VoiceSearchLayout.e(this.vmL)) {
                    if (i2 <= 10) {
                        VoiceSearchLayout.f(this.vmL);
                        if (VoiceSearchLayout.g(this.vmL) >= VoiceSearchLayout.caL().length) {
                            VoiceSearchLayout.h(this.vmL);
                        }
                        VoiceSearchLayout.a(this.vmL, VoiceSearchLayout.caL()[VoiceSearchLayout.g(this.vmL)]);
                    } else {
                        i2 /= 5;
                        if (i2 >= VoiceSearchLayout.caM().length) {
                            i2 = VoiceSearchLayout.caM().length - 1;
                        }
                        x.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i2);
                        VoiceSearchLayout.b(this.vmL, i2);
                    }
                } else if (VoiceSearchLayout.d(this.vmL) > VoiceSearchLayout.e(this.vmL)) {
                    VoiceSearchLayout.i(this.vmL);
                } else {
                    VoiceSearchLayout.j(this.vmL);
                }
                VoiceSearchLayout.a(this.vmL, VoiceSearchLayout.caM()[i]);
            }
        }
        return true;
    }
}
