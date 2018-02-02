package com.tencent.mm.u.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    private a<a> gOC;

    public a(String str, LinkedList<String> linkedList, a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i, int i2, a<a> aVar) {
        this(str, linkedList, i, i2);
        this.gOC = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ami();
        aVar.hmk = new amj();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hmi = 1157;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ami com_tencent_mm_protocal_c_ami = (ami) this.gJQ.hmg.hmo;
        if (i2 > 0) {
            com_tencent_mm_protocal_c_ami.wtd = new cbj();
            com_tencent_mm_protocal_c_ami.wtd.scene = i2;
        }
        com_tencent_mm_protocal_c_ami.ngo = str;
        com_tencent_mm_protocal_c_ami.wta = linkedList;
        com_tencent_mm_protocal_c_ami.wtc = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.gOC != null) {
            this.gOC.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1157;
    }

    public final amj BV() {
        return (amj) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
