package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public abstract class l extends i implements a {
    private int errCode = 0;
    private String fnL = "";
    public boolean sFA = false;
    private RetryPayInfo syh;
    private boolean zIv = false;
    public boolean zIw = false;
    public boolean zIx = false;
    public boolean zIy;

    public final void F(boolean z, boolean z2) {
        super.F(z, z2);
    }

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.fnL = str;
    }

    public boolean cBH() {
        return false;
    }

    public final boolean bnA() {
        return !this.zIw;
    }

    public void a(c cVar, JSONObject jSONObject) {
        boolean z = true;
        super.a(cVar, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.zIy = z;
        this.syh = new RetryPayInfo();
        this.syh.X(jSONObject);
    }

    public final void cBT() {
        reset();
        this.zIx = true;
        this.zIj = false;
    }
}
