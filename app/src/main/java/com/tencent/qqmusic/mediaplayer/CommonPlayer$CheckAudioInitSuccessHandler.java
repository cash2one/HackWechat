package com.tencent.qqmusic.mediaplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

class CommonPlayer$CheckAudioInitSuccessHandler extends Handler {
    private static final int MSG_CHECK = 1;
    private static final int MSG_NOTIFY_BUFFER_PROGRESS = 2;
    private final WeakReference<CommonPlayer> mQQMediaPlayer;

    CommonPlayer$CheckAudioInitSuccessHandler(CommonPlayer commonPlayer) {
        super(Looper.getMainLooper());
        this.mQQMediaPlayer = new WeakReference(commonPlayer);
    }

    public void handleMessage(Message message) {
        CommonPlayer commonPlayer = (CommonPlayer) this.mQQMediaPlayer.get();
        if (commonPlayer != null) {
            if (message.what == 1) {
                check(message, commonPlayer);
            } else if (message.what == 2) {
                PlayerListenerCallback access$000 = CommonPlayer.access$000(commonPlayer);
                if (access$000 != null) {
                    CorePlayer access$100 = CommonPlayer.access$100(commonPlayer);
                    if (access$100 != null) {
                        int bufferedPercentage = access$100.getBufferedPercentage();
                        access$000.onBufferingUpdate(commonPlayer, bufferedPercentage);
                        if (bufferedPercentage != 100 && commonPlayer.getPlayerState() != 9 && commonPlayer.getPlayerState() != 8 && commonPlayer.getPlayerState() != 7) {
                            sendEmptyMessageDelayed(2, 200);
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    private void check(Message message, CommonPlayer commonPlayer) {
        Logger.i("CommonPlayer", "mCheckAudioInitSuccessHandler wait 5s");
        String str = "null";
        CorePlayer access$100 = CommonPlayer.access$100(commonPlayer);
        if (access$100 != null) {
            Logger.i("CommonPlayer", String.format("handleMessage, init: %b, startDecode: %b, decode: %b, statue: %d ", new Object[]{Boolean.valueOf(access$100.isInit()), Boolean.valueOf(access$100.hasDecodeData()), Boolean.valueOf(access$100.hasDecodeDataSuccess()), Integer.valueOf(access$100.getPlayerState())}));
            str = access$100.getPlayingFilePath();
            Logger.i("CommonPlayer", "handleMessage mFilePath = " + str);
        }
        if (str == null) {
            return;
        }
        if (access$100 != null && access$100.isCreateAudioTrackFail()) {
            Logger.w("CommonPlayer", "create audiotrack fail,EXCEPTION_TYPE_CREATAUDIOTRACK");
            CommonPlayer.access$200(commonPlayer, 92, 66);
        } else if ((CommonPlayer.access$300(commonPlayer) && access$100 != null && access$100.getPlayerState() == 5) || (access$100 != null && access$100.isInit() && !access$100.hasDecodeData())) {
            CommonPlayer.access$400(commonPlayer, 5000);
        } else if (access$100 == null || access$100.hasDecodeDataSuccess() || !CommonPlayer.access$300(commonPlayer)) {
            Logger.i("CommonPlayer", "path =" + str + ", AudioPlayer exit check");
        } else {
            try {
                CommonPlayer.access$302(commonPlayer, false);
                access$100.exitNotCallback();
                AudioType recognitionAudioFormatExactly = AudioRecognition.recognitionAudioFormatExactly(str);
                AudioType access$500 = CommonPlayer.access$500(commonPlayer);
                if (!AudioFormat.isAudioType(recognitionAudioFormatExactly) || recognitionAudioFormatExactly.equals(access$500)) {
                    Logger.w("CommonPlayer", "path =" + str + ", mAudioType = " + CommonPlayer.access$500(commonPlayer) + ",newAudioType = " + recognitionAudioFormatExactly + "recognition audio format second same with first  or is other，switch QQMediaplayer");
                    CommonPlayer.access$200(commonPlayer, 90, 101);
                    return;
                }
                CommonPlayer.access$502(commonPlayer, recognitionAudioFormatExactly);
                CommonPlayer.access$600(commonPlayer, access$100.getPlayingFilePath(), recognitionAudioFormatExactly);
                access$100.copyPlayerStatus(access$100);
                Logger.i("CommonPlayer", "recognition again, path =" + str + "recognition audio format second ,result =  " + CommonPlayer.access$500(commonPlayer) + "，init decoder again");
                commonPlayer.prepare();
            } catch (Throwable e) {
                CommonPlayer.access$200(commonPlayer, 90, 53);
                Logger.e("CommonPlayer", e);
            } catch (Throwable e2) {
                CommonPlayer.access$200(commonPlayer, 90, 90);
                Logger.e("CommonPlayer", e2);
            }
        }
    }
}
