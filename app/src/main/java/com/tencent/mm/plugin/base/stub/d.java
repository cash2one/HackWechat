package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class d {
    protected String appId;
    protected Context context;
    protected a kuN;
    protected String openId;

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.kuN = aVar;
    }

    public final void aqV() {
        if (this.openId == null || this.openId.length() == 0) {
            x.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.kuN.dP(true);
            return;
        }
        f aZ = g.aZ(this.appId, false);
        if (aZ == null) {
            x.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.kuN.dP(true);
        } else if (t.ov(aZ.field_openId)) {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            x.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            an.bip().OI(this.appId);
            this.kuN.dP(true);
        } else if (this.openId.equalsIgnoreCase(aZ.field_openId)) {
            x.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.kuN.dP(true);
        } else {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + aZ.field_openId);
            Wb();
        }
    }

    protected void Wb() {
        h.b(this.context, R.l.ezL, R.l.dGO, new 1(this), new 2(this));
    }
}
