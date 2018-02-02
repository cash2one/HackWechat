package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.bs.a;
import java.util.ArrayList;
import java.util.Map;

public final class aa {
    static ArrayList<j> mhp = null;
    private static aa sPB = null;
    a lhZ = new 1(this);

    static /* synthetic */ boolean a(aa aaVar, int i, Map map) {
        if (map == null) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            return true;
        } else if (i < 0) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            return true;
        } else if (i != 12) {
            return false;
        } else {
            int i2 = bh.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            long j = bh.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            String[] strArr = new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"};
            e.a(strArr, new 3(aaVar, bh.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200), j, i2, i, map));
            return true;
        }
    }

    private aa() {
    }

    public static aa bLA() {
        if (sPB == null) {
            sPB = new aa();
        }
        return sPB;
    }

    public static boolean a(j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
            return false;
        }
        if (mhp == null) {
            mhp = new ArrayList();
        }
        mhp.add(jVar);
        return true;
    }

    public static boolean b(j jVar) {
        if (mhp == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            return false;
        }
        mhp.remove(jVar);
        return true;
    }
}
