package com.tencent.mm.u.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    private a<c> gOE;

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, a<c> aVar) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.gOE = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hmj = new amm();
        aVar.hmk = new amn();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.hmi = 1029;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        amm com_tencent_mm_protocal_c_amm = (amm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_amm.ngo = str;
        com_tencent_mm_protocal_c_amm.wta = linkedList;
        com_tencent_mm_protocal_c_amm.wtf = i;
        com_tencent_mm_protocal_c_amm.nfX = str2;
        com_tencent_mm_protocal_c_amm.wtg = str3;
        com_tencent_mm_protocal_c_amm.wtc = i2;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_amm.wtd = new cbj();
            com_tencent_mm_protocal_c_amm.wtd.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.gOE != null) {
            this.gOE.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1029;
    }

    public final amn BX() {
        return (amn) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
