package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.k;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.r;

public final class a {
    MMActivity fmM;
    r ilH;
    RecyclerThumbSeekBar oBC;
    boolean oBD = false;
    int oBE = -1;
    int oBF = -1;
    int oBG = -1;
    ak oBH;
    ViewGroup oBI;
    m oBJ;
    b oBK;
    com.tencent.mm.plugin.mmsight.api.a oBL;
    public a oBM;
    boolean oBN = false;
    public boolean oBO = false;
    private boolean oBP = false;
    private boolean oBQ = false;
    public String oBR = null;
    public int oBS = -1;
    com.tencent.mm.plugin.mmsight.a.a.b oBT;
    VideoTransPara osr;
    VideoSeekBarEditorView oxA;
    VideoPlayerTextureView oxz;
    public int scene;
    String videoPath;

    static /* synthetic */ void a(a aVar) {
        int width = aVar.oxz.getWidth();
        int height = aVar.oxz.getHeight();
        int fromDPToPix = ((aVar.oxA.getHeight() <= 0 ? com.tencent.mm.bv.a.fromDPToPix(aVar.fmM, 100) : aVar.oxA.getHeight()) + com.tencent.mm.bv.a.fromDPToPix(aVar.fmM, 20)) + com.tencent.mm.bv.a.fromDPToPix(aVar.fmM, 12);
        if (ae.fy(aVar.fmM)) {
            fromDPToPix += ae.fx(aVar.fmM);
        }
        int i = height - fromDPToPix;
        if (aVar.oxz.getBottom() + fromDPToPix < d.db(aVar.fmM).y) {
            i = (int) (((float) (width - (com.tencent.mm.bv.a.fromDPToPix(aVar.fmM, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i)))) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        aVar.oxz.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new 11(aVar));
        aVar.oBK.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        aVar.oBK.aA(false);
        aVar.oBK.aB(false);
        aVar.oBK.aC(false);
        if (!aVar.oBD) {
            aVar.oBC.oyx = new 7(aVar);
            aVar.oBC.oyy = new 8(aVar);
            aVar.oBC.Fl(aVar.videoPath);
            aVar.oxz.quG = new 9(aVar);
            aVar.oBD = true;
        }
        aVar.oxA.setVisibility(0);
        aVar.oxA.bringToFront();
        aVar.oxA.mkk.setOnClickListener(new 12(aVar));
        aVar.oxA.oDx.setOnClickListener(new OnClickListener(aVar) {
            final /* synthetic */ a oBU;

            {
                this.oBU = r1;
            }

            public final void onClick(View view) {
                this.oBU.bbz();
                if (this.oBU.oBF >= 0 && this.oBU.oBG > 0) {
                    this.oBU.oBN = true;
                }
            }
        });
        aVar.oBQ = true;
    }

    public final void a(MMActivity mMActivity, int i, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        this.scene = i;
        this.videoPath = str;
        this.oxA = videoSeekBarEditorView;
        this.oBC = videoSeekBarEditorView.oDw;
        this.oxz = videoPlayerTextureView;
        this.oBI = viewGroup;
        this.fmM = mMActivity;
        this.osr = videoTransPara;
        this.oBP = z;
        this.oBT = new com.tencent.mm.plugin.mmsight.a.a.b(i);
        this.oBJ = m.fdD.sU();
        m mVar = this.oBJ;
        com.tencent.mm.api.m.a.a aVar = new com.tencent.mm.api.m.a.a();
        aVar.fdF = false;
        aVar.fdH = true;
        aVar.fdE = c.fdJ;
        aVar.fdI = new Rect(this.oxz.getLeft(), this.oxz.getTop(), this.oxz.getRight(), this.oxz.getBottom());
        mVar.a(aVar.tg());
        this.oBK = this.oBJ.ai(this.oBI.getContext());
        this.oBK.a(new 1(this));
        LayoutParams marginLayoutParams = new MarginLayoutParams(-1, -1);
        if (ae.fy(this.fmM)) {
            marginLayoutParams.height = d.aZP().y - ae.fx(this.fmM);
        }
        this.oBI.addView(this.oBK, marginLayoutParams);
        this.oBK.fds = new 5(this);
        if (this.oBP) {
            this.oBK.post(new 6(this));
        }
    }

    final void bbz() {
        this.oxz.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oxA.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ a oBU;

            {
                this.oBU = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.oBU.oxA.setVisibility(8);
                this.oBU.oxA.setAlpha(1.0f);
            }
        });
        this.oBK.aB(true);
        this.oBK.aC(true);
        this.oBK.aA(true);
        this.oBK.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oBQ = false;
    }

    public final void release() {
        try {
            if (this.oBH != null) {
                this.oBH.TG();
                this.oBH = null;
            }
            if (this.oBC != null) {
                this.oBC.release();
            }
            if (this.oBJ != null) {
                this.oBJ.onDestroy();
            }
            if (this.oBI != null) {
                this.oBI.removeView(this.oBK);
            }
            if (this.oxA != null) {
                this.oxA.bbI();
            }
            this.oBD = false;
            j.ouM.Es();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightVideoEditor", e, "release error: %s", e.getMessage());
        }
    }

    public final void gJ(boolean z) {
        int i = 2;
        try {
            this.oBT.hnr = z;
            if (this.oBJ == null) {
                x.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                return;
            }
            k sT = this.oBJ.sT();
            this.oBT.oxb = sT.sY();
            this.oBT.oxc = sT.sX();
            this.oBT.oxe = sT.ta();
            this.oBT.gBx = sT.tb();
            this.oBT.oxf = sT.te();
            this.oBT.textColor = sT.getTextColor();
            com.tencent.mm.plugin.mmsight.a.a.b bVar = this.oBT;
            g gVar = g.pQN;
            Object[] objArr = new Object[12];
            objArr[0] = Integer.valueOf(bVar.scene);
            if (!bVar.hnr) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(bVar.oxb);
            objArr[3] = Integer.valueOf(bVar.oxc);
            objArr[4] = Integer.valueOf(bVar.oxe);
            objArr[5] = Boolean.valueOf(bVar.oxd);
            objArr[6] = Integer.valueOf(bVar.gBx);
            objArr[7] = Integer.valueOf(bVar.owZ);
            objArr[8] = Integer.valueOf(bVar.oxa);
            objArr[9] = Integer.valueOf(bVar.oxf);
            objArr[10] = Integer.valueOf(0);
            objArr[11] = Integer.valueOf(bVar.textColor);
            gVar.h(14362, objArr);
            x.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", bVar.toString());
        } catch (Exception e) {
        }
    }

    public final boolean aeG() {
        if (this.oBQ) {
            bbz();
            return true;
        } else if (this.oBJ != null) {
            return this.oBJ.sS();
        } else {
            return false;
        }
    }
}
