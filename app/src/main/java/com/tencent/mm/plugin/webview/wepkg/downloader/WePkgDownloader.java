package com.tencent.mm.plugin.webview.wepkg.downloader;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader {
    private static volatile WePkgDownloader tLS = null;
    private Map<String, IWepkgUpdateCallback> tLT;
    private a tLU = new 1(this);

    static /* synthetic */ void b(g gVar) {
        f fVar = gVar.tLH;
        if (fVar != null) {
            String str = fVar.tMf;
            String str2 = fVar.tMh;
            int i = gVar.tMo;
            int i2 = gVar.lJY;
            int i3 = gVar.mRetryTimes;
            Context context = ac.getContext();
            int i4 = an.isNetworkConnected(context) ? an.is2G(context) ? 2 : an.is3G(context) ? 3 : an.is4G(context) ? 4 : an.isWifi(context) ? 1 : 0 : -1;
            x.i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %d", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            String Qm = a.Qm(fVar.mUrl);
            Object[] objArr = new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), Qm};
            StringBuilder stringBuilder = new StringBuilder();
            for (i4 = 0; i4 < 6; i4++) {
                stringBuilder.append(String.valueOf(objArr[i4])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[6]));
            ar.CG().a(new al(14229, stringBuilder.toString()), 0);
        }
    }

    public static WePkgDownloader bVg() {
        if (tLS == null) {
            synchronized (WePkgDownloader.class) {
                if (tLS == null) {
                    tLS = new WePkgDownloader();
                }
            }
        }
        return tLS;
    }

    public WePkgDownloader() {
        if (this.tLT == null) {
            this.tLT = new ConcurrentHashMap();
        }
    }

    public final void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String eX;
        String str6;
        x.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[]{Integer.valueOf(i), str, str3, Long.valueOf(j), str4, str5, Integer.valueOf(i2)});
        if (i == 1) {
            eX = d.eX(str, str4);
            d.Qu(eX);
            str6 = eX + "/package";
        } else {
            eX = d.eX(str, str4) + "/preload_files";
            d.Qu(eX);
            str6 = eX + "/" + str5;
        }
        if (bh.ov(str6)) {
            x.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[]{str6});
            iWepkgUpdateCallback.a(str, "", RetCode.tMa);
            return;
        }
        if (!com.tencent.mm.pluginsdk.i.a.e.a.bO(str6)) {
            eX = d.Qp(str);
            if (!bh.ov(eX)) {
                File file = new File(eX);
                List<String> arrayList = new ArrayList();
                if (str6 == null || str6.length() <= 0) {
                    eX = "";
                } else {
                    eX = new File(str6).getName();
                    int lastIndexOf = eX.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        eX = lastIndexOf == 0 ? "" : eX.substring(0, lastIndexOf);
                    }
                }
                a(file, eX, arrayList);
                x.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[]{Integer.valueOf(arrayList.size())});
                for (String eX2 : arrayList) {
                    File file2 = new File(eX2);
                    if (file2.isFile() && file2.length() == j && bh.ou(g.i(file2)).equalsIgnoreCase(str5)) {
                        e.x(file2.getAbsolutePath(), str6);
                        x.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[]{file2.getAbsolutePath(), str6});
                        iWepkgUpdateCallback.a(str, str6, RetCode.tLW);
                        return;
                    }
                }
            }
        } else if (bh.ou(g.bV(str6)).equals(str5)) {
            x.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[]{str4, str6});
            iWepkgUpdateCallback.a(str, str6, RetCode.tLW);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        switch (i2) {
            case 1:
                if (an.isWifi(ac.getContext())) {
                    z = true;
                    z2 = true;
                    break;
                }
                break;
            case 3:
                if (an.eS(ac.getContext()) || an.is3G(ac.getContext())) {
                    z = true;
                    break;
                }
            case 4:
                z = true;
                break;
            case 9:
                if (!an.isWifi(ac.getContext())) {
                    if ((an.eS(ac.getContext()) || an.is3G(ac.getContext())) && d.bVo()) {
                        z = true;
                        break;
                    }
                }
                z = true;
                break;
        }
        x.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            Object obj;
            c cVar = new c(new f(g.s(str3.getBytes()), i, str, str2, str4, str3, str6, j, str5, z2, this.tLU));
            d bVe = d.bVe();
            if (bVe.tLR.containsKey(cVar.tLH.tMe)) {
                obj = null;
            } else {
                cVar.tLI = b.bVc().tLG.submit(cVar);
                bVe.tLR.put(cVar.tLH.tMe, cVar);
                obj = 1;
            }
            if (obj != null) {
                this.tLT.put(g.s(str3.getBytes()), iWepkgUpdateCallback);
                return;
            } else {
                iWepkgUpdateCallback.a(str, "", RetCode.tMb);
                return;
            }
        }
        x.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
        iWepkgUpdateCallback.a(str, "", RetCode.tMb);
    }

    private void a(File file, String str, List<String> list) {
        if (file != null && file.exists()) {
            if (file.isFile() && file.getName().equals(str)) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        a(a, str, list);
                    }
                }
            }
        }
    }
}
