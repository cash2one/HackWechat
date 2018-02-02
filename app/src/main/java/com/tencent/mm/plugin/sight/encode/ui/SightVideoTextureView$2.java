package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.view.Surface;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SightVideoTextureView$2 implements Runnable {
    final /* synthetic */ boolean oTT;
    final /* synthetic */ SightVideoTextureView qxT;
    final /* synthetic */ String qxU;

    SightVideoTextureView$2(SightVideoTextureView sightVideoTextureView, String str, boolean z) {
        this.qxT = sightVideoTextureView;
        this.qxU = str;
        this.oTT = z;
    }

    public final void run() {
        if (SightVideoTextureView.e(this.qxT) != null) {
            try {
                SightVideoTextureView.e(this.qxT).stop();
                SightVideoTextureView.e(this.qxT).release();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                x.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
            }
        }
        try {
            SightVideoTextureView.a(this.qxT, new j());
            SightVideoTextureView.e(this.qxT).setOnCompletionListener(new 1(this));
            SightVideoTextureView.e(this.qxT).setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ SightVideoTextureView$2 qxV;

                {
                    this.qxV = r1;
                }

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    x.i("MicroMsg.SightVideoTextureView", "play %s error", this.qxV.qxU);
                    return false;
                }
            });
            SightVideoTextureView.e(this.qxT).setDataSource(this.qxU);
            SightVideoTextureView sightVideoTextureView = this.qxT;
            SightVideoTextureView sightVideoTextureView2 = this.qxT;
            SightVideoTextureView.a(sightVideoTextureView, sightVideoTextureView2.qxQ != null ? new Surface(sightVideoTextureView2.qxQ) : null);
            SightVideoTextureView.e(this.qxT).setSurface(SightVideoTextureView.f(this.qxT));
            SightVideoTextureView.e(this.qxT).setAudioStreamType(3);
            if (this.oTT) {
                SightVideoTextureView.e(this.qxT).setVolume(0.0f, 0.0f);
            } else {
                this.qxT.btN();
            }
            SightVideoTextureView.e(this.qxT).setScreenOnWhilePlaying(true);
            SightVideoTextureView.e(this.qxT).setLooping(true);
            SightVideoTextureView.e(this.qxT).prepare();
            SightVideoTextureView.e(this.qxT).start();
        } catch (Throwable e2) {
            x.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", this.qxU, e2.getMessage(), bh.i(e2));
        }
    }

    public final String toString() {
        return super.toString() + "|playVideo";
    }
}
