package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

class aa$3 implements a {
    final /* synthetic */ aa sPC;
    final /* synthetic */ Map sPE;
    final /* synthetic */ long sPF;
    final /* synthetic */ long sPG;
    final /* synthetic */ int sPH;
    final /* synthetic */ int sPI;

    aa$3(aa aaVar, long j, long j2, int i, int i2, Map map) {
        this.sPC = aaVar;
        this.sPF = j;
        this.sPG = j2;
        this.sPH = i;
        this.sPI = i2;
        this.sPE = map;
    }

    public final void T(Map<String, Object> map) {
        if (map != null) {
            long a = bh.a((Long) map.get("wallet_balance_version"), -1);
            long a2 = bh.a((Long) map.get("wallet_balance_last_update_time"), -1);
            if (a2 < 0 || a < 0 || a2 + this.sPF > bh.Wq() || this.sPG >= a) {
                e.a(new c[]{new c("wallet_balance_version", Long.valueOf(this.sPG)), new c("wallet_balance_last_update_time", Long.valueOf(bh.Wq())), new c("wallet_balance", Double.valueOf(((double) this.sPH) / 100.0d))});
                aa.e(this.sPI, this.sPE);
                return;
            }
            x.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
        }
    }
}
