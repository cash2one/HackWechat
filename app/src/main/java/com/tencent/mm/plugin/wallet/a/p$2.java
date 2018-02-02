package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.Map;

class p$2 implements m {
    final /* synthetic */ p sDY;

    p$2(p pVar) {
        this.sDY = pVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
            Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
            String str2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
            x.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[]{Integer.valueOf(bh.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj});
            if (bh.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                c.Bq().b(w.a.xwe, true);
            } else {
                c.Bq().b(w.a.xwe, false);
            }
            if (r3 == 1) {
                c.Bq().b(w.a.xwf, true);
            } else {
                c.Bq().b(w.a.xwf, false);
            }
            if (!bh.ov(str2)) {
                g.Dk();
                g.Dj().CU().a(w.a.xwh, str2);
            }
            if (!bh.ov(obj)) {
                g.Dk();
                str2 = (String) g.Dj().CU().get(w.a.xwi, "");
                if (!bh.ov(str2)) {
                    obj = str2 + "," + obj;
                }
                g.Dk();
                g.Dj().CU().a(w.a.xwi, obj);
            }
        }
    }
}
