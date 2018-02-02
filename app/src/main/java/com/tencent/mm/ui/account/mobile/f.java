package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class f implements e, MobileVerifyUI$b {
    SecurityImage xKa = null;
    com.tencent.mm.ui.account.f xOA = null;
    private a xQO = null;
    MobileVerifyUI xUE;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.xUE = mobileVerifyUI;
    }

    public final void start() {
        b.b(true, ar.CB() + "," + getClass().getName() + ",F200_300," + ar.fH("F200_300") + ",1");
        b.oG("F200_300");
    }

    public final void stop() {
        int i = 2;
        if (this.xUE.xVf != -1) {
            i = this.xUE.xVf;
        }
        b.b(false, ar.CB() + "," + getClass().getName() + ",F200_300," + ar.fH("F200_300") + "," + i);
    }

    public final boolean Ej(int i) {
        k sVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (6.xUH[i - 1]) {
            case 1:
                ar.CG().a(c.CTRL_INDEX, this);
                sVar = new s(this.xUE.fAf, 9, this.xUE.xTy.getText().toString().trim(), 0, "");
                ar.CG().a(sVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = h.a(context, this.xUE.getString(R.l.dLx), true, new 2(this, sVar));
                break;
            case 2:
                b.oI(ar.CB() + "," + getClass().getName() + ",R200_400," + ar.fH("R200_400") + ",1");
                ar.CG().a(c.CTRL_INDEX, this);
                ar.CG().a(new s(this.xUE.fAf, 8, "", 0, ""), 0);
                break;
            case 3:
                b.oI(ar.CB() + "," + getClass().getName() + ",R200_350_auto," + ar.fH("R200_350_auto") + ",1");
                ar.CG().a(c.CTRL_INDEX, this);
                sVar = new s(this.xUE.fAf, 9, this.xUE.xTy.getText().toString().trim(), 0, "");
                ar.CG().a(sVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = h.a(context, this.xUE.getString(R.l.dLx), true, new 1(this, sVar));
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xUE.iln != null) {
            this.xUE.iln.dismiss();
            this.xUE.iln = null;
        }
        if (this.xOA == null) {
            this.xOA = new com.tencent.mm.ui.account.f();
        }
        if (kVar.getType() != 701 || this.xQO == null) {
            a eA;
            if (kVar.getType() == c.CTRL_INDEX) {
                this.xOA.hNv = ((s) kVar).getUsername();
                this.xOA.xPp = ((s) kVar).NV();
                ar.CG().b(c.CTRL_INDEX, this);
                if (((s) kVar).IS() != 9) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    ar.CG().a(701, this);
                    this.xQO = new a(new 5(this), ((s) kVar).getUsername(), ((s) kVar).NV(), this.xUE.fAf);
                    this.xQO.j(this.xUE);
                    return;
                } else if (i2 == -51) {
                    eA = a.eA(str);
                    if (eA != null) {
                        eA.a(this.xUE, null, null);
                        return;
                    } else {
                        h.h(this.xUE, R.l.dLA, R.l.bNB);
                        return;
                    }
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
                    return;
                }
                return;
            }
            return;
        }
        ar.CG().b(701, this);
        this.xOA.xPq = ((v) kVar).Op();
        this.xOA.xPs = ((v) kVar).Oo();
        this.xOA.xPr = ((v) kVar).Sa();
        this.xOA.xPt = ((v) kVar).RZ();
        if (i2 == -6 || i2 == -311 || i2 == -310) {
            ar.CG().a(701, this);
            if (this.xKa == null) {
                this.xKa = SecurityImage.a.a(this.xUE, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new 3(this), null, new 4(this), this.xOA);
                return;
            }
            x.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.xOA.xPq + " img len" + this.xOA.xPs.length + " " + g.zh());
            this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
            return;
        }
        this.xQO.a(this.xUE, i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            boolean Sg;
            if (kVar instanceof v) {
                Sg = ((v) kVar).Sg();
            } else {
                Sg = true;
            }
            this.xUE.mc(Sg);
        }
    }
}
