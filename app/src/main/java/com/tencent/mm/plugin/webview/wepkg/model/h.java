package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.bzx;
import com.tencent.mm.protocal.c.bzz;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.protocal.c.cab;
import com.tencent.mm.protocal.c.cac;
import com.tencent.mm.protocal.c.cad;
import com.tencent.mm.protocal.c.cae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h {
    public static WepkgVersion Qi(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 3001;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.tMS == null) {
            return null;
        }
        return wepkgCrossProcessTask.tMS;
    }

    public static WepkgVersion Qj(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 3002;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.tMS == null) {
            return null;
        }
        return wepkgCrossProcessTask.tMS;
    }

    public static void a(String str, String str2, boolean z, a aVar) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 3005;
        wepkgCrossProcessTask.tMS.tNm = str;
        wepkgCrossProcessTask.tMS.iEa = str2;
        wepkgCrossProcessTask.tMS.tNI = z;
        if (ac.cfw()) {
            d.Dm().F(new 8(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.jcI = new 9(aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, a aVar) {
        final WepkgMainProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i;
        wepkgDownloadProcessTask.fME = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.tMY = j;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.fqR = str5;
        wepkgDownloadProcessTask.tMZ = i2;
        if (ac.cfw()) {
            d.Dm().F(new 12(i, str, str2, str3, j, str4, str5, i2, wepkgDownloadProcessTask, aVar));
            return;
        }
        final a aVar2 = aVar;
        wepkgDownloadProcessTask.jcI = new Runnable() {
            public final void run() {
                if (aVar2 != null) {
                    aVar2.a(wepkgDownloadProcessTask);
                }
                wepkgDownloadProcessTask.afj();
            }
        };
        wepkgDownloadProcessTask.afi();
        WepkgMainProcessService.a(wepkgDownloadProcessTask);
    }

    public static void a(axe com_tencent_mm_protocal_c_axe) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 2002;
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.tMS;
        if (com_tencent_mm_protocal_c_axe != null) {
            wepkgVersion.tNm = com_tencent_mm_protocal_c_axe.vXf;
            cac com_tencent_mm_protocal_c_cac = com_tencent_mm_protocal_c_axe.wEt;
            cae com_tencent_mm_protocal_c_cae = com_tencent_mm_protocal_c_axe.wEu;
            if (com_tencent_mm_protocal_c_cac != null) {
                wepkgVersion.appId = com_tencent_mm_protocal_c_cac.ngo;
                bzz com_tencent_mm_protocal_c_bzz = com_tencent_mm_protocal_c_cac.wZK;
                if (com_tencent_mm_protocal_c_bzz != null) {
                    wepkgVersion.version = com_tencent_mm_protocal_c_bzz.wZE;
                    wepkgVersion.tNC = com_tencent_mm_protocal_c_bzz.wZF;
                    wepkgVersion.tND = (long) com_tencent_mm_protocal_c_bzz.wZG;
                    wepkgVersion.tNE = (long) com_tencent_mm_protocal_c_bzz.wZH;
                }
            }
            if (com_tencent_mm_protocal_c_cae != null) {
                wepkgVersion.fMh = com_tencent_mm_protocal_c_cae.wZN;
                wepkgVersion.charset = com_tencent_mm_protocal_c_cae.wYs;
                bzx com_tencent_mm_protocal_c_bzx = com_tencent_mm_protocal_c_cae.wZO;
                if (com_tencent_mm_protocal_c_bzx == null || com_tencent_mm_protocal_c_bzx.wZB == null || bh.ov(com_tencent_mm_protocal_c_bzx.wZB.vNd)) {
                    wepkgVersion.tNI = true;
                } else {
                    wepkgVersion.fqR = com_tencent_mm_protocal_c_bzx.wZB.vZL;
                    wepkgVersion.downloadUrl = com_tencent_mm_protocal_c_bzx.wZB.vNd;
                    wepkgVersion.tNG = com_tencent_mm_protocal_c_bzx.wZB.wZJ;
                    wepkgVersion.tMZ = com_tencent_mm_protocal_c_bzx.wZB.wZI;
                    wepkgVersion.tNI = false;
                }
                cad com_tencent_mm_protocal_c_cad = com_tencent_mm_protocal_c_cae.wZP;
                if (com_tencent_mm_protocal_c_cad != null) {
                    wepkgVersion.tNK = com_tencent_mm_protocal_c_cad.wZM;
                }
                if (com_tencent_mm_protocal_c_cad == null || bh.cA(com_tencent_mm_protocal_c_cad.wZL) || !com_tencent_mm_protocal_c_cad.wZM) {
                    wepkgVersion.tNJ = true;
                } else {
                    wepkgVersion.tNJ = false;
                }
                wepkgVersion.tNL = 0;
            }
        }
        cad com_tencent_mm_protocal_c_cad2 = com_tencent_mm_protocal_c_axe.wEu.wZP;
        if (!(com_tencent_mm_protocal_c_cad2 == null || bh.cA(com_tencent_mm_protocal_c_cad2.wZL))) {
            List arrayList = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_cad2.wZL.iterator();
            while (it.hasNext()) {
                cab com_tencent_mm_protocal_c_cab = (cab) it.next();
                WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                String str = com_tencent_mm_protocal_c_axe.vXf;
                String str2 = com_tencent_mm_protocal_c_axe.wEt.wZK.wZE;
                if (com_tencent_mm_protocal_c_cab != null) {
                    wepkgPreloadFile.aAM = d.eY(str, com_tencent_mm_protocal_c_cab.wgp);
                    wepkgPreloadFile.tNm = str;
                    wepkgPreloadFile.version = str2;
                    wepkgPreloadFile.tMX = com_tencent_mm_protocal_c_cab.wgp;
                    wepkgPreloadFile.mimeType = com_tencent_mm_protocal_c_cab.wgr;
                    caa com_tencent_mm_protocal_c_caa = com_tencent_mm_protocal_c_cab.wZB;
                    if (com_tencent_mm_protocal_c_caa != null) {
                        wepkgPreloadFile.fqR = com_tencent_mm_protocal_c_caa.vZL;
                        wepkgPreloadFile.downloadUrl = com_tencent_mm_protocal_c_caa.vNd;
                        wepkgPreloadFile.size = com_tencent_mm_protocal_c_caa.wZJ;
                        wepkgPreloadFile.tMZ = com_tencent_mm_protocal_c_caa.wZI;
                    }
                    wepkgPreloadFile.tNn = false;
                }
                arrayList.add(wepkgPreloadFile);
            }
            wepkgCrossProcessTask.tMV = arrayList;
        }
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
    }

    public static List<WepkgPreloadFile> Qk(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 4001;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.tMV;
    }

    public static void a(String str, String str2, String str3, a aVar) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 4002;
        wepkgCrossProcessTask.tMU.tNm = str;
        wepkgCrossProcessTask.tMU.tMX = str2;
        wepkgCrossProcessTask.tMU.filePath = str3;
        wepkgCrossProcessTask.tMU.tNn = false;
        if (ac.cfw()) {
            d.Dm().F(new 4(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.jcI = new 5(aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static List<WepkgPreloadFile> Ql(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 4003;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.tMV;
    }
}
