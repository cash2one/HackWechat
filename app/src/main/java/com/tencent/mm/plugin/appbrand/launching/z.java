package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

abstract class z extends x<WxaPkgWrappingInfo> implements j {
    final String appId;
    int iGL;
    final int iKd;
    final d iPk;
    String iUj = null;
    final int jxz;
    private WxaPkgWrappingInfo jyf;

    private final class a implements Callable<WxaPkgWrappingInfo> {
        private final int jyg;
        private final int jyh;
        private final ain jyi;
        final /* synthetic */ z jyj;

        public final /* synthetic */ Object call() {
            return (bh.ov(this.jyi.fyG) || !h.ZG()) ? new b().ada() : aia();
        }

        private a(z zVar, int i, int i2, ain com_tencent_mm_protocal_c_ain) {
            this.jyj = zVar;
            this.jyg = i;
            this.jyh = i2;
            this.jyi = com_tencent_mm_protocal_c_ain;
        }

        private WxaPkgWrappingInfo aia() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            com.tencent.mm.plugin.appbrand.p.h hVar = new com.tencent.mm.plugin.appbrand.p.h();
            if (!f.a(this.jyj.appId, this.jyg, this.jyh, this.jyi.fyG, new 1(this, this.jyj.iKd, hVar, countDownLatch))) {
                return null;
            }
            try {
                countDownLatch.await();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadIncremental semaphore exp ", new Object[0]);
            }
            return (WxaPkgWrappingInfo) hVar.jRK;
        }
    }

    private final class b implements Callable<WxaPkgWrappingInfo> {
        final /* synthetic */ z jyj;

        private b(z zVar) {
            this.jyj = zVar;
        }

        public final /* synthetic */ Object call() {
            return ada();
        }

        public final WxaPkgWrappingInfo ada() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            com.tencent.mm.plugin.appbrand.p.h hVar = new com.tencent.mm.plugin.appbrand.p.h();
            com.tencent.mm.plugin.appbrand.appcache.aj.a 1 = new 1(this, this.jyj.iKd, hVar, countDownLatch);
            x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[]{this.jyj.appId, Integer.valueOf(this.jyj.iKd), Integer.valueOf(this.jyj.iGL)});
            if (this.jyj.iKd != 0) {
                this.jyj.iUj = com.tencent.mm.plugin.appbrand.app.f.Zo().ah(this.jyj.appId, this.jyj.iKd);
                if (bh.ov(this.jyj.iUj)) {
                    x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d)", new Object[]{this.jyj.appId, Integer.valueOf(this.jyj.iKd)});
                    this.jyj.a(com.tencent.mm.plugin.appbrand.appcache.ad.a.iFV);
                    return null;
                }
            }
            if (aj.a(this.jyj.appId, this.jyj.iKd, this.jyj.iGL, this.jyj.iPk.iPH, this.jyj.iUj, 1)) {
                new 2(this).ceO();
                try {
                    countDownLatch.await();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadNonIncremental semaphore exp ", new Object[0]);
                }
                return (WxaPkgWrappingInfo) hVar.jRK;
            }
            x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[]{this.jyj.appId, Integer.valueOf(this.jyj.iKd), Integer.valueOf(this.jyj.iGL)});
            this.jyj.a(com.tencent.mm.plugin.appbrand.appcache.ad.a.iFZ);
            return null;
        }
    }

    public /* synthetic */ Object call() {
        return ada();
    }

    z(String str, int i, int i2, int i3, d dVar) {
        this.appId = str;
        this.iKd = i;
        this.iGL = i2;
        this.jxz = i3;
        this.iPk = dVar;
    }

    public void ahO() {
    }

    public void ahQ() {
    }

    private WxaPkgWrappingInfo ada() {
        Pair p = ad.p(this.appId, this.iKd, this.iGL);
        if (p.second != null) {
            return (WxaPkgWrappingInfo) p.second;
        }
        if (com.tencent.mm.plugin.appbrand.appcache.ad.a.iFY.equals(p.first)) {
            WxaPkgWrappingInfo c;
            if (this.iKd == 0) {
                this.jyf = f.sZ(this.appId);
                try {
                    ae a = com.tencent.mm.plugin.appbrand.app.f.Zo().a(this.appId, 0, new String[]{"version", "versionMd5", "versionState"});
                    if (a == null) {
                        throw new com.tencent.mm.plugin.appbrand.launching.j.a.a().f(c.getMMString(j.iAY, new Object[]{com.tencent.mm.plugin.appbrand.appcache.a.ju(this.iKd)}), new Object[0]).g("get NULL record with md5", new Object[0]).ahV();
                    }
                    long Wp = bh.Wp();
                    int i = a.field_version;
                    int i2 = this.jyf == null ? 0 : this.jyf.iGL;
                    com.tencent.mm.ae.a.a c2 = com.tencent.mm.plugin.appbrand.i.c.c(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, 0, i2).gJQ);
                    if (c2 != null && c2.errType == 0 && c2.errCode == 0) {
                        s.a(s$a.GET_DOWNLOAD_URL, this.appId, i, this.iKd, this.jxz, bh.Wp() - Wp);
                        if (bh.ov(((ain) c2.fJJ).url)) {
                            throw new com.tencent.mm.plugin.appbrand.launching.j.a.a().g("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[]{Integer.valueOf(((ain) c2.fJJ).ret)}).ahV();
                        }
                        cbc com_tencent_mm_protocal_c_cbc = new cbc();
                        String str = ((ain) c2.fJJ).url;
                        this.iUj = str;
                        com_tencent_mm_protocal_c_cbc.xat = str;
                        int i3 = a.field_version;
                        this.iGL = i3;
                        com_tencent_mm_protocal_c_cbc.vNa = i3;
                        com_tencent_mm_protocal_c_cbc.xar = a.field_versionState;
                        com_tencent_mm_protocal_c_cbc.xas = a.field_versionMd5;
                        com.tencent.mm.plugin.appbrand.app.f.Zo().a(this.appId, com_tencent_mm_protocal_c_cbc, 0);
                        if (this.iPk.iPH > 0) {
                            long Wp2 = bh.Wp();
                            com.tencent.mm.plugin.appbrand.appcache.n.a bC = n.bC((long) this.iPk.iPH);
                            Wp2 = bh.Wp() - Wp2;
                            x.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[]{Integer.valueOf(this.iPk.iPH), Long.valueOf(Wp2), bC.name()});
                        }
                        c = c(new a(i2, i, (ain) c2.fJJ));
                        if (c != null) {
                            return c;
                        }
                        throw new com.tencent.mm.plugin.appbrand.launching.j.a.a().g("Download Fail", new Object[0]).ahV();
                    }
                    String mMString;
                    if (c2 == null || c2.errCode != -1001) {
                        int i4 = j.iAT;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(c2 == null ? -1 : c2.errType);
                        objArr[1] = Integer.valueOf(c2 == null ? -1 : c2.errCode);
                        mMString = y.getMMString(i4, objArr);
                    } else {
                        mMString = y.getMMString(j.iAV, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.launching.j.a.a aVar = new com.tencent.mm.plugin.appbrand.launching.j.a.a();
                    String str2 = "fail get download url, resp %s";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = c2 == null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(c2.errType), Integer.valueOf(c2.errCode)});
                    throw aVar.g(str2, objArr2).f(mMString, new Object[0]).ahV();
                } catch (com.tencent.mm.plugin.appbrand.launching.j.a e) {
                    com.tencent.mm.plugin.appbrand.launching.j.a aVar2 = e;
                    x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[]{this.appId, aVar2.getMessage()});
                    c = f.sZ(this.appId);
                    if (c != null) {
                        return c;
                    }
                    if (!bh.ov(aVar2.jxM)) {
                        y.ta(aVar2.jxM);
                    }
                    return null;
                }
            }
            c = c(new b());
            if (c != null) {
                return c;
            }
        }
        a((com.tencent.mm.plugin.appbrand.appcache.ad.a) p.first);
        return null;
    }

    private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> callable) {
        if (callable == this) {
            Assert.assertTrue("Why the hell you pass 'this' to this method", false);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        ahO();
        try {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) callable.call();
        } catch (Exception e) {
            wxaPkgWrappingInfo = null;
        }
        ahQ();
        return wxaPkgWrappingInfo;
    }

    final void a(com.tencent.mm.plugin.appbrand.appcache.ad.a aVar) {
        if (com.tencent.mm.plugin.appbrand.appcache.ad.a.iFV.equals(aVar)) {
            String mMString;
            if (this.iKd == 1) {
                mMString = c.getMMString(j.iAc, new Object[0]);
            } else {
                mMString = c.getMMString(j.iAY, new Object[]{com.tencent.mm.plugin.appbrand.appcache.a.ju(this.iKd)});
            }
            if (this.iKd == 1) {
                com.tencent.mm.plugin.appbrand.task.d.aJ(this.appId, this.iKd);
                com.tencent.mm.plugin.appbrand.report.a.z(this.appId, 10, this.iKd + 1);
            }
            y.ta(mMString);
        } else if (com.tencent.mm.plugin.appbrand.appcache.ad.a.iFX.equals(aVar) || com.tencent.mm.plugin.appbrand.appcache.ad.a.iFW.equals(aVar)) {
            y.kP(this.iKd != 0 ? j.iAc : j.iAe);
            if (this.iKd == 1) {
                com.tencent.mm.plugin.appbrand.report.a.z(this.appId, 10, this.iKd + 1);
            }
            com.tencent.mm.plugin.appbrand.task.d.aJ(this.appId, this.iKd);
        } else {
            y.ta(c.getMMString(j.iAW, new Object[]{Integer.valueOf(1), Integer.valueOf(aVar.aak())}));
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
