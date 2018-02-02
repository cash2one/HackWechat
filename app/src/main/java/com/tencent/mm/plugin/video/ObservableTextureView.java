package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture aDa;
    protected b sgt;
    private boolean sgu = false;

    public ObservableTextureView(Context context) {
        super(context);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.aDa = getSurfaceTexture();
    }

    public boolean isAvailable() {
        return this.sgu;
    }

    public final void a(b bVar) {
        this.sgt = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        cpK();
        this.sgu = true;
        if (this.sgt != null) {
            this.sgt.d(surfaceTexture);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.sgu = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
