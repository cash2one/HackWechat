package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.bg.f;
import com.tencent.mm.sdk.platformtools.ak.a;

class VoiceInputLayout$4 implements a {
    final /* synthetic */ VoiceInputLayout vme;

    VoiceInputLayout$4(VoiceInputLayout voiceInputLayout) {
        this.vme = voiceInputLayout;
    }

    public final boolean uF() {
        if (VoiceInputLayout.b(this.vme) != null) {
            f b = VoiceInputLayout.b(this.vme);
            int i = b.hYo;
            b.hYo = 0;
            if (i > f.fmh) {
                f.fmh = i;
            }
            int i2 = (i * 100) / f.fmh;
            if (this.vme.vlD == 2) {
                this.vme.BT(i2);
            }
        }
        return true;
    }
}
