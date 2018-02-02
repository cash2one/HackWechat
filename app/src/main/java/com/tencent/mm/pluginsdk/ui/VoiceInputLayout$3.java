package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayout$3 extends af {
    final /* synthetic */ VoiceInputLayout vme;

    VoiceInputLayout$3(VoiceInputLayout voiceInputLayout) {
        this.vme = voiceInputLayout;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                VoiceInputLayout voiceInputLayout = this.vme;
                x.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[]{Integer.valueOf(voiceInputLayout.vlD)});
                if (voiceInputLayout.vlD == 2) {
                    voiceInputLayout.vlD = 3;
                    voiceInputLayout.jzN.removeMessages(0);
                    voiceInputLayout.jzN.sendEmptyMessageDelayed(0, (long) voiceInputLayout.vma);
                    voiceInputLayout.jzN.sendEmptyMessageDelayed(1, (long) voiceInputLayout.vmb);
                    voiceInputLayout.cJ(false);
                    return;
                }
                return;
            case 1:
                Bundle data = message.getData();
                this.vme.ae(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                return;
            default:
                return;
        }
    }
}
