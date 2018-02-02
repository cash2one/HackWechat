package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class WepkgVersionManager {
    public static void U(String str, int i, int i2) {
        if (!bh.ov(str)) {
            WepkgVersion Qi = h.Qi(str);
            if (Qi == null) {
                o(str, "", i, i2);
                return;
            }
            long j = Qi.tNH;
            if (d.alI() >= j) {
                o(str, Qi.version, i, i2);
                WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.pK = 3003;
                wepkgCrossProcessTask.tMS.tNm = str;
                if (ac.cfw()) {
                    d.Dm().F(new 1(wepkgCrossProcessTask));
                    return;
                } else {
                    WepkgMainProcessService.a(wepkgCrossProcessTask);
                    return;
                }
            }
            x.i("MicroMsg.Wepkg.WepkgVersionManager", "currTime[%s]s < nextCheckTime[%s]s, no net request", new Object[]{Long.valueOf(d.alI()), Long.valueOf(j)});
        }
    }

    private static void o(String str, String str2, int i, int i2) {
        x.i("MicroMsg.Wepkg.WepkgVersionManager", "pkgId = " + str + ", version = " + str2 + ", scene = " + i + ", binder = " + i2);
        LinkedList linkedList = new LinkedList();
        of ofVar = new of();
        ofVar.vXf = str;
        ofVar.ktA = str2;
        ofVar.rYW = i;
        linkedList.add(ofVar);
        g(linkedList, i2);
    }

    private static void g(LinkedList<of> linkedList, int i) {
        if (linkedList.size() != 0) {
            WepkgMainProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
            WepkgNetSceneProcessTask.a(wepkgNetSceneProcessTask, i);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                of ofVar = (of) it.next();
                WepkgCheckReq wepkgCheckReq = new WepkgCheckReq((byte) 0);
                WepkgCheckReq.a(wepkgCheckReq, ofVar.vXf);
                WepkgCheckReq.b(wepkgCheckReq, ofVar.ktA);
                WepkgCheckReq.a(wepkgCheckReq, ofVar.rYW);
                WepkgNetSceneProcessTask.a(wepkgNetSceneProcessTask).add(wepkgCheckReq);
            }
            if (ac.cfw()) {
                d.Dm().F(new 2(wepkgNetSceneProcessTask));
            } else {
                WepkgMainProcessService.a(wepkgNetSceneProcessTask);
            }
        }
    }
}
