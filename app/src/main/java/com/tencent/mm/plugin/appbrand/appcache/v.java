package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.ad.a;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class v {
    private static c iEM;
    private static Future<c> iEN;
    private static final ThreadPoolExecutor iEO = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    private static final class b implements j<IPCVoid, WxaPkgWrappingInfo> {
        private b() {
        }

        public final /* synthetic */ Object at(Object obj) {
            WxaPkgWrappingInfo cp = cp(false);
            WxaPkgWrappingInfo cp2 = cp != null ? cp : cp(true);
            u.jy(cp2 == null ? y.VERSION : cp2.iGL);
            return cp2;
        }

        private WxaPkgWrappingInfo cp(boolean z) {
            Pair cr = ad.cr(z);
            if (cr.first == a.iFY && cr.second == null && !z) {
                e.post(new 1(this), "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
            }
            if (cr.second != null && ((WxaPkgWrappingInfo) cr.second).iGK == 999) {
                ((WxaPkgWrappingInfo) cr.second).iGL = 0;
            }
            return (WxaPkgWrappingInfo) cr.second;
        }
    }

    public static synchronized void ks() {
        synchronized (v.class) {
            if (iEM != null) {
                x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[]{iEM});
            } else {
                boolean cfA = ac.cfA();
                boolean ZV = y.ZV();
                if (!cfA || ZV) {
                    x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), mmexists %b, forceLocal %b, use AssetReader", new Object[]{Boolean.valueOf(cfA), Boolean.valueOf(ZV)});
                    iEM = a.iEQ;
                } else {
                    c cVar;
                    try {
                        if (iEN != null) {
                            x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                        } else {
                            x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                            iEN = iEO.submit(new 1());
                        }
                        iEM = (c) iEN.get(3, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        x.e("MicroMsg.WxaCommLibRuntimeReader", "load(), by retriever e = %s", new Object[]{e});
                    } finally {
                        iEN.cancel(true);
                        iEN = null;
                    }
                    if (iEM == null) {
                        cVar = a.iEQ;
                    } else {
                        cVar = iEM;
                    }
                    iEM = cVar;
                }
            }
        }
    }

    public static synchronized boolean ZN() {
        boolean z = true;
        synchronized (v.class) {
            x.i("MicroMsg.WxaCommLibRuntimeReader", "loaded(), reader %s", new Object[]{iEM});
            if (iEM == null) {
                z = false;
            }
        }
        return z;
    }

    private static synchronized c ZO() {
        c cVar;
        synchronized (v.class) {
            if (iEM == null) {
                ks();
            }
            cVar = iEM;
        }
        return cVar;
    }

    static InputStream pD(String str) {
        if (bh.ov(str)) {
            return null;
        }
        InputStream openRead = ZO().openRead(str);
        String format = String.format(Locale.US, "[%d | %s | %b]", new Object[]{Integer.valueOf(r1.ZR().iGK), bh.fJ(r1.ZR().iGM), Boolean.valueOf(r1.ZR().iGN)});
        try {
            int i;
            String str2 = "MicroMsg.WxaCommLibRuntimeReader";
            String str3 = "read %s, %s, ret %d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = format;
            if (openRead == null) {
                i = -1;
            } else {
                i = openRead.available();
            }
            objArr[2] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
            return openRead;
        } catch (Exception e) {
            x.e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", new Object[]{str, format, e});
            return openRead;
        }
    }

    public static String pE(String str) {
        InputStream pD = pD(str);
        if (pD == null) {
            return "";
        }
        return c.convertStreamToString(pD);
    }

    public static m pF(String str) {
        InputStream pD = pD(str);
        if (pD == null) {
            return null;
        }
        return new m(s.SW(str), "UTF-8", pD);
    }

    public static WxaPkgWrappingInfo ZP() {
        return ZO().ZR();
    }
}
