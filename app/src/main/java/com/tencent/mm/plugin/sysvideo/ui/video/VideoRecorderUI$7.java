package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class VideoRecorderUI$7 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$7(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            u.fI(this.sao);
        } else if (VideoRecorderUI.k(this.sao)) {
            VideoRecorderUI.d(this.sao);
        } else if (VideoRecorderUI.l(this.sao)) {
            h.a(this.sao, this.sao.getString(R.l.eTn), this.sao.getString(R.l.dGO), new 1(this), new 2(this));
        } else {
            VideoRecorderUI.m(this.sao).setImageResource(R.g.bHi);
            VideoRecorderUI.n(this.sao);
        }
    }
}
