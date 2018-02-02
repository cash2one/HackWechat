package com.tencent.mm.plugin.music.model.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends Handler {
    final /* synthetic */ a oLJ;

    a$1(a aVar, Looper looper) {
        this.oLJ = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (100 == message.what) {
            long duration = this.oLJ.oLx.getDuration();
            long currentPosition = this.oLJ.oLx.getCurrentPosition();
            long bufferedPosition = this.oLJ.oLx.getBufferedPosition();
            long bufferedPercentage = (long) this.oLJ.oLx.getBufferedPercentage();
            x.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[]{Long.valueOf(duration), Long.valueOf(currentPosition), Long.valueOf(bufferedPosition), Long.valueOf(bufferedPercentage)});
            this.oLJ.oLH.removeMessages(100);
            if (this.oLJ.oKF) {
                this.oLJ.oLH.sendEmptyMessageDelayed(100, 5000);
            }
        }
    }
}
