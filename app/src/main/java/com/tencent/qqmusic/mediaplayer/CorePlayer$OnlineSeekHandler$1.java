package com.tencent.qqmusic.mediaplayer;

import android.os.Message;
import com.tencent.qqmusic.mediaplayer.CorePlayer.OnlineSeekHandler;

class CorePlayer$OnlineSeekHandler$1 implements OnBufferListener {
    final /* synthetic */ OnlineSeekHandler this$0;
    final /* synthetic */ CorePlayer val$player;
    final /* synthetic */ long val$position;

    CorePlayer$OnlineSeekHandler$1(OnlineSeekHandler onlineSeekHandler, CorePlayer corePlayer, long j) {
        this.this$0 = onlineSeekHandler;
        this.val$player = corePlayer;
        this.val$position = j;
    }

    public void onBufferReadyToPlay() {
        this.this$0.removeMessages(50);
        this.val$player.addSeekRecord((int) this.val$position);
        Message obtain = Message.obtain(this.this$0, 50);
        obtain.arg1 = (int) this.val$position;
        obtain.obj = Boolean.valueOf(OnlineSeekHandler.access$1700(this.this$0));
        this.this$0.sendMessageDelayed(obtain, 100);
    }

    public void onBufferProgress(long j, long j2) {
        this.val$player.notifyDownloadProgress(j, j2);
    }
}
