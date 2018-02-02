package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.b;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private PayInfo pCn;
    private int pLT;
    private b pNe;
    private WalletSuccPageAwardWidget pNf;
    private Orders pPl;
    private String pPm;
    private boolean pPn;
    private TextView pPo;
    private ViewGroup pPp;
    private TextView pPq;
    private WalletTextView pPr;
    private ViewGroup pPs;
    private ViewGroup pPt;
    private ViewGroup pPu;
    private TextView pPv;
    private TextView pPw;
    private WalletTextView pPx;
    private ky pPy;
    private Button pPz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        this.pCn = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (this.pCn == null) {
            x.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        String str2 = "";
        if (this.pCn.vzx != null) {
            this.pPn = this.pCn.vzx.getBoolean("extinfo_key_4");
            str = this.pCn.vzx.getString("extinfo_key_1");
            str2 = this.pCn.vzx.getString("extinfo_key_16");
        }
        this.pLT = this.pCn.fCV;
        this.pPm = str;
        x.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[]{Integer.valueOf(r2)});
        initView();
        if (this.pLT == 31) {
            x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[]{str2});
            com.tencent.mm.plugin.remittance.a.b.bnm().bnp().dP(str2, this.pPm);
        }
    }

    protected final int getLayoutId() {
        return g.uEe;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bnY();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        boolean z = false;
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pPo = (TextView) findViewById(f.usU);
        this.pPp = (ViewGroup) findViewById(f.ukm);
        this.pPq = (TextView) findViewById(f.ukg);
        this.pPr = (WalletTextView) findViewById(f.ukf);
        this.pPs = (ViewGroup) findViewById(f.ukk);
        this.pPt = (ViewGroup) findViewById(f.ukl);
        this.pPu = (ViewGroup) findViewById(f.urV);
        this.pPv = (TextView) findViewById(f.urU);
        this.pPw = (TextView) findViewById(f.urT);
        this.pPx = (WalletTextView) findViewById(f.urS);
        this.pPz = (Button) findViewById(f.uxn);
        this.pPz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RemittanceResultNewUI pPA;

            {
                this.pPA = r1;
            }

            public final void onClick(View view) {
                this.pPA.bnY();
            }
        });
        this.pNf = (WalletSuccPageAwardWidget) findViewById(f.ueI);
        String gu = e.gu(this.pPm);
        if (this.pLT == 31 || this.pLT == 5) {
            this.pPw.setText(e.aax(this.pPl.paz));
            this.pPx.setText(e.t(this.pPl.pNX));
            if (this.pLT == 31) {
                CharSequence string = getString(i.uwh, new Object[]{gu});
                if (bh.ov(string)) {
                    this.pPv.setVisibility(8);
                } else {
                    this.pPv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string, this.pPv.getTextSize()));
                }
            } else {
                boolean z2;
                if (this.pCn.vzx == null || !this.pCn.vzx.getBoolean("extinfo_key_10")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                x.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[]{Boolean.valueOf(z2)});
                if (z2) {
                    this.pPv.setText(getString(i.uNN));
                } else if (!(this.pPl.sNW == null || this.pPl.sNW.get(0) == null || TextUtils.isEmpty(((Commodity) this.pPl.sNW.get(0)).pao))) {
                    this.pPv.setText(((Commodity) this.pPl.sNW.get(0)).pao);
                }
            }
            this.pPu.setVisibility(0);
            if (this.pPl.pKL > 0.0d) {
                bnX();
                ((MarginLayoutParams) this.pPs.getLayoutParams()).topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 20);
                this.pPs.setVisibility(0);
                this.pPt.setVisibility(0);
            }
        } else {
            byte[] byteArray = this.vf.getByteArray("key_succpage_resp");
            if (byteArray != null) {
                this.pPy = new ky();
                try {
                    this.pPy.aF(byteArray);
                    this.pNe = this.pPy.sOJ;
                } catch (Throwable e) {
                    this.pPy = null;
                    this.pNe = null;
                    x.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e, "parse f2FPaySucPageResp error: %s", new Object[]{e.getMessage()});
                }
            }
            gu = e.gu(this.pPm);
            this.pPq.setText(e.aax(this.pPl.paz));
            this.pPr.setText(e.t(this.pPl.pNX));
            this.pPt.removeAllViews();
            if (this.pLT == 32 || this.pLT == 33 || this.pLT == 48) {
                CharSequence charSequence;
                ViewGroup viewGroup;
                TextView textView;
                String str = "";
                if (this.pCn.vzx != null) {
                    str = this.pCn.vzx.getString("extinfo_key_2");
                }
                if (gu != null && gu.length() > 10) {
                    gu = gu.substring(0, 10) + "...";
                }
                Object obj;
                if (bh.ov(str)) {
                    obj = gu;
                } else if (bh.ov(gu)) {
                    obj = str;
                } else {
                    charSequence = gu + "(" + e.aaA(str) + ")";
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
                ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(g.uBT, this.pPt, false);
                TextView textView2 = (TextView) viewGroup2.findViewById(f.uuM);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) viewGroup2.findViewById(f.uvy), this.pPm, 0.06f, false);
                textView2.setText(charSequence);
                this.pPt.addView(viewGroup2);
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
                CharSequence string2 = this.pCn.vzx.getString("extinfo_key_3");
                CharSequence string3 = this.pCn.vzx.getString("extinfo_key_8");
                if (!bh.ov(string2)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uBS, this.pPt, false);
                    textView2 = (TextView) viewGroup.findViewById(f.cSu);
                    textView = (TextView) viewGroup.findViewById(f.caS);
                    if (bh.ov(string3)) {
                        textView2.setText(getString(i.uIv));
                    } else {
                        textView2.setText(string3);
                    }
                    textView.setText(string2);
                    this.pPt.addView(viewGroup);
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
                string2 = this.pCn.vzx.getString("extinfo_key_6");
                string3 = this.pCn.vzx.getString("extinfo_key_7");
                if (!bh.ov(string3)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uBS, this.pPt, false);
                    textView2 = (TextView) viewGroup.findViewById(f.cSu);
                    textView = (TextView) viewGroup.findViewById(f.caS);
                    if (bh.ov(string2)) {
                        textView2.setText(getString(i.uIu));
                    } else {
                        textView2.setText(string2);
                    }
                    textView.setText(string3);
                    this.pPt.addView(viewGroup);
                }
                bnX();
                if (this.pPt.getChildCount() == 1) {
                    LayoutParams layoutParams = (LayoutParams) this.pPs.getLayoutParams();
                    layoutParams.topMargin = BackwardSupportUtil.b.b(this, 78.0f);
                    this.pPs.setLayoutParams(layoutParams);
                    View findViewById = viewGroup2.findViewById(f.uvT);
                    layoutParams = (LayoutParams) findViewById.getLayoutParams();
                    layoutParams.topMargin = BackwardSupportUtil.b.b(this, 24.0f);
                    layoutParams.bottomMargin = 0;
                    findViewById.setLayoutParams(layoutParams);
                    ImageView imageView = (ImageView) viewGroup2.findViewById(f.uvy);
                    ((TextView) viewGroup2.findViewById(f.uuM)).setVisibility(8);
                    findViewById(f.uuO).setVisibility(0);
                    ((TextView) findViewById(f.uuN)).setText(charSequence);
                    LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
                    int b = BackwardSupportUtil.b.b(this, 52.0f);
                    layoutParams2.width = b;
                    layoutParams2.height = b;
                    imageView.setLayoutParams(layoutParams2);
                    this.pPr.setTextSize(1, 42.0f);
                    this.pPq.setTextSize(1, 42.0f);
                    ((TextView) findViewById(f.uuQ)).setTextSize(1, 16.0f);
                    ImageView imageView2 = (ImageView) findViewById(f.uAO);
                    layoutParams = (LayoutParams) imageView2.getLayoutParams();
                    layoutParams.width = BackwardSupportUtil.b.b(this, 26.0f);
                    layoutParams.height = BackwardSupportUtil.b.b(this, 22.0f);
                    imageView2.setLayoutParams(layoutParams);
                }
                this.pPs.setVisibility(0);
                this.pPt.setVisibility(0);
                if (WalletSuccPageAwardWidget.a(this.pNe)) {
                    String str2 = "";
                    if (this.pPl.sNW.size() > 0) {
                        str2 = ((Commodity) this.pPl.sNW.get(0)).fuI;
                    }
                    x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[]{str2});
                    this.pNf.a(this, this.pNe, str2, true, (ImageView) findViewById(f.background));
                    this.pNf.init();
                    this.pNf.setVisibility(0);
                } else {
                    this.pNf.setVisibility(8);
                }
            }
            this.pPp.setVisibility(0);
        }
        com.tencent.mm.kernel.g.Dk();
        Object obj2 = com.tencent.mm.kernel.g.Dj().CU().get(w.a.xoL, Boolean.valueOf(false));
        if (obj2 != null) {
            z = ((Boolean) obj2).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultNewUI", "has show the finger print auth guide!");
            return;
        }
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        Bundle bundle = new Bundle();
        if (ag != null) {
            bundle = ag.msB;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultNewUI", "pwd is empty, not show the finger print auth guide!");
        } else if (ag != null) {
            ag.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void bnX() {
        boolean z = true;
        if (this.pPl != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.pPl.pKL <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.pPl.pKL > 0.0d) {
                CharSequence string = getString(i.uOe);
                CharSequence d = e.d(this.pPl.pKL, this.pPl.paz);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uBR, this.pPt, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(f.bLL);
                TextView textView = (TextView) viewGroup.findViewById(f.caS);
                ((TextView) viewGroup.findViewById(f.cSu)).setText(string);
                imageView.setVisibility(8);
                textView.setText(d);
                this.pPt.addView(viewGroup);
            }
        }
    }

    private void bnY() {
        x.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new 2(this));
                realnameGuideHelper.a(this, bundle, new 3(this));
                this.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        bnZ();
    }

    private void bnZ() {
        x.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        cCc().b((Activity) this, this.vf);
        new af().postDelayed(new 4(this), 100);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            return this.pNf.d(i, i2, str, kVar);
        }
        return super.d(i, i2, str, kVar);
    }

    public final void uD(int i) {
        this.mController.contentView.setVisibility(i);
    }

    protected final boolean boa() {
        return false;
    }

    public void onResume() {
        super.onResume();
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            this.pNf.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            this.pNf.onDestroy();
        }
    }
}
