package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$f extends e {
    final /* synthetic */ a sZD;

    public a$f(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        ((Integer) objArr[0]).intValue();
        String str = (String) objArr[1];
        this.zHV.ji(2996);
        this.zHV.a(new q(a.b(this.sZD), str), true);
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof q)) {
            return false;
        }
        x.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        q qVar = (q) kVar;
        if (i == 0 && i2 == 0) {
            auu com_tencent_mm_protocal_c_auu = qVar.szf;
            if (com_tencent_mm_protocal_c_auu.kLO == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                d.b(this.zHU, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
            } else {
                Toast.makeText(this.zHU, com_tencent_mm_protocal_c_auu.kLP, 1).show();
            }
        } else {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{kVar});
            h.b(this.zHU, b.d(this.zHU, new String[]{str}), "", false);
        }
        this.zHU.finish();
        this.sZD.b(this.zHU, new Bundle());
        return true;
    }
}
