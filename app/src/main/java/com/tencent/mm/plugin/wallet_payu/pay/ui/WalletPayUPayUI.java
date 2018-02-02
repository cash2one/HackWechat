package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_payu.balance.a.b;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String tcU = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
    }

    protected final void bKi() {
        b(new c(bKt().fuH), bKt().vzv);
        b(new com.tencent.mm.plugin.wallet_core.c.b.a(bKt().fuH), bKt().vzv);
    }

    protected final void bJZ() {
        if (XK()) {
            x.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.szh = b.a(this, this.pPl, this.sEQ, this.szl, new 1(this), new 2(this), new 3(this), "CREDITCARD_PAYU".equals(this.szl.field_bankcardType));
        }
    }

    protected final void I(Bundle bundle) {
        boolean z = true;
        this.sFB = true;
        if (this.pPl != null) {
            bundle.putInt("key_support_bankcard", this.pPl.sIJ);
        }
        String str = "key_is_oversea";
        if (bKn()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
    }

    protected final void jF(boolean z) {
        if (this.sEO.fCV == 32 || this.sEO.fCV == 31) {
            int i;
            if (this.sEO.fCV == 32) {
                x.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            r(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.sEO.fuH, this.mzL, this.sEO.vzx.getDouble("total_fee"), this.sEO.vzx.getString("fee_type"), i, this.sEO.vzx.getString("extinfo_key_1"), this.szl.field_bindSerial, this.sEO.vzx.getString("extinfo_key_4")));
        } else if (this.sEO.fCV == 11) {
            String str = this.mzL;
            String str2 = this.tcU;
            String str3 = this.sEO.fuH;
            double d = this.sEO.vzx.getDouble("total_fee");
            String string = this.sEO.vzx.getString("fee_type");
            String str4 = this.szl.field_bindSerial;
            String str5 = this.szl.field_bankcardType;
            p.bJN();
            r(new b(str, str2, str3, d, string, str4, str5, p.bJO().szU.field_bindSerial));
        } else {
            l(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.sEO.fuH, this.sEO.vzx.getDouble("total_fee"), this.sEO.vzx.getString("fee_type"), this.szl.field_bankcardType, this.szl.field_bindSerial, this.tcU, this.mzL));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                this.pPl = ((c) kVar).pPl;
                if (this.pPl != null) {
                    i3 = this.pPl.sNW.size();
                }
                this.mCount = i3;
                x.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.pPl != null ? Integer.valueOf(this.pPl.sIJ) : ""));
                XK();
                if (!(this.pPl == null || this.pPl.sNW == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pPl.sNW) {
                        if (bh.ov(commodity.fuI)) {
                            commodity.fuI = this.sEO.fuH;
                        }
                        linkedList.add(commodity.fuI);
                    }
                    if (linkedList.size() > 0) {
                        com.tencent.mm.sdk.b.b syVar = new sy();
                        syVar.fLp.fLr = linkedList;
                        com.tencent.mm.sdk.b.a.xef.m(syVar);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putDouble("total_fee", this.pPl.pNX);
                    bundle.putString("fee_type", "ZAR");
                    if (this.sEO.vzx == null) {
                        this.sEO.vzx = bundle;
                    } else {
                        this.sEO.vzx.putAll(bundle);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
                p.bJN();
                this.szk = p.bJO().jB(bJW());
                p.bJN();
                this.szl = p.bJO().a(null, null, bJW(), false);
                this.pNB.setClickable(true);
                if (!(this.pPl == null || this.szk == null || this.sEO == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sEO, this.pPl);
                    g gVar = g.pQN;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sEO.fCV);
                    objArr[1] = Integer.valueOf(0);
                    p.bJN();
                    objArr[2] = Integer.valueOf(p.bJO().bLM() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pPl.pNX * 100.0d));
                    objArr[4] = this.pPl.paz;
                    gVar.h(10690, objArr);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                r1 = this.vf;
                r1.putParcelable("key_pay_info", this.sEO);
                r1.putParcelable("key_bankcard", this.szl);
                r1.putString("key_bank_type", this.szl.field_bankcardType);
                if (!bh.ov(this.mzL)) {
                    r1.putString("key_pwd1", this.mzL);
                }
                r1.putString("kreq_token", bVar.bhV());
                r1.putParcelable("key_authen", bKm());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.szl.field_mobile);
                if (bVar.isSuccess()) {
                    r1.putParcelable("key_orders", d.a(this.pPl, bVar.tcQ, bVar.tcR, bVar.cRJ, bVar.sQZ));
                }
                this.vf.putBoolean("key_should_redirect", bVar.tcO);
                this.vf.putString("key_gateway_code", bVar.tbt);
                this.vf.putString("key_gateway_reference", bVar.tbs);
                this.vf.putBoolean("key_should_force_adjust", bVar.tcP);
                this.vf.putString("key_force_adjust_code", bVar.tbv);
                r1.putInt("key_pay_flag", 3);
                I(r1);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) kVar;
                r1 = this.vf;
                r1.putParcelable("key_pay_info", this.sEO);
                r1.putParcelable("key_bankcard", this.szl);
                r1.putString("key_bank_type", this.szl.field_bankcardType);
                if (!bh.ov(this.mzL)) {
                    r1.putString("key_pwd1", this.mzL);
                }
                r1.putString("kreq_token", aVar.bhV());
                r1.putParcelable("key_authen", bKm());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.szl.field_mobile);
                r1.putParcelable("key_orders", this.pPl);
                r1.putInt("key_pay_flag", 3);
                I(r1);
                return true;
            }
            au();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                    this.sFF = this.vf;
                    this.sFF.putParcelable("key_pay_info", this.sEO);
                    this.sFF.putParcelable("key_bankcard", this.szl);
                    if (!bh.ov(this.mzL)) {
                        this.sFF.putString("key_pwd1", this.mzL);
                    }
                    this.sFF.putString("kreq_token", bVar.bhV());
                    this.sFF.putString("key_mobile", this.szl.field_mobile);
                    this.sFF.putInt("key_err_code", i2);
                    this.sFF.putParcelable("key_orders", this.pPl);
                    if (bh.ov(str)) {
                        string = getString(a$i.uUY);
                    } else {
                        string = str;
                    }
                    h.a(this, string, "", getString(a$i.uUX), getString(a$i.dEn), new 4(this), new OnClickListener(this) {
                        final /* synthetic */ WalletPayUPayUI tcY;

                        {
                            this.tcY = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.tcY.aYf()) {
                                this.tcY.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.szl == null || this.pPl == null)) {
                        this.szl.sLe = this.pPl.fuH;
                        if (this.szk == null || this.szk.size() <= 1) {
                            b(true, 4, str);
                            return true;
                        }
                        c(true, 4, str);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
