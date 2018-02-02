package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$2 implements OnCancelListener {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$2(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
        if (VideoRecorderUI.h(this.sao) != null) {
            VideoRecorderUI.u(this.sao);
            VideoRecorderUI.v(this.sao).setVisibility(0);
            VideoRecorderUI.w(this.sao).setVisibility(0);
        }
    }
}
