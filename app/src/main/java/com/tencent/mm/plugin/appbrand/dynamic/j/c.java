package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.f$a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.xweb.m;
import java.io.Closeable;
import java.io.InputStream;

public final class c {
    private static final String[] iFc = y.iFc;

    private static m ba(String str, String str2) {
        Closeable zVar;
        Closeable pI;
        Throwable e;
        try {
            zVar = new z(str);
            try {
                zVar.ZX();
                pI = zVar.pI(str2);
                try {
                    bh.d(zVar);
                    return new m(s.SW(str2), "UTF-8", pI);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                pI = null;
                x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, bh.i(e));
                bh.d(zVar);
                bh.d(pI);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            pI = null;
            zVar = null;
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, bh.i(e));
            bh.d(zVar);
            bh.d(pI);
            return null;
        }
    }

    public static String bb(String str, String str2) {
        if (bh.ov(str2)) {
            return "";
        }
        m bc = bc(str, str2);
        if (bc != null) {
            try {
                x.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", Integer.valueOf(bc.mInputStream.available()), str2);
            } catch (Exception e) {
                x.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", e, str, str2);
            }
            return com.tencent.mm.plugin.appbrand.p.c.convertStreamToString(bc.mInputStream);
        }
        x.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", str, str2);
        return "";
    }

    public static m bc(String str, String str2) {
        x.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", str, str2);
        if (bh.ov(str2) || s.eE(str2, "about:blank") || com.tencent.mm.plugin.appbrand.p.c.uz(str2)) {
            return null;
        }
        String py = a.py(str2);
        WxaPkgWrappingInfo acI;
        if (com.tencent.mm.compatible.loader.a.a(iFc, py)) {
            WxaWidgetContext ro = i.ro(str);
            acI = ro != null ? ro.acI() : null;
            if (acI == null) {
                return null;
            }
            if (acI.iGN) {
                InputStream openRead = y.openRead(py);
                if (openRead != null) {
                    return new m(s.SW(py), "UTF-8", openRead);
                }
                return null;
            } else if (bh.ov(acI.iEa)) {
                x.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", acI.iEa);
                return null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", str, py);
                return ba(acI.iEa, py);
            }
        }
        m mVar;
        ro = i.ro(str);
        acI = ro != null ? ro.acH() : null;
        if (acI == null) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", str);
            mVar = null;
        } else if (bh.ov(acI.iEa)) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", acI.iEa, str);
            mVar = null;
        } else {
            String str3 = acI.iEa;
            if (bh.ov(str3)) {
                x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                mVar = null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", str, py);
                mVar = ba(str3, py);
            }
        }
        if (mVar == null) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
            f.a("com.tencent.mm:support", bundle, f$a.class, null);
        }
        return mVar;
    }
}
