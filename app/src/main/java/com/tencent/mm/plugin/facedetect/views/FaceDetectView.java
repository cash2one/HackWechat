package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView extends RelativeLayout {
    public static long mmI = 100;
    public static int mmJ = 1;
    public boolean isPaused;
    public volatile boolean kMn;
    public long mgq;
    public TextView mkj;
    public String mmA;
    public boolean mmB;
    public boolean mmC;
    public long mmD;
    private long mmE;
    private final int mmF;
    private Animation mmG;
    private View mmH;
    public FaceDetectCameraView mms;
    public FaceDetectDecorView mmt;
    public ViewGroup mmu;
    public ViewGroup mmv;
    public a mmw;
    public b mmx;
    public boolean mmy;
    public boolean mmz;

    static /* synthetic */ void a(FaceDetectView faceDetectView, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
            return;
        }
        Object obj;
        if (aVar == null) {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
        } else if (aVar.mhu > 0) {
            if (faceDetectView.mmw != null) {
                faceDetectView.mmw.pC(aVar.mhu);
            }
            obj = 1;
            if (obj == null) {
                faceDetectView.mmz = FaceCharacteristicsResult.pr(aVar.mhv);
                faceDetectView.zO(aVar.fnL == null ? aVar.fnL : faceDetectView.getContext().getString(h.mdO));
                if (faceDetectView.mmw != null) {
                    faceDetectView.mmw.K(aVar.mhv, aVar.fnL == null ? aVar.fnL : faceDetectView.getContext().getString(h.mdO));
                }
            }
        }
        obj = null;
        if (obj == null) {
            faceDetectView.mmz = FaceCharacteristicsResult.pr(aVar.mhv);
            if (aVar.fnL == null) {
            }
            faceDetectView.zO(aVar.fnL == null ? aVar.fnL : faceDetectView.getContext().getString(h.mdO));
            if (faceDetectView.mmw != null) {
                if (aVar.fnL == null) {
                }
                faceDetectView.mmw.K(aVar.mhv, aVar.fnL == null ? aVar.fnL : faceDetectView.getContext().getString(h.mdO));
            }
        }
    }

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        if (faceDetectView.mmx != null && faceDetectView.mmx.aGU()) {
            x.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.mms.aHy();
            faceDetectView.isPaused = true;
            long bA = bh.bA(faceDetectView.mmD);
            x.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", new Object[]{Long.valueOf(bA)});
            if (bA < faceDetectView.mgq - 5) {
                ag.h(new 3(faceDetectView), faceDetectView.mgq - bA);
            } else if (faceDetectView.mmw != null && !faceDetectView.kMn) {
                faceDetectView.mmw.K(0, "");
            }
        }
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        long Wq = bh.Wq();
        x.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", new Object[]{Long.valueOf(Wq - faceDetectView.mmE), Integer.valueOf(1500)});
        if (Wq - faceDetectView.mmE <= 1500) {
            return false;
        }
        faceDetectView.mmE = Wq;
        return true;
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i, byte b) {
        Animation animation;
        super(context, attributeSet, i);
        this.mms = null;
        this.mmt = null;
        this.mkj = null;
        this.mmu = null;
        this.mmv = null;
        this.mmw = null;
        this.mmy = false;
        this.kMn = false;
        this.isPaused = false;
        this.mmz = false;
        this.mmA = ac.getContext().getString(h.mez);
        this.mmB = true;
        this.mmC = false;
        this.mgq = -1;
        this.mmD = -1;
        this.mmE = -1;
        this.mmF = 1500;
        this.mmH = null;
        View inflate = LayoutInflater.from(context).inflate(g.mdN, null, false);
        addView(inflate);
        this.mms = (FaceDetectCameraView) inflate.findViewById(e.mcR);
        this.mmt = (FaceDetectDecorView) inflate.findViewById(e.mdt);
        this.mmH = inflate.findViewById(e.mds);
        this.mms.mlG = new 1(this);
        Context context2 = getContext();
        if (context2 == null) {
            x.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, com.tencent.mm.w.a.a.gUt);
            animation.setInterpolator(new c());
        }
        this.mmG = animation;
    }

    public final void g(boolean z, String str) {
        if (z) {
            com.tencent.mm.sdk.f.e.post(new 2(this, str), "face_detect_set_backgroud");
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.mmH.startAnimation(alphaAnimation);
    }

    private void aHE() {
        this.mkj.setText("");
        this.mkj.setVisibility(4);
    }

    private void zO(String str) {
        if (bh.ou(str).equals(this.mkj.getText().toString())) {
            x.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            return;
        }
        this.mkj.setText(str);
        this.mkj.setVisibility(0);
        this.mkj.setAnimation(this.mmG);
    }

    public final int aHF() {
        return this.mms.mlY.aGN();
    }

    public final void eV(boolean z) {
        if (this.mmx != null) {
            this.mmx.aGW();
        }
        if (this.kMn) {
            x.w("MicroMsg.FaceDetectView", "hy: already end");
            return;
        }
        this.kMn = true;
        if (z) {
            if (this.mms != null) {
                f.w(new 5(this, null));
            }
        } else if (this.mms != null) {
            this.mms.aHy();
            f.mgf.mgg.mil.aGI();
        }
        x.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.mmz = false;
        aHE();
    }
}
