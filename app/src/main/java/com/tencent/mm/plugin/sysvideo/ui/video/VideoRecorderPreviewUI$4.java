package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.video.VideoView;

class VideoRecorderPreviewUI$4 implements OnPreparedListener {
    final /* synthetic */ VideoRecorderPreviewUI rZP;

    VideoRecorderPreviewUI$4(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.rZP = videoRecorderPreviewUI;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        x.d("MicroMsg.VideoRecorderPreviewUI", g.zg() + " onPrepared");
        x.d("MicroMsg.VideoRecorderPreviewUI", g.zg() + " onPrepared");
        VideoView a = VideoRecorderPreviewUI.a(this.rZP);
        if (a.qxO == null || !a.vyC) {
            a.vyD = true;
        } else {
            a.qxO.start();
            a.vyD = false;
        }
        VideoRecorderPreviewUI.b(this.rZP).sendEmptyMessageDelayed(0, 3000);
    }
}
