package com.tencent.mm.u.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    private a<d> gOF;

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, a<d> aVar) {
        this(str, linkedList, 0, str2, 0, i3, -1, aVar);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4, a<d> aVar) {
        this(str, (LinkedList) linkedList, i, str2, i2, i3, i4);
        this.gOF = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        a aVar = new a();
        aVar.hmj = new amk();
        aVar.hmk = new aml();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.hmi = 1117;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        amk com_tencent_mm_protocal_c_amk = (amk) this.gJQ.hmg.hmo;
        if (i4 > 0) {
            com_tencent_mm_protocal_c_amk.wtd = new cbj();
            com_tencent_mm_protocal_c_amk.wtd.scene = i4;
        }
        com_tencent_mm_protocal_c_amk.ngo = str;
        com_tencent_mm_protocal_c_amk.wta = linkedList;
        com_tencent_mm_protocal_c_amk.wtf = i;
        com_tencent_mm_protocal_c_amk.wtg = str2;
        com_tencent_mm_protocal_c_amk.wtc = i2;
        com_tencent_mm_protocal_c_amk.wtb = i3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.gOF != null) {
            this.gOF.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1117;
    }

    public final aml BY() {
        return (aml) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
