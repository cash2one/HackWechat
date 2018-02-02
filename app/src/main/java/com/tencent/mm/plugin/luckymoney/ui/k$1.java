package com.tencent.mm.plugin.luckymoney.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnErrorListener {
    k$1() {
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        return false;
    }
}
