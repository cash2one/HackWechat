package com.tencent.mm.plugin.wallet.balance;

import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class b$4 extends e {
    final /* synthetic */ b syb;

    b$4(b bVar, MMActivity mMActivity, g gVar) {
        this.syb = bVar;
        super(mMActivity, gVar);
    }

    public final /* synthetic */ CharSequence um(int i) {
        String str;
        String az = bh.az(b.y(this.syb).getString("key_mobile"), "");
        if (bh.ov(az)) {
            Bankcard bankcard = (Bankcard) b.z(this.syb).getParcelable("key_bankcard");
            if (bankcard != null) {
                str = bankcard.field_mobile;
                return this.zHU.getString(i.uXj, new Object[]{str});
            }
        }
        str = az;
        return this.zHU.getString(i.uXj, new Object[]{str});
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e) {
                com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                if (eVar.sFA) {
                    b.r(this.syb).putParcelable("key_orders", eVar.sEs);
                }
                a.j(this.zHU, b.s(this.syb));
                return true;
            } else if (kVar instanceof b) {
                b bVar = (b) kVar;
                Parcelable parcelable = bVar.oWt;
                if (parcelable != null) {
                    b.t(this.syb).putParcelable("key_realname_guide_helper", parcelable);
                }
                b.u(this.syb).putString("kreq_token", bVar.token);
                return true;
            }
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[1];
        if (!(pVar == null || pVar.pCn == null)) {
            pVar.pCn.fCV = 21;
        }
        Orders orders = (Orders) b.v(this.syb).getParcelable("key_orders");
        switch (this.syb.msB.getInt("key_pay_flag", 0)) {
            case 1:
                pVar.flag = "1";
                break;
            case 2:
                if (!this.syb.bMX()) {
                    pVar.flag = "2";
                    break;
                }
                pVar.flag = "5";
                break;
            case 3:
                if (!this.syb.bMX()) {
                    pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    break;
                }
                pVar.flag = "6";
                break;
            default:
                return false;
        }
        this.zHV.a(new com.tencent.mm.plugin.wallet.pay.a.d.e(pVar, orders), true, 1);
        return true;
    }

    public final boolean q(Object... objArr) {
        Authen authen = (Authen) b.x(this.syb).getParcelable("key_authen");
        this.zHV.a(new b(authen, (Orders) b.w(this.syb).getParcelable("key_orders")), true, 1);
        return true;
    }
}
