package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public ConcurrentHashMap<Long, WeakReference<a>> rfy;
    public ConcurrentHashMap<String, b> rfz;

    private a() {
        this.rfy = new ConcurrentHashMap();
        this.rfz = new ConcurrentHashMap();
        f.aAd();
        c.a(new 1(this));
    }

    public static void stopTask(long j) {
        f.aAd().bX(j);
    }

    public static long queryIdByAppid(String str) {
        FileDownloadTaskInfo xI = f.aAd().xI(str);
        return xI != null ? xI.id : Long.MAX_VALUE;
    }

    public final void H(int i, long j) {
        com.tencent.mm.plugin.downloader.e.a cl = ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fe().cl(j);
        if (cl != null) {
            String str = cl.field_appId;
            cl = ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fe().xE(str);
            if (cl == null) {
                x.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
                return;
            }
            String str2 = cl.field_packageName;
            String str3 = cl.field_md5;
            d(i, str, str2, cl.field_downloadUrl);
        }
    }

    private static String o(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[3]));
        return stringBuilder.toString();
    }

    public final void d(int i, String str, String str2, String str3) {
        System.currentTimeMillis();
        b bVar = (b) this.rfz.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        x.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[]{Integer.valueOf(14542), o(str, Integer.valueOf(i), str3, bVar == null ? "" : bVar.reb + "." + bVar.iUN + "." + str2 + ".0.20.0")});
        x.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : " + r0);
        com.tencent.mm.plugin.report.service.g.pQN.k(14542, r1);
    }
}
