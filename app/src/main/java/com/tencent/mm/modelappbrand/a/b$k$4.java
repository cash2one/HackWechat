package com.tencent.mm.modelappbrand.a;

import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;

class b$k$4 implements Runnable {
    final /* synthetic */ k hkn;

    b$k$4(k kVar) {
        this.hkn = kVar;
    }

    public final void run() {
        Closeable iE;
        Closeable bufferedInputStream;
        Throwable e;
        Closeable closeable = null;
        k kVar = this.hkn;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kVar.hkg).openConnection();
            iE = kVar.hjQ.iE(b.access$1500(kVar.hkg));
            if (iE == null) {
                bh.d(iE);
                bh.d(null);
            } else {
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", new Object[]{kVar.hkg});
                        kVar.hjQ.iF(b.access$1500(kVar.hkg));
                        bh.d(iE);
                        bh.d(closeable);
                        b.d(this.hkn.hke).i(new 1(this));
                    } catch (Throwable th) {
                        e = th;
                        bh.d(iE);
                        bh.d(closeable);
                        throw e;
                    }
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        iE.write(bArr, 0, read);
                    }
                    iE.flush();
                    bh.d(iE);
                    bh.d(bufferedInputStream);
                } catch (Exception e3) {
                    e = e3;
                    closeable = bufferedInputStream;
                    x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", new Object[]{kVar.hkg});
                    kVar.hjQ.iF(b.access$1500(kVar.hkg));
                    bh.d(iE);
                    bh.d(closeable);
                    b.d(this.hkn.hke).i(new 1(this));
                } catch (Throwable th2) {
                    e = th2;
                    closeable = bufferedInputStream;
                    bh.d(iE);
                    bh.d(closeable);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            iE = null;
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", new Object[]{kVar.hkg});
            kVar.hjQ.iF(b.access$1500(kVar.hkg));
            bh.d(iE);
            bh.d(closeable);
            b.d(this.hkn.hke).i(new 1(this));
        } catch (Throwable th3) {
            e = th3;
            iE = null;
            bh.d(iE);
            bh.d(closeable);
            throw e;
        }
        b.d(this.hkn.hke).i(new 1(this));
    }
}
