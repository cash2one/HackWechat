package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b implements e {
    static RetryPayInfo syh;
    private j zHQ;
    private int zHS = 0;
    e zHT;

    private boolean cBH() {
        if (this.zHS >= cBI()) {
            return false;
        }
        return true;
    }

    private static int cBI() {
        if (syh == null || !syh.cBO()) {
            return 0;
        }
        return syh.zId;
    }

    public b(e eVar) {
        this.zHT = eVar;
    }

    public final boolean d(j jVar) {
        int i = (syh == null || !syh.cBO()) ? 0 : syh.zIc;
        int cBI = cBI();
        this.zHS++;
        if (this.zHS > cBI) {
            return false;
        }
        this.zHQ = jVar;
        this.zHQ.zIw = true;
        g.Dk();
        g.Di().gPJ.a(385, (e) this);
        this.zHQ.cBT();
        int i2 = this.zHS;
        int i3 = this.zHS >= cBI ? 1 : 0;
        Map hashMap = new HashMap();
        hashMap.put("retry_count", String.valueOf(i2));
        hashMap.put("is_last_retry", String.valueOf(i3));
        jVar.aA(hashMap);
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i), Integer.valueOf(cBI));
        g.Dk();
        g.Di().gPJ.a((k) jVar, i);
        return true;
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.zHQ != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.zHQ.a(i2, str, jSONObject);
            this.zHT.a(i, i2, str, this.zHQ);
        } else if (this.zHT != null) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.zHT.a(i, i2, str, this.zHQ);
        }
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.zHS = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if (kVar instanceof j) {
            if (kVar instanceof ITenpaySave) {
                RetryPayInfo bJl = ((ITenpaySave) kVar).bJl();
                if (bJl.cBO()) {
                    syh = bJl;
                }
            }
            g.Dk();
            g.Di().gPJ.b(385, (e) this);
            if (!((j) kVar).zIx) {
                return;
            }
            if (this.zHQ.sFA) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                a(i, i2, str, ((j) kVar).zIs);
            } else if (this.zHQ.zIy && cBH()) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", Boolean.valueOf(this.zHQ.zIy), Boolean.valueOf(cBH()));
                if (!d(this.zHQ)) {
                    c(i, i2, kVar);
                }
            } else if (((j) kVar).zHx) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                if (!d(this.zHQ)) {
                    c(i, i2, kVar);
                }
            } else {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", syh.zIe);
                a(i, i2, r0, ((j) kVar).zIs);
            }
        }
    }

    private void c(int i, int i2, k kVar) {
        a(i, i2, syh.zIe, ((j) kVar).zIs);
    }
}
