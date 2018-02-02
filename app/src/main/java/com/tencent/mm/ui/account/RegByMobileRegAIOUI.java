package com.tencent.mm.ui.account;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b$a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.j.a;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;

public class RegByMobileRegAIOUI extends MMActivity implements e {
    private String countryCode = null;
    private String hEx = null;
    private ImageView iip;
    private int jge;
    private String pRQ;
    private String phQ = null;
    private int progress = 0;
    private c xNR = new 1(this);
    private ResizeLayout xOH;
    private String xOW;
    private r xPh;
    private i xQA = null;
    private af xQB = new af(this) {
        final /* synthetic */ RegByMobileRegAIOUI xQK;

        {
            this.xQK = r1;
        }

        public final void handleMessage(Message message) {
            if ((this.xQK.xQA == null || this.xQK.xQA.isShowing()) && !this.xQK.xQD) {
                this.xQK.progress = this.xQK.progress + 2;
                this.xQK.xQz.setProgress(this.xQK.progress);
                if (this.xQK.progress < this.xQK.xQz.getMax()) {
                    sendEmptyMessageDelayed(0, 10);
                    return;
                }
                this.xQK.xQz.setIndeterminate(true);
                if (!this.xQK.xQD) {
                    if (this.xQK.xQA != null) {
                        this.xQK.xQA.dismiss();
                    }
                    this.xQK.Yx(null);
                }
            }
        }
    };
    private j xQC;
    private boolean xQD = false;
    private a xQE = new 16(this);
    private int xQF;
    private int xQG;
    private boolean xQH;
    private boolean xQI;
    private final int xQJ = FileUtils.S_IWUSR;
    private LinearLayout xQd;
    private TextView xQe;
    private EditText xQf;
    private MMFormInputView xQg;
    private String xQh = null;
    private boolean xQi = true;
    private String xQj;
    private String xQk;
    private String xQl = null;
    private TextView xQm;
    private Button xQn;
    private Button xQo;
    private MMFormInputView xQp;
    private boolean xQq = false;
    private ImageView xQr;
    private MMFormInputView xQs;
    private int xQt = 0;
    private boolean xQu;
    private boolean xQv;
    private ScrollView xQw;
    private boolean xQx = false;
    private boolean xQy = true;
    private ProgressBar xQz;

    static /* synthetic */ void a(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        View currentFocus = regByMobileRegAIOUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - regByMobileRegAIOUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                regByMobileRegAIOUI.xQw.post(new Runnable(regByMobileRegAIOUI) {
                    final /* synthetic */ RegByMobileRegAIOUI xQK;

                    public final void run() {
                        this.xQK.xQw.smoothScrollBy(0, height);
                    }
                });
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dqD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hEx = bh.az(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bh.az(getIntent().getStringExtra("couttry_code"), "");
        this.xQh = bh.az(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.jge = getIntent().getIntExtra("login_type", 0);
        this.pRQ = b.Xn();
        com.tencent.mm.z.bh.HO();
        b.jd(20);
        initView();
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        ar.CG().a(701, this);
        ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        ar.CG().a(132, this);
        b.b(true, ar.CB() + "," + getClass().getName() + ",RE200_100," + ar.fH("RE200_100") + ",1");
        showVKB();
        this.xQt = 0;
    }

    public void onPause() {
        super.onPause();
        if (this.xPh != null) {
            this.xPh.dismiss();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
        ar.CG().b(701, this);
        ar.CG().b(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        ar.CG().b(132, this);
        b.oG("RE200_100");
    }

    protected final void initView() {
        this.xQd = (LinearLayout) findViewById(R.h.bZd);
        this.xQe = (TextView) findViewById(R.h.bZf);
        this.xQg = (MMFormInputView) findViewById(R.h.cHr);
        this.xQg.setInputType(3);
        this.xQf = this.xQg.pqM;
        this.xQm = (TextView) findViewById(R.h.bJE);
        this.xQo = (Button) findViewById(R.h.cHi);
        this.iip = (ImageView) findViewById(R.h.cLI);
        this.xQr = (ImageView) findViewById(R.h.cLK);
        this.xQp = (MMFormInputView) findViewById(R.h.cHp);
        com.tencent.mm.ui.tools.a.c.d(this.xQp.pqM).GN(16).a(null);
        this.xQw = (ScrollView) findViewById(R.h.scrollView);
        this.xOH = (ResizeLayout) findViewById(R.h.cHL);
        this.xQs = (MMFormInputView) findViewById(R.h.cHk);
        this.xQs.pqM.requestFocus();
        this.xOH.xSs = new 12(this);
        OnFocusChangeListener anonymousClass19 = new OnFocusChangeListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI xQK;

            {
                this.xQK = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    RegByMobileRegAIOUI.a(this.xQK);
                }
            }
        };
        this.xQs.yaq = anonymousClass19;
        this.xQp.yaq = anonymousClass19;
        com.tencent.mm.z.bh.HO();
        this.xQv = true;
        com.tencent.mm.z.bh.HO();
        this.xQu = true;
        if (!this.xQu) {
            this.iip.setVisibility(8);
            this.xQr.setVisibility(8);
        }
        if (!this.xQv) {
            this.xQp.setVisibility(8);
        }
        String string = getString(R.l.eEa);
        if (d.vAC) {
            string = string + getString(R.l.dDD);
        }
        setMMTitle(string);
        if (this.xQn != null) {
            this.xQn.setOnClickListener(new 20(this));
        }
        string = getString(R.l.esL);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (w.cff()) {
            string2 = getString(R.l.esM);
            string3 = getString(R.l.eAW);
            string4 = getString(R.l.dDI);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI xQK;

                {
                    this.xQK = r1;
                }

                public final void onClick(View view) {
                    bh.F(this.xQK.mController.xIM, this.xQK.getString(R.l.eSl));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.xQK.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new 22(this), ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + str.length()) + string2.length()) + string4.length()) + string3.length(), 33);
            this.xQm.setText(newSpannable);
        } else {
            string2 = getString(R.l.esS);
            string3 = getString(R.l.esO);
            string4 = getString(R.l.dDI);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new 23(this), string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new 24(this), ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            this.xQm.setText(newSpannable);
        }
        this.xQm.setMovementMethod(LinkMovementMethod.getInstance());
        this.xQf.addTextChangedListener(new 25(this));
        this.xQp.addTextChangedListener(new 2(this));
        this.xQs.addTextChangedListener(new 3(this));
        this.xQo.setOnClickListener(new 4(this));
        this.xQo.setEnabled(false);
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            string = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + string);
            if (bh.ov(string)) {
                x.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
            } else {
                b$a h = com.tencent.mm.ar.b.h(this, string, getString(R.l.bZb));
                if (h == null) {
                    x.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                } else {
                    this.hEx = h.hEx;
                    this.countryCode = h.hEw;
                }
            }
        }
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            this.hEx = getString(R.l.dXI);
            this.countryCode = ao.Vl(getString(R.l.dXH));
        }
        cnZ();
        if (this.xQh == null || this.xQh.equals("")) {
            ar.Dm().a(new ag.a(this) {
                String lbT;
                final /* synthetic */ RegByMobileRegAIOUI xQK;

                {
                    this.xQK = r1;
                }

                public final boolean JC() {
                    if (bh.ov((this.xQK.xQf.getText()).trim())) {
                        this.xQK.xQf.setText(bh.ov(this.lbT) ? "" : this.lbT);
                    }
                    return true;
                }

                public final boolean JB() {
                    this.lbT = com.tencent.mm.modelsimple.c.z(this.xQK, this.xQK.countryCode);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView1";
                }
            });
        } else {
            this.xQf.setText(this.xQh);
        }
        this.xQd.setOnClickListener(new 6(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI xQK;

            {
                this.xQK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xQK.aWs();
                this.xQK.bov();
                this.xQK.finish();
                return true;
            }
        });
        this.iip.setOnClickListener(new 8(this));
        ar.Dm().a(new 9(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        b.oH(this.pRQ);
        b.b(false, ar.CB() + "," + getClass().getName() + ",RE200_100," + ar.fH("RE200_100") + ",2");
        finish();
    }

    private void Yw(String str) {
        String obj;
        if (this.xQv) {
            int i;
            obj = this.xQp.getText().toString();
            if (obj.length() > 16) {
                Eg(a.xSz);
                i = 0;
            } else if (bh.Vq(obj)) {
                h.h(this, R.l.eDw, R.l.eDR);
                i = 0;
            } else if (bh.Vv(obj)) {
                boolean z = true;
            } else {
                if (obj.length() < 8 || obj.length() >= 16) {
                    Eg(a.xSA);
                } else {
                    Eg(a.xSB);
                }
                i = 0;
            }
            if (i == 0) {
                return;
            }
        }
        if (this.xPh != null) {
            this.xPh.dismiss();
        }
        getString(R.l.dGO);
        this.xPh = h.a(this, getString(R.l.eDx), true, new 10(this));
        if (this.jge == 0) {
            obj = ao.Vk(this.xQf.getText().toString().trim());
            int i2 = (this.xQj == null || this.xQk == null || obj.equals(this.xQj) || !obj.equals(this.xQk)) ? (this.xQj == null || this.xQk == null || this.xQk.equals(this.xQj) || obj.equals(this.xQk)) ? 0 : 2 : 1;
            k sVar = new s(str, 12, "", 0, "");
            sVar.hE(this.xQt);
            sVar.hF(i2);
            ar.CG().a(sVar, 0);
            this.xQj = ao.Vk(this.xQf.getText().toString().trim());
            this.xQt++;
            return;
        }
        throw new IllegalArgumentException("NO IMPLEMENT");
    }

    private void cnZ() {
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            this.xQe.setText(getString(R.l.evh));
        } else {
            this.xQe.setText(ao.fr(this.hEx, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 30846) {
            if (i2 == -1 && cob()) {
                coa();
                b.oH("RE200_250");
                this.xQx = false;
            }
        } else if (i != 30847) {
            switch (i2) {
                case 100:
                    this.hEx = bh.az(intent.getStringExtra("country_name"), "");
                    this.countryCode = bh.az(intent.getStringExtra("couttry_code"), "");
                    cnZ();
                    return;
                default:
                    Bitmap a = com.tencent.mm.plugin.c.a.ift.a(this, i, i2, intent);
                    if (a != null) {
                        this.iip.setImageBitmap(a);
                        this.xQq = true;
                        this.xQr.setVisibility(8);
                        return;
                    }
                    return;
            }
        } else if (i2 == -1) {
            this.xQy = false;
            Yw(this.xQl + this.phQ);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xPh != null) {
            this.xPh.dismiss();
            this.xPh = null;
        }
        if (i2 == -75) {
            h.h(this, R.l.dDG, R.l.eCW);
            return;
        }
        com.tencent.mm.h.a eA;
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX) {
            String NY;
            int IS = ((s) kVar).IS();
            if (IS == 12) {
                if (i2 == -41 || i2 == -59) {
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this, null, null);
                        return;
                    } else {
                        h.h(this, R.l.eDE, R.l.eDF);
                        return;
                    }
                }
                this.phQ = ao.Vk(this.phQ);
                this.xQk = this.xQl + this.phQ;
                this.xOW = ((s) kVar).Ok();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    NY = ((s) kVar).NY();
                    if (!bh.ov(NY)) {
                        this.phQ = NY.trim();
                    }
                    b.oG("RE200_100");
                    b.b(true, ar.CB() + "," + getClass().getName() + ",RE200_200," + ar.fH("RE200_200") + ",1");
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this, new 11(this), new 13(this));
                        return;
                    }
                    coa();
                    b.oH("RE200_250");
                    this.xQx = false;
                    return;
                } else if (i2 == -355) {
                    m.b(this, str, 30846);
                    return;
                } else if (i2 == -34) {
                    h.b(this, getString(R.l.dKT), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            }
            if (IS == 14) {
                if (i2 == 0 || str == null) {
                    if (((s) kVar).NZ() == 1) {
                        String str2 = this.xQl + this.phQ;
                        String Ob = ((s) kVar).Ob();
                        NY = ((s) kVar).Oa();
                        Intent intent = new Intent(this, RegByMobileSendSmsUI.class);
                        intent.putExtra("regsession_id", this.xOW);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", Ob);
                        intent.putExtra("verify_code", NY);
                        intent.putExtra("kintent_nickname", this.xQs.getText().toString());
                        intent.putExtra("kintent_password", this.xQp.getText().toString());
                        intent.putExtra("kintent_hasavatar", this.xQq);
                        startActivity(intent);
                    } else {
                        this.xQF = ((s) kVar).Od();
                        this.xQG = ((s) kVar).Oe();
                        this.xQH = ((s) kVar).Of();
                        this.xQI = ((s) kVar).Oh();
                        if (this.xQC == null) {
                            this.xQC = new j(this, this.xQE);
                            this.xQC.coq();
                        }
                        if (this.xQA == null) {
                            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.i.dqB, null);
                            this.xQz = (ProgressBar) inflate.findViewById(R.h.cDZ);
                            TextView textView = (TextView) inflate.findViewById(R.h.cUA);
                            this.xQA = h.a(this, false, getString(R.l.dLk), inflate, "", "", null, null);
                            this.xQl = ao.Vm(this.countryCode);
                            textView.setText(this.xQl + " " + this.xQf.getText().toString());
                        } else {
                            this.xQA.show();
                        }
                        this.progress = 0;
                        this.xQz.setIndeterminate(false);
                        this.xQB.sendEmptyMessage(10);
                    }
                } else if (i2 == -41) {
                    h.h(this, R.l.eDE, R.l.eDF);
                    return;
                } else if (i2 == -34) {
                    h.b(this, getString(R.l.dKT), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            }
        }
        if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str) && kVar.getType() == 701) {
            eA = com.tencent.mm.h.a.eA(str);
            if (eA != null && eA.a(this, null, null)) {
            }
        }
    }

    private void coa() {
        getString(R.l.dGO);
        this.xPh = h.a(this, getString(R.l.eDx), true, new 14(this));
        k sVar = new s(this.xQl + this.phQ, 14, "", 0, "");
        sVar.lb(this.xOW);
        ar.CG().a(sVar, 0);
    }

    protected void onDestroy() {
        if (this.xQC != null) {
            this.xQC.cor();
            this.xQC = null;
        }
        if (this.xQA != null) {
            this.xQA.dismiss();
        }
        super.onDestroy();
    }

    private synchronized void Yx(String str) {
        if (this.xQC != null) {
            this.xQC.cor();
            this.xQC = null;
        }
        if (!this.xQD) {
            this.xQD = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.xQl + " " + this.xQf.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.phQ);
            intent.putExtra("country_name", this.hEx);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("login_type", this.jge);
            intent.putExtra("mobileverify_countdownsec", this.xQF);
            intent.putExtra("mobileverify_countdownstyle", this.xQG);
            intent.putExtra("mobileverify_fb", this.xQH);
            intent.putExtra("mobileverify_reg_qq", this.xQI);
            intent.putExtra("kintent_nickname", this.xQs.getText().toString());
            intent.putExtra("kintent_password", this.xQp.getText().toString());
            intent.putExtra("kintent_hasavatar", this.xQq);
            intent.putExtra("regsession_id", this.xOW);
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
        }
    }

    private boolean cob() {
        int i;
        boolean a;
        if (bh.ov(this.countryCode)) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.xQv) {
            a = i & a(this.xQf.getText(), this.xQp.getText(), this.xQs.getText());
        } else {
            a = i & a(this.xQf.getText(), this.xQs.getText());
        }
        if (a) {
            this.xQo.setEnabled(true);
        } else {
            this.xQo.setEnabled(false);
        }
        return a;
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        for (Object obj : editableArr) {
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.xQi) {
            return true;
        }
        return false;
    }

    private void Eg(int i) {
        switch (18.xQc[i - 1]) {
            case 1:
                h.h(this, R.l.eDP, R.l.eDR);
                return;
            case 2:
                h.h(this, R.l.eDQ, R.l.eDR);
                return;
            case 3:
                h.h(this, R.l.eSL, R.l.dEN);
                return;
            case 4:
                h.h(this, R.l.eSN, R.l.dEN);
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileRegAIOUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.xQC != null) {
                    this.xQC.cos();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
