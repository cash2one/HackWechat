package com.tencent.mm.plugin.sight.decode.ui;

import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;

class VideoPlayView$3 implements Runnable {
    final /* synthetic */ VideoPlayView qvt;

    VideoPlayView$3(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.qvt.getContext() instanceof MMActivity) {
            ((MMActivity) this.qvt.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (VideoPlayView.a(this.qvt) instanceof VideoSightView) {
                ((VideoSightView) VideoPlayView.a(this.qvt)).wj(displayMetrics.widthPixels);
            }
        }
        ((View) VideoPlayView.a(this.qvt)).requestLayout();
        ((View) VideoPlayView.a(this.qvt)).postInvalidate();
    }
}
