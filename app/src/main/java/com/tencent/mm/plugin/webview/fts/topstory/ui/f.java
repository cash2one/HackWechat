package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebDotPercentIndicator;
import com.tencent.mm.pluginsdk.ui.AbstractVideoView;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

public final class f extends RelativeLayout {
    private static c tpH;
    private boolean acS;
    private String fqu = "";
    private boolean kTc;
    int position;
    b toV;
    h toW;
    private a toX = a.AUTO;
    public FrameLayout toY;
    public TextView toZ;
    private int tpA = c.tpR;
    private View tpB;
    private TextView tpC;
    private ak tpD;
    private int tpE = -1;
    boolean tpF;
    com.tencent.mm.plugin.topstory.a.a.c tpG;
    b tpI = new 15(this);
    private OnClickListener tpJ = new OnClickListener(this) {
        final /* synthetic */ f tpL;

        {
            this.tpL = r1;
        }

        public final void onClick(View view) {
            d.bPB().bPD();
        }
    };
    private OnClickListener tpK = new OnClickListener(this) {
        final /* synthetic */ f tpL;

        {
            this.tpL = r1;
        }

        public final void onClick(View view) {
            d.bPB().a(this.tpL, true);
            if (this.tpL.toW != null) {
                this.tpL.toW.bPF();
                this.tpL.toW = null;
            }
        }
    };
    TopStoryVideoViewControlBar tpa;
    public View tpb;
    public View tpc;
    public View tpd;
    private View tpe;
    public View tpf;
    public LinearLayout tpg;
    private FtsWebDotPercentIndicator tph;
    private TextView tpi;
    private ImageView tpj;
    public ImageView tpk;
    public ImageView tpl;
    public ImageView tpm;
    private Button tpn;
    private TextView tpo;
    public TextView tpp;
    private TextView tpq;
    private com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a tpr;
    private com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a tps;
    public ImageView tpt;
    public TextView tpu;
    public ImageView tpv;
    private View tpw;
    public FrameLayout tpx;
    private ImageView tpy;
    private ImageView tpz;

    private enum a {
        AUTO,
        LANDSCAPE,
        PORTRAIT
    }

    static /* synthetic */ boolean r(f fVar) {
        return !fVar.bPY();
    }

    public f(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.i.dtb, this);
        this.toY = (FrameLayout) findViewById(R.h.cVE);
        this.toZ = (TextView) findViewById(R.h.cEc);
        this.tpb = findViewById(R.h.cUE);
        this.tpc = findViewById(R.h.cVy);
        this.tpd = findViewById(R.h.cUF);
        this.tpg = (LinearLayout) findViewById(R.h.bJx);
        this.tpe = findViewById(R.h.cUZ);
        this.tph = (FtsWebDotPercentIndicator) findViewById(R.h.bJy);
        this.tpi = (TextView) findViewById(R.h.bJv);
        this.tpj = (ImageView) findViewById(R.h.bJw);
        this.tpw = findViewById(R.h.cVc);
        this.tpk = (ImageView) findViewById(R.h.bZs);
        this.tpq = (TextView) findViewById(R.h.cVv);
        this.tph.bQj();
        this.tpl = (ImageView) findViewById(R.h.bZn);
        this.tpm = (ImageView) findViewById(R.h.bZo);
        this.tpp = (TextView) findViewById(R.h.cHD);
        this.tpn = (Button) findViewById(R.h.cRO);
        this.tpo = (TextView) findViewById(R.h.cRP);
        this.tpt = (ImageView) findViewById(R.h.cfH);
        this.tpu = (TextView) findViewById(R.h.ckq);
        this.tpv = (ImageView) findViewById(R.h.cNM);
        this.tpf = findViewById(R.h.ckm);
        this.tpB = findViewById(R.h.cCH);
        this.tpC = (TextView) findViewById(R.h.cCI);
        this.tpf.setVisibility(8);
        this.tpt.setOnClickListener(this.tpJ);
        this.tpy = (ImageView) findViewById(R.h.cCL);
        this.tpz = (ImageView) findViewById(R.h.cCK);
        this.tpx = (FrameLayout) findViewById(R.h.cCM);
        this.tpn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f tpL;

            {
                this.tpL = r1;
            }

            public final void onClick(View view) {
                if (this.tpL.tpA == c.tpS) {
                    ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFp();
                }
                if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
                    if (g.bQd().tpZ) {
                        g.bQd().bEA();
                    } else {
                        this.tpL.kg(true);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(791, 19);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(791, 20);
            }
        });
        this.tpB.setOnClickListener(new 10(this));
        this.tpl.setOnClickListener(new 11(this));
        this.tpm.setOnClickListener(new 12(this));
        this.tpb.setOnClickListener(new 13(this));
        this.tpv.setOnClickListener(new 14(this));
        this.tps = new com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a(getContext(), this, new b(this));
        this.tpr = new com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a(getContext(), this, new b(this));
        this.tpr.tqr = true;
        this.tpr.tqq = true;
        this.tpa = new TopStoryVideoViewControlBar(getContext());
        this.tpa.setVisibility(8);
        this.tpa.l(this.tpK);
        this.tpa.m(this.tpJ);
        this.tpa.tqD = new 2(this);
        this.tpa.k(new 3(this));
        this.tpa.quk = new 4(this);
        this.tpa.i(new 5(this));
        this.tpa.trx = new 6(this);
        TopStoryVideoViewControlBar topStoryVideoViewControlBar = this.tpa;
        topStoryVideoViewControlBar.tqz.setOnClickListener(new 7(this));
    }

    public final void bPN() {
        this.fqu = UUID.randomUUID().toString();
    }

    public final void bPO() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setPlayingContainerStatus");
        this.tpb.setVisibility(8);
        this.tpk.setVisibility(8);
        this.tpg.setVisibility(8);
        this.toZ.setVisibility(8);
        this.toY.setVisibility(0);
        this.toY.setAlpha(1.0f);
    }

    public final void bPP() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setStopContainerStatus");
        this.tpk.setVisibility(0);
        this.tpb.setVisibility(0);
        this.tpt.setVisibility(8);
        this.tpu.setVisibility(8);
        this.tpv.setVisibility(8);
        this.tpx.setVisibility(8);
        this.tpc.setVisibility(8);
        this.tpd.setVisibility(0);
        this.tpf.setVisibility(8);
        this.tpl.setVisibility(0);
        this.tpm.setVisibility(8);
        this.tpp.setVisibility(8);
        if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFn()) {
            this.tpq.setText(bh.a(this.tpG.seM, 100.0d));
            this.tpq.setVisibility(0);
            return;
        }
        this.tpq.setVisibility(8);
    }

    public final void bPQ() {
        eJ(bPS(), this.toV.bPx().getString(R.l.eTp));
    }

    public final void eJ(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setWarningTipContainerStatus %s %s", new Object[]{str, str2});
        this.tpk.setVisibility(0);
        this.tpb.setVisibility(0);
        this.tpt.setVisibility(8);
        this.tpu.setVisibility(8);
        this.tpv.setVisibility(8);
        this.tpc.setVisibility(0);
        this.tpd.setVisibility(8);
        this.tpf.setVisibility(8);
        this.tpe.setVisibility(0);
        this.tpw.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.tpo.setVisibility(8);
        } else {
            this.tpo.setText(str);
            this.tpo.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.tpn.setVisibility(8);
            return;
        }
        this.tpn.setText(str2);
        this.tpn.setVisibility(0);
    }

    public final void bPR() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setReplayContainerStatus");
        this.tpk.setVisibility(0);
        this.tpb.setVisibility(0);
        this.toZ.setVisibility(8);
        this.tpg.setVisibility(8);
        this.tpc.setVisibility(8);
        this.tpd.setVisibility(0);
        this.tpl.setVisibility(8);
        this.tpq.setVisibility(8);
        this.tpm.setVisibility(0);
        this.tpp.setVisibility(0);
        if (d.bPB().nbV) {
            this.tpt.setVisibility(0);
            this.tpu.setVisibility(0);
            this.tpv.setVisibility(0);
        } else {
            this.tpt.setVisibility(8);
            this.tpu.setVisibility(8);
            this.tpv.setVisibility(8);
        }
        if (this.tpF && ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCc()) {
            this.tpf.setVisibility(0);
        } else {
            this.tpf.setVisibility(8);
        }
    }

    static {
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDA = true;
        aVar.hDz = true;
        tpH = aVar.PK();
    }

    private String bPS() {
        return getContext().getString(R.l.eTf);
    }

    public final boolean kg(boolean z) {
        if (!((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
            this.tpA = c.tpT;
            this.tpa.setVisibility(8);
            eJ(bPS(), getContext().getString(R.l.eTp));
            return false;
        } else if (z && ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFn() && !((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFo()) {
            String string;
            this.tpA = c.tpS;
            this.tpa.setVisibility(8);
            if (this.tpG.seM == 0) {
                string = getContext().getString(R.l.eTh);
            } else {
                string = getContext().getString(R.l.eTg, new Object[]{bh.a(this.tpG.seM, 100.0d)});
            }
            eJ(string, getContext().getString(R.l.eST));
            return false;
        } else {
            bPN();
            this.tpA = c.tpR;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setStartPlayContainerStatus");
            this.tpb.setVisibility(0);
            this.tpt.setVisibility(8);
            this.tpu.setVisibility(8);
            this.tpv.setVisibility(8);
            this.tpd.setVisibility(8);
            this.tpf.setVisibility(8);
            this.tpx.setVisibility(8);
            this.tpc.setVisibility(0);
            this.tpe.setVisibility(8);
            this.tpw.setVisibility(0);
            this.tpw.setVisibility(0);
            this.tpw.setAlpha(0.0f);
            this.tpw.animate().setDuration(2000).setInterpolator(new AccelerateInterpolator()).alpha(1.0f).start();
            this.tpk.setVisibility(0);
            this.tpg.setVisibility(8);
            this.toZ.setVisibility(8);
            this.toY.setVisibility(0);
            this.toY.setAlpha(0.0f);
            this.tpa.bQs();
            g bQd = g.bQd();
            if (bQd.tpX == null) {
                AbstractVideoView topStoryVideoView = new TopStoryVideoView(ac.getContext());
                topStoryVideoView.tqb = bQd.tqb;
                bQd.tpX = topStoryVideoView;
            }
            if (bQd.tpX.getParent() != null) {
                ((ViewGroup) bQd.tpX.getParent()).removeView(bQd.tpX);
            }
            this.toY.addView(bQd.tpX);
            bQd.tpX.a(this.tpa);
            bQd.tpX.jte = this.tpI;
            bQd.tpW.a(bQd.tqc);
            g bQd2 = g.bQd();
            com.tencent.mm.plugin.topstory.a.a.c cVar = this.tpG;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewMgr", "start play %s %s", new Object[]{cVar.title, this.fqu});
            if (bQd2.tpY != null) {
                if (!bQd2.tpY.seK.equals(cVar.seK)) {
                    bQd2.tpX.stop();
                    d.bPs();
                }
                return true;
            }
            bQd2.tpX.b(false, cVar.videoUrl, cVar.sex);
            bQd2.tpX.setMute(false);
            bQd2.tpX.setKeepScreenOn(true);
            bQd2.tpX.Oh(r4);
            bQd2.tpX.bPM();
            bQd2.tpY = cVar;
            bQd2.tpZ = true;
            bQd2.tqa = false;
            bQd2.bQe();
            return true;
        }
    }

    final void au() {
        this.tpk.setImageDrawable(null);
        o.PA().a(this.tpG.sew, this.tpk, tpH);
        this.toX = a.LANDSCAPE;
        this.tpa.wl(this.tpG.sex);
        TopStoryVideoViewControlBar topStoryVideoViewControlBar = this.tpa;
        topStoryVideoViewControlBar.tqA.setText(this.tpG.title);
        this.tpu.setText(this.tpG.title);
        if (this.toW != null && this.toW.hashCode() != ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFr()) {
            if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
                bPP();
            } else {
                eJ(bPS(), getContext().getString(R.l.eTp));
            }
        }
    }

    public static void seekTo(int i) {
        int ahk = g.bQd().ahk();
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "seek to position=%d current=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(ahk)});
        g bQd = g.bQd();
        if (bQd.tpX != null) {
            bQd.tpX.s(i, true);
        }
        if (d.tnO != null) {
            d.tnO.set = 1;
        }
    }

    public final void bPT() {
        if (this.tpa != null) {
            this.tpa.setVisibility(8);
        }
    }

    public final void bPU() {
        if (this.tpa != null) {
            this.tpa.ki(false);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.kTc = z;
        g.bQd().setMute(z);
        if (z) {
            this.tpa.At();
        } else {
            this.tpa.bQp();
        }
    }

    public final void bPV() {
        bPR();
        if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCc()) {
            if (this.tpD == null) {
                this.tpD = new ak(Looper.getMainLooper(), new 16(this), true);
            }
            this.tpE = 2;
            this.tpC.setVisibility(0);
            this.tpC.setText(getContext().getString(R.l.eCv, new Object[]{Integer.valueOf(this.tpE)}));
            this.tpD.J(1000, 1000);
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "%s startPlayNextCountDown, position: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.position)});
            return;
        }
        bPW();
    }

    public final void bPW() {
        if (this.tpD != null) {
            this.tpD.TG();
        }
        this.tpC.setVisibility(8);
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "%s stopPlayNextCountDown, position: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.position)});
    }

    public final void kh(boolean z) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "playNextVideo %b", new Object[]{Boolean.valueOf(z)});
        if (this.position + 1 < com.tencent.mm.plugin.webview.fts.topstory.a.b.bPn() - 1) {
            this.position++;
            this.tpG = (com.tencent.mm.plugin.topstory.a.a.c) com.tencent.mm.plugin.webview.fts.topstory.a.b.tnu.get(this.position);
            au();
            if (z) {
                d.tnP = 1;
            }
            kg(true);
            return;
        }
        this.toV.a(new 17(this));
        bPT();
        this.tpF = false;
        bPR();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (d.bPB().nbV) {
            if (this.tpr != null) {
                this.tpr.F(motionEvent);
            }
        } else if (this.tps != null) {
            this.tps.F(motionEvent);
        }
        return true;
    }

    public final void bPX() {
        if (((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3) <= 1) {
            setMute(true);
        } else {
            setMute(false);
        }
    }

    private boolean bPY() {
        return this.tpb.getVisibility() == 0;
    }

    public final void ej(int i, int i2) {
        if (i == 0) {
            if (g.bQd().tpZ) {
                bPO();
            } else {
                bPP();
            }
        } else if (i2 == 0) {
            bPQ();
        }
    }
}
