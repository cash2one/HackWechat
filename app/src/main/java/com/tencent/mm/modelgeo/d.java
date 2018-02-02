package com.tencent.mm.modelgeo;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    private String fwM = "";
    public final b gJQ;
    private e gJT;

    public d(double d, double d2) {
        a aVar = new a();
        aVar.hmj = new xq();
        aVar.hmk = new xr();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.hmi = 655;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        xq xqVar = (xq) this.gJQ.hmg.hmo;
        xqVar.vNP = d;
        xqVar.vNO = d2;
    }

    public final int getType() {
        return 655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.fwM = ((xr) ((b) qVar).hmh.hmo).wii;
            x.d("MicroMsg.NetSceneGetAddress", this.fwM);
            if (this.gJT != null) {
                this.gJT.a(i2, i3, str, this);
            }
        } else if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final Addr OS() {
        if (bh.ov(this.fwM)) {
            return null;
        }
        Addr addr = new Addr();
        try {
            x.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[]{this.fwM});
            JSONObject jSONObject = new JSONObject(this.fwM);
            addr.hxE = jSONObject.optString("request_id");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            addr.hxu = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            addr.hxv = jSONObject2.getString("p");
            addr.hxw = jSONObject2.getString("c");
            addr.hxy = jSONObject2.getString("d");
            addr.hxz = "";
            addr.hxA = "";
            addr.hxB = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.hxA = jSONObject2.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.hxB = jSONObject2.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.hxC = jSONObject2.getString("rough_address_name");
                    }
                } catch (Exception e) {
                }
            }
            if (!bh.ov(addr.hxB)) {
                addr.hxA = "";
            }
            return addr;
        } catch (Exception e2) {
            return null;
        }
    }
}
