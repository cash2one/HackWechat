package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class b extends e {
    private boolean sEA = false;
    private boolean sEB;

    public final int ayQ() {
        return 121;
    }

    public b(p pVar, Orders orders) {
        super(pVar, orders);
        bJU();
    }

    private void bJU() {
        this.sEA = false;
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (!(com.tencent.mm.plugin.wallet.a.p.bJO().sQf == null || this.sEG.pCn == null)) {
            String str = this.sEG.oZz;
            com.tencent.mm.plugin.wallet.a.p.bJN();
            if (str.equals(com.tencent.mm.plugin.wallet.a.p.bJO().sQf.field_bankcardType)) {
                if (this.sEG.pCn.fCV == 31 || this.sEG.pCn.fCV == 32 || this.sEG.pCn.fCV == 33 || this.sEG.pCn.fCV == 42 || this.sEG.pCn.fCV == 37) {
                    this.sEA = true;
                } else {
                    this.sEB = true;
                }
            }
        }
        x.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[]{Boolean.valueOf(this.sEA), Boolean.valueOf(this.sEB)});
    }

    protected final void S(Map<String, String> map) {
        bJU();
        if (this.sEA || this.sEB) {
            map.put("busi_scene", this.sEG.oZz);
        }
    }

    public final int Hr() {
        bJU();
        if (this.sEA) {
            return 1281;
        }
        if (this.sEB) {
            return 1305;
        }
        return 1601;
    }

    public final String getUri() {
        bJU();
        if (this.sEA) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
        }
        if (this.sEB) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
    }

    public final int a(e eVar, com.tencent.mm.ae.e eVar2) {
        if (this.sEA) {
            g.pQN.a(663, 26, 1, false);
        } else if (this.sEB) {
            g.pQN.a(663, 22, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.sEA) {
            g.pQN.a(663, 27, 1, false);
        } else if (this.sEB) {
            g.pQN.a(663, 23, 1, false);
        }
    }
}
