package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.oz.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.z.ar;

public final class a extends k {
    private static final String kLD = (e.bnF + "card");
    private OnClickListener inN = new 2(this);
    private String kIw = "";
    private View kND;
    private ImageView kOm;
    private Button kOn;
    private ProgressBar lpy;
    private Resources mResources;
    private ImageView oaE;
    private TextView pOy;
    private com.tencent.mm.plugin.shake.c.a.e qoH;
    private View qoK;
    private TextView qoL;
    private TextView qoM;
    private TextView qoN;
    private TextView qoO;
    private View qoP;
    private View qoQ;
    private View qoR;
    private TextView qoS;
    private TextView qoT;
    private TextView qoU;
    private View qoV;
    private ImageView qoW;
    private boolean qoX;
    public boolean qoY = false;
    private boolean qoZ = false;
    private int qpa = 0;
    private b qpb;
    private int qpc = a.qph;
    private b qpd;
    private c qpe = new 1(this);

    static /* synthetic */ void d(a aVar) {
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.qoH.kJN)) {
            x.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            return;
        }
        com.tencent.mm.sdk.b.b ozVar = new oz();
        ozVar.fGT = null;
        ozVar.fGS.fGU = aVar.qoH.kJN;
        ozVar.fGS.fGV = aVar.qoH.fGV;
        ozVar.fGS.fGW = 15;
        ozVar.fqI = new 3(aVar, ozVar);
        com.tencent.mm.sdk.b.a.xef.a(ozVar, Looper.getMainLooper());
    }

    static /* synthetic */ void f(a aVar) {
        x.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        g.pQN.k(11665, aVar.kIw);
        com.tencent.mm.plugin.shake.c.c.a.q(aVar.getContext(), aVar.kIw, aVar.qoH.fGV);
    }

    static /* synthetic */ void i(a aVar) {
        aVar.brP();
        if (aVar.qpc == a.qpj) {
            aVar.pOy.setText(R.l.eNZ);
            if (aVar.qpa == 1) {
                aVar.qoW.setImageResource(R.k.dAD);
            } else {
                aVar.qoW.setImageResource(R.k.dAE);
            }
        }
    }

    private a(Context context) {
        super(context, R.m.eYW);
        x.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.mResources = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.kND = View.inflate(context, R.i.cMB, null);
        this.qoK = this.kND.findViewById(R.h.cMB);
        this.qoL = (TextView) this.kND.findViewById(R.h.bSs);
        this.qoM = (TextView) this.kND.findViewById(R.h.bSf);
        this.qoN = (TextView) this.kND.findViewById(R.h.bQm);
        this.oaE = (ImageView) this.kND.findViewById(R.h.bPZ);
        this.kOn = (Button) this.kND.findViewById(R.h.bPp);
        this.qoO = (TextView) this.kND.findViewById(R.h.bPv);
        this.lpy = (ProgressBar) this.kND.findViewById(R.h.bRM);
        this.oaE.setOnClickListener(this.inN);
        this.kOn.setOnClickListener(this.inN);
        this.qoP = this.kND.findViewById(R.h.bPJ);
        this.qoQ = this.kND.findViewById(R.h.cZG);
        this.qoR = this.kND.findViewById(R.h.bSt);
        this.kOm = (ImageView) this.kND.findViewById(R.h.bRp);
        this.qoS = (TextView) this.kND.findViewById(R.h.bSm);
        this.qoT = (TextView) this.kND.findViewById(R.h.bPP);
        this.qoU = (TextView) this.kND.findViewById(R.h.bSk);
        this.qoV = this.kND.findViewById(R.h.bRP);
        this.qoW = (ImageView) this.kND.findViewById(R.h.cHP);
        this.pOy = (TextView) this.kND.findViewById(R.h.cHO);
        this.qpa = com.tencent.mm.plugin.shake.c.c.a.brT();
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.qpd != null) {
                this.qpd.brR();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kND);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qoX = z;
        setCanceledOnTouchOutside(this.qoX);
    }

    public final void dismiss() {
        try {
            if (this.qpd != null) {
                this.qpd.brR();
            }
            if (!(this.qpc == a.qpj || this.qoZ)) {
                this.qoZ = true;
                x.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                ar.CG().a(new com.tencent.mm.plugin.shake.c.a.a(this.qoH.kJN, this.qoH.fGV), 0);
            }
            com.tencent.mm.sdk.b.a.xef.c(this.qpe);
            x.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void brO() {
        if (this.qpc == a.qpj) {
            this.qoP.setVisibility(8);
            this.qoV.setVisibility(0);
        } else if (this.qpc == a.qph || this.qpc == a.qpi || this.qpc == a.qpk) {
            this.qoP.setVisibility(0);
            this.qoV.setVisibility(8);
        }
    }

    private void brP() {
        if (this.qpc == a.qph || this.qpc == a.qpk) {
            if (TextUtils.isEmpty(this.qoH.qor)) {
                this.kOn.setText(R.l.dNG);
            } else {
                this.kOn.setText(this.qoH.qor);
            }
        } else if (this.qpc == a.qpi) {
            this.kOn.setText("");
        } else if (this.qpc == a.qpj) {
            this.kOn.setText(R.l.eOe);
        }
    }

    private void brQ() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.f.bxX);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.wO(this.qoH.hbM));
        this.qoR.setBackgroundDrawable(shapeDrawable);
        brP();
        if (!TextUtils.isEmpty(this.qoH.qop)) {
            this.qoL.setText(this.qoH.qop);
        }
        if (!TextUtils.isEmpty(this.qoH.qot)) {
            this.qoM.setText(this.qoH.qot);
            this.qoM.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.qoH.qoq)) {
            this.qoN.setText(this.qoH.qoq);
            this.qoN.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.qoH.kJP)) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(R.f.bxW);
            ImageView imageView = this.kOm;
            String str = this.qoH.kJP;
            int i = R.k.dAC;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(i);
                } else {
                    c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                    com_tencent_mm_aq_a_a_c_a.hDD = e.bnF;
                    o.PB();
                    com_tencent_mm_aq_a_a_c_a.hDW = null;
                    com_tencent_mm_aq_a_a_c_a.hDC = String.format("%s/%s", new Object[]{kLD, com.tencent.mm.a.g.s(str.getBytes())});
                    com_tencent_mm_aq_a_a_c_a.hDA = true;
                    com_tencent_mm_aq_a_a_c_a.hDY = true;
                    com_tencent_mm_aq_a_a_c_a.hDy = true;
                    com_tencent_mm_aq_a_a_c_a.hDH = dimensionPixelOffset;
                    com_tencent_mm_aq_a_a_c_a.hDG = dimensionPixelOffset;
                    com_tencent_mm_aq_a_a_c_a.hDP = i;
                    o.PA().a(str, imageView, com_tencent_mm_aq_a_a_c_a.PK());
                }
            }
        }
        if (!TextUtils.isEmpty(this.qoH.title)) {
            this.qoS.setText(this.qoH.title);
        }
        if (!TextUtils.isEmpty(this.qoH.kLa)) {
            this.qoT.setText(this.qoH.kLa);
        }
        if (this.qoH.cey > 0) {
            this.qoU.setText(getContext().getString(R.l.dPO, new Object[]{com.tencent.mm.plugin.shake.c.c.a.bp((long) this.qoH.cey)}));
        }
        if (this.qpc == a.qpk) {
            this.qoO.setVisibility(0);
        } else {
            this.qoO.setVisibility(8);
        }
    }

    public static a a(Context context, com.tencent.mm.plugin.shake.c.a.e eVar, OnCancelListener onCancelListener, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.qoH = eVar;
        if (aVar.qoH == null) {
            x.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.qoH.title)) {
                aVar.qoL.setText(aVar.qoH.title);
            }
            x.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.qpc = a.qph;
            aVar.brO();
            aVar.brQ();
            if (aVar.qpa == 0) {
                aVar.qoK.setBackgroundResource(R.g.bFM);
                aVar.qoQ.setBackgroundResource(R.g.bFN);
                aVar.qoL.setTextColor(aVar.mResources.getColor(R.e.black));
                aVar.qoM.setTextColor(aVar.mResources.getColor(R.e.btp));
                aVar.qoN.setTextColor(aVar.mResources.getColor(R.e.btp));
                aVar.pOy.setTextColor(aVar.getContext().getResources().getColor(R.e.black));
                aVar.kOn.setBackgroundResource(R.g.bAb);
                aVar.kOn.setTextColor(aVar.getContext().getResources().getColor(R.e.white));
                aVar.qoO.setTextColor(aVar.getContext().getResources().getColor(R.e.btr));
            }
        }
        aVar.qpd = bVar;
        aVar.show();
        h.a(context, aVar);
        return aVar;
    }
}
