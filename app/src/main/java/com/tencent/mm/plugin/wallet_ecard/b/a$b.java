package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$b extends e {
    final /* synthetic */ a sZD;

    public a$b(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        String str = (String) objArr[0];
        int i = a.a(this.sZD).getInt(a.sYX);
        this.zHV.ji(1958);
        this.zHV.a(new com.tencent.mm.plugin.wallet_ecard.a.e(a.b(this.sZD), str, i, null), true);
        a.c(this.sZD).putString("key_pwd1", str);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e)) {
            return false;
        }
        this.zHV.jj(1958);
        com.tencent.mm.plugin.wallet_ecard.a.e eVar = (com.tencent.mm.plugin.wallet_ecard.a.e) kVar;
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{eVar});
            h.a(this.zHU, b.d(this.zHU, new String[]{str}), "", false, new 2(this));
        } else if (eVar.sZA.kLO == 0) {
            Bundle bundle = new Bundle();
            x.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[]{eVar.sZA.vLJ});
            a.d(this.sZD).putString(a.sYZ, eVar.sZA.vLJ);
            this.sZD.a(this.zHU, 0, bundle);
        } else if (!(b.a((WalletBaseUI) this.zHU, eVar.sZA.vLL) || b.a((WalletBaseUI) this.zHU, eVar, eVar.liH, eVar.liI, eVar.sZA.kLO, eVar.sZA.kLP))) {
            h.a(this.zHU, b.d(this.zHU, new String[]{eVar.sZA.kLP, eVar.liI, str}), "", false, new OnClickListener(this) {
                final /* synthetic */ a$b sZE;

                {
                    this.sZE = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sZE.sZD.b(this.sZE.zHU, null);
                }
            });
        }
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
