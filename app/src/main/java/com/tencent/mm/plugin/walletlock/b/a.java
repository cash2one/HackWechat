package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.x;

public class a implements b {
    public static int N(Activity activity) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[]{activity.getClass().getSimpleName()});
        if (activity.getClass().getSimpleName().equals("MallIndexUI")) {
            return 1;
        }
        if (activity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
            return 2;
        }
        return -1;
    }

    public void init() {
        g.tho.zz(0);
    }

    public void a(Activity activity, b.b bVar) {
    }

    public void a(Activity activity, b.b bVar, b$a com_tencent_mm_plugin_walletlock_a_b_a) {
    }

    public void j(Activity activity, int i) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            new c().j(activity, i);
        } else if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().j(activity, i);
        }
    }

    public void b(Activity activity, int i, int i2) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            new c().b(activity, i, i2);
        } else if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(activity, i, i2);
        }
    }

    public void L(Activity activity) {
    }

    public void k(Activity activity, int i) {
    }

    public b.b bNx() {
        return null;
    }

    public boolean bNy() {
        return false;
    }

    public boolean bNz() {
        return false;
    }

    public void c(Activity activity, Intent intent) {
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivity(intent);
    }

    public void b(Activity activity, Intent intent, int i) {
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivityForResult(intent, i);
    }

    public void zu(int i) {
    }
}
