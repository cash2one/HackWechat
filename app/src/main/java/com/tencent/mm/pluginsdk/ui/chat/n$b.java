package com.tencent.mm.pluginsdk.ui.chat;

import android.telephony.PhoneStateListener;
import com.tencent.mm.sdk.platformtools.x;

class n$b extends PhoneStateListener {
    final /* synthetic */ n vsx;

    private n$b(n nVar) {
        this.vsx = nVar;
    }

    public final void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        int i2 = -1;
        if (n.k(this.vsx) != null) {
            i2 = n.k(this.vsx).vlD;
        }
        x.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == 2) {
            this.vsx.pause();
        }
    }
}
