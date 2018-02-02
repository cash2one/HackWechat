package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String kvs = null;
    private long kvt = 0;

    public void onCreate(Bundle bundle) {
        this.kvt = System.currentTimeMillis();
        t.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        boolean z = true;
        if (intent == null) {
            finish();
            return;
        }
        x.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + aVar);
        switch (1.kuV[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[]{Boolean.valueOf(com.tencent.mm.kernel.a.Cs())});
                if (com.tencent.mm.kernel.a.Cs()) {
                    finish();
                    return;
                }
                break;
            case 2:
                nb(-2);
                x.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            case 3:
                nb(-1);
                x.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            default:
                x.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        this.kvs = t.j(intent, ConstantsAPI.APP_PACKAGE);
        x.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.kvs);
        if (getIntent() == null || t.ah(getIntent()) == null) {
            z = false;
        } else {
            PayReq payReq = new PayReq();
            payReq.fromBundle(t.ah(getIntent()));
            String str = payReq.appId;
            x.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + str);
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                f aZ = g.aZ(str, true);
                if (aZ == null) {
                    x.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    aZ = new f();
                    aZ.field_appId = str;
                    aZ.field_appName = "";
                    aZ.field_packageName = this.kvs;
                    aZ.field_status = 0;
                    String aW = p.aW(this, this.kvs);
                    if (aW != null) {
                        aZ.field_signature = aW;
                    }
                    if (an.bin().l(aZ) && bh.ov(aZ.field_openId)) {
                        x.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + str);
                        an.bip().OI(str);
                    }
                } else if (aZ.field_status == 3) {
                    x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!p.b(this, aZ, this.kvs)) {
                    AutoLoginActivity.a(this, aZ, this.kvs, 5);
                    x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            x.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
        Bundle ah = t.ah(intent);
        ah.putLong("wallet_pay_key_check_time", this.kvt);
        h.a(this, ah, z);
        finish();
    }

    private void nb(int i) {
        PayReq payReq = new PayReq();
        payReq.fromBundle(t.ah(getIntent()));
        Options options = new Options();
        options.fromBundle(t.ah(getIntent()));
        PayResp payResp = new PayResp();
        payResp.prepayId = payReq.prepayId;
        payResp.extData = payReq.extData;
        payResp.errCode = i;
        e.a(this, t.j(getIntent(), ConstantsAPI.APP_PACKAGE), payResp, options);
    }
}
