package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class s$2 implements OnErrorListener {
    final /* synthetic */ s hXO;

    s$2(s sVar) {
        this.hXO = sVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if (this.hXO.hXN != null) {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
            this.hXO.hXN.zd();
        }
        if (this.hXO.hXf != null) {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
            this.hXO.hXf.onError();
        }
        try {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener release");
            this.hXO.hXM.release();
            this.hXO.status = -1;
        } catch (Exception e) {
            x.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.hXO.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
        return false;
    }
}
