package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class s$1 implements OnCompletionListener {
    final /* synthetic */ s hXO;

    s$1(s sVar) {
        this.hXO = sVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if (this.hXO.hXN != null) {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
            this.hXO.hXN.zd();
        }
        if (this.hXO.hXe != null) {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
            this.hXO.hXe.vh();
        }
        try {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
            this.hXO.hXM.release();
            this.hXO.status = 0;
        } catch (Exception e) {
            x.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.hXO.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
