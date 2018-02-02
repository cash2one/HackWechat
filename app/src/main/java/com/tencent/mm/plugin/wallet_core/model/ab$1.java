package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

class ab$1 implements a {
    final /* synthetic */ int sPH;
    final /* synthetic */ long sPJ;
    final /* synthetic */ long sPK;
    final /* synthetic */ Bankcard sPL;

    ab$1(long j, long j2, int i, Bankcard bankcard) {
        this.sPJ = j;
        this.sPK = j2;
        this.sPH = i;
        this.sPL = bankcard;
    }

    public final void T(Map<String, Object> map) {
        if (map != null) {
            long a = bh.a((Long) map.get("wallet_balance_version"), -1);
            long a2 = bh.a((Long) map.get("wallet_balance_last_update_time"), -1);
            if (a2 < 0 || a < 0 || a2 + this.sPJ > bh.Wq() || this.sPK >= a) {
                e.a(new c("wallet_balance_version", Long.valueOf(this.sPK)), new c("wallet_balance_last_update_time", Long.valueOf(bh.Wq())), new c("wallet_balance", Double.valueOf(((double) this.sPH) / 100.0d)));
                this.sPL.sLf = ((double) this.sPH) / 100.0d;
                return;
            }
            x.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
        }
    }
}
