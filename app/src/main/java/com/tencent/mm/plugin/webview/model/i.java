package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class i extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public i(String str, String str2, Map<String, Object> map) {
        a aVar = new a();
        aVar.hmj = new zn();
        aVar.hmk = new zo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        aVar.hmi = 1393;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        zn znVar = (zn) this.gJQ.hmg.hmo;
        znVar.vYi = str;
        znVar.vOC = str2;
        znVar.wji = (String) map.get("groupId");
        znVar.sMr = (String) map.get("timestamp");
        znVar.kUf = (String) map.get("nonceStr");
        znVar.signature = (String) map.get("signature");
        znVar.wjj = map.get("params").toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1393;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final zo bQB() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (zo) this.gJQ.hmh.hmo;
    }
}
