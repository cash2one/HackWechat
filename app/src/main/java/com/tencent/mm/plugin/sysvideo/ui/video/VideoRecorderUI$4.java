package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoRecorderUI$4 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$4(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        VideoRecorderUI.h(this.sao).bZK();
        this.sao.finish();
    }
}
