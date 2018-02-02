package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements OnCompletionListener {
    final /* synthetic */ i hXc;

    i$1(i iVar) {
        this.hXc = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (i.a(this.hXc) != null) {
            x.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
            i.a(this.hXc).zd();
        }
        try {
            i.a(this.hXc, 0);
            if (i.b(this.hXc) != null) {
                x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                i.b(this.hXc).stop();
                i.b(this.hXc).release();
                i.c(this.hXc);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.SilkPlayer", "setCompletion File[" + i.d(this.hXc) + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
