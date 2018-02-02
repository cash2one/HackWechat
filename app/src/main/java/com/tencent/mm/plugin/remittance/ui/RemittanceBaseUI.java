package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public abstract class RemittanceBaseUI extends WalletBaseUI implements com.tencent.mm.ad.d.a {
    protected String gAT;
    public String gAb;
    private final int iiI = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 270);
    public int irz;
    protected Button lRZ;
    protected WalletFormView llY;
    private int ofD;
    protected ScrollView pJd;
    private double pKP;
    protected com.tencent.mm.plugin.wallet.a pLQ = null;
    public double pLR;
    protected String pLS;
    public int pLT;
    public String pLU;
    protected ImageView pLV;
    protected TextView pLW;
    protected TextView pLX;
    protected TextView pLY;
    protected TextView pLZ;
    protected TextView pMa;
    private TextView pMb;
    private TextView pMc;
    protected TextView pMd;
    private LinearLayout pMe;
    private LinearLayout pMf;
    protected String pMg;
    private String pMh;
    private String pMi;
    protected String pMj;
    protected String pMk = null;
    protected String pMl = null;
    protected int pMm;
    private int pMn;
    protected String pMo;
    private Map<String, a> pMp = new HashMap();
    private String pMq;
    private boolean pMr = false;
    private boolean pMs = false;
    private boolean pMt = false;
    private boolean pMu = false;
    private c<fk> pMv = new 13(this);

    private static class a {
        String fEs;
        String fuI;
        String lie;
        String ljT;
        int nZd;
        String pKU;
        String pKV;
        String pKZ;
        long pMC;

        a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j) {
            this.pKU = str;
            this.lie = str2;
            this.ljT = str3;
            this.pKV = str4;
            this.nZd = i;
            this.fEs = str5;
            this.fuI = str6;
            this.pKZ = str7;
            this.pMC = j;
        }
    }

    public abstract void bnH();

    public abstract void bnK();

    public abstract void bnN();

    public abstract void dQ(String str, String str2);

    static /* synthetic */ void a(RemittanceBaseUI remittanceBaseUI, String str, String str2) {
        a aVar = (a) remittanceBaseUI.pMp.get(str);
        x.d("MicroMsg.RemittanceBaseUI", "match reqKey: %s, %d", new Object[]{str, Integer.valueOf(remittanceBaseUI.pMp.size())});
        if (aVar == null) {
            x.i("MicroMsg.RemittanceBaseUI", "no data for: %s", new Object[]{str});
        } else {
            x.i("MicroMsg.RemittanceBaseUI", "pay check: %d", new Object[]{Integer.valueOf(remittanceBaseUI.pLT)});
            if (bh.ov(aVar.fuI)) {
                aVar.fuI = str2;
            }
            if (bh.ov(aVar.lie)) {
                aVar.lie = str2;
            }
            if (remittanceBaseUI.pLT == 31) {
                g.CG().a(new q(str, aVar.fEs, aVar.fuI, aVar.pKZ, aVar.pMC, aVar.ljT), 0);
            } else {
                g.CG().a(new l(aVar.pKU, aVar.lie, aVar.ljT, aVar.pKV, aVar.nZd), 0);
            }
        }
        remittanceBaseUI.pMp.clear();
    }

    static /* synthetic */ void c(RemittanceBaseUI remittanceBaseUI) {
        if (bh.ov(remittanceBaseUI.gAT)) {
            remittanceBaseUI.pLZ.setVisibility(8);
            if (remittanceBaseUI.irz == 1) {
                remittanceBaseUI.pMa.setText(i.uMR);
            } else {
                remittanceBaseUI.pMa.setText(i.uMQ);
            }
            remittanceBaseUI.pMa.setVisibility(0);
            return;
        }
        com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(remittanceBaseUI.mController.xIM);
        String string = remittanceBaseUI.getString(i.uNM);
        CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a(remittanceBaseUI, remittanceBaseUI.getString(i.uIy, new Object[]{remittanceBaseUI.gAT, string}));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(a);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wxpay.a.c.btd), a.length() - string.length(), a.length(), 34);
        remittanceBaseUI.pLZ.setText(spannableStringBuilder);
        remittanceBaseUI.pMa.setVisibility(8);
        remittanceBaseUI.pLZ.setVisibility(0);
    }

    protected int getLayoutId() {
        if (this.pLT == 33 || this.pLT == 32) {
            return com.tencent.mm.plugin.wxpay.a.g.uEd;
        }
        return com.tencent.mm.plugin.wxpay.a.g.uEc;
    }

    public void onCreate(Bundle bundle) {
        this.irz = getIntent().getIntExtra("scene", 0);
        this.pLT = getIntent().getIntExtra("pay_scene", 31);
        super.onCreate(bundle);
        this.pLQ = com.tencent.mm.plugin.wallet.a.X(getIntent());
        this.pLU = getIntent().getStringExtra("scan_remittance_id");
        this.pLR = getIntent().getDoubleExtra("fee", 0.0d);
        this.gAb = getIntent().getStringExtra("receiver_name");
        this.pLS = getIntent().getStringExtra("receiver_nick_name");
        this.pMj = getIntent().getStringExtra("receiver_true_name");
        this.ofD = getIntent().getIntExtra("pay_channel", 0);
        this.pMo = bh.az(getIntent().getStringExtra("rcvr_open_id"), "");
        x.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[]{this.gAb});
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.pMn = 1;
        } else if ((longValue & 32) != 0) {
            this.pMn = 2;
        } else {
            this.pMn = 0;
        }
        bnH();
        n.Jz().a(this);
        initView();
        this.pMv.ceO();
    }

    public void onDestroy() {
        super.onDestroy();
        n.Jz().b(this);
        this.pMv.dead();
    }

    public void bnI() {
        k rVar = new r(this.gAb, this.pLU);
        rVar.gOs = "RemittanceProcess";
        l(rVar);
    }

    public void bnJ() {
    }

    protected final void initView() {
        if (this.irz == 1) {
            setMMTitle(i.uNd);
        } else {
            setMMTitle(i.uOk);
        }
        setBackBtn(new 1(this));
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
        this.ofs = findViewById(f.uwM);
        this.pJd = (ScrollView) findViewById(f.uwl);
        this.pLV = (ImageView) findViewById(f.uvV);
        this.pLW = (TextView) findViewById(f.uvW);
        this.pLX = (TextView) findViewById(f.uvX);
        this.pLX.setVisibility(8);
        this.pMf = (LinearLayout) findViewById(f.uvN);
        this.pMe = (LinearLayout) findViewById(f.uvS);
        this.pMc = (TextView) findViewById(f.uvQ);
        this.pMd = (TextView) findViewById(f.uvR);
        this.pMb = (TextView) findViewById(f.uvP);
        bnO();
        this.llY = (WalletFormView) findViewById(f.urG);
        if (this.pLT == 33) {
            this.pMc.setText(e.t(this.pLR));
            this.pMd.setText(u.cBD());
            this.pMg = getIntent().getStringExtra("desc");
            if (bh.ov(this.pMg)) {
                this.pMb.setVisibility(8);
            } else {
                this.pMb.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xIM, this.pMg, this.pMb.getTextSize()));
                this.pMb.setVisibility(0);
            }
            this.pMe.setVisibility(0);
            this.pMf.setVisibility(8);
        } else {
            this.llY.setOnClickListener(new 19(this));
            this.llY.jJn.setText(String.format(getString(i.uNP), new Object[]{"¥"}));
            this.llY.a(new TextWatcher(this) {
                final /* synthetic */ RemittanceBaseUI pMw;

                {
                    this.pMw = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                }
            });
            e(this.llY, 2, false);
            findViewById(f.utA);
            findViewById(f.uvU).setVisibility(0);
            this.pMe.setVisibility(8);
            this.pMf.setVisibility(0);
            this.ofE = new 2(this);
        }
        this.lRZ = (Button) findViewById(f.cAg);
        if (this.irz == 1) {
            this.lRZ.setText(i.uNd);
        }
        this.lRZ.setOnClickListener(new 12(this));
        this.pLZ = (TextView) findViewById(f.uvE);
        this.pMa = (TextView) findViewById(f.uet);
        if (this.irz == 1 || this.irz == 6) {
            this.pMa.setText(i.uMR);
        } else {
            this.pMa.setText(i.uMQ);
        }
        if (!com.tencent.mm.z.q.Gf()) {
            findViewById(f.uvF).setOnClickListener(new 14(this));
        }
        if (this.irz == 1) {
            g.Dk();
            if (((String) g.Dj().CU().get(327732, "0")).equals("0")) {
                h.a(this.mController.xIM, i.uNQ, i.uNR, new 15(this));
                g.Dk();
                g.Dj().CU().set(327732, "1");
                g.Dk();
                g.Dj().CU().lH(true);
            }
        }
        this.pLY = (TextView) findViewById(f.utA);
        bnM();
        bnN();
        bnL();
    }

    private void bnL() {
        if (!bnQ() || bh.ov(this.pMl) || this.pMn == 0 || this.pMm != 1) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.udW, new 16(this));
        }
    }

    private void bnM() {
        if (bh.ov(this.pMk) || this.pMn == 0) {
            this.pLY.setText("");
            this.pLY.setVisibility(8);
            return;
        }
        int i;
        if (this.pMn == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.pLY.setText(String.format(this.pMk, new Object[]{Integer.valueOf(i)}));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.pLY.setText(getString(i.uNU, new Object[]{Integer.valueOf(i)}));
        }
        this.pLY.setVisibility(0);
    }

    protected final void bnO() {
        int i;
        CharSequence dC = e.dC(e.gu(this.gAb), 10);
        if (!bh.ov(this.pMj)) {
            dC = getString(i.uMZ, new Object[]{dC, this.pMj});
        }
        String stringExtra;
        if (this.irz == 1) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            this.pLW.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
            this.pLX.setVisibility(0);
            if (bh.ov(this.gAb)) {
                dC = getString(i.uNc, new Object[]{this.pMj});
            } else {
                dC = getString(i.uNb, new Object[]{e.dC(e.gu(this.gAb), 10), this.pMj});
            }
            this.pLX.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, dC, this.pLX.getTextSize()));
            dC = stringExtra;
        } else if (this.irz == 6) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            if (bh.ov(stringExtra)) {
                dC = getString(i.uNa, new Object[]{dC});
            } else {
                dC = bh.j(stringExtra, new Object[]{dC});
            }
        }
        this.pLW.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, dC, this.pLW.getTextSize()));
        this.pLV.setImageResource(com.tencent.mm.plugin.wxpay.a.e.bBB);
        if (g.Dh().Cy()) {
            com.tencent.mm.ad.i JQ = n.JQ();
            if (!(JQ == null || bh.ov(this.gAb))) {
                com.tencent.mm.ad.h jm = JQ.jm(this.gAb);
                if (jm == null || bh.ov(jm.JH())) {
                    com.tencent.mm.z.ak.a.hfL.a(this.gAb, "", new 17(this, bh.Wp()));
                    i = 1;
                    if (i == 0) {
                        bnP();
                    }
                }
            }
        }
        i = 0;
        if (i == 0) {
            bnP();
        }
    }

    private void bnP() {
        ag.y(new 18(this));
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                com.tencent.mm.wallet_core.c.t.j(this.pLT, tVar.fwY, i2);
                this.pMi = tVar.pKK;
                this.pMj = tVar.pKT;
                if (this.pLT == 32 || this.pLT == 33) {
                    this.pMq = tVar.lie;
                } else {
                    this.pMq = tVar.fEs;
                }
                if (this.pLQ != null) {
                    this.pLQ.i(10000, new Object[]{Integer.valueOf(this.pLT), this.gAb, Double.valueOf(tVar.pKW)});
                }
                if (!a(tVar)) {
                    a(tVar.fwY, this.gAb, this.pMj, tVar);
                }
                this.pMp.put(tVar.fwY, new a(tVar.pKU, tVar.lie, tVar.ljT, tVar.pKV, tVar.nZd, tVar.fEs, tVar.fuI, tVar.pKZ, bh.getLong(tVar.pKX, 0)));
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.ac) {
                com.tencent.mm.plugin.wallet_core.c.ac acVar = (com.tencent.mm.plugin.wallet_core.c.ac) kVar;
                if (!bh.ov(acVar.sIQ)) {
                    ((TextView) findViewById(f.uwi)).setText(acVar.sIQ);
                    View findViewById = findViewById(f.uxe);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new 3(this));
                }
                this.pMh = acVar.pMh;
                this.pKP = acVar.pKP;
                if (this.pKP == 0.0d) {
                    if (this.irz == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(14), Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                    }
                }
            } else if (kVar instanceof ad) {
                this.pMk = ((ad) kVar).sIS;
                this.pMl = ((ad) kVar).sIW;
                this.pMm = ((ad) kVar).sIX;
                bnM();
                bnL();
            }
            return true;
        }
        if (kVar instanceof ad) {
            x.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.pLY.setText("");
            this.pLY.setVisibility(8);
        } else if (kVar instanceof t) {
            com.tencent.mm.wallet_core.c.t.j(this.pLT, "", i2);
            if (b((t) kVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(final t tVar) {
        boolean z = false;
        if (!this.pMr) {
            if (bh.ov(tVar.pKJ)) {
                z = false;
            } else {
                this.pMr = true;
                h.a((Context) this, tVar.pKJ, getString(i.dGt), getString(i.uNf), getString(i.dEn), new OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI pMw;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!this.pMw.a(tVar)) {
                            this.pMw.a(tVar.fwY, this.pMw.gAb, this.pMw.pMj, tVar);
                        }
                    }
                }, new 7(this));
                z = true;
            }
        }
        if (!(z || this.pMs)) {
            if (tVar.pKI > 0) {
                this.pMs = true;
                h.a((Context) this, getString(i.uNZ, new Object[]{Integer.valueOf(tVar.pKI)}), getString(i.dGt), getString(i.uNf), getString(i.uNW), new OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI pMw;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!this.pMw.a(tVar)) {
                            this.pMw.a(tVar.fwY, this.pMw.gAb, this.pMw.pMj, tVar);
                        }
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI pMw;

                    {
                        this.pMw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(this.pMw, "ShowOrdersInfoProcess", null);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.pMt)) {
            if (tVar.pKO) {
                this.pMt = true;
                int i = this.irz;
                double d = tVar.pKS / 100.0d;
                String str = tVar.pKQ;
                b.a(this, i, d, tVar.pKR / 100.0d, tVar.pKL / 100.0d, tVar.pKN, new 10(this, tVar));
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.pMu)) {
            z = b(tVar);
        }
        if (z || bh.ov(tVar.pKX) || bh.ov(tVar.pKY)) {
            return z;
        }
        CharSequence string;
        str = e.dC(e.gu(this.gAb), 10);
        if (bh.ov(this.pMj)) {
            Object obj = str;
        } else {
            string = getString(i.uMZ, new Object[]{str, this.pMj});
        }
        String str2 = tVar.fwY;
        CharSequence charSequence = tVar.pKY;
        String str3 = tVar.pKX;
        View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uEg, null);
        TextView textView = (TextView) inflate.findViewById(f.uwn);
        TextView textView2 = (TextView) inflate.findViewById(f.uwm);
        ((TextView) inflate.findViewById(f.uwo)).setText(charSequence);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string, textView.getTextSize()));
        Double valueOf = Double.valueOf(bh.getDouble(str3, 0.0d));
        textView2.setText(String.format("%s%.2f", new Object[]{u.cBD(), Double.valueOf(valueOf.doubleValue() / 100.0d)}));
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        aVar.mi(false);
        aVar.Ez(i.uOi);
        aVar.dk(inflate);
        aVar.EC(i.uNf);
        aVar.ED(i.uIc);
        aVar.a(new 11(this, str2, tVar));
        aVar.akx().show();
        return true;
    }

    private boolean b(t tVar) {
        if (tVar.fHg == null || !tVar.fHg.bKN()) {
            return false;
        }
        this.pMu = true;
        h.a((Context) this, tVar.fHg.fyY, "", tVar.fHg.odx, tVar.fHg.odw, new 4(this, tVar), new 5(this));
        return true;
    }

    protected final boolean bnQ() {
        return this.irz == 0 || this.irz == 2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gAb);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (this.irz != 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
                        break;
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(16), Integer.valueOf(1)});
                    break;
                }
                stringExtra = intent.getStringExtra("key_trans_id");
                if (bh.ov(this.pMq)) {
                    this.pMq = stringExtra;
                }
                if (!(this.pLT == 33 || this.pLT == 32)) {
                    aa.Is(this.gAb);
                }
                if (this.pKP == 0.0d) {
                    if (this.irz == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(17), Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(12689, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                    }
                }
                finish();
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bh.ov(stringExtra)) {
                        this.gAb = stringExtra;
                        bnO();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(String str, String str2, String str3, t tVar) {
        boolean z;
        if (this.pLT == 31) {
            Object obj = this.pMi;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            } else {
                String decode = URLDecoder.decode(obj);
                x.i("MicroMsg.RemittanceBaseUI", "helios:" + decode);
                String str4 = (String) bi.y(decode, "msg").get(".msg.appmsg.wcpayinfo.transferid");
                if (TextUtils.isEmpty(str4)) {
                    x.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
                } else {
                    z bnp = b.bnm().bnp();
                    if (bh.ov(str4) || bh.ov(decode)) {
                        x.e(z.TAG, "saveMsgContent param error");
                    } else {
                        bnp.pLH.put(str4, decode);
                    }
                }
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str;
        payInfo.fCV = this.pLT;
        if (this.ofD > 0) {
            payInfo.fCR = this.ofD;
        }
        if (this.irz == 2 || this.irz == 5) {
            z = true;
        } else {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str2);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", this.pMg);
        bundle.putBoolean("extinfo_key_4", z);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
        bundle.putString("extinfo_key_7", this.gAT);
        bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
        bundle.putString("extinfo_key_16", this.pMq);
        if (this.irz == 1 && tVar != null) {
            bundle.putString("extinfo_key_11", tVar.pKU);
            bundle.putInt("extinfo_key_12", tVar.pLa);
            bundle.putString("extinfo_key_13", tVar.pLb);
            bundle.putString("extinfo_key_14", tVar.pLc);
        }
        if (tVar != null) {
            bundle.putInt("extinfo_key_15", tVar.nZd);
        }
        payInfo.vzx = bundle;
        Intent intent = new Intent();
        com.tencent.mm.plugin.wallet.a.a(this.pLQ, intent);
        com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, str3, intent, 1);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void bnR() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", aa.bnB());
        intent.setClass(this.mController.xIM, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void jh(String str) {
        x.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (bh.ou(str).length() <= 0) {
            x.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = " + str);
        } else if (str.equals(this.gAb)) {
            bnP();
        }
    }
}
