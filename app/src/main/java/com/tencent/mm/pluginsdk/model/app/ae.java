package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae extends w {
    List<String> veR;

    public ae(List<String> list) {
        a aVar = new a();
        aVar.hmj = new yb();
        aVar.hmk = new yc();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        aVar.hmi = com.tencent.mm.plugin.appbrand.game.d.a.CTRL_INDEX;
        this.lMW = aVar.JZ();
        this.veR = list;
        x.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                db dbVar = new db();
                dbVar.nfn = str;
                linkedList.add(dbVar);
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        yb ybVar = (yb) this.lMW.hmg.hmo;
        ybVar.wiy = linkedList;
        ybVar.wix = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            yc ycVar = (yc) this.lMW.hmh.hmo;
            x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + ycVar.wix);
            LinkedList linkedList = ycVar.wiz;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                return;
            }
            i bin = com.tencent.mm.plugin.y.a.bin();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                da daVar = (da) it.next();
                f aZ = g.aZ(daVar.nfn, false);
                if (aZ != null) {
                    aZ.field_authFlag = daVar.vIl;
                    aZ.field_openId = daVar.nhz;
                    x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bin.a(aZ, new String[0]) + ", appId = " + daVar.nfn);
                }
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
    }

    public final byte[] aQX() {
        try {
            return ((b) this.lMW.Kb()).Hq();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 1;
    }
}
