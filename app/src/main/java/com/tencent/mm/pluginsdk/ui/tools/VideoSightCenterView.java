package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSightCenterView extends VideoSightView {
    private boolean fAs = false;
    private int rkc = 0;
    private volatile boolean vyu = false;
    private MediaMetadataRetriever vyv;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void wj(int i) {
        super.wj(i);
        ccK();
    }

    public final void dt(int i, int i2) {
        super.dt(i, i2);
        ccK();
    }

    private void ccK() {
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
    }

    protected final void init() {
        if (bh.az(q.gGe.gFv, "").equals("other")) {
            x.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            ia(true);
        }
        a(new e(this) {
            final /* synthetic */ VideoSightCenterView vyw;

            {
                this.vyw = r1;
            }

            public final void d(b bVar, int i) {
                if (-1 == i) {
                    x.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[]{Boolean.valueOf(this.vyw.vyu)});
                    if (this.vyw.quG != null && !this.vyw.vyu) {
                        this.vyw.quG.onError(0, 0);
                    }
                } else if (i == 0) {
                    x.i("MicroMsg.VideoSightCenterView", "normal stop");
                    this.vyw.vyu = true;
                    if (this.vyw.quG != null) {
                        this.vyw.quG.vh();
                    }
                }
            }
        });
    }

    public final void id(boolean z) {
        if (z) {
            a(new 2(this));
        } else {
            a(null);
        }
    }

    public final int getDuration() {
        x.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!bh.ov(this.qtl)) {
            try {
                if (this.vyv == null) {
                    this.vyv = new MediaMetadataRetriever();
                    this.vyv.setDataSource(this.qtl);
                }
                x.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[]{Integer.valueOf(Integer.valueOf(this.vyv.extractMetadata(9)).intValue())});
                return Integer.valueOf(this.vyv.extractMetadata(9)).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[]{e.getMessage()});
            }
        }
        return super.getDuration();
    }

    public final int getCurrentPosition() {
        x.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[]{Integer.valueOf(this.rkc)});
        return this.rkc;
    }

    public final boolean start() {
        x.v("MicroMsg.VideoSightCenterView", "start");
        this.fAs = true;
        return super.start();
    }

    public final void stop() {
        x.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.rkc = 0;
        this.fAs = false;
    }

    public final void pause() {
        x.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
    }

    public final double btg() {
        return super.btg();
    }

    public final void q(double d) {
        x.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[]{Double.valueOf(d), Boolean.valueOf(this.fAs), Integer.valueOf(this.rkc), Double.valueOf(super.btg())});
        if (this.fAs && super.btg() > 0.0d) {
            super.q(d / 1000.0d);
        }
    }

    public final boolean isPlaying() {
        x.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[]{Boolean.valueOf(this.fAs), Integer.valueOf(this.rkc)});
        return this.fAs;
    }
}
