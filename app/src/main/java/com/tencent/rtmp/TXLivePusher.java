package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.c;
import com.tencent.liteav.d;
import com.tencent.liteav.f;
import com.tencent.liteav.l;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.g;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

public class TXLivePusher implements a, c.a, l, com.tencent.liteav.qos.a {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final String TAG = TXLivePusher.class.getSimpleName();
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private AudioCustomProcessListener mAudioProcessListener;
    private c mCaptureAndEnc = null;
    private TXLivePushConfig mConfig = null;
    private Context mContext = null;
    private d mDataReport = null;
    private String mID = "";
    private ITXLivePushListener mListener = null;
    private Handler mMainHandler = null;
    private f mNewConfig = null;
    private boolean mNotifyStatus = false;
    private VideoCustomProcessListener mPreprocessListener;
    private String mPushUrl = "";
    private TXCQoS mQos = null;
    private boolean mSnapshotRunning = false;
    private TXCStreamUploader mStreamUploader = null;
    private TXCloudVideoView mTXCloudVideoView;
    private int mVideoQuality = -1;

    public TXLivePusher(Context context) {
        TXCLog.init();
        this.mNewConfig = new f();
        this.mContext = context.getApplicationContext();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mCaptureAndEnc = new c(this.mContext);
        this.mCaptureAndEnc.a(this);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.mConfig = tXLivePushConfig;
        transferConfig(tXLivePushConfig);
        applyConfig();
    }

    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mListener = iTXLivePushListener;
    }

    public int startPusher(String str) {
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        this.mPushUrl = str;
        updateId(this.mPushUrl);
        startNetworkModule();
        startEncoder();
        startQosModule();
        startDataReportModule();
        startStatusNotify();
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
        }
        return 0;
    }

    public void stopPusher() {
        TXCLog.d(TAG, "stopPush ");
        stopStatusNotify();
        stopDataReportModule();
        stopQosModule();
        stopEncoder();
        this.mNewConfig.H = false;
        stopNetworkModule();
    }

    public void pausePusher() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g();
        }
    }

    public void resumePusher() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h();
        }
    }

    public boolean isPushing() {
        if (this.mCaptureAndEnc != null) {
            return this.mCaptureAndEnc.i();
        }
        return false;
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            setConfig(this.mConfig);
            if (this.mNewConfig.E) {
                TXCLog.e(TAG, "enable pure audio push , so can not start preview!");
                return;
            }
            if (!(this.mTXCloudVideoView == tXCloudVideoView || this.mTXCloudVideoView == null)) {
                this.mTXCloudVideoView.removeVideoView();
            }
            this.mTXCloudVideoView = tXCloudVideoView;
            if (this.mCaptureAndEnc == null) {
                this.mCaptureAndEnc = new c(this.mContext);
            }
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.a(tXCloudVideoView);
        }
    }

    public void stopCameraPreview(boolean z) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(z);
        }
    }

    public void switchCamera() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.j();
        }
    }

    public boolean turnOnFlashLight(boolean z) {
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        this.mCaptureAndEnc.b(z);
        return true;
    }

    public void setMute(boolean z) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(z);
        }
    }

    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(i);
            this.mCaptureAndEnc.b(i2, i3, i4);
        }
        if (this.mConfig != null) {
            this.mConfig.mBeautyLevel = i2;
            this.mConfig.mWhiteningLevel = i3;
            this.mConfig.mRuddyLevel = i4;
        }
        return true;
    }

    public void onLogRecord(String str) {
        TXCLog.d("User", str);
    }

    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        if (this.mCaptureAndEnc == null) {
            return DownloadResult.CODE_UNDEFINED;
        }
        int i4;
        switch (i) {
            case 3:
                i4 = 1;
                break;
            case 5:
                i4 = 2;
                break;
            default:
                return DownloadResult.CODE_UNDEFINED;
        }
        return this.mCaptureAndEnc.a(bArr, i4, i2, i3);
    }

    public void sendCustomPCMData(byte[] bArr) {
        this.mCaptureAndEnc.a(bArr);
    }

    public int getMaxZoom() {
        if (this.mCaptureAndEnc == null) {
            return 0;
        }
        return this.mCaptureAndEnc.m();
    }

    public boolean setZoom(int i) {
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        return this.mCaptureAndEnc.j(i);
    }

    public boolean setMirror(boolean z) {
        if (this.mConfig != null) {
            this.mConfig.setVideoEncoderXMirror(z);
        }
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        this.mCaptureAndEnc.d(z);
        return true;
    }

    public void setExposureCompensation(float f) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(f);
        }
    }

    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(onBGMNotify);
        }
    }

    public boolean playBGM(String str) {
        return this.mCaptureAndEnc.c(str);
    }

    public boolean stopBGM() {
        return this.mCaptureAndEnc.n();
    }

    public boolean pauseBGM() {
        return this.mCaptureAndEnc.o();
    }

    public boolean resumeBGM() {
        return this.mCaptureAndEnc.p();
    }

    public boolean setMicVolume(float f) {
        return this.mCaptureAndEnc.c(f);
    }

    public boolean setBGMVolume(float f) {
        return this.mCaptureAndEnc.d(f);
    }

    public int getMusicDuration(String str) {
        return this.mCaptureAndEnc.d(str);
    }

    public void startScreenCapture() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.k();
        }
    }

    public void stopScreenCapture() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.l();
        }
    }

    public void setRenderRotation(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(i);
        }
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        this.mPreprocessListener = videoCustomProcessListener;
        if (this.mPreprocessListener == null) {
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.a(null);
            }
        } else if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(this);
        }
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        this.mAudioProcessListener = audioCustomProcessListener;
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        if (!this.mSnapshotRunning && iTXSnapshotListener != null) {
            this.mSnapshotRunning = true;
            com.tencent.liteav.renderer.d dVar = null;
            if (this.mTXCloudVideoView != null) {
                dVar = this.mTXCloudVideoView.getGLSurfaceView();
            }
            if (dVar != null) {
                dVar.a(new 1(this, iTXSnapshotListener));
            } else {
                this.mSnapshotRunning = false;
            }
        }
    }

    private void postBitmapToMainThread(ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new 2(this, iTXSnapshotListener, bitmap));
        }
    }

    public void setFilter(Bitmap bitmap) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(bitmap);
        }
    }

    private void setSharpenLevel(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(i);
        }
    }

    public void setMotionTmpl(String str) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(str);
        }
    }

    @TargetApi(18)
    public boolean setGreenScreenFile(String str) {
        if (this.mCaptureAndEnc != null) {
            return this.mCaptureAndEnc.b(str);
        }
        return false;
    }

    public void setEyeScaleLevel(int i) {
        if (this.mConfig != null) {
            this.mConfig.setEyeScaleLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.d(i);
        }
    }

    public void setFaceSlimLevel(int i) {
        if (this.mConfig != null) {
            this.mConfig.setFaceSlimLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.e(i);
        }
    }

    public void setFaceVLevel(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.f(i);
        }
    }

    public void setSpecialRatio(float f) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(f);
        }
    }

    public void setFaceShortLevel(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g(i);
        }
    }

    public void setChinLevel(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h(i);
        }
    }

    public void setNoseSlimLevel(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.i(i);
        }
    }

    private void setAdjustStrategy(boolean z, boolean z2) {
        int adjustStrategy = getAdjustStrategy(z, z2);
        if (adjustStrategy == -1) {
            this.mConfig.setAutoAdjustBitrate(false);
            this.mConfig.setAutoAdjustStrategy(-1);
            return;
        }
        this.mConfig.setAutoAdjustBitrate(true);
        this.mConfig.setAutoAdjustStrategy(adjustStrategy);
    }

    private int getAdjustStrategy(boolean z, boolean z2) {
        if (!z) {
            return -1;
        }
        if (z2) {
            return 1;
        }
        return 0;
    }

    public void setVideoQuality(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = false;
        int i2 = 1;
        if (VERSION.SDK_INT < 18 && (i == 2 || i == 3)) {
            i = 1;
        }
        if (this.mConfig == null) {
            this.mConfig = new TXLivePushConfig();
        }
        this.mConfig.setVideoFPS(20);
        switch (i) {
            case 1:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(301);
                this.mConfig.setVideoBitrate(800);
                this.mConfig.setMaxVideoBitrate(800);
                z3 = false;
                break;
            case 2:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(1);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(600);
                this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                this.mConfig.setMaxVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                z3 = false;
                break;
            case 3:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(2);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(600);
                this.mConfig.setVideoBitrate(1800);
                this.mConfig.setMaxVideoBitrate(1800);
                z3 = false;
                break;
            case 4:
                if (VERSION.SDK_INT < 18) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(0);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(301);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 1) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(301);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 3) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(2);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(600);
                    this.mConfig.setVideoBitrate(1800);
                    this.mConfig.setMaxVideoBitrate(1800);
                } else {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(1);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(600);
                    this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                    this.mConfig.setMaxVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                }
                this.mConfig.setAudioSampleRate(48000);
                z3 = true;
                break;
            case 5:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(6);
                this.mConfig.setAutoAdjustBitrate(false);
                this.mConfig.setVideoBitrate(350);
                this.mConfig.setAudioSampleRate(48000);
                z3 = true;
                break;
            case 6:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(16000);
                this.mConfig.setAutoAdjustBitrate(true);
                this.mConfig.setAutoAdjustStrategy(5);
                this.mConfig.setMinVideoBitrate(190);
                this.mConfig.setVideoBitrate(400);
                this.mConfig.setMaxVideoBitrate(810);
                z3 = true;
                break;
            default:
                this.mConfig.setHardwareAcceleration(2);
                TXCLog.e(TAG, "setVideoPushQuality: invalid quality " + i);
                return;
        }
        this.mVideoQuality = i;
        TXLivePushConfig tXLivePushConfig = this.mConfig;
        if (!z3) {
            z4 = true;
        }
        tXLivePushConfig.enableVideoHardEncoderMainProfile(z4);
        TXLivePushConfig tXLivePushConfig2 = this.mConfig;
        if (!z3) {
            i2 = 3;
        }
        tXLivePushConfig2.setVideoEncodeGop(i2);
        if (this.mNewConfig != null) {
            this.mNewConfig.H = z3;
        }
        setConfig(this.mConfig);
    }

    public void setReverb(int i) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.k(i);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new 3(this, bundle, i));
        }
        transferPushEvent(i, bundle);
    }

    public int onTextureCustomProcess(int i, int i2, int i3) {
        if (this.mPreprocessListener != null) {
            return this.mPreprocessListener.onTextureCustomProcess(i, i2, i3);
        }
        return 0;
    }

    public void onDetectFacePoints(float[] fArr) {
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onDetectFacePoints(fArr);
        }
    }

    public void onTextureDestoryed() {
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onTextureDestoryed();
        }
    }

    public int onGetEncoderRealBitrate() {
        return TXCStatus.d(this.mID, 4002);
    }

    public int onGetQueueInputSize() {
        int d = TXCStatus.d(this.mID, 7002);
        if (this.mNewConfig.H) {
            return d + TXCStatus.d(this.mID, 7001);
        }
        return d + TXCStatus.d(this.mID, 4002);
    }

    public int onGetQueueOutputSize() {
        if (this.mStreamUploader == null) {
            return 0;
        }
        return TXCStatus.d(this.mID, 7004) + TXCStatus.d(this.mID, 7003);
    }

    public int onGetVideoQueueMaxCount() {
        return 5;
    }

    public int onGetVideoQueueCurrentCount() {
        return TXCStatus.d(this.mID, 7005);
    }

    public int onGetVideoDropCount() {
        return TXCStatus.d(this.mID, 7007);
    }

    public void onEncoderParamsChanged(int i, int i2, int i3) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(i, i2, i3);
        }
        if (!(i2 == 0 || i3 == 0)) {
            this.mNewConfig.a = i2;
            this.mNewConfig.b = i3;
        }
        if (i != 0) {
            this.mNewConfig.c = i;
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.N, "Qos Result", "mode:" + this.mNewConfig.f + " bitrate:" + i + " videosize:" + this.mNewConfig.a + " * " + this.mNewConfig.b);
        }
    }

    public void onEnableDropStatusChanged(boolean z) {
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setDropEanble(z);
        }
    }

    public void onEncAudio(byte[] bArr, long j, int i, int i2) {
        if (this.mStreamUploader != null && bArr != null) {
            this.mStreamUploader.pushAAC(bArr, j);
        }
    }

    public void onEncVideo(b bVar) {
        if (this.mQos != null) {
            this.mQos.setHasVideo(true);
        }
        if (this.mStreamUploader != null && bVar != null && bVar.a != null) {
            this.mStreamUploader.pushNAL(bVar);
        }
    }

    public void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3) {
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j, i, i2, i3);
        }
    }

    private void updateId(String str) {
        String format = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setID(format);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(format);
        }
        if (this.mDataReport != null) {
            this.mDataReport.b(format);
        }
        this.mID = format;
    }

    private void startStatusNotify() {
        this.mNotifyStatus = true;
        if (this.mMainHandler != null) {
            this.mMainHandler.postDelayed(new 4(this), 2000);
        }
    }

    private void stopStatusNotify() {
        this.mNotifyStatus = false;
    }

    private void statusNotify() {
        int[] a = com.tencent.liteav.basic.util.a.a();
        int i = a[0] / 10;
        CharSequence charSequence = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.d(this.mID, 7004);
        int d2 = TXCStatus.d(this.mID, 7003);
        int d3 = TXCStatus.d(this.mID, 7007);
        int d4 = TXCStatus.d(this.mID, 7005);
        int d5 = TXCStatus.d(this.mID, 7006);
        CharSequence c = TXCStatus.c(this.mID, 7012);
        double e = TXCStatus.e(this.mID, 4001);
        int d6 = TXCStatus.d(this.mID, 4003);
        Bundle bundle = new Bundle();
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, d2 + d);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, (int) e);
        if (e < 1.0d) {
            e = 15.0d;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((d6 * 10) / ((int) e))) / 10.0f)) + 0.5d));
        bundle.putInt(TXLiveConstants.NET_STATUS_DROP_SIZE, d3);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, d);
        bundle.putInt(TXLiveConstants.NET_STATUS_CODEC_CACHE, d5);
        bundle.putInt(TXLiveConstants.NET_STATUS_CACHE_SIZE, d4);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, c);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, charSequence);
        if (this.mCaptureAndEnc != null) {
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.mCaptureAndEnc.d());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.mCaptureAndEnc.b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.mCaptureAndEnc.c());
        }
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setLogText(bundle, null, 0);
        }
        if (this.mListener != null) {
            this.mListener.onNetStatus(bundle);
        }
        if (this.mDataReport != null) {
            this.mDataReport.d();
        }
        if (this.mMainHandler != null && this.mNotifyStatus) {
            this.mMainHandler.postDelayed(new 5(this), 2000);
        }
    }

    private void startNetworkModule() {
        int i = 5;
        g gVar = new g();
        gVar.d = com.tencent.liteav.audio.c.a().d();
        gVar.e = com.tencent.liteav.audio.c.a().e();
        gVar.a = 0;
        gVar.c = 20;
        gVar.b = 0;
        gVar.f = 3;
        gVar.j = true;
        gVar.l = true;
        gVar.k = false;
        gVar.h = 40;
        gVar.i = 5000;
        gVar.m = this.mNewConfig.H;
        this.mStreamUploader = new TXCStreamUploader(this.mContext, gVar);
        this.mStreamUploader.setID(this.mID);
        if ((this.mNewConfig.I & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
        }
        this.mStreamUploader.setNotifyListener(this);
        this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.F, this.mNewConfig.G);
        if (this.mNewConfig.E) {
            this.mStreamUploader.setMode(1);
        }
        if (this.mNewConfig.H) {
            int i2 = this.mNewConfig.o;
            int i3 = this.mNewConfig.p;
            if (i2 >= 5) {
                i = i2;
            }
            if (i3 > 1) {
                i3 = 1;
            }
            this.mStreamUploader.setRetryInterval(i3);
            this.mStreamUploader.setRetryTimes(i);
            this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
            this.mStreamUploader.setSendStrategy(true);
            return;
        }
        this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
        this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
        this.mStreamUploader.setVideoDropParams(true, 40, 3000);
        this.mStreamUploader.setSendStrategy(false);
    }

    private void stopNetworkModule() {
        if (this.mStreamUploader != null) {
            this.mStreamUploader.stop();
            this.mStreamUploader.setNotifyListener(null);
            this.mStreamUploader = null;
        }
    }

    private void startQosModule() {
        this.mQos = new TXCQoS(true);
        this.mQos.setListener(this);
        this.mQos.setNotifyListener(this);
        this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
        this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
        this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
        this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
        if (this.mNewConfig.g) {
            this.mQos.start(2000);
        }
    }

    private void stopQosModule() {
        if (this.mQos != null) {
            this.mQos.stop();
            this.mQos.setListener(null);
            this.mQos.setNotifyListener(null);
            this.mQos = null;
        }
    }

    private void startDataReportModule() {
        this.mDataReport = new d(this.mContext);
        this.mDataReport.b(this.mID);
        this.mDataReport.a(this.mNewConfig.c);
        this.mDataReport.b(this.mNewConfig.q);
        this.mDataReport.a(this.mNewConfig.a, this.mNewConfig.b);
        this.mDataReport.a(this.mPushUrl);
        this.mDataReport.a();
    }

    private void stopDataReportModule() {
        if (this.mDataReport != null) {
            this.mDataReport.b();
            this.mDataReport = null;
        }
    }

    private void startEncoder() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(this.mID);
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.e();
        }
    }

    private void stopEncoder() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(null);
            this.mCaptureAndEnc.f();
            this.mCaptureAndEnc.a(null);
        }
    }

    private void transferConfig(TXLivePushConfig tXLivePushConfig) {
        f fVar = this.mNewConfig;
        fVar.c = tXLivePushConfig.mVideoBitrate;
        fVar.e = tXLivePushConfig.mMinVideoBitrate;
        fVar.d = tXLivePushConfig.mMaxVideoBitrate;
        fVar.f = tXLivePushConfig.mAutoAdjustStrategy;
        fVar.g = tXLivePushConfig.mAutoAdjustBitrate;
        fVar.h = tXLivePushConfig.mVideoFPS;
        fVar.i = tXLivePushConfig.mVideoEncodeGop;
        fVar.j = tXLivePushConfig.mHardwareAccel;
        fVar.k = tXLivePushConfig.mVideoResolution;
        fVar.n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile;
        fVar.q = tXLivePushConfig.mAudioSample;
        fVar.r = tXLivePushConfig.mAudioChannels;
        fVar.s = tXLivePushConfig.mEnableAec;
        fVar.w = tXLivePushConfig.mPauseFlag;
        fVar.v = tXLivePushConfig.mPauseFps;
        fVar.t = tXLivePushConfig.mPauseImg;
        fVar.u = tXLivePushConfig.mPauseTime;
        fVar.E = tXLivePushConfig.mEnablePureAudioPush;
        fVar.D = tXLivePushConfig.mTouchFocus;
        fVar.x = tXLivePushConfig.mWatermark;
        fVar.y = tXLivePushConfig.mWatermarkX;
        fVar.z = tXLivePushConfig.mWatermarkY;
        fVar.A = tXLivePushConfig.mWatermarkXF;
        fVar.B = tXLivePushConfig.mWatermarkYF;
        fVar.C = tXLivePushConfig.mWatermarkWidth;
        fVar.l = tXLivePushConfig.mHomeOrientation;
        fVar.F = tXLivePushConfig.mEnableNearestIP;
        fVar.G = tXLivePushConfig.mRtmpChannelType;
        fVar.o = tXLivePushConfig.mConnectRetryCount;
        fVar.p = tXLivePushConfig.mConnectRetryInterval;
        fVar.m = tXLivePushConfig.mFrontCamera;
        fVar.I = tXLivePushConfig.mCustomModeType;
        fVar.J = tXLivePushConfig.mVideoEncoderXMirror;
        fVar.K = tXLivePushConfig.mEnableHighResolutionCapture;
        fVar.a();
    }

    private void applyConfig() {
        int i = 5;
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(this.mNewConfig);
            if (this.mCaptureAndEnc.i()) {
                if (this.mStreamUploader != null) {
                    if (this.mNewConfig.H) {
                        int i2 = this.mNewConfig.o;
                        int i3 = this.mNewConfig.p;
                        if (i2 >= 5) {
                            i = i2;
                        }
                        if (i3 > 1) {
                            i3 = 1;
                        }
                        this.mStreamUploader.setRetryInterval(i3);
                        this.mStreamUploader.setRetryTimes(i);
                        this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
                        this.mStreamUploader.setSendStrategy(true);
                    } else {
                        this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
                        this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
                        this.mStreamUploader.setVideoDropParams(true, 40, 3000);
                        this.mStreamUploader.setSendStrategy(false);
                    }
                }
                if (this.mQos != null) {
                    this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
                    this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
                    this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
                    this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
                    this.mQos.stop();
                    if (this.mNewConfig.g) {
                        this.mQos.start(2000);
                    }
                }
            } else if ((this.mNewConfig.I & 1) != 0) {
                if (this.mStreamUploader != null) {
                    this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
                }
            } else if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
            }
        }
    }

    private void transferPushEvent(int i, Bundle bundle) {
        int i2;
        switch (i) {
            case TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT /*-1309*/:
                i2 = TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT;
                break;
            case TXLiveConstants.PUSH_ERR_NET_DISCONNECT /*-1307*/:
                i2 = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                break;
            case TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL /*-1303*/:
                i2 = TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL;
                break;
            case TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL /*-1302*/:
                i2 = TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL;
                break;
            case TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL /*-1301*/:
                i2 = TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL;
                break;
            case 1001:
                i2 = 1001;
                break;
            case 1002:
                i2 = 1002;
                break;
            case 1003:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1004;
                break;
            case 1005:
                i2 = 1005;
                break;
            case 1006:
                i2 = 1006;
                break;
            case 1007:
                i2 = 1007;
                break;
            case 1008:
                i2 = 1008;
                break;
            case TXLiveConstants.PUSH_WARNING_NET_BUSY /*1101*/:
                i2 = TXLiveConstants.PUSH_WARNING_NET_BUSY;
                break;
            case TXLiveConstants.PUSH_WARNING_RECONNECT /*1102*/:
                i2 = TXLiveConstants.PUSH_WARNING_RECONNECT;
                break;
            case TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL /*1103*/:
                i2 = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
                break;
            case TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW /*1107*/:
                i2 = TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW;
                break;
            case 3002:
                i2 = 3002;
                break;
            case 3003:
                i2 = 3003;
                break;
            case TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT /*3004*/:
                i2 = TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT;
                break;
            case 3005:
                i2 = 3005;
                break;
            default:
                TXCLog.w(TAG, "unhandled event : " + i);
                return;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new 6(this, i2, bundle));
        }
    }
}
