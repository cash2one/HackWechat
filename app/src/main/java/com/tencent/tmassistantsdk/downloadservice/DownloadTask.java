package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DownloadTask {
    public static final String TAG = "_DownloadTask";
    protected DownloadInfo mDownloadInfo = null;
    HttpClient mHttpClient = null;
    HttpGet mHttpGet = null;
    protected final byte[] mRecvBuf = new byte[Downloads.RECV_BUFFER_SIZE];
    TMAssistantFile mSaveFile;
    protected boolean mStopTask = false;
    protected final int mTaskId = GlobalUtil.getMemUUID();
    private String startDownloadNetType = "wifi";

    public DownloadTask(DownloadInfo downloadInfo) {
        this.mDownloadInfo = downloadInfo;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void cancel() {
        TMLog.i(TAG, "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
        this.mStopTask = true;
        if (this.mHttpGet != null && !this.mHttpGet.isAborted()) {
            this.mHttpGet.abort();
        }
    }

    public String getDownloadURI() {
        return this.mDownloadInfo.mURL;
    }

    public int getPriority() {
        return this.mDownloadInfo.mPriority;
    }

    public void exec(String str) {
        boolean z;
        this.startDownloadNetType = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mTaskIsRunning = true;
        this.mDownloadInfo.updateStatus(2, false);
        boolean z2 = false;
        boolean z3 = true;
        while (z3) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 0);
            createNewChunkLogInfo.UUID = this.mDownloadInfo.mUUID;
            createNewChunkLogInfo.currentRetryCnt = (byte) this.mDownloadInfo.mRetryCnt;
            createNewChunkLogInfo.requestUrl = getDownloadURI();
            if (this.mStopTask) {
                break;
            }
            String str2;
            if (z2) {
                try {
                    str2 = this.mDownloadInfo.mSecondaryUrl;
                } catch (Throwable e) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "ConnectTimeoutException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 601;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e2) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "SocketTimeoutException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e2, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 602;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e22) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "UnknownHostException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e22, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 603;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e222) {
                    if (!this.mStopTask) {
                        TMLog.i(TAG, "InterruptedException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z3 = false;
                    }
                    z3 = false;
                } catch (Throwable e2222) {
                    if (!this.mStopTask) {
                        TMLog.i(TAG, "SSLHandshakeException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e2222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION;
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z3 = false;
                    }
                    z3 = false;
                } catch (Throwable e22222) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "IOException " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e22222, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 606;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e222222) {
                    if (this.mStopTask) {
                        z3 = z2;
                        z2 = false;
                    } else {
                        TMLog.i(TAG, "StopRequestException, errCode = " + e222222.mFinalErrCode + " " + Thread.currentThread().getName());
                        x.printErrStackTrace(TAG, e222222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = e222222.mFinalErrCode;
                        if (e222222.mFinalErrCode == 703 || e222222.mFinalErrCode == 710 || e222222.mFinalErrCode == 711) {
                            z3 = z2;
                            z2 = false;
                        } else if (704 == e222222.mFinalErrCode) {
                            this.mDownloadInfo.setTotalSize(0);
                            new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName).deleteTempFile();
                            z3 = z2;
                            z2 = false;
                        } else if (705 != e222222.mFinalErrCode) {
                            z = z2;
                            z2 = shouldRetryConnect();
                            z3 = z;
                        } else if (z2 || !this.mDownloadInfo.hasRetryChance() || TextUtils.isEmpty(this.mDownloadInfo.mSecondaryUrl)) {
                            z3 = z2;
                            z2 = false;
                        } else {
                            z3 = true;
                            z2 = true;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z = z3;
                        z3 = z2;
                        z2 = z;
                    } else {
                        z = z3;
                        z3 = z2;
                        z2 = z;
                    }
                } catch (Throwable th) {
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                }
            } else {
                str2 = this.mDownloadInfo.mRequestURL;
            }
            TMLog.i(TAG, "changeUrl = " + z2);
            TMLog.i(TAG, "url = " + str2);
            this.mHttpClient = HttpClientUtil.createHttpClient();
            HttpClientUtil.setProxy(this.mHttpClient);
            this.mHttpGet = new HttpGet();
            URI uri = new URI(str2);
            this.mHttpGet.setURI(uri);
            setExtraHeaderParam(this.mHttpGet, this.mDownloadInfo.getHeaderParams());
            setRangeHeader(this.mHttpGet, createNewChunkLogInfo);
            if (uri.getScheme().equals("https")) {
                SocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                this.mHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, JsApiPauseDownloadTask.CTRL_INDEX));
            }
            TMLog.i(TAG, "start httpGet " + Thread.currentThread().getName());
            HttpResponse execute = this.mHttpClient.execute(this.mHttpGet);
            if (execute == null) {
                throw new StopRequestException(701, "response is null! " + Thread.currentThread().getName());
            }
            handleResponseCode(execute, createNewChunkLogInfo);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (this.mHttpGet != null) {
                if (!this.mHttpGet.isAborted()) {
                    this.mHttpGet.abort();
                }
                this.mHttpGet = null;
            }
            if (this.mHttpClient != null) {
                this.mHttpClient.getConnectionManager().shutdown();
                this.mHttpClient = null;
            }
            if (this.mSaveFile != null) {
                this.mSaveFile.close();
                this.mSaveFile = null;
            }
        }
        TMLog.i(TAG, "mStopTask = " + this.mStopTask + " " + Thread.currentThread().getName());
        if (this.mStopTask) {
            this.mDownloadInfo.mDownloadFailedErrCode = 0;
        } else {
            TMLog.i(TAG, "download finished, " + Thread.currentThread().getName() + ",finalstatus: " + this.mDownloadInfo.mStatus + " errCode: " + this.mDownloadInfo.mDownloadFailedErrCode);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                this.mDownloadInfo.updateStatus(4, z2);
            } else {
                this.mDownloadInfo.updateStatus(5, z2);
            }
        }
        this.mDownloadInfo.mTaskIsRunning = false;
    }

    private boolean shouldRetryConnect() {
        boolean z = false;
        if (this.mStopTask) {
            TMLog.i(TAG, "mStopTask = " + this.mStopTask);
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            if (!DownloadHelper.isNetworkConncted()) {
                int i = 0;
                while (!DownloadHelper.isNetworkConncted() && i < 5) {
                    i++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e2) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
            }
            if (!DownloadHelper.isNetworkConncted()) {
                TMLog.i(TAG, "network unconnected");
            } else if (DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") || DownloadHelper.getNetStatus().equalsIgnoreCase(this.startDownloadNetType)) {
                if (this.mDownloadInfo.hasRetryChance()) {
                    DownloadInfo downloadInfo = this.mDownloadInfo;
                    downloadInfo.mRetryCnt++;
                    this.mDownloadInfo.mRedirectCnt = 0;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
                TMLog.i(TAG, "shouldRetryConnect(" + z + "), retryCnt = " + this.mDownloadInfo.mRetryCnt);
            } else {
                TMLog.i(TAG, "not equal netType, current: " + DownloadHelper.getNetStatus() + ", startNetType: " + this.startDownloadNetType);
            }
        }
        return z;
    }

    private void onDownloadError(Throwable th) {
        if (th != null) {
            x.printErrStackTrace(TAG, th, "", new Object[0]);
        }
    }

    private void handleResponseCode(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        TMLog.i(TAG, "httpResponseCode = " + statusCode + " " + Thread.currentThread().getName());
        downloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
        downloadChunkLogInfo.responseHttpCode = statusCode;
        if (statusCode == 200 || statusCode == b.CTRL_INDEX) {
            this.mDownloadInfo.mRetryCnt = 0;
        }
        switch (statusCode) {
            case 200:
                Header[] headers = httpResponse.getHeaders("Content-Type");
                if (headers != null && headers.length > 0) {
                    if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                    } else {
                        Object value = headers[0].getValue();
                        if (TextUtils.isEmpty(value) || !value.startsWith("text")) {
                            renameApkFileName(httpResponse);
                        } else {
                            throw new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
                        }
                    }
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case b.CTRL_INDEX /*206*/:
                if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                } else {
                    renameApkFileName(httpResponse);
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case 301:
            case HardCoderJNI.SCENE_QUIT_CHATTING /*302*/:
            case 303:
            case 307:
                if (this.mDownloadInfo.mRedirectCnt > 5) {
                    TMLog.i(TAG, "mRedirectCnt = " + this.mDownloadInfo.mRedirectCnt + ",MAX_REDIRESTS = 5");
                    throw new StopRequestException(709, "Redirect cnt many times.");
                }
                Header firstHeader = httpResponse.getFirstHeader("location");
                if (firstHeader != null) {
                    String value2 = firstHeader.getValue();
                    TMLog.i(TAG, "jumpURL = " + value2);
                    if (DownloadHelper.isValidURL(value2)) {
                        this.mDownloadInfo.mRequestURL = DownloadHelper.correctURL(value2);
                        DownloadInfo downloadInfo = this.mDownloadInfo;
                        downloadInfo.mRedirectCnt++;
                        return;
                    }
                    throw new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + statusCode + " url: " + value2);
                }
                TMLog.e(TAG, "location header is null. httpResponseCode = " + statusCode);
                throw new StopRequestException(702, "location header is null. httpResponseCode = " + statusCode);
            case 416:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 500:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 503:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            default:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
        }
    }

    private boolean verifyTotalLen(HttpResponse httpResponse, HttpEntity httpEntity) {
        long contentLength;
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            contentLength = httpEntity.getContentLength();
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1) {
                return false;
            }
            if (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue()) {
                return false;
            }
        } else if (httpResponse.getStatusLine().getStatusCode() == b.CTRL_INDEX) {
            contentLength = ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue());
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1) {
                return false;
            }
            if (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReceivedResponseData(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        Throwable th;
        long j;
        HttpEntity entity = httpResponse.getEntity();
        if (verifyTotalLen(httpResponse, entity)) {
            Header firstHeader;
            if (this.mDownloadInfo.getTotalSize() == 0) {
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    this.mDownloadInfo.setTotalSize(entity.getContentLength());
                    TMLog.i(TAG, "HTTPCode 200, totalBytes:" + this.mDownloadInfo.getTotalSize());
                } else if (httpResponse.getStatusLine().getStatusCode() == b.CTRL_INDEX) {
                    this.mDownloadInfo.setTotalSize(ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue()));
                    TMLog.i(TAG, "HTTPCode 206, totalBytes:" + this.mDownloadInfo.getTotalSize());
                } else {
                    TMLog.w(TAG, "statusCode=" + httpResponse.getStatusLine().getStatusCode() + " onReceivedResponseData error.");
                }
                TMLog.w(TAG, "first start downloadinfoTotalSize = " + this.mDownloadInfo.getTotalSize());
                firstHeader = httpResponse.getFirstHeader("content-range");
                if (firstHeader != null) {
                    ByteRange parseContentRange = ByteRange.parseContentRange(firstHeader.getValue());
                    downloadChunkLogInfo.responseRangePosition = parseContentRange.getStart();
                    downloadChunkLogInfo.responseRangeLength = (parseContentRange.getEnd() - parseContentRange.getStart()) + 1;
                }
                downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            } else if (httpResponse.getStatusLine().getStatusCode() == b.CTRL_INDEX) {
                try {
                    firstHeader = httpResponse.getFirstHeader("content-range");
                    ByteRange parseContentRange2 = ByteRange.parseContentRange(firstHeader.getValue());
                    long totalSize = ByteRange.getTotalSize(firstHeader.getValue());
                    downloadChunkLogInfo.responseRangePosition = parseContentRange2.getStart();
                    downloadChunkLogInfo.responseRangeLength = (parseContentRange2.getEnd() - parseContentRange2.getStart()) + 1;
                    downloadChunkLogInfo.responseContentLength = totalSize;
                    TMLog.w(TAG, "totalSize = " + totalSize + "  downloadinfoTotalSize = " + this.mDownloadInfo.getTotalSize());
                    TMLog.i(TAG, "mReceivedBytes = " + this.mDownloadInfo.mReceivedBytes);
                    TMLog.i(TAG, "start = " + parseContentRange2.getStart() + ", end = " + parseContentRange2.getEnd());
                    if (parseContentRange2.getStart() != this.mDownloadInfo.mReceivedBytes) {
                        throw new StopRequestException(706, "The received size is not equal with ByteRange.");
                    } else if (totalSize != this.mDownloadInfo.getTotalSize()) {
                        throw new StopRequestException(705, "The total size is not equal with ByteRange.");
                    } else {
                        TMLog.d(TAG, "response ByteRange: " + firstHeader);
                        if (this.mSaveFile != null) {
                            this.mSaveFile.close();
                            this.mSaveFile = null;
                        }
                    }
                } catch (Throwable th2) {
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                }
            }
            if (this.mSaveFile == null) {
                this.mSaveFile = new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName);
            }
            long j2 = 0;
            try {
                int read;
                InputStream content = entity.getContent();
                TMLog.i(TAG, "start write file, fileName: " + this.mDownloadInfo.mFileName);
                j = 0;
                while (true) {
                    try {
                        read = content.read(this.mRecvBuf);
                        if (read <= 0) {
                            break;
                        } else if (this.mStopTask) {
                            break;
                        } else {
                            long j3 = this.mDownloadInfo.mReceivedBytes + ((long) read);
                            if (j3 <= this.mDownloadInfo.getTotalSize()) {
                                if (!this.mSaveFile.write(this.mRecvBuf, 0, read, this.mDownloadInfo.mReceivedBytes, j3 == this.mDownloadInfo.getTotalSize())) {
                                    break;
                                }
                                this.mDownloadInfo.updateReceivedSize((long) read);
                                j += (long) read;
                            } else {
                                TMLog.w(TAG, "write file size too long.\r\nreadedLen: " + read + "\r\nreceivedSize: " + this.mDownloadInfo.mReceivedBytes + "\r\ntotalSize: " + this.mDownloadInfo.getTotalSize() + "\r\nisTheEndData: false");
                                throw new StopRequestException(703, "write file size too long.");
                            }
                        }
                    } catch (SocketException e) {
                        th = e;
                        j2 = j;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                String str;
                if (!DownloadHelper.isSpaceEnough(TMAssistantFile.getSavePathRootDir(), this.mDownloadInfo.getTotalSize())) {
                    str = "write file failed, no enough space! fileName: " + this.mDownloadInfo.mFileName + " receivedSize: " + this.mDownloadInfo.mReceivedBytes + " readedSize: " + read + " totalSize: " + this.mDownloadInfo.getTotalSize();
                    TMLog.w(TAG, str);
                    throw new StopRequestException(710, str);
                } else if (TMAssistantFile.isSDCardExistAndCanWrite()) {
                    str = "write file failed, fileName: " + this.mDownloadInfo.mFileName + " receivedSize: " + this.mDownloadInfo.mReceivedBytes + " readedSize: " + read + " totalSize: " + this.mDownloadInfo.getTotalSize();
                    TMLog.w(TAG, str);
                    throw new StopRequestException(703, str);
                } else {
                    str = "write file failed, no sdCard! fileName: " + this.mDownloadInfo.mFileName + " receivedSize: " + this.mDownloadInfo.mReceivedBytes + " readedSize: " + read + " totalSize: " + this.mDownloadInfo.getTotalSize();
                    TMLog.w(TAG, str);
                    throw new StopRequestException(711, str);
                }
            } catch (SocketException e2) {
                th = e2;
                try {
                    x.printErrStackTrace(TAG, th, "", new Object[0]);
                    throw new StopRequestException(605, th);
                } catch (Throwable th4) {
                    th = th4;
                    j = j2;
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                    downloadChunkLogInfo.receiveDataSize = j;
                    throw th;
                }
            }
        }
        TMLog.i(TAG, "verifyTotalLen false");
        throw new StopRequestException(705, "totalLen is not match the requestSize");
    }

    private void setRangeHeader(HttpGet httpGet, DownloadChunkLogInfo downloadChunkLogInfo) {
        String netStatus = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mNetType = netStatus;
        if (TextUtils.isEmpty(netStatus) || (!netStatus.contains("wap") && (!netStatus.contains("net") || this.mDownloadInfo.mRetryCnt <= 0))) {
            netStatus = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
            downloadChunkLogInfo.requestRanageSize = 0;
            return;
        }
        try {
            long j;
            int splitSizeInBytes = DownloadSetting.getSplitSizeInBytes(netStatus);
            long j2 = this.mDownloadInfo.mReceivedBytes;
            if (this.mDownloadInfo.getTotalSize() > 0) {
                j = (this.mDownloadInfo.mReceivedBytes + ((long) splitSizeInBytes)) - 1;
                if (j >= this.mDownloadInfo.getTotalSize()) {
                    j = this.mDownloadInfo.getTotalSize() - 1;
                }
            } else {
                j = (long) (splitSizeInBytes - 1);
            }
            netStatus = "bytes=" + j2 + "-" + j;
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = j2;
            downloadChunkLogInfo.requestRanageSize = (long) splitSizeInBytes;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
        }
    }

    private void renameApkFileName(HttpResponse httpResponse) {
        if (httpResponse != null && this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive")) {
            Object obj = null;
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            if (headers == null || headers.length <= 0) {
                obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
            } else {
                String value = headers[0].getValue();
                TMLog.i(TAG, "headerFileName = " + value);
                if (TextUtils.isEmpty(value) || !value.contains("filename=\"")) {
                    obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
                } else {
                    value = value.substring(value.indexOf("filename=\"") + 10);
                    if (!TextUtils.isEmpty(value)) {
                        obj = value.substring(0, value.indexOf("\""));
                        TMLog.i(TAG, "header file Name =" + obj);
                    }
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                this.mDownloadInfo.mFileName = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(obj));
            }
        }
    }

    private void setExtraHeaderParam(HttpGet httpGet, Map<String, String> map) {
        if (httpGet != null && map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                httpGet.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
