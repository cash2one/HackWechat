package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements e {
    private boolean HF = false;
    private Dialog ilS = null;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] kuV = new int[a.values().length];

        static {
            try {
                kuV[a.vjh.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kuV[a.vjj.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kuV[a.vji.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dk();
        g.Di().gPJ.a(385, this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Dk();
        g.Di().gPJ.b(385, this);
    }

    protected final void a(a aVar, Intent intent) {
        x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + aVar);
        switch (AnonymousClass3.kuV[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                g.Dk();
                g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, 19), 0);
                if (this.ilS != null) {
                    this.ilS.dismiss();
                    this.ilS = null;
                }
                this.ilS = com.tencent.mm.wallet_core.ui.g.e(this, new 1(this));
                return;
            case 2:
            case 3:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + aVar);
                b(1, false, "");
                break;
            default:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + aVar);
                break;
        }
        b(2, true, getString(a$i.uOO));
    }

    private void b(int i, boolean z, String str) {
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[]{Integer.valueOf(i)});
        if (this.ilS != null && this.ilS.isShowing()) {
            this.ilS.dismiss();
            this.ilS = null;
        }
        if (z) {
            h.a(this, str, "", false, new 2(this));
        } else {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.ilS != null && this.ilS.isShowing()) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            return;
        }
        if (this.HF) {
            x.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            return;
        }
        this.HF = true;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
            p.bJN();
            ag bJO = p.bJO();
            if (bJO == null || !bJO.bLM()) {
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                b(5, true, getString(a$i.uRI));
                return;
            } else if (com.tencent.mm.plugin.wallet.b.a.bKF() && q.gFY.gGi == 1) {
                Intent intent = new Intent();
                intent.putExtra("key_is_from_system", true);
                d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                finish();
                return;
            } else {
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                b(6, true, getString(a$i.uRK));
                return;
            }
        }
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        b(3, true, getString(a$i.uOO));
    }
}
