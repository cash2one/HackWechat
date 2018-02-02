package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.webview.wepkg.a.b;
import com.tencent.mm.plugin.webview.wepkg.a.d;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask.1;
import com.tencent.mm.plugin.webview.wepkg.model.h.6;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.bzx;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.protocal.c.cac;
import com.tencent.mm.protocal.c.cad;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

class WepkgVersionManager$WepkgNetSceneProcessTask$1$1 implements Runnable {
    final /* synthetic */ ny tNR;
    final /* synthetic */ 1 tNS;

    WepkgVersionManager$WepkgNetSceneProcessTask$1$1(1 1, ny nyVar) {
        this.tNS = 1;
        this.tNR = nyVar;
    }

    public final void run() {
        ny nyVar = this.tNR;
        int b = WepkgNetSceneProcessTask.b(this.tNS.tNQ);
        if (nyVar == null) {
            return;
        }
        if (bh.cA(nyVar.vWJ)) {
            x.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
            return;
        }
        axe com_tencent_mm_protocal_c_axe = (axe) nyVar.vWJ.get(0);
        if (com_tencent_mm_protocal_c_axe != null) {
            String str = com_tencent_mm_protocal_c_axe.vXf;
            cac com_tencent_mm_protocal_c_cac = com_tencent_mm_protocal_c_axe.wEt;
            bzy com_tencent_mm_protocal_c_bzy = com_tencent_mm_protocal_c_axe.wEv;
            if (!bh.ov(str)) {
                if (com_tencent_mm_protocal_c_bzy != null) {
                    if (com_tencent_mm_protocal_c_bzy.wZD) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now. binder:%d", new Object[]{Integer.valueOf(b)});
                        ac.getContext().sendBroadcast(new Intent("com.tencent.mm.ACTION_RELOAD").putExtra("hashcode", b), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
                        x.i("MicroMsg.Wepkg.WepkgManager", "sync clear wepkg info, pkgid:%s", new Object[]{str});
                        d.bVa().PQ(str);
                        b.bUZ().PQ(str);
                        g.Qg(com.tencent.mm.plugin.webview.wepkg.utils.d.Qp(str));
                        if (com.tencent.mm.plugin.webview.wepkg.utils.b.tNV != null) {
                            com.tencent.mm.plugin.webview.wepkg.utils.b.tNV.Qo(str);
                        }
                    }
                    if (com_tencent_mm_protocal_c_bzy.wZC) {
                        g.Qe(str);
                        return;
                    }
                }
                if (com_tencent_mm_protocal_c_cac != null && com_tencent_mm_protocal_c_cac.wZK != null) {
                    if (bh.ov(com_tencent_mm_protocal_c_cac.wZK.wZE)) {
                        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.pK = TXLiveConstants.PLAY_EVT_PLAY_BEGIN;
                        wepkgCrossProcessTask.tMS.tNm = str;
                        if (ac.cfw()) {
                            com.tencent.mm.plugin.webview.wepkg.utils.d.Dm().F(new 6(wepkgCrossProcessTask, null));
                            return;
                        }
                        wepkgCrossProcessTask.jcI = new h$7(null, wepkgCrossProcessTask);
                        wepkgCrossProcessTask.afi();
                        WepkgMainProcessService.a(wepkgCrossProcessTask);
                        return;
                    }
                    boolean z = com_tencent_mm_protocal_c_cac.wZK.wZF;
                    long j = (long) com_tencent_mm_protocal_c_cac.wZK.wZG;
                    long j2 = (long) com_tencent_mm_protocal_c_cac.wZK.wZH;
                    WepkgMainProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask2.pK = TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT;
                    wepkgCrossProcessTask2.tMS.tNm = str;
                    wepkgCrossProcessTask2.tMS.tNC = z;
                    wepkgCrossProcessTask2.tMS.tND = j;
                    wepkgCrossProcessTask2.tMS.tNE = j2;
                    if (ac.cfw()) {
                        wepkgCrossProcessTask2.Yr();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask2);
                    }
                    WepkgMainProcessTask wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask3.pK = 3009;
                    wepkgCrossProcessTask3.tMS.tNm = str;
                    if (ac.cfw()) {
                        wepkgCrossProcessTask3.Yr();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask3);
                    }
                    wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask3.pK = 4006;
                    wepkgCrossProcessTask3.tMU.tNm = str;
                    if (ac.cfw()) {
                        wepkgCrossProcessTask3.Yr();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask3);
                    }
                    i bVl = i.bVl();
                    if (com_tencent_mm_protocal_c_axe == null || com_tencent_mm_protocal_c_axe.wEu == null) {
                        x.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                        if (com_tencent_mm_protocal_c_axe != null) {
                            bVl.aU(com_tencent_mm_protocal_c_axe.vXf, false);
                            return;
                        }
                        return;
                    }
                    bzx com_tencent_mm_protocal_c_bzx = com_tencent_mm_protocal_c_axe.wEu.wZO;
                    cad com_tencent_mm_protocal_c_cad = com_tencent_mm_protocal_c_axe.wEu.wZP;
                    if (com_tencent_mm_protocal_c_bzx == null && com_tencent_mm_protocal_c_cad == null) {
                        x.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                        g.Qe(com_tencent_mm_protocal_c_axe.vXf);
                        return;
                    }
                    h.a(com_tencent_mm_protocal_c_axe);
                    bVl.aU(com_tencent_mm_protocal_c_axe.vXf, false);
                }
            }
        }
    }
}
