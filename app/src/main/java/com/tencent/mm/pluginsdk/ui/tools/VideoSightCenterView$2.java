package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.x;

class VideoSightCenterView$2 implements f {
    final /* synthetic */ VideoSightCenterView vyw;

    VideoSightCenterView$2(VideoSightCenterView videoSightCenterView) {
        this.vyw = videoSightCenterView;
    }

    public final void b(b bVar, long j) {
        if (this.vyw.duration == 0) {
            this.vyw.duration = this.vyw.getDuration();
        }
        if (this.vyw.quG != null) {
            x.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.vyw.duration)});
            VideoSightCenterView.a(this.vyw, (int) (1000 * j));
            this.vyw.quG.cf((int) j, this.vyw.duration);
        }
    }
}
