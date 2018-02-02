package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.pluginsdk.i.a.d.c;
import com.tencent.mm.pluginsdk.i.a.d.e;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

final class aa$e implements c {
    final /* synthetic */ aa iFG;
    final af iFK = new af(new ag("WxaPkgDownloadPerformerEventDispatchThread").oAt.getLooper());

    aa$e(aa aaVar) {
        this.iFG = aaVar;
    }

    public final void a(e eVar, l lVar) {
        this.iFK.post(new 1(this, lVar, eVar));
    }

    public final void o(String str, int i, int i2) {
    }

    public final void s(String str, long j) {
    }

    public static void b(e eVar, l lVar) {
        e(eVar, lVar);
    }

    public static void c(e eVar, l lVar) {
        ab aaa = ((aa$d) eVar).aaa();
        if (aaa instanceof x) {
            x xVar = (x) aaa;
            p$a com_tencent_mm_plugin_appbrand_appcache_p_a = ((aa$d) eVar).iFJ;
            ai YW = ((a) g.h(a.class)).YW();
            if (YW == null) {
                aj.a(xVar.vgd, xVar.appId, aj$a$b.ENV_ERR, null);
                return;
            }
            String str = xVar.appId;
            int i = xVar.iEZ;
            int i2 = xVar.iFa;
            String ZS = xVar.ZS();
            ae a = YW.a(str, i, 0, new String[]{"pkgPath"});
            ae a2 = YW.a(str, i2, 0, new String[]{"versionMd5"});
            if (a == null || a2 == null) {
                aj.a(xVar.vgd, xVar.appId, aj$a$b.ENV_ERR, null);
                return;
            }
            com_tencent_mm_plugin_appbrand_appcache_p_a.ZC();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int v = f.v(a.field_pkgPath, ZS, xVar.getFilePath());
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            x.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", xVar.appId, a.field_pkgPath, ZS, xVar.getFilePath(), Long.valueOf(elapsedRealtime), Integer.valueOf(v));
            com_tencent_mm_plugin_appbrand_appcache_p_a.jw(v);
            if (v == 0) {
                aj.a(xVar.vgd, xVar.appId, ZS, i2, 0, com_tencent_mm_plugin_appbrand_appcache_p_a);
                return;
            }
            b.deleteFile(ZS);
            ae a3 = YW.a(xVar.appId, xVar.iFa, 0, new String[]{"downloadURL"});
            if (a3 == null) {
                aj.a(xVar.vgd, xVar.appId, aj$a$b.ENV_ERR, null);
                return;
            }
            aj.pN(xVar.vgd);
            aj.b(xVar.appId, 0, xVar.iFa, a3.field_downloadURL, xVar.iFb);
            return;
        }
        String str2 = ((aa$d) eVar).aaa().appId;
        try {
            aj.a(lVar.vgd, str2, lVar.filePath, ((aa$d) eVar).aaa().version, ((aa$d) eVar).aaa().fvM, ((aa$d) eVar).iFJ);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
            aj.aK(lVar.vgd, str2);
        }
    }

    public static void d(e eVar, l lVar) {
        e(eVar, lVar);
    }

    private static void e(e eVar, l lVar) {
        aj$a$b com_tencent_mm_plugin_appbrand_appcache_aj_a_b;
        b.deleteFile(lVar.filePath);
        String str = ((aa$d) eVar).aaa().appId;
        if (!(lVar.vhO instanceof com.tencent.mm.pluginsdk.i.a.c.a)) {
            switch (lVar.httpStatusCode) {
                case ap.CTRL_INDEX /*403*/:
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    com_tencent_mm_plugin_appbrand_appcache_aj_a_b = aj$a$b.SEVER_FILE_NOT_FOUND;
                    break;
                default:
                    com_tencent_mm_plugin_appbrand_appcache_aj_a_b = aj$a$b.FAILED;
                    break;
            }
        }
        com_tencent_mm_plugin_appbrand_appcache_aj_a_b = aj$a$b.DISK_FULL;
        aj.a(lVar.vgd, str, com_tencent_mm_plugin_appbrand_appcache_aj_a_b);
    }
}
