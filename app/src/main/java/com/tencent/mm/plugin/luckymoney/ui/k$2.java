package com.tencent.mm.plugin.luckymoney.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements OnCompletionListener {
    final /* synthetic */ String gBF;

    k$2(String str) {
        this.gBF = str;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        String str = "MicroMsg.LuckySoundUtil";
        String str2 = "play completion mp:%d  path:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
        objArr[1] = this.gBF;
        x.i(str, str2, objArr);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
