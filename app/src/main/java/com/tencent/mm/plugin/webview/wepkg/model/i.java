package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.g.a.tv;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class i {
    private static volatile i tNx = null;

    static /* synthetic */ void a(i iVar, String str, boolean z) {
        if (bh.ov(str)) {
            k(z, str);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "update preload files. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        List Qk = h.Qk(str);
        if (!bh.cA(Qk)) {
            x.i("MicroMsg.Wepkg.WepkgUpdater", "pkgid:%s, %s preload files need to download", new Object[]{str, Integer.valueOf(Qk.size())});
        }
        iVar.a(str, Qk, z);
    }

    public static i bVl() {
        if (tNx == null) {
            synchronized (i.class) {
                if (tNx == null) {
                    tNx = new i();
                }
            }
        }
        return tNx;
    }

    public final void aU(String str, boolean z) {
        if (bh.ov(str)) {
            k(z, str);
            return;
        }
        a 1 = new 1(this, z, str);
        1.object = str;
        x.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        if (bh.ov(str)) {
            k(z, str);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        WepkgVersion Qi = h.Qi(str);
        if (Qi == null) {
            k(z, str);
        } else if (Qi.tNI) {
            1.a(null);
        } else {
            h.a(1, Qi.tNm, "", Qi.downloadUrl, (long) Qi.tNG, Qi.version, Qi.fqR, Qi.tMZ, new 2(this, 1, z, str));
        }
    }

    private void a(String str, List<WepkgPreloadFile> list, boolean z) {
        try {
            if (bh.cA(list)) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (bh.ov(str)) {
                    k(z, str);
                    return;
                }
                if (bh.cA(h.Qk(str))) {
                    WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.pK = 3006;
                    wepkgCrossProcessTask.tMS.tNm = str;
                    wepkgCrossProcessTask.tMS.tNJ = true;
                    if (ac.cfw()) {
                        wepkgCrossProcessTask.Yr();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion Qi = h.Qi(str);
                    if (!(Qi == null || Qi.hVE == 0)) {
                        a.b("downloadCompleteTime", "", Qi.tNm, Qi.version, -1, System.currentTimeMillis() - (Qi.hVE * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.pK = 3007;
                        wepkgCrossProcessTask.tMS.tNm = str;
                        if (ac.cfw()) {
                            wepkgCrossProcessTask.Yr();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                    }
                    k(z, str);
                    x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    return;
                }
                x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[]{Integer.valueOf(h.Qk(str).size())});
                k(z, str);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[]{wepkgPreloadFile.tNm, wepkgPreloadFile.version, wepkgPreloadFile.tMX});
                a 3 = new 3(this, str, list, z);
                3.object = wepkgPreloadFile;
                h.a(2, wepkgPreloadFile.tNm, wepkgPreloadFile.tMX, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.fqR, wepkgPreloadFile.tMZ, 3);
                return;
            }
            x.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            a(str, (List) list, z);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[]{e.getMessage()});
        }
    }

    private static void k(boolean z, String str) {
        if (z) {
            b tvVar = new tv();
            tvVar.fMD.fpr = 0;
            com.tencent.mm.sdk.b.a.xef.m(tvVar);
        }
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = TXLiveConstants.PLAY_EVT_PLAY_END;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        g.Qf(str);
    }
}
