package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public class LoginIndepPass extends MMActivity implements e {
    private String fIG;
    private String hNv;
    private ProgressDialog iln = null;
    private String pRM;
    private String pRQ;
    private SecurityImage xKa = null;
    private c xNR = new 1(this);
    private f xOA = new f();
    private String xOC;
    private String xOD;
    private EditText xPe;
    private String xPf;
    private Button xPg;
    private r xPh;

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        if (bh.ov(str)) {
            h.h(loginIndepPass, R.l.eSP, R.l.etw);
        } else if (bh.ov(str2)) {
            h.h(loginIndepPass, R.l.eSM, R.l.etw);
        } else {
            loginIndepPass.xPe.setText(str2);
            loginIndepPass.aWs();
            ar.CG().a(701, loginIndepPass);
            k vVar = new v(str, str2, null, 1);
            ar.CG().a(vVar, 0);
            loginIndepPass.getString(R.l.dGO);
            loginIndepPass.iln = h.a(loginIndepPass, loginIndepPass.getString(R.l.etF), true, new 2(loginIndepPass, vVar));
        }
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        if (bh.ov(loginIndepPass.xPe.getText().toString().trim())) {
            loginIndepPass.enableOptionMenu(false);
        } else {
            loginIndepPass.enableOptionMenu(true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dmN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.ety);
        if (d.vAC) {
            string = getString(R.l.app_name) + getString(R.l.dDD);
        }
        setMMTitle(string);
        this.xPf = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.xPf != null) {
            this.hNv = ao.Vk(this.xPf);
        }
        a.ift.up();
        this.pRQ = b.Xn();
        initView();
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        b.b(true, ar.CB() + "," + getClass().getName() + ",L200_200," + ar.fH("L200_200") + ",1");
        b.oG("L200_200");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
        b.b(false, ar.CB() + "," + getClass().getName() + ",L200_200," + ar.fH("L200_200") + ",2");
    }

    public void onDestroy() {
        ar.CG().b(701, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.xPe = (EditText) findViewById(R.h.cpJ);
        this.xPg = (Button) findViewById(R.h.cut);
        enableOptionMenu(false);
        addTextOptionMenu(0, getString(R.l.etA), new 9(this));
        this.xPe.addTextChangedListener(new 10(this));
        this.xPe.setOnEditorActionListener(new 11(this));
        this.xPe.setOnKeyListener(new 12(this));
        this.xPg.setText(getString(R.l.etD));
        this.xPg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginIndepPass xPi;

            {
                this.xPi = r1;
            }

            public final void onClick(View view) {
                h.a(this.xPi, this.xPi.getString(R.l.eDX) + this.xPi.xPf, this.xPi.getString(R.l.eDY), new 1(this), new 2(this));
            }
        });
        setBackBtn(new 14(this));
        this.pRM = getIntent().getStringExtra("auth_ticket");
        if (!bh.ov(this.pRM)) {
            new af().postDelayed(new Runnable(this) {
                final /* synthetic */ LoginIndepPass xPi;

                {
                    this.xPi = r1;
                }

                public final void run() {
                    LoginIndepPass.a(this.xPi, f.cnT(), f.cnU());
                }
            }, 500);
        }
    }

    private void afF() {
        String obj = this.xPe.getText().toString();
        if (bh.ov(this.hNv)) {
            h.h(this, R.l.eSP, R.l.etw);
        } else if (obj.equals("")) {
            h.h(this, R.l.eSM, R.l.etw);
        } else {
            aWs();
            ar.CG().a(701, this);
            k vVar = new v(this.hNv, obj, null, 1);
            ar.CG().a(vVar, 0);
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.etF), true, new 16(this, vVar));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (this.xPh != null) {
            this.xPh.dismiss();
            this.xPh = null;
        }
        if (kVar.getType() == 701) {
            this.fIG = ((v) kVar).RY();
            ar.CG().b(701, this);
            this.xOA.xPq = ((v) kVar).Op();
            this.xOA.xPs = ((v) kVar).Oo();
            this.xOA.xPr = ((v) kVar).Sa();
            this.xOA.xPt = ((v) kVar).RZ();
            this.xOA.hNv = this.hNv;
            this.xOA.xPo = this.xPe.getText().toString();
            if (i2 == -75) {
                m.bE(this.mController.xIM);
            } else if (i2 == -106) {
                m.b(this, str, 0);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else if (i2 == -205) {
                this.pRM = ((v) kVar).NX();
                this.xOC = ((v) kVar).Sb();
                this.xOD = ((v) kVar).Se();
                x.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bh.VT(this.pRM), this.xOD});
                f.a(this.xOA);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.pRM);
                intent.putExtra("binded_mobile", this.xOC);
                intent.putExtra("close_safe_device_style", this.xOD);
                intent.putExtra("from_source", 5);
                a.ifs.g(this, intent);
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    ar.CG().a(new bd(new 3(this)), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    ar.CG().a(701, this);
                    if (this.xKa == null) {
                        this.xKa = SecurityImage.a.a(this.mController.xIM, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new 4(this), null, new 5(this), this.xOA);
                        return;
                    }
                    x.d("MicroMsg.LoginIndepPass", "imgSid:" + this.xOA.xPq + " img len" + this.xOA.xPs.length + " " + g.zh());
                    this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
                } else if (z || (i == 0 && i2 == 0)) {
                    ar.unhold();
                    m.or(this.xOA.hNv);
                    com.tencent.mm.modelsimple.d.bq(this);
                    m.a(this, new 6(this), false, 2);
                } else if (!o(i, i2, str)) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                        if (eA != null && eA.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (!bh.ov(this.fIG)) {
                m.j(this, str, this.fIG);
            }
        } else if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX) {
            ar.CG().b(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
            String NY = ((s) kVar).NY();
            if (i2 == -41) {
                h.h(this, R.l.eDE, R.l.eDF);
            } else if (i2 == -75) {
                h.b(this, getString(R.l.dDF), "", true);
            } else {
                b.oH("L3");
                b.b(true, ar.CB() + "," + getClass().getName() + ",L3," + ar.fH("L3") + ",1");
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.xPf);
                intent2.putExtra("bindmcontact_shortmobile", NY);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("login_type", 3);
                intent2.putExtra("mobileverify_countdownsec", ((s) kVar).Od());
                intent2.putExtra("mobileverify_countdownstyle", ((s) kVar).Oe());
                intent2.putExtra("mobileverify_fb", ((s) kVar).Of());
                a(MobileVerifyUI.class, intent2);
            }
        } else if (!o(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean o(int i, int i2, String str) {
        if (a.ift.a(this.mController.xIM, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bh.ov(this.fIG)) {
                    m.j(this.mController.xIM, str, this.fIG);
                }
                return true;
            case -100:
                ar.hold();
                h.a(this.mController.xIM, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this.mController.xIM, R.l.euu) : ar.Ci(), this.mController.xIM.getString(R.l.dGO), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginIndepPass xPi;

                    {
                        this.xPi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new 8(this));
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
            default:
                return false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
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
