package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class c extends b {
    private boolean sEA;
    private boolean sEB;
    private boolean sEC;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.sEC = z;
        bJU();
    }

    private void bJU() {
        this.sEA = false;
        p.bJN();
        if (!(p.bJO().sQf == null || this.sEt.pCn == null || this.sEC)) {
            if (this.sEt.pCn.fCV == 31 || this.sEt.pCn.fCV == 32 || this.sEt.pCn.fCV == 33 || this.sEt.pCn.fCV == 42 || this.sEt.pCn.fCV == 37) {
                this.sEA = true;
            } else {
                this.sEB = true;
            }
        }
        x.i("MicroMsg.NetSceneTenpayBalanceBindAuthen", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[]{Boolean.valueOf(this.sEA), Boolean.valueOf(this.sEB), Boolean.valueOf(this.sEC)});
    }

    protected final void S(Map<String, String> map) {
        bJU();
        if (this.sEA || this.sEB) {
            map.put("busi_scene", this.sEt.oZz);
        }
    }

    public final int ayQ() {
        return 120;
    }

    public final String getUri() {
        bJU();
        if (this.sEA) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
        }
        if (this.sEB) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public final int Hr() {
        bJU();
        if (this.sEA) {
            return 1274;
        }
        if (this.sEB) {
            return 1259;
        }
        return 1600;
    }

    public final int a(e eVar, com.tencent.mm.ae.e eVar2) {
        if (this.sEA) {
            g.pQN.a(663, 24, 1, false);
        } else if (this.sEB) {
            g.pQN.a(663, 20, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.sEA) {
            g.pQN.a(663, 25, 1, false);
        } else if (this.sEB) {
            g.pQN.a(663, 21, 1, false);
        }
    }
}
