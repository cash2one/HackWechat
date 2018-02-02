package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends b {
    static /* synthetic */ void e(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).vf.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).vf.getInt("offline_add_fee", 0);
        Bankcard bhK = a.bhK();
        if (bhK != null) {
            ((WalletBaseUI) mMActivity).r(new k(bhK, string, i));
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        com.tencent.mm.sdk.b.a.xef.m(new kq());
        c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, int i) {
        super.d(activity, i);
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 1(this, mMActivity, gVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new e(this, mMActivity, gVar) {
            final /* synthetic */ d oVk;

            public final boolean k(Object... objArr) {
                this.zHV.a(new com.tencent.mm.plugin.wallet_core.b.a.b((p) objArr[0]), true, 1);
                return true;
            }

            public final boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof x) {
                        if (!(((WalletBaseUI) this.zHU).vf == null || ((WalletBaseUI) this.zHU).vf.getInt("key_bind_scene", -1) != 5 || a.bhH())) {
                            d.e(this.zHU);
                        }
                        return true;
                    } else if (kVar instanceof k) {
                        Bundle bundle = ((WalletBaseUI) this.zHU).vf;
                        bundle.putBoolean("intent_bind_end", true);
                        com.tencent.mm.wallet_core.a.j(this.zHU, bundle);
                        a.F(this.zHU);
                        return true;
                    }
                }
                return false;
            }
        } : super.a(mMActivity, gVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return super.c(activity, bundle);
    }

    public final String aKG() {
        return "OfflineBindCardRegProcess";
    }
}
