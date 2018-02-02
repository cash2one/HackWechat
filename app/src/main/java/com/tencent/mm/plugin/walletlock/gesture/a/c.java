package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.b.a;
import com.tencent.mm.plugin.walletlock.b.d;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    public final /* synthetic */ b bNx() {
        return d.bOf();
    }

    public final void init() {
        x.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
        g gVar = g.tho;
        g.jW(true);
        g.tho.zz(1);
    }

    public final void a(Activity activity, b bVar) {
        if (!com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (bVar == null || bVar.M(activity)) {
            com.tencent.mm.sdk.b.b svVar = new sv();
            svVar.fLi.fLk = 0;
            svVar.fLi.activity = activity;
            com.tencent.mm.sdk.b.a.xef.m(svVar);
            switch (((Integer) svVar.fLj.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.N(activity));
                    intent.setPackage(ac.getPackageName());
                    activity.startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        } else {
            x.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
        }
    }

    public final void a(Activity activity, b bVar, b$a com_tencent_mm_plugin_walletlock_a_b_a) {
        if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            com.tencent.mm.sdk.b.b svVar = new sv();
            svVar.fLi.fLk = 1;
            svVar.fLi.activity = activity;
            com.tencent.mm.sdk.b.a.xef.m(svVar);
            switch (((Integer) svVar.fLj.data).intValue()) {
                case 17:
                    if (bVar == null || bVar.M(activity)) {
                        Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                        intent.putExtra("action", "action.verify_pattern");
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.putExtra("scene", a.N(activity));
                        intent.setPackage(ac.getPackageName());
                        activity.startActivity(intent);
                        return;
                    }
                    x.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
    }

    public final void j(Activity activity, int i) {
        if (i == 1) {
            if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 1);
                com.tencent.mm.bm.d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
                return;
            }
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        }
    }

    public final void b(Activity activity, int i, int i2) {
        if (i == 1) {
            if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 1);
                com.tencent.mm.bm.d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
                return;
            }
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        }
    }

    public final void L(Activity activity) {
        if (!com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (b.bNN()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("action", "action.verify_pattern");
            intent.putExtra("next_action", "next_action.modify_pattern");
            intent.setPackage(ac.getPackageName());
            activity.startActivity(intent);
        } else {
            x.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
        }
    }

    public final void k(Activity activity, int i) {
        if (!com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (b.bNN()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("action", "action.verify_pattern");
            intent.putExtra("next_action", "next_action.switch_off_pattern");
            intent.setPackage(ac.getPackageName());
            activity.startActivity(intent);
        } else {
            x.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
        }
    }

    public final boolean bNy() {
        return b.bNN();
    }

    public final boolean bNz() {
        return b.bNO();
    }
}
