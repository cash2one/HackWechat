package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends a {
    public String desc;
    public long fLR;
    public int liH;
    public String liI;
    public String liJ;
    public int liK;
    public String liL;
    public String liM;
    public String liN;
    public String liO;
    public String liP;
    public String liQ;
    public int liR;
    public String liS;
    public String liT;
    public String liU;
    public String liV;
    public int liW;

    public m(int i) {
        Map hashMap = new HashMap();
        hashMap.put("set_amount", "0");
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
    }

    public m(long j, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!bh.ov(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
        this.fLR = j;
        this.desc = str;
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[]{Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.liH = jSONObject.optInt("retcode", 0);
        this.liI = jSONObject.optString("retmsg", "");
        this.liJ = jSONObject.optString("qrcode_url", "");
        this.liK = jSONObject.optInt("alert_type", 0);
        this.liL = jSONObject.optString("alert_title", "");
        this.liM = jSONObject.optString("left_button_text", "");
        this.liN = jSONObject.optString("right_button_text", "");
        this.liO = jSONObject.optString("right_button_url", "");
        this.liP = jSONObject.optString("bottom_text", "");
        this.liQ = jSONObject.optString("bottom_url", "");
        this.liR = jSONObject.optInt("currency", 0);
        this.liS = jSONObject.optString("currencyunit", "");
        this.liT = jSONObject.optString("notice", "");
        this.liU = jSONObject.optString("notice_url", "");
        this.liV = jSONObject.optString("recv_realname", "");
        this.liW = jSONObject.optInt("set_amount", 0);
        if (this.liW == 0) {
            g.Dk();
            g.Dj().CU().a(w.a.xvt, this.liJ);
            x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[]{this.liJ});
        }
        x.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[]{this.liJ, Integer.valueOf(this.liR)});
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    public final int getType() {
        return 1335;
    }

    public final int ayO() {
        return 1335;
    }

    public final boolean ayP() {
        return true;
    }
}
