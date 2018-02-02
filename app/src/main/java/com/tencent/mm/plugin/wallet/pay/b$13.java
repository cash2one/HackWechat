package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.d.b;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class b$13 extends a {
    final /* synthetic */ b sEl;

    b$13(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final /* synthetic */ CharSequence um(int i) {
        boolean z = this.sEl.msB.getBoolean("key_is_changing_balance_phone_num");
        boolean z2 = this.sEl.msB.getBoolean("key_is_return_from_switch_phone", false);
        Authen authen = (Authen) this.sEl.msB.getParcelable("key_authen");
        String str = (authen == null || authen.sKF == null) ? "" : authen.sKF;
        int i2 = this.sEl.msB.getInt("key_pay_flag", 3);
        Bankcard bankcard;
        String ou;
        MMActivity mMActivity;
        int i3;
        Object[] objArr;
        if (!z2 || str.isEmpty()) {
            if (!z || i2 == 2) {
                str = bh.az(b.k(this.sEl).getString("key_mobile"), "");
                return String.format(this.zHU.getString(i.uXk), new Object[]{str});
            }
            bankcard = (Bankcard) this.sEl.msB.getParcelable("key_bankcard");
            ou = bh.ou(this.sEl.msB.getString("key_mobile"));
            mMActivity = this.zHU;
            i3 = i.uXb;
            objArr = new Object[2];
            objArr[0] = bankcard.field_desc;
            objArr[1] = e.aaB(bh.ov(ou) ? bankcard.field_mobile : ou);
            return mMActivity.getString(i3, objArr);
        } else if (str.equals("cft")) {
            bankcard = (Bankcard) this.sEl.msB.getParcelable("key_bankcard");
            ou = bh.ou(this.sEl.msB.getString("key_mobile"));
            mMActivity = this.zHU;
            i3 = i.uXb;
            objArr = new Object[2];
            objArr[0] = bankcard.field_desc;
            objArr[1] = e.aaB(bh.ov(ou) ? bankcard.field_mobile : ou);
            return mMActivity.getString(i3, objArr);
        } else {
            str = bh.az(b.j(this.sEl).getString("key_mobile"), "");
            return String.format(this.zHU.getString(i.uXk), new Object[]{str});
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (super.d(i, i2, str, kVar)) {
            return true;
        }
        if (i == 0 && i2 == 0) {
            if ((kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e) || (kVar instanceof b)) {
                com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                if (eVar.sFA) {
                    b.l(this.sEl).putParcelable("key_orders", eVar.sEs);
                }
                Parcelable parcelable = eVar.oWt;
                if (parcelable != null) {
                    b.m(this.sEl).putParcelable("key_realname_guide_helper", parcelable);
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(10707, new Object[]{Integer.valueOf(1), Integer.valueOf(c.bNh())});
                return false;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[1];
        Orders orders = (Orders) b.n(this.sEl).getParcelable("key_orders");
        x.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + this.sEl.msB.getInt("key_pay_flag", 0));
        boolean z = this.sEl.msB.getBoolean("key_is_changing_balance_phone_num");
        String str;
        k a;
        switch (this.sEl.msB.getInt("key_pay_flag", 0)) {
            case 1:
                pVar.flag = "1";
                if (!z) {
                    if (!bh.ov(pVar.oZz)) {
                        com.tencent.mm.plugin.wallet.a.p.bJN();
                        if (com.tencent.mm.plugin.wallet.a.p.bJO().sQf != null) {
                            str = pVar.oZz;
                            com.tencent.mm.plugin.wallet.a.p.bJN();
                            break;
                        }
                    }
                    a = com.tencent.mm.plugin.wallet.pay.a.a.a(pVar, orders);
                    if (a != null) {
                        this.zHV.a(a, true, 1);
                    }
                    return true;
                }
                this.zHV.a(new b(pVar, orders), true, 1);
                return true;
            case 2:
                if (this.sEl.bMX()) {
                    pVar.flag = "5";
                } else {
                    pVar.flag = "2";
                }
                if (!z) {
                    if (!bh.ov(pVar.oZz)) {
                        com.tencent.mm.plugin.wallet.a.p.bJN();
                        if (com.tencent.mm.plugin.wallet.a.p.bJO().sQf != null) {
                            str = pVar.oZz;
                            com.tencent.mm.plugin.wallet.a.p.bJN();
                            break;
                        }
                    }
                    a = com.tencent.mm.plugin.wallet.pay.a.a.a(pVar, orders);
                    if (a != null) {
                        this.zHV.a(a, true, 1);
                    }
                    return true;
                }
                this.zHV.a(new b(pVar, orders), true, 1);
                return true;
            case 3:
                if (this.sEl.bMX()) {
                    pVar.flag = "6";
                } else {
                    pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                }
                if (!z) {
                    if (!bh.ov(pVar.oZz)) {
                        com.tencent.mm.plugin.wallet.a.p.bJN();
                        if (com.tencent.mm.plugin.wallet.a.p.bJO().sQf != null) {
                            str = pVar.oZz;
                            com.tencent.mm.plugin.wallet.a.p.bJN();
                            break;
                        }
                    }
                    a = com.tencent.mm.plugin.wallet.pay.a.a.a(pVar, orders);
                    if (a != null) {
                        this.zHV.a(a, true, 1);
                    }
                    return true;
                }
                this.zHV.a(new b(pVar, orders), true, 1);
                return true;
            default:
                return false;
        }
    }
}
