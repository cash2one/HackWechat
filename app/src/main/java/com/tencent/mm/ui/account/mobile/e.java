package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.ShowAgreementsUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bq;
import com.tencent.mm.z.q;

public final class e implements com.tencent.mm.ae.e, b {
    private String fIG;
    String hNv;
    String mBX;
    private String pRM;
    private String qgX;
    SecurityImage xKa = null;
    private boolean xOP = true;
    private int xOU;
    private String xOV;
    private String xOW;
    private String xOX;
    private int xOY;
    MobileInputUI xTM;
    int xTR;

    static /* synthetic */ void a(e eVar, String str) {
        k sVar = new s(str, 16, "", 0, "");
        ar.CG().a(sVar, 0);
        MobileInputUI mobileInputUI = eVar.xTM;
        Context context = eVar.xTM;
        eVar.xTM.getString(R.l.dGO);
        mobileInputUI.xPh = h.a(context, eVar.xTM.getString(R.l.dHc), true, new 14(eVar, sVar));
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.xTM = mobileInputUI;
        mobileInputUI.xUc.setVisibility(0);
        this.hNv = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (bh.ov(this.hNv)) {
            this.hNv = ao.Vk(mobileInputUI.xUe + mobileInputUI.phQ);
        }
        mobileInputUI.xTY.setTextColor(mobileInputUI.getResources().getColor(R.e.bsO));
        mobileInputUI.xTY.setEnabled(false);
        mobileInputUI.xTY.setFocusable(false);
        mobileInputUI.xTX.setFocusable(false);
        mobileInputUI.xTX.setText(ao.Vk(this.hNv));
        mobileInputUI.xTX.setVisibility(0);
        biE();
        mobileInputUI.xUd.setVisibility(0);
        mobileInputUI.xQo.setText(R.l.etA);
        mobileInputUI.xQo.setVisibility(0);
        mobileInputUI.xQo.setEnabled(true);
        this.qgX = aq.hfP.H("login_weixin_username", "");
        this.pRM = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!bh.ov(this.pRM)) {
            new af().postDelayed(new 1(this), 500);
        }
    }

    private void biE() {
        if (this.xTM.hgg == 6) {
            this.xTM.xTZ.reset();
            this.xTM.xUd.setText(R.l.etC);
            this.xTM.xPC.setVisibility(8);
            this.xTM.xTZ.setVisibility(0);
            this.xTM.xTZ.pqM.requestFocus();
            this.xTM.xTZ.yaE = new 10(this);
            this.xTM.xUd.setOnClickListener(new 11(this));
        } else if (this.xTM.hgg == 7) {
            this.xTM.xUd.setText(R.l.etD);
            this.xTM.xPC.setVisibility(0);
            this.xTM.lTk.requestFocus();
            this.xTM.xTZ.setVisibility(8);
            this.xTM.xUd.setOnClickListener(new 12(this));
        }
    }

    public final void start() {
        ar.CG().a(701, this);
        ar.CG().a(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",L200_100," + ar.fH("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.oG("L200_100");
    }

    public final void stop() {
        ar.CG().b(701, this);
        ar.CG().b(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + ",L200_100," + ar.fH("L200_100") + ",2");
    }

    public final void Ei(int i) {
        switch (9.xTO[i - 1]) {
            case 1:
                this.xTM.aWs();
                switch (this.xTR) {
                    case 1:
                        cnQ();
                        return;
                    case 2:
                        cow();
                        return;
                    default:
                        if (this.xOU == -355) {
                            m.b(this.xTM, this.xOV, 32046);
                            return;
                        } else if (this.xOU == -30) {
                            cow();
                            return;
                        } else {
                            this.xTM.xUe = ao.Vm(this.xTM.countryCode);
                            this.xTM.phQ = this.xTM.xTY.getText().toString();
                            if (!bh.ov(this.xTM.xUe) && !bh.ov(this.xTM.phQ)) {
                                if (this.xTM.hgg == 7) {
                                    if (bh.ov(this.mBX)) {
                                        fL(this.hNv, this.xTM.lTk.getText().toString());
                                        return;
                                    } else {
                                        fL(this.hNv, this.mBX);
                                        return;
                                    }
                                } else if (this.xTM.hgg == 6) {
                                    String trim = this.xTM.xTZ.getText().toString().trim();
                                    if (bh.ov(trim)) {
                                        h.h(this.xTM, R.l.eSO, R.l.etw);
                                        return;
                                    }
                                    this.xTM.aWs();
                                    k sVar = new s(this.hNv, 17, trim, 0, "");
                                    ar.CG().a(sVar, 0);
                                    MobileInputUI mobileInputUI = this.xTM;
                                    Context context = this.xTM;
                                    this.xTM.getString(R.l.dGO);
                                    mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.dLx), true, new 13(this, sVar));
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                }
            default:
                return;
        }
    }

    private void fL(String str, String str2) {
        if (bh.ov(str)) {
            h.h(this.xTM, R.l.eSP, R.l.etw);
        } else if (bh.ov(str2)) {
            h.h(this.xTM, R.l.eSM, R.l.etw);
        } else {
            this.xTM.lTk.setText(str2);
            this.xTM.aWs();
            k vVar = new v(str, str2, null, 1);
            ar.CG().a(vVar, 0);
            MobileInputUI mobileInputUI = this.xTM;
            Context context = this.xTM;
            this.xTM.getString(R.l.dGO);
            mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.etF), true, new 15(this, vVar));
        }
    }

    private void cow() {
        Intent intent = new Intent();
        intent.putExtra("regsetinfo_ticket", this.xOX);
        intent.putExtra("regsetinfo_user", this.hNv);
        intent.putExtra("regsession_id", this.xOW);
        intent.putExtra("regsetinfo_ismobile", 1);
        intent.putExtra("regsetinfo_NextControl", this.xOY);
        intent.setClass(this.xTM, RegSetInfoUI.class);
        com.tencent.mm.plugin.c.b.oH("R200_950_olduser");
        this.xTM.startActivity(intent);
        com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",L200_900_phone," + ar.fH("L200_900_phone") + ",2");
    }

    final void cnQ() {
        Intent intent = new Intent(this.xTM, ShowAgreementsUI.class);
        intent.putExtra("agreement_type", 0);
        this.xTM.startActivityForResult(intent, 32047);
    }

    public final void a(int i, int i2, String str, k kVar) {
        a eA;
        x.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xTM.xPh != null) {
            this.xTM.xPh.dismiss();
            this.xTM.xPh = null;
        }
        String string;
        if (kVar.getType() == c.CTRL_INDEX) {
            int IS = ((s) kVar).IS();
            if (IS == 16) {
                if (i2 == -41) {
                    this.xTM.xTZ.reset();
                    h.h(this.xTM, R.l.eDE, R.l.eDF);
                    return;
                } else if (i2 == -75) {
                    this.xTM.xTZ.reset();
                    h.b(this.xTM, this.xTM.getString(R.l.dDF), "", true);
                    return;
                }
            } else if (IS == 17) {
                this.xOU = i2;
                this.xOV = str;
                if (i == 0 && i2 == 0) {
                    new a(new 16(this), ((s) kVar).getUsername(), ((s) kVar).NV(), this.hNv).j(this.xTM);
                    return;
                }
                this.xOW = ((s) kVar).Ok();
                this.xOX = ((s) kVar).NW();
                this.xOY = ((s) kVar).Oc();
                if (i2 == -355 || i2 == -30) {
                    com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",L200_900_phone," + ar.fH("L200_900_phone") + ",1");
                    if (d.vAC) {
                        string = this.xTM.getString(R.l.dXK, new Object[]{"0x" + Integer.toHexString(d.vAz), w.cfi()});
                        x.e("MicroMsg.MobileInputIndepPassLoginLogic", "url " + string);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", string);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        intent.putExtra("neverGetA8Key", true);
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                        com.tencent.mm.plugin.c.a.ifs.j(intent, this.xTM);
                        return;
                    } else if (i2 == -355) {
                        cnQ();
                        return;
                    } else {
                        eA = a.eA(str);
                        if (eA != null) {
                            eA.a(this.xTM, new 17(this), null);
                            return;
                        }
                        return;
                    }
                } else if (i2 == -51) {
                    eA = a.eA(str);
                    if (eA != null) {
                        eA.a(this.xTM, null, null);
                        return;
                    } else {
                        h.h(this.xTM, R.l.eDb, R.l.bNB);
                        return;
                    }
                } else if (o(i, i2, str)) {
                    return;
                }
            }
        } else if (kVar.getType() == 701) {
            this.fIG = ((v) kVar).RY();
            final SecurityImage$b fVar = new f();
            fVar.xPq = ((v) kVar).Op();
            fVar.xPs = ((v) kVar).Oo();
            fVar.xPr = ((v) kVar).Sa();
            fVar.xPt = ((v) kVar).RZ();
            fVar.hNv = ((v) kVar).hNv;
            fVar.xPo = this.xTM.lTk.getText().toString();
            if (i2 == -75) {
                m.bE(this.xTM);
                return;
            } else if (i2 == -106) {
                m.b(this.xTM, str, 32045);
                return;
            } else if (i2 == -217) {
                m.a(this.xTM, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
                return;
            } else if (i2 == -205) {
                this.pRM = ((v) kVar).NX();
                string = ((v) kVar).Sb();
                x.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bh.VT(this.pRM), ((v) kVar).Se()});
                f.a(fVar);
                Intent intent2 = new Intent();
                intent2.putExtra("auth_ticket", this.pRM);
                intent2.putExtra("binded_mobile", string);
                intent2.putExtra("close_safe_device_style", r3);
                intent2.putExtra("from_source", 6);
                com.tencent.mm.plugin.c.a.ifs.g(this.xTM, intent2);
                return;
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    ar.CG().a(new bd(new 2(this)), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.xKa == null) {
                        this.xKa = SecurityImage.a.a(this.xTM, R.l.eEi, fVar.xPt, fVar.xPs, fVar.xPq, fVar.xPr, new OnClickListener(this) {
                            final /* synthetic */ e xTT;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                x.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.xPq + " img len" + fVar.xPs.length + " " + g.zh());
                                k vVar = new v(fVar.hNv, fVar.xPo, fVar.xPt, this.xTT.xKa.coF(), this.xTT.xKa.xPq, this.xTT.xKa.xPr, 1, "", false, false);
                                ar.CG().a(vVar, 0);
                                MobileInputUI mobileInputUI = this.xTT.xTM;
                                Context context = this.xTT.xTM;
                                this.xTT.xTM.getString(R.l.dGO);
                                mobileInputUI.xPh = h.a(context, this.xTT.xTM.getString(R.l.etF), true, new 1(this, vVar));
                            }
                        }, null, new 4(this), fVar);
                        return;
                    }
                    x.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.xPq + " img len" + fVar.xPs.length + " " + g.zh());
                    this.xKa.a(fVar.xPt, fVar.xPs, fVar.xPq, fVar.xPr);
                    return;
                } else if (z || (i == 0 && i2 == 0)) {
                    ar.unhold();
                    x.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[]{fVar.hNv});
                    m.or(fVar.hNv);
                    string = aq.hfP.H("login_weixin_username", "");
                    com.tencent.mm.modelsimple.d.bq(this.xTM);
                    if (this.xTM.xPG) {
                        bq.hhK.V(this.qgX, string);
                        bq.hhK.c(q.FS(), q.GB());
                        com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(9)});
                    }
                    m.a(this.xTM, new Runnable(this) {
                        final /* synthetic */ e xTT;

                        {
                            this.xTT = r1;
                        }

                        public final void run() {
                            x.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
                            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this.xTT.xTM);
                            at.addFlags(67108864);
                            this.xTT.xTM.startActivity(at);
                            this.xTT.xTM.finish();
                        }
                    }, false, 2);
                    if (this.xTM.hgg == 6) {
                        this.xOP = ((v) kVar).Sg();
                        ar.CG().a(255, this);
                        final k xVar = new com.tencent.mm.modelsimple.x(1);
                        ar.CG().a(xVar, 0);
                        MobileInputUI mobileInputUI = this.xTM;
                        Context context = this.xTM;
                        this.xTM.getString(R.l.dGO);
                        mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eLF), true, new OnCancelListener(this) {
                            final /* synthetic */ e xTT;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ar.CG().c(xVar);
                                ar.CG().b(255, this.xTT);
                            }
                        });
                        return;
                    }
                    return;
                } else if (!o(i, i2, str)) {
                    if (!(i == 0 && i2 == 0)) {
                        Toast.makeText(this.xTM, this.xTM.getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                } else {
                    return;
                }
            } else if (!bh.ov(this.fIG)) {
                m.j(this.xTM, str, this.fIG);
                return;
            } else {
                return;
            }
        } else if (kVar.getType() == 255) {
            ar.CG().b(255, this);
            if (i != 0 || i2 != 0) {
                Context context2 = this.xTM;
                boolean z2 = this.xOP;
                Intent intent3 = new Intent(context2, RegByMobileSetPwdUI.class);
                intent3.putExtra("kintent_hint", context2.getString(R.l.eLU));
                intent3.putExtra("kintent_cancelable", z2);
                context2.startActivity(intent3);
                return;
            }
            return;
        }
        eA = a.eA(str);
        if (eA != null && this.xTM != null && eA.a(this.xTM, null, null)) {
        }
    }

    private boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ift.a(this.xTM, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bh.ov(this.fIG)) {
                    m.j(this.xTM, str, this.fIG);
                }
                return true;
            case -100:
                String ac;
                ar.hold();
                Context context = this.xTM;
                if (TextUtils.isEmpty(ar.Ci())) {
                    ac = com.tencent.mm.bv.a.ac(this.xTM, R.l.euu);
                } else {
                    ac = ar.Ci();
                }
                h.a(context, ac, this.xTM.getString(R.l.dGO), new 7(this), new 8(this));
                return true;
            case -34:
                Toast.makeText(this.xTM, R.l.dKT, 0).show();
                return true;
            case -33:
                h.a(this.xTM, R.l.dLA, R.l.bNB, null);
                return true;
            case -32:
                h.a(this.xTM, R.l.dLC, R.l.bNB, null);
                return true;
            case -9:
                h.h(this.xTM, R.l.etv, R.l.etw);
                return true;
            case -4:
            case -3:
                h.h(this.xTM, R.l.ecj, R.l.etw);
                return true;
            case -1:
                if (ar.CG().Km() != 5) {
                    return false;
                }
                h.h(this.xTM, R.l.exG, R.l.exF);
                return true;
            default:
                return false;
        }
    }
}
