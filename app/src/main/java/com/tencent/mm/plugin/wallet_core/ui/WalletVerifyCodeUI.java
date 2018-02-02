package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private com.tencent.mm.plugin.af.a jgC = null;
    private Orders pPl;
    private Button sCT;
    private Authen sCY;
    private PayInfo sEO;
    public int sWG = 60000;
    public WalletFormView sWH = null;
    private Button sWI;
    private String sWJ;
    private String sWK;
    private boolean sWL = false;
    private a sWM = null;
    private TextView sWN;
    private boolean sWO = false;
    private h sWP = new h();
    private com.tencent.mm.wallet_core.c.f.a sWQ = new 2(this);

    class a extends CountDownTimer {
        final /* synthetic */ WalletVerifyCodeUI sWR;

        public a(WalletVerifyCodeUI walletVerifyCodeUI, long j) {
            this.sWR = walletVerifyCodeUI;
            super(j, 1000);
        }

        public final void onTick(long j) {
            this.sWR.sWI.setText(this.sWR.getString(i.uXn) + "(" + (j / 1000) + ")");
        }

        public final void onFinish() {
            this.sWR.sWI.setClickable(true);
            this.sWR.sWI.setEnabled(true);
            this.sWR.sWI.setText(this.sWR.getString(i.uXn));
        }
    }

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, com.tencent.mm.wallet_core.c.f.a aVar) {
        if (walletVerifyCodeUI.sWO) {
            x.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            return false;
        } else if (walletVerifyCodeUI.sWP.bLa()) {
            x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (bh.ov(walletVerifyCodeUI.sWH.getText())) {
                x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            g.pQN.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.l(new f(walletVerifyCodeUI.sWH.getText(), walletVerifyCodeUI.bJQ(), aVar, true));
            return true;
        } else if (walletVerifyCodeUI.sWP.bKZ()) {
            x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            g.pQN.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.l(new f(walletVerifyCodeUI.sWH.getText(), walletVerifyCodeUI.bJQ(), aVar, false));
            return true;
        } else {
            x.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void c(WalletVerifyCodeUI walletVerifyCodeUI) {
        if (walletVerifyCodeUI.sWK == null) {
            walletVerifyCodeUI.sWK = "";
        }
        CharSequence format = String.format(q.Gf() ? walletVerifyCodeUI.getString(i.uXh) : walletVerifyCodeUI.getString(i.uXg), new Object[]{walletVerifyCodeUI.sWK});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.mController.xIM.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(com.tencent.mm.plugin.wxpay.a.g.uCa, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(d.bvv);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setText(format);
        com.tencent.mm.ui.base.h.a(walletVerifyCodeUI.mController.xIM, walletVerifyCodeUI.getString(i.uXi), walletVerifyCodeUI.getString(i.uRP), textView, new 4(walletVerifyCodeUI));
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        super.onCreate(bundle);
        setMMTitle(i.uXo);
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        this.sWK = this.vf.getString("key_bank_phone");
        this.jgC = new com.tencent.mm.plugin.af.a(this);
        this.jgC.qyb = getResources().getStringArray(b.uav);
        this.jgC.qxZ = new com.tencent.mm.plugin.af.a.a(this) {
            final /* synthetic */ WalletVerifyCodeUI sWR;

            {
                this.sWR = r1;
            }

            public final void si(String str) {
                this.sWR.sWH.setText(str);
            }
        };
        this.jgC.start();
        this.sWP = new h(this.vf);
        this.sWL = false;
        bMT();
        initView();
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        int i2 = (this.sEO == null || this.sEO.fCV == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.sWL) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(10706, objArr);
        c.bNg();
        c.b(this, this.vf, 4);
        if (this.sWP.bKY()) {
            g.pQN.h(13731, new Object[]{Integer.valueOf(5)});
            if (!bh.ov(this.sWP.sMd.title)) {
                setMMTitle(this.sWP.sMd.title);
            }
            findViewById(com.tencent.mm.plugin.wxpay.a.f.uhx).setVisibility(8);
            ((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhy)).setText(this.sWP.sMd.zHh);
            if (this.sWN != null) {
                String bMS = bMS();
                this.sWN.setText(bh.j(this.sWP.sMd.zHi, new Object[]{bMS}));
                this.sWN.setGravity(1);
            }
            if (!(this.sCT == null || bh.ov(this.sWP.sMd.zHj))) {
                this.sCT.setText(this.sWP.sMd.zHj);
            }
        } else {
            findViewById(com.tencent.mm.plugin.wxpay.a.f.uhx).setVisibility(8);
        }
        this.zIY.ji(1580);
    }

    private String bMS() {
        String az = bh.az(this.vf.getString("key_mobile"), "");
        if (bh.ov(az)) {
            Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
            if (bankcard != null) {
                return bankcard.field_mobile;
            }
        }
        return az;
    }

    public void bMT() {
    }

    public void bMU() {
        int i = 2;
        x.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        int i2 = (this.sEO == null || this.sEO.fCV == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.sWL) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(10706, objArr);
        this.sWL = true;
        this.sWI.setClickable(false);
        this.sWI.setEnabled(false);
        if (this.sWM != null) {
            this.sWM.cancel();
            this.sWM = null;
        }
        a aVar = new a(this, (long) this.sWG);
        this.sWM = aVar;
        aVar.start();
        if (this.jgC != null) {
            this.jgC.start();
        }
        if (!cCd().q(this.sWJ) && !nJ(false)) {
            this.sCY = (Authen) this.vf.getParcelable("key_authen");
            if (this.sCY == null) {
                x.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
            } else {
                c.bNg();
            }
        }
    }

    protected final void initView() {
        String str;
        CharSequence um;
        a aVar;
        TextView textView;
        final Bankcard bankcard;
        boolean z;
        boolean z2;
        PayInfo payInfo;
        int i;
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        this.sWN = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ufM);
        String bMS = bMS();
        if (bh.ov(bMS)) {
            Bankcard bankcard2 = (Bankcard) this.vf.getParcelable("key_bankcard");
            if (bankcard2 != null) {
                str = bankcard2.field_mobile;
                this.vf.putString("key_mobile", str);
                um = um(0);
                if (bh.M(um)) {
                    this.sWN.setText(um);
                    this.sWN.setGravity(3);
                } else {
                    TextView textView2 = this.sWN;
                    if (q.Gf()) {
                        bMS = getString(i.uXc);
                    } else {
                        bMS = getString(i.uXd);
                    }
                    textView2.setText(String.format(bMS, new Object[]{str}));
                    this.sWN.setGravity(3);
                }
                this.sWH = (WalletFormView) findViewById(com.tencent.mm.plugin.wxpay.a.f.bNA);
                this.sWH.zJH = this;
                this.sWI = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.ukN);
                this.sWI.setOnClickListener(new 5(this));
                this.sWI.setClickable(false);
                this.sWI.setEnabled(false);
                if (this.sWM != null) {
                    this.sWM.cancel();
                    this.sWM = null;
                }
                aVar = new a(this, (long) this.sWG);
                this.sWM = aVar;
                aVar.start();
                this.sCT = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.bNx);
                this.sCT.setOnClickListener(new 6(this));
                textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ufL);
                bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
                z = this.vf.getBoolean("key_is_changing_balance_phone_num");
                z2 = this.vf.getBoolean("key_need_show_switch_phone", false);
                if (z || z2) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
                if (payInfo == null) {
                    i = payInfo.fCV;
                } else {
                    i = 0;
                }
                if (z2) {
                    textView.setText(i.uXi);
                    textView.setOnClickListener(new 7(this, bankcard));
                } else if (ag != null || !ag.cBl() || r2 == 11 || r2 == 21) {
                    textView.setText(q.Gf() ? getString(i.uXf) : getString(i.uXe));
                    textView.setOnClickListener(new 10(this));
                } else if (bankcard.bKP() || bankcard.bKQ()) {
                    textView.setText(this.vf.getString("key_verify_tail_wording", getString(i.uXi)));
                    textView.setOnClickListener(new 9(this, bankcard));
                } else {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI sWR;

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.h.a(this.sWR, this.sWR.getString(i.uUY, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", this.sWR.getString(i.uUX), this.sWR.getString(i.dEn), new 1(this), null);
                        }
                    });
                }
                this.sWH.requestFocus();
                addIconOptionMenu(0, a$e.udW, new 11(this));
                setBackBtn(new 12(this));
            }
        }
        str = bMS;
        um = um(0);
        if (bh.M(um)) {
            TextView textView22 = this.sWN;
            if (q.Gf()) {
                bMS = getString(i.uXc);
            } else {
                bMS = getString(i.uXd);
            }
            textView22.setText(String.format(bMS, new Object[]{str}));
            this.sWN.setGravity(3);
        } else {
            this.sWN.setText(um);
            this.sWN.setGravity(3);
        }
        this.sWH = (WalletFormView) findViewById(com.tencent.mm.plugin.wxpay.a.f.bNA);
        this.sWH.zJH = this;
        this.sWI = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.ukN);
        this.sWI.setOnClickListener(new 5(this));
        this.sWI.setClickable(false);
        this.sWI.setEnabled(false);
        if (this.sWM != null) {
            this.sWM.cancel();
            this.sWM = null;
        }
        aVar = new a(this, (long) this.sWG);
        this.sWM = aVar;
        aVar.start();
        this.sCT = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.bNx);
        this.sCT.setOnClickListener(new 6(this));
        textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ufL);
        bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        z = this.vf.getBoolean("key_is_changing_balance_phone_num");
        z2 = this.vf.getBoolean("key_need_show_switch_phone", false);
        if (z) {
        }
        textView.setVisibility(0);
        payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo == null) {
            i = 0;
        } else {
            i = payInfo.fCV;
        }
        if (z2) {
            textView.setText(i.uXi);
            textView.setOnClickListener(new 7(this, bankcard));
        } else {
            if (ag != null) {
            }
            if (q.Gf()) {
            }
            textView.setText(q.Gf() ? getString(i.uXf) : getString(i.uXe));
            textView.setOnClickListener(new 10(this));
        }
        this.sWH.requestFocus();
        addIconOptionMenu(0, a$e.udW, new 11(this));
        setBackBtn(new 12(this));
    }

    public void bMV() {
        Bundle bundle = this.vf;
        String string = this.vf.getString("key_pwd1");
        this.sWJ = this.sWH.getText();
        p pVar = new p();
        pVar.sPj = string;
        pVar.pCn = this.sEO;
        pVar.sPk = this.sWJ;
        pVar.token = bh.az(this.vf.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            pVar.oZz = bankcard.field_bankcardType;
            pVar.oZA = bankcard.field_bindSerial;
            pVar.sKA = bh.az(bankcard.field_arrive_type, "");
        } else {
            pVar.oZz = this.vf.getString("key_bank_type");
            if (bh.ov(pVar.oZz)) {
                pVar.oZz = this.vf.getString("key_bind_card_type", "");
            }
        }
        x.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + pVar.pCn + " mVerifyCode: " + this.sWJ);
        bundle.putString("key_verify_code", this.sWJ);
        com.tencent.mm.wallet_core.a.ag(this);
        x.i("MicroMsg.WalletVertifyCodeUI", "do verify result : " + cCd().k(this.sWJ, pVar));
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (!(kVar instanceof f)) {
            if (i == 0 && i2 == 0) {
                boolean z;
                com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
                if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                    this.vf.putBoolean("intent_bind_end", true);
                    com.tencent.mm.ui.base.h.bu(this, getString(i.uPE));
                    x.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                    z = true;
                } else {
                    if (!(kVar instanceof m)) {
                        if (ag.c(this, null)) {
                            r(new com.tencent.mm.plugin.wallet_core.c.x(bJQ(), 13));
                            x.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.q) {
                    g.pQN.h(10707, new Object[]{Integer.valueOf(2), Integer.valueOf(c.bNh())});
                }
                if (this.sCY != null && (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.i)) {
                    String bhV = ((com.tencent.mm.wallet_core.tenpay.model.i) kVar).bhV();
                    if (!bh.ov(bhV)) {
                        this.vf.putString("kreq_token", bhV);
                    }
                }
                if (z) {
                    x.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                    com.tencent.mm.wallet_core.a.j(this, this.vf);
                    finish();
                    return true;
                }
            }
            return false;
        } else if (i2 == 0 || !((f) kVar).fHt) {
            return true;
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.xIM, str, null, false, new 3(this));
            return true;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFY;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.jgC != null) {
            this.jgC.stop();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void hx(boolean z) {
        if (this.sWH.dQ(null)) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
            return;
        }
        this.sCT.setEnabled(false);
        this.sCT.setClickable(false);
    }

    public void onDestroy() {
        if (this.jgC != null) {
            this.jgC.stop();
        }
        this.zIY.jj(1580);
        super.onDestroy();
    }

    public boolean bKa() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_need_confirm_finish", false);
        if ((this.sEO == null || !this.sEO.ncX) && !booleanExtra) {
            return super.bKa();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.WalletVertifyCodeUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.jgC != null) {
                    this.jgC.start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean j(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), kVar});
        if ((kVar instanceof f) && i2 == 0) {
            this.sWO = true;
            u.makeText(this, i.uUe, 0).show();
            x.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
