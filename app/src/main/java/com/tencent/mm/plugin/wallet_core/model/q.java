package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class q {
    public List<ElementQuery> sIH = null;
    public SparseArray<String> sPo = null;

    public final String O(Context context, int i) {
        if (this.sPo != null) {
            String str = (String) this.sPo.get(i);
            if (!bh.ov(str)) {
                return str;
            }
        }
        return context.getString(i.uQe);
    }

    public final ElementQuery MT(String str) {
        if (this.sIH == null || this.sIH.size() == 0) {
            x.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            return null;
        }
        for (ElementQuery elementQuery : this.sIH) {
            if (elementQuery.oZz != null && elementQuery.oZz.equals(str)) {
                return elementQuery;
            }
        }
        x.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[]{str});
        return null;
    }

    public final ElementQuery MU(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            return null;
        } else if (this.sIH == null || this.sIH.size() == 0) {
            x.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            return null;
        } else {
            for (ElementQuery elementQuery : this.sIH) {
                if (str.equals(elementQuery.oZA)) {
                    return elementQuery;
                }
            }
            x.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            return null;
        }
    }
}
