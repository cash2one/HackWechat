package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class VideoRecorderPreviewUI$3 implements OnErrorListener {
    final /* synthetic */ VideoRecorderPreviewUI rZP;

    VideoRecorderPreviewUI$3(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.rZP = videoRecorderPreviewUI;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        VideoRecorderPreviewUI.a(this.rZP).stopPlayback();
        h.h(this.rZP, R.l.eTk, R.l.eTi);
        return false;
    }
}
