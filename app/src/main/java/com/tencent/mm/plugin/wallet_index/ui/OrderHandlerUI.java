package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class OrderHandlerUI extends MMActivity implements e {
    private String fuH;
    private int irz = 0;
    private String kvs;
    private long kvt = 0;
    private Options options;
    private c pfJ = new 1(this);
    private PayReq taR;
    private PayResp taS;
    private boolean taT = false;
    private String taU = "";
    private boolean taV = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kvt = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        uD(8);
        p.cBw();
        com.tencent.mm.sdk.b.a.xef.b(this.pfJ);
    }

    protected void onResume() {
        Throwable th;
        k eVar;
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.taR == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.taR.prepayId))) {
            this.taR = payReq;
            this.irz = getIntent().getIntExtra("key_scene", 0);
            x.i("MicroMsg.OrderHandlerUI", "onCreate() mScene is " + this.irz);
            if (this.irz == 0) {
                this.kvs = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (this.kvs == null || this.kvs.length() == 0) {
                    x.e("MicroMsg.OrderHandlerUI", "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    return;
                }
            }
            this.options = new Options();
            this.options.fromBundle(getIntent().getExtras());
            this.taS = new PayResp();
            this.taS.prepayId = payReq.prepayId;
            this.taS.extData = payReq.extData;
            String str = "";
            if (this.irz == 0) {
                if (!payReq.checkArgs()) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, PayReq checkArgs fail");
                    this.taS.errCode = -1;
                    this.taS.errStr = getString(a$i.uMf);
                    e.a(this, this.kvs, this.taS, this.options);
                    finish();
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, checkAppResult fail");
                    this.taS.errCode = -1;
                    e.a(this, this.kvs, this.taS, this.options);
                    finish();
                    return;
                }
            } else if (this.irz == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] aX = com.tencent.mm.pluginsdk.model.app.p.aX(this, stringExtra);
                    if (aX == null || aX.length == 0) {
                        x.e("MicroMsg.AppUtil", "signs is null");
                        str2 = null;
                    } else {
                        str2 = g.s(aX[0].toByteArray());
                    }
                    str3 = str2;
                    str2 = str4;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    str2 = str4;
                    th = th2;
                    x.printErrStackTrace("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                    x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(397, this);
                    eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(eVar, 0);
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                x.printErrStackTrace("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(397, this);
                eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(eVar, 0);
            }
            x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(397, this);
            eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(eVar, 0);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(397, this);
        com.tencent.mm.sdk.b.a.xef.c(this.pfJ);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return a$g.uDi;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 397) {
            PayInfo payInfo = new PayInfo();
            if (this.irz == 1) {
                payInfo.fCV = 36;
            } else {
                payInfo.fCV = 2;
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(397, this);
            x.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.e eVar = (com.tencent.mm.plugin.wallet_index.c.e) kVar;
            avn com_tencent_mm_protocal_c_avn = (avn) eVar.gJQ.hmh.hmo;
            this.taU = com_tencent_mm_protocal_c_avn == null ? null : com_tencent_mm_protocal_c_avn.wDl;
            int i3;
            String str2;
            if (i == 4 && i2 == -5) {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
                this.taS.errCode = -1;
                aN(str, true);
                i3 = payInfo.fCV;
                if (this.taR == null) {
                    str2 = "";
                } else {
                    str2 = this.taR.prepayId;
                }
                t.j(i3, str2, i2);
            } else if (i == 0 && i2 == 0) {
                com_tencent_mm_protocal_c_avn = (avn) eVar.gJQ.hmh.hmo;
                i3 = com_tencent_mm_protocal_c_avn == null ? -1 : com_tencent_mm_protocal_c_avn.lOr;
                com_tencent_mm_protocal_c_avn = (avn) eVar.gJQ.hmh.hmo;
                String str3 = com_tencent_mm_protocal_c_avn == null ? null : com_tencent_mm_protocal_c_avn.lOs;
                com_tencent_mm_protocal_c_avn = (avn) eVar.gJQ.hmh.hmo;
                String str4 = com_tencent_mm_protocal_c_avn == null ? null : com_tencent_mm_protocal_c_avn.whq;
                com_tencent_mm_protocal_c_avn = (avn) eVar.gJQ.hmh.hmo;
                x.d("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[]{Integer.valueOf(i3), str3, str4, com_tencent_mm_protocal_c_avn == null ? null : com_tencent_mm_protocal_c_avn.whr});
                if (bh.ov(str4)) {
                    x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
                    this.taS.errCode = -1;
                    aN(str, true);
                    return;
                }
                t.j(payInfo.fCV, str4, i2);
                payInfo.appId = this.taR.appId;
                payInfo.fuH = str4;
                payInfo.partnerId = this.taR.partnerId;
                payInfo.tan = str2;
                payInfo.vzw = String.valueOf(i3);
                payInfo.fnL = str3;
                if (this.kvt > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 1, 1, true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 2, bh.bz(this.kvt), true);
                    if (payInfo.vzx == null) {
                        payInfo.vzx = new Bundle();
                    }
                    payInfo.vzx.putLong("wallet_pay_key_check_time", this.kvt);
                }
                this.fuH = payInfo.fuH;
                h.a(this, payInfo, 123);
                this.taT = false;
            } else {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
                this.taS.errCode = -1;
                aN(str, true);
                t.j(payInfo.fCV, this.taR == null ? "" : this.taR.prepayId, i2);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.taS != null && !this.taT) {
            x.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
            this.taS.errCode = -2;
            aN("", false);
        }
    }

    private void aN(String str, boolean z) {
        if (this.irz != 1) {
            e.a(this, this.kvs, this.taS, this.options);
            finish();
        } else if (TextUtils.isEmpty(this.taU) && z) {
            uD(0);
            if (TextUtils.isEmpty(str)) {
                str = getString(a$i.uXa);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new 2(this));
        } else {
            aJ(this, this.taU);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
    }

    private static void aJ(Context context, String str) {
        if (context == null) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        } else {
            x.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
