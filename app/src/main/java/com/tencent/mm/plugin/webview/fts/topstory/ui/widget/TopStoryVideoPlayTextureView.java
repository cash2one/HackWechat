package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class TopStoryVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setVideoPath(String str) {
        super.setVideoPath(str);
    }

    protected final void aJH() {
        x.i("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", "%d open video [%s]", new Object[]{Integer.valueOf(hashCode()), this.path});
        synchronized (this.lock) {
            if (this.vye != null) {
                this.vye.opW = null;
                this.vye.opV.stop();
                this.vye.release();
                this.vye = null;
            }
            if (bh.ov(this.path)) {
                x.w("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", "%d open video but path is null.", new Object[]{Integer.valueOf(hashCode())});
                return;
            }
            try {
                this.HE = false;
                this.vye = new i(Looper.getMainLooper());
                this.vye.setPath(this.path);
                this.vye.a(this.opG);
                this.vye.gz(this.opy);
                this.vye.gA(this.opz);
                this.vye.opW = this.vyq;
                this.vye.setSurface(this.mSurface);
                this.vye.gy(this.vyn);
                if (this.mSurface != null) {
                    this.vye.aZJ();
                } else if (this.vyj) {
                    this.vye.aZJ();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", e, "prepare async error %s", new Object[]{e.getMessage()});
                if (this.quG != null) {
                    this.quG.onError(-1, -1);
                }
            }
        }
    }

    public final void stop() {
        e.post(new 1(this), "player-stop");
    }

    public final boolean start() {
        boolean start;
        synchronized (this.lock) {
            start = super.start();
        }
        return start;
    }

    public final void pause() {
        synchronized (this.lock) {
            super.pause();
        }
    }

    public final void q(double d) {
        synchronized (this.lock) {
            super.q(d);
        }
    }

    public final void setMute(boolean z) {
        synchronized (this.lock) {
            super.setMute(z);
        }
    }
}
