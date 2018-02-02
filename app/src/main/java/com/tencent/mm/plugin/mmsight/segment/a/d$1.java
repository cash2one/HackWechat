package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;

class d$1 implements OnPreparedListener {
    final /* synthetic */ b oAy;
    final /* synthetic */ d oAz;

    d$1(d dVar, b bVar) {
        this.oAz = dVar;
        this.oAy = bVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.oAy.by(mediaPlayer);
    }
}
