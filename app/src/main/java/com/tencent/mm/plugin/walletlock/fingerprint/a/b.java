package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.b.a;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    public final void init() {
        g gVar = g.tho;
        g.jX(true);
        g.tho.zz(2);
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar) {
        if (!com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        } else if (bVar == null || bVar.M(activity)) {
            com.tencent.mm.sdk.b.b svVar = new sv();
            svVar.fLi.fLk = 0;
            svVar.fLi.activity = activity;
            com.tencent.mm.sdk.b.a.xef.m(svVar);
            switch (((Integer) svVar.fLj.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.N(activity));
                    intent.setPackage(ac.getPackageName());
                    activity.startActivity(intent);
                    return;
                default:
                    return;
            }
        } else {
            x.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
        }
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar, b$a com_tencent_mm_plugin_walletlock_a_b_a) {
        if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            com.tencent.mm.sdk.b.b svVar = new sv();
            svVar.fLi.fLk = 1;
            svVar.fLi.activity = activity;
            com.tencent.mm.sdk.b.a.xef.m(svVar);
            switch (((Integer) svVar.fLj.data).intValue()) {
                case 17:
                    if (bVar == null || bVar.M(activity)) {
                        Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                        intent.putExtra("action", "action.verify_pattern");
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.putExtra("scene", a.N(activity));
                        intent.setPackage(ac.getPackageName());
                        activity.startActivity(intent);
                        return;
                    }
                    x.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
    }

    public final void j(Activity activity, int i) {
        if (i == 2) {
            if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 2);
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
                return;
            }
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        }
    }

    public final void b(Activity activity, int i, int i2) {
        if (i == 2) {
            if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 2);
                x.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[]{Integer.valueOf(i)});
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
                return;
            }
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        }
    }

    public final void L(Activity activity) {
    }

    public final void k(Activity activity, int i) {
    }

    public final com.tencent.mm.plugin.walletlock.a.b.b bNx() {
        return com.tencent.mm.plugin.walletlock.b.d.bOf();
    }

    public final boolean bNy() {
        g gVar = g.tho;
        return g.bNC();
    }

    public final boolean bNz() {
        return false;
    }
}
