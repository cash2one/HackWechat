package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class b implements e, com.tencent.mm.ui.account.mobile.MobileInputUI.b {
    private String xQj;
    private String xQk;
    private int xQt = 0;
    private MobileInputUI xTM;

    public final void a(MobileInputUI mobileInputUI) {
        this.xTM = mobileInputUI;
        mobileInputUI.xTY.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(R.l.eEa);
        if (d.vAC) {
            string = string + mobileInputUI.getString(R.l.dDD);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.xQd.setVisibility(0);
        mobileInputUI.xTX.setVisibility(0);
        mobileInputUI.xTY.requestFocus();
        mobileInputUI.xQo.setText(R.l.dFQ);
        mobileInputUI.xQo.setVisibility(0);
    }

    public final void start() {
        ar.CG().a(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",F200_100," + ar.fH("F200_100") + ",1");
        com.tencent.mm.plugin.c.b.oG("F200_100");
        this.xQt = 0;
    }

    public final void stop() {
        ar.CG().b(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + ",F200_100," + ar.fH("F200_100") + ",2");
    }

    public final void Ei(int i) {
        switch (5.xTO[i - 1]) {
            case 1:
                this.xTM.xUe = ao.Vm(this.xTM.countryCode);
                this.xTM.phQ = this.xTM.xTX.getText().toString();
                String str = this.xTM.xUe + this.xTM.phQ;
                if (this.xTM.xPh != null) {
                    x.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.xTM;
                Context context = this.xTM;
                this.xTM.getString(R.l.dGO);
                mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eDx), true, new 1(this));
                String obj = this.xTM.xTX.getText().toString();
                int i2 = (this.xQj == null || this.xQk == null || obj.equals(this.xQj) || !obj.equals(this.xQk)) ? (this.xQj == null || this.xQk == null || this.xQk.equals(this.xQj) || obj.equals(this.xQk)) ? 0 : 2 : 1;
                k sVar = new s(str, 12, "", 0, "");
                sVar.hE(this.xQt);
                sVar.hF(i2);
                ar.CG().a(sVar, 0);
                this.xQj = this.xTM.xTX.getText().toString();
                this.xQt++;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xTM.xPh != null) {
            this.xTM.xPh.dismiss();
            this.xTM.xPh = null;
        }
        if (i2 == -75) {
            h.h(this.xTM, R.l.dDG, R.l.eCW);
        } else if (i2 == -41 || i2 == -59) {
            r0 = a.eA(str);
            if (r0 != null) {
                r0.a(this.xTM, null, null);
            } else {
                h.h(this.xTM, R.l.eDE, R.l.eDF);
            }
        } else if (kVar.getType() == c.CTRL_INDEX) {
            int IS = ((s) kVar).IS();
            if (IS == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String NY = ((s) kVar).NY();
                    if (!bh.ov(NY)) {
                        this.xTM.phQ = NY.trim();
                    }
                    this.xTM.phQ = ao.Vk(this.xTM.phQ);
                    this.xQk = this.xTM.xUe + this.xTM.phQ;
                    com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",F200_200," + ar.fH("F200_200") + ",1");
                    r0 = a.eA(str);
                    if (r0 != null) {
                        r0.a(this.xTM, new OnClickListener(this) {
                            final /* synthetic */ b xTN;

                            {
                                this.xTN = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.xTN.cov();
                                com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",F200_200," + ar.fH("F200_200") + ",2");
                            }
                        }, new 3(this));
                        return;
                    }
                    cov();
                    com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",F200_200," + ar.fH("F200_200") + ",2");
                    return;
                } else if (i2 == -34) {
                    h.b(this.xTM, this.xTM.getString(R.l.dKT), "", true);
                    return;
                } else {
                    Toast.makeText(this.xTM, this.xTM.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (IS == 8 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.xTM.xUe + " " + this.xTM.xTX.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.xTM.phQ);
                intent.putExtra("country_name", this.xTM.hEx);
                intent.putExtra("couttry_code", this.xTM.countryCode);
                intent.putExtra("mobileverify_countdownsec", ((s) kVar).Od());
                intent.putExtra("mobileverify_countdownstyle", ((s) kVar).Oe());
                intent.putExtra("mobileverify_fb", ((s) kVar).Of());
                intent.putExtra("mobileverify_reg_qq", ((s) kVar).Oh());
                intent.putExtra("mobile_verify_purpose", 3);
                intent.setClass(this.xTM, MobileVerifyUI.class);
                this.xTM.startActivity(intent);
            }
        }
    }

    private void cov() {
        MobileInputUI mobileInputUI = this.xTM;
        Context context = this.xTM;
        this.xTM.getString(R.l.dGO);
        mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eDx), true, new 4(this));
        ar.CG().a(new s(this.xTM.xUe + this.xTM.phQ, 8, "", 0, ""), 0);
    }
}
