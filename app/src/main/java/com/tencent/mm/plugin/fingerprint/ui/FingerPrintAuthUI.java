package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.b.f.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wxpay.a$a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintAuthUI extends WalletBaseUI implements a {
    private boolean isPaused = false;
    private c mAa;
    private a mAb;
    private boolean mAc = false;
    private final int mAd = 1;
    private Dialog mzP = null;
    private j mzQ = null;
    private Animation mzS;
    private int mzT = 0;
    private TextView mzZ;

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.mzT > 1) {
            fingerPrintAuthUI.mzT = currentTimeMillis;
            fingerPrintAuthUI.mzZ.setText(i.uJf);
            fingerPrintAuthUI.mzZ.setTextColor(fingerPrintAuthUI.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
            fingerPrintAuthUI.mzZ.setVisibility(4);
            if (fingerPrintAuthUI.mzS == null) {
                fingerPrintAuthUI.mzS = AnimationUtils.loadAnimation(fingerPrintAuthUI.mController.xIM, a$a.uan);
            }
            fingerPrintAuthUI.mzZ.startAnimation(fingerPrintAuthUI.mzS);
            ag.h(new 3(fingerPrintAuthUI), fingerPrintAuthUI.mzS.getDuration());
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, int i) {
        fingerPrintAuthUI.mAc = false;
        c.abort();
        c.release();
        fingerPrintAuthUI.mzQ.a(fingerPrintAuthUI, String.valueOf(i), 1);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!fingerPrintAuthUI.isPaused);
        x.i(str, str2, objArr);
        return !fingerPrintAuthUI.isPaused;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(i.uMe));
        this.mzZ = (TextView) findViewById(a$f.ulb);
        com.tencent.mm.plugin.fingerprint.a.aJS();
        this.mAa = com.tencent.mm.plugin.fingerprint.a.aJT();
        this.mzQ = c.aKc();
        Bundle af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null) {
            Object string = af.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                x.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                bl(getString(i.uJi), -1);
                com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "get user pwd error");
                return;
            } else if (e.aKi()) {
                dY(true);
                f.cGi().cGj();
                this.mzQ.a(this, new 1(this), string);
                return;
            } else {
                x.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                return;
            }
        }
        x.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        bl(getString(i.uJi), -1);
        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
    }

    protected final void dY(boolean z) {
        ag.y(new 2(this, z));
    }

    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (this.mAc) {
            fn(false);
        }
    }

    private void fn(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aJS();
        com.tencent.mm.plugin.fingerprint.a.aJT();
        c.abort();
        c.release();
        if (c.aKb()) {
            if (this.mAb == null) {
                this.mAb = new a(this, this);
            }
            if (c.a(this.mAb, z) != 0) {
                x.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
                return;
            }
            return;
        }
        x.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }

    public void onPause() {
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.mController.xIM.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        x.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aJS();
        if (com.tencent.mm.plugin.fingerprint.a.aJT() != null) {
            c.aKa();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.mzS != null) {
            this.mzS.cancel();
        }
        this.mAb = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (this.mzQ.d(i, i2, str, kVar)) {
            return true;
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            return false;
        }
        dY(false);
        com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
        Toast.makeText(this, i.uJj, 0).show();
        return true;
    }

    private void bl(String str, int i) {
        ag.y(new 4(this, str, i));
    }

    protected final int getLayoutId() {
        return g.uBW;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void ac(int i, String str) {
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            b(new com.tencent.mm.plugin.wallet_core.c.x(null, 19), false);
            return;
        }
        dY(false);
        x.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        h.a(this, getString(i.uJi), "", new 5(this));
    }
}
