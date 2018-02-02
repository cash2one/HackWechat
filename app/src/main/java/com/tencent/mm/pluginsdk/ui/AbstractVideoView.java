package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a$b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class AbstractVideoView extends RelativeLayout implements h, a, b, c, d, e {
    private boolean HE;
    public String TAG;
    private int aBO;
    protected af hae;
    public h.b jte;
    public f kTe;
    protected TextView lhf;
    public Context mContext;
    protected ImageView msx;
    protected ProgressBar mvE;
    protected TextView ruW;
    public h.c tqb;
    public boolean viL;
    protected RelativeLayout viM;
    protected LinearLayout viN;
    protected VideoPlayerSeekBar viO;
    protected g viP;
    protected boolean viQ;
    public int viR;
    public boolean viS;
    public int viT;
    public boolean viU;
    public int viV;
    public boolean viW;
    public long viX;
    public int viY;
    protected ak viZ;
    protected ak vja;
    protected ak vjb;
    private com.tencent.mm.plugin.sight.decode.ui.b vjc;
    private OnClickListener vjd;
    protected l vje;

    public abstract int TJ();

    static /* synthetic */ void b(AbstractVideoView abstractVideoView) {
        x.i(abstractVideoView.TAG, "%s reset error count ", new Object[]{abstractVideoView.asN()});
        abstractVideoView.aBO = 0;
        abstractVideoView.fv((long) (abstractVideoView.TJ() + 91));
    }

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.AbstractVideoView";
        this.viL = true;
        this.viQ = true;
        this.viR = 0;
        this.viS = false;
        this.hae = new af(Looper.getMainLooper());
        this.viT = 0;
        this.viU = true;
        this.viV = -1;
        this.aBO = 0;
        this.viW = false;
        this.HE = false;
        this.viX = 0;
        this.viY = 0;
        this.viZ = new ak(new 1(this), true);
        this.vja = new ak(new ak.a(this) {
            final /* synthetic */ AbstractVideoView vjf;

            {
                this.vjf = r1;
            }

            public final boolean uF() {
                boolean isPlaying = this.vjf.isPlaying();
                x.i(this.vjf.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[]{this.vjf.asN(), Boolean.valueOf(isPlaying), Integer.valueOf(this.vjf.ahj())});
                if (this.vjf.kTe != null && r1 <= 50) {
                    this.vjf.kTe.q(0.0d);
                }
                return false;
            }
        }, false);
        this.vjb = new ak(new 5(this), true);
        this.vjc = new 6(this);
        this.vjd = new 7(this);
        this.tqb = null;
        this.vje = new l();
        this.mContext = context;
        initView();
    }

    public f bB(Context context) {
        return null;
    }

    public void initView() {
        x.i(this.TAG, "%s init view ", new Object[]{asN()});
        LayoutInflater.from(this.mContext).inflate(a$b.pdC, this);
        this.msx = (ImageView) findViewById(com.tencent.mm.plugin.ab.a.a.cVw);
        this.viM = (RelativeLayout) findViewById(com.tencent.mm.plugin.ab.a.a.cVu);
        this.ruW = (TextView) findViewById(com.tencent.mm.plugin.ab.a.a.cUS);
        this.mvE = (ProgressBar) findViewById(com.tencent.mm.plugin.ab.a.a.cVb);
        this.lhf = (TextView) findViewById(com.tencent.mm.plugin.ab.a.a.cVz);
        this.viN = (LinearLayout) findViewById(com.tencent.mm.plugin.ab.a.a.cUV);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(com.tencent.mm.plugin.ab.a.a.cVi);
        this.viO = videoPlayerSeekBar;
        this.viP = videoPlayerSeekBar;
        this.viO.quk = this.vjc;
        this.viO.setOnClickListener(this.vjd);
        this.kTe = bB(this.mContext);
        this.kTe.a(this);
        this.kTe.a(this);
        this.kTe.a(this);
        this.kTe.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.viM.addView((View) this.kTe, layoutParams);
    }

    public final void a(g gVar) {
        if (gVar instanceof View) {
            ahh();
            this.viP = gVar;
            this.viQ = false;
            this.viN.addView((View) this.viP);
            return;
        }
        x.w(this.TAG, "%s set video footer view but is not view", new Object[]{asN()});
    }

    public final void ahh() {
        this.viN.removeView((View) this.viP);
    }

    private void kj(boolean z) {
        this.viP.kj(z);
    }

    public void bX(boolean z) {
        x.d(this.TAG, "%s start timer rightNow[%b]", new Object[]{asN(), Boolean.valueOf(z)});
        this.viZ.J(500, 500);
    }

    public int TH() {
        return 0;
    }

    public void TG() {
        this.viZ.TG();
        this.vja.TG();
    }

    public final void mK(int i) {
        this.viP.wZ(i);
    }

    public final void alw() {
        this.hae.post(new 8(this));
    }

    public final void aUZ() {
        x.d(this.TAG, "%s hide loading %s", new Object[]{asN(), bh.cgy()});
        this.hae.post(new 9(this));
    }

    public final String asN() {
        return hashCode();
    }

    public boolean play() {
        if (this.viL) {
            fv((long) (TJ() + 3));
            if (this.kTe == null) {
                return false;
            }
            boolean start = this.kTe.start();
            x.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[]{asN(), Boolean.valueOf(start), Boolean.valueOf(this.viS)});
            kj(start);
            if (start) {
                this.viS = false;
                bX(false);
                if (this.jte != null) {
                    this.jte.bn(bPL(), getMediaId());
                }
            }
            return start;
        }
        x.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[]{asN(), bh.cgy()});
        return false;
    }

    public boolean pause() {
        x.i(this.TAG, "%s pause", new Object[]{asN()});
        fv((long) (TJ() + 4));
        if (this.kTe == null) {
            return false;
        }
        kj(false);
        this.kTe.pause();
        TG();
        if (this.jte != null) {
            this.jte.bm(bPL(), getMediaId());
        }
        this.vje.rvw = bh.Wp();
        return true;
    }

    public final boolean kI(int i) {
        return s(i, isPlaying());
    }

    public boolean s(int i, boolean z) {
        int i2;
        boolean isPrepared = isPrepared();
        int ahi = ahi();
        if (ahi <= 0 || i <= ahi) {
            i2 = i;
        } else {
            i2 = ahi;
        }
        boolean z2 = this.kTe != null ? !bh.ov(this.kTe.Ur()) : false;
        x.k(this.TAG, "%s seek to [%d %d] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[]{asN(), Integer.valueOf(i2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(isPrepared), Integer.valueOf(ahi), Boolean.valueOf(z2)});
        fv((long) (TJ() + 5));
        if (!isPrepared) {
            this.viV = i2;
            if (z2) {
                this.viU = true;
            } else {
                this.viU = z;
                start();
            }
        } else if (this.kTe != null) {
            alw();
            mK(i2);
            this.kTe.c((double) (i2 * 1000), z);
            return z;
        }
        return false;
    }

    public int ahi() {
        if (this.kTe != null) {
            return Math.round((((float) this.kTe.getDuration()) * 1.0f) / 1000.0f);
        }
        return -1;
    }

    public int ahj() {
        if (this.kTe != null) {
            return this.kTe.getCurrentPosition();
        }
        return 0;
    }

    public int ahk() {
        if (this.kTe != null) {
            return Math.round((((float) this.kTe.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    public boolean isPlaying() {
        if (this.kTe != null) {
            return this.kTe.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        boolean z = this.kTe != null ? !bh.ov(this.kTe.Ur()) && this.HE : false;
        x.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[]{asN(), Boolean.valueOf(z), Boolean.valueOf(this.HE)});
        return z;
    }

    public void stop() {
        long j;
        x.i(this.TAG, "%s stop [%s]", new Object[]{asN(), bh.cgy()});
        fv((long) (TJ() + 6));
        if (this.kTe != null) {
            this.kTe.stop();
        }
        this.viV = -1;
        this.viU = true;
        this.HE = false;
        this.viY = 0;
        this.viX = 0;
        TG();
        this.hae.postDelayed(new Runnable(this) {
            final /* synthetic */ AbstractVideoView vjf;

            {
                this.vjf = r1;
            }

            public final void run() {
                try {
                    this.vjf.mK(0);
                    this.vjf.kj(this.vjf.isPlaying());
                } catch (Throwable th) {
                }
            }
        }, 10);
        this.vje.vkY = bh.Wp();
        if (this.vje.blockCount > 0) {
            int i;
            int i2;
            if (an.isWifi(this.mContext)) {
                i = 41;
                i2 = 45;
            } else if (an.is4G(this.mContext)) {
                i = 46;
                i2 = 50;
            } else if (an.is3G(this.mContext)) {
                i = 51;
                i2 = 55;
            } else if (an.is2G(this.mContext)) {
                i = 56;
                i2 = 60;
            }
            x.d(this.TAG, "%s rptBlockCount [%d]", new Object[]{asN(), Integer.valueOf(bh.e((Integer) com.tencent.mm.plugin.report.d.a(this.vje.blockCount, new int[]{1, 2, 3, 4}, i + TJ(), i2 + TJ())))});
            fv((long) i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.vje.vkW).append(",");
        stringBuffer.append(this.vje.vkX).append(",");
        stringBuffer.append(this.vje.vkY).append(",");
        stringBuffer.append(this.vje.rvw).append(",");
        stringBuffer.append(this.vje.vkZ).append(",");
        stringBuffer.append(this.vje.vla).append(",");
        stringBuffer.append(this.vje.vlb).append(",");
        stringBuffer.append(this.vje.blockCount).append(",");
        stringBuffer.append(this.vje.vkX - this.vje.vkW).append(",");
        stringBuffer.append(this.vje.url).append(",");
        stringBuffer.append(this.vje.duration).append(",");
        stringBuffer.append(this.vje.vlc).append(",");
        stringBuffer.append(this.vje.vld).append(",");
        stringBuffer.append(this.vje.rvu).append(",");
        if (this.vje.rvu > this.vje.vkW) {
            j = this.vje.rvu - this.vje.vkW;
        } else {
            j = 0;
        }
        stringBuffer.append(j).append(",");
        stringBuffer.append(this.viT);
        x.i(this.TAG, "%s rpt video kv stat{%s}", new Object[]{asN(), stringBuffer.toString()});
        if (this.tqb != null) {
            this.tqb.k(14349, r0);
        }
    }

    public final void setMute(boolean z) {
        if (this.kTe != null) {
            this.kTe.setMute(z);
        }
    }

    public void TE() {
        x.i(this.TAG, "%s onUIResume %s", new Object[]{asN(), bh.cgy()});
        this.viL = true;
        fv((long) (TJ() + 10));
    }

    public void TD() {
        x.i(this.TAG, "%s onUIPause %s", new Object[]{asN(), bh.cgy()});
        this.viR = ahk();
        this.viS = isPlaying();
        this.viY = 0;
        this.viX = 0;
        pause();
        TG();
        this.viL = false;
        fv((long) (TJ() + 11));
    }

    public final void ahl() {
        x.i(this.TAG, "%s onUIDestroy", new Object[]{asN()});
        stop();
        this.hae.removeCallbacksAndMessages(null);
        TG();
        this.vjb.TG();
        fv((long) (TJ() + 12));
    }

    public void onError(int i, int i2) {
        x.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.aBO)});
        fv((long) (TJ() + 90));
        this.aBO++;
        if (this.aBO > 5) {
            fv((long) (TJ() + 92));
            this.vje.vlc = i;
            this.vje.vld = i2;
            if (this.jte != null) {
                h.b bVar = this.jte;
                String bPL = bPL();
                String mediaId = getMediaId();
                String str = i == -1010 ? "MEDIA_ERR_SRC_NOT_SUPPORTED" : i == -1007 ? "MEDIA_ERR_SRC_NOT_SUPPORTED" : i == -1004 ? !an.isConnected(this.mContext) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE" : !an.isConnected(this.mContext) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE";
                bVar.c(bPL, mediaId, str, i, i2);
            }
            stop();
            aUZ();
            return;
        }
        x.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[]{asN(), Integer.valueOf(this.viV == -1 ? ahk() : this.viV), Integer.valueOf(this.viV), Integer.valueOf(ahk())});
        stop();
        alw();
        this.hae.postDelayed(new 3(this, r0), 200);
    }

    public final void hX() {
        x.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[]{asN(), Boolean.valueOf(this.viU), Integer.valueOf(this.viV), Boolean.valueOf(this.HE)});
        this.HE = true;
        if (this.kTe != null) {
            this.kTe.a(this);
        }
        int ahi = ahi();
        if (!(this.viP == null || this.viP.bsW() == ahi)) {
            this.viP.wl(ahi);
        }
        if (!this.viU) {
            s(this.viV < 0 ? 0 : this.viV, this.viU);
        } else if (this.viV < 0) {
            if (play() && bPK()) {
                this.vja.J(1000, 1000);
            }
        } else if (agP()) {
            play();
        } else {
            s(this.viV, this.viU);
        }
        this.viV = -1;
        this.viU = true;
        this.viY = 0;
        this.viX = 0;
        if (this.jte != null) {
            this.jte.bk(bPL(), getMediaId());
        }
        if (this.aBO > 0) {
            x.d(this.TAG, "%s start error check timer", new Object[]{asN()});
            this.vjb.J(5000, 5000);
        }
        fv((long) (TJ() + 2));
        if (this.vje.vkX == 0) {
            this.vje.vkX = bh.Wp();
        }
        this.vje.duration = ahi();
        if (this.vje.vkW > 0 && this.vje.vkX > 0) {
            int i;
            int i2 = (int) ((this.vje.vkX - this.vje.vkW) / 1000);
            if (an.isWifi(this.mContext)) {
                i = 20;
                ahi = 24;
            } else if (an.is4G(this.mContext)) {
                i = 25;
                ahi = 29;
            } else if (an.is3G(this.mContext)) {
                i = 30;
                ahi = 34;
            } else if (an.is2G(this.mContext)) {
                i = 35;
                ahi = 39;
            } else {
                return;
            }
            x.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[]{asN(), Integer.valueOf(bh.e((Integer) com.tencent.mm.plugin.report.d.a(i2, new int[]{1, 2, 3, 4}, i + TJ(), ahi + TJ())))});
            fv((long) ahi);
        }
    }

    public final void bbH() {
        x.i(this.TAG, "%s onTextureUpdate ", new Object[]{asN()});
        aUZ();
    }

    public void vh() {
        x.i(this.TAG, "%s onCompletion", new Object[]{asN()});
        aUZ();
        TG();
        if (this.jte != null) {
            this.jte.bl(bPL(), getMediaId());
        }
        this.viY = 0;
        this.viX = 0;
        fv((long) (TJ() + 7));
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
        x.i(this.TAG, "%s on get video size [%d, %d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jte != null) {
            this.jte.d(bPL(), getMediaId(), i, i2);
        }
        fv((long) (TJ() + 8));
    }

    public void bW(boolean z) {
        x.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[]{asN(), Boolean.valueOf(z)});
        if (this.kTe != null) {
            this.kTe.a(this);
        }
        aUZ();
        kj(z);
        mK(ahk());
        if (z) {
            bX(false);
            this.viS = false;
            if (this.jte != null) {
                this.jte.bn(bPL(), getMediaId());
            }
        }
    }

    public void TI() {
        x.i(this.TAG, "%s on surface available", new Object[]{asN()});
        bX(false);
    }

    public boolean bPK() {
        return true;
    }

    public final void fv(long j) {
        if (this.tqb != null) {
            this.tqb.a(600, j, 1, false);
        }
    }

    public final void bzW() {
        if (this.vje.vkW == 0) {
            this.vje.vkW = bh.Wp();
        }
    }

    public final void bZQ() {
        if (this.vje.rvu == 0) {
            this.vje.rvu = bh.Wp();
        }
    }

    public final void bZR() {
        this.vje.vkZ = bh.Wp();
    }

    public final void bZS() {
        this.vje.vla = bh.Wp();
        if (this.vje.vkZ > 0) {
            l lVar = this.vje;
            lVar.vlb += this.vje.vla - this.vje.vkZ;
        }
    }

    public final void bZT() {
        l lVar = this.vje;
        lVar.blockCount++;
    }

    protected final void Se(String str) {
        this.vje.url = str;
    }

    public final void bZU() {
        if (this.vje.vla > 0 && this.vje.vkZ > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.vje.vla - this.vje.vkZ) / 1000);
            if (an.isWifi(this.mContext)) {
                i = 70;
                i2 = 74;
            } else if (an.is4G(this.mContext)) {
                i = 75;
                i2 = 79;
            } else if (an.is3G(this.mContext)) {
                i = 80;
                i2 = 84;
            } else if (an.is2G(this.mContext)) {
                i = 85;
                i2 = 89;
            } else {
                return;
            }
            x.d(this.TAG, "%s rptResumeTime [%d]", new Object[]{asN(), Integer.valueOf(bh.e((Integer) com.tencent.mm.plugin.report.d.a(i3, new int[]{1, 2, 3, 4}, i + TJ(), i2 + TJ())))});
            fv((long) i2);
        }
    }

    public String bPL() {
        return "";
    }

    public String getMediaId() {
        return "";
    }
}
