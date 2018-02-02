package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource$Factory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URL;

public class CommonPlayer extends BaseMediaPlayer implements PlayerException {
    private static final int INIT_STATE_CHECK_TIME = 5000;
    private static final String TAG = "CommonPlayer";
    private PlayerCallback callback = new 1(this);
    private final StateRunner<Integer> currentState = new StateRunner(Integer.valueOf(0));
    private CorePlayer mAudioPlayer = null;
    private AudioType mAudioType = AudioType.UNSUPPORT;
    private PlayerListenerCallback mCallback;
    private final Handler mCheckAudioInitSuccessHandler = new CheckAudioInitSuccessHandler(this);
    private long mDuration;
    private long mFileLength = 0;
    private boolean mRecognitionByExtensions = true;

    public CommonPlayer(PlayerListenerCallback playerListenerCallback) {
        this.mCallback = playerListenerCallback;
        reset();
    }

    public int getDuration() {
        long j = 0;
        if (this.mAudioPlayer != null) {
            this.mDuration = this.mAudioPlayer.getDuration();
            return (int) this.mDuration;
        }
        Logger.e(TAG, "getDuration() mAudioPlayer is null!");
        if (this.mDuration > 0) {
            j = this.mDuration;
        }
        return (int) j;
    }

    public int getPlayerState() {
        return ((Integer) this.currentState.get()).intValue();
    }

    public boolean isPlaying() {
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "isPlaying() mAudioPlayer is null!");
            return false;
        } else if (this.mAudioPlayer.getPlayerState() == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void pause() {
        Logger.i(TAG, auxiliary("[pause]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause();
        } else {
            Logger.e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
        TransferStateTo(5);
    }

    public void prepare() {
        TransferStateTo(3);
        Logger.i(TAG, auxiliary("[prepare]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.prepare();
        } else {
            Logger.e(TAG, "prepare() null mAudioPlayer!");
        }
    }

    public void prepareAsync() {
        throw new UnSupportMethodException("Soft decode player cannot support prepareAsync");
    }

    public void release() {
        TransferStateTo(8);
        Logger.i(TAG, auxiliary("[release]"));
        this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        } else {
            Logger.w(TAG, "release() mAudioPlayer is null!");
        }
        this.mCallback = null;
    }

    public void reset() {
        TransferStateTo(0);
        Logger.i(TAG, auxiliary("[reset]"));
        this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        }
        this.mDuration = 0;
        this.mAudioType = AudioType.UNSUPPORT;
        this.mRecognitionByExtensions = true;
        this.mFileLength = 0;
    }

    public void seekTo(int i) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.seek(i);
        } else {
            Logger.e(TAG, "seekTo() mAudioPlayer is null!");
        }
    }

    public void setDataSource(String str) {
        TransferStateTo(1);
        if (str == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            throw new NullPointerException("the path is null!");
        }
        Logger.i(TAG, "setDataSource, path: " + str);
        try {
            this.mAudioType = AudioRecognition.recognitionAudioFormatByExtensions(str);
            if (AudioFormat.isAudioType(this.mAudioType)) {
                this.mFileLength = new File(str).length();
                newCommonPlayer(str, this.mAudioType);
                this.mRecognitionByExtensions = true;
                Logger.i(TAG, "setDataSource() recognition audio format first result =  " + this.mAudioType);
            } else {
                onError(90, 55);
            }
            this.mRecognitionByExtensions = true;
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
    }

    public void setVolume(float f, float f2) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setVolume(f, f2);
        }
    }

    public void start() {
        TransferStateTo(4);
        Logger.i(TAG, auxiliary("[start]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.play();
        } else {
            Logger.e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
    }

    public void stop() {
        try {
            TransferStateTo(6);
            Logger.i(TAG, auxiliary("[stop]"));
            this.mCheckAudioInitSuccessHandler.removeCallbacksAndMessages(null);
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.stop();
            } else {
                Logger.e(TAG, "stop() mAudioPlayer is null!");
            }
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
    }

    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        this.mCallback = playerListenerCallback;
    }

    public long getCurrentPosition() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurPosition();
        }
        Logger.e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        return 0;
    }

    public void flush() {
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
        } else {
            this.mAudioPlayer.flush();
        }
    }

    public long getDecodePosition() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurPositionByDecoder();
        }
        Logger.e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        return 0;
    }

    public void setDataSource(Context context, Uri uri) {
        TransferStateTo(1);
        if (uri == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            throw new IllegalArgumentException("the path is null!");
        }
        Logger.i(TAG, "setDataSource, uri: " + uri);
        try {
            this.mAudioPlayer = new CorePlayer(new DefaultMediaHTTPService(), new URL(uri.toString()), this.callback);
            this.mAudioPlayer.setThreadName(uri.toString());
            this.mRecognitionByExtensions = false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            onError(90, 55);
        }
    }

    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) {
        TransferStateTo(1);
        if (iMediaHTTPService == null) {
            throw new IllegalArgumentException("httpService can't be null!");
        }
        Logger.i(TAG, "[setDataSource] httpService: " + iMediaHTTPService);
        try {
            this.mAudioPlayer = new CorePlayer(iMediaHTTPService, new URL(uri.toString()), this.callback);
            this.mAudioPlayer.setThreadName(uri.toString());
            this.mRecognitionByExtensions = false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            onError(90, 55);
        }
    }

    public void setDataSource(IDataSource$Factory iDataSource$Factory) {
        TransferStateTo(1);
        if (iDataSource$Factory == null) {
            Logger.e(TAG, "[setDataSource] dataSourceFactory is null!");
            throw new NullPointerException("dataSourceFactory is null!");
        }
        Logger.i(TAG, "[setDataSource] dataSourceFactory: " + iDataSource$Factory);
        try {
            IDataSource createDataSource = iDataSource$Factory.createDataSource();
            try {
                createDataSource.open();
                try {
                    this.mAudioType = createDataSource.getAudioType();
                    try {
                        this.mFileLength = createDataSource.getSize();
                    } catch (IOException e) {
                        Logger.w(TAG, "[setDataSource] failed to getSize!");
                    }
                    if (AudioFormat.isAudioType(this.mAudioType)) {
                        this.mAudioPlayer = new CorePlayer(createDataSource, this.mAudioType, this.callback);
                        this.mAudioPlayer.setFileLength(this.mFileLength);
                        this.mAudioPlayer.setThreadName(iDataSource$Factory.toString());
                        this.mRecognitionByExtensions = false;
                        Logger.i(TAG, "[setDataSource] create CorePlayer with audioType: " + this.mAudioType);
                        return;
                    }
                    onError(90, 55);
                } catch (Throwable e2) {
                    Logger.e(TAG, "[setDataSource] dataSource.getAudioType failed!", e2);
                    onError(90, 70);
                }
            } catch (Throwable e22) {
                Logger.e(TAG, "[setDataSource] failed to open dataSource!", e22);
                onError(90, 83);
            }
        } catch (Throwable e222) {
            Logger.e(TAG, "[setDataSource] failed to create java DataSource!", e222);
            onError(90, 82, e222.getErrorCode());
        }
    }

    public void setDataSource(Factory factory) {
        TransferStateTo(1);
        if (factory == null) {
            Logger.e(TAG, "[setDataSource] dataSourceFactory is null!");
            throw new NullPointerException("dataSourceFactory is null!");
        }
        Logger.i(TAG, "[setDataSource] dataSourceFactory: " + factory);
        try {
            INativeDataSource createDataSource = factory.createDataSource();
            try {
                this.mAudioType = createDataSource.getAudioType();
                if (AudioFormat.isAudioType(this.mAudioType)) {
                    this.mAudioPlayer = new CorePlayer(createDataSource, this.mAudioType, this.callback);
                    this.mAudioPlayer.setThreadName(factory.toString());
                    this.mRecognitionByExtensions = false;
                    Logger.i(TAG, "[setDataSource] create CorePlayer with audioType: " + this.mAudioType);
                    return;
                }
                onError(90, 55);
            } catch (Throwable e) {
                Logger.e(TAG, "[setDataSource] dataSource.getAudioType failed!", e);
                onError(90, 70);
            }
        } catch (Throwable e2) {
            Logger.e(TAG, "[setDataSource] failed to create native DataSource!", e2);
            onError(90, 81, e2.getErrorCode());
        }
    }

    public void setAudioStreamType(int i) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setAudioStreamType(i);
        }
    }

    public void setWakeMode(Context context, int i) {
        throw new UnSupportMethodException("Soft decode player cannot support setWakeMode");
    }

    protected void TransferStateTo(int i) {
        this.currentState.transfer(Integer.valueOf(i));
        if (this.mCallback != null) {
            this.mCallback.onStateChanged(i);
        }
        Logger.d(TAG, "TransferStateTo() CURSTATE:" + i);
    }

    public long getCurrentPositionFromFile() {
        return 0;
    }

    public AudioInformation getCurrentAudioInformation() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getCurrentAudioInformation();
        }
        return null;
    }

    public void setFileTotalLength(long j) {
        this.mFileLength = j;
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setFileLength(j);
            Logger.i(TAG, "setFileLength length = " + j);
        }
    }

    public int getSessionId() {
        if (this.mAudioPlayer != null) {
            return this.mAudioPlayer.getSessionId();
        }
        return 0;
    }

    public boolean isSoftDecoder() {
        return true;
    }

    public void addAudioListener(IAudioListener iAudioListener) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.addAudioListener(iAudioListener);
        }
    }

    public void removeAudioListener(IAudioListener iAudioListener) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.removeAudioListener(iAudioListener);
        }
    }

    public String getFilePath() {
        return this.mAudioPlayer == null ? "" : this.mAudioPlayer.getPlayingFilePath();
    }

    private void onError(int i, int i2) {
        onError(i, i2, 0);
    }

    private void onError(int i, int i2, int i3) {
        TransferStateTo(9);
        if (this.mCallback != null) {
            this.mCallback.onError(this, i, i2, i3);
        } else {
            Logger.e(TAG, "onError() mOnErrorListener is null!");
        }
    }

    private void checkPlayerAndRePlay(long j) {
        this.mCheckAudioInitSuccessHandler.removeMessages(1);
        int playerState = getPlayerState();
        if (playerState != 8 && playerState != 6 && playerState != 7 && playerState != 9) {
            this.mCheckAudioInitSuccessHandler.sendEmptyMessageDelayed(1, j);
        }
    }

    private boolean newCommonPlayer(String str, AudioType audioType) {
        if (audioType == null) {
            return false;
        }
        this.mAudioPlayer = new CorePlayer(str, audioType, this.callback);
        this.mAudioPlayer.setThreadName(str);
        this.mAudioPlayer.setFileLength(this.mFileLength);
        return true;
    }

    private String auxiliary(String str) {
        CorePlayer corePlayer = this.mAudioPlayer;
        return corePlayer == null ? "null" : "[" + corePlayer.getPlayingFilePath() + "]" + str;
    }

    public int getBufferedPercentage() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getBufferedPercentage();
        }
        return 0;
    }
}
