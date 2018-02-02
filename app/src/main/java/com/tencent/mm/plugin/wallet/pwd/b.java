package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletPasswordSettingUI.class, -1, false);
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 2(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                h.a(walletBaseUI, str, null, walletBaseUI.getString(i.uWJ), false, new OnClickListener(this) {
                    final /* synthetic */ b sGq;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.sGq.b(walletBaseUI, this.sGq.msB);
                        if (walletBaseUI.aYf()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.cCa();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uWJ;
    }

    public final String aKG() {
        return "ModifyPwdProcess";
    }
}
