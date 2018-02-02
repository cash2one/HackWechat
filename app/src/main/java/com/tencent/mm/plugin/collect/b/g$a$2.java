package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class g$a$2 implements OnCompletionListener {
    final /* synthetic */ String gBF;
    final /* synthetic */ MediaPlayer liw;
    final /* synthetic */ OnCompletionListener liy;

    g$a$2(String str, MediaPlayer mediaPlayer, OnCompletionListener onCompletionListener) {
        this.gBF = str;
        this.liw = mediaPlayer;
        this.liy = onCompletionListener;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        String str = "MicroMsg.F2fRcvVoiceListener";
        String str2 = "play completion mp:%d  path:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
        objArr[1] = this.gBF;
        x.i(str, str2, objArr);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.liw != null) {
            this.liw.release();
        }
        if (this.liy != null) {
            this.liy.onCompletion(mediaPlayer);
        }
    }
}
