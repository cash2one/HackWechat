package com.tencent.xweb.xwalk.a;

import android.os.AsyncTask;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class f extends AsyncTask<a, b, c> {
    b AtQ = null;
    a AtR = null;
    int AtS = 0;
    long AtT = 0;
    private Timer bnp = null;

    static /* synthetic */ void a(a aVar, b bVar, int i) {
        f fVar = new f();
        fVar.AtQ = bVar;
        fVar.AtR = aVar;
        fVar.AtS = i;
        fVar.AtT = System.currentTimeMillis();
        fVar.execute(new a[]{fVar.AtR});
    }

    static /* synthetic */ void d(f fVar) {
        if (fVar.bnp != null) {
            fVar.bnp.cancel();
            fVar.bnp = null;
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((a[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Object obj2 = null;
        obj = (c) obj;
        if (obj == null) {
            obj = new c();
            obj.AtX = -10004;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (obj.AtX == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.AtQ.a(obj);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + obj.AtX + " mRetrytimes = " + this.AtS);
        if (!(this.AtS >= 2 || obj.AtX == -10001 || obj.AtX == -10004)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.AtS++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.AtS);
            this.bnp = new Timer();
            this.bnp.schedule(new 1(this), 3000 * ((long) this.AtS));
            return;
        }
        this.AtQ.b(obj);
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    protected final void onPreExecute() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c a(a... aVarArr) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        if (aVarArr == null) {
            return null;
        }
        if (aVarArr.length != 1) {
            return null;
        }
        a aVar = aVarArr[0];
        if (aVar == null) {
            return null;
        }
        c cVar = new c();
        cVar.mUrl = aVar.mUrl;
        cVar.mFilePath = aVar.mFilePath;
        cVar.AtX = 0;
        cVar.jcD = "";
        cVar.mRetryTimes = this.AtS;
        cVar.AtY = 0;
        cVar.mTotalSize = 0;
        cVar.AtZ = 0;
        cVar.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
        if (aVar.mUrl == null || aVar.mFilePath == null || aVar.mUrl.length() == 0 || aVar.mFilePath.length() == 0 || this.AtQ == null) {
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para");
            cVar.AtX = -10001;
            return cVar;
        }
        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(aVar.mUrl).openConnection();
            try {
                httpURLConnection3.setRequestMethod("GET");
                if (aVar.AtV && (httpURLConnection3 instanceof HttpsURLConnection)) {
                    SSLContext cJm = d.cJm();
                    if (cJm != null) {
                        ((HttpsURLConnection) httpURLConnection3).setSSLSocketFactory(cJm.getSocketFactory());
                        ((HttpsURLConnection) httpURLConnection3).setHostnameVerifier(d.Aub);
                    }
                }
                httpURLConnection3.setConnectTimeout(8000);
                httpURLConnection3.setReadTimeout(8000);
                if (httpURLConnection3.getResponseCode() == 200) {
                    inputStream = httpURLConnection3.getInputStream();
                    int contentLength = httpURLConnection3.getContentLength();
                    String str = aVar.mFilePath;
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    OutputStream fileOutputStream = new FileOutputStream(str);
                    try {
                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                        long j = 0;
                        b bVar = new b();
                        bVar.mUrl = aVar.mUrl;
                        bVar.mTotalSize = (long) contentLength;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else if (isCancelled()) {
                                break;
                            } else {
                                j += (long) read;
                                fileOutputStream.write(bArr, 0, read);
                                bVar.AtW = j;
                                if (contentLength > 0) {
                                    publishProgress(new b[]{bVar});
                                }
                            }
                        }
                        inputStream.close();
                        try {
                            fileOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            return null;
                        } catch (IOException e) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e.toString());
                            cVar.AtX = -10003;
                            return cVar;
                        }
                    } catch (Exception e2) {
                        outputStream = fileOutputStream;
                        httpURLConnection = httpURLConnection3;
                        exception = e2;
                        httpURLConnection2 = httpURLConnection;
                    } catch (Throwable th2) {
                        outputStream = fileOutputStream;
                        httpURLConnection = httpURLConnection3;
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                    }
                }
                httpURLConnection3.disconnect();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e3.toString());
                        cVar.AtX = -10003;
                        return cVar;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return cVar;
            } catch (Exception e22) {
                Exception exception2 = e22;
                httpURLConnection2 = httpURLConnection3;
                exception = exception2;
                try {
                    XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + exception.toString());
                    cVar.AtX = -10002;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e32.toString());
                            cVar.AtX = -10003;
                            return cVar;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e322) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e322.toString());
                            cVar.AtX = -10003;
                            return cVar;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                Throwable th4 = th22;
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            exception = e4;
            XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + exception.toString());
            cVar.AtX = -10002;
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return cVar;
        }
    }
}
