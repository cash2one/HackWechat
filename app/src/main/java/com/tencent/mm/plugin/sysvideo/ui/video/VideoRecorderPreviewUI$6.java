package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoRecorderPreviewUI$6 implements OnCompletionListener {
    final /* synthetic */ VideoRecorderPreviewUI rZP;

    VideoRecorderPreviewUI$6(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.rZP = videoRecorderPreviewUI;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.rZP.finish();
        this.rZP.overridePendingTransition(0, 0);
    }
}
