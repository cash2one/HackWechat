package com.tencent.mm.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class l$3 implements OnCompletionListener {
    l$3() {
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.release();
        } catch (Throwable e) {
            x.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
        }
    }
}
