package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends l {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    public final String a(c cVar, JSONObject jSONObject) {
        if (!(cVar.YQ().iqB instanceof m)) {
            return e("fail:not debug", null);
        }
        m mVar = (m) cVar.YQ().iqB;
        String jSONObject2 = jSONObject.toString();
        x.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
        a com_tencent_mm_protocal_c_bvp = new bvp();
        com_tencent_mm_protocal_c_bvp.wWX = mVar.irP.iqC.aiT().aex().hashCode();
        com_tencent_mm_protocal_c_bvp.wWW = jSONObject2;
        mVar.iQX.iQB.a(o.a(com_tencent_mm_protocal_c_bvp, mVar.iQx, "domEvent"));
        return e("ok", null);
    }
}
