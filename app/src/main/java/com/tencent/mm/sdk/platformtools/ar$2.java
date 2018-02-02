package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.ar.a;

class ar$2 implements OnCompletionListener {
    final /* synthetic */ String gBF;
    final /* synthetic */ MediaPlayer liw;
    final /* synthetic */ a xhk;

    ar$2(String str, MediaPlayer mediaPlayer, a aVar) {
        this.gBF = str;
        this.liw = mediaPlayer;
        this.xhk = aVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        String str = "MicroMsg.PlaySound";
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
        if (this.xhk != null) {
            this.xhk.vh();
        }
    }
}
