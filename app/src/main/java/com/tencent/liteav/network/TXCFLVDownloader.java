package com.tencent.liteav.network;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader extends TXIStreamDownloader {
    private final int CONNECT_TIMEOUT;
    private final int FLV_HEAD_SIZE;
    private final int MAX_FRAME_SIZE;
    private final int MSG_CONNECT;
    private final int MSG_DISCONNECT;
    private final int MSG_QUIT;
    private final int MSG_RECONNECT;
    private final int MSG_RECV_DATA;
    private final int MSG_RESUME;
    private final int MSG_SEEK;
    private final int READ_STREAM_SIZE;
    public final String TAG;
    private HttpURLConnection mConnection;
    private long mContentLength;
    private long mDownloadedSize;
    private long mFLVParser;
    private Handler mFlvHandler;
    private HandlerThread mFlvThread;
    private InputStream mInputStream;
    private byte[] mPacketBytes;
    private String mPlayUrl;
    private boolean mRecvData;
    private DownloadStats mStats;
    private boolean mbFirstAudio;
    private boolean mbFirstVideo;

    private native void nativeCleanData(long j);

    private native long nativeInitFlvHander(String str, int i);

    private native int nativeParseData(long j, byte[] bArr, int i);

    private native void nativeUninitFlvhander(long j);

    public TXCFLVDownloader() {
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 1048576;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = 8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mFLVParser = 0;
        this.mPlayUrl = "";
        this.mbFirstVideo = false;
        this.mbFirstAudio = false;
        this.mStats = null;
        this.mStats = new DownloadStats();
        this.mStats.afterParseAudioBytes = 0;
        this.mStats.dnsTS = 0;
        this.mStats.startTS = TXCTimeUtil.getTimeTick();
    }

    private void processMsgConnect() {
        try {
            connect();
            if (this.mFLVParser == 0) {
                this.mFLVParser = nativeInitFlvHander(this.mPlayUrl, 0);
            }
            if (this.mFlvHandler != null) {
                this.mFlvHandler.sendEmptyMessage(101);
            }
        } catch (SocketTimeoutException e) {
            TXCLog.e("network.TXCFLVDownloader", "socket timeout, reconnect");
            postReconnectMsg();
        } catch (FileNotFoundException e2) {
            TXCLog.e("network.TXCFLVDownloader", "file not found, reconnect");
            postReconnectMsg();
        } catch (Exception e3) {
            TXCLog.e("network.TXCFLVDownloader", "exception, reconnect");
            postReconnectMsg();
        } catch (Error e4) {
            TXCLog.e("network.TXCFLVDownloader", "error, reconnect");
            postReconnectMsg();
        }
    }

    private void processMsgRecvData() {
        int i = 0;
        if (this.mInputStream != null) {
            try {
                int read = this.mInputStream.read(this.mPacketBytes, 0, 1388);
                if (read > 0) {
                    this.mDownloadedSize += (long) read;
                    if (!this.mRecvData) {
                        TXCLog.w("network.TXCFLVDownloader", "flv play receive first data");
                        this.mRecvData = true;
                    }
                    if (this.mFLVParser != 0) {
                        DownloadStats downloadStats = this.mStats;
                        downloadStats.beforeParseVideoBytes += (long) read;
                        i = nativeParseData(this.mFLVParser, this.mPacketBytes, read);
                    }
                    if (i > 1048576) {
                        TXCLog.e("network.TXCFLVDownloader", "flv play parse frame: " + i + " > 1048576,sart reconnect");
                        postReconnectMsg();
                        return;
                    }
                } else if (read < 0) {
                    TXCLog.w("network.TXCFLVDownloader", "http read: " + read + " < 0, start reconnect");
                    postReconnectMsg();
                    return;
                }
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.sendEmptyMessage(101);
                }
            } catch (SocketTimeoutException e) {
                TXCLog.w("network.TXCFLVDownloader", "socket timeout start reconnect");
                postReconnectMsg();
            } catch (SocketException e2) {
                TXCLog.w("network.TXCFLVDownloader", "socket exception start reconnect");
                postReconnectMsg();
            } catch (SSLException e3) {
                TXCLog.w("network.TXCFLVDownloader", "ssl exception start reconnect");
                postReconnectMsg();
            } catch (EOFException e4) {
                TXCLog.w("network.TXCFLVDownloader", "eof exception start reconnect");
                postReconnectMsg();
            } catch (Exception e5) {
                TXCLog.e("network.TXCFLVDownloader", "exception");
                this.mInputStream = null;
                this.mConnection = null;
            } catch (Error e6) {
                TXCLog.e("network.TXCFLVDownloader", "error");
                this.mInputStream = null;
                this.mConnection = null;
            }
        }
    }

    private void processMsgDisConnect() {
        try {
            disconnect();
        } catch (Exception e) {
        }
        if (this.mFLVParser != 0) {
            nativeUninitFlvhander(this.mFLVParser);
            this.mFLVParser = 0;
        }
    }

    private void processMsgReconnect() {
        reconnect();
    }

    private void startInternal() {
        if (this.mFlvThread == null) {
            this.mFlvThread = new HandlerThread("FlvThread");
            this.mFlvThread.start();
        }
        if (this.mFlvHandler == null) {
            this.mFlvHandler = new 1(this, this.mFlvThread.getLooper());
        }
        postConnectMsg();
    }

    private void reconnect() {
        processMsgDisConnect();
        if (this.connectRetryTimes < this.connectRetryLimit) {
            this.connectRetryTimes++;
            TXCLog.d("network.TXCFLVDownloader", "reconnect retry time:" + this.connectRetryTimes + ", limit:" + this.connectRetryLimit);
            processMsgConnect();
            sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
            return;
        }
        sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
    }

    private void postReconnectMsg() {
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessageDelayed(103, (long) (this.connectRetryInterval * 1000));
        }
    }

    private void postDisconnectMsg() {
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessage(102);
        }
    }

    private void postConnectMsg() {
        this.mInputStream = null;
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        Message message = new Message();
        message.what = 100;
        message.arg1 = 0;
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendMessage(message);
        }
    }

    private void connect() {
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        this.mConnection = (HttpURLConnection) new URL(this.mPlayUrl).openConnection();
        this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
        this.mConnection.setConnectTimeout(8000);
        this.mConnection.setReadTimeout(8000);
        this.mConnection.setRequestProperty("Accept-Encoding", "identity");
        this.mConnection.setInstanceFollowRedirects(true);
        this.mConnection.connect();
        this.mInputStream = this.mConnection.getInputStream();
        this.mPacketBytes = new byte[1388];
        this.mRecvData = false;
        this.mContentLength = (long) this.mConnection.getContentLength();
        this.mDownloadedSize = 0;
        this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
        this.mStats.connTS = TXCTimeUtil.getTimeTick();
        sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
    }

    private void disconnect() {
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        if (this.mInputStream != null) {
            this.mInputStream.close();
            this.mInputStream = null;
        }
    }

    public DownloadStats getDownloadStats() {
        DownloadStats downloadStats = new DownloadStats();
        downloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
        downloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
        downloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
        downloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
        downloadStats.startTS = this.mStats.startTS;
        downloadStats.dnsTS = this.mStats.dnsTS;
        downloadStats.connTS = this.mStats.connTS;
        downloadStats.firstAudioTS = this.mStats.firstAudioTS;
        downloadStats.firstVideoTS = this.mStats.firstVideoTS;
        downloadStats.serverIP = this.mStats.serverIP;
        return downloadStats;
    }

    public void startDownload(Vector<d> vector, boolean z, boolean z2) {
        if (!this.mIsRunning && vector != null && !vector.isEmpty()) {
            this.mIsRunning = true;
            this.mPlayUrl = ((d) vector.get(0)).a;
            TXCLog.d("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
            startInternal();
        }
    }

    public void stopDownload() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            TXCLog.d("network.TXCFLVDownloader", "stop pull");
            try {
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.removeCallbacksAndMessages(null);
                    this.mFlvHandler.sendEmptyMessage(102);
                    this.mFlvHandler.sendEmptyMessage(106);
                    this.mFlvHandler = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (!this.mbFirstVideo) {
            this.mbFirstVideo = true;
            this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
            TXCLog.d("network.TXCFLVDownloader", "receive first video with ts " + this.mStats.firstVideoTS);
        }
        DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseVideoBytes += (long) bArr.length;
        super.onRecvVideoData(bArr, i, j, j2, i2);
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (!this.mbFirstAudio) {
            this.mbFirstAudio = true;
            this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
            TXCLog.d("network.TXCFLVDownloader", "receive first audio with ts " + this.mStats.firstAudioTS);
        }
        DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseAudioBytes += (long) bArr.length;
        super.onRecvAudioData(bArr, i, i2, i3);
    }
}
