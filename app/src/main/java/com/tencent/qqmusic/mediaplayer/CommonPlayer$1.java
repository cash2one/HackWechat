package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class CommonPlayer$1 implements PlayerCallback {
    final /* synthetic */ CommonPlayer this$0;

    CommonPlayer$1(CommonPlayer commonPlayer) {
        this.this$0 = commonPlayer;
    }

    public void playThreadStart(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playThreadStart");
        } else if (CommonPlayer.access$300(this.this$0)) {
            Logger.i("CommonPlayer", "mCheckAudioInitSuccessHandler 开始检查，等待5S");
            CommonPlayer.access$400(this.this$0, 5000);
        }
    }

    public void playerPrepared(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerPrepared");
            return;
        }
        Logger.i("CommonPlayer", "playerPrepared() callback prepared");
        this.this$0.TransferStateTo(2);
        CommonPlayer.access$700(this.this$0).sendEmptyMessage(2);
        if (CommonPlayer.access$000(this.this$0) != null) {
            CommonPlayer.access$000(this.this$0).onPrepared(this.this$0);
        }
    }

    public void playerStopped(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerStopped");
            return;
        }
        Logger.i("CommonPlayer", "playerStopped() callback stopped");
        CommonPlayer.access$700(this.this$0).removeCallbacksAndMessages(null);
    }

    public void playerStarted(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerStarted");
            return;
        }
        Logger.i("CommonPlayer", "playerStarted() callback started");
        if (CommonPlayer.access$000(this.this$0) != null) {
            CommonPlayer.access$000(this.this$0).onStarted(this.this$0);
        }
    }

    public void playerSeeked(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerSeekCompletion");
            return;
        }
        Logger.i("CommonPlayer", "playerSeeked() callback seeked");
        if (CommonPlayer.access$000(this.this$0) != null) {
            CommonPlayer.access$000(this.this$0).onSeekComplete(this.this$0);
        }
    }

    public void playerPaused(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerPaused");
        } else {
            Logger.i("CommonPlayer", "playerPaused() callback paused");
        }
    }

    public void playerException(CorePlayer corePlayer, int i, int i2, int i3) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerException");
            return;
        }
        Logger.e("CommonPlayer", "playerException() callback exception what = " + i + ",extra = " + i2 + " mAudioPlayer:" + CommonPlayer.access$100(this.this$0));
        if (CommonPlayer.access$100(this.this$0) != null) {
            Logger.e("CommonPlayer", "handleMessage state = " + CommonPlayer.access$100(this.this$0).getPlayerState());
            Logger.e("CommonPlayer", "handleMessage isInit = " + CommonPlayer.access$100(this.this$0).isInit() + ",isStartDecode = " + CommonPlayer.access$100(this.this$0).hasDecodeData() + ",decodeSuccess = " + CommonPlayer.access$100(this.this$0).hasDecodeDataSuccess());
        }
        CommonPlayer.access$700(this.this$0).removeMessages(1);
        if (!CommonPlayer.access$300(this.this$0) || CommonPlayer.access$100(this.this$0) == null || CommonPlayer.access$100(this.this$0).hasDecodeDataSuccess() || i2 == 70 || i2 == 66) {
            CommonPlayer.access$800(this.this$0, i, i2, i3);
            return;
        }
        Logger.i("CommonPlayer", "playerException() path =" + CommonPlayer.access$100(this.this$0).getPlayingFilePath() + "mCheckAudioInitSuccessHandler throw a exception so check immediately");
        CommonPlayer.access$400(this.this$0, 0);
    }

    public void playerEnded(CorePlayer corePlayer) {
        if (CommonPlayer.access$100(this.this$0) != corePlayer) {
            Logger.i("CommonPlayer", "different playerEnded");
            return;
        }
        Logger.i("CommonPlayer", "playerEnded() callback ended");
        this.this$0.TransferStateTo(7);
        CommonPlayer.access$700(this.this$0).removeCallbacksAndMessages(null);
        if (CommonPlayer.access$000(this.this$0) != null) {
            CommonPlayer.access$000(this.this$0).onCompletion(this.this$0);
        }
    }
}
