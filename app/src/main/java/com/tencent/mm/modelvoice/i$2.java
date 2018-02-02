package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnErrorListener {
    final /* synthetic */ i hXc;

    i$2(i iVar) {
        this.hXc = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.SilkPlayer", "onError");
        if (i.a(this.hXc) != null) {
            i.a(this.hXc).zd();
        }
        if (i.e(this.hXc) != null) {
            i.e(this.hXc).onError();
        }
        try {
            i.a(this.hXc, -1);
            if (i.b(this.hXc) != null) {
                x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                i.b(this.hXc).stop();
                i.b(this.hXc).release();
                i.c(this.hXc);
            }
        } catch (Exception e) {
            x.e("MicroMsg.SilkPlayer", "setErrorListener File[" + i.d(this.hXc) + "] ErrMsg[" + e.getStackTrace() + "]");
        }
        return false;
    }
}
