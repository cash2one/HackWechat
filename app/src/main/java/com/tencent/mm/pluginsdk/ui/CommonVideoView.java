package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class CommonVideoView extends AbstractVideoView {
    protected boolean avH;
    protected int jtj;
    public String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
    }

    public void b(boolean z, String str, int i) {
        x.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[]{asN(), Boolean.valueOf(z), str, Integer.valueOf(i)});
        this.avH = z;
        this.url = str;
        this.jtj = i;
        Se(str);
    }

    public f bB(Context context) {
        this.viT = 0;
        return new VideoTextureView(context);
    }

    public void start() {
        if (this.kTe != null) {
            x.i(this.TAG, "%s start path [%s] [%s]", new Object[]{asN(), this.kTe.Ur(), bh.cgy()});
            if (bh.ov(this.kTe.Ur())) {
                this.kTe.setVideoPath(this.url);
                alw();
                bzW();
            } else {
                play();
            }
            fv((long) (TJ() + 1));
        }
    }

    public void a(d dVar) {
        if (this.kTe instanceof VideoTextureView) {
            VideoTextureView videoTextureView = (VideoTextureView) this.kTe;
            videoTextureView.vys.a(dVar);
            videoTextureView.requestLayout();
            fv((long) (TJ() + 14));
        }
    }

    public final boolean aa(float f) {
        x.i(this.TAG, "%s set play rate [%f]", new Object[]{asN(), Float.valueOf(f)});
        if (!(this.kTe instanceof VideoTextureView)) {
            return false;
        }
        fv((long) (TJ() + 13));
        return ((VideoTextureView) this.kTe).aa(f);
    }

    public final int ahi() {
        if (this.jtj <= 0) {
            return super.ahi();
        }
        return this.jtj;
    }

    public int TH() {
        try {
            if (this.kTe instanceof VideoTextureView) {
                return (int) (((((float) ((VideoTextureView) this.kTe).vyM) * 1.0f) / 100.0f) * ((float) super.ahi()));
            }
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "%s get cache time sec error", new Object[]{asN()});
        }
        return 0;
    }

    public boolean s(int i, boolean z) {
        if (!agP()) {
            return super.s(i, z);
        }
        x.w(this.TAG, "%s it is live, don't seek ", new Object[]{asN()});
        return false;
    }

    public void TE() {
        super.TE();
        if (this.kTe != null && (this.kTe instanceof VideoTextureView)) {
            if (this.viS) {
                play();
            } else {
                ((VideoTextureView) this.kTe).aZM();
            }
        }
    }

    public void TD() {
        super.TD();
    }

    public final void ez(int i, int i2) {
        x.d(this.TAG, "%s onInfo [%d %d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 701) {
            alw();
            bZT();
            bZR();
            fv((long) (TJ() + 40));
        } else if (i == 702) {
            aUZ();
            bZS();
            bZU();
        }
    }

    public void vh() {
        if (agP()) {
            x.i(this.TAG, "%s it is live video, do not completion", new Object[]{asN()});
            stop();
            start();
            return;
        }
        super.vh();
    }

    public final boolean agP() {
        boolean isPrepared = isPrepared();
        int duration = this.kTe != null ? this.kTe.getDuration() : 0;
        if (this.avH) {
            isPrepared = true;
        } else if (!isPrepared || duration > 0) {
            isPrepared = false;
        } else {
            isPrepared = true;
        }
        x.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[]{asN(), Boolean.valueOf(isPrepared), Boolean.valueOf(isPrepared()), Integer.valueOf(duration), Boolean.valueOf(this.avH)});
        return isPrepared;
    }

    public int TJ() {
        return 0;
    }
}
