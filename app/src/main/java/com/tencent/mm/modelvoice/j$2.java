package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements OnErrorListener {
    final /* synthetic */ j hXs;

    j$2(j jVar) {
        this.hXs = jVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.SpeexPlayer", "onError");
        if (this.hXs.fme != null) {
            this.hXs.fme.zd();
        }
        if (this.hXs.hXf != null) {
            this.hXs.hXf.onError();
        }
        try {
            this.hXs.status = -1;
            this.hXs.UB();
            try {
                j.a(this.hXs);
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.hXs.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
        }
        return false;
    }
}
