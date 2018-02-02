package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayView$1 implements f$a {
    final /* synthetic */ VideoPlayView qvt;

    VideoPlayView$1(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final void hX() {
        x.d("MicroMsg.VideoPlayView", g.zg() + " onPrepared");
        VideoPlayView.a(this.qvt, true);
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        VideoPlayView.a(this.qvt).stop();
    }

    public final void vh() {
        x.d("MicroMsg.VideoPlayView", "on completion " + bh.cgy().toString());
        if (VideoPlayView.b(this.qvt)) {
            VideoPlayView.c(this.qvt).db(false);
            VideoPlayView.a(this.qvt, (int) VideoPlayView.g(this.qvt));
            VideoPlayView.d(this.qvt);
            if (VideoPlayView.f(this.qvt) != null) {
                VideoPlayView.f(this.qvt).btk();
                return;
            }
            return;
        }
        VideoPlayView.a(this.qvt, 0.0d);
        this.qvt.q(0.0d);
        VideoPlayView.c(this.qvt).db(false);
        VideoPlayView.a(this.qvt, 0);
        VideoPlayView.d(this.qvt);
        if (System.currentTimeMillis() - VideoPlayView.e(this.qvt) < 2000) {
            x.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            return;
        }
        VideoPlayView.a(this.qvt, System.currentTimeMillis());
        if (VideoPlayView.f(this.qvt) != null) {
            VideoPlayView.f(this.qvt).btj();
        }
    }

    public final int cf(int i, int i2) {
        ag.y(new 1(this, i, i2));
        return 0;
    }

    public final void cg(int i, int i2) {
        VideoPlayView.c(this.qvt, i);
        VideoPlayView.d(this.qvt, i2);
        if (VideoPlayView.k(this.qvt)) {
            VideoPlayView.l(this.qvt).post(new 2(this));
        }
    }
}
