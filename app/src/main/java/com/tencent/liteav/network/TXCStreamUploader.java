package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class TXCStreamUploader extends a implements b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_ERROR_ALLADDRESS_FAILED = 11011;
    public static final int TXE_UPLOAD_ERROR_NET_DISCONNECT = 11012;
    public static final int TXE_UPLOAD_ERROR_NET_RECONNECT = 11016;
    public static final int TXE_UPLOAD_ERROR_NO_DATA = 11013;
    public static final int TXE_UPLOAD_ERROR_NO_NETWORK = 11015;
    public static final int TXE_UPLOAD_ERROR_READ_FAILED = 11017;
    public static final int TXE_UPLOAD_ERROR_WRITE_FAILED = 11018;
    public static final int TXE_UPLOAD_INFO_CONNECT_FAILED = 11006;
    public static final int TXE_UPLOAD_INFO_CONNECT_SUCCESS = 11001;
    public static final int TXE_UPLOAD_INFO_HANDSHAKE_FAIL = 11005;
    public static final int TXE_UPLOAD_INFO_NET_BUSY = 11003;
    public static final int TXE_UPLOAD_INFO_PUSH_BEGIN = 11002;
    public static final int TXE_UPLOAD_INFO_SERVER_REFUSE = 11007;
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
    private final int MSG_EVENT = 102;
    private final int MSG_RECONNECT = 101;
    private final int MSG_REPORT_STATUS = 103;
    private int mChannelType = 0;
    private int mConnectCountQuic = 0;
    private int mConnectCountTcp = 0;
    private long mConnectSuccessTimeStamps = 0;
    private Context mContext = null;
    private int mCurrentRecordIdx = 0;
    private boolean mEnableNearestIP = true;
    private long mGoodPushTime = 30000;
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private c mIntelligentRoute = null;
    private ArrayList<a> mIpList = null;
    private boolean mIsPushing = false;
    private int mLastNetworkType = 255;
    private long mLastTimeStamp = 0;
    private UploadStats mLastUploadStats = null;
    private com.tencent.liteav.basic.c.a mNotifyListener = null;
    private g mParam = null;
    private long mPushStartTS = 0;
    private boolean mQuicChannel = false;
    private int mRetryCount = 0;
    private String mRtmpUrl = "";
    private Thread mThread = null;
    private Object mThreadLock = null;
    private long mUploaderInstance = 0;
    private Vector<b> mVecPendingNAL = new Vector();

    private native void nativeEnableDrop(long j, boolean z);

    private native UploadStats nativeGetStats(long j);

    private native long nativeInitUploader(String str, String str2, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native void nativeOnThreadRun(long j);

    private native void nativePushAAC(long j, byte[] bArr, long j2);

    private native void nativePushNAL(long j, byte[] bArr, int i, long j2, long j3, long j4);

    private native void nativeSetSendStrategy(long j, int i);

    private native void nativeSetVideoDropParams(long j, boolean z, int i, int i2);

    private native void nativeStopPush(long j);

    private native void nativeUninitUploader(long j);

    static {
        com.tencent.liteav.basic.util.a.d();
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = aVar;
    }

    public TXCStreamUploader(Context context, g gVar) {
        this.mContext = context;
        if (gVar == null) {
            gVar = new g();
            gVar.a = 0;
            gVar.g = 3;
            gVar.f = 3;
            gVar.h = 40;
            gVar.i = 1000;
            gVar.j = true;
        }
        this.mParam = gVar;
        this.mThreadLock = new Object();
        this.mIntelligentRoute = new c();
        this.mIntelligentRoute.a = this;
        this.mUploaderInstance = 0;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 255;
        this.mHandlerThread = null;
    }

    public void setRetryInterval(int i) {
        if (this.mParam != null) {
            this.mParam.g = i;
        }
    }

    public void setAudioInfo(int i, int i2) {
        if (this.mParam != null) {
            this.mParam.d = i2;
            this.mParam.e = i;
        }
    }

    public void setRetryTimes(int i) {
        if (this.mParam != null) {
            this.mParam.f = i;
        }
    }

    public void setMode(int i) {
        if (this.mParam != null) {
            this.mParam.a = i;
        }
    }

    private void postReconnectMsg(String str, boolean z, int i) {
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        message.arg1 = z ? 2 : 1;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) i);
        }
    }

    public void onFetchDone(int i, ArrayList<a> arrayList) {
        if (this.mIsPushing) {
            if (arrayList != null) {
                TXCLog.e(TAG, "onFetchDone: code = " + i + " ip count = " + arrayList.size());
                if (i == 0) {
                    this.mIpList = arrayList;
                    this.mCurrentRecordIdx = 0;
                }
            }
            if (this.mIpList != null && this.mIpList.size() > 0) {
                Iterator it = this.mIpList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    int i3;
                    a aVar = (a) it.next();
                    if (aVar == null || !aVar.c || aVar.a == null || aVar.a.length() <= 0) {
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                }
                setStatusValue(7016, Long.valueOf((long) i2));
            }
            a rtmpRealConnectInfo = getRtmpRealConnectInfo();
            postReconnectMsg(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, 0);
        }
    }

    public int init() {
        return 0;
    }

    public void start(String str, boolean z, int i) {
        if (!this.mIsPushing) {
            this.mIsPushing = true;
            this.mConnectSuccessTimeStamps = 0;
            this.mRetryCount = 0;
            this.mRtmpUrl = str;
            this.mChannelType = i;
            this.mPushStartTS = 0;
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            setStatusValue(7016, Long.valueOf(0));
            setStatusValue(7017, Long.valueOf(0));
            setStatusValue(7018, Long.valueOf(0));
            TXCLog.d(TAG, "start push with url:" + this.mRtmpUrl + " enable nearest ip:" + (z ? "yes" : "no") + "channel type:" + i);
            if (com.tencent.liteav.basic.util.a.c(this.mContext) == 255) {
                sendNotifyEvent(TXE_UPLOAD_ERROR_NO_NETWORK);
                return;
            }
            this.mEnableNearestIP = z;
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("RTMP_PUSH");
                this.mHandlerThread.start();
            }
            this.mHandler = new 1(this, this.mHandlerThread.getLooper());
            if (!this.mEnableNearestIP || this.mLastNetworkType == com.tencent.liteav.basic.util.a.c(this.mContext)) {
                startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            } else {
                TXCLog.d(TAG, "fetching nearest ip list");
                this.mIntelligentRoute.a(str, i);
            }
            this.mHandler.sendEmptyMessageDelayed(103, 2000);
        }
    }

    public void stop() {
        if (this.mIsPushing) {
            this.mIsPushing = false;
            TXCLog.d(TAG, "stop push");
            synchronized (this.mThreadLock) {
                nativeStopPush(this.mUploaderInstance);
                this.mPushStartTS = 0;
            }
            if (this.mHandlerThread != null) {
                this.mHandlerThread.getLooper().quit();
                this.mHandlerThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
        }
    }

    private void tryResetRetryCount() {
        if (this.mConnectSuccessTimeStamps != 0 && TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > ((long) ((this.mParam.f * (this.mParam.g + 13)) * 1000))) {
            this.mRetryCount = 0;
            this.mConnectSuccessTimeStamps = 0;
            TXCLog.d(TAG, "reset retry count");
        }
    }

    public void pushAAC(byte[] bArr, long j) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (this.mPushStartTS == 0) {
                this.mPushStartTS = j - 3600000;
            }
            nativePushAAC(this.mUploaderInstance, bArr, j - this.mPushStartTS);
        }
    }

    public void pushNAL(b bVar) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance != 0) {
                if (this.mPushStartTS == 0) {
                    this.mPushStartTS = bVar.h - 3600000;
                }
                if (!(bVar == null || bVar.a == null || bVar.a.length <= 0)) {
                    nativePushNAL(this.mUploaderInstance, bVar.a, bVar.b, bVar.e, bVar.g - this.mPushStartTS, bVar.h - this.mPushStartTS);
                }
            } else {
                if (bVar.b == 0) {
                    this.mVecPendingNAL.removeAllElements();
                }
                this.mVecPendingNAL.add(bVar);
            }
        }
    }

    public void setDropEanble(boolean z) {
        TXCLog.d(TAG, "drop enable " + (z ? "yes" : "no"));
        synchronized (this.mThreadLock) {
            nativeEnableDrop(this.mUploaderInstance, z);
        }
    }

    public void setVideoDropParams(boolean z, int i, int i2) {
        TXCLog.d(TAG, "drop params wait i frame:" + (z ? "yes" : "no") + " max video count:" + i + " max video cache time: " + i2 + " ms");
        synchronized (this.mThreadLock) {
            this.mParam.j = z;
            this.mParam.h = i;
            this.mParam.i = i2;
            if (this.mUploaderInstance != 0) {
                nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
            }
        }
    }

    public void setSendStrategy(boolean z) {
        if (this.mParam.m != z) {
            synchronized (this.mThreadLock) {
                long j = this.mUploaderInstance;
                int i = this.mParam.m ? this.mQuicChannel ? 3 : 2 : 1;
                nativeSetSendStrategy(j, i);
            }
        }
        this.mParam.m = z;
    }

    public UploadStats getUploadStats() {
        UploadStats nativeGetStats;
        synchronized (this.mThreadLock) {
            nativeGetStats = nativeGetStats(this.mUploaderInstance);
            if (nativeGetStats != null) {
                nativeGetStats.channelType = this.mQuicChannel ? 2 : 1;
            }
        }
        return nativeGetStats;
    }

    private void startPushTask(String str, boolean z, int i) {
        TXCLog.d(TAG, "start push task");
        if (this.mQuicChannel != z && this.mQuicChannel) {
            TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.M, "switch video push channel from quic to tcp", "limits:" + this.mParam.f + " current:" + this.mRetryCount);
        }
        int i2;
        if (z) {
            i2 = this.mConnectCountQuic + 1;
            this.mConnectCountQuic = i2;
            setStatusValue(7017, Long.valueOf((long) i2));
        } else {
            i2 = this.mConnectCountTcp + 1;
            this.mConnectCountTcp = i2;
            setStatusValue(7018, Long.valueOf((long) i2));
        }
        this.mThread = new 2(this, "RTMPUpload", z, str);
        this.mThread.start();
    }

    private void stopPushTask() {
        TXCLog.d(TAG, "stop push task");
        synchronized (this.mThreadLock) {
            this.mVecPendingNAL.removeAllElements();
            nativeStopPush(this.mUploaderInstance);
        }
    }

    private a getRtmpRealConnectInfo() {
        int i = 1;
        if (!this.mEnableNearestIP) {
            return new a(this, this.mRtmpUrl, false);
        }
        if (this.mIpList == null) {
            return new a(this, this.mRtmpUrl, false);
        }
        if (this.mCurrentRecordIdx >= this.mIpList.size() || this.mCurrentRecordIdx < 0) {
            return new a(this, this.mRtmpUrl, false);
        }
        a aVar = (a) this.mIpList.get(this.mCurrentRecordIdx);
        String[] split = this.mRtmpUrl.split("://");
        if (split.length < 2) {
            return new a(this, this.mRtmpUrl, false);
        }
        String[] split2 = split[1].split("/");
        split2[0] = aVar.a + ":" + aVar.b;
        StringBuilder stringBuilder = new StringBuilder(split2[0]);
        while (i < split2.length) {
            stringBuilder.append("/");
            stringBuilder.append(split2[i]);
            i++;
        }
        return new a(this, split[0] + "://" + stringBuilder.toString(), aVar.c);
    }

    private boolean nextRecordIdx(boolean z) {
        if (this.mIpList == null || this.mIpList.size() == 0) {
            return false;
        }
        if (z) {
            a aVar = (a) this.mIpList.get(this.mCurrentRecordIdx);
            aVar.d++;
        }
        if (this.mCurrentRecordIdx >= this.mIpList.size()) {
            return false;
        }
        this.mCurrentRecordIdx++;
        if (this.mCurrentRecordIdx != this.mIpList.size()) {
            return true;
        }
        this.mCurrentRecordIdx = 0;
        return false;
    }

    private void reconnect(boolean z) {
        stopPushTask();
        if (!this.mEnableNearestIP || this.mLastNetworkType == com.tencent.liteav.basic.util.a.c(this.mContext)) {
            if (!this.mEnableNearestIP) {
                z = false;
            }
            if (this.mQuicChannel) {
                z = true;
            }
            TXCLog.e(TAG, "reconnect change ip: " + z + " enableNearestIP: " + this.mEnableNearestIP + " last channel type: " + (this.mQuicChannel ? "Q Channel" : "TCP"));
            if (!z || nextRecordIdx(true)) {
                a rtmpRealConnectInfo = getRtmpRealConnectInfo();
                if (this.mQuicChannel) {
                    TXCLog.e(TAG, "reconnect last channel type is Q Channel,  invoke reconnect " + this.mParam.g + "s after");
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server", "reconnect last channel type is Q Channel,  invoke reconnect " + this.mParam.g + "s after");
                    postReconnectMsg(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, this.mParam.g * 1000);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    return;
                }
                TXCLog.e(TAG, "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f + " invoke reconnect " + this.mParam.g + "s after");
                if (this.mRetryCount < this.mParam.f) {
                    this.mRetryCount++;
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f + " invoke reconnect " + this.mParam.g + "s after");
                    postReconnectMsg(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, this.mParam.g * 1000);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    return;
                }
                TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all times");
                sendNotifyEvent(TXE_UPLOAD_ERROR_NET_DISCONNECT);
                return;
            }
            TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all addresses");
            sendNotifyEvent(TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
            return;
        }
        TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.a.c(this.mContext));
        this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
        this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
        this.mRetryCount = 0;
    }

    private void sendNotifyEvent(int i, String str) {
        if (str.isEmpty()) {
            sendNotifyEvent(i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        switch (i) {
            case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                i = 3002;
                break;
            case TXE_UPLOAD_ERROR_READ_FAILED /*11017*/:
                i = 3005;
                break;
            case TXE_UPLOAD_ERROR_WRITE_FAILED /*11018*/:
                i = 3005;
                break;
        }
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
    }

    private void sendNotifyEvent(int i) {
        if (i == 0) {
            reconnect(false);
        } else if (i == 1) {
            reconnect(true);
        } else {
            if (i == TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
                this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
            }
            if (this.mNotifyListener != null) {
                Bundle bundle = new Bundle();
                switch (i) {
                    case TXE_UPLOAD_INFO_CONNECT_SUCCESS /*11001*/:
                        i = 1001;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "已经连接rtmp服务器");
                        break;
                    case TXE_UPLOAD_INFO_PUSH_BEGIN /*11002*/:
                        i = 1002;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "rtmp开始推流");
                        break;
                    case TXE_UPLOAD_INFO_NET_BUSY /*11003*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "上行带宽不足，数据发送不及时");
                        i = TXLiveConstants.PUSH_WARNING_NET_BUSY;
                        break;
                    case TXE_UPLOAD_INFO_HANDSHAKE_FAIL /*11005*/:
                        i = 3003;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                        break;
                    case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                        i = 3002;
                        break;
                    case TXE_UPLOAD_INFO_SERVER_REFUSE /*11007*/:
                        i = TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求，可能是该推流地址已经被占用");
                        break;
                    case TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "所有IP都已经尝试失败,可以放弃治疗");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NET_DISCONNECT /*11012*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "经连续多次重连失败，放弃重连");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "超过30s没有数据发送，主动断开连接");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "没有网络，请检测WiFi或移动数据是否开启");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NET_RECONNECT /*11016*/:
                        i = TXLiveConstants.PUSH_WARNING_RECONNECT;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                        break;
                    default:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN");
                        break;
                }
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                if (this.mNotifyListener != null) {
                    this.mNotifyListener.onNotifyEvent(i, bundle);
                }
            }
        }
    }

    private void reportNetStatus() {
        long timeTick = TXCTimeUtil.getTimeTick();
        long j = timeTick - this.mLastTimeStamp;
        UploadStats uploadStats = getUploadStats();
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        if (uploadStats != null) {
            if (this.mLastUploadStats != null) {
                long longValue = getSpeed(this.mLastUploadStats.inVideoBytes, uploadStats.inVideoBytes, j).longValue();
                long longValue2 = getSpeed(this.mLastUploadStats.inAudioBytes, uploadStats.inAudioBytes, j).longValue();
                long longValue3 = getSpeed(this.mLastUploadStats.outVideoBytes, uploadStats.outVideoBytes, j).longValue();
                j4 = getSpeed(this.mLastUploadStats.outAudioBytes, uploadStats.outAudioBytes, j).longValue();
                j3 = longValue3;
                j2 = longValue2;
                j = longValue;
            } else {
                j = 0;
            }
            setStatusValue(7001, Long.valueOf(j));
            setStatusValue(7002, Long.valueOf(j2));
            setStatusValue(7003, Long.valueOf(j3));
            setStatusValue(7004, Long.valueOf(j4));
            setStatusValue(7005, Long.valueOf(uploadStats.videoCacheLen));
            setStatusValue(7006, Long.valueOf(uploadStats.audioCacheLen));
            setStatusValue(7007, Long.valueOf(uploadStats.videoDropCount));
            setStatusValue(7008, Long.valueOf(uploadStats.audioDropCount));
            setStatusValue(7009, Long.valueOf(uploadStats.startTS));
            setStatusValue(7010, Long.valueOf(uploadStats.dnsTS));
            setStatusValue(7011, Long.valueOf(uploadStats.connTS));
            setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            setStatusValue(7013, Long.valueOf(this.mQuicChannel ? 2 : 1));
            setStatusValue(7014, uploadStats.connectionID);
            setStatusValue(7015, uploadStats.connectionStats);
        }
        this.mLastTimeStamp = timeTick;
        this.mLastUploadStats = uploadStats;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(103, 2000);
        }
    }

    private Long getSpeed(long j, long j2, long j3) {
        long j4 = 0;
        if (j <= j2) {
            j2 -= j;
        }
        if (j3 > 0) {
            j4 = ((8 * j2) * 1000) / (1024 * j3);
        }
        return Long.valueOf(j4);
    }
}
