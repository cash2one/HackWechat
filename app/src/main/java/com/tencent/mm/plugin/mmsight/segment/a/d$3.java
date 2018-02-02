package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;

class d$3 implements OnVideoSizeChangedListener {
    final /* synthetic */ d oAB;
    final /* synthetic */ d oAz;

    d$3(d dVar, d dVar2) {
        this.oAz = dVar;
        this.oAB = dVar2;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.oAB.Q(i, i2, 0);
    }
}
