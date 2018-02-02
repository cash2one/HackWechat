package com.tencent.liteav.network;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public class TXCRTMPDownloader extends TXIStreamDownloader {
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final String TAG;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private a mCurrentThread;
    private boolean mEnableNearestIP;
    private Handler mHandler;
    private boolean mHasTcpPlayUrl;
    private boolean mIsPlayRtmpAccStream;
    private String mPlayUrl;
    private boolean mQuicChannel;
    private Object mRTMPThreadLock;
    private String mServerIp;
    private HandlerThread mThread;
    private Vector<d> mVecPlayUrls;

    private native DownloadStats nativeGetStats(long j);

    private native long nativeInitRtmpHandler(String str, boolean z);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    private native void nativeUninitRtmpHandler(long j);

    public TXCRTMPDownloader() {
        this.TAG = "network.TXCRTMPDownloader";
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        this.mPlayUrl = "";
        this.mQuicChannel = false;
        this.mServerIp = "";
        this.mCurrentThread = null;
        this.mRTMPThreadLock = null;
        this.mThread = null;
        this.mHandler = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRTMPThreadLock = new Object();
    }

    private void startInternal() {
        if (this.mQuicChannel) {
            this.mConnectCountQuic++;
        } else {
            this.mConnectCountTcp++;
        }
        synchronized (this.mRTMPThreadLock) {
            this.mCurrentThread = new a(this, this.mPlayUrl, this.mQuicChannel);
            this.mCurrentThread.start();
        }
    }

    private void postReconnectMsg() {
        Message message = new Message();
        message.what = 101;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) (this.connectRetryInterval * 1000));
        }
    }

    private void reconnect(boolean z) {
        synchronized (this.mRTMPThreadLock) {
            if (this.mCurrentThread != null) {
                this.mCurrentThread.a();
                this.mCurrentThread = null;
            }
        }
        if (this.mIsRunning) {
            boolean z2 = this.mQuicChannel;
            if (this.mIsPlayRtmpAccStream) {
                int i;
                if (this.mEnableNearestIP) {
                    boolean z3 = z;
                } else {
                    i = 0;
                }
                if (z2) {
                    i = 1;
                }
                if (!(i == 0 || this.mVecPlayUrls == null || this.mVecPlayUrls.isEmpty())) {
                    d dVar = (d) this.mVecPlayUrls.get(0);
                    this.mVecPlayUrls.remove(0);
                    this.mPlayUrl = dVar.a;
                    this.mQuicChannel = dVar.b;
                }
            }
            if (z2 && this.mHasTcpPlayUrl) {
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                postReconnectMsg();
            } else if (this.connectRetryTimes < this.connectRetryLimit) {
                this.connectRetryTimes++;
                TXCLog.d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                postReconnectMsg();
            } else {
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
            }
        }
    }

    public void sendNotifyEvent(int i, String str) {
        if (str.isEmpty()) {
            sendNotifyEvent(i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
    }

    public void sendNotifyEvent(int i) {
        boolean z = true;
        if (i == 0 || i == 1) {
            if (i != 1) {
                z = false;
            }
            reconnect(z);
            return;
        }
        super.sendNotifyEvent(i);
    }

    public void startDownload(Vector<d> vector, boolean z, boolean z2) {
        if (!this.mIsRunning && vector != null && !vector.isEmpty()) {
            this.mIsPlayRtmpAccStream = z;
            this.mEnableNearestIP = z2;
            this.mVecPlayUrls = vector;
            this.mHasTcpPlayUrl = false;
            for (int i = 0; i < this.mVecPlayUrls.size(); i++) {
                if (!((d) this.mVecPlayUrls.elementAt(i)).b) {
                    this.mHasTcpPlayUrl = true;
                    break;
                }
            }
            d dVar = (d) this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = dVar.a;
            this.mQuicChannel = dVar.b;
            this.mIsRunning = true;
            TXCLog.d("network.TXCRTMPDownloader", "start pull with url:" + this.mPlayUrl + " quic:" + (this.mQuicChannel ? "yes" : "no"));
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("RTMP_PULL");
                this.mThread.start();
            }
            this.mHandler = new 1(this, this.mThread.getLooper());
            startInternal();
        }
    }

    public void stopDownload() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mVecPlayUrls.removeAllElements();
            this.mVecPlayUrls = null;
            this.mIsPlayRtmpAccStream = false;
            this.mEnableNearestIP = false;
            TXCLog.d("network.TXCRTMPDownloader", "stop pull");
            synchronized (this.mRTMPThreadLock) {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a();
                    this.mCurrentThread = null;
                }
            }
            if (this.mThread != null) {
                this.mThread.quit();
                this.mThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
        }
    }

    public DownloadStats getDownloadStats() {
        DownloadStats b;
        synchronized (this.mRTMPThreadLock) {
            if (this.mCurrentThread != null) {
                b = this.mCurrentThread.b();
            } else {
                b = null;
            }
        }
        return b;
    }

    public String getCurrentStreamUrl() {
        return this.mPlayUrl;
    }

    public boolean isQuicChannel() {
        return this.mQuicChannel;
    }

    public int getConnectCountQuic() {
        return this.mConnectCountQuic;
    }

    public int getConnectCountTcp() {
        return this.mConnectCountTcp;
    }
}
