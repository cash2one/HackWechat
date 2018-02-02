package com.tencent.mm.pluginsdk.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayout$1 extends af {
    final /* synthetic */ VoiceInputLayout vme;

    VoiceInputLayout$1(VoiceInputLayout voiceInputLayout) {
        this.vme = voiceInputLayout;
    }

    public final void handleMessage(Message message) {
        if (message.what != 0) {
            if (message.what == 1) {
                x.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[]{Integer.valueOf(this.vme.vlD)});
            } else {
                return;
            }
        }
        x.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[]{Integer.valueOf(this.vme.vlD)});
        if (this.vme.vlD == 3) {
            VoiceInputLayout.a(this.vme).removeMessages(0);
            VoiceInputLayout.a(this.vme).removeMessages(1);
            if (VoiceInputLayout.b(this.vme) != null) {
                VoiceInputLayout.b(this.vme).al(true);
            }
            this.vme.reset(true);
        }
    }
}
