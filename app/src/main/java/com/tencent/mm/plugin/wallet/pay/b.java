package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.sz$a;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class b extends a {
    public final c a(Activity activity, Bundle bundle) {
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.fCV);
        bundle.putInt("key_pay_channel", payInfo.fCR);
        if (!e(activity, bundle)) {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.fCV == 11) {
                o.Hz(13);
            }
            x.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    x.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    c(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    x.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    c(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !bMX()) {
                        x.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        c(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    x.i("MicroMsg.PayProcess", "jump to result ui!");
                    f(activity, bundle);
                    break;
                default:
                    break;
            }
        }
        x.w("MicroMsg.PayProcess", "hy: has err. return");
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (e(activity, bundle)) {
            x.i("MicroMsg.PayProcess", "deal with the err!");
            return;
        }
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.msB.getBoolean("key_forward_to_id_verify", false)) {
                x.i("MicroMsg.PayProcess", "go to verify id tail");
                c(activity, WalletVerifyIdCardUI.class, this.msB);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            f(activity, bundle);
        }
        int i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.msB.getInt("key_pay_flag", 0);
        x.i("MicroMsg.PayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 1:
                x.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    c(activity, WalletPwdConfirmUI.class, bundle);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bMX()) {
                        x.i("MicroMsg.PayProcess", "oversea, set pwd");
                        c(activity, WalletSetPasswordUI.class, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 2:
                x.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bMX()) {
                        x.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 3:
                x.i("MicroMsg.PayProcess", "forwardBound()");
                if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if ((activity instanceof WalletResetInfoUI) || (activity instanceof WalletChangeBankcardUI)) {
                    if ((!bundle.getBoolean("key_need_verify_sms", false) || bMX()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        x.i("MicroMsg.PayProcess", "jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else if ((activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    x.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void d(Activity activity, int i) {
        x.i("MicroMsg.PayProcess", "back pay_flag : " + this.msB.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            return;
        }
        o.cBv();
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i = -1;
        x.i("MicroMsg.PayProcess", "end pay_flag : " + this.msB.getInt("key_pay_flag", 0));
        o.cBv();
        int i2 = this.msB.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            payInfo = (PayInfo) this.msB.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.msB.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.msB.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.msB.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.msB.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.msB.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.fCR);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.msB.getParcelable("key_orders"));
        com.tencent.mm.sdk.b.b szVar = new sz();
        szVar.fLs.intent = intent;
        szVar.fLs.fuH = bJQ();
        sz$a com_tencent_mm_g_a_sz_a = szVar.fLs;
        if (!this.msB.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        com_tencent_mm_g_a_sz_a.result = i;
        if (szVar.fLs.result == 0 && bundle != null) {
            payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                com.tencent.mm.plugin.wallet.pay.a.b.b.S(payInfo.fuH, payInfo.fCV, payInfo.fCR);
            }
        }
        com.tencent.mm.sdk.b.a.xef.m(szVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
    }

    private boolean e(Activity activity, Bundle bundle) {
        x.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", new Object[]{Integer.valueOf(bundle.getInt("key_err_code", 0))});
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                c(activity, WalletChangeBankcardUI.class, bundle);
                return true;
            case -1003:
                p.bJN();
                if (p.bJO().bLM()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
                return true;
            case e.CTRL_INDEX /*402*/:
            case ap.CTRL_INDEX /*403*/:
            case av.CTRL_INDEX /*408*/:
                Bankcard bankcard = (Bankcard) this.msB.get("key_bankcard");
                if (bankcard == null || !bankcard.bKP()) {
                    c(activity, WalletResetInfoUI.class, bundle);
                } else if (com.tencent.mm.plugin.wallet_core.model.o.bLq().bLX() == null || com.tencent.mm.plugin.wallet_core.model.o.bLq().bLX().size() <= 0) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    x.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", com.tencent.mm.plugin.wallet_core.model.o.bLq().bLX());
                    bundle2.putString("key_top_tips", activity.getString(a$i.uWw));
                    c(activity, WalletSelectBankcardUI.class, bundle2);
                }
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletResetInfoUI.class, bundle);
                return true;
            default:
                return false;
        }
    }

    private void f(Activity activity, Bundle bundle) {
        if (this.msB != null && this.msB.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.msB.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        x.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", new Object[]{Integer.valueOf(i)});
        if (i == 11 || i == 21) {
            c(activity, WalletBalanceResultUI.class, bundle);
        } else if (i == 5 || i == 31 || i == 32 || i == 33 || i == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.pLj != 1) {
                a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                return;
            }
            x.i("MicroMsg.PayProcess", "is busi f2f");
            b(activity, bundle);
        } else if (i == 37 || i == 39 || i == 42 || i == 45 || i == 52 || i == 49) {
            b(activity, bundle);
        } else {
            c(activity, WalletOrderInfoUI.class, bundle);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayProcess", "pay_flag : " + this.msB.getInt("key_pay_flag", 0));
        switch (this.msB.getInt("key_pay_flag", 0)) {
            case 1:
                return activity instanceof WalletOrderInfoUI;
            case 2:
                return activity instanceof WalletOrderInfoUI;
            default:
                return false;
        }
    }

    public final com.tencent.mm.wallet_core.d.e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletPayUI) {
            return new 1(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new a(this, (WalletBaseUI) mMActivity, gVar) {
                final /* synthetic */ b sEl;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    this.zHV.a(new r((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBankcardIdUI) {
            return new 11(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new 12(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 13(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new 14(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new 15(this, (WalletBaseUI) mMActivity, gVar);
        }
        if (mMActivity instanceof WalletChangeBankcardUI) {
            return new c(this, (WalletBaseUI) mMActivity, gVar) {
                final /* synthetic */ b sEl;

                public final boolean k(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSelectBankcardUI) {
            return new 17(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletResetInfoUI) {
            return new a(this, (WalletBaseUI) mMActivity, gVar) {
                final /* synthetic */ b sEl;

                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            return new 3(this, (WalletBaseUI) mMActivity, gVar);
        }
        return mMActivity instanceof WalletVerifyIdCardUI ? new a(this, (WalletBaseUI) mMActivity, gVar) {
            final /* synthetic */ b sEl;

            public final boolean k(Object... objArr) {
                if (objArr.length > 0) {
                    this.zHV.a(com.tencent.mm.plugin.wallet.pay.a.a.a((com.tencent.mm.plugin.wallet_core.model.p) objArr[0], (Orders) this.sEl.msB.getParcelable("key_orders")), true, 1);
                }
                return false;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (super.d(i, i2, str, kVar) || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e)) {
                    return false;
                }
                com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                if (i != 0 || i2 != 0) {
                    return false;
                }
                if (eVar.sFA) {
                    this.sEl.msB.putParcelable("key_orders", eVar.sEs);
                }
                Parcelable parcelable = eVar.oWt;
                if (parcelable != null) {
                    this.sEl.msB.putParcelable("key_realname_guide_helper", parcelable);
                }
                this.sEl.a(this.zHU, 0, this.sEl.msB);
                this.zHU.finish();
                return true;
            }
        } : super.a(mMActivity, gVar);
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        x.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case e.CTRL_INDEX /*402*/:
            case ap.CTRL_INDEX /*403*/:
            case av.CTRL_INDEX /*408*/:
                if (cBl() && this.msB.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.msB.getParcelable("key_bankcard");
                    if (bh.ov(str)) {
                        string = walletBaseUI.getString(a$i.uUY, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.uUX), walletBaseUI.getString(a$i.dEn), new 5(this, i, walletBaseUI), null);
                    return true;
                }
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                x.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                p.bJN();
                ArrayList bLX = p.bJO().bLX();
                if (bLX == null || bLX.isEmpty()) {
                    h.a(walletBaseUI, str, "", walletBaseUI.getString(a$i.uUs), walletBaseUI.getString(a$i.uPU), new OnClickListener(this) {
                        final /* synthetic */ b sEl;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.sEl.msB.putInt("key_err_code", -1003);
                            this.sEl.a(walletBaseUI, 0, this.sEl.msB);
                            if (walletBaseUI.aYf()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new 7(this, walletBaseUI));
                } else {
                    h.a(walletBaseUI, str, "", walletBaseUI.getString(a$i.uUI), walletBaseUI.getString(a$i.uPU), new 8(this, walletBaseUI), new OnClickListener(this) {
                        final /* synthetic */ b sEl;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.sEl.b(walletBaseUI, this.sEl.msB);
                            if (walletBaseUI.aYf()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
        }
        return false;
    }

    private String bJQ() {
        if (this.msB == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.msB.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fuH;
        }
        return "";
    }

    public final int b(MMActivity mMActivity, int i) {
        return a$i.uUR;
    }

    public final String aKG() {
        return "PayProcess";
    }
}
