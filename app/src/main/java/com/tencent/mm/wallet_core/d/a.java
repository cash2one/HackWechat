package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {
    private j zHQ;
    private f zHR;
    private int zHS = 0;
    e zHT;

    public a(e eVar) {
        this.zHT = eVar;
    }

    public final boolean a(j jVar) {
        int i = o.bLq().mRetryCount;
        x.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[]{Boolean.valueOf(jVar.cBS()), Integer.valueOf(this.zHS)});
        if (!jVar.cBS() || this.zHS >= i) {
            return false;
        }
        return true;
    }

    public final void b(j jVar) {
        x.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.zHS = 0;
        c(jVar);
    }

    private void c(j jVar) {
        f fVar;
        boolean z;
        this.zHQ = jVar;
        this.zHQ.zIw = true;
        g.Dk();
        g.Di().gPJ.a(385, this);
        ag bLq = o.bLq();
        int i = bLq.sQk > 0 ? bLq.sQk : 10000;
        this.zHS++;
        Map cBR = this.zHQ.cBR();
        String str = (String) cBR.get("req_key");
        if (bh.ov(str)) {
            x.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            fVar = new f(cBR);
        } else {
            x.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[]{str});
            x.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
            fVar = str.startsWith("sns_aa_") ? new b(cBR) : str.startsWith("sns_tf_") ? new h(cBR) : str.startsWith("sns_ff_") ? new c(cBR) : str.startsWith("ts_") ? new d(cBR) : str.startsWith("sns_") ? new com.tencent.mm.wallet_core.tenpay.model.g(cBR) : str.startsWith("offline_") ? new com.tencent.mm.wallet_core.tenpay.model.e(cBR) : new f(cBR);
        }
        this.zHR = fVar;
        this.zHR.zIi = true;
        int i2 = o.bLq().mRetryCount;
        f fVar2 = this.zHR;
        if (this.zHS >= i2) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.zHS;
        Map hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i3));
        fVar2.aA(hashMap);
        x.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.Dk();
        g.Di().gPJ.a(this.zHR, i);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.zHQ != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.zHQ.a(i2, str, jSONObject);
            this.zHT.a(i, i2, str, this.zHQ);
        } else if (this.zHT != null) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.zHT.a(i, i2, str, this.zHQ);
        }
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.zHS = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        if ((kVar instanceof f) && this.zHR.equals(kVar)) {
            g.Dk();
            g.Di().gPJ.b(385, this);
            f fVar = (f) kVar;
            x.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, fVar, Integer.valueOf(fVar.zIh)});
            if (fVar.zIh == 1) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                a(i, i2, str, fVar.cBP());
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (fVar.zIh != 2) {
                    a(i, i2, str, fVar.cBP());
                    return;
                }
            } else if (!fVar.zHx) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{o.bLq().sQl});
            } else if (a(this.zHQ)) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                c(this.zHQ);
                return;
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail");
                if (fVar.zIh == 1) {
                    a(i, i2, str, fVar.cBP());
                    return;
                }
            }
            a(this.zHQ.zIp, this.zHQ.zIq, this.zHQ.zIr, this.zHQ.zIs);
        } else if ((kVar instanceof j) && this.zHQ.equals(kVar)) {
            g.Dk();
            g.Di().gPJ.b(385, this);
            if (!((j) kVar).zIx) {
                return;
            }
            if (this.zHQ.sFA) {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                a(i, i2, str, ((j) kVar).zIs);
            } else if (this.zHQ.cBS()) {
                x.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                c(this.zHQ);
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{o.bLq().sQl});
                a(i, i2, r0, ((j) kVar).zIs);
            }
        }
    }
}
