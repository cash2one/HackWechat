package com.tencent.mm.ui.bindqq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public final class b implements e {
    Context context;
    i pyk = null;
    private View pyl = null;
    SecurityImage xKa = null;
    r xPh = null;
    String xPo = "";
    private String xPq = "";
    private String xPr;
    private byte[] xPs = null;
    private a ymK;

    public b(Context context, a aVar) {
        this.context = context;
        this.ymK = aVar;
    }

    public final void EI() {
        ar.CG().a(384, this);
    }

    public final void onDetach() {
        ar.CG().b(384, this);
        if (this.ymK != null) {
            this.ymK.cqE();
        }
    }

    public final void cqF() {
        this.pyl = View.inflate(this.context, R.i.drO, null);
        EditText editText = (EditText) this.pyl.findViewById(R.h.cLz);
        editText.setHint(R.l.dSk);
        this.pyk = h.a(this.context, this.context.getString(R.l.dSl), this.pyl, new 1(this, editText), new 2(this));
    }

    @TargetApi(17)
    public final void a(int i, int i2, String str, k kVar) {
        onDetach();
        if (kVar != null && kVar.getType() == 384) {
            byte[] a;
            if (this.xPh != null) {
                this.xPh.dismiss();
                this.xPh = null;
            }
            this.xPq = n.a(((bsf) ((al) kVar).gJQ.hmh.hmo).woX);
            al alVar = (al) kVar;
            if (((bsf) alVar.gJQ.hmh.hmo).vJc == null || ((bsf) alVar.gJQ.hmh.hmo).vJc.wJB <= 0) {
                a = n.a(((bsf) alVar.gJQ.hmh.hmo).vHb);
            } else {
                a = g.Dh().Cq().aP(alVar.hnZ);
            }
            this.xPs = a;
            if (this.ymK == null || !this.ymK.t(i, i2, str)) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing()) {
                        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                            return;
                        }
                    }
                    return;
                }
                a eA;
                if (i == 4) {
                    switch (i2) {
                        case -311:
                        case -310:
                        case -6:
                            if (!ar.Hj()) {
                                return;
                            }
                            if (this.xKa == null) {
                                this.xKa = SecurityImage.a.a(this.context, R.l.eEi, 0, this.xPs, this.xPq, this.xPr, new 5(this), null, new 6(this), new b(this));
                                return;
                            } else {
                                this.xKa.a(0, this.xPs, this.xPq, this.xPr);
                                return;
                            }
                        case -72:
                            this.pyk = h.h(this.context, R.l.dSm, R.l.dGO);
                            return;
                        case -34:
                            this.pyk = h.b(this.context, this.context.getString(R.l.dLU), this.context.getString(R.l.dGO), true);
                            return;
                        case -3:
                            this.pyk = h.a(this.context, this.context.getString(R.l.dQO), this.context.getString(R.l.dGO), new 4(this), null);
                            return;
                        default:
                            eA = a.eA(str);
                            if (eA != null) {
                                eA.a(this.context, null, null);
                                return;
                            }
                            return;
                    }
                }
                eA = a.eA(str);
                if (eA != null) {
                    eA.a(this.context, null, null);
                }
            }
        }
    }
}
