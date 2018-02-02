package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public final com.tencent.mm.ae.b gJQ;
    private e gOB;
    private a<b> jBd;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, a<b> aVar) {
        this(str, str2, str3, i, i2, i3);
        this.jBd = aVar;
    }

    private b(String str, String str2, String str3, int i, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new amo();
        aVar.hmk = new amp();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.hmi = 1133;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        amo com_tencent_mm_protocal_c_amo = (amo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_amo.ngo = str;
        com_tencent_mm_protocal_c_amo.ksB = new com.tencent.mm.bq.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        com_tencent_mm_protocal_c_amo.wtk = str3;
        com_tencent_mm_protocal_c_amo.wtc = i;
        com_tencent_mm_protocal_c_amo.wtb = i2;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_amo.wtd = new cbj();
            com_tencent_mm_protocal_c_amo.wtd.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.jBd != null) {
            this.jBd.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1133;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
