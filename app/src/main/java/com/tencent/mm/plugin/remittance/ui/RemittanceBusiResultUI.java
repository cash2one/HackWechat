package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@a(19)
public class RemittanceBusiResultUI extends WalletBaseUI {
    private TextView jJn;
    private String oWp;
    private int ofD;
    private Button pIM;
    private int pKa;
    private String pKb;
    private TextView pMD;
    private TextView pME;
    private TextView pMF;
    private CdnImageView pMG;
    private TextView pMH;
    private TextView pMI;
    private Button pMJ;
    private ViewGroup pMK;
    private ViewGroup pML;
    private ViewGroup pMM;
    private String pMN;
    private String pMO;
    private String pMP;
    private String pMQ;
    private double pMR;
    private String pMS;
    private String pMT;
    private String pMU;
    private int pMV;
    private String pMW;
    private String pMX;
    private b pMY;
    private boolean pMZ = false;
    private String pMo;
    private String pNa;
    private BusiRemittanceResp pNb;
    private cd pNc = new cd();
    private int pNd;
    private d.a.a.b pNe;
    private WalletSuccPageAwardWidget pNf;
    private CdnImageView pNg;
    private TextView pNh;
    private View pNi;
    private TextView pNj;
    private ViewGroup pNk;
    private ViewGroup pNl;
    private ViewGroup pNm;
    private TextView pNn;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1537);
        ji(1680);
        ji(2504);
        if (d.fM(21)) {
            if (d.fM(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pMN = getIntent().getStringExtra("key_mch_name");
        this.pNb = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        this.pMR = getIntent().getDoubleExtra("key_money", 0.0d);
        this.pMQ = getIntent().getStringExtra("key_rcver_name");
        this.pNa = getIntent().getStringExtra("key_rcver_true_name");
        this.pMO = getIntent().getStringExtra("key_rcv_desc");
        this.pMP = getIntent().getStringExtra("key_pay_desc");
        this.pMS = getIntent().getStringExtra("key_f2f_id");
        this.oWp = getIntent().getStringExtra("key_trans_id");
        this.pMo = getIntent().getStringExtra("key_rcvr_open_id");
        this.pMX = getIntent().getStringExtra("key_check_sign");
        this.pMT = getIntent().getStringExtra("key_pay_desc");
        this.pMU = getIntent().getStringExtra("key_rcv_desc");
        this.pMV = getIntent().getIntExtra("key_scan_sceen", 0);
        this.ofD = getIntent().getIntExtra("key_channel", 0);
        this.pMW = getIntent().getStringExtra("key_succ_page_extend");
        try {
            this.pNc.aF(getIntent().getByteArrayExtra("AfterPlaceOrderCommReq"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e, "", new Object[0]);
        }
        this.pNd = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.pKa = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.pKb = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.pMZ = false;
        x.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        l(new j(this.pNc, this.pMW));
        initView();
    }

    protected final void initView() {
        CharSequence string;
        this.jJn = (TextView) findViewById(f.uuP);
        this.pMD = (TextView) findViewById(f.uuG);
        this.pME = (TextView) findViewById(f.uuK);
        this.pMF = (TextView) findViewById(f.uuI);
        this.pMK = (LinearLayout) findViewById(f.uuJ);
        this.pML = (LinearLayout) findViewById(f.uuH);
        this.pMG = (CdnImageView) findViewById(f.uuC);
        this.pMH = (TextView) findViewById(f.uuE);
        this.pMI = (TextView) findViewById(f.uuD);
        this.pMJ = (Button) findViewById(f.uuA);
        this.pMM = (ViewGroup) findViewById(f.uuB);
        this.pIM = (Button) findViewById(f.uuF);
        this.pMD.setText(e.t(this.pMR));
        String dC;
        Object string2;
        if (bh.ov(this.pMN)) {
            dC = e.dC(e.gu(this.pMQ), 6);
            if (!bh.ov(this.pNa)) {
                string2 = getString(i.uMZ, new Object[]{dC, this.pNa});
            }
            string2 = dC;
        } else {
            dC = e.dC(this.pMN, 6);
            if (!bh.ov(this.pNa)) {
                string = getString(i.uMZ, new Object[]{dC, this.pNa});
            }
            string2 = dC;
        }
        if (bh.ov(this.pMO)) {
            this.pMK.setVisibility(8);
        } else {
            this.pME.setText(this.pMO);
            this.pMK.setVisibility(0);
        }
        if (bh.ov(this.pMP)) {
            this.pML.setVisibility(8);
        } else {
            this.pMF.setText(this.pMP);
            this.pML.setVisibility(0);
        }
        this.pIM.setOnClickListener(new 1(this));
        this.pNf = (WalletSuccPageAwardWidget) findViewById(f.ueI);
        this.pNk = (ViewGroup) findViewById(f.ujD);
        this.pNl = (ViewGroup) findViewById(f.ujB);
        this.pNm = (ViewGroup) findViewById(f.usM);
        this.pNn = (TextView) findViewById(f.usL);
        this.pNg = (CdnImageView) findViewById(f.uvy);
        this.pNh = (TextView) findViewById(f.uuM);
        this.pNi = findViewById(f.ulN);
        this.pNj = (TextView) findViewById(f.uuL);
        this.pNh.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, string));
        this.pNg.setVisibility(0);
        if (!bh.ov(this.pKb)) {
            if (this.pNd == 1) {
                this.pNg.vnf = true;
            }
            this.pNg.setUrl(this.pKb);
        } else if (this.pNd == 1) {
            com.tencent.mm.pluginsdk.ui.a.b.o(this.pNg, this.pMQ);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.pNg, this.pMQ);
        }
        this.pNi.setVisibility(8);
        this.pNj.setVisibility(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[]{jVar});
            } else if (jVar.pKx.kLO == 0) {
                x.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[]{jVar.pKx.sOJ});
                this.pNe = jVar.pKx.sOJ;
                if (WalletSuccPageAwardWidget.a(this.pNe)) {
                    x.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[]{this.oWp});
                    this.pNf.a(this, this.pNe, this.oWp, true, (ImageView) findViewById(f.background));
                    this.pNf.init();
                    this.pNf.setVisibility(0);
                    ImageView imageView = (ImageView) findViewById(f.background);
                    imageView.post(new 2(this, imageView));
                    this.pNf.post(new Runnable(this) {
                        final /* synthetic */ RemittanceBusiResultUI pNo;

                        {
                            this.pNo = r1;
                        }

                        public final void run() {
                            View findViewById = this.pNo.findViewById(f.ufP);
                            if (findViewById != null) {
                                int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.pNo, 25);
                                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                                marginLayoutParams.topMargin = fromDPToPix;
                                marginLayoutParams.bottomMargin = fromDPToPix;
                                findViewById.setLayoutParams(marginLayoutParams);
                                findViewById.setVisibility(0);
                            }
                        }
                    });
                } else {
                    this.pNf.setVisibility(8);
                }
                this.pNl.setVisibility(8);
                this.pNk.setVisibility(8);
                this.pNm.setVisibility(8);
                if (jVar.pKx.vPi == 1) {
                    this.pNi.setVisibility(0);
                    this.pNj.setVisibility(0);
                    this.pNj.setText(e.u(((double) jVar.pKx.vPf) / 100.0d));
                } else {
                    this.pNi.setVisibility(8);
                    this.pNj.setVisibility(8);
                }
                if (!(jVar == null || jVar.pKx == null || jVar.pKx.vPg.size() <= 0)) {
                    int size;
                    List list = jVar.pKx.vPg;
                    String str2 = "MicroMsg.RemittanceBusiResultUI";
                    String str3 = "discountInfoList: %s, size: %s received_amount: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = list;
                    if (list != null) {
                        size = list.size();
                    } else {
                        size = 0;
                    }
                    objArr[1] = Integer.valueOf(size);
                    objArr[2] = Long.valueOf(jVar.pKx.vPf);
                    x.i(str2, str3, objArr);
                    if (list != null && list.size() > 0) {
                        this.pNl.removeAllViews();
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            String str4 = (String) list.get(i3);
                            View textView = new TextView(this.mController.xIM);
                            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.bottomMargin = com.tencent.mm.bv.a.fromDPToPix(this, 6);
                            textView.setLayoutParams(layoutParams);
                            textView.setTextSize(1, 12.0f);
                            textView.setTextColor(Color.parseColor("#FA962A"));
                            textView.setText(str4);
                            this.pNl.addView(textView);
                        }
                        this.pNl.setVisibility(0);
                        this.pNk.setVisibility(0);
                    }
                    if (jVar.pKx.vPf > 0) {
                        this.pNn.setText(e.u(((double) jVar.pKx.vPf) / 100.0d));
                        this.pNn.getPaint().setFlags(16);
                        this.pNm.setVisibility(0);
                    }
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", new Object[]{Integer.valueOf(jVar.pKx.kLO), jVar.pKx.kLP});
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.f) {
            com.tencent.mm.plugin.remittance.model.f fVar = (com.tencent.mm.plugin.remittance.model.f) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[]{fVar});
            } else if (fVar.pKm.kLO == 0) {
                jn jnVar = fVar.pKm.vOM;
                if (jnVar != null) {
                    this.pMG.setUrl(jnVar.fDI);
                    this.pMH.setText(jnVar.title);
                    this.pMI.setText(jnVar.sNy);
                    this.pMJ.setText(jnVar.sUr);
                    this.pMJ.setOnClickListener(new 4(this, jnVar));
                    this.pMJ.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.udD);
                    this.pMJ.setTextColor(getResources().getColor(c.buk));
                    this.pMM.setVisibility(0);
                } else {
                    x.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.pMM.setVisibility(8);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[]{Integer.valueOf(fVar.pKm.kLO), fVar.pKm.kLP});
                Toast.makeText(this, fVar.pKm.kLP, 1).show();
            }
        }
        if (this.pNe != null) {
            return this.pNf.d(i, i2, str, kVar);
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        if (this.pMZ) {
            x.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            b(new com.tencent.mm.plugin.remittance.model.f(this.pMS, this.oWp, this.pMo, (int) Math.round(this.pMR * 100.0d), this.pMY, this.pMX), false);
            this.pMZ = false;
        }
        if (this.pNe != null) {
            this.pNf.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1537);
        jj(1680);
        jj(2504);
        if (this.pNe != null) {
            this.pNf.onDestroy();
        }
    }

    protected final int getLayoutId() {
        return g.uDY;
    }

    public final void uD(int i) {
        this.mController.contentView.setVisibility(i);
    }
}
