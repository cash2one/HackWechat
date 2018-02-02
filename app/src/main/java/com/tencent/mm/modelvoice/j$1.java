package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements OnCompletionListener {
    final /* synthetic */ j hXs;

    j$1(j jVar) {
        this.hXs = jVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.hXs.fme != null) {
            this.hXs.fme.zd();
        }
        try {
            this.hXs.status = 0;
            this.hXs.UB();
            try {
                j.a(this.hXs);
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e2)});
            x.e("MicroMsg.SpeexPlayer", "setCompletion File[" + this.hXs.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
        }
    }
}
