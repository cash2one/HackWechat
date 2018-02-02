package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;

class d$4 implements OnErrorListener {
    final /* synthetic */ a oAC;
    final /* synthetic */ d oAz;

    d$4(d dVar, a aVar) {
        this.oAz = dVar;
        this.oAC = aVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.oAC.cP(i, i2);
    }
}
