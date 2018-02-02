package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends c {
    static /* synthetic */ String b(a aVar) {
        String string = aVar.msB.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sZc);
        return bh.ov(string) ? "WEB_DEBIT" : string;
    }

    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletOpenECardProxyUI.class, bundle);
        x.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[]{Integer.valueOf(bNk())});
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletECardBindCardListUI.class, null);
        } else if (activity instanceof WalletECardBindCardListUI) {
            if (this.msB.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sZb, com.tencent.mm.plugin.wallet_ecard.a.a.sZq) != com.tencent.mm.plugin.wallet_ecard.a.a.sZq) {
                c(activity, WalletECardCheckOtherCardUI.class, null);
            } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZm)) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                g(activity, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            g(activity, bundle);
        } else if (activity instanceof WalletECardCheckOtherCardUI) {
            x.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[]{Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZn, false)), Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZm))});
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZn, false)) {
                c(activity, WalletECardElementInputUI.class, null);
            } else if (r1) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                g(activity, bundle);
            }
        } else if (activity instanceof WalletECardElementInputUI) {
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZm)) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
                return;
            }
            g(activity, bundle);
        } else if (activity instanceof WalletOpenECardProxyUI) {
            boolean z = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZa, false);
            this.msB.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZa, z);
            String string = this.msB.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sYY);
            x.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s", new Object[]{Integer.valueOf(bNk()), Boolean.valueOf(bh.ov(string)), Boolean.valueOf(z)});
            if (bh.ov(string)) {
                a(activity, WalletCheckPwdUI.class, bundle, 1);
            } else if (z) {
                c(activity, WalletCheckPwdUI.class, bundle);
            } else if (r2 == 3) {
                c(activity, WalletECardBindCardListUI.class, null);
            }
        }
    }

    private void g(Activity activity, Bundle bundle) {
        x.k("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[]{Integer.valueOf(bNk())});
        if (bNk() == 3) {
            bundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX, 3);
            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.sZd, this.msB.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sZd, ""));
            c(activity, WalletOpenLqbProxyUI.class, bundle);
            return;
        }
        c(activity, WalletECardFinishUI.class, null);
    }

    public final void d(Activity activity, int i) {
        if (i == 100) {
            x.i("MicroMsg.OpenECardProcess", "back to card list");
            int bNk = bNk();
            String bNj = bNj();
            String str = (String) this.msB.get("key_pwd1");
            this.msB.clear();
            this.msB.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX, bNk);
            this.msB.putString(com.tencent.mm.plugin.wallet_ecard.a.a.sYZ, bNj);
            this.msB.putString("key_pwd1", str);
            a(activity, WalletECardBindCardListUI.class, 0);
        } else if (!(activity instanceof WalletVerifyCodeUI)) {
        } else {
            if (this.msB.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sZb) == com.tencent.mm.plugin.wallet_ecard.a.a.sZq) {
                a(activity, WalletECardBindCardListUI.class, 0);
            } else {
                a(activity, WalletECardCheckOtherCardUI.class, 0);
            }
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        x.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[]{activity});
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        Activity activity2 = activity;
        a(activity2, WalletOpenECardProxyUI.class, bundle.getInt("key_process_result_code", -1), intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "OpenECardProcess";
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uJe;
    }

    public final boolean h(Activity activity, Bundle bundle) {
        x.d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        return super.h(activity, bundle);
    }

    private String bNj() {
        return this.msB.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sYZ);
    }

    private int bNk() {
        return this.msB.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX);
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new b(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletECardBindCardListUI) {
            return new d(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            return new a(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletECardElementInputUI) {
            return new e(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletOpenECardProxyUI) {
            return new c(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletOpenLqbProxyUI) {
            return new f(this, mMActivity, gVar);
        }
        return super.a(mMActivity, gVar);
    }
}
