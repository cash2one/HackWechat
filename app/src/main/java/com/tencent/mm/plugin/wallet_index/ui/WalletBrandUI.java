package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.z.q;

@a(7)
public class WalletBrandUI extends MMActivity implements e {
    private String appId;
    private String fCU;
    private Dialog ilS = null;
    private int pak;
    private boolean taX = false;
    private b taY;
    private c taZ = new 2(this);
    private c tba = new 3(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        this.pak = getIntent().getIntExtra("pay_scene", 3);
        p.cBw();
        x.i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        x.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is " + intExtra);
        if (q.Gf()) {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.taY = new c(this);
        } else if (intExtra == 2) {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.taY = new a(this);
        } else if (intExtra == 3) {
            x.i("MicroMsg.WalletBrandUI", "do pay with mall");
            this.taY = new e(this);
        } else {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.taY = new d(this);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.taZ);
        com.tencent.mm.sdk.b.a.xef.b(this.tba);
        g.Dk();
        g.Di().gPJ.a(this.taY.bNo(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        g.Dk();
        g.Di().gPJ.b(this.taY.bNo(), this);
        com.tencent.mm.sdk.b.a.xef.c(this.taZ);
        com.tencent.mm.sdk.b.a.xef.c(this.tba);
    }

    public void onResume() {
        x.d("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        x.i("MicroMsg.WalletBrandUI", "Handler jump");
        if (!this.taX) {
            this.taX = true;
            k bNp = this.taY.bNp();
            if (this.ilS != null) {
                this.ilS.dismiss();
                this.ilS = null;
            }
            this.ilS = com.tencent.mm.wallet_core.ui.g.e(this, new 1(this, bNp));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() == this.taY.bNo()) {
            this.taY.a(i, i2, str, kVar);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    x.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
