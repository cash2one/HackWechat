package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ad extends i {
    private long hQs;
    public String sIS;
    public String sIT;
    public String sIU;
    public String sIV;
    public String sIW;
    public int sIX;
    public int sIY;

    public ad() {
        D(null);
    }

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        x.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[]{jSONObject});
        this.sIS = jSONObject.optString("delay_confirm_wording");
        this.sIT = jSONObject.optString("delay_confirm_switch_wording");
        this.sIU = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.sIV = jSONObject.optString("delay_confirm_desc_url");
        this.sIX = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.hQs = jSONObject.optLong("expire_time", 0) * 1000;
        this.sIY = jSONObject.optInt("delay_confirm_switch_flag", 0);
        g.Dk();
        t CU = g.Dj().CU();
        if (!bh.ov(this.sIS)) {
            CU.a(a.xtn, this.sIS);
        }
        if (!bh.ov(this.sIT)) {
            CU.a(a.xto, this.sIT);
        }
        if (!bh.ov(this.sIU)) {
            CU.a(a.xtp, this.sIU);
        }
        if (!bh.ov(this.sIV)) {
            try {
                this.sIW = URLDecoder.decode(this.sIV, "UTF-8");
                if (!bh.ov(this.sIW)) {
                    CU.a(a.xtr, this.sIW);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        CU.a(a.xts, Integer.valueOf(this.sIX));
        CU.a(a.xtq, Long.valueOf(this.hQs));
        CU.a(a.xtt, Integer.valueOf(this.sIY));
        if (this.sIY == 0) {
            x.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_asb = new asb();
            com_tencent_mm_protocal_c_asb.pQk = 0;
            ((h) g.h(h.class)).EX().b(new e.a(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, com_tencent_mm_protocal_c_asb));
            CU.set(147457, Long.valueOf((((Long) CU.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
    }

    public static boolean a(boolean z, com.tencent.mm.wallet_core.d.g gVar) {
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(a.xtq, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            x.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[]{Long.valueOf(longValue), Boolean.valueOf(z)});
            if (gVar != null) {
                gVar.a(new ad(), false, 1);
            } else {
                g.Dk();
                g.Di().gPJ.a(new ad(), 0);
            }
            return true;
        }
        x.d("MicroMsg.NetSceneTransferWording", "not time");
        return false;
    }

    public final boolean bhd() {
        return false;
    }
}
