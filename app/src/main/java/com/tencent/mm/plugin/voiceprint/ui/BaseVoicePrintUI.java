package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.plugin.voiceprint.ui.a.7;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private boolean nUA = false;
    private final ak nUJ = new ak(new 3(this), true);
    String sgZ = null;
    ak shA = new ak(new 4(this), true);
    private af shB = new af(Looper.getMainLooper(), new 5(this));
    Button shq;
    View shr;
    VoicePrintVolumeMeter shs;
    VoiceTipInfoView sht;
    p shu = null;
    String shv = null;
    private boolean shw = false;
    private View shx;
    private boolean shy = false;
    private final a shz = new 1(this);

    protected abstract void aWr();

    protected abstract void bFM();

    static /* synthetic */ void a(BaseVoicePrintUI baseVoicePrintUI, float f) {
        float f2 = 10.0f;
        if (f >= 10.0f) {
            f2 = f;
        }
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.shs;
        f2 /= 100.0f;
        if (f2 > voicePrintVolumeMeter.mVolume) {
            voicePrintVolumeMeter.sit = true;
        } else {
            voicePrintVolumeMeter.sit = false;
        }
        voicePrintVolumeMeter.mVolume = f2;
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.shx.setVisibility(0);
        if (baseVoicePrintUI.shy) {
            baseVoicePrintUI.shx.setVisibility(0);
            return;
        }
        baseVoicePrintUI.shy = true;
        View view = baseVoicePrintUI.shx;
        View view2 = baseVoicePrintUI.shq;
        a.a 8 = new 8(baseVoicePrintUI);
        view.clearAnimation();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", new Object[]{Arrays.toString(iArr)});
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", new Object[]{Integer.valueOf(iArr[1] - iArr2[1])});
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new 7(8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sht = (VoiceTipInfoView) findViewById(R.h.cRQ);
        this.shq = (Button) findViewById(R.h.cGt);
        this.shr = findViewById(R.h.cYu);
        this.shs = (VoicePrintVolumeMeter) findViewById(R.h.cYv);
        this.shx = findViewById(R.h.bPj);
        this.sht.bGa();
        this.shs.nVo = this.shq;
        this.shu = new p();
        this.shu.shl = this.shz;
        this.shq.setOnTouchListener(new 10(this));
        findViewById(R.h.csK).setOnClickListener(new 2(this));
        aWr();
    }

    protected final void bFJ() {
        ag.h(new 7(this), 1300);
    }

    protected final void bFK() {
        if (this.shx.getVisibility() != 4 && this.shx.getVisibility() != 8) {
            if (this.shy) {
                this.shx.setVisibility(4);
                return;
            }
            this.shy = true;
            a.a(this.shx, this, new 9(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.dtD;
    }

    protected void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.shs;
        voicePrintVolumeMeter.sif.TG();
        voicePrintVolumeMeter.sie.oAt.getLooper().quit();
        x.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        x.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(m.aJ("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(m.aJ("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    protected final void bFL() {
        yr(R.l.eTE);
    }

    protected final void yr(int i) {
        this.sht.bFW();
        this.sht.yt(i);
        this.sht.bFZ();
    }
}
