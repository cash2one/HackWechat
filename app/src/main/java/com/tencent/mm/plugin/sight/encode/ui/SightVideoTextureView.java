package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private boolean mMute;
    private String qtl;
    private MediaPlayer qxO;
    private TextureView qxP;
    SurfaceTexture qxQ;
    private Surface qxR;
    private boolean qxS;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qxP = null;
        this.qxQ = null;
        this.qxR = null;
        this.qxP = (TextureView) findViewById(R.h.cPI);
        this.qxP.setSurfaceTextureListener(new 1(this));
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected final void ig(boolean z) {
        if (this.qxO != null) {
            try {
                if (!this.qxO.isPlaying()) {
                    return;
                }
                if (z) {
                    try {
                        this.qxO.setVolume(0.0f, 0.0f);
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                btN();
                try {
                    this.qxO.setVolume(1.0f, 1.0f);
                } catch (Exception e2) {
                    x.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e22) {
                x.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[]{Boolean.valueOf(z), e22.getMessage()});
            }
        }
    }

    public final void aB(String str, boolean z) {
        x.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(this.qxS)});
        this.qtl = str;
        this.mMute = z;
        if (this.qxQ == null) {
            x.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.qxS = true;
            return;
        }
        this.qxS = false;
        ar.Dm().F(new 2(this, str, z));
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            if (this.qxO != null) {
                z = this.qxO.isPlaying();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
        }
        return z;
    }

    public final void btJ() {
        x.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[]{Boolean.valueOf(this.qxS)});
        if (this.qxO != null || this.qxS) {
            ar.Dm().F(new 3(this));
        } else {
            x.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        }
    }

    protected final int btK() {
        if (this.qxP != null) {
            return this.qxP.getWidth();
        }
        return 0;
    }

    protected final int btL() {
        if (this.qxP != null) {
            return this.qxP.getHeight();
        }
        return 0;
    }

    public final void at(float f) {
        LayoutParams layoutParams = this.qxP.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        x.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[]{Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        x.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        this.qxP.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.width = displayMetrics2.widthPixels;
        layoutParams2.height = (int) (((float) displayMetrics2.widthPixels) / f);
        x.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[]{Integer.valueOf(layoutParams2.width), Integer.valueOf(layoutParams2.height), Float.valueOf(f)});
        postInvalidate();
    }
}
