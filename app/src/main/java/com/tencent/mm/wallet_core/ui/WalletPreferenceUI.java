package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements d {
    public c zIX = null;
    public g zIY = null;
    public e zIZ = null;

    public abstract boolean g(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zIY = new g(this, this);
        this.zIY.ji(385);
        this.zIY.ji(1518);
        if (getLayoutId() > 0) {
            e.cCf();
        }
    }

    public final g cCh() {
        if (this.zIY == null) {
            this.zIY = new g(this, this);
        }
        return this.zIY;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!g(i, i2, str, kVar) && i2 != 0) {
            if (bh.ov(str)) {
                str = getString(i.uRf);
            }
            h.a((Context) this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletPreferenceUI zJp;

                {
                    this.zJp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zJp.finish();
                }
            });
        }
    }

    public void onDestroy() {
        this.zIY.jj(385);
        this.zIY.jj(1518);
        this.zIY = null;
        super.onDestroy();
    }
}
