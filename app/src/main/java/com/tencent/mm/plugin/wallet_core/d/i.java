package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends com.tencent.mm.sdk.e.i<ac> {
    public static final String[] gJN = new String[]{com.tencent.mm.sdk.e.i.a(ac.gJc, "WalletRegionGreyAreaList")};
    private e gJP;

    public i(e eVar) {
        super(eVar, ac.gJc, "WalletRegionGreyAreaList", null);
        this.gJP = eVar;
    }

    public final void a(int i, awc com_tencent_mm_protocal_c_awc) {
        c acVar = new ac();
        acVar.field_wallet_region = i;
        try {
            acVar.field_wallet_grey_item_buf = com_tencent_mm_protocal_c_awc.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(acVar);
    }

    public final ac zm(int i) {
        String str = "select * from WalletRegionGreyAreaList where wallet_region = " + i;
        Cursor a = this.gJP.a(str, null, 2);
        x.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + str);
        if (a == null) {
            return new ac();
        }
        ac acVar = new ac();
        if (a.moveToNext()) {
            acVar = new ac();
            acVar.b(a);
        }
        x.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        a.close();
        return acVar;
    }
}
