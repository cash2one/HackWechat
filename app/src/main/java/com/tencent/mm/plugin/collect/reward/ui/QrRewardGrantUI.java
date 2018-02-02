package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI extends QrRewardBaseUI {
    private int fCR;
    private String fuH;
    private String jeE;
    private String lie;
    private ImageView ljG;
    private TextView ljH;
    private TextView ljI;
    private WalletTextView ljJ;
    private LinearLayout ljK;
    private WalletFormView ljL;
    private MMEditText ljM;
    private Button ljN;
    private int ljO;
    private int ljP;
    private String ljQ;
    private String ljR;
    private String ljS;
    private String ljT;
    private String ljU;
    private String ljV;
    private String ljW;
    private String ljX;
    private String ljY;
    private int ljZ;
    private c<fk> lka = new 6(this);

    static /* synthetic */ boolean a(QrRewardGrantUI qrRewardGrantUI, int i) {
        boolean z;
        boolean z2;
        if (qrRewardGrantUI.ljP == 1) {
            z = false;
            z2 = true;
        } else if (((double) i) <= 0.0d) {
            z = true;
            z2 = false;
        } else if (i <= qrRewardGrantUI.ljZ) {
            qrRewardGrantUI.ljL.HH(a.c.black);
            z = false;
            z2 = true;
        } else {
            qrRewardGrantUI.ljL.HH(a.c.uay);
            z = false;
            z2 = false;
        }
        if (z2) {
            if (qrRewardGrantUI.ljI.isShown()) {
                qrRewardGrantUI.ljI.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, a.a.uap));
                qrRewardGrantUI.ljI.setVisibility(8);
            }
            qrRewardGrantUI.ljN.setEnabled(true);
        } else {
            if (!(z || qrRewardGrantUI.ljI.isShown())) {
                qrRewardGrantUI.ljI.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, a.a.uao));
                qrRewardGrantUI.ljI.setVisibility(0);
            }
            qrRewardGrantUI.ljN.setEnabled(false);
        }
        return z2;
    }

    static /* synthetic */ void b(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s", new Object[]{Integer.valueOf(qrRewardGrantUI.ljO), Integer.valueOf(qrRewardGrantUI.ljP), qrRewardGrantUI.ljM.getText().toString().replace("\n", "")});
        k eVar = new e(qrRewardGrantUI.ljO, qrRewardGrantUI.ljP, qrRewardGrantUI.ljU, qrRewardGrantUI.ljQ, r5, qrRewardGrantUI.fCR, qrRewardGrantUI.ljW, qrRewardGrantUI.ljS, qrRewardGrantUI.jeE, qrRewardGrantUI.ljX, qrRewardGrantUI.ljY);
        eVar.m(qrRewardGrantUI);
        qrRewardGrantUI.l(eVar);
    }

    static /* synthetic */ void c(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = qrRewardGrantUI.fuH;
        payInfo.fCV = 48;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.ljU);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.ljV);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.ljQ);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.ljM.getText().toString().replace("\n", ""));
        payInfo.vzx = bundle;
        h.a(qrRewardGrantUI, payInfo, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1336);
        this.lka.ceO();
        setMMTitle(a$i.uMA);
        this.ljO = getIntent().getIntExtra("key_money_amt", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        this.ljP = getIntent().getIntExtra("key_amt_type", 0);
        this.ljQ = getIntent().getStringExtra("key_qrcode_desc");
        this.fCR = getIntent().getIntExtra("key_channel", 0);
        this.ljS = getIntent().getStringExtra("key_rcvr_open_id");
        this.ljU = getIntent().getStringExtra("key_rcvr_name");
        this.ljV = getIntent().getStringExtra("key_rcvr_true_name");
        this.ljW = getIntent().getStringExtra("key_scan_id");
        this.jeE = getIntent().getStringExtra("key_web_url");
        this.ljX = getIntent().getStringExtra("key_sxtend_1");
        this.ljY = getIntent().getStringExtra("key_sxtend_2");
        this.ljZ = getIntent().getIntExtra("key_max_amt", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        x.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[]{Integer.valueOf(this.ljP), Integer.valueOf(this.fCR), Integer.valueOf(this.ljZ)});
        initView();
    }

    public final void initView() {
        this.ljG = (ImageView) findViewById(f.utL);
        this.ljH = (TextView) findViewById(f.utM);
        this.ljJ = (WalletTextView) findViewById(f.utQ);
        this.ljK = (LinearLayout) findViewById(f.utP);
        this.ljL = (WalletFormView) findViewById(f.utN);
        this.ljM = (MMEditText) findViewById(f.utO);
        this.ljN = (Button) findViewById(f.utR);
        this.ljI = (TextView) findViewById(f.utK);
        this.ljI.setText(getString(a$i.uMJ, new Object[]{Math.round(((float) this.ljZ) / 100.0f)}));
        b.a(this.ljG, this.ljU, 0.03f, false);
        String dC = com.tencent.mm.wallet_core.ui.e.dC(com.tencent.mm.wallet_core.ui.e.gu(this.ljU), 10);
        this.ljH.setText(i.a(this, getString(a$i.uMB, new Object[]{dC})));
        if (this.ljP == 2) {
            x.i("MicroMsg.QrRewardGrantUI", "edit layout");
            e(this.ljL, 2, false);
            this.ljL.a(new 1(this));
            this.ljL.setVisibility(0);
            this.ljK.setVisibility(8);
            this.ljL.cCo();
            this.ljN.setEnabled(false);
        } else {
            this.ljJ.setText(com.tencent.mm.wallet_core.ui.e.t(((double) this.ljO) / 100.0d));
            this.ljL.setVisibility(8);
            this.ljK.setVisibility(0);
        }
        this.ljN.setOnClickListener(new 2(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof e) {
            e eVar = (e) kVar;
            eVar.a(new 5(this, eVar)).b(new 4(this, eVar)).c(new 3(this));
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1336);
        this.lka.dead();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            if (intent != null) {
                cb(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
        }
    }

    protected final int getLayoutId() {
        return a$g.uDJ;
    }

    private void cb(String str, String str2) {
        x.i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (bh.ov(this.fuH)) {
            this.fuH = str;
        }
        if (bh.ov(this.lie)) {
            this.lie = str2;
        }
        b(new d(this.fuH, this.ljR, this.lie, this.ljO, this.ljS, this.ljT), false);
    }
}
