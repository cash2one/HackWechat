package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int pOK;
    private String pPm;
    private int paR;
    private int paS;
    private int tdA;
    private String tdx;
    private String tdy;
    private int tdz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pOK = getIntent().getIntExtra("total_fee", 0);
        this.tdx = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.tdy = q.FS();
            this.pPm = this.pOG;
            return;
        }
        this.tdy = this.pOG;
        this.pPm = q.FS();
    }

    protected final void vv(int i) {
        b(new f(this.pMq, this.pOG, this.pOD), true);
    }

    protected final void vw(int i) {
        b(new f(this.pMq, this.pOG, this.pOD, 1, i), true);
    }

    protected final void T(Intent intent) {
        d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
    }

    protected final void bnV() {
        l(new c(this.pMq, this.pOK, this.tdx, this.pOG));
    }

    protected final void bnW() {
        l(new b(this.pMq, this.pOK, this.tdx, this.pOG));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            String string;
            CharSequence spannableString;
            a aVar;
            if (fVar.fut != 0) {
                boolean equals;
                boolean z = false;
                if (i == 0 && i2 == 0) {
                    this.tdz = fVar.status;
                    this.tdA = fVar.pLs;
                    this.paS = fVar.tdt;
                    this.paR = fVar.tdu;
                    this.pOK = (int) (fVar.ljg * 100.0d);
                    this.tdx = fVar.paz;
                    z = true;
                    equals = this.pPm.equals(q.FS());
                    this.pOA.setVisibility(8);
                    this.pOz.setText(e.d(((double) this.pOK) / 100.0d, this.tdx));
                    int i3 = this.tdz;
                    String string2;
                    CharSequence spannableString2;
                    a aVar2;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            if (equals) {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udY);
                                this.pOA.setVisibility(0);
                                this.pOA.setOnClickListener(new 2(this));
                                string = getString(a$i.uNG, new Object[]{Integer.valueOf(this.pOI)});
                                string2 = getString(a$i.uNu);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.pdj = new 3(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(spannableString2);
                            } else {
                                this.pOy.setText(i.b(this, getString(a$i.uND, new Object[]{ax(this.pPm, true)}), this.pOy.getTextSize()));
                                string = getString(a$i.uNK, new Object[]{Integer.valueOf(this.pOI)});
                                string2 = getString(a$i.uOc);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.pdj = new 1(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(spannableString2);
                            }
                            this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udY);
                            this.pOB.setText(getString(a$i.uNL, new Object[]{e.HD(this.paS)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setVisibility(8);
                            equals = true;
                            break;
                        case 2001:
                            this.pOx.setImageResource(a$h.uGE);
                            if (equals) {
                                this.pOy.setText(a$i.uNx);
                                Object string3 = getString(a$i.uNi);
                                spannableString = new SpannableString(string3);
                                aVar = new a(this);
                                aVar.pdj = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI tdB;

                                    {
                                        this.tdB = r1;
                                    }

                                    public final void onClick(View view) {
                                        h.Y(this.tdB, 0);
                                    }
                                };
                                spannableString.setSpan(aVar, 0, string3.length(), 33);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(spannableString);
                                this.ogW.setVisibility(0);
                            } else {
                                this.pOy.setText(i.b(this, ax(this.pPm, true) + " " + getString(a$i.uNx), this.pOy.getTextSize()));
                                this.ogW.setVisibility(8);
                            }
                            this.pOB.setText(getString(a$i.uNL, new Object[]{e.HD(this.tdA)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setText(getString(a$i.uNm, new Object[]{e.HD(this.paR)}));
                            this.pOC.setVisibility(0);
                            equals = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pOx.setImageResource(a$h.uGF);
                                if (equals) {
                                    this.pOy.setText(a$i.uNz);
                                } else {
                                    this.pOy.setText(i.b(this, ax(this.pPm, true) + getString(a$i.uNz), this.pOy.getTextSize()));
                                }
                            } else {
                                this.pOx.setImageResource(a$h.uGG);
                                this.pOy.setText(a$i.uNB);
                            }
                            if (equals) {
                                this.ogW.setText("");
                            } else {
                                string = getString(a$i.uNr);
                                string2 = getString(a$i.uNi);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.pdj = new 5(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(spannableString2);
                            }
                            this.ogW.setVisibility(0);
                            this.pOB.setText(getString(a$i.uNL, new Object[]{e.HD(this.tdA)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setText(getString(a$i.uNp, new Object[]{e.HD(this.paS)}));
                            this.pOC.setVisibility(0);
                            equals = true;
                            break;
                        default:
                            finish();
                            break;
                    }
                }
                equals = z;
                if (fVar.fDt != 1) {
                    return equals;
                }
                g.Dk();
                if (((String) g.Dj().CU().get(327729, "0")).equals("0")) {
                    com.tencent.mm.ui.base.h.a(this.mController.xIM, a$i.uId, a$i.uWb, new 8(this));
                    g.Dk();
                    g.Dj().CU().set(327729, "1");
                    return equals;
                }
                com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(a$i.uNk));
                return equals;
            } else if (i == 0 && i2 == 0) {
                if (this.pOE == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udY);
                    this.pOy.setText(a$i.uNC);
                    this.pOz.setText(e.d(fVar.ljg, fVar.paz));
                    this.pOA.setVisibility(0);
                    this.pOA.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ PayURemittanceDetailUI tdB;

                        {
                            this.tdB = r1;
                        }

                        public final void onClick(View view) {
                            this.tdB.bnV();
                        }
                    });
                    String string4 = getString(a$i.uNG, new Object[]{Integer.valueOf(this.pOI)});
                    string = getString(a$i.uNu);
                    spannableString = new SpannableString(string4 + string);
                    aVar = new a(this);
                    aVar.pdj = new a.a(this) {
                        final /* synthetic */ PayURemittanceDetailUI tdB;

                        {
                            this.tdB = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.h.a(this.tdB, this.tdB.getString(a$i.uNq, new Object[]{PayURemittanceDetailUI.ax(this.tdB.pOG, false)}), this.tdB.getString(a$i.dGt), this.tdB.getString(a$i.uNv), this.tdB.getString(a$i.dEn), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 tdE;

                                {
                                    this.tdE = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.tdE.tdB.bnW();
                                }
                            }, new 2(this));
                        }
                    };
                    spannableString.setSpan(aVar, string4.length(), string4.length() + string.length(), 33);
                    this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                    this.ogW.setText(spannableString);
                    this.pOB.setText(getString(a$i.uNL, new Object[]{e.HD(fVar.pLs)}));
                    this.pOB.setVisibility(0);
                    this.pOC.setVisibility(8);
                }
                return true;
            } else {
                vw(0);
                return true;
            }
        } else if (!(kVar instanceof c) && !(kVar instanceof b)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                if (kVar instanceof c) {
                    vw(1);
                } else {
                    ay(0, getString(a$i.uNl));
                }
                return true;
            }
            ay(i2, str);
            return true;
        }
    }
}
