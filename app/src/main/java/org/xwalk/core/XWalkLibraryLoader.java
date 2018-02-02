package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.xweb.util.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWalkLibraryLoader {
    private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
    private static final int DOWNLOAD_TYPE_CDN = 2;
    private static final int DOWNLOAD_TYPE_HTTP = 1;
    private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
    private static final String TAG = "XWalkLib";
    private static AsyncTask<Void, Integer, Integer> sActiveTask;

    public interface DownloadListener {
        void onDownloadCancelled();

        void onDownloadCompleted(UpdateConfig updateConfig);

        void onDownloadFailed(int i, int i2);

        void onDownloadStarted();

        void onDownloadUpdated(int i);
    }

    private static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
        private Context mContext;
        private UpdateConfig mDownloadConfig;
        private File mDownloadedFile;
        private long mFileTotalSize = 0;
        private boolean mIsDownloadResume = false;
        private DownloadListener mListener;
        private int mNetWorkType = 0;
        private long mProgressUpdateTime;
        private long mStartTimestamp = 0;

        HttpDownloadTask(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
            this.mListener = downloadListener;
            this.mContext = context;
            this.mDownloadConfig = updateConfig;
        }

        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask started, config:" + this.mDownloadConfig.getLogSelf());
            XWalkLibraryLoader.sActiveTask = this;
            this.mDownloadedFile = new File(this.mDownloadConfig.getDownloadPath());
            this.mListener.onDownloadStarted();
            this.mStartTimestamp = System.currentTimeMillis();
            this.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
            if (this.mDownloadConfig.isPatchUpdate) {
                e.cIM();
            } else {
                e.cII();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected Integer doInBackground(Void... voidArr) {
            Integer valueOf;
            Throwable th;
            if (this.mDownloadConfig == null) {
                return Integer.valueOf(-1);
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            HttpURLConnection httpURLConnection = null;
            try {
                URL url = new URL(this.mDownloadConfig.downUrl);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setReadTimeout(30000);
                    httpURLConnection2.connect();
                    Integer valueOf2;
                    if (httpURLConnection2.getResponseCode() == 200 || httpURLConnection2.getResponseCode() == b.CTRL_INDEX) {
                        long j;
                        int contentLength;
                        int contentLength2 = httpURLConnection2.getContentLength();
                        if (this.mDownloadedFile.exists()) {
                            long length = this.mDownloadedFile.length();
                            if (((long) contentLength2) == length) {
                                Log.i(XWalkLibraryLoader.TAG, "royle:same size in server success");
                                valueOf2 = Integer.valueOf(0);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return valueOf2;
                            }
                            if (length > 0) {
                                this.mIsDownloadResume = true;
                                Log.i(XWalkLibraryLoader.TAG, "royle:http download IsDownloadResume");
                            }
                            httpURLConnection2.disconnect();
                            httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            httpURLConnection2.setConnectTimeout(30000);
                            httpURLConnection2.setReadTimeout(30000);
                            httpURLConnection2.setRequestProperty("Range", "bytes=" + length + "-");
                            Log.i(XWalkLibraryLoader.TAG, "royle:download range begin:" + length);
                            httpURLConnection2.connect();
                            if (httpURLConnection2.getResponseCode() == 200 || httpURLConnection2.getResponseCode() == b.CTRL_INDEX) {
                                j = length;
                                httpURLConnection = httpURLConnection2;
                                contentLength = httpURLConnection2.getContentLength();
                            } else {
                                Log.e(XWalkLibraryLoader.TAG, "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage());
                                valueOf2 = Integer.valueOf(-1);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return valueOf2;
                            }
                        }
                        j = 0;
                        int i = contentLength2;
                        httpURLConnection = httpURLConnection2;
                        contentLength = i;
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            OutputStream fileOutputStream = new FileOutputStream(this.mDownloadedFile, true);
                            try {
                                byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                long j2 = 0;
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else if (isCancelled()) {
                                        break;
                                    } else {
                                        j2 += (long) read;
                                        fileOutputStream.write(bArr, 0, read);
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        if (uptimeMillis - this.mProgressUpdateTime > 500) {
                                            this.mProgressUpdateTime = uptimeMillis;
                                            publishProgress(new Integer[]{Integer.valueOf((int) (j2 + j)), Integer.valueOf((int) (((long) contentLength) + j))});
                                        }
                                    }
                                }
                                valueOf = Integer.valueOf(-1);
                                try {
                                    fileOutputStream.close();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } catch (IOException e) {
                                }
                                if (httpURLConnection == null) {
                                    return valueOf;
                                }
                                httpURLConnection.disconnect();
                                return valueOf;
                            } catch (Exception e2) {
                                outputStream = fileOutputStream;
                                inputStream = inputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream = fileOutputStream;
                                inputStream = inputStream2;
                            }
                        } catch (Exception e3) {
                            inputStream = inputStream2;
                            try {
                                valueOf = Integer.valueOf(-1);
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e4) {
                                        if (httpURLConnection == null) {
                                            return valueOf;
                                        }
                                        httpURLConnection.disconnect();
                                        return valueOf;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection == null) {
                                    return valueOf;
                                }
                                httpURLConnection.disconnect();
                                return valueOf;
                            } catch (Throwable th3) {
                                th = th3;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e5) {
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    Log.e(XWalkLibraryLoader.TAG, "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage());
                    valueOf2 = Integer.valueOf(-1);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return valueOf2;
                } catch (Exception e6) {
                    httpURLConnection = httpURLConnection2;
                    valueOf = Integer.valueOf(-1);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                        return valueOf;
                    }
                    httpURLConnection.disconnect();
                    return valueOf;
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    httpURLConnection = httpURLConnection2;
                    th = th6;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                valueOf = Integer.valueOf(-1);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection == null) {
                    return valueOf;
                }
                httpURLConnection.disconnect();
                return valueOf;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.mFileTotalSize = this.mDownloadedFile.length();
            return Integer.valueOf(0);
        }

        protected void onProgressUpdate(Integer... numArr) {
            int i = 0;
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask updated: " + numArr[0] + "/" + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i);
        }

        protected void onCancelled(Integer num) {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask cancelled");
            XWalkLibraryLoader.sActiveTask = null;
            this.mListener.onDownloadCancelled();
        }

        protected void onPostExecute(Integer num) {
            int i;
            int i2 = 1;
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask finished, " + num);
            XWalkLibraryLoader.sActiveTask = null;
            if (num.intValue() == 0) {
                this.mListener.onDownloadCompleted(this.mDownloadConfig);
                if (this.mDownloadConfig.isPatchUpdate) {
                    e.gH(System.currentTimeMillis() - this.mStartTimestamp);
                } else {
                    e.gF(System.currentTimeMillis() - this.mStartTimestamp);
                }
            } else {
                this.mListener.onDownloadFailed(-1, 0);
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
            if (!this.mIsDownloadResume) {
                i2 = 0;
            }
            e.be(15124, i + "," + availableVersion + "," + i3 + ",17," + num + "," + this.mNetWorkType + ",0," + currentTimeMillis + "," + this.mFileTotalSize + ",1," + i2);
        }
    }

    public static boolean isInitializing() {
        return false;
    }

    public static boolean isDownloading() {
        return sActiveTask != null && (sActiveTask instanceof HttpDownloadTask);
    }

    public static boolean isSharedLibrary() {
        return XWalkCoreWrapper.getInstance().isSharedMode();
    }

    public static boolean isLibraryReady() {
        return XWalkCoreWrapper.getInstance() != null;
    }

    public static int getLibraryStatus() {
        return XWalkCoreWrapper.getCoreStatus();
    }

    public static void prepareToInit(Context context) {
        XWalkEnvironment.init(context);
        XWalkCoreWrapper.handlePreInit(context.getClass().getName());
    }

    public static void finishInit(Context context) {
        XWalkCoreWrapper.handlePostInit(context.getClass().getName());
    }

    public static void startHttpDownload(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
        WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(downloadListener, context, updateConfig);
        if (updateConfig.bUseCdn && wXFileDownloaderTask.isValid()) {
            Log.i(TAG, "use wx file downloader");
            wXFileDownloaderTask.execute(new Void[0]);
            return;
        }
        Log.i(TAG, "use default file downloader");
        new HttpDownloadTask(downloadListener, context, updateConfig).execute(new Void[0]);
    }

    public static boolean cancelHttpDownload() {
        if (sActiveTask != null && (sActiveTask instanceof HttpDownloadTask) && sActiveTask.cancel(true)) {
            return true;
        }
        return false;
    }
}
