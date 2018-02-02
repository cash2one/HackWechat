package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private k mzO = null;
    Dialog mzP;
    private j mzQ = null;
    private int mzR = -1;
    private Animation mzS;
    private int mzT = 0;
    private boolean mzU = false;
    private int mzV = 0;
    private boolean mzW = false;
    private c mzd = new 1(this);
    View view = null;

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        fingerPrintAuthTransparentUI.mzU = false;
        com.tencent.mm.plugin.fingerprint.a.aJS();
        com.tencent.mm.plugin.fingerprint.a.aJT();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        fingerPrintAuthTransparentUI.mzO.dismiss();
        fingerPrintAuthTransparentUI.mzQ.a((com.tencent.mm.pluginsdk.wallet.a) fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mzR, 2);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.mzT > 1) {
            fingerPrintAuthTransparentUI.mzT = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(f.cRY)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(f.ujZ);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.mzS == null) {
                fingerPrintAuthTransparentUI.mzS = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.mController.xIM, com.tencent.mm.plugin.wxpay.a.a.uan);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.mzS);
            ag.h(new Runnable(fingerPrintAuthTransparentUI) {
                final /* synthetic */ FingerPrintAuthTransparentUI mzX;

                public final void run() {
                    textView.setVisibility(0);
                }
            }, fingerPrintAuthTransparentUI.mzS.getDuration());
        }
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        com.tencent.mm.plugin.soter.c.a.dL(2, fingerPrintAuthTransparentUI.mzV);
        if (z) {
            com.tencent.mm.plugin.soter.c.a.c(10, -1000223, -1, "user permanent cancelled");
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            g.Dk();
            g.Dj().CU().a(w.a.xoL, Boolean.valueOf(true));
        } else {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        com.tencent.mm.plugin.soter.c.a.dL(3, fingerPrintAuthTransparentUI.mzV);
        Bundle af = com.tencent.mm.wallet_core.a.af(fingerPrintAuthTransparentUI);
        String str = "";
        if (af != null) {
            str = af.getString("key_pwd1");
        }
        fingerPrintAuthTransparentUI.mzQ.a((Context) fingerPrintAuthTransparentUI, new 11(fingerPrintAuthTransparentUI), str);
        fingerPrintAuthTransparentUI.dY(true);
        if (fingerPrintAuthTransparentUI.mzO != null && fingerPrintAuthTransparentUI.mzO.isShowing()) {
            fingerPrintAuthTransparentUI.mzO.dismiss();
        }
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(a$g.uBV, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        ViewGroup viewGroup = parent != null ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(f.ukB)).setOnClickListener(new OnClickListener(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI mzX;

            {
                this.mzX = r1;
            }

            public final void onClick(View view) {
                if (this.mzX.mzO != null) {
                    this.mzX.mzO.cancel();
                }
                FingerPrintAuthTransparentUI.aKH();
                this.mzX.finish();
            }
        });
        if (fingerPrintAuthTransparentUI.mzO != null && fingerPrintAuthTransparentUI.mzO.isShowing()) {
            fingerPrintAuthTransparentUI.mzO.dismiss();
            fingerPrintAuthTransparentUI.mzO = null;
        }
        fingerPrintAuthTransparentUI.mzO = new k(fingerPrintAuthTransparentUI, com.tencent.mm.plugin.wxpay.a.j.eYY);
        fingerPrintAuthTransparentUI.mzO.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.mzO.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.mzO.setCancelable(true);
        fingerPrintAuthTransparentUI.mzO.show();
        fingerPrintAuthTransparentUI.mzO.setOnCancelListener(new 13(fingerPrintAuthTransparentUI));
        h.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mzO);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.aKi()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
        } else if (q.Gf()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
        } else if (e.aKu()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
        } else {
            com.tencent.mm.plugin.fingerprint.a.aJS();
            com.tencent.mm.plugin.fingerprint.a.aJT();
            if (com.tencent.mm.plugin.fingerprint.b.c.aKb()) {
                if (com.tencent.mm.compatible.d.q.gFY.gGh != 1) {
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                com.tencent.mm.plugin.wallet_core.model.ag bLq = o.bLq();
                com.tencent.mm.plugin.fingerprint.a.aJS();
                com.tencent.mm.plugin.fingerprint.a.aJT();
                this.mzQ = com.tencent.mm.plugin.fingerprint.b.c.aKc();
                this.mzW = g.Dj().CU().getBoolean(w.a.xoN, false);
                if (!bLq.bLM() || e.aKu()) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + bLq.bLM() + ";isOpenTouch:" + e.aKu());
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    return;
                }
                x.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                com.tencent.d.b.f.f.cGi().cGj();
                com.tencent.mm.plugin.report.service.g.pQN.h(12924, new Object[]{Integer.valueOf(1)});
                com.tencent.mm.plugin.soter.c.a.xZ(0);
                if (g.Dj().CU().getBoolean(w.a.xoK, true)) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    g.Dj().CU().a(w.a.xoK, Boolean.valueOf(false));
                    g.Dj().CU().a(w.a.xoN, Boolean.valueOf(false));
                    h.a(this, this.mzW ? getString(a$i.uJn) : getString(a$i.uJm), "", getString(a$i.uIa), getString(a$i.dEn), false, new 7(this), new 8(this));
                    g.Dj().CU().a(w.a.xoM, Integer.valueOf(1));
                    this.mzV = 1;
                    com.tencent.mm.plugin.soter.c.a.dL(1, this.mzV);
                    return;
                }
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                View inflate = LayoutInflater.from(this).inflate(a$g.uBX, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(f.ukF);
                this.mzV = ((Integer) g.Dj().CU().get(w.a.xoM, null)).intValue() + 1;
                g.Dj().CU().a(w.a.xoM, Integer.valueOf(this.mzV));
                com.tencent.mm.plugin.soter.c.a.dL(1, this.mzV);
                h.a(this, false, null, inflate, getString(a$i.uIa), getString(a$i.dEn), new 9(this), new 10(this, checkBox));
                return;
            }
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mzU) {
            fn(false);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.mController.xIM.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        aKH();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    private void fn(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aJS();
        com.tencent.mm.plugin.fingerprint.a.aJT();
        com.tencent.mm.plugin.fingerprint.b.c.abort();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        if (!com.tencent.mm.plugin.fingerprint.b.c.aKb()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        } else if (com.tencent.mm.plugin.fingerprint.b.c.a(this.mzd, z) != 0) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
        }
    }

    private static void aKH() {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aJS();
        if (com.tencent.mm.plugin.fingerprint.a.aJT() != null) {
            com.tencent.mm.plugin.fingerprint.b.c.aKa();
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        return this.mzQ.d(i, i2, str, kVar);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void finish() {
        if (this.mzQ != null) {
            this.mzQ.clear();
        }
        super.finish();
    }

    private void af(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        h.a(this, string, "", getString(a$i.uRP), false, new 3(this));
    }

    protected final void dY(boolean z) {
        if (z) {
            this.mzP = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else if (this.mzP != null && this.mzP.isShowing()) {
            this.mzP.dismiss();
            this.mzP = null;
        }
    }

    public void onDestroy() {
        if (this.mzO != null && this.mzO.isShowing()) {
            this.mzO.dismiss();
            this.mzO = null;
        }
        if (this.mzS != null) {
            this.mzS.cancel();
        }
        dY(false);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void ac(int i, String str) {
        dY(false);
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            b(new com.tencent.mm.plugin.wallet_core.c.x(null, 19), false);
            h.a(this.mController.xIM, false, null, LayoutInflater.from(this).inflate(a$g.uBU, null), getString(a$i.uRP), "", new 2(this), null);
        } else if (i == -2) {
            String string;
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            int i2 = a$i.uJi;
            if (TextUtils.isEmpty(str)) {
                string = getString(i2);
            } else {
                string = str;
            }
            h.a(this, string, "", getString(a$i.uJk), getString(a$i.dEn), false, new 4(this), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI mzX;

                {
                    this.mzX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mzX.finish();
                }
            });
        } else {
            af(-1, str);
        }
    }
}
