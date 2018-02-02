package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bq;
import com.tencent.mm.z.q;

public class LoginUI extends MMActivity implements e {
    private TextWatcher XD = new TextWatcher(this) {
        final /* synthetic */ LoginUI xPJ;

        {
            this.xPJ = r1;
        }

        public final void afterTextChanged(Editable editable) {
            LoginUI.a(this.xPJ);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String fIG = "";
    private String frP = null;
    private ProgressDialog iln = null;
    private g jLx;
    private String pRM;
    private String pRQ;
    private String qgX;
    private int sceneType = 0;
    private SecurityImage xKa = null;
    private c xNR = new 12(this);
    private f xOA = new f();
    private String xOC;
    private String xOD;
    private ResizeLayout xOH;
    private a xOK;
    protected Button xOw;
    protected Button xOx;
    private View xOy;
    protected Button xOz;
    private MMClearEditText xPA;
    private MMFormInputView xPB;
    private MMFormInputView xPC;
    private Button xPD;
    private Button xPE;
    protected View xPF;
    private boolean xPG;
    private MMKeyboardUperView xPH;
    private boolean xPI = false;
    private MMClearEditText xPz;

    static /* synthetic */ void a(LoginUI loginUI) {
        if (bh.ov(loginUI.xPz.getText().toString()) || bh.ov(loginUI.xPA.getText().toString())) {
            loginUI.xPD.setEnabled(false);
        } else {
            loginUI.xPD.setEnabled(true);
        }
    }

    static /* synthetic */ void m(LoginUI loginUI) {
        com.tencent.mm.kernel.g.Dk().fM("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        com.tencent.mm.plugin.c.a.ifs.s(intent, loginUI);
    }

    protected final int getLayoutId() {
        return R.i.dmL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "";
        if (d.vAC) {
            str = getString(R.l.app_name) + getString(R.l.dDD);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        com.tencent.mm.plugin.c.a.ift.up();
        this.pRQ = b.Xn();
        initView();
        this.xOK = new a();
        this.xPG = getIntent().getBooleanExtra("from_switch_account", false);
        this.qgX = aq.hfP.H("login_weixin_username", "");
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14262, new Object[]{Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4])});
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        if (this.sceneType == 0) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",L100_100_logout," + ar.fH("L100_100_logout") + ",1");
            b.oG("L100_100_logout");
        } else if (this.sceneType == 1) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",L400_100_login," + ar.fH("L400_100_login") + ",1");
            b.oG("L400_100_login");
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
        if (this.sceneType == 0) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",L100_100_logout," + ar.fH("L100_100_logout") + ",2");
        } else if (this.sceneType == 1) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",L400_100_login," + ar.fH("L400_100_login") + ",2");
        }
    }

    public void onDestroy() {
        if (this.xOK != null) {
            this.xOK.close();
        }
        ar.CG().b(701, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.xPB = (MMFormInputView) findViewById(R.h.cuh);
        this.xPC = (MMFormInputView) findViewById(R.h.cuq);
        this.xPz = (MMClearEditText) this.xPB.pqM;
        this.xPz.setFocusableInTouchMode(false);
        this.xPz.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LoginUI xPJ;

            {
                this.xPJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.xPJ.xPz.setFocusableInTouchMode(true);
                return this.xPJ.xPz.sqw.onTouch(view, motionEvent);
            }
        });
        this.xPA = (MMClearEditText) this.xPC.pqM;
        this.xPA.setFocusableInTouchMode(false);
        this.xPA.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LoginUI xPJ;

            {
                this.xPJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.xPJ.xPA.setFocusableInTouchMode(true);
                this.xPJ.xPz.setFocusableInTouchMode(false);
                return this.xPJ.xPA.sqw.onTouch(view, motionEvent);
            }
        });
        com.tencent.mm.ui.tools.a.c.d(this.xPA).GN(16).a(null);
        this.xPD = (Button) findViewById(R.h.cuj);
        this.xPD.setEnabled(false);
        this.xPE = (Button) findViewById(R.h.cuk);
        this.xPF = findViewById(R.h.cui);
        this.xPF.setVisibility(0);
        this.xOw = (Button) findViewById(R.h.cun);
        this.xOy = findViewById(R.h.cjf);
        this.xOx = (Button) findViewById(R.h.cuo);
        this.xOz = (Button) findViewById(R.h.cup);
        this.xOH = (ResizeLayout) findViewById(R.h.cHL);
        this.xPH = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xOH.xSs = new ResizeLayout$a(this) {
            final /* synthetic */ LoginUI xPJ;

            {
                this.xPJ = r1;
            }

            public final void cnS() {
                this.xPJ.xPH.post(new 1(this));
            }
        };
        this.xPH.setOnTouchListener(new 26(this));
        boolean PQ = com.tencent.mm.ar.b.PQ();
        View findViewById = findViewById(R.h.chx);
        findViewById.setVisibility(!PQ ? 8 : 0);
        findViewById.setOnClickListener(new 27(this));
        this.xOw.setOnClickListener(new 28(this));
        this.xOx.setOnClickListener(new 29(this));
        this.jLx = new g(this, g.ztp, false);
        this.jLx.rKC = new 2(this);
        this.jLx.ztB = new g.a(this) {
            final /* synthetic */ LoginUI xPJ;

            {
                this.xPJ = r1;
            }

            public final void onDismiss() {
                this.xPJ.jLx.bxh();
            }
        };
        this.jLx.rKD = new 4(this);
        if (w.cff()) {
            this.xOz.setOnClickListener(new 5(this));
        } else {
            this.xOy.setVisibility(8);
            this.xOz.setText(R.l.etr);
            this.xOz.setOnClickListener(new 6(this));
        }
        setMMTitle("");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.btq));
        getSupportActionBar().getCustomView().findViewById(R.h.divider).setVisibility(8);
        setBackBtn(new 7(this), R.k.duV);
        this.xPD.setOnClickListener(new 8(this));
        this.xPE.setOnClickListener(new 9(this));
        this.pRM = getIntent().getStringExtra("auth_ticket");
        if (!bh.ov(this.pRM)) {
            this.xPz.setText(bh.ou(f.cnT()));
            this.xPA.setText(bh.ou(f.cnU()));
            new af().postDelayed(new 10(this), 500);
        }
        this.xPz.addTextChangedListener(this.XD);
        this.xPA.addTextChangedListener(this.XD);
        this.xPA.setOnEditorActionListener(new 11(this));
        this.xPA.setOnKeyListener(new 13(this));
        if (f.xeC) {
            com.tencent.mm.plugin.c.a.ift.e(this);
        }
        CharSequence stringExtra = getIntent().getStringExtra("login_username");
        this.xPI = getIntent().getBooleanExtra("from_deep_link", false);
        if (!bh.ov(stringExtra)) {
            this.xPz.setText(stringExtra);
        }
    }

    private static void bp(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        com.tencent.mm.bm.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        aWs();
        b.oH(this.pRQ);
        p.bYM();
        finish();
    }

    private boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    ar.CG().a(701, this);
                    if (this.xKa == null) {
                        this.xKa = SecurityImage$a.a(this, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new 14(this), null, new 15(this), this.xOA);
                    } else {
                        x.d("MicroMsg.LoginUI", "imgSid:" + this.xOA.xPq + " img len" + this.xOA.xPs.length + " " + com.tencent.mm.compatible.util.g.zh());
                        this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
                    }
                    return true;
                case -205:
                    x.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bh.VT(this.pRM), this.xOD});
                    f.a(this.xOA);
                    b.oH("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.pRM);
                    intent.putExtra("binded_mobile", this.xOC);
                    intent.putExtra("close_safe_device_style", this.xOD);
                    intent.putExtra("from_source", 1);
                    com.tencent.mm.plugin.c.a.ifs.g(this, intent);
                    return true;
                case -140:
                    if (!bh.ov(this.fIG)) {
                        m.j(this, str, this.fIG);
                    }
                    return true;
                case -100:
                    ar.hold();
                    h.a(this.mController.xIM, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this.mController.xIM, R.l.euu) : ar.Ci(), this.mController.xIM.getString(R.l.dGO), new 16(this), new 17(this));
                    return true;
                case -75:
                    m.bE(this.mController.xIM);
                    return true;
                case -72:
                    h.h(this.mController.xIM, R.l.eEb, R.l.dGO);
                    return true;
                case -9:
                    h.h(this, R.l.etv, R.l.etw);
                    return true;
                case -4:
                case -3:
                    h.h(this, R.l.ecj, R.l.etw);
                    return true;
                case -1:
                    if (ar.CG().Km() != 5) {
                        return false;
                    }
                    h.h(this, R.l.exG, R.l.exF);
                    return true;
            }
        }
        return this.xOK.a(this, new o(i, i2, str));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() == 701) {
            boolean z;
            ar.CG().b(701, this);
            this.fIG = ((v) kVar).RY();
            this.xOA.xPq = ((v) kVar).Op();
            this.xOA.xPs = ((v) kVar).Oo();
            this.xOA.xPr = ((v) kVar).Sa();
            this.xOA.xPt = ((v) kVar).RZ();
            this.xOA.hNv = ((v) kVar).hNv;
            if (i2 == -205) {
                this.pRM = ((v) kVar).NX();
                this.xOC = ((v) kVar).Sb();
                this.xOD = ((v) kVar).Se();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ar.CG().a(new bd(new 18(this)), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                ar.unhold();
                m.or(this.xOA.hNv);
                String H = aq.hfP.H("login_weixin_username", "");
                com.tencent.mm.modelsimple.d.bq(this);
                if (this.xPG) {
                    bq.hhK.V(this.qgX, H);
                    bq.hhK.c(q.FS(), q.GB());
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(9)});
                }
                m.a(this, new 19(this, kVar), false, 2);
                b.oI(ar.CB() + "," + getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
                if (this.xPI) {
                    H = ac.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                    com.tencent.mm.plugin.report.service.g.pQN.h(11930, new Object[]{H, Integer.valueOf(4)});
                }
            } else if (i2 == -106) {
                m.b(this, str, 32644);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else if (i2 == -30) {
                if (!d.vAC || d.vAE) {
                    b.oI(ar.CB() + "," + getClass().getName() + ",R400_100_login," + ar.fH("R400_100_login") + ",1");
                    h.a(this, getString(R.l.etI), "", new 20(this, kVar), new OnClickListener(this) {
                        final /* synthetic */ LoginUI xPJ;

                        {
                            this.xPJ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.oI(ar.CB() + "," + this.xPJ.getClass().getName() + ",R400_100_login," + ar.fH("R400_100_login") + ",2");
                        }
                    });
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.fIG);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                com.tencent.mm.plugin.c.a.ifs.j(intent, this);
            } else if (!o(i, i2, str)) {
                if (i2 == -5) {
                    Toast.makeText(this, getString(R.l.etG), 0).show();
                    return;
                }
                if (kVar.getType() == 701) {
                    com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null && eA.a(this, null, null)) {
                        return;
                    }
                }
                Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private void afF() {
        this.xOA.hNv = this.xPz.getText().toString().trim();
        this.xOA.xPo = this.xPA.getText().toString();
        if (this.xOA.hNv.equals("")) {
            h.h(this, R.l.eSP, R.l.etw);
        } else if (this.xOA.xPo.equals("")) {
            h.h(this, R.l.eSM, R.l.etw);
        } else {
            aWs();
            ar.CG().a(701, this);
            k vVar = new v(this.xOA.hNv, this.xOA.xPo, this.pRM, 2);
            ar.CG().a(vVar, 0);
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.etF), true, new 22(this, vVar));
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bpQ);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 != -1) {
            return;
        }
        if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bh.ov(stringExtra));
            if (!bh.ov(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.d(str2, str3, objArr2);
            if (intExtra == -217) {
                this.xOA.xPo = stringExtra;
                afF();
            }
        } else if (i == 32644) {
            if (intent != null && intent.hasExtra("VoiceLoginAuthPwd")) {
                this.xOA.xPo = intent.getStringExtra("VoiceLoginAuthPwd");
            }
            afF();
        }
    }
}
