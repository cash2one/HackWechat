package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.SystemClock;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.k.e;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$1 implements a {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$1(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final boolean uF() {
        if (VideoRecorderUI.a(this.sao) == -1) {
            VideoRecorderUI.a(this.sao, SystemClock.elapsedRealtime());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.a(this.sao);
        VideoRecorderUI.b(this.sao).setText(e.iW((int) (elapsedRealtime / 1000)));
        if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
            VideoRecorderUI.c(this.sao).setVisibility(8);
        } else {
            long j = (30000 - elapsedRealtime) / 1000;
            VideoRecorderUI.c(this.sao).setVisibility(0);
            VideoRecorderUI.c(this.sao).setText(this.sao.getResources().getQuantityString(R.j.duM, (int) j, new Object[]{Long.valueOf(j)}));
        }
        if (elapsedRealtime >= 30000) {
            x.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
            VideoRecorderUI.d(this.sao);
            VideoRecorderUI.a(this.sao, -1);
            return false;
        }
        VideoRecorderUI.a(this.sao, VideoRecorderUI.e(this.sao) % 2);
        if (VideoRecorderUI.e(this.sao) == 0) {
            VideoRecorderUI.f(this.sao).setVisibility(4);
        } else {
            VideoRecorderUI.f(this.sao).setVisibility(0);
        }
        VideoRecorderUI.g(this.sao);
        return true;
    }
}
