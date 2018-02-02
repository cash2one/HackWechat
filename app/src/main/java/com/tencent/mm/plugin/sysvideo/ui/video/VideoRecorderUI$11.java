package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoRecorderUI$11 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$11(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sao.finish();
    }
}
