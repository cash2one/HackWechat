package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.sdk.platformtools.x;

class b$i$1 implements OnErrorListener {
    final /* synthetic */ i quf;

    b$i$1(i iVar) {
        this.quf = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[]{b.a(this.quf.qtU), Integer.valueOf(i), Integer.valueOf(i2)});
        this.quf.qtU.clear();
        if (b.b(this.quf.qtU) != null) {
            b.b(this.quf.qtU).d(this.quf.qtU, -1);
        }
        return true;
    }
}
