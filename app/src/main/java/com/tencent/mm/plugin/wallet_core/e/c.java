package com.tencent.mm.plugin.wallet_core.e;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;

public final class c {
    public static long sYH = 0;
    public static int sYI = 2;
    public static int sYJ = 1;
    public static int sYK = 2;

    public static void bNg() {
        sYH = System.currentTimeMillis();
    }

    public static int bNh() {
        return (int) ((System.currentTimeMillis() - sYH) / 1000);
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        com.tencent.mm.wallet_core.c ag = a.ag(activity);
        if (!o.bLq().bLM() && ag != null && ag.cBk()) {
            Orders orders = (Orders) bundle.getParcelable("key_orders");
            if (((PayInfo) bundle.getParcelable("key_pay_info")) != null && orders != null) {
                g.pQN.h(10725, new Object[]{Integer.valueOf(i), Integer.valueOf(r0.fCV), Integer.valueOf((int) (orders.pNX * 100.0d)), orders.paz});
            }
        } else if (!o.bLq().bLM() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
            g.pQN.h(10932, new Object[]{Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0))});
        }
    }

    public static void ea(int i, int i2) {
        g.pQN.h(10932, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static void a(PayInfo payInfo, Orders orders) {
        if (!o.bLq().bLM() && payInfo != null && orders != null) {
            g.pQN.h(10725, new Object[]{Integer.valueOf(1), Integer.valueOf(payInfo.fCV), Integer.valueOf((int) (orders.pNX * 100.0d)), orders.paz});
        }
    }
}
