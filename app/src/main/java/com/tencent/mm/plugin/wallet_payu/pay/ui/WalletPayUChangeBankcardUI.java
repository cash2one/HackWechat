package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String tcU = null;
    private c tcV = new c<ln>(this) {
        final /* synthetic */ WalletPayUChangeBankcardUI tcW;

        {
            this.tcW = r2;
            this.xen = ln.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ln lnVar = (ln) bVar;
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            g gVar = new g(lnVar);
            this.tcW.vf.putString("app_id", gVar.appId);
            this.tcW.vf.putString("package", gVar.packageExt);
            this.tcW.vf.putString("timestamp", gVar.timeStamp);
            this.tcW.vf.putString("noncestr", gVar.nonceStr);
            this.tcW.vf.putString("pay_sign", gVar.fCT);
            this.tcW.vf.putString("sign_type", gVar.signType);
            this.tcW.vf.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            this.tcW.vf.putBoolean("from_jsapi", true);
            this.tcW.vf.putString("key_trans_id", ((PayInfo) this.tcW.vf.getParcelable("key_pay_info")).fuH);
            this.tcW.vf.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.j(this.tcW, this.tcW.vf);
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.b(this.tcV);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.tcV);
    }

    protected final f bJY() {
        return new a(this, this.szk, this.sEM, this.pPl);
    }

    protected final void bJZ() {
        x.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.vf.getString("key_pwd1");
        if (bh.ov(string)) {
            uD(4);
            this.szh = b.a(this, this.pPl, this.sEQ, this.szl, new 1(this), new OnClickListener(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI tcW;

                {
                    this.tcW = r1;
                }

                public final void onClick(View view) {
                    if (this.tcW.szh != null) {
                        this.tcW.szh.dismiss();
                    }
                    this.tcW.sEN.d(this.tcW.szk, true);
                    this.tcW.sEQ = (FavorPayInfo) view.getTag();
                    if (this.tcW.sEQ != null) {
                        this.tcW.sEQ.sMX = "";
                    }
                    this.tcW.vf.putParcelable("key_favor_pay_info", this.tcW.sEQ);
                    this.tcW.au();
                    this.tcW.uD(0);
                }
            }, new 3(this), "CREDITCARD_PAYU".equals(this.szl.field_bankcardType));
            return;
        }
        MM(string);
    }

    protected final void MM(String str) {
        this.sCY.sKs = str;
        if (this.szl != null) {
            this.vf.putString("key_mobile", this.szl.field_mobile);
            this.vf.putParcelable("key_bankcard", this.szl);
            this.sCY.oZA = this.szl.field_bindSerial;
            this.sCY.oZz = this.szl.field_bankcardType;
            if (this.sEQ != null) {
                this.sCY.sKE = this.sEQ.sMT;
            } else {
                this.sCY.sKE = null;
            }
            if (!(this.pPl == null || this.pPl.sNX == null)) {
                this.sCY.sKD = this.pPl.sNX.sDq;
            }
            if (this.pPl != null && this.pPl.sIJ == 3) {
                boolean z;
                if (this.szl.bKS()) {
                    this.sCY.fDt = 3;
                } else {
                    this.sCY.fDt = 6;
                }
                Bundle bundle = this.vf;
                String str2 = "key_is_oversea";
                if (this.szl.bKS()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.vf.putParcelable("key_authen", this.sCY);
        if (this.sEO.fCV == 32 || this.sEO.fCV == 31) {
            int i;
            if (this.sEO.fCV == 32) {
                x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            r(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.sEO.fuH, this.mzL, this.sEO.vzx.getDouble("total_fee"), this.sEO.vzx.getString("fee_type"), i, this.sEO.vzx.getString("extinfo_key_1"), this.szl.field_bindSerial, this.sEO.vzx.getString("extinfo_key_4")));
        } else if (this.sEO.fCV == 11) {
            String str3 = this.mzL;
            String str4 = this.tcU;
            String str5 = this.sEO.fuH;
            double d = this.sEO.vzx.getDouble("total_fee");
            String string = this.sEO.vzx.getString("fee_type");
            String str6 = this.szl.field_bindSerial;
            String str7 = this.szl.field_bankcardType;
            p.bJN();
            r(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str4, str5, d, string, str6, str7, p.bJO().szU.field_bindSerial));
        } else {
            l(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.sEO.fuH, this.sEO.vzx.getDouble("total_fee"), this.sEO.vzx.getString("fee_type"), this.szl.field_bankcardType, this.szl.field_bindSerial, this.tcU, str));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {
            return false;
        }
        Bundle bundle = this.vf;
        if (!bh.ov(this.mzL)) {
            bundle.putString("key_pwd1", this.mzL);
        }
        bundle.putBoolean("key_need_verify_sms", false);
        bundle.putParcelable("key_pay_info", this.sEO);
        bundle.putInt("key_pay_flag", 3);
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
            bundle.putString("transid", bVar.lie);
            bundle.putBoolean("key_should_redirect", bVar.tcO);
            bundle.putString("key_gateway_code", bVar.tbt);
            bundle.putString("key_gateway_reference", bVar.tbs);
            bundle.putString("key_force_adjust_code", bVar.tbv);
            bundle.putBoolean("key_should_force_adjust", bVar.tcP);
            if (bVar.isSuccess()) {
                bundle.putParcelable("key_orders", d.a(this.pPl, bVar.tcQ, bVar.tcR, bVar.cRJ, bVar.sQZ));
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
            com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) kVar;
            bundle.putString("transid", bVar2.lie);
            bundle.putBoolean("key_should_redirect", bVar2.isRedirect);
            bundle.putString("key_gateway_code", bVar2.tbt);
            bundle.putString("key_gateway_reference", bVar2.tbs);
            bundle.putString("key_force_adjust_code", bVar2.tbv);
            bundle.putBoolean("key_should_force_adjust", bVar2.tbu);
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 23351) {
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                this.vf.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.j(this, this.vf);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.c(this, this.vf, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
