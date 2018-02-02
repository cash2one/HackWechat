package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.util.Pair;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ad.a;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.aj$a;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int iUh = 0;
    public static int iUi = 1;
    final String appId;
    final int fvM;
    volatile int iGL;
    String iRN;
    int iUf;
    volatile String iUj;
    final String id;

    public final /* synthetic */ Object call() {
        return ada();
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this.id = str;
        this.appId = str2;
        this.fvM = i;
        this.iGL = i2;
        this.iUj = str4;
        this.iUf = i3;
        this.iRN = str3;
    }

    public final WxaPkgWrappingInfo ada() {
        int i = 1;
        Pair p = ad.p(this.appId, this.fvM, this.iGL);
        if (p.second != null) {
            return (WxaPkgWrappingInfo) p.second;
        }
        int i2;
        if (a.iFY.equals(p.first)) {
            if (this.fvM == 10002 || this.fvM == 10102) {
                ae a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(this.appId, this.fvM, "version", "versionMd5", "versionState");
                if (a == null) {
                    a((a) p.first);
                    return null;
                }
                i2 = this.fvM == 10102 ? 2 : 1;
                com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rz(this.appId);
                com.tencent.mm.ae.a.a c = c.c(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, i2).gJQ);
                if (c != null && c.errType == 0 && c.errCode == 0) {
                    if (this.iUf == 1) {
                        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.R(this.appId, true);
                    }
                    if (bh.ov(((ain) c.fJJ).url)) {
                        if (this.iUf == 1) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRN + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                        }
                        return null;
                    }
                    if (this.iUf == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRN + "-" + this.appId, Integer.valueOf(5), Long.valueOf(System.currentTimeMillis())});
                    }
                    cbc com_tencent_mm_protocal_c_cbc = new cbc();
                    String str = ((ain) c.fJJ).url;
                    this.iUj = str;
                    com_tencent_mm_protocal_c_cbc.xat = str;
                    i2 = a.field_version;
                    this.iGL = i2;
                    com_tencent_mm_protocal_c_cbc.vNa = i2;
                    com_tencent_mm_protocal_c_cbc.xar = a.field_versionState;
                    com_tencent_mm_protocal_c_cbc.xas = a.field_versionMd5;
                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(this.appId, com_tencent_mm_protocal_c_cbc, this.fvM);
                } else {
                    if (this.iUf == 1) {
                        if (this.id != null && this.id.length() > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, this.id);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        }
                        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.R(this.appId, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRN + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                    }
                    return null;
                }
            }
            WxaPkgWrappingInfo adb = adb();
            if (adb != null) {
                if (this.iUf != 1) {
                    return adb;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRN + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis())});
                return adb;
            } else if (this.iUf == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRN + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis())});
            }
        } else if (!a.iFU.equals(p.first)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[]{this.appId, Integer.valueOf(this.fvM), Integer.valueOf(this.iGL), Integer.valueOf(((a) p.first).aak())});
        }
        if (this.fvM == 10002 || this.fvM == 10102) {
            int[] pM = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().pM(this.appId);
            if (pM != null && pM.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair p2 = ad.p(this.appId, this.fvM, pM[i]);
                    if (p2 != null && p2.first == a.iFU && p2.second != null) {
                        return (WxaPkgWrappingInfo) p2.second;
                    }
                    if (i2 >= pM.length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        a((a) p.first);
        return null;
    }

    private WxaPkgWrappingInfo adb() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final h hVar = new h();
        aj$a anonymousClass1 = new aj$a(this) {
            final /* synthetic */ b iUl;

            public final void a(String str, com.tencent.mm.plugin.appbrand.appcache.aj$a.b bVar, aj$a.a aVar) {
                x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdatingCallback, appId = %s, return = %s", new Object[]{str, bVar.name()});
                if (com.tencent.mm.plugin.appbrand.appcache.aj$a.b.iGB.equals(bVar)) {
                    WxaPkgWrappingInfo pO = WxaPkgWrappingInfo.pO(aVar.filePath);
                    if (pO == null) {
                        x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdatingCallback, ret=OK but obtain null appPkgInfo");
                    } else {
                        pO.iGL = aVar.version;
                        pO.iGM = bh.Wo();
                        pO.iGK = aVar.iGA;
                        hVar.jRK = pO;
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.aj$a.b.iGG.equals(bVar);
                }
                countDownLatch.countDown();
            }
        };
        if (this.fvM == 10002 || this.fvM == 10102) {
            x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.iGL)});
            if (!aj.b(this.appId, this.fvM, this.iGL, this.iUj, anonymousClass1)) {
                a(a.iFZ);
                return null;
            }
        }
        x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[]{this.appId, Integer.valueOf(this.fvM)});
        if (((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW() == null) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            a(a.iFZ);
            return null;
        }
        String ah = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().ah(this.appId, this.fvM);
        if (bh.ov(ah)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil");
            a(a.iFV);
            return null;
        }
        aj.a(this.appId, this.fvM, ah, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) hVar.jRK;
    }

    private static void a(a aVar) {
        if (!a.iFV.equals(aVar) && !a.iFX.equals(aVar) && a.iFW.equals(aVar)) {
        }
    }
}
