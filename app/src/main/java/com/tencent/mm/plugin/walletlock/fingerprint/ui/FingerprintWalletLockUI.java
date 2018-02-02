package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.b.f.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;

public class FingerprintWalletLockUI extends MMActivity {
    private String hzj;
    private TextView kmC;
    private String mzL = null;
    private int mzT = 0;
    private i nAo = null;
    private ProgressDialog nAp = null;
    private boolean ozR = true;
    private boolean pou = false;
    private TextView tfD;
    private TextView tfE;
    private Animation tfF;
    private String tfG;
    private String tfH;
    private d tfI;
    private h tfJ;
    private b tfK;
    private String tfL = "-1";
    private int tfM = -1;
    private int tfN = -1;
    private boolean tfx = false;
    private String vz;

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tfN, 2, 1);
        fingerprintWalletLockUI.sh(str);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        a.bNE();
        fingerprintWalletLockUI.dismissDialog();
        if (i == 3) {
            com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tfN, 2, 2);
            a.G(System.currentTimeMillis(), 0);
            fingerprintWalletLockUI.tfD.setText(g.teY);
            fingerprintWalletLockUI.tfD.setTextColor(fingerprintWalletLockUI.getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btB));
        } else if (i == 8) {
            fingerprintWalletLockUI.bNH();
        } else {
            fingerprintWalletLockUI.sh(str);
        }
    }

    static /* synthetic */ void d(FingerprintWalletLockUI fingerprintWalletLockUI) {
        com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tfN, 2, 0);
        com.tencent.d.a.c.i iVar = com.tencent.mm.plugin.walletlock.b.g.tho.thq;
        if (iVar != null) {
            fingerprintWalletLockUI.tfL = iVar.Act;
            x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", new Object[]{fingerprintWalletLockUI.tfL});
            if (fingerprintWalletLockUI.tfH.equals("action.switch_on_pattern")) {
                fingerprintWalletLockUI.tfH = fingerprintWalletLockUI.tfG;
                fingerprintWalletLockUI.bNI();
            } else if (!fingerprintWalletLockUI.tfH.equals("action.verify_pattern")) {
            } else {
                if (a.NE(fingerprintWalletLockUI.tfL)) {
                    fingerprintWalletLockUI.tfH = fingerprintWalletLockUI.tfG;
                    fingerprintWalletLockUI.bNI();
                    return;
                }
                fingerprintWalletLockUI.zv(2);
            }
        }
    }

    static /* synthetic */ void g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        Intent intent = new Intent();
        intent.putExtra("key_wallet_lock_setting_scene", 1);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).b((Activity) fingerprintWalletLockUI, intent, 3);
    }

    static /* synthetic */ void i(FingerprintWalletLockUI fingerprintWalletLockUI) {
        fingerprintWalletLockUI.dismissDialog();
        ag.y(new Runnable(fingerprintWalletLockUI) {
            final /* synthetic */ FingerprintWalletLockUI tfO;

            {
                this.tfO = r1;
            }

            public final void run() {
                a.bNB();
                a.ND(this.tfO.tfL);
                a.fh(-1);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tho;
                com.tencent.mm.plugin.walletlock.b.g.jX(true);
            }
        });
        Toast.makeText(fingerprintWalletLockUI, g.teV, 0).show();
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zu(2);
        com.tencent.mm.plugin.walletlock.b.i.ths.bOp();
        fingerprintWalletLockUI.q(-1, 0, "open fingerprint lock ok");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.vz = intent.getStringExtra("action");
        this.tfH = this.vz;
        this.tfG = intent.getStringExtra("next_action");
        this.hzj = intent.getStringExtra("token");
        this.mzL = intent.getStringExtra("key_pay_passwd");
        this.tfN = intent.getIntExtra("scene", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[]{this.vz, this.tfG});
        if (this.vz.equals("action.verify_pattern")) {
            this.tfM = 2;
            com.tencent.mm.plugin.walletlock.b.h.bOm();
        } else if (this.vz.equals("action.switch_on_pattern")) {
            this.tfM = 1;
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[]{Boolean.valueOf(this.ozR)});
        if (this.ozR) {
            this.tfI = new c();
            this.tfJ = new h();
            this.pou = false;
            f.cGi().cGj();
            this.nAp = com.tencent.mm.ui.base.h.a(this, getString(g.dHc), false, null);
            bNG();
            if (this.vz.equals("action.switch_on_pattern")) {
                this.tfx = false;
            } else {
                this.tfx = true;
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.tfx)});
            com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tho;
            boolean bOi = com.tencent.mm.plugin.walletlock.b.g.bOi();
            com.tencent.mm.plugin.walletlock.b.g gVar2 = com.tencent.mm.plugin.walletlock.b.g.tho;
            if (com.tencent.mm.plugin.walletlock.b.g.bNC() && !bOi) {
                x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[]{Boolean.valueOf(bOi)});
                if (e.bNN()) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zu(1);
                    gVar = com.tencent.mm.plugin.walletlock.b.g.tho;
                    com.tencent.mm.plugin.walletlock.b.g.jX(true);
                    finish();
                    Intent intent = new Intent(this, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                    intent.setPackage(ac.getPackageName());
                    if (!com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.xwH, false)) {
                        intent.putExtra("verify_title", getString(g.tfl));
                        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwH, Boolean.valueOf(true));
                        com.tencent.mm.kernel.g.Dj().CU().lH(true);
                    }
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[]{Boolean.valueOf(r1)});
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                } else {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                    bJB();
                    this.nAo = new i.a(this).EA(g.tfh).EC(g.tfk).a(new 13(this)).d(new 12(this)).akx();
                    this.nAo.setCanceledOnTouchOutside(false);
                    this.nAo.b(getString(g.teQ), false, new 14(this));
                    this.nAo.show();
                }
            } else if (com.tencent.d.a.a.id(this)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_pay_passwd", this.mzL);
                bundle.putBoolean("key_fp_lock_offline_mode", this.tfx);
                this.tfI.a(new 8(this), bundle);
            } else {
                bNH();
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.ozR = true;
    }

    protected final void initView() {
        super.initView();
        this.tfD = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.teh);
        this.tfE = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.tek);
        this.kmC = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.teg);
        this.tfE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FingerprintWalletLockUI tfO;

            {
                this.tfO = r1;
            }

            public final void onClick(View view) {
                this.tfO.zv(1);
            }
        });
        this.kmC.setOnClickListener(new 7(this));
    }

    private void bNG() {
        if (this.vz.equals("action.verify_pattern")) {
            this.tfD.setText(g.tfb);
            this.tfD.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btv));
            this.tfE.setVisibility(0);
            return;
        }
        this.tfD.setText(g.teW);
        this.tfD.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btv));
        this.tfE.setVisibility(8);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.walletlock.a.e.tem;
    }

    private void bNH() {
        bJB();
        i.a aVar = new i.a(this);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[]{Integer.valueOf(this.tfM)});
        if (this.tfM == 2) {
            aVar.EA(g.tfg).EC(g.tfj).a(new 10(this)).ED(g.dEn).b(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerprintWalletLockUI tfO;

                {
                    this.tfO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
                }
            });
        } else {
            aVar.EA(g.tff).YI(getString(g.dFU)).a(new 11(this));
        }
        this.nAo = aVar.akx();
        this.nAo.setCanceledOnTouchOutside(false);
        this.nAo.show();
    }

    private void dismissDialog() {
        bJB();
        if (this.nAo != null && this.nAo.isShowing()) {
            this.nAo.dismiss();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        com.tencent.mm.plugin.walletlock.b.i.ths.bOq();
    }

    private void bNI() {
        x.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[]{this.tfH});
        if (bh.ov(this.tfH)) {
            finish();
            return;
        }
        String str = this.tfH;
        boolean z = true;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    z = true;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    z = true;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    z = true;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                this.tfK = new a(this, this);
                this.tfL = "-1";
                if (this.tfJ == null) {
                    this.tfJ = new h();
                }
                h hVar = this.tfJ;
                b bVar = this.tfK;
                com.tencent.d.b.c.b 1 = new 1(hVar, bVar);
                hVar.mzB = new com.tencent.d.b.c.a();
                com.tencent.d.b.f.b bVar2 = new com.tencent.d.b.f.b.a().io(this).a(hVar.mzB).abA(com.tencent.mm.plugin.walletlock.b.g.tho.thp).Ib(3).a(1).AcZ;
                com.tencent.mm.plugin.walletlock.b.g.tho.thq = null;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
                com.tencent.d.b.a.a(new 2(hVar, bVar), bVar2);
                return;
            case true:
                com.tencent.d.a.c.i iVar = com.tencent.mm.plugin.walletlock.b.g.tho.thq;
                if (iVar == null) {
                    sh(getString(g.teX));
                    return;
                }
                String str2 = iVar.AcA;
                String str3 = iVar.signature;
                if (this.tfI != null) {
                    this.nAp = com.tencent.mm.ui.base.h.a(this, getString(g.tfc), false, null);
                    this.tfI.a(new 5(this), this.hzj, str2, str3);
                    return;
                }
                return;
            case true:
                a.fh(SystemClock.elapsedRealtime());
                bNJ();
                return;
            default:
                return;
        }
    }

    private void bNJ() {
        this.ozR = false;
        ag.h(new 2(this), 200);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
            com.tencent.mm.plugin.walletlock.b.i.ths.kb(true);
            com.tencent.mm.plugin.walletlock.b.i.ths.kc(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
            overridePendingTransition(com.tencent.mm.plugin.walletlock.a.a.bqz, com.tencent.mm.plugin.walletlock.a.a.bqC);
            return;
        }
        x.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    }

    private void zv(int i) {
        Intent intent = new Intent();
        if (i == 1) {
            intent.putExtra("action", "action.touchlock_verify_by_paypwd");
        } else if (i == 2) {
            intent.putExtra("action", "action.touchlock_need_verify_paypwd");
            intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(g.tfe));
        }
        intent.putExtra("key_wallet_lock_type", 2);
        com.tencent.mm.bm.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
    }

    private void bJB() {
        if (this.nAp != null && this.nAp.isShowing()) {
            this.nAp.dismiss();
        }
    }

    private void yE(String str) {
        if (bh.ov(str)) {
            str = getString(g.tfa);
        }
        dismissDialog();
        this.nAo = com.tencent.mm.ui.base.h.a(this, str, "", new 3(this));
        this.nAo.setCanceledOnTouchOutside(false);
    }

    private void sh(String str) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - this.mzT > 1) {
            this.mzT = currentTimeMillis;
            dismissDialog();
            if (this.tfD != null) {
                this.tfD.setText(str);
                this.tfD.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btB));
                this.tfD.setVisibility(4);
                if (this.tfF == null) {
                    this.tfF = AnimationUtils.loadAnimation(this.mController.xIM, com.tencent.mm.plugin.walletlock.a.a.tdX);
                }
                this.tfD.startAnimation(this.tfF);
                ag.h(new 4(this), this.tfF.getDuration());
            }
        }
    }

    private void release() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[]{Boolean.valueOf(this.pou)});
        if (!this.pou) {
            this.pou = true;
            if (this.tfJ != null) {
                h hVar = this.tfJ;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
                if (hVar.mzB != null) {
                    hVar.mzB.nV(true);
                }
            }
            if (this.tfI != null) {
                this.tfI.release();
            }
            f.cGi().cGj();
        }
    }

    private void q(int i, int i2, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(-1), Integer.valueOf(i2), str});
        release();
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        release();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null) {
            x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[]{Integer.valueOf(intExtra)});
        if (i == 1) {
            if (intExtra == 0) {
                bNJ();
                com.tencent.mm.plugin.walletlock.b.h.bOk();
            } else if (intExtra == -1) {
                this.ozR = false;
                yE(getString(g.tfm));
            }
        } else if (i == 2) {
            if (intExtra == 0) {
                a.ND(this.tfL);
                a.fh(SystemClock.elapsedRealtime());
                bNJ();
            } else if (intExtra == -1) {
                this.ozR = false;
                yE(getString(g.tfm));
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                bNJ();
                return;
            }
            finish();
            com.tencent.mm.plugin.walletlock.b.i.ths.bOq();
        } else if (i == 4) {
            if (intExtra == 0) {
                bNJ();
            } else if (intExtra == -1) {
                this.ozR = false;
                yE(getString(g.tfd));
            } else {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.ths.bOq();
            }
        } else if (i != 5) {
        } else {
            if (intExtra == 0) {
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zu(0);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tho;
                com.tencent.mm.plugin.walletlock.b.g.bNE();
                Toast.makeText(this, getString(g.teR), 0).show();
                bNJ();
            } else if (intExtra == -1) {
                this.ozR = false;
                yE(getString(g.teS));
            } else if (intExtra == 4) {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.ths.bOq();
            }
        }
    }
}
