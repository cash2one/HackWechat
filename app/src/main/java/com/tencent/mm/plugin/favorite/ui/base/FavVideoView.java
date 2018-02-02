package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class FavVideoView extends RelativeLayout implements a {
    public String hDC;
    public af kRY;
    public f kTe;
    private boolean mvA;
    private boolean mvB;
    private int mvC;
    private boolean mvD;
    private ProgressBar mvE;
    private MMPinProgressBtn mvF;
    public String mvG;
    private int mvH;
    public a mvI;
    private ImageView mvy;
    private TextView mvz;

    public FavVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kRY = new af(Looper.getMainLooper());
        this.mvA = false;
        this.mvB = false;
        this.mvC = 0;
        this.mvD = false;
        this.mvG = "";
        this.mvH = 0;
        this.mvI = new a(this, (byte) 0);
        x.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(context).inflate(R.i.dhS, this);
        this.mvy = (ImageView) findViewById(R.h.cVw);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.h.cVu);
        ((TextView) findViewById(R.h.cUS)).setVisibility(8);
        this.mvF = (MMPinProgressBtn) findViewById(R.h.cVj);
        this.mvE = (ProgressBar) findViewById(R.h.cVb);
        this.mvz = (TextView) findViewById(R.h.cVz);
        if (d.Nb()) {
            this.mvB = true;
            this.kTe = new VideoPlayerTextureView(context);
        } else {
            this.mvB = false;
            this.kTe = new VideoTextureView(context);
        }
        this.kTe.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        relativeLayout.addView((View) this.kTe, layoutParams);
        ((com.tencent.mm.plugin.record.a.a) g.k(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.mvI);
        ((r) g.k(r.class)).getFavCdnStorage().a(this.mvI);
    }

    public final void onResume() {
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.mvA) {
            if (bh.ov(this.hDC) || !e.bO(this.hDC)) {
                x.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
                fe(false);
                return;
            }
            x.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
            Au(this.hDC);
        }
    }

    private void fe(final boolean z) {
        this.kRY.post(new Runnable(this) {
            final /* synthetic */ FavVideoView mvJ;

            public final void run() {
                x.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[]{Boolean.valueOf(z)});
                View view = (View) this.mvJ.kTe;
                if (z) {
                    view.setVisibility(0);
                    this.mvJ.mvy.setVisibility(8);
                    return;
                }
                view.setVisibility(8);
                this.mvJ.mvy.setVisibility(0);
            }
        });
    }

    public final void Au(String str) {
        x.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (bh.ov(str)) {
            x.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.kTe != null) {
            if (this.kTe instanceof VideoPlayerTextureView) {
                VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) this.kTe;
                ar.Hg();
                videoPlayerTextureView.gz(c.CU().getBoolean(w.a.xtK, false));
            }
            this.kTe.setVideoPath(str);
        }
        ar.Hg();
        if (((Integer) c.CU().get(w.a.xsG, Integer.valueOf(0))).intValue() == 1) {
            this.mvz.setText(com.tencent.mm.plugin.sight.base.d.Ff(str));
            this.mvz.setVisibility(0);
        }
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }

    public final void hX() {
        this.mvC = 0;
        fe(true);
        this.mvD = this.kTe.start();
        x.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[]{Integer.valueOf(this.kTe.getDuration() / 1000)});
    }

    public final void vh() {
        x.i("MicroMsg.FavVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (com.tencent.mm.compatible.util.d.fO(18) || !this.mvB) {
            x.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[]{Integer.valueOf(0)});
            this.kTe.q(0.0d);
        } else if (this.kTe != null) {
            this.kTe.stop();
        }
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mvB)});
        if (this.mvD) {
            vh();
            return;
        }
        this.mvC = i2;
        String Ur = this.kTe.Ur();
        this.kTe.stop();
        this.mvA = true;
        fe(false);
        if (this.mvC == -1) {
            this.mvH++;
            if (this.mvH <= 3) {
                ag.y(new 2(this));
                return;
            }
        }
        if (!bh.ov(Ur) && FileOp.bO(Ur)) {
            x.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.kRY.post(new 3(this, Ur));
        }
    }
}
