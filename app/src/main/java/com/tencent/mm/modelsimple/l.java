package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;
    public Object tag;

    private l() {
        this.gJQ = a.b(a.a(l$a$a.GetA8Key));
    }

    private l(String str, int i) {
        l$a$a com_tencent_mm_modelsimple_l_a_a = l$a$a.AutoRoute;
        if (com_tencent_mm_modelsimple_l_a_a == l$a$a.AutoRoute) {
            com_tencent_mm_modelsimple_l_a_a = a.R(str, i);
        }
        x.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", str, com_tencent_mm_modelsimple_l_a_a, Integer.valueOf(i));
        this.gJQ = a.b(a.a(com_tencent_mm_modelsimple_l_a_a));
    }

    private l(l$a$a com_tencent_mm_modelsimple_l_a_a) {
        this.gJQ = a.a(com_tencent_mm_modelsimple_l_a_a);
    }

    public l(String str, String str2, String str3, int i) {
        this(l$a$a.MpGetA8Key);
        xg xgVar = (xg) this.gJQ.hmg.hmo;
        xgVar.vDW = 1;
        xgVar.whv = new bdo().UA(str);
        xgVar.whw = new bdo().UA(str2);
        xgVar.whx = new bdo().UA(str3);
        xgVar.whG = i;
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i));
    }

    public l(String str, String str2, int i, int i2, byte[] bArr) {
        this(str, 0);
        xg xgVar = (xg) this.gJQ.hmg.hmo;
        xgVar.vDW = 2;
        xgVar.why = new bdo().UA(str);
        xgVar.rYW = i;
        xgVar.ksU = str2;
        xgVar.whD = 0;
        xgVar.whG = i2;
        xgVar.whJ = new bdn().bj(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = 0, requestId = " + i2);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bh.by(bArr));
    }

    public l(String str, int i, int i2, int i3, String str2, int i4, byte[] bArr) {
        this(str, 0);
        xg xgVar = (xg) this.gJQ.hmg.hmo;
        xgVar.vDW = 2;
        xgVar.why = new bdo().UA(str);
        xgVar.rYW = i;
        xgVar.ksU = null;
        xgVar.whD = 0;
        xgVar.vVn = i2;
        xgVar.vVo = i3;
        xgVar.whG = i4;
        xgVar.whv = new bdo().UA(str2);
        xgVar.whJ = new bdn().bj(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bh.by(bArr));
    }

    public l(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, String str5, int i5, byte[] bArr) {
        this(str, i2);
        xg xgVar = (xg) this.gJQ.hmg.hmo;
        xgVar.vDW = 2;
        xgVar.why = new bdo().UA(str);
        xgVar.rYW = i;
        xgVar.ksU = str2;
        xgVar.whD = i2;
        xgVar.vGN = i3;
        xgVar.whF = str3;
        xgVar.whG = i4;
        xgVar.whH = str5;
        xgVar.whI = i5;
        xgVar.whv = new bdo().UA(str4);
        xgVar.whJ = new bdn().bj(bArr);
        x.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4, str5, Integer.valueOf(i5), bh.by(bArr));
    }

    public l(int i, int i2) {
        this();
        xg xgVar = (xg) this.gJQ.hmg.hmo;
        xgVar.vDW = 3;
        xgVar.rYW = 5;
        xgVar.whA = i;
        xgVar.whG = i2;
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i), Integer.valueOf(xgVar.vJi.wJB), Integer.valueOf(i2));
    }

    public final int getType() {
        return 233;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), RE(), ((xh) this.gJQ.hmh.hmo).whL);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", bh.by(RN()));
        this.gJT.a(i2, i3, str, this);
    }

    public final String RE() {
        return ((xh) this.gJQ.hmh.hmo).whK;
    }

    public final String RF() {
        bdo com_tencent_mm_protocal_c_bdo = ((xg) this.gJQ.hmg.hmo).why;
        if (com_tencent_mm_protocal_c_bdo != null) {
            return com_tencent_mm_protocal_c_bdo.wJF;
        }
        return null;
    }

    public final String getTitle() {
        return ((xh) this.gJQ.hmh.hmo).fon;
    }

    public final String we() {
        return ((xh) this.gJQ.hmh.hmo).nje;
    }

    public final int RG() {
        return ((xh) this.gJQ.hmh.hmo).vEe;
    }

    public final byte[] RH() {
        xh xhVar = (xh) this.gJQ.hmh.hmo;
        if (xhVar.whT == null) {
            return null;
        }
        try {
            return n.a(xhVar.whT);
        } catch (Exception e) {
            return null;
        }
    }

    public final String RI() {
        return ((xh) this.gJQ.hmh.hmo).whO;
    }

    public final ArrayList<byte[]> RJ() {
        xh xhVar = (xh) this.gJQ.hmh.hmo;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (xhVar == null || xhVar.whQ == null) {
            return arrayList;
        }
        Iterator it = xhVar.whQ.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((ie) it.next()).toByteArray());
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetA8Key", "exception:%s", bh.i(e));
            }
        }
        x.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final long RK() {
        xh xhVar = (xh) this.gJQ.hmh.hmo;
        return xhVar.whS != null ? xhVar.whS.vYH : -1;
    }

    public final List<akj> RL() {
        return ((xh) this.gJQ.hmh.hmo).whV;
    }

    public final int RM() {
        return ((xg) this.gJQ.hmg.hmo).whG;
    }

    public final byte[] RN() {
        xh xhVar = (xh) this.gJQ.hmh.hmo;
        if (xhVar.whJ == null) {
            return new byte[0];
        }
        try {
            return n.a(xhVar.whJ);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
