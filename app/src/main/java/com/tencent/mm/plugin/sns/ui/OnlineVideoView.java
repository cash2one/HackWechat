package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.af.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.z.d;

public class OnlineVideoView extends RelativeLayout implements a, f.a, d.a {
    private int duration;
    private aqr fHC;
    private int fHZ;
    private boolean fIa;
    private int fIb;
    private String fus;
    private int hzW;
    private d jtl;
    af kRY;
    boolean kTc;
    f kTe;
    private ak kTk;
    private Context mContext;
    private boolean mvA;
    private boolean mvB;
    private int mvC;
    private ProgressBar mvE;
    private MMPinProgressBtn mvF;
    ImageView mvy;
    private TextView mvz;
    private RelativeLayout mxu;
    private b opG;
    private an qQS;
    private c qXG;
    private boolean ruK;
    private e ruN;
    private int ruR;
    boolean ruS;
    String ruT;
    private boolean ruU;
    private a ruV;
    private TextView ruW;
    private af ruX;
    private boolean ruY;
    private boolean ruZ;
    private int rva;
    private int rvb;
    private long rvc;
    private long rvd;
    private ak rve;
    private com.tencent.mm.plugin.sns.model.b.b rvf;
    private c rvg;
    c rvh;
    private long rvi;
    private int rvj;

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i) {
        if (onlineVideoView.fIb > 0) {
            x.w("MicroMsg.OnlineVideoView", "send video now, do nothing.");
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d retransmit video req code %d, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), ap.a(onlineVideoView.fus, onlineVideoView.fHC));
        if (bh.ov(ap.a(onlineVideoView.fus, onlineVideoView.fHC))) {
            onlineVideoView.fIb = i;
            onlineVideoView.t(true, 33);
            onlineVideoView.alw();
            g.pQN.a(354, 223, 1, false);
            return;
        }
        onlineVideoView.xw(i);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i, boolean z) {
        if (onlineVideoView.fHZ > 0) {
            x.w("MicroMsg.OnlineVideoView", "fav video now, do nothing.");
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d fav video req code %d fromMain %b, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), Boolean.valueOf(z), ap.a(onlineVideoView.fus, onlineVideoView.fHC));
        if (bh.ov(ap.a(onlineVideoView.fus, onlineVideoView.fHC))) {
            onlineVideoView.fHZ = i;
            onlineVideoView.fIa = z;
            onlineVideoView.t(true, 35);
            onlineVideoView.alw();
            g.pQN.a(354, 224, 1, false);
            return;
        }
        onlineVideoView.N(i, z);
    }

    static /* synthetic */ void p(OnlineVideoView onlineVideoView) {
        x.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), ap.a(onlineVideoView.fus, onlineVideoView.fHC));
        if (bh.ov(ap.a(onlineVideoView.fus, onlineVideoView.fHC))) {
            onlineVideoView.ruU = true;
            onlineVideoView.t(true, 34);
            onlineVideoView.alw();
            g.pQN.a(354, 220, 1, false);
            return;
        }
        onlineVideoView.bzK();
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ruR = 0;
        this.ruS = false;
        this.mvA = false;
        this.kTc = false;
        this.fHC = null;
        this.ruU = false;
        this.ruX = null;
        this.ruZ = false;
        this.duration = 0;
        this.rva = 0;
        this.rvb = 0;
        this.rvc = 0;
        this.rvd = 0;
        this.mvC = 0;
        this.kRY = new af(Looper.getMainLooper());
        this.rve = new ak(new 16(this), true);
        this.kTk = new ak(new 17(this), true);
        this.rvf = new com.tencent.mm.plugin.sns.model.b.b(this) {
            final /* synthetic */ OnlineVideoView rvm;

            {
                this.rvm = r1;
            }

            public final void JT(String str) {
            }

            public final void aE(String str, boolean z) {
            }

            public final void bun() {
            }

            public final void aF(String str, boolean z) {
                this.rvm.kRY.postDelayed(new 1(this, z, str), 100);
            }
        };
        this.rvg = new c<qm>(this) {
            final /* synthetic */ OnlineVideoView rvm;

            {
                this.rvm = r2;
                this.xen = qm.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qm qmVar = (qm) bVar;
                x.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", Integer.valueOf(this.rvm.hashCode()), qmVar.fHY.fus, this.rvm.fus);
                if (bh.fu(qmVar.fHY.fus, this.rvm.fus)) {
                    if (qmVar.fHY.fuL == 1) {
                        OnlineVideoView.a(this.rvm, qmVar.fHY.fIb);
                    } else if (qmVar.fHY.fuL == 2) {
                        OnlineVideoView.a(this.rvm, qmVar.fHY.fHZ, qmVar.fHY.fIa);
                    } else if (qmVar.fHY.fuL == 3) {
                        OnlineVideoView.p(this.rvm);
                    }
                }
                return false;
            }
        };
        this.rvh = new 4(this);
        this.qXG = new 5(this);
        this.ruN = new e(this) {
            final /* synthetic */ OnlineVideoView rvm;

            {
                this.rvm = r1;
            }

            public final void bbH() {
                x.i("MicroMsg.OnlineVideoView", "%d on texture update.", Integer.valueOf(this.rvm.hashCode()));
                try {
                    this.rvm.a(true, 1.0f);
                } catch (Exception e) {
                    x.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.opG = new 7(this);
        this.mContext = context;
        x.i("MicroMsg.OnlineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(i.g.qIl, this);
        this.mvy = (ImageView) findViewById(i.f.cVw);
        this.mxu = (RelativeLayout) findViewById(i.f.cVu);
        this.ruW = (TextView) findViewById(i.f.cUS);
        this.ruW.setVisibility(8);
        this.mvF = (MMPinProgressBtn) findViewById(i.f.cVj);
        this.mvE = (ProgressBar) findViewById(i.f.cVb);
        this.mvz = (TextView) findViewById(i.f.cVz);
        com.tencent.mm.modelcontrol.d.MU();
        if (com.tencent.mm.modelcontrol.d.Nb()) {
            this.mvB = true;
            this.kTe = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.kTe).opG = this.opG;
            ((VideoPlayerTextureView) this.kTe).vyj = true;
            g.pQN.a(354, 148, 1, false);
        } else {
            this.mvB = false;
            this.kTe = new VideoTextureView(context);
            g.pQN.a(354, 149, 1, false);
        }
        this.kTe.a((f.a) this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mxu.addView((View) this.kTe, layoutParams);
        a(false, 0.0f);
    }

    public final void bzJ() {
        x.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        com.tencent.mm.sdk.b.a.xef.c(this.rvh);
    }

    public final void a(aqr com_tencent_mm_protocal_c_aqr, String str, int i) {
        this.fus = str;
        this.hzW = i;
        an ciT = an.ciT();
        ciT.time = this.hzW;
        this.qQS = ciT;
        if (this.fHC != com_tencent_mm_protocal_c_aqr) {
            this.fHC = com_tencent_mm_protocal_c_aqr;
            boolean c = ae.bvs().c(this.fHC, this.mvy, i.e.black, this.mContext.hashCode(), this.qQS);
            x.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(c));
        }
        this.ruS = false;
        x.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", Integer.valueOf(hashCode()), this.fus, Integer.valueOf(this.hzW), Boolean.valueOf(this.ruS));
    }

    public final void onResume() {
        x.d("MicroMsg.OnlineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bh.cgy());
        this.rvc = bh.Wp();
        if (this.ruX == null) {
            x.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.ruX = new af(this);
            com.tencent.mm.sdk.b.a.xef.b(this.qXG);
            com.tencent.mm.sdk.b.a.xef.b(this.rvg);
            ae.bvq().a(this.rvf);
            this.jtl = new d();
            this.jtl.a(this);
            if (com.tencent.mm.p.a.ux() != null) {
                com.tencent.mm.p.a.ux().wB();
            }
        }
        if (!this.mvA) {
            bzG();
        }
        this.ruK = true;
    }

    public final void onPause() {
        x.d("MicroMsg.OnlineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), bh.cgy());
        bzL();
        if (this.kTe != null) {
            this.kTe.stop();
        }
    }

    public final void onDestroy() {
        x.d("MicroMsg.OnlineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), bh.cgy());
        this.rvd = bh.Wp();
        x.i("MicroMsg.OnlineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        bzO();
        this.kTe.stop();
        com.tencent.mm.sdk.b.a.xef.c(this.qXG);
        com.tencent.mm.sdk.b.a.xef.c(this.rvg);
        ae.bvq().b(this.rvf);
        bzL();
        this.kRY.removeCallbacksAndMessages(null);
        if (this.ruX != null) {
            this.ruX.bzU();
            this.ruX.clear();
        }
        if (com.tencent.mm.p.a.ux() != null) {
            com.tencent.mm.p.a.ux().wA();
        }
        if (this.jtl != null) {
            this.jtl.bx(false);
        }
        this.jtl = null;
        this.fHC = null;
        this.fus = null;
        this.ruX = null;
        this.rvb = 0;
    }

    private void xw(int i) {
        String str = am.r(ae.getAccSnsPath(), this.fHC.nGJ) + com.tencent.mm.plugin.sns.data.i.e(this.fHC);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        x.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", str, Integer.valueOf(i));
        com.tencent.mm.bm.d.a(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.fIb = 0;
    }

    private void N(final int i, final boolean z) {
        this.kRY.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView rvm;

            public final void run() {
                m Lm = ae.bvv().Lm(this.rvm.fus);
                if (Lm != null) {
                    x.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", this.rvm.fus, Integer.valueOf(i), Boolean.valueOf(z));
                    com.tencent.mm.sdk.b.b cfVar = new cf();
                    cfVar.fqp.fqw = i;
                    cfVar.fqp.activity = (Activity) this.rvm.mContext;
                    com.tencent.mm.plugin.sns.i.a.a(cfVar, Lm);
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    if (cfVar.fqq.ret == 0) {
                        g.pQN.a(354, 225, 1, false);
                    } else {
                        g.pQN.a(354, 226, 1, false);
                    }
                    if (z) {
                        com.tencent.mm.sdk.b.b poVar = new po();
                        poVar.fHr.frH = Lm.byq();
                        poVar.fHr.fzW = com.tencent.mm.plugin.sns.data.i.g(Lm);
                        com.tencent.mm.sdk.b.a.xef.m(poVar);
                    }
                    this.rvm.fHZ = 0;
                    if (this.rvm.kTe == null) {
                        return;
                    }
                    if (bh.ov(this.rvm.kTe.Ur())) {
                        x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(this.rvm.hashCode()));
                        String a = ap.a(this.rvm.fus, this.rvm.fHC);
                        if (!bh.ov(a)) {
                            this.rvm.aI(a, false);
                        }
                    } else if (!this.rvm.kTe.isPlaying()) {
                        this.rvm.kTe.start();
                    }
                }
            }
        });
    }

    private void bzK() {
        long Wq = bh.Wq();
        String nG = t.nG(ap.a(this.fus, this.fHC));
        if (bh.ov(nG)) {
            Toast.makeText(this.mContext, this.mContext.getString(j.eTd), 1).show();
            g.pQN.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(j.eTe, new Object[]{nG}), 1).show();
            com.tencent.mm.platformtools.d.b(nG, this.mContext);
            g.pQN.a(354, 221, 1, false);
        }
        this.ruU = false;
        x.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(bh.bA(Wq)), r0);
        this.kRY.post(new 10(this));
    }

    private void a(boolean z, float f) {
        this.kRY.post(new 11(this, z, f));
    }

    private void bzG() {
        String str;
        if (this.ruS) {
            str = this.ruT;
        } else {
            str = ap.a(this.fus, this.fHC);
        }
        x.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.fus, str, Boolean.valueOf(this.ruS));
        if (bh.ov(str)) {
            a(false, 0.0f);
            t(false, 0);
            alw();
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
        a(true, 0.0f);
        aI(str, false);
    }

    private void t(boolean z, int i) {
        if (this.fHC == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", Integer.valueOf(hashCode()));
        } else if (this.ruX == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", Integer.valueOf(hashCode()));
        } else if (this.fHC.wxD == 2) {
            x.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", Integer.valueOf(hashCode()));
            this.ruR = 3;
            ae.bvq().a(this.fHC, 4, null, this.qQS);
        } else {
            boolean z2;
            int i2;
            af afVar;
            aqr com_tencent_mm_protocal_c_aqr;
            int i3;
            String str;
            if (!z) {
                com.tencent.mm.modelcontrol.d.MU();
                if (com.tencent.mm.modelcontrol.d.Na()) {
                    x.i("MicroMsg.OnlineVideoView", "%d it start online download video", Integer.valueOf(hashCode()));
                    this.ruR = 1;
                    z2 = true;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    afVar = this.ruX;
                    com_tencent_mm_protocal_c_aqr = this.fHC;
                    i3 = this.hzW;
                    str = this.fus;
                    afVar.fHC = com_tencent_mm_protocal_c_aqr;
                    afVar.hzW = i3;
                    afVar.frH = str;
                    afVar.hTv = ap.D(com_tencent_mm_protocal_c_aqr);
                    afVar.hTu = ap.aF(i3, com_tencent_mm_protocal_c_aqr.nfX);
                    if (!bh.ov(afVar.hTv) && !bh.ov(afVar.hTu)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", afVar.hTu, Boolean.valueOf(z2));
                        ae.bvt().a(com_tencent_mm_protocal_c_aqr, i3, str, z2, true, i2);
                        afVar.hTx = 1;
                        afVar.htG = bh.Wp();
                        if (z2) {
                            g.pQN.a(354, 201, 1, false);
                            return;
                        } else {
                            g.pQN.a(354, 202, 1, false);
                            return;
                        }
                    }
                }
            }
            x.i("MicroMsg.OnlineVideoView", "%d it start offline download video", Integer.valueOf(hashCode()));
            this.ruR = 2;
            z2 = false;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            afVar = this.ruX;
            com_tencent_mm_protocal_c_aqr = this.fHC;
            i3 = this.hzW;
            str = this.fus;
            afVar.fHC = com_tencent_mm_protocal_c_aqr;
            afVar.hzW = i3;
            afVar.frH = str;
            afVar.hTv = ap.D(com_tencent_mm_protocal_c_aqr);
            afVar.hTu = ap.aF(i3, com_tencent_mm_protocal_c_aqr.nfX);
            if (!bh.ov(afVar.hTv)) {
            }
        }
    }

    private void alw() {
        this.kRY.post(new 13(this));
    }

    private void aUZ() {
        this.kRY.post(new 14(this));
    }

    protected final void bX(boolean z) {
        if (!this.ruY) {
            this.kTk.J(500, 500);
        } else if (z) {
            ag.y(new 15(this));
        } else {
            this.rve.J(500, 500);
        }
    }

    protected final void bzL() {
        this.rve.TG();
        this.kTk.TG();
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.ruY), Boolean.valueOf(this.mvB));
        if (this.ruY) {
            g.pQN.a(354, 230, 1, false);
        } else {
            g.pQN.a(354, 231, 1, false);
        }
        this.mvC = i2;
        bzO();
        String Ur = this.kTe.Ur();
        this.rva = this.kTe.getCurrentPosition() / 1000;
        if (this.ruY) {
            if (i == -2) {
                this.kTe.stop();
            } else if (i == -3) {
                this.rvb = i;
                this.kTe.pause();
            } else {
                bzL();
                this.kTe.stop();
            }
            try {
                alw();
                if (this.ruX != null) {
                    af afVar = this.ruX;
                    String str = afVar.hTu + 0 + "_-1";
                    if (!afVar.rvq.containsKey(str)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", afVar.hTu);
                        o.TV();
                        com.tencent.mm.modelcdntran.f.f(afVar.hTu, 0, -1);
                        afVar.rvq.put(str, Integer.valueOf(0));
                        g.pQN.a(354, 207, 1, false);
                        g.pQN.h(13836, Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.ap.CTRL_INDEX), Long.valueOf(bh.Wo()), "");
                    }
                    afVar.hTy = 5;
                    afVar.hTD = true;
                    afVar.hTG = false;
                }
                bzO();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.kTe.stop();
        this.mvA = true;
        a(false, 0.0f);
        if (!bh.ov(Ur)) {
            x.w("MicroMsg.OnlineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kRY.post(new 8(this, Ur));
        }
    }

    public final void hX() {
        x.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.mvC), Integer.valueOf(this.rva));
        this.mvC = 0;
        if (this.rva > 0) {
            sD(this.rva);
            this.rva = 0;
            return;
        }
        this.rvb = 0;
        aUZ();
        bzN();
        this.kTe.start();
        this.duration = this.kTe.getDuration() / 1000;
        x.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.fus);
        bX(false);
    }

    public final void vh() {
        x.i("MicroMsg.OnlineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.ruV != null) {
            return;
        }
        if (com.tencent.mm.compatible.util.d.fO(18) || !this.mvB) {
            sD(0);
        } else if (this.kTe != null) {
            String Ur = this.kTe.Ur();
            this.kTe.stop();
            aI(Ur, this.ruY);
        }
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }

    public final void aI(String str, boolean z) {
        x.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (bh.ov(str)) {
            x.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            return;
        }
        this.ruY = z;
        if (this.kTe != null) {
            VideoPlayerTextureView videoPlayerTextureView;
            if (this.rvb != -3) {
                if (this.kTe instanceof VideoPlayerTextureView) {
                    boolean z2;
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kTe;
                    if (this.ruY) {
                        com.tencent.mm.kernel.g.Dk();
                        z2 = com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
                    } else {
                        z2 = false;
                    }
                    videoPlayerTextureView.gz(z2);
                    ((VideoPlayerTextureView) this.kTe).gA(z);
                }
                this.kTe.a(this.ruN);
                this.kTe.setVideoPath(str);
                a(true, 0.0f);
            } else {
                x.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.kTe instanceof VideoPlayerTextureView) {
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kTe;
                    x.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(videoPlayerTextureView.hashCode()));
                    if (videoPlayerTextureView.vye != null) {
                        com.tencent.mm.plugin.s.i iVar = videoPlayerTextureView.vye;
                        if (iVar.opV != null) {
                            iVar.opV.aZL();
                        }
                    }
                }
                sD(this.rva);
            }
        }
        com.tencent.mm.kernel.g.Dk();
        if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mvz.setText(com.tencent.mm.plugin.sight.base.d.Ff(str));
            this.mvz.setVisibility(0);
        }
    }

    public final boolean bzM() {
        x.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (this.kTe.isPlaying()) {
            return true;
        }
        bzN();
        boolean start = this.kTe.start();
        aUZ();
        return start;
    }

    public final void TF() {
        x.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        bzO();
        alw();
        if (this.kTe.isPlaying()) {
            x.i("MicroMsg.OnlineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            bzO();
            this.kTe.pause();
        }
    }

    public final void sD(int i) {
        x.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(true));
        this.rvb = 0;
        aUZ();
        this.kTe.c((double) (i * 1000), true);
        bX(false);
    }

    private void bzN() {
        this.rvi = bh.Wp();
        x.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.rvi));
    }

    private void bzO() {
        if (this.rvi > 0) {
            this.rvj = (int) (((long) this.rvj) + ((bh.Wp() - this.rvi) / 1000));
        }
        x.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.rvj));
        this.rvi = 0;
    }

    public final int bzP() {
        if (this.rvj < 0) {
            this.rvj = 0;
        }
        x.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.rvj));
        return this.rvj;
    }

    public final int bzQ() {
        return this.mvC;
    }

    public final int bzR() {
        int i;
        if (this.rvd <= 0 || this.rvc <= 0) {
            i = 0;
        } else {
            i = (int) (this.rvd - this.rvc);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
