package com.tencent.rtmp.sharp.jni;

import java.util.TimerTask;

class TraeMediaPlayer$1 extends TimerTask {
    final /* synthetic */ TraeMediaPlayer a;

    TraeMediaPlayer$1(TraeMediaPlayer traeMediaPlayer) {
        this.a = traeMediaPlayer;
    }

    public void run() {
        if (TraeMediaPlayer.access$000(this.a) != null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeMediaPlay | play timeout");
            }
            if (TraeMediaPlayer.access$100(this.a) != null) {
                TraeMediaPlayer.access$100(this.a).a();
            }
        }
    }
}
