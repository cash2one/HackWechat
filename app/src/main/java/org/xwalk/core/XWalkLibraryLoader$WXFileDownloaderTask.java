package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.xweb.b.b;
import com.tencent.xweb.b.c;
import com.tencent.xweb.b.d;
import com.tencent.xweb.util.e;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

class XWalkLibraryLoader$WXFileDownloaderTask extends AsyncTask<Void, Integer, Integer> implements c {
    private static final int DOWNLOAD_FAILED = -1;
    private static final int DOWNLOAD_SUCCESS = 0;
    private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
    private static final int ERROR_CODE_EXCEPTION = -101;
    private static final int ERROR_TYPE_DOWNLOADER = 1;
    private static final int ERROR_TYPE_USER = 2;
    private static final int UPDATE_INTERVAL_MS = 500;
    private Object lockObj = new Object();
    private Context mContext;
    private UpdateConfig mDownloadConfig;
    private int mErrorCode = 0;
    private int mErrorType = 0;
    private long mFileTotalSize = 0;
    private boolean mIsDownloadResume = false;
    private DownloadListener mListener;
    private int mNetWorkType = 0;
    private long mProgressUpdateTime = 0;
    private int mRetryTimes = 0;
    private long mStartTimestamp = 0;
    private d mWXFileDownloaderBridge = null;
    private boolean mWaitTimeout = false;

    public boolean isValid() {
        if (this.mWXFileDownloaderBridge == null) {
            return false;
        }
        return d.isValid();
    }

    XWalkLibraryLoader$WXFileDownloaderTask(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
        this.mListener = downloadListener;
        this.mContext = context;
        this.mDownloadConfig = updateConfig;
        this.mWXFileDownloaderBridge = new d();
        this.mWXFileDownloaderBridge.AqJ = this;
    }

    protected void onPreExecute() {
        Log.d("XWalkLib", "WXFileDownloaderTask started, config:" + this.mDownloadConfig.getLogSelf());
        XWalkLibraryLoader.access$002(this);
        this.mListener.onDownloadStarted();
        this.mStartTimestamp = System.currentTimeMillis();
        this.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
        if (this.mDownloadConfig.isPatchUpdate) {
            e.cIM();
        } else {
            e.cII();
        }
    }

    protected Integer doInBackground(Void... voidArr) {
        if (this.mDownloadConfig == null || this.mWXFileDownloaderBridge == null || !d.isValid()) {
            this.mErrorType = 2;
            this.mErrorCode = -1;
            return Integer.valueOf(-1);
        }
        int a;
        this.mDownloadConfig.getUpdateBizType();
        b bVar = this.mWXFileDownloaderBridge;
        String str = this.mDownloadConfig.downUrl;
        String downloadPath = this.mDownloadConfig.getDownloadPath();
        if (d.AqI != null) {
            a = d.AqI.a(str, downloadPath, bVar);
        } else {
            a = -1;
        }
        if (a != 0) {
            this.mErrorType = 1;
            this.mErrorCode = -1;
            return Integer.valueOf(-1);
        }
        synchronized (this.lockObj) {
            try {
                this.mWaitTimeout = true;
                this.lockObj.wait(300000);
            } catch (InterruptedException e) {
                this.mWaitTimeout = false;
                this.mErrorType = 2;
                this.mErrorCode = -101;
            }
            if (this.mErrorType == 0 && this.mErrorCode == 0) {
                Integer valueOf = Integer.valueOf(0);
                return valueOf;
            }
            Log.e("XWalkLib", "download errortype:" + this.mErrorType + ", errorcode:" + this.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
            if (this.mWaitTimeout) {
                this.mErrorType = 1;
                this.mErrorCode = ERROR_CODE_DOWNLOADER_TIMEOUT;
            }
            valueOf = Integer.valueOf(-1);
            return valueOf;
        }
    }

    protected void onProgressUpdate(Integer... numArr) {
        int i = 0;
        Log.d("XWalkLib", "WXFileDownloaderTask updated: " + numArr[0] + "/" + numArr[1]);
        if (numArr[1].intValue() > 0) {
            i = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
        }
        this.mListener.onDownloadUpdated(i);
    }

    protected void onPostExecute(Integer num) {
        int i;
        int i2 = 1;
        Log.d("XWalkLib", "WXFileDownloaderTask finished, " + num);
        XWalkLibraryLoader.access$002(null);
        if (num.intValue() == 0) {
            this.mListener.onDownloadCompleted(this.mDownloadConfig);
            if (this.mDownloadConfig.isPatchUpdate) {
                e.gH(System.currentTimeMillis() - this.mStartTimestamp);
            } else {
                e.gF(System.currentTimeMillis() - this.mStartTimestamp);
            }
        } else {
            this.mListener.onDownloadFailed(-1, this.mErrorCode);
            if (this.mDownloadConfig.isPatchUpdate) {
                e.cIN();
            } else {
                e.cIJ();
            }
        }
        if (this.mDownloadConfig.isPatchUpdate) {
            i = 2;
        } else {
            i = 1;
        }
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        int i3 = this.mDownloadConfig.apkVer;
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTimestamp;
        synchronized (this.lockObj) {
            if (!this.mIsDownloadResume) {
                i2 = 0;
            }
        }
        e.be(15124, i + "," + availableVersion + "," + i3 + ",17," + this.mErrorCode + "," + this.mNetWorkType + "," + this.mRetryTimes + "," + currentTimeMillis + "," + this.mFileTotalSize + ",2," + i2);
    }

    public void onProgressChange(String str, long j, long j2) {
        Log.d("XWalkLib", "url:" + str + ", cur_size:" + j + ", total_size:" + j2);
        if (this.mFileTotalSize != j2) {
            this.mFileTotalSize = j2;
        }
        publishProgress(new Integer[]{Integer.valueOf((int) j), Integer.valueOf((int) j2)});
    }

    public void onTaskSucc(String str, String str2, boolean z) {
        synchronized (this.lockObj) {
            this.mIsDownloadResume = z;
            this.mWaitTimeout = false;
            this.lockObj.notify();
        }
    }

    public void onTaskFail(String str, int i, boolean z) {
        synchronized (this.lockObj) {
            this.mErrorType = 1;
            this.mErrorCode = i;
            this.mIsDownloadResume = z;
            this.mWaitTimeout = false;
            this.lockObj.notify();
        }
    }
}
