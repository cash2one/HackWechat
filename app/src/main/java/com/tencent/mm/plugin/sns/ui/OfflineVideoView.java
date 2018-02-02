package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class OfflineVideoView extends RelativeLayout implements a {
    private int aBO;
    private int duration;
    private af kRY;
    private boolean kTc;
    public f kTe;
    private ak kTk;
    private Context mContext;
    private boolean mvA;
    private boolean mvB;
    private ProgressBar mvE;
    private ImageView mvy;
    private RelativeLayout mxu;
    public a ruJ;
    private boolean ruK;
    private boolean ruL;
    private int ruM;
    private e ruN;

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mContext = null;
        this.kTc = false;
        this.mvA = false;
        this.ruK = false;
        this.ruL = true;
        this.ruM = -1;
        this.aBO = 0;
        this.duration = 0;
        this.kRY = new af(Looper.getMainLooper());
        this.kTk = new ak(new ak.a(this) {
            final /* synthetic */ OfflineVideoView ruP;

            {
                this.ruP = r1;
            }

            public final boolean uF() {
                if (this.ruP.kTe == null) {
                    return false;
                }
                if (((View) this.ruP.kTe).getAlpha() < 1.0f) {
                    this.ruP.a(true, 1.0f);
                }
                if (this.ruP.kTe.isPlaying()) {
                    this.ruP.aUZ();
                    OfflineVideoView offlineVideoView = this.ruP;
                    int currentPosition = this.ruP.kTe.getCurrentPosition() / 1000;
                    if (offlineVideoView.ruJ != null) {
                        offlineVideoView.ruJ.wZ(currentPosition);
                    }
                }
                return true;
            }
        }, true);
        this.ruN = new 8(this);
        this.mContext = context;
        x.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(this.mContext).inflate(i$g.qIl, this);
        this.mvy = (ImageView) findViewById(i.f.cVw);
        this.mxu = (RelativeLayout) findViewById(i.f.cVu);
        this.mvE = (ProgressBar) findViewById(i.f.cVb);
        if (d.fN(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.mvB = true;
            this.kTe = new VideoPlayerTextureView(this.mContext);
        } else {
            this.mvB = false;
            this.kTe = new VideoTextureView(this.mContext);
        }
        this.kTe.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mxu.addView((View) this.kTe, layoutParams);
        a(false, 0.0f);
    }

    public final void setMute(boolean z) {
        this.kTc = z;
        this.kTe.setMute(this.kTc);
    }

    private void onResume() {
        x.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        if (!this.mvA) {
            bzG();
        }
        this.ruK = true;
    }

    public final void onDestroy() {
        x.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        x.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[]{Integer.valueOf(hashCode())});
        this.kRY.removeCallbacksAndMessages(null);
        this.kTk.TG();
        if (this.kTe != null) {
            this.kTe.stop();
        }
    }

    public final void bzG() {
        if (this.ruJ != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.ruJ.a(pString)) {
                if (!bh.ov(pString2.value)) {
                    LS(pString2.value);
                }
                if (!bh.ov(pString.value)) {
                    Au(pString.value);
                    return;
                }
                return;
            }
            this.kRY.post(new Runnable(this) {
                final /* synthetic */ OfflineVideoView ruP;

                {
                    this.ruP = r1;
                }

                public final void run() {
                    x.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.ruP.hashCode()), Integer.valueOf(this.ruP.hashCode())});
                    if (this.ruP.mvE != null && this.ruP.mvE.getVisibility() != 0) {
                        this.ruP.mvE.setVisibility(0);
                    }
                }
            });
            a(false, 0.0f);
            return;
        }
        x.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[]{Integer.valueOf(hashCode())});
    }

    public final void LS(String str) {
        if (!bh.ov(str)) {
            this.kRY.post(new 1(this, str));
        }
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mvB), Integer.valueOf(this.aBO)});
        this.aBO++;
        final String Ur = this.kTe.Ur();
        this.kTe.stop();
        this.mvA = true;
        a(false, 0.0f);
        if (this.aBO <= 3) {
            this.kRY.postDelayed(new 2(this, Ur), 200);
        } else if (!bh.ov(Ur)) {
            x.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[]{Integer.valueOf(hashCode())});
            this.kRY.post(new Runnable(this) {
                final /* synthetic */ OfflineVideoView ruP;

                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Ur)), "video/*");
                    try {
                        this.ruP.getContext().startActivity(intent);
                    } catch (Exception e) {
                        x.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
                        h.h(this.ruP.getContext(), j.efS, j.efT);
                    }
                }
            });
        }
    }

    private void a(final boolean z, final float f) {
        this.kRY.post(new Runnable(this) {
            final /* synthetic */ OfflineVideoView ruP;

            public final void run() {
                x.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.ruP.hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
                View view = (View) this.ruP.kTe;
                if (z) {
                    view.setAlpha(f);
                    view.setVisibility(0);
                    this.ruP.mxu.setVisibility(0);
                    this.ruP.mxu.setAlpha(f);
                    if (((double) f) >= 1.0d) {
                        this.ruP.mvy.setVisibility(8);
                        return;
                    }
                    return;
                }
                view.setVisibility(0);
                this.ruP.mxu.setVisibility(0);
                this.ruP.mxu.setAlpha(0.0f);
                this.ruP.mvy.setVisibility(0);
            }
        });
    }

    public final void hX() {
        a(true, 0.0f);
        this.mvA = false;
        aUZ();
        this.duration = this.kTe.getDuration() / 1000;
        x.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.ruL), Integer.valueOf(this.ruM)});
        if (this.ruL) {
            if (this.ruM <= 0) {
                this.kTe.start();
            } else {
                F(this.ruM, true);
            }
            akP();
            if (this.ruJ != null) {
                this.ruJ.onStart(this.duration);
            }
        } else {
            F(this.ruM > 0 ? this.ruM : 0, false);
        }
        this.ruM = -1;
    }

    private void aUZ() {
        this.kRY.post(new 6(this));
    }

    public final void akP() {
        this.kTk.J(500, 500);
    }

    public final void vh() {
        x.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (this.ruJ != null) {
            this.ruJ.vh();
        } else if (d.fO(18) || !this.mvB) {
            F(0, true);
        } else if (this.kTe != null) {
            String Ur = this.kTe.Ur();
            this.kTe.stop();
            Au(Ur);
        }
    }

    public final void Au(String str) {
        x.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[]{Integer.valueOf(hashCode()), str});
        if (bh.ov(str)) {
            x.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.kTe != null) {
            this.kTe.a(this.ruN);
            this.kTe.setVideoPath(str);
        }
    }

    public final void F(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        aUZ();
        this.kTe.c((double) (i * 1000), z);
        akP();
    }

    public final void bzH() {
        x.i("MicroMsg.OfflineVideoView", "%d pause", new Object[]{Integer.valueOf(hashCode())});
        x.d("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        this.ruL = false;
        if (this.kTe.isPlaying()) {
            this.ruM = this.kTe.getCurrentPosition() / 1000;
        }
        x.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[]{Integer.valueOf(hashCode())});
        this.kTe.pause();
        aUZ();
        this.kTk.TG();
    }

    public final void bzI() {
        x.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.ruK)});
        this.ruL = true;
        if (!this.ruK) {
            onResume();
        } else if (bh.ov(this.kTe.Ur())) {
            onResume();
        } else if (this.kTe.start() && this.ruJ != null) {
            this.ruJ.onStart(this.duration);
        }
        akP();
    }

    public final void M(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        F(i, z);
        akP();
    }

    public final boolean isPlaying() {
        return this.kTe != null ? this.kTe.isPlaying() : false;
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }

    public final int getCurrentPosition() {
        if (this.kTe != null) {
            return this.kTe.getCurrentPosition() / 1000;
        }
        return 0;
    }
}
