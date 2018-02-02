package com.tencent.mm.ui.bindlinkedin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class BindLinkedInUI extends MMActivity implements e {
    private String fWA;
    private String fWB;
    private ProgressDialog kVi;
    private String name;
    private boolean pka = false;
    private TextView qle;
    private int status;
    private String yle;
    private boolean ylf = false;
    private boolean ylg = false;
    private boolean ylh = false;
    private Bundle yli;
    private boolean ylj = false;
    private boolean ylk = false;
    private TextView yll;
    private TextView ylm;
    private View yln;
    private MMSwitchBtn ylo;
    private TextView ylp;
    private TextView ylq;
    private String ylr;
    private String yls;
    private String ylt;
    private String ylu;

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", q.FS());
        if (bindLinkedInUI.ylh) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        d.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(549, (e) this);
        ar.CG().a(550, (e) this);
        this.yli = getIntent().getBundleExtra("qrcode_bundle");
        this.ylg = this.yli != null;
        if (this.yli != null) {
            this.fWA = this.yli.getString("i");
            this.fWB = this.yli.getString("n");
            this.ylr = this.yli.getString("t");
            this.yls = this.yli.getString("o");
            this.ylt = this.yli.getString("s");
            this.ylu = this.yli.getString("r");
            if (this.fWA == null || this.fWB == null || this.ylr == null || this.ylt == null || this.ylu == null) {
                h.a(this, getString(R.l.dVo), null, false, new 1(this));
            }
        }
        this.ylh = getIntent().getBooleanExtra("oversea_entry", false);
        WT();
        if (this.ylg) {
            this.ylf = true;
        }
        initView();
        if (this.yli != null && this.pka && this.yle.equals(this.fWA)) {
            this.ylj = true;
            mA(true);
        }
    }

    protected void onDestroy() {
        ar.CG().b(550, (e) this);
        ar.CG().b(549, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dbe;
    }

    private void WT() {
        boolean z = true;
        ar.Hg();
        this.yle = (String) c.CU().get(286721, null);
        this.pka = !bh.ov(this.yle);
        ar.Hg();
        this.name = (String) c.CU().get(286722, null);
        this.status = q.FW();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.ylf = z;
    }

    protected final void initView() {
        if (this.ylg) {
            setMMTitle(R.l.dVw);
        } else if (this.ylh) {
            setMMTitle(R.l.dVy);
        } else {
            setMMTitle(R.l.dVq);
        }
        this.yll = (TextView) findViewById(R.h.cLS);
        this.ylm = (TextView) findViewById(R.h.cLT);
        this.yln = findViewById(R.h.cOj);
        this.ylo = (MMSwitchBtn) findViewById(R.h.cOi);
        this.ylp = (TextView) findViewById(R.h.bNd);
        this.ylq = (TextView) findViewById(R.h.cTE);
        this.qle = (TextView) findViewById(R.h.bPn);
        this.yll.setOnClickListener(new 6(this));
        this.ylp.setOnClickListener(new 7(this));
        this.ylq.setOnClickListener(new 8(this));
        this.qle.setOnClickListener(new 9(this));
        setBackBtn(new 10(this));
        au();
    }

    private void goBack() {
        if (!this.ylg) {
            setResult(-1);
            finish();
        } else if (this.ylk) {
            Intent at = a.ifs.at(this);
            at.addFlags(603979776);
            at.putExtra("preferred_tab", 2);
            startActivity(at);
        } else {
            setResult(-1);
            finish();
        }
    }

    private void mA(boolean z) {
        if (this.yli == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            return;
        }
        k aVar = new com.tencent.mm.at.a(this.ylo.zvg ? 1 : 2, this.fWA, this.fWB, "", this.ylr, this.yls, this.ylt, this.ylu);
        if (!z) {
            this.kVi = h.a(this, getString(R.l.ctB), false, new 11(this, aVar));
        }
        ar.CG().a(aVar, 0);
    }

    private void YU(String str) {
        int indexOf = getString(R.l.dVl).indexOf("%s");
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(R.l.dVl, new Object[]{str}));
        newSpannable.setSpan(new 12(this), indexOf, str.length() + indexOf, 33);
        this.yll.setText(newSpannable);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        this.qle.setVisibility(8);
        if (z) {
            this.ylm.setVisibility(8);
            this.yll.setVisibility(0);
            YU(str);
            this.yln.setVisibility(0);
            this.ylp.setVisibility(8);
            if (z2) {
                this.ylq.setVisibility(0);
            }
            this.ylo.nB(z3);
            this.ylo.zvp = new 3(this);
            return;
        }
        this.yll.setVisibility(8);
        this.yll.setText(getString(R.l.dVm));
        this.ylm.setVisibility(0);
        this.yln.setVisibility(8);
        this.ylp.setVisibility(0);
        this.ylq.setVisibility(8);
    }

    private void au() {
        boolean z = true;
        if (this.ylg && this.yli == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
        } else if (this.ylh) {
            a(this.pka, false, this.name, this.ylf);
        } else if (this.ylg) {
            if (!(this.pka && this.yle.equals(this.fWA))) {
                z = false;
            }
            String str = this.fWB;
            boolean z2 = this.ylf;
            this.yll.setVisibility(0);
            YU(str);
            this.yln.setVisibility(0);
            this.ylq.setVisibility(8);
            if (z) {
                this.ylm.setVisibility(8);
                this.ylp.setVisibility(8);
                this.qle.setVisibility(8);
                this.ylo.nB(z2);
                this.ylo.zvp = new 13(this);
                return;
            }
            this.ylm.setVisibility(0);
            this.ylp.setVisibility(0);
            this.qle.setVisibility(0);
            this.ylo.nB(z2);
            this.ylo.zvp = new 2(this);
        } else {
            a(this.pka, true, this.name, this.ylf);
        }
    }

    private void V(boolean z, boolean z2) {
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        if (z2) {
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = 33;
            wlVar.wgM = i;
            ar.Hg();
            c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
            a.ift.um();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent != null) {
            switch (i) {
                case 100:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    String string = bundleExtra.getString("ret");
                    String string2 = bundleExtra.getString("limid");
                    String string3 = bundleExtra.getString("liname");
                    String string4 = bundleExtra.getString("liurl");
                    String string5 = bundleExtra.getString("liswitch");
                    if (bh.ov(string)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
                        return;
                    }
                    int VI = bh.VI(string);
                    if (VI != 0) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(VI));
                        h.b(this, getString(VI == 1 ? R.l.dVu : R.l.dVt), null, true);
                        return;
                    } else if (bh.ov(string2)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
                        return;
                    } else {
                        x.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", string2, string3, string4, string5);
                        ar.Hg();
                        c.CU().set(286722, string3);
                        ar.Hg();
                        c.CU().set(286721, string2);
                        ar.Hg();
                        c.CU().set(286723, string4);
                        if (!bh.ov(string5)) {
                            V(bh.VI(string5) == 1, false);
                        }
                        WT();
                        au();
                        string5 = getString(R.l.dVr);
                        4 4 = new 4(this);
                        h.bu(this, string5);
                        return;
                    }
                default:
                    x.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.kVi != null) {
            this.kVi.dismiss();
            this.kVi = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 549) {
                this.ylk = true;
                if (this.ylj) {
                    i3 = R.l.dVs;
                } else {
                    i3 = R.l.dVr;
                }
            } else if (kVar.getType() == 550) {
                i3 = R.l.dVz;
            } else {
                return;
            }
            String string = getString(i3);
            5 5 = new 5(this);
            h.bu(this, string);
            WT();
            this.ylf = this.ylo.zvg;
            au();
            return;
        }
        if (kVar.getType() == 549) {
            if (i2 == 1) {
                i3 = R.l.dVu;
            } else {
                i3 = R.l.dVt;
            }
        } else if (kVar.getType() == 550) {
            i3 = R.l.dVv;
        } else {
            return;
        }
        h.b(this, getString(i3), null, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
