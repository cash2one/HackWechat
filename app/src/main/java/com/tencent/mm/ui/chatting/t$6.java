package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.mm.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class t$6 implements Runnable {
    final /* synthetic */ t yuo;

    t$6(t tVar) {
        this.yuo = tVar;
    }

    public final void run() {
        Throwable th;
        Throwable th2;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.yuo.puq).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.connect();
                this.yuo.pur = httpURLConnection2.getHeaderField("Location");
                InputStream inputStream = httpURLConnection2.getInputStream();
                int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                if (headerFieldInt <= 0) {
                    x.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                    inputStream.close();
                } else {
                    byte[] bArr = new byte[headerFieldInt];
                    inputStream.read(bArr);
                    inputStream.close();
                    byte[] a = l.a(Base64.decode(bArr, 0), l.k(this.yuo.mContext, "rsa_public_key_forwx.pem"));
                    this.yuo.pus = new String(a);
                    ag.y(new 1(this));
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable e) {
                th = e;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                try {
                    x.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", th2, "", new Object[0]);
                    t.a(this.yuo);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Exception e3) {
            th2 = e3;
            x.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", th2, "", new Object[0]);
            t.a(this.yuo);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
