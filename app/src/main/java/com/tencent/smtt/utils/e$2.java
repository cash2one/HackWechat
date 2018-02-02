package com.tencent.smtt.utils;

import com.tencent.smtt.utils.e.a;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class e$2 extends Thread {
    final /* synthetic */ a Aay;
    final /* synthetic */ String gBF;

    e$2(String str, a aVar) {
        this.gBF = str;
        this.Aay = aVar;
    }

    public final void run() {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        OutputStream V;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                V = f.V(new File(this.gBF));
                try {
                    byte[] bArr = new byte[8192];
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        i += read;
                        V.write(bArr, 0, read);
                        this.Aay.kO((i * 100) / contentLength);
                    }
                    this.Aay.cFo();
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                    }
                    V.close();
                } catch (Exception e2) {
                    inputStream2 = inputStream;
                    try {
                        this.Aay.cFp();
                        try {
                            inputStream2.close();
                        } catch (Exception e3) {
                        }
                        try {
                            V.close();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        outputStream = V;
                        th2 = th;
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = V;
                    th2 = th;
                    inputStream.close();
                    outputStream.close();
                    throw th2;
                }
            } catch (Exception e7) {
                V = null;
                inputStream2 = inputStream;
                this.Aay.cFp();
                inputStream2.close();
                V.close();
            } catch (Throwable th5) {
                th2 = th5;
                inputStream.close();
                outputStream.close();
                throw th2;
            }
        } catch (Exception e8) {
            V = null;
            this.Aay.cFp();
            inputStream2.close();
            V.close();
        } catch (Throwable th6) {
            th2 = th6;
            inputStream = null;
            inputStream.close();
            outputStream.close();
            throw th2;
        }
    }
}
