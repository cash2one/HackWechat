package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.RegByMobileSendSmsUI;
import com.tencent.mm.ui.account.ShowAgreementsUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class d implements e, b {
    private String xOW;
    private String xQj;
    private String xQk;
    private int xQt = 0;
    private MobileInputUI xTM;
    int xTR = 1;

    public final void a(final MobileInputUI mobileInputUI) {
        this.xTM = mobileInputUI;
        String string = mobileInputUI.getString(R.l.eDZ);
        if (com.tencent.mm.protocal.d.vAC) {
            string = string + mobileInputUI.getString(R.l.dDD);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.showOptionMenu(false);
        mobileInputUI.xUb.setVisibility(0);
        mobileInputUI.xUb.setVisibility(0);
        mobileInputUI.xQd.setVisibility(0);
        mobileInputUI.xTX.setVisibility(0);
        mobileInputUI.xTY.requestFocus();
        mobileInputUI.xUa.setVisibility(0);
        mobileInputUI.xQo.setVisibility(0);
        mobileInputUI.xQo.setText(R.l.etH);
        if (mobileInputUI.xQn != null) {
            mobileInputUI.xQn.setOnClickListener(new 1(this, mobileInputUI));
        }
        string = mobileInputUI.getString(R.l.esL);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (w.cff()) {
            string2 = mobileInputUI.getString(R.l.esM);
            string3 = mobileInputUI.getString(R.l.eAW);
            string4 = mobileInputUI.getString(R.l.dDI);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new 3(this, mobileInputUI), string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d xTS;

                public final void onClick(View view) {
                    bh.F(mobileInputUI, ac.getResources().getString(R.l.esR, new Object[]{w.eL(mobileInputUI), w.cfh()}));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.xQm.setText(newSpannable);
        } else {
            string2 = mobileInputUI.getString(R.l.esS);
            string3 = mobileInputUI.getString(R.l.esO);
            string4 = mobileInputUI.getString(R.l.dDI);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d xTS;

                public final void onClick(View view) {
                    bh.F(mobileInputUI.mController.xIM, mobileInputUI.getString(R.l.eSn));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d xTS;

                public final void onClick(View view) {
                    bh.F(mobileInputUI, ac.getResources().getString(R.l.esR, new Object[]{w.eL(mobileInputUI), w.cfh()}));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.xQm.setText(newSpannable);
        }
        mobileInputUI.xQm.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void start() {
        ar.CG().a(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",R200_100," + ar.fH("R200_100") + ",1");
        com.tencent.mm.plugin.c.b.oG("R200_100");
        this.xQt = 0;
    }

    public final void stop() {
        ar.CG().b(c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + ",R200_100," + ar.fH("R200_100") + ",2");
    }

    public final void Ei(int i) {
        switch (2.xTO[i - 1]) {
            case 1:
                this.xTM.aWs();
                switch (this.xTR) {
                    case 1:
                        Intent intent = new Intent(this.xTM, ShowAgreementsUI.class);
                        intent.putExtra("agreement_type", 0);
                        if (ao.Vm(this.xTM.countryCode).equals("+86")) {
                            intent.putExtra("country_code", "CN");
                        } else {
                            intent.putExtra("country_code", "US");
                        }
                        this.xTM.startActivityForResult(intent, 32047);
                        break;
                    case 2:
                        cov();
                        break;
                    default:
                        this.xTM.xUe = ao.Vm(this.xTM.countryCode);
                        this.xTM.phQ = this.xTM.xTX.getText().toString();
                        String str = this.xTM.xUe + this.xTM.phQ;
                        if (this.xTM.xPh == null) {
                            MobileInputUI mobileInputUI = this.xTM;
                            Context context = this.xTM;
                            this.xTM.getString(R.l.dGO);
                            mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eDx), true, new OnCancelListener(this) {
                                final /* synthetic */ d xTS;

                                {
                                    this.xTS = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            String obj = this.xTM.xTX.getText().toString();
                            int i2 = (this.xQj == null || this.xQk == null || obj.equals(this.xQj) || !obj.equals(this.xQk)) ? (this.xQj == null || this.xQk == null || this.xQk.equals(this.xQj) || obj.equals(this.xQk)) ? 0 : 2 : 1;
                            k sVar = new s(str, 12, "", 0, "");
                            sVar.hE(this.xQt);
                            sVar.hF(i2);
                            ar.CG().a(sVar, 0);
                            this.xQj = this.xTM.xTX.getText().toString();
                            this.xQt++;
                            break;
                        }
                        x.d("MicroMsg.MobileInputRegLogic", "already checking ");
                        break;
                        break;
                }
                this.xTR = 0;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xTM.xPh != null) {
            this.xTM.xPh.dismiss();
            this.xTM.xPh = null;
        }
        if (i2 == -75) {
            h.h(this.xTM, R.l.dDG, R.l.eCW);
        } else if (kVar.getType() != c.CTRL_INDEX) {
        } else {
            a eA;
            if (i2 == -41 || i2 == -59) {
                eA = a.eA(str);
                if (eA != null) {
                    eA.a(this.xTM, null, null);
                    return;
                } else {
                    h.h(this.xTM, R.l.eDE, R.l.eDF);
                    return;
                }
            }
            String NY;
            int IS = ((s) kVar).IS();
            if (IS == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    NY = ((s) kVar).NY();
                    if (!bh.ov(NY)) {
                        this.xTM.phQ = NY.trim();
                    }
                    this.xTM.phQ = ao.Vk(this.xTM.phQ);
                    this.xQk = this.xTM.xUe + this.xTM.phQ;
                    this.xOW = ((s) kVar).Ok();
                    com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",R200_200," + ar.fH("R200_200") + ",1");
                    eA = a.eA(str);
                    if (eA != null) {
                        eA.a(this.xTM, new 8(this), new 9(this));
                        return;
                    }
                    cov();
                    com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",R200_200," + ar.fH("R200_200") + ",2");
                    return;
                } else if (i2 == -355) {
                    m.b(this.xTM, str, 32046);
                    return;
                } else if (i2 == -34) {
                    h.b(this.xTM, this.xTM.getString(R.l.dKT), "", true);
                    return;
                } else {
                    Toast.makeText(this.xTM, this.xTM.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (IS != 14) {
                return;
            }
            if (i2 == 0 || str == null) {
                if (((s) kVar).NZ() == 1) {
                    String str2 = this.xTM.xUe + this.xTM.phQ;
                    NY = ((s) kVar).Ob();
                    String Oa = ((s) kVar).Oa();
                    Intent intent = new Intent(this.xTM, RegByMobileSendSmsUI.class);
                    intent.putExtra("from_mobile", str2);
                    intent.putExtra("to_mobile", NY);
                    intent.putExtra("verify_code", Oa);
                    intent.putExtra("regsession_id", this.xOW);
                    this.xTM.startActivity(intent);
                    return;
                }
                com.tencent.mm.plugin.c.b.oH("R200_300");
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.xTM.xUe + " " + this.xTM.xTX.getText().toString());
                intent2.putExtra("bindmcontact_shortmobile", this.xTM.phQ);
                intent2.putExtra("country_name", this.xTM.hEx);
                intent2.putExtra("couttry_code", this.xTM.countryCode);
                intent2.putExtra("mobileverify_countdownsec", ((s) kVar).Od());
                intent2.putExtra("mobileverify_countdownstyle", ((s) kVar).Oe());
                intent2.putExtra("mobileverify_fb", ((s) kVar).Of());
                intent2.putExtra("mobileverify_reg_qq", ((s) kVar).Oh());
                intent2.putExtra("mobile_verify_purpose", 2);
                intent2.setClass(this.xTM, MobileVerifyUI.class);
                this.xTM.startActivity(intent2);
                com.tencent.mm.plugin.accountsync.a.c.je(com.tencent.mm.plugin.accountsync.a.c.a.ikO);
            } else if (i2 == -34) {
                h.b(this.xTM, this.xTM.getString(R.l.dKT), "", true);
            } else if (!com.tencent.mm.plugin.c.a.ift.a(this.xTM, i, i2, str)) {
                Toast.makeText(this.xTM, this.xTM.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private void cov() {
        MobileInputUI mobileInputUI = this.xTM;
        Context context = this.xTM;
        this.xTM.getString(R.l.dGO);
        mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eDx), true, new OnCancelListener(this) {
            final /* synthetic */ d xTS;

            {
                this.xTS = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        k sVar = new s(this.xTM.xUe + this.xTM.phQ, 14, "", 0, "");
        sVar.lb(this.xOW);
        ar.CG().a(sVar, 0);
    }
}
