package com.tencent.mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.z$d;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFileService extends IntentService {
    private static final String TAG = DownloadFileService.class.getSimpleName();
    private ResultReceiver lrr;
    private int lrs;
    private int lrt;

    public DownloadFileService() {
        super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
    }

    public void onCreate() {
        super.onCreate();
        z$d android_support_v4_app_z_d = new z$d(this);
        android_support_v4_app_z_d.a("Something Download").b("Download in progress").U(a.icon);
        startForeground(4657, android_support_v4_app_z_d.build());
    }

    protected void onHandleIntent(Intent intent) {
        String string = intent.getExtras().getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.lrr = (ResultReceiver) intent.getParcelableExtra("receiver");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        a(string, new File(file, "file11.apk"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(String str, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(3000);
                int intValue = Integer.valueOf(httpURLConnection.getHeaderField("Content-Length")).intValue();
                inputStream = httpURLConnection.getInputStream();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                            this.lrs = read + this.lrs;
                            Bundle bundle = new Bundle();
                            int i = (int) ((((long) this.lrs) * 100) / ((long) intValue));
                            if (i > this.lrt) {
                                bundle.putInt("progress", i);
                                this.lrr.send(4657, bundle);
                                this.lrt = i;
                            }
                        }
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                x.e(TAG, "Server return code:" + responseCode);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
            } catch (Throwable e22) {
                x.printErrStackTrace(TAG, e22, "", new Object[0]);
                try {
                } catch (Exception e3) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable e222) {
                    x.printErrStackTrace(TAG, e222, "", new Object[0]);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace(TAG, e2222, "", new Object[0]);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e4) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable e22222) {
                    x.printErrStackTrace(TAG, e22222, "", new Object[0]);
                }
            } catch (Throwable e222222) {
                x.printErrStackTrace(TAG, e222222, "", new Object[0]);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e5) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable e2222222) {
                    x.printErrStackTrace(TAG, e2222222, "", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e6) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable e7) {
                    x.printErrStackTrace(TAG, e7, "", new Object[0]);
                }
            }
        } catch (Throwable e22222222) {
            x.e(TAG, "can not fond output folder");
            x.printErrStackTrace(TAG, e22222222, "", new Object[0]);
        }
    }
}
