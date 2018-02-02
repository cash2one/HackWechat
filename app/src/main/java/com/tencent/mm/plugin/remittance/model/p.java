package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public String desc;
    public long fLR;
    public int liR;
    public String liS;
    public String liT;
    public String liU;
    public String liV;
    public int liW;
    public String pKD;
    public String pKE;
    public String pKF;

    public p(String str) {
        Map hashMap = new HashMap();
        try {
            if (!bh.ov(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[]{str});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pKD = jSONObject.optString("recv_username", "");
        this.liV = jSONObject.optString("recv_realname", "");
        this.pKE = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.fLR = jSONObject.optLong("amount", 0);
        this.liW = jSONObject.optInt("set_amount", 0);
        this.liR = jSONObject.optInt("currency", 0);
        this.liS = jSONObject.optString("currencyunit", "");
        this.pKF = jSONObject.optString("qrcodeid", "");
        this.liT = jSONObject.optString("notice", "");
        this.liU = jSONObject.optString("notice_url", "");
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", new Object[]{this.pKD, this.pKE, this.desc, Long.valueOf(this.fLR), Integer.valueOf(this.liW), this.liS});
        x.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[]{this.liV});
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    public final int getType() {
        return 1301;
    }

    public final int ayO() {
        return 1301;
    }
}
