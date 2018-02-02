package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mm.bz.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class aa$a {
    private aa$a() {
    }

    public final l a(aa$d com_tencent_mm_plugin_appbrand_appcache_aa_d) {
        String bZj = com_tencent_mm_plugin_appbrand_appcache_aa_d.bZj();
        x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", com_tencent_mm_plugin_appbrand_appcache_aa_d.iFI);
        try {
            ak akVar;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final h hVar = new h();
            final k aaa = com_tencent_mm_plugin_appbrand_appcache_aa_d.aaa();
            final String str = aaa.vgd;
            final p$a com_tencent_mm_plugin_appbrand_appcache_p_a = com_tencent_mm_plugin_appbrand_appcache_aa_d.iFJ;
            if (com_tencent_mm_plugin_appbrand_appcache_aa_d.aaa().iFO) {
                akVar = new ak(a.cll().getLooper(), new ak.a(this) {
                    final /* synthetic */ aa$a iFC;

                    public final boolean uF() {
                        g.MJ().kI(str);
                        com_tencent_mm_plugin_appbrand_appcache_p_a.ZA();
                        b.deleteFile(aaa.getFilePath());
                        hVar.jRK = null;
                        countDownLatch.countDown();
                        return false;
                    }
                }, false);
            } else {
                akVar = null;
            }
            i.a 2 = new 2(this, com_tencent_mm_plugin_appbrand_appcache_aa_d, akVar, hVar, countDownLatch);
            i iVar = new i();
            iVar.field_mediaId = str;
            iVar.field_fullpath = aaa.getFilePath();
            iVar.htu = aaa.url;
            iVar.fLH = false;
            iVar.htt = 2;
            iVar.htv = (int) TimeUnit.MILLISECONDS.toSeconds((long) aaa.getConnectTimeout());
            iVar.htw = (int) TimeUnit.MILLISECONDS.toSeconds((long) aaa.getReadTimeout());
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrV;
            String host = Uri.parse(iVar.htu).getHost();
            if (!bh.ov(host)) {
                ArrayList arrayList = new ArrayList();
                try {
                    com.tencent.mm.kernel.g.Di().gPJ.hmV.getHostByName(host, arrayList);
                    iVar.htx = new String[arrayList.size()];
                    arrayList.toArray(iVar.htx);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", e);
                }
            }
            g.MJ().b(iVar, -1);
            if (akVar != null) {
                long readTimeout = (long) aaa.getReadTimeout();
                akVar.J(readTimeout, readTimeout);
            }
            try {
                countDownLatch.await();
                return (l) hVar.jRK;
            } catch (Exception e2) {
                x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", bZj, e2);
                return null;
            }
        } catch (Exception e22) {
            x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", bZj, e22);
            return null;
        }
    }
}
