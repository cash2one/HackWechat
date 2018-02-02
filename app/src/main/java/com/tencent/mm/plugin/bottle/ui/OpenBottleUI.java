package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import junit.framework.Assert;

public class OpenBottleUI extends FrameLayout implements OnClickListener, a, b, m.b, SensorController.a {
    static SensorController kCP;
    private com.tencent.mm.e.a.a fhH;
    au fnB;
    private boolean isDeleteCancel = false;
    BottleBeachUI kCH;
    TextView kCI;
    LinearLayout kCJ;
    FrameLayout kCK;
    ImageView kCL;
    TextView kCM;
    TextView kCN;
    TextView kCO;
    ThrowBottleAnimUI kCQ;
    String kCR;
    private boolean kCS = true;
    private ay kCT;
    private long kCU = -1;
    private boolean kCV;
    TextView kCW;
    MMActivity kCX;
    long kCY = 0;
    private boolean kCZ = false;

    public OpenBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCH = (BottleBeachUI) context;
        ar.Hg();
        c.EY().a(this);
        if (kCP == null) {
            kCP = new SensorController(context.getApplicationContext());
        }
        if (this.kCT == null) {
            this.kCT = new ay(context.getApplicationContext());
        }
        ar.Hg();
        Boolean bool = (Boolean) c.CU().get(26, Boolean.valueOf(false));
        this.kCV = bool.booleanValue();
        this.kCS = !bool.booleanValue();
        if (this.fhH != null) {
            this.fhH.aM(this.kCS);
        }
    }

    public final void onPause() {
        ar.Hh().xV();
        if (this.fnB != null && this.fnB.ciW()) {
            arT();
        }
        if (this.fhH != null) {
            if (this.fhH.isPlaying()) {
                stopPlay();
            }
            this.fhH.aM(true);
        }
    }

    public final void arT() {
        if (kCP != null) {
            kCP.cgf();
        }
        this.kCT.cgg();
    }

    public void onClick(View view) {
        if (R.h.bOn == view.getId()) {
            ThrowBottleAnimUI throwBottleAnimUI = this.kCQ;
            throwBottleAnimUI.kDT = this.fnB.ciW();
            throwBottleAnimUI.setVisibility(0);
            throwBottleAnimUI.kCH.kBs = false;
            throwBottleAnimUI.kCH.nm(-1);
            throwBottleAnimUI.asb();
            throwBottleAnimUI.arZ();
            throwBottleAnimUI.asa();
            ar.Hg();
            c.EX().b(new f(this.kCR, 1));
            this.isDeleteCancel = false;
            Context context = this.kCH;
            this.kCH.getString(R.l.dGO);
            ba.a(this.kCR, new 3(this, h.a(context, this.kCH.getString(R.l.dHc), true, new 2(this))));
            ar.Hg();
            c.Fd().WX(this.kCR);
            arT();
        } else if (R.h.bOl == view.getId()) {
            this.kCH.nm(0);
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.kCR);
            com.tencent.mm.plugin.bottle.a.ifs.e(intent, this.kCH);
            arT();
        } else if (R.h.bOr != view.getId()) {
            return;
        } else {
            if (this.fhH == null || !this.fhH.isPlaying()) {
                G(this.fnB);
                return;
            }
        }
        stopPlay();
    }

    final void arU() {
        String str;
        ar.Hg();
        af WO = c.EY().WO(this.kCR);
        if (!(WO == null || this.kCH == null)) {
            this.kCN.setText(this.kCH.getString(R.l.dMM, new Object[]{com.tencent.mm.plugin.bottle.a.c.b(this.kCH, WO)}));
            this.kCN.setCompoundDrawablesWithIntrinsicBounds(WO.fWf == 1 ? R.k.dyN : R.k.dyM, 0, 0, 0);
            this.kCN.setCompoundDrawablePadding(8);
            this.kCO.setText(i.b(this.kCH, WO.signature, this.kCO.getTextSize()));
        }
        String WD = x.WD(this.kCR);
        if (bh.ov(WD)) {
            str = this.kCR;
        } else {
            str = WD;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) findViewById(R.h.bOi), str);
    }

    static int nr(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return d.CTRL_INDEX;
    }

    private void G(au auVar) {
        if (com.tencent.mm.p.a.aW(getContext()) || com.tencent.mm.p.a.aU(this.kCH)) {
            com.tencent.mm.sdk.platformtools.x.d("MM.Bottle_OpenBottleUI", "voip is running, can't use the feature");
            return;
        }
        boolean z = auVar != null && auVar.ciW();
        Assert.assertTrue(z);
        if (!(auVar == null || !auVar.ciW() || kCP.xic)) {
            kCP.a(this);
            if (this.kCT.O(new 5(this))) {
                this.kCU = 0;
            } else {
                this.kCU = -1;
            }
        }
        ar.Hg();
        if (c.isSDCardAvailable() || bh.ov(auVar.field_imgPath)) {
            if (this.fhH == null) {
                this.fhH = new com.tencent.mm.e.a.a(this.kCH);
            }
            ae.Vc("keep_app_silent");
            q.E(auVar);
            this.fhH.aL(false);
            if (auVar == null || !this.fhH.k(auVar.field_imgPath, this.kCS)) {
                Toast.makeText(this.kCH, this.kCH.getString(R.l.dSB), 0).show();
                return;
            }
            ar.Hh().h(this.kCS, false);
            this.fhH.fjG = this;
            this.fhH.fjF = this;
            this.kCL.setBackgroundResource(R.a.bpT);
            ((AnimationDrawable) this.kCL.getBackground()).start();
            return;
        }
        u.fI(this.kCH);
    }

    private void stopPlay() {
        ae.Vd("keep_app_silent");
        arT();
        if (this.kCL.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.kCL.getBackground()).stop();
            this.kCL.setBackgroundResource(R.g.bzU);
        }
        if (this.fhH != null) {
            this.fhH.aL(false);
        }
        setScreenEnable(true);
    }

    public final void vh() {
        com.tencent.mm.sdk.platformtools.x.v("MM.Bottle_OpenBottleUI", "voice play completion");
        stopPlay();
    }

    public final void onError() {
        com.tencent.mm.sdk.platformtools.x.v("MM.Bottle_OpenBottleUI", "voice play error");
        stopPlay();
    }

    public final void a(int i, m mVar, Object obj) {
        com.tencent.mm.sdk.platformtools.x.d("MM.Bottle_OpenBottleUI", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e("MM.Bottle_OpenBottleUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (!bh.ov(this.kCR) && x.WD(this.kCR).equals(x.WD(str))) {
            arU();
        }
    }

    public final boolean arV() {
        if (this.fhH == null || !this.fhH.isPlaying() || this.kCS) {
            return false;
        }
        return true;
    }

    public final void dT(boolean z) {
        boolean z2 = true;
        if (this.fnB.ciW() && this.fhH != null) {
            if (this.kCZ) {
                if (z) {
                    z2 = false;
                }
                this.kCZ = z2;
            } else if (z || this.kCU == -1 || bh.bA(this.kCU) <= 400) {
                this.kCZ = false;
                if (bh.Wq() - this.kCY > 500 && (z || (!z && this.fhH.isPlaying()))) {
                    setScreenEnable(z);
                }
                if (this.kCV) {
                    this.fhH.aM(false);
                    ar.Hh().h(false, false);
                    this.kCS = false;
                } else if (this.fhH.isPlaying()) {
                    this.fhH.aM(z);
                    ar.Hh().h(z, false);
                    this.kCS = z;
                    if (!z) {
                        G(this.fnB);
                    }
                } else {
                    this.fhH.aM(true);
                    ar.Hh().h(true, false);
                    this.kCS = true;
                }
            } else {
                this.kCZ = true;
            }
        }
    }

    final void setScreenEnable(boolean z) {
        this.kCX.setScreenEnable(z);
    }
}
