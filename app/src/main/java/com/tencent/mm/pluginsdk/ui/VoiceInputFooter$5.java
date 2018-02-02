package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputFooter$5 implements ChatFooterPanel$a {
    final /* synthetic */ VoiceInputFooter vlO;

    VoiceInputFooter$5(VoiceInputFooter voiceInputFooter) {
        this.vlO = voiceInputFooter;
    }

    public final void aXU() {
    }

    public final void gw(boolean z) {
    }

    public final void amZ() {
        VoiceInputFooter.e(this.vlO).ztO.sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(this.vlO).ztO.sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            VoiceInputFooter.e(this.vlO).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
        }
    }
}
