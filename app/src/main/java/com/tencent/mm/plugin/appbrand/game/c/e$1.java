package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Debug.MemoryInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e iYO;

    public e$1(e eVar) {
        this.iYO = eVar;
    }

    public final boolean uF() {
        e eVar = this.iYO;
        int i = i.iZn.iZt == null ? 0 : i.iZn.iZt.booleanValue() ? 1 : 2;
        eVar.iYM = i;
        e oQ = com.tencent.mm.plugin.appbrand.a.oQ(i.iZn.mAppId);
        i = (oQ == null || oQ.iqu == null) ? 0 : oQ.iqu.YJ();
        eVar.iYN = i;
        i iVar = i.iZn;
        int currentTimeMillis = (int) (iVar.iZw <= 0 ? 0 : System.currentTimeMillis() - iVar.iZw);
        f aei = i.iZn.aei();
        if (aei != null) {
            i = aei.iZd;
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYQ.iYZ), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN), Integer.valueOf(eVar.iYM)});
        }
        h aeh = i.iZn.aeh();
        if (aeh != null) {
            MemoryInfo aeg = h.aeg();
            int b = h.b(aeg);
            int i2 = aeg == null ? 0 : aeg.nativePss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            int i3 = aeg == null ? 0 : aeg.dalvikPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            i = aeg == null ? 0 : aeg.otherPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            int a = aeh.a(aeg);
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYR.iYZ), Integer.valueOf(b), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYV.iYZ), Integer.valueOf(i2), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYW.iYZ), Integer.valueOf(i3), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYX.iYZ), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYY.iYZ), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] other = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(b), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN), Integer.valueOf(eVar.iYM)});
        }
        g aej = i.iZn.aej();
        if (aej != null) {
            i = (int) Math.round(aej.iZj);
            g.pQN.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.fIm), Integer.valueOf(eVar.fno), Integer.valueOf(eVar.iYM), Integer.valueOf(e.a.iYP.iYZ), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.iYN), Integer.valueOf(eVar.iYM)});
        }
        return true;
    }
}
