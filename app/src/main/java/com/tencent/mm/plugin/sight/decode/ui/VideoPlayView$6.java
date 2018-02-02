package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View;
import android.view.View.OnClickListener;

class VideoPlayView$6 implements OnClickListener {
    final /* synthetic */ VideoPlayView qvt;

    public VideoPlayView$6(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final void onClick(View view) {
        VideoPlayView.l(this.qvt).removeCallbacks(VideoPlayView.n(this.qvt));
        VideoPlayView.l(this.qvt).postDelayed(VideoPlayView.n(this.qvt), 3000);
        if (VideoPlayView.a(this.qvt).isPlaying()) {
            VideoPlayView.o(this.qvt);
            if (VideoPlayView.c(this.qvt) != null) {
                VideoPlayView.c(this.qvt).db(false);
                return;
            }
            return;
        }
        VideoPlayView.a(this.qvt, false);
        VideoPlayView.a(this.qvt).q(VideoPlayView.g(this.qvt));
        if (VideoPlayView.c(this.qvt) != null) {
            VideoPlayView.c(this.qvt).db(true);
        }
    }
}
