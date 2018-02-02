package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.plugin.voiceprint.ui.a.6;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import org.xwalk.core.R$styleable;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private View lpA = null;
    private int sgY = 1;
    private l shM;
    private o shN = null;
    private View shO;
    private NoiseDetectMaskView shP;
    private Button shQ = null;
    private int shR = 0;
    private c shS = new c<sk>(this) {
        final /* synthetic */ VoiceCreateUI shT;

        {
            this.shT = r2;
            this.xen = sk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", Boolean.valueOf(((sk) bVar).fKf.fKg));
            if (((sk) bVar).fKf.fKg) {
                VoiceCreateUI.a(this.shT);
            } else {
                VoiceCreateUI.b(this.shT);
            }
            return false;
        }
    };

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        g.pQN.h(11390, Integer.valueOf(4));
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.shP;
        if (noiseDetectMaskView.lpy != null) {
            noiseDetectMaskView.lpy.setVisibility(8);
        }
        noiseDetectMaskView.shF.setText(R.l.eTH);
        noiseDetectMaskView.shG.setVisibility(0);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.lpA.setVisibility(0);
        voiceCreateUI.shO.setVisibility(0);
        voiceCreateUI.shr.setVisibility(0);
        View view = voiceCreateUI.shP;
        a.a 6 = new 6(voiceCreateUI);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new 6(6));
        view.startAnimation(translateAnimation);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.sht.bFV();
        voiceCreateUI.sgY = 1;
        voiceCreateUI.shM.sgY = 71;
        ar.CG().a(new d(71, ""), 0);
    }

    protected final void bFM() {
        x.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.shv);
        if (!bh.ov(this.shv)) {
            this.shq.setEnabled(false);
            this.sht.bFV();
            l lVar;
            k fVar;
            if (this.sgY == 1) {
                lVar = this.shM;
                fVar = new f(this.shv, 71, lVar.sha, 0);
                fVar.sgG = true;
                ar.CG().a(fVar, 0);
                lVar.sgY = 71;
            } else if (this.sgY == 2) {
                lVar = this.shM;
                fVar = new f(this.shv, 72, lVar.sha, lVar.sgJ);
                fVar.sgG = true;
                ar.CG().a(fVar, 0);
                lVar.sgY = 72;
            }
        }
    }

    protected final void aWr() {
        this.shM = new l(this);
        findViewById(R.h.cId).setVisibility(8);
        this.sht.ys(R.l.eTI);
        this.sht.bFY();
        this.shq.setEnabled(false);
        this.shN = new o();
        this.shO = findViewById(R.h.cWh);
        this.shP = (NoiseDetectMaskView) findViewById(R.h.mask);
        this.lpA = findViewById(R.h.csK);
        this.shQ = (Button) findViewById(R.h.cId);
        this.shQ.setVisibility(8);
        this.shQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI shT;

            {
                this.shT = r1;
            }

            public final void onClick(View view) {
                this.shT.bFK();
                a.a(this.shT.sht, new 1(this));
            }
        });
        this.shP.shH = new 3(this);
        this.shP.shI = new NoiseDetectMaskView$a(this) {
            final /* synthetic */ VoiceCreateUI shT;

            {
                this.shT = r1;
            }

            public final void bFP() {
                this.shT.bFS();
                o f = this.shT.shN;
                x.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                f.shd.vi();
                f.she.TG();
                this.shT.finish();
            }
        };
        com.tencent.mm.sdk.b.a.xef.b(this.shS);
        this.lpA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI shT;

            {
                this.shT = r1;
            }

            public final void onClick(View view) {
                this.shT.bFS();
                this.shT.finish();
            }
        });
        start();
    }

    private void start() {
        x.d("MicroMsg.VoiceCreateUI", "start create");
        this.shN.reset();
        NoiseDetectMaskView noiseDetectMaskView = this.shP;
        if (noiseDetectMaskView.lpy != null) {
            noiseDetectMaskView.lpy.setVisibility(0);
        }
        noiseDetectMaskView.shF.setText(R.l.eTF);
        noiseDetectMaskView.shG.setVisibility(8);
        x.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.lpA.setVisibility(4);
        this.shO.setVisibility(4);
        this.shr.setVisibility(4);
        this.shP.setVisibility(0);
        o oVar = this.shN;
        x.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        oVar.reset();
        if (oVar.shd.cI(m.aJ("voice_pt_voice_print_noise_detect.rec", true))) {
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            oVar.shd.vi();
            oVar.reset();
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        oVar.she.J(100, 100);
    }

    public final void My(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        bFJ();
        this.sgZ = str;
        this.sht.bFW();
        this.sht.bFX();
        this.sht.MB(str);
        this.shq.setEnabled(true);
    }

    public final void Mz(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.sgZ = str;
        this.sht.bFW();
        this.sht.bFX();
        this.sht.MB(str);
        this.shq.setEnabled(true);
    }

    public final void v(boolean z, int i) {
        x.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            switch (i) {
                case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.shq.setEnabled(false);
                    this.sgY = 2;
                    bFK();
                    a.a(this.sht, new 7(this));
                    return;
                case 72:
                    this.shR = 0;
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                return;
            case 72:
                bFS();
                this.shR++;
                if (this.shR >= 2) {
                    x.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.shR = 0;
                    startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                    overridePendingTransition(R.a.bqB, R.a.bqA);
                    finish();
                    return;
                }
                this.shq.setEnabled(true);
                this.sht.bFW();
                this.sht.yt(R.l.eTK);
                this.sht.bFZ();
                return;
            default:
                return;
        }
    }

    public final void bFF() {
        bFL();
        bFS();
    }

    private void bFS() {
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.shM;
        ar.CG().b(611, eVar);
        ar.CG().b(612, eVar);
        eVar.shb = null;
        com.tencent.mm.sdk.b.a.xef.c(this.shS);
    }

    public void onBackPressed() {
        super.onBackPressed();
        bFS();
    }
}
