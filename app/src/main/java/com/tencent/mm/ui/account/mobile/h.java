package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.accountsync.a.c$a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bh;
import java.io.File;
import java.util.Map;

public final class h implements e, b {
    String lcJ;
    a xQO = null;
    MobileVerifyUI xUE;
    String xUL;
    private boolean xUM = true;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.xUE = mobileVerifyUI;
    }

    public final void start() {
        if (bh.HO().HP() == 0) {
            com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",R200_300," + ar.fH("R200_300") + ",1");
            com.tencent.mm.plugin.c.b.oG("R200_300");
            return;
        }
        com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",RE200_300," + ar.fH("RE200_300") + ",1");
        com.tencent.mm.plugin.c.b.oG("RE200_300");
    }

    public final void stop() {
    }

    public final boolean Ej(int i) {
        k sVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (8.xUH[i - 1]) {
            case 1:
                com.tencent.mm.ui.base.h.a(this.xUE, this.xUE.getString(R.l.evp), "", this.xUE.getString(R.l.evq), this.xUE.getString(R.l.evr), new 9(this), new 10(this));
                return true;
            case 2:
                ar.CG().a(c.CTRL_INDEX, this);
                sVar = new s(this.xUE.fAf, 15, this.xUE.xTy.getText().toString().trim(), 0, "");
                sVar.lb(this.xUE.xOW);
                ar.CG().a(sVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = com.tencent.mm.ui.base.h.a(context, this.xUE.getString(R.l.dLx), true, new 11(this, sVar));
                return false;
            case 3:
                com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",R200_400," + ar.fH("R200_400") + ",1");
                if (bh.HO().HP() > 0) {
                    com.tencent.mm.plugin.c.b.oG("RE200_250");
                } else {
                    com.tencent.mm.plugin.c.b.oG("R200_350_auto");
                }
                ar.CG().a(c.CTRL_INDEX, this);
                sVar = new s(this.xUE.fAf, 14, "", 0, "");
                sVar.lb(this.xUE.xOW);
                ar.CG().a(sVar, 0);
                com.tencent.mm.plugin.accountsync.a.c.je(c$a.ikO);
                return false;
            case 4:
                com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",R200_350_auto," + ar.fH("R200_350_auto") + ",1");
                ar.CG().a(c.CTRL_INDEX, this);
                sVar = new s(this.xUE.fAf, 15, this.xUE.xTy.getText().toString().trim(), 0, "");
                sVar.lb(this.xUE.xOW);
                ar.CG().a(sVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = com.tencent.mm.ui.base.h.a(context, this.xUE.getString(R.l.dLx), true, new 1(this, sVar));
                return false;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xUE.iln != null) {
            this.xUE.iln.dismiss();
            this.xUE.iln = null;
        }
        if (kVar.getType() == 255) {
            ar.CG().b(255, this);
            if (i != 0 || i2 != 0) {
                this.xUE.mc(this.xUM);
            }
        } else if (kVar.getType() != 701 || this.xQO == null) {
            a eA;
            int IS;
            Intent intent;
            String str2;
            if (kVar.getType() == c.CTRL_INDEX) {
                ar.CG().b(c.CTRL_INDEX, this);
                IS = ((s) kVar).IS();
                if (IS != 15) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    if (IS != 15) {
                        return;
                    }
                    if (this.xUE.xVc.booleanValue()) {
                        this.xUL = ((s) kVar).NW();
                        ar.CG().a(126, this);
                        r3 = new y("", this.xUE.mzr, this.xUE.bgo, 0, "", this.xUE.fAf, "", "", this.xUL, this.xUE.hNU, "", "", "", true, this.xUE.xVb.booleanValue());
                        r3.mx(this.xUE.xOW);
                        ar.CG().a(r3, 0);
                        r4 = this.xUE;
                        r5 = this.xUE;
                        this.xUE.getString(R.l.dGO);
                        r4.iln = com.tencent.mm.ui.base.h.a(r5, this.xUE.getString(R.l.eEh), true, new 7(this, r3));
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("regsetinfo_ticket", ((s) kVar).NW());
                    intent.putExtra("regsetinfo_user", this.xUE.fAf);
                    intent.putExtra("regsession_id", this.xUE.xOW);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_NextControl", ((s) kVar).Oc());
                    intent.setClass(this.xUE, RegSetInfoUI.class);
                    this.xUE.startActivity(intent);
                    com.tencent.mm.plugin.accountsync.a.c.je(c$a.ikP);
                    com.tencent.mm.plugin.c.b.oH("R200_900_phone");
                    if (bh.HO().HP() > 0) {
                        str2 = "RE200_300";
                    } else {
                        str2 = "R200_300";
                    }
                    com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + "," + str2 + "," + ar.fH(str2) + ",2");
                    return;
                } else if (i2 == -35) {
                    eA = a.eA(str);
                    if (eA != null) {
                        final k kVar2 = kVar;
                        eA.a(this.xUE, new OnClickListener(this) {
                            final /* synthetic */ h xUN;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ar.CG().a(701, this.xUN);
                                this.xUN.xQO = new a(new 1(this), ((s) kVar2).getUsername(), ((s) kVar2).NV(), this.xUN.xUE.fAf);
                                this.xUN.xQO.j(this.xUN.xUE);
                            }
                        }, new 14(this));
                        return;
                    }
                    com.tencent.mm.ui.base.h.a(this.xUE, this.xUE.getString(R.l.dKD), null, new 15(this, kVar), new 16(this));
                    return;
                } else if (i2 == -212) {
                    intent = new Intent(this.xUE, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((s) kVar).NW());
                    intent.putExtra("moble", this.xUE.fAf);
                    intent.putExtra("regsession_id", this.xUE.xOW);
                    intent.putExtra("next_controll", ((s) kVar).Oc());
                    intent.putExtra("username", ((s) kVar).getUsername());
                    intent.putExtra("password", ((s) kVar).NV());
                    intent.putExtra("nickname", ((s) kVar).Oj());
                    intent.putExtra("avatar_url", ((s) kVar).Oi());
                    if (this.xUE.xVc.booleanValue()) {
                        intent.putExtra("kintent_nickname", this.xUE.bgo);
                        intent.putExtra("kintent_password", this.xUE.mzr);
                        intent.putExtra("kintent_hasavatar", this.xUE.xVb);
                    }
                    this.xUE.startActivity(intent);
                    com.tencent.mm.plugin.c.b.oH("R200_600");
                    if (bh.HO().HP() > 0) {
                        str2 = "RE200_300";
                    } else {
                        str2 = "R200_300";
                    }
                    com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + "," + str2 + "," + ar.fH(str2) + ",2");
                    return;
                } else if (i2 == -51) {
                    eA = a.eA(str);
                    if (eA != null) {
                        eA.a(this.xUE, null, null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.h(this.xUE, R.l.dLA, R.l.bNB);
                        return;
                    }
                }
            } else if (kVar.getType() == 126) {
                int i3;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    str2 = this.xUE.fAf;
                    Boolean bool = this.xUE.xVb;
                    String str3 = this.xUE.mzr;
                    String str4 = this.xUE.bgo;
                    if (this.xUE.xKa == null) {
                        MobileVerifyUI mobileVerifyUI = this.xUE;
                        Context context = this.xUE;
                        int i4 = R.l.eEi;
                        byte[] Oo = ((y) kVar).Oo();
                        String Op = ((y) kVar).Op();
                        Context context2 = context;
                        i3 = i4;
                        int i5 = 0;
                        byte[] bArr = Oo;
                        String str5 = Op;
                        mobileVerifyUI.xKa = SecurityImage.a.a(context2, i3, i5, bArr, str5, "", new 2(this, str3, str4, kVar, bool), null, new 3(this), new 4(this, str3, str4, kVar, bool));
                        return;
                    }
                    this.xUE.xKa.a(0, ((y) kVar).Oo(), ((y) kVar).Op(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str6;
                    Intent intent2;
                    String str7;
                    String str8 = this.xUE.fAf;
                    Boolean bool2 = this.xUE.xVb;
                    str2 = this.xUE.mzr;
                    str2 = this.xUE.bgo;
                    int Og = ((y) kVar).Og();
                    String Si = ((y) kVar).Si();
                    i3 = ((y) kVar).Sj();
                    String str9 = null;
                    String str10 = null;
                    boolean z = false;
                    Map y = bi.y(((y) kVar).Sk(), "wording");
                    if (y != null) {
                        str2 = (String) y.get(".wording.switch");
                        if (com.tencent.mm.sdk.platformtools.bh.ov(str2)) {
                            z = true;
                        } else {
                            IS = com.tencent.mm.sdk.platformtools.bh.VI(str2);
                            if (IS == 0) {
                                z = false;
                            } else if (IS == 1) {
                                z = true;
                            }
                        }
                        if (z) {
                            str2 = (String) y.get(".wording.title");
                            if (!com.tencent.mm.sdk.platformtools.bh.ov(str2)) {
                                str9 = str2;
                            }
                            str2 = (String) y.get(".wording.desc");
                            if (com.tencent.mm.sdk.platformtools.bh.ov(str2)) {
                                str6 = str9;
                            } else {
                                str10 = str2;
                                str6 = str9;
                            }
                            x.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[]{bool2});
                            x.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[]{Integer.valueOf(Og)});
                            x.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[]{Si});
                            x.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[]{Integer.valueOf(i3)});
                            x.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[]{r7});
                            ar.unhold();
                            ar.by(true);
                            if (bool2.booleanValue()) {
                                this.lcJ = ((y) kVar).Sh();
                                aq.hfP.S("login_user_name", str8);
                                if (Si != null) {
                                    if (Si.contains("0")) {
                                        com.tencent.mm.plugin.c.b.oH("R300_100_phone");
                                        if (z) {
                                            intent2 = new Intent(this.xUE, FindMContactIntroUI.class);
                                        } else {
                                            intent2 = new Intent(this.xUE, FindMContactAlertUI.class);
                                            intent2.putExtra("alert_title", str6);
                                            intent2.putExtra("alert_message", str10);
                                        }
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("regsetinfo_ticket", this.lcJ);
                                        intent2.putExtra("regsetinfo_NextStep", Si);
                                        intent2.putExtra("regsetinfo_NextStyle", i3);
                                        intent = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.b(this.xUE, intent2, intent);
                                        this.xUE.finish();
                                    }
                                }
                                intent2 = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.xUE.startActivity(intent2);
                                com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + this.xUE.getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
                                this.xUE.finish();
                            } else {
                                str7 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                                str2 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                                new File(str7).renameTo(new File(str2));
                                com.tencent.mm.loader.stub.b.deleteFile(str7);
                                d.b(str2, 96, 96, CompressFormat.JPEG, 90, str7);
                                new p(this.xUE, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new 5(this, kVar, str8, Si, z, str6, str10, i3), new 6(this, kVar, str8, Si, z, str6, str10, i3));
                            }
                        }
                    }
                    str6 = null;
                    x.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[]{bool2});
                    x.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[]{Integer.valueOf(Og)});
                    x.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[]{Si});
                    x.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[]{Integer.valueOf(i3)});
                    x.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[]{r7});
                    ar.unhold();
                    ar.by(true);
                    if (bool2.booleanValue()) {
                        this.lcJ = ((y) kVar).Sh();
                        aq.hfP.S("login_user_name", str8);
                        if (Si != null) {
                            if (Si.contains("0")) {
                                com.tencent.mm.plugin.c.b.oH("R300_100_phone");
                                if (z) {
                                    intent2 = new Intent(this.xUE, FindMContactAlertUI.class);
                                    intent2.putExtra("alert_title", str6);
                                    intent2.putExtra("alert_message", str10);
                                } else {
                                    intent2 = new Intent(this.xUE, FindMContactIntroUI.class);
                                }
                                intent2.addFlags(67108864);
                                intent2.putExtra("regsetinfo_ticket", this.lcJ);
                                intent2.putExtra("regsetinfo_NextStep", Si);
                                intent2.putExtra("regsetinfo_NextStyle", i3);
                                intent = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this.xUE, intent2, intent);
                                this.xUE.finish();
                            }
                        }
                        intent2 = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                        intent2.addFlags(67108864);
                        intent2.putExtra("LauncherUI.enter_from_reg", true);
                        this.xUE.startActivity(intent2);
                        com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + this.xUE.getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
                        this.xUE.finish();
                    } else {
                        str7 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                        str2 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                        new File(str7).renameTo(new File(str2));
                        com.tencent.mm.loader.stub.b.deleteFile(str7);
                        d.b(str2, 96, 96, CompressFormat.JPEG, 90, str7);
                        new p(this.xUE, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new 5(this, kVar, str8, Si, z, str6, str10, i3), new 6(this, kVar, str8, Si, z, str6, str10, i3));
                    }
                }
                eA = a.eA(str);
                if (eA != null) {
                    eA.a(this.xUE, null, null);
                    return;
                }
            }
            if (!this.xUE.o(i, i2, str)) {
                if (kVar.getType() == 701) {
                    eA = a.eA(str);
                    if (eA != null && eA.a(this.xUE, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.xUE, this.xUE.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else {
            ar.CG().b(701, this);
            this.xQO.a(this.xUE, i, i2, str, kVar);
            if (i == 0 && i2 == 0) {
                if (kVar instanceof v) {
                    this.xUM = ((v) kVar).Sg();
                }
                ar.CG().a(255, this);
                r3 = new com.tencent.mm.modelsimple.x(1);
                ar.CG().a(r3, 0);
                r4 = this.xUE;
                r5 = this.xUE;
                this.xUE.getString(R.l.dGO);
                r4.iln = com.tencent.mm.ui.base.h.a(r5, this.xUE.getString(R.l.eLF), true, new 12(this, r3));
            }
        }
    }
}
