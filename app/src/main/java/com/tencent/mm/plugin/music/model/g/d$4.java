package com.tencent.mm.plugin.music.model.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements OnErrorListener {
    final /* synthetic */ d oMm;

    d$4(d dVar) {
        this.oMm = dVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.oMm.gW(false);
        return false;
    }
}
