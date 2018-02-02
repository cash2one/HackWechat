package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.xwalk.core.R$styleable;

class CorePlayer$OnlineSeekHandler extends Handler {
    private boolean mIsLastSeekPlaying = false;
    private final WeakReference<CorePlayer> mPlayer;

    CorePlayer$OnlineSeekHandler(Looper looper, CorePlayer corePlayer) {
        super(looper);
        this.mPlayer = new WeakReference(corePlayer);
    }

    public void handleMessage(Message message) {
        CorePlayer corePlayer = (CorePlayer) this.mPlayer.get();
        if (corePlayer != null) {
            switch (message.what) {
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    AudioInformation currentAudioInformation = corePlayer.getCurrentAudioInformation();
                    if ((message.obj instanceof Long) && currentAudioInformation != null && CorePlayer.access$1100(corePlayer) != null) {
                        long longValue = ((Long) message.obj).longValue();
                        boolean access$1200 = CorePlayer.access$1200(corePlayer);
                        if (!CorePlayer.access$1300(corePlayer)) {
                            if (access$1200) {
                                this.mIsLastSeekPlaying = true;
                                corePlayer.pause();
                            } else {
                                this.mIsLastSeekPlaying = false;
                            }
                        }
                        long access$1400 = CorePlayer.access$1400(corePlayer, longValue, (int) ((long) corePlayer.getCurrentAudioInformation().getBitrate()));
                        if (access$1400 >= CorePlayer.access$400(corePlayer)) {
                            access$1400 = CorePlayer.access$400(corePlayer) - CorePlayer.access$1500(corePlayer);
                        }
                        if (access$1400 - CorePlayer.access$1500(corePlayer) < 0) {
                            access$1400 = 0;
                        } else {
                            access$1400 -= CorePlayer.access$1500(corePlayer);
                        }
                        CorePlayer.access$1100(corePlayer).setBufferListener(new 1(this, corePlayer, longValue));
                        CorePlayer.access$1100(corePlayer).seekByBytePosition(access$1400);
                        removeMessages(50);
                        return;
                    }
                    return;
                case 50:
                    if (message.obj instanceof Boolean) {
                        int i = message.arg1;
                        if (((Boolean) message.obj).booleanValue()) {
                            this.mIsLastSeekPlaying = false;
                            corePlayer.play();
                            CorePlayer.access$1800(corePlayer, i);
                            return;
                        }
                        if (CorePlayer.access$1900(corePlayer).transfer(Integer.valueOf(5), new Integer[]{Integer.valueOf(4), Integer.valueOf(2)})) {
                            CorePlayer.access$1800(corePlayer, i);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
