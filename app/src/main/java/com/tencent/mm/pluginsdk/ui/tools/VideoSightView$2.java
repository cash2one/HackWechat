package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.x;

class VideoSightView$2 implements f {
    final /* synthetic */ VideoSightView vyA;

    VideoSightView$2(VideoSightView videoSightView) {
        this.vyA = videoSightView;
    }

    public final void b(b bVar, long j) {
        if (this.vyA.duration == 0) {
            this.vyA.duration = this.vyA.getDuration();
        }
        if (this.vyA.quG != null) {
            x.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.vyA.duration)});
            this.vyA.quG.cf((int) j, this.vyA.duration);
        }
    }
}
