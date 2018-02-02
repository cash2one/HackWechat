package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.accountsync.a.b;
import com.tencent.mm.plugin.accountsync.a.b.1;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public class SimpleLoginUI extends MMWizardActivity implements e {
    private TextWatcher XD = new 1(this);
    private String fIG = "";
    private ProgressDialog iln = null;
    private String pRM;
    private SecurityImage xKa = null;
    private c xNR = new 12(this);
    private f xOA = new f();
    private String xOC;
    private String xOD;
    private ResizeLayout xOH;
    private MMClearEditText xPA;
    private MMFormInputView xPB;
    private MMFormInputView xPC;
    private Button xPD;
    private MMKeyboardUperView xPH;
    private MMClearEditText xPz;

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        if (bh.ov(simpleLoginUI.xPz.getText().toString()) || bh.ov(simpleLoginUI.xPA.getText().toString())) {
            simpleLoginUI.xPD.setEnabled(false);
        } else {
            simpleLoginUI.xPD.setEnabled(true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dmL;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", 4);
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle(R.l.app_name);
        if (a.ift != null) {
            a.ift.up();
        }
        initView();
        ar.CG().a(701, this);
        x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE"))});
        if (com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.READ_PHONE_STATE"))});
            if (com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.READ_PHONE_STATE")) {
                z = true;
            }
        }
        if (!z) {
            new Intent().addFlags(67108864);
            a.ifs.s(new Intent(), this);
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
    }

    public void onDestroy() {
        ar.CG().b(701, this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.pRM = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.pRM = extras.getString("auth_ticket");
        }
        if (!bh.ov(this.pRM)) {
            this.xPz.setText(bh.ou(f.cnT()));
            this.xPA.setText(bh.ou(f.cnU()));
            new af().postDelayed(new 13(this), 500);
        }
    }

    protected final void initView() {
        this.xPB = (MMFormInputView) findViewById(R.h.cuh);
        this.xPC = (MMFormInputView) findViewById(R.h.cuq);
        this.xPz = (MMClearEditText) this.xPB.pqM;
        this.xPz.setFocusableInTouchMode(false);
        this.xPz.setOnTouchListener(new 14(this));
        this.xPA = (MMClearEditText) this.xPC.pqM;
        this.xPA.setFocusableInTouchMode(false);
        this.xPA.setOnTouchListener(new 15(this));
        com.tencent.mm.ui.tools.a.c.d(this.xPA).GN(16).a(null);
        this.xPD = (Button) findViewById(R.h.cuj);
        this.xPD.setEnabled(false);
        this.xPz.addTextChangedListener(this.XD);
        this.xPA.addTextChangedListener(this.XD);
        this.xPA.setOnEditorActionListener(new 16(this));
        this.xPA.setOnKeyListener(new 17(this));
        this.xOH = (ResizeLayout) findViewById(R.h.cHL);
        this.xPH = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xOH.xSs = new 18(this);
        this.xPH.setOnTouchListener(new 19(this));
        findViewById(R.h.cuk).setVisibility(8);
        View findViewById = findViewById(R.h.chx);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        setMMTitle(R.l.cuu);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SimpleLoginUI xSL;

            {
                this.xSL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xSL.bov();
                return true;
            }
        });
        this.pRM = getIntent().getStringExtra("auth_ticket");
        if (!bh.ov(this.pRM)) {
            this.xPz.setText(bh.ou(f.cnT()));
            this.xPA.setText(bh.ou(f.cnU()));
            new af().postDelayed(new 3(this), 500);
        }
        if (f.xeC) {
            a.ift.e(this);
        }
        this.xPD.setOnClickListener(new 4(this));
    }

    private void bov() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        DU(1);
        if (booleanExtra) {
            exit(1);
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
            k vVar = new v(this.xOA.hNv, this.xOA.xPo, this.pRM, 0);
            ar.CG().a(vVar, 0);
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.etF), true, new 5(this, vVar));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    protected void onPause() {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        com.tencent.mm.ae.f bVar;
        x.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        x.d("MicroMsg.SimpleLoginUI", "Scene Type " + kVar.getType());
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        this.fIG = ((v) kVar).RY();
        if (kVar.getType() == 701) {
            this.xOA.xPt = ((v) kVar).RZ();
            this.xOA.xPq = ((v) kVar).Op();
            this.xOA.xPs = ((v) kVar).Oo();
            this.xOA.xPr = ((v) kVar).Sa();
            if (i2 == -205) {
                this.pRM = ((v) kVar).NX();
                this.xOC = ((v) kVar).Sb();
                this.xOD = ((v) kVar).Se();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                ar.CG().a(new bd(new 10(this)), 0);
                if (obj == null || (i == 0 && i2 == 0)) {
                    ar.unhold();
                    d.bq(this);
                    m.or(this.xOA.hNv);
                    bVar = new b(this.mController.xIM, new 11(this));
                    bVar.frb = a.ift.a(bVar);
                    if (bVar.frb == null) {
                        if (bVar.frb.getType() == com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX) {
                            ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, bVar);
                        } else if (bVar.frb.getType() == 138) {
                            ar.CG().a(138, bVar);
                        }
                        ar.CG().a(bVar.frb, 0);
                        Context context = bVar.context;
                        bVar.context.getString(R.l.dGO);
                        bVar.tipDialog = h.a(context, bVar.context.getString(R.l.dFy), true, new 1(bVar));
                    } else if (bVar.ikC != null) {
                        bVar.ikC.Xo();
                    }
                } else if (i2 == -217) {
                    m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
                    return;
                } else {
                    if (a.ift.a(this.mController.xIM, i, i2, str)) {
                        obj = 1;
                    } else {
                        if (i == 4) {
                            switch (i2) {
                                case -311:
                                case -310:
                                case -6:
                                    if (this.xKa == null) {
                                        this.xKa = SecurityImage$a.a(this.mController.xIM, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new 6(this), null, new 7(this), this.xOA);
                                    } else {
                                        x.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.xOA.xPq + " img len" + this.xOA.xPs.length + " " + g.zh());
                                        this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
                                    }
                                    obj = 1;
                                    break;
                                case -205:
                                    x.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bh.VT(this.pRM), this.xOD});
                                    f.a(this.xOA);
                                    Intent intent = new Intent();
                                    intent.putExtra("auth_ticket", this.pRM);
                                    intent.putExtra("binded_mobile", this.xOC);
                                    intent.putExtra("close_safe_device_style", this.xOD);
                                    intent.putExtra("from_source", 3);
                                    a.ifs.g(this, intent);
                                    obj = 1;
                                    break;
                                case -140:
                                    if (!bh.ov(this.fIG)) {
                                        m.j(this, str, this.fIG);
                                    }
                                    obj = 1;
                                    break;
                                case -106:
                                    m.b(this, str, 0);
                                    obj = 1;
                                    break;
                                case -100:
                                    ar.hold();
                                    h.a(this, ar.Ci(), getString(R.l.dGO), new 8(this), new 9(this));
                                    obj = 1;
                                    break;
                                case -75:
                                    m.bE(this.mController.xIM);
                                    obj = 1;
                                    break;
                                case -72:
                                    h.h(this.mController.xIM, R.l.eEb, R.l.dGO);
                                    obj = 1;
                                    break;
                                case -30:
                                case -4:
                                case -3:
                                    h.h(this, R.l.ecj, R.l.etw);
                                    obj = 1;
                                    break;
                                case -9:
                                    h.h(this, R.l.etv, R.l.etw);
                                    obj = 1;
                                    break;
                                case -1:
                                    if (ar.CG().Km() == 5) {
                                        h.h(this, R.l.exG, R.l.exF);
                                        obj = 1;
                                        break;
                                    }
                            }
                        }
                        obj = null;
                    }
                    if (obj == null) {
                        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                        if (eA == null || !eA.a(this, null, null)) {
                            Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        obj = null;
        if (obj == null) {
        }
        ar.unhold();
        d.bq(this);
        m.or(this.xOA.hNv);
        bVar = new b(this.mController.xIM, new 11(this));
        bVar.frb = a.ift.a(bVar);
        if (bVar.frb == null) {
            if (bVar.frb.getType() == com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX) {
                ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, bVar);
            } else if (bVar.frb.getType() == 138) {
                ar.CG().a(138, bVar);
            }
            ar.CG().a(bVar.frb, 0);
            Context context2 = bVar.context;
            bVar.context.getString(R.l.dGO);
            bVar.tipDialog = h.a(context2, bVar.context.getString(R.l.dFy), true, new 1(bVar));
        } else if (bVar.ikC != null) {
            bVar.ikC.Xo();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
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
                afF();
            }
        }
    }
}
