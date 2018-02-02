package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.6;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtSaveFetchUI$6$4 implements a<Void, bbp> {
    final /* synthetic */ 6 sBy;
    final /* synthetic */ int sBz;

    WalletLqtSaveFetchUI$6$4(6 6, int i) {
        this.sBy = 6;
        this.sBz = i;
    }

    public final /* synthetic */ Object call(Object obj) {
        return a((bbp) obj);
    }

    private Void a(bbp com_tencent_mm_protocal_c_bbp) {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[]{com_tencent_mm_protocal_c_bbp, Boolean.valueOf(com_tencent_mm_protocal_c_bbp.wHS), Boolean.valueOf(com_tencent_mm_protocal_c_bbp.wHT)});
        if (com_tencent_mm_protocal_c_bbp.wHS && com_tencent_mm_protocal_c_bbp.wHT) {
            Intent intent = new Intent(this.sBy.sBv, WalletLqtSaveFetchFinishUI.class);
            intent.putExtra("key_amount", ((double) this.sBz) / 100.0d);
            intent.putExtra("key_mode", 2);
            this.sBy.sBv.startActivity(intent);
        } else {
            Intent intent2 = new Intent(this.sBy.sBv, WalletLqtSaveFetchFinishProgressUI.class);
            try {
                intent2.putExtra("key_redeem_res", com_tencent_mm_protocal_c_bbp.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "pass redeemFundRes error: %s", new Object[]{e.getMessage()});
            }
            this.sBy.sBv.startActivity(intent2);
        }
        this.sBy.sBv.finish();
        return zBS;
    }
}
