package com.tencent.mm.plugin.wallet.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class a {
    public static boolean bKF() {
        boolean z;
        l lVar = (l) g.h(l.class);
        x.i("MicroMsg.WalletUtil", "mgr==null?" + (lVar == null));
        if (lVar != null) {
            x.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + lVar.aKi());
        }
        p.bJN();
        ag bJO = p.bJO();
        ae bLQ = bJO.bLQ();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (bLQ == null) {
            z = true;
        } else {
            z = false;
        }
        x.i(str, stringBuilder.append(z).toString());
        if (bLQ != null) {
            x.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + bLQ.bLF());
        }
        x.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + bJO.bLM());
        if (lVar != null && lVar.aKi() && bLQ != null && bLQ.bLF() && bJO.bLM()) {
            return true;
        }
        return false;
    }

    public static boolean bKG() {
        boolean z;
        c fn = com.tencent.mm.z.c.c.IF().fn("100338");
        if (!fn.isValid()) {
            z = false;
        } else if (bh.getInt((String) fn.chI().get("enabled"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletUtil", "isEnableSaveAndFetchBindQuery enabled: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
