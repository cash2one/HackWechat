package com.c.a;

import android.os.IBinder.DeathRecipient;
import com.tencent.rtmp.TXLiveConstants;

class a$1 implements DeathRecipient {
    final /* synthetic */ a bgf;

    a$1(a aVar) {
        this.bgf = aVar;
    }

    public final void binderDied() {
        if (this.bgf.bgc != null) {
            this.bgf.bgc.aH(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL, -1);
        }
    }
}
