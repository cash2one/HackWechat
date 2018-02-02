package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$c extends e {
    final /* synthetic */ a sZD;

    public a$c(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        int intValue = ((Integer) objArr[0]).intValue();
        String str = (String) objArr[1];
        this.zHV.ji(1958);
        this.zHV.a(new com.tencent.mm.plugin.wallet_ecard.a.e(a.b(this.sZD), null, intValue, str), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e)) {
            return false;
        }
        this.zHV.jj(1958);
        k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.e) kVar;
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{kVar2});
            h.a(this.zHU, b.d(this.zHU, str), "", false, new 2(this));
        } else if (kVar2.sZA.kLO == 0) {
            Bundle bundle = new Bundle();
            x.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[]{kVar2.sZA.vLJ});
            a.e(this.sZD).putString(a.sYZ, kVar2.sZA.vLJ);
            x.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s", new Object[]{kVar2.token, Boolean.valueOf(kVar2.sZA.wCD)});
            if (!bh.ov(kVar2.token)) {
                bundle.putBoolean(a.sZa, kVar2.sZA.wCD);
            }
            this.sZD.a(this.zHU, 0, bundle);
        } else if (!(b.a((WalletBaseUI) this.zHU, kVar2.sZA.vLL) || b.a((WalletBaseUI) this.zHU, kVar2, kVar2.liH, kVar2.liI, kVar2.sZA.kLO, kVar2.sZA.kLP))) {
            h.a(this.zHU, b.d(this.zHU, kVar2.sZA.kLP, kVar2.liI, str), "", false, new 1(this));
        }
        this.zHU.finish();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Bundle bundle = new Bundle();
        bundle.putInt("key_process_result_code", 0);
        this.sZD.b(this.zHU, bundle);
    }
}
