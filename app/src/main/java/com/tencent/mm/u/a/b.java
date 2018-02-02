package com.tencent.mm.u.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gOB;
    private a<b> gOD;

    public b(String str, LinkedList<String> linkedList, int i, int i2, int i3, a<b> aVar) {
        this(str, (LinkedList) linkedList, i, i2, i3);
        this.gOD = aVar;
    }

    public b(String str, LinkedList<String> linkedList, int i, int i2, a<b> aVar) {
        this(str, linkedList, 0, i2, -1, aVar);
    }

    private b(String str, LinkedList<String> linkedList, int i, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hmj = new amg();
        aVar.hmk = new amh();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.hmi = 1158;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        amg com_tencent_mm_protocal_c_amg = (amg) this.gJQ.hmg.hmo;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_amg.wtd = new cbj();
            com_tencent_mm_protocal_c_amg.wtd.scene = i3;
        }
        com_tencent_mm_protocal_c_amg.ngo = str;
        com_tencent_mm_protocal_c_amg.wta = linkedList;
        com_tencent_mm_protocal_c_amg.wtc = i;
        com_tencent_mm_protocal_c_amg.wtb = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.gOD != null) {
            this.gOD.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1158;
    }

    public final amh BW() {
        return (amh) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
