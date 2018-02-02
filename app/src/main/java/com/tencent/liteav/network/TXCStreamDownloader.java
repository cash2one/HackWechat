package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public class TXCStreamDownloader extends a implements com.tencent.liteav.basic.c.a, e {
    public static final String TAG = "TXCStreamDownloader";
    public static final int TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED = 12031;
    public static final int TXE_DOWNLOAD_ERROR_CONNECT_FAILED = 12011;
    public static final int TXE_DOWNLOAD_ERROR_DISCONNECT = 12012;
    public static final int TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL = 12030;
    public static final int TXE_DOWNLOAD_ERROR_NET_RECONNECT = 12015;
    public static final int TXE_DOWNLOAD_ERROR_READ_FAILED = 12013;
    public static final int TXE_DOWNLOAD_ERROR_WRITE_FAILED = 12014;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_END = 12007;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_FAILED = 12004;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_SUCCESS = 12001;
    public static final int TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL = 12005;
    public static final int TXE_DOWNLOAD_INFO_PLAY_BEGIN = 12008;
    public static final int TXE_DOWNLOAD_INFO_SERVER_REFUSE = 12009;
    private f mAccUrlFetcher;
    private Context mApplicationContext;
    private int mDownloadFormat = 1;
    private TXIStreamDownloader mDownloader = null;
    private boolean mDownloaderRunning = false;
    private Handler mHandler = null;
    private DownloadStats mLastDownloadStats = null;
    private long mLastTimeStamp = 0;
    private e mListener = null;
    private byte[] mListenerLock = new byte[0];
    private com.tencent.liteav.basic.c.a mNotifyListener = null;
    private boolean mRecvFirstNal = false;
    private Runnable mReportNetStatusRunnalbe = new 2(this);

    public void onNotifyEvent(int i, Bundle bundle) {
        int i2 = 3002;
        synchronized (this.mListenerLock) {
            if (this.mNotifyListener != null) {
                Bundle bundle2 = new Bundle();
                switch (i) {
                    case TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "已连接服务器");
                        i2 = 2001;
                        break;
                    case TXE_DOWNLOAD_INFO_CONNECT_FAILED /*12004*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                        break;
                    case TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL /*12005*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                        i2 = 3003;
                        break;
                    case TXE_DOWNLOAD_INFO_CONNECT_END /*12007*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接结束");
                        i2 = i;
                        break;
                    case TXE_DOWNLOAD_INFO_PLAY_BEGIN /*12008*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "开始拉流");
                        i2 = 2002;
                        break;
                    case TXE_DOWNLOAD_INFO_SERVER_REFUSE /*12009*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求");
                        i2 = TXLiveConstants.PLAY_WARNING_RECONNECT;
                        break;
                    case TXE_DOWNLOAD_ERROR_CONNECT_FAILED /*12011*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                        break;
                    case TXE_DOWNLOAD_ERROR_DISCONNECT /*12012*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "经多次自动重连失败，放弃连接");
                        i2 = TXLiveConstants.PLAY_ERR_NET_DISCONNECT;
                        break;
                    case TXE_DOWNLOAD_ERROR_READ_FAILED /*12013*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "读数据错误，网络连接断开");
                        i2 = 3005;
                        break;
                    case TXE_DOWNLOAD_ERROR_WRITE_FAILED /*12014*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "写数据错误，网络连接断开");
                        i2 = 3005;
                        break;
                    case TXE_DOWNLOAD_ERROR_NET_RECONNECT /*12015*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                        i2 = TXLiveConstants.PLAY_WARNING_RECONNECT;
                        break;
                    case TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL /*12030*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "获取加速拉流地址失败");
                        i2 = TXLiveConstants.PLAY_ERR_GET_RTMP_ACC_URL_FAIL;
                        break;
                    case TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED /*12031*/:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "所有拉流地址尝试失败,可以放弃治疗");
                        i2 = TXLiveConstants.PLAY_ERR_NET_DISCONNECT;
                        break;
                    default:
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN event = " + i);
                        i2 = i;
                        break;
                }
                String str = "";
                if (bundle != null) {
                    str = bundle.getString(TXLiveConstants.EVT_DESCRIPTION, "");
                }
                if (!(str == null || str.isEmpty())) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, str);
                }
                bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                this.mNotifyListener.onNotifyEvent(i2, bundle2);
            }
        }
        if (i == TXE_DOWNLOAD_INFO_CONNECT_SUCCESS) {
            reportNetStatusInternal();
        }
    }

    private void tryResetRetryCount() {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryTimes = 0;
        }
    }

    public void onPullAudio(com.tencent.liteav.basic.f.a aVar) {
        tryResetRetryCount();
        synchronized (this.mListenerLock) {
            if (this.mListener != null) {
                this.mListener.onPullAudio(aVar);
            }
        }
    }

    public void onPullNAL(b bVar) {
        tryResetRetryCount();
        if (!this.mRecvFirstNal) {
            reportNetStatusInternal();
            this.mRecvFirstNal = true;
        }
        synchronized (this.mListenerLock) {
            if (this.mListener != null) {
                this.mListener.onPullNAL(bVar);
            }
        }
    }

    public void setListener(e eVar) {
        synchronized (this.mListenerLock) {
            this.mListener = eVar;
        }
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        synchronized (this.mListenerLock) {
            this.mNotifyListener = aVar;
        }
    }

    static {
        com.tencent.liteav.basic.util.a.d();
    }

    public TXCStreamDownloader(Context context, int i, int i2) {
        if (i2 == 0) {
            this.mDownloader = new TXCFLVDownloader();
        } else if (i2 == 1 || i2 == 4) {
            this.mDownloader = new TXCRTMPDownloader();
        }
        if (this.mDownloader != null) {
            this.mDownloader.setListener(this);
            this.mDownloader.setNotifyListener(this);
        }
        this.mDownloadFormat = i2;
        this.mAccUrlFetcher = new f(context);
        this.mApplicationContext = context;
        if (this.mApplicationContext != null) {
            this.mHandler = new Handler(this.mApplicationContext.getMainLooper());
        }
    }

    public void setRetryTimes(int i) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryLimit = i;
        }
    }

    public void setRetryInterval(int i) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryInterval = i;
        }
    }

    public int start(String str, boolean z, int i) {
        boolean z2 = true;
        this.mDownloaderRunning = true;
        this.mRecvFirstNal = false;
        setStatusValue(7116, Long.valueOf(0));
        setStatusValue(7117, Long.valueOf(0));
        setStatusValue(7118, Long.valueOf(0));
        if (z && this.mDownloadFormat == 4) {
            int a = this.mAccUrlFetcher.a(str, i, new 1(this, str));
            if (a != 0) {
                if (a == -1) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.as, a, "invalid playUrl");
                } else if (a == -2) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.as, a, "invalid streamID");
                } else if (a == -3) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.as, a, "invalid signature");
                }
                TXCLog.e(TAG, "getAccelerateStreamPlayUrl failed, result = " + a + ", play stream with raw url");
                playStreamWithRawUrl(str);
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
                }
            }
        } else if (this.mDownloader != null) {
            setStatusValue(7112, Long.valueOf(1));
            Vector vector = new Vector();
            vector.add(new d(str, false));
            TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
            if (this.mDownloadFormat != 4) {
                z2 = false;
            }
            tXIStreamDownloader.startDownload(vector, z2, z);
            if (this.mHandler != null) {
                this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
            }
        }
        return 0;
    }

    private void playStreamWithRawUrl(String str) {
        if (this.mDownloader != null) {
            if (str != null && ((str.startsWith("http://") || str.startsWith("https://")) && str.contains(".flv"))) {
                int i = this.mDownloader.connectRetryLimit;
                int i2 = this.mDownloader.connectRetryInterval;
                this.mDownloader = null;
                this.mDownloader = new TXCFLVDownloader();
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.connectRetryLimit = i;
                this.mDownloader.connectRetryInterval = i2;
            }
            setStatusValue(7112, Long.valueOf(1));
            Vector vector = new Vector();
            vector.add(new d(str, false));
            this.mDownloader.startDownload(vector, false, false);
        }
    }

    public void stop() {
        this.mDownloaderRunning = false;
        this.mRecvFirstNal = false;
        if (this.mDownloader != null) {
            this.mDownloader.stopDownload();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mReportNetStatusRunnalbe);
        }
    }

    public DownloadStats getDownloadStats() {
        if (this.mDownloader != null) {
            return this.mDownloader.getDownloadStats();
        }
        return null;
    }

    public a getRealTimeStreamInfo() {
        a aVar = new a();
        if (this.mAccUrlFetcher != null) {
            aVar.b = this.mAccUrlFetcher.a();
            aVar.c = this.mAccUrlFetcher.b();
            aVar.d = this.mAccUrlFetcher.c();
            aVar.e = this.mAccUrlFetcher.d();
        }
        if (this.mDownloader != null) {
            aVar.a = this.mDownloader.getCurrentStreamUrl();
            aVar.f = this.mDownloader.isQuicChannel();
        }
        return aVar;
    }

    private void reportNetStatus() {
        reportNetStatusInternal();
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
    }

    private void reportNetStatusInternal() {
        long j = 0;
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = timeTick - this.mLastTimeStamp;
        DownloadStats downloadStats = getDownloadStats();
        a realTimeStreamInfo = getRealTimeStreamInfo();
        if (downloadStats != null) {
            long j3;
            if (this.mLastDownloadStats != null) {
                long longValue = getSpeed(this.mLastDownloadStats.afterParseVideoBytes, downloadStats.afterParseVideoBytes, j2).longValue();
                j = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, downloadStats.afterParseAudioBytes, j2).longValue();
                j3 = longValue;
            } else {
                j3 = 0;
            }
            setStatusValue(7101, Long.valueOf(j3));
            setStatusValue(7102, Long.valueOf(j));
            setStatusValue(7103, Long.valueOf(downloadStats.firstVideoTS));
            setStatusValue(7104, Long.valueOf(downloadStats.firstAudioTS));
            if (realTimeStreamInfo != null) {
                setStatusValue(7105, Long.valueOf((long) realTimeStreamInfo.d));
                setStatusValue(7106, realTimeStreamInfo.e);
                setStatusValue(7111, Long.valueOf(realTimeStreamInfo.f ? 2 : 1));
                setStatusValue(7113, realTimeStreamInfo.a);
                setStatusValue(7114, realTimeStreamInfo.b);
                setStatusValue(7115, realTimeStreamInfo.c);
            }
            setStatusValue(7107, Long.valueOf(downloadStats.startTS));
            setStatusValue(7108, Long.valueOf(downloadStats.dnsTS));
            setStatusValue(7109, Long.valueOf(downloadStats.connTS));
            setStatusValue(7110, String.valueOf(downloadStats.serverIP));
        }
        if (this.mDownloader != null) {
            int connectCountQuic = this.mDownloader.getConnectCountQuic();
            int connectCountTcp = this.mDownloader.getConnectCountTcp();
            setStatusValue(7117, Long.valueOf((long) (connectCountQuic + 1)));
            setStatusValue(7118, Long.valueOf((long) (connectCountTcp + 1)));
        }
        this.mLastTimeStamp = timeTick;
        this.mLastDownloadStats = downloadStats;
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
