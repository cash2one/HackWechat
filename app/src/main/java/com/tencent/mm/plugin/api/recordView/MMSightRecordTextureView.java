package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView extends MMTextureView implements SurfaceTextureListener {
    private int ioA;
    private int ioz;
    private d iph;
    private c ipi;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSurfaceTextureListener(this);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", new Object[]{surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2)});
        this.ioz = i;
        this.ioA = i2;
        this.iph = new d();
        this.ipi = new c(surfaceTexture, this.iph);
        this.iph.bv(i, i2);
        this.ipi.ipo = true;
        this.ipi.start();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", new Object[]{surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2)});
        this.ioz = i;
        this.ioA = i2;
        this.iph.bv(i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.ipi.ipo = false;
        try {
            this.ipi.join();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e, "onSurfaceTextureDestroyed error: %s", new Object[]{e.getMessage()});
        }
        this.ipi = null;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
