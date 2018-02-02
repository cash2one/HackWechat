package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad extends w {
    private static final String[] veQ = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ad(List<String> list) {
        int i = 0;
        a aVar = new a();
        aVar.hmj = new xx();
        aVar.hmk = new xy();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        aVar.hmi = 451;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        xx xxVar = (xx) this.lMW.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!bh.ov(str)) {
                    linkedList.add(n.os(str));
                }
                i++;
            }
        }
        xxVar.wit = linkedList;
        xxVar.ksO = linkedList.size();
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((xy) this.lMW.hmh.hmo).wiu;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    hf hfVar = (hf) it.next();
                    if (hfVar != null) {
                        a(g.aZ(hfVar.ngo, false), hfVar);
                    }
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, hf hfVar) {
        boolean z;
        int i = 0;
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = hfVar.ngo;
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[]{hfVar.ngo, Integer.valueOf(hfVar.nfu), Long.valueOf(hfVar.vNf)});
        x.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[]{fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag)});
        if (!fVar.bYD() || bh.ov(fVar.field_appName)) {
            fVar.field_appName = hfVar.nfp;
        }
        if (!fVar.bYD() || bh.ov(fVar.field_appName_en)) {
            fVar.field_appName_en = hfVar.vMR;
        }
        if (!fVar.bYD() || bh.ov(fVar.field_appName_tw)) {
            fVar.field_appName_tw = hfVar.vMT;
        }
        fVar.field_appDiscription = hfVar.vIO;
        fVar.field_appDiscription_en = hfVar.vMS;
        fVar.field_appDiscription_tw = hfVar.vMU;
        fVar.field_appWatermarkUrl = hfVar.vMY;
        fVar.field_packageName = hfVar.vFY;
        fVar.field_signature = p.RJ(hfVar.vMZ);
        x.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", new Object[]{hfVar.vMZ, fVar.field_signature});
        fVar.field_appType = hfVar.vIU;
        if (!bh.ov(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = hfVar.nfu;
        fVar.field_appVersion = hfVar.vNa;
        fVar.cN(hfVar.vIW);
        fVar.field_appWatermarkUrl = hfVar.vMY;
        if (!(bh.ov(hfVar.vNd) || bh.ov(hfVar.vNe))) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[]{fVar.field_appName, hfVar.vNd, hfVar.vNe});
            fVar.cO(hfVar.vNd);
            fVar.cR(hfVar.vNe);
        }
        fVar.cS(hfVar.vFZ);
        fVar.field_svrAppSupportContentType = hfVar.vNf;
        if (hfVar.vNb > fVar.fQF) {
            fVar.fQG = 1;
            fVar.fPZ = true;
        }
        fVar.fQF = hfVar.vNb;
        fVar.fPZ = true;
        String str = hfVar.vFY;
        String str2 = hfVar.vFY;
        int i2 = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? true : 0;
        if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + hfVar.vFY + "appid: " + fVar.field_appId);
        }
        if (fVar.Yz()) {
            b.SL(fVar.field_appId);
        }
        i bin = com.tencent.mm.plugin.y.a.bin();
        if (z) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = hfVar.vMW;
            if (fVar.field_appId != null) {
                while (i < veQ.length) {
                    if (fVar.field_appId.equals(veQ[i])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i++;
                }
            }
            if (bin.l(fVar)) {
                com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 1);
                com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 2);
                com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 3);
                com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 4);
                com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 5);
                return;
            }
            x.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            return;
        }
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : veQ) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        z = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? true : (hfVar == null || hfVar.vNc == null || hfVar.vNc.length() == 0) ? false : !fVar.field_appIconUrl.equals(hfVar.vMW);
        if (z) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[]{fVar.field_appIconUrl, hfVar.vMW});
            fVar.field_appIconUrl = hfVar.vMW;
            com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 1);
            com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 2);
            com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 3);
            com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 4);
            com.tencent.mm.plugin.y.a.bil().cP(fVar.field_appId, 5);
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bin.a(fVar, new String[0]) + ", appid = " + hfVar.ngo);
    }

    public final byte[] aQX() {
        try {
            return ((com.tencent.mm.ae.b.b) this.lMW.Kb()).Hq();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
        }
    }
}
