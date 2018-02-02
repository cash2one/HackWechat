package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.e.b.j;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.v;
import java.io.File;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] kDX = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kDY = new int[]{R.g.byC, R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI};
    private long duration;
    private int kDQ;
    private long kEb = -1;
    private Toast kEc;
    private ImageView kEg;
    private boolean kEo;
    private boolean kEp;
    private final ak kEu = new ak(new 1(this), true);
    private final ak kEv = new ak(new 7(this), true);
    private final af kEx = new 6(this);
    private Button myD;
    private long myE;
    private View myF;
    private View myG;
    private View myH;
    private View myI;
    private TextView myJ;
    private View myK;
    private j myL;
    boolean myM = false;
    private String path;

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.myD.setKeepScreenOn(true);
        favPostVoiceUI.myD.setBackgroundResource(R.g.bFh);
        favPostVoiceUI.myD.setText(R.l.egq);
        favPostVoiceUI.kEp = false;
        favPostVoiceUI.myL = favPostVoiceUI.aJM();
        if (favPostVoiceUI.myL.cK(favPostVoiceUI.path)) {
            favPostVoiceUI.myE = bh.Wq();
            favPostVoiceUI.kEv.J(200, 200);
            favPostVoiceUI.kEg.setVisibility(0);
            favPostVoiceUI.kEu.J(100, 100);
            favPostVoiceUI.myJ.setText(R.l.efR);
            return;
        }
        favPostVoiceUI.myE = 0;
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.myD.setKeepScreenOn(false);
        favPostVoiceUI.myL.vi();
        favPostVoiceUI.kEu.TG();
        favPostVoiceUI.kEv.TG();
        favPostVoiceUI.aJP();
        favPostVoiceUI.aJO();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(v.fv(this).inflate(R.i.dhI, null));
        this.kEg = (ImageView) findViewById(R.h.cWI);
        this.myH = findViewById(R.h.cWJ);
        this.myI = findViewById(R.h.cWL);
        this.myF = findViewById(R.h.cWP);
        this.myG = findViewById(R.h.cWQ);
        this.myJ = (TextView) findViewById(R.h.cWR);
        this.myK = findViewById(R.h.cWK);
        findViewById(R.h.cWH).setVisibility(8);
        this.myK.setVisibility(8);
        findViewById(R.h.cWH).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavPostVoiceUI myN;

            {
                this.myN = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.myN.aJQ();
                return false;
            }
        });
        findViewById(R.h.cgU).setVisibility(8);
        this.myL = aJM();
        this.myD = (Button) findViewById(R.h.cgT);
        this.myD.setOnTouchListener(new 5(this));
        aJO();
        String aIF = com.tencent.mm.plugin.favorite.a.j.aIF();
        File file = new File(aIF);
        if (!file.exists()) {
            file.mkdirs();
        }
        do {
            str = aIF + "/" + System.currentTimeMillis();
        } while (new File(str).exists());
        this.path = str;
        this.myJ.post(new 3(this));
    }

    private j aJM() {
        a aVar = a.gBX;
        j jVar = new j();
        jVar.fmg = new j.a(this) {
            final /* synthetic */ FavPostVoiceUI myN;

            {
                this.myN = r1;
            }

            public final void onError() {
                this.myN.kEu.TG();
                this.myN.kEv.TG();
            }
        };
        return jVar;
    }

    private void aJN() {
        long j = 0;
        if (this.kEo) {
            boolean z;
            this.myD.setKeepScreenOn(true);
            this.myD.setBackgroundResource(R.g.bFg);
            this.myD.setText(R.l.egc);
            this.myL.vi();
            if (this.myE != 0) {
                j = bh.bA(this.myE);
            }
            this.duration = j;
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.kEu.TG();
            this.kEv.TG();
            if (z) {
                aJP();
                this.myD.setEnabled(false);
                this.myD.setBackgroundResource(R.g.bFf);
                this.myG.setVisibility(0);
                this.myF.setVisibility(8);
                this.kEx.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (bh.ov(str)) {
                    x.e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    f fVar = new f();
                    fVar.field_type = 3;
                    fVar.field_sourceType = 6;
                    c.j(fVar);
                    uq uqVar = new uq();
                    uqVar.TE(str);
                    uqVar.CI(i);
                    uqVar.lt(true);
                    uqVar.CJ(fVar.field_type);
                    uqVar.TA("amr");
                    fVar.field_favProto.weU.add(uqVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    g.pQN.h(10648, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.kEo = false;
        }
    }

    public final void aJO() {
        this.myF.setVisibility(0);
        this.myG.setVisibility(8);
        this.myI.setVisibility(8);
        this.myH.setVisibility(0);
        this.myJ.setText(R.l.eAV);
        this.myD.setBackgroundResource(R.g.bFh);
        this.myD.setText(R.l.egc);
        this.kEg.setVisibility(4);
        this.kEo = false;
    }

    private void aJP() {
        File file = new File(this.path);
        if (file.exists()) {
            file.delete();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        aJN();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        aJQ();
        return true;
    }

    private void aJQ() {
        if (!this.myM) {
            this.myM = true;
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(300);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new 8(this));
            findViewById(R.h.cWH).setVisibility(8);
            findViewById(R.h.cgU).setVisibility(8);
            this.myK.setVisibility(8);
            this.myK.startAnimation(alphaAnimation);
            findViewById(R.h.cWH).startAnimation(alphaAnimation);
            findViewById(R.h.cgU).startAnimation(translateAnimation);
        }
    }
}
