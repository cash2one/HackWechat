package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends c {
    static /* synthetic */ String n(b bVar) {
        if (bVar.msB != null) {
            PayInfo payInfo = (PayInfo) bVar.msB.getParcelable("key_pay_info");
            if (payInfo != null) {
                return payInfo.fuH;
            }
        }
        return "";
    }

    public final c a(Activity activity, Bundle bundle) {
        o.Hz(14);
        if (activity instanceof WalletBalanceFetchUI) {
            p.bJN();
            if (!p.bJO().bLM()) {
                this.msB.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.msB.getParcelable("key_bankcard")) != null) {
                this.msB.putInt("key_pay_flag", 3);
                this.msB.putString("key_pwd_cash_title", activity.getString(a$i.uPe));
                Orders orders = (Orders) this.msB.getParcelable("key_orders");
                if (orders != null) {
                    this.msB.putString("key_pwd_cash_money", e.u(orders.pNX));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.msB.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            c(activity, WalletBalanceFetchUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            p.bJN();
            if (!p.bJO().bLM()) {
                this.msB.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.msB.getParcelable("key_bankcard")) != null) {
                this.msB.putInt("key_pay_flag", 3);
                this.msB.putString("key_pwd_cash_title", activity.getString(a$i.uPe));
                Orders orders = (Orders) this.msB.getParcelable("key_orders");
                if (orders != null) {
                    this.msB.putString("key_pwd_cash_money", e.u(orders.pNX));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.msB.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                c(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            c(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletCardElementUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            p.bJN();
            if (p.bJO().bLM()) {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletBalanceFetchResultUI.class, bundle);
        } else if (activity instanceof WalletBalanceFetchResultUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else if (activity instanceof WalletBalanceResultUI) {
            o.cBv();
            b(activity, this.msB);
        } else {
            o.cBv();
            C(activity);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletBalanceManagerUI.class, -1, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final com.tencent.mm.wallet_core.d.e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletBalanceFetchUI) {
            return new 1(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            return new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
                final /* synthetic */ b syb;

                public final boolean d(int i, int i2, String str, k kVar) {
                    boolean z = false;
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.syb.msB.putString("kreq_token", bVar.token);
                    this.syb.msB.putParcelable("key_authen", bVar.sEt);
                    Bundle d = this.syb.msB;
                    String str2 = "key_need_verify_sms";
                    if (!bVar.sEr) {
                        z = true;
                    }
                    d.putBoolean(str2, z);
                    Parcelable parcelable = bVar.oWt;
                    if (parcelable != null) {
                        this.syb.msB.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    a.j(this.zHU, this.syb.msB);
                    this.zHU.finish();
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Bankcard bankcard = (Bankcard) this.syb.msB.getParcelable("key_bankcard");
                    this.syb.msB.putString("key_pwd1", (String) objArr[0]);
                    this.syb.msB.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.fDt = 3;
                    authen.sKs = (String) objArr[0];
                    authen.oZA = bankcard.field_bindSerial;
                    authen.oZz = bankcard.field_bankcardType;
                    authen.pCn = (PayInfo) this.syb.msB.getParcelable("key_pay_info");
                    authen.sKA = bankcard.field_arrive_type;
                    this.zHV.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) this.syb.msB.getParcelable("key_orders")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
                final /* synthetic */ b syb;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        this.syb.msB.putString("kreq_token", bVar.token);
                        if (bVar.sFA) {
                            this.syb.msB.putParcelable("key_orders", bVar.sEs);
                        }
                    }
                    if (this.syb.c(this.zHU, null)) {
                        this.zHV.a(new x(b.n(this.syb), 13), true, 1);
                        return true;
                    }
                    this.syb.a(this.zHU, 0, this.syb.msB);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (this.syb.msB.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!this.syb.bMX()) {
                                authen.fDt = 1;
                                break;
                            }
                            authen.fDt = 4;
                            break;
                        case 2:
                            if (!this.syb.bMX()) {
                                authen.fDt = 2;
                                break;
                            }
                            authen.fDt = 5;
                            break;
                        case 3:
                            if (!this.syb.bMX()) {
                                authen.fDt = 3;
                                break;
                            }
                            authen.fDt = 6;
                            break;
                        default:
                            return false;
                    }
                    this.syb.msB.putParcelable("key_authen", authen);
                    this.zHV.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 4(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletBalanceFetchResultUI) {
            return new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
                final /* synthetic */ b syb;

                public final boolean p(Object... objArr) {
                    Orders orders = (Orders) this.syb.msB.getParcelable("key_orders");
                    Bankcard bankcard = com.tencent.mm.plugin.wallet_core.model.o.bLq().szU;
                    bankcard.sLf -= orders.pNX;
                    this.syb.msB.putInt("key_balance_result_logo", a$h.uGH);
                    return super.p(objArr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }

                public final CharSequence um(int i) {
                    Orders orders;
                    switch (i) {
                        case 0:
                            return this.zHU.getString(a$i.uPr);
                        case 1:
                            orders = (Orders) this.syb.msB.getParcelable("key_orders");
                            if (orders == null || bh.ov(orders.sNR)) {
                                return this.zHU.getString(a$i.uPq);
                            }
                            return orders.sNR;
                        case 2:
                            orders = (Orders) this.syb.msB.getParcelable("key_orders");
                            if (orders != null && orders.sNQ > 0) {
                                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.sNQ));
                            }
                    }
                    return super.um(i);
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 6(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public final int b(MMActivity mMActivity, int i) {
        return a$i.uOZ;
    }

    public final String aKG() {
        return "BalanceFetchProcess";
    }
}
