package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;

public class e extends c {
    public final c a(Activity activity, Bundle bundle) {
        if (!o.bLq().bLL()) {
            if (o.bLq().bLM()) {
                c(activity, WalletCheckPwdUI.class, bundle);
            } else {
                c(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            C(activity);
            c(activity, WalletWXCreditOpenUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                c(activity, WalletBindDepositUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletBindDepositUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (o.bLq().bLM()) {
                c(activity, WalletWXCreditOpenResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletWXCreditOpenResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenResultUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final com.tencent.mm.wallet_core.d.e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletCheckIdentityUI) {
            return new 2(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
                final /* synthetic */ e tYU;

                public final /* synthetic */ CharSequence um(int i) {
                    if (this.tYU.msB.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) this.tYU.msB.getParcelable("key_bankcard");
                        return this.zHU.getString(i.uXl, new Object[]{bankcard.field_bankName, bankcard.field_bankName, this.tYU.msB.getString("key_mobile")});
                    }
                    return this.zHU.getString(i.uXm, new Object[]{this.tYU.msB.getString("key_mobile")});
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) kVar).fCU;
                        if (!bh.ov(str2)) {
                            this.tYU.msB.putString("key_bank_username", str2);
                        }
                        this.tYU.a(this.zHU, 0, this.tYU.msB);
                        return true;
                    } else if (kVar instanceof h) {
                        this.tYU.a(this.zHU, 0, this.tYU.msB);
                        return true;
                    } else if (kVar instanceof q) {
                        if (o.bLq().bLM()) {
                            this.zHV.a(new x(), true, 1);
                            return true;
                        }
                        this.tYU.a(this.zHU, 0, this.tYU.msB);
                        return true;
                    } else if (!(kVar instanceof x)) {
                        return false;
                    } else {
                        this.zHV.a(new com.tencent.mm.plugin.wxcredit.a.g(this.tYU.msB.getString("key_verify_code"), this.tYU.msB.getString("KEY_SESSION_KEY"), this.tYU.msB.getString("key_pwd1"), o.bLq().bMb(), this.tYU.msB.getString("key_bank_type")), true, 1);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    String str = (String) objArr[0];
                    this.tYU.msB.putString("key_verify_code", str);
                    p pVar;
                    if (o.bLq().bLM()) {
                        if (!this.tYU.msB.getBoolean("key_need_bind_deposit", true) || this.tYU.msB.getBoolean("key_is_bank_user")) {
                            this.zHV.a(new com.tencent.mm.plugin.wxcredit.a.g(str, this.tYU.msB.getString("KEY_SESSION_KEY"), this.tYU.msB.getString("key_pwd1"), this.tYU.msB.getString("key_bind_serial"), this.tYU.msB.getString("key_bank_type")), true, 1);
                        } else {
                            pVar = (p) objArr[1];
                            pVar.flag = "2";
                            this.zHV.a(new q(pVar), true, 1);
                        }
                    } else if (this.tYU.msB.getBoolean("key_is_bank_user", false)) {
                        this.tYU.msB.putString("key_verify_code", str);
                        this.zHV.a(new h(str, this.tYU.msB.getString("KEY_SESSION_KEY"), this.tYU.msB.getString("key_pwd1"), this.tYU.msB.getString("key_bind_serial"), this.tYU.msB.getString("key_bank_type")), true, 1);
                    } else {
                        pVar = (p) objArr[1];
                        pVar.flag = "1";
                        this.zHV.a(new q(pVar), true, 1);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBindDepositUI) {
            return new 4(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
                final /* synthetic */ e tYU;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof b) {
                        this.zHV.a(new x(), true, 1);
                        return true;
                    } else if (kVar instanceof x) {
                        this.zHV.a(new com.tencent.mm.plugin.wxcredit.a.g(this.tYU.msB.getString("key_verify_code"), this.tYU.msB.getString("KEY_SESSION_KEY"), this.tYU.msB.getString("key_pwd1"), o.bLq().bMb(), this.tYU.msB.getString("key_bank_type")), true, 1);
                        return true;
                    } else if (!(kVar instanceof com.tencent.mm.plugin.wxcredit.a.g)) {
                        return false;
                    } else {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) kVar).fCU;
                        if (!bh.ov(str2)) {
                            this.tYU.msB.putString("key_bank_username", str2);
                        }
                        this.tYU.a(this.zHU, 0, this.tYU.msB);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    if (this.tYU.msB.getBoolean("key_is_bank_user", false)) {
                        this.zHV.a(new com.tencent.mm.plugin.wxcredit.a.g(this.tYU.msB.getString("key_verify_code"), this.tYU.msB.getString("KEY_SESSION_KEY"), this.tYU.msB.getString("key_pwd1"), o.bLq().bMb(), this.tYU.msB.getString("key_bank_type")), true, 1);
                    } else {
                        this.zHV.a(new b((p) objArr[0]), true, 1);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletWXCreditOpenResultUI ? new 6(this, mMActivity, gVar) : null;
    }

    public final String aKG() {
        return "WXCreditOpenProcess";
    }
}
