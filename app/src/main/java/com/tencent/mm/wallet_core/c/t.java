package com.tencent.mm.wallet_core.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class t {
    public static void j(int i, String str, int i2) {
        x.v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        g.pQN.h(14997, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
    }

    public static void d(int i, String str, int i2, String str2) {
        x.v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2});
        g.pQN.h(15001, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2});
    }
}
