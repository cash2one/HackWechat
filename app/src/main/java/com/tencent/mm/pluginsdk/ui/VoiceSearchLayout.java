package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] kDY = new int[]{R.g.bHC, R.g.bHD, R.g.bHE, R.g.bHF, R.g.bHq, R.g.bHr, R.g.bHs, R.g.bHt, R.g.bHu, R.g.bHv, R.g.bHw, R.g.bHx, R.g.bHy, R.g.bHz};
    private static final int[] vmG = new int[]{R.g.bHC, R.g.bHC, R.g.bHC, R.g.bHD, R.g.bHE, R.g.bHD, R.g.bHC, R.g.bHF, R.g.bHC, R.g.bHC};
    private static final int[] vmH = new int[]{R.g.bHA, R.g.bHB, R.g.bHB, R.g.bHB, R.g.bHA};
    public boolean fAs = false;
    private int fqe = 0;
    public final ak kEu = new ak(new 1(this), true);
    public View lWv = null;
    public int vmA = 0;
    public b vmB;
    public View vmC;
    public AnimationDrawable vmD;
    public e vmE;
    private boolean vmF = false;
    private int vmI = 0;
    private int vmJ = 0;
    public int vmK = 0;
    public a vmx = null;
    public Button vmy;
    public boolean vmz = false;

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i) {
        if (voiceSearchLayout.vmy != null) {
            voiceSearchLayout.vmy.setBackgroundResource(i);
        }
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.vmJ + 1;
        voiceSearchLayout.vmJ = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fqe - 1;
        voiceSearchLayout.fqe = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fqe + 1;
        voiceSearchLayout.fqe = i;
        return i;
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        voiceSearchLayout.vmz = true;
        voiceSearchLayout.kY(true);
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lWv = inflate(context, R.i.cWW, this);
        this.vmy = (Button) this.lWv.findViewById(R.h.cWY);
        this.vmC = this.lWv.findViewById(R.h.cWV);
        kY(false);
        reset();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.vmz) {
            caJ();
        }
        return true;
    }

    public final void caJ() {
        x.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.fAs);
        if (this.fAs) {
            caz();
            this.fAs = false;
        }
    }

    public final void caz() {
        x.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.fAs);
        if (this.fAs) {
            this.fAs = false;
            if (this.vmx != null) {
                this.vmx.caO();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.vmB != null) {
                this.vmB.kZ(false);
            }
        }
        xT();
        if (this.vmE != null) {
            this.vmE.cancel();
        }
        if (this.kEu != null) {
            this.kEu.TG();
        }
    }

    public final void reset() {
        kY(false);
        this.fAs = false;
        this.vmz = false;
        this.vmy.setBackgroundResource(R.g.bHp);
        this.vmC.setBackgroundDrawable(getResources().getDrawable(R.g.bHo));
    }

    private void kY(boolean z) {
        if (z) {
            this.vmy.setBackgroundResource(R.g.bHm);
            this.vmD = (AnimationDrawable) this.vmy.getBackground();
            if (this.vmD != null) {
                this.vmD.start();
                return;
            }
            return;
        }
        this.vmy.setBackgroundResource(R.g.bHp);
    }

    public void setVisibility(int i) {
        if (super.getVisibility() != i && !this.vmF) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bqa);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bpZ);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.vmB != null) {
                this.vmB.kZ(i == 0);
            }
        }
    }

    public final void BV(int i) {
        LayoutParams layoutParams = (LayoutParams) this.vmC.getLayoutParams();
        layoutParams.topMargin = i;
        this.vmC.setLayoutParams(layoutParams);
    }

    public final void a(boolean z, i iVar) {
        if (z) {
            x.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            ar.Hh().xS();
        } else {
            xT();
        }
        MediaPlayer jVar = new j();
        if (z) {
            try {
                jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dzU));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                return;
            }
        }
        jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dzw));
        jVar.setAudioStreamType(5);
        jVar.setOnCompletionListener(new 2(this, null));
        jVar.setOnErrorListener(new 3(this, null));
        jVar.prepare();
        jVar.setLooping(false);
        jVar.start();
    }

    private static void xT() {
        x.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        ar.Hh().xT();
    }
}
