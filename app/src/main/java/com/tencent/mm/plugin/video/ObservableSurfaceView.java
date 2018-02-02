package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.x;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder iLo;
    private a sgp = null;
    protected boolean sgq = false;
    protected boolean sgr = false;
    protected boolean sgs = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iLo = getHolder();
        this.iLo.addCallback(this);
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.iLo;
    }

    public final void bFC() {
        this.sgs = true;
        if (this.sgs) {
            this.iLo.setType(3);
        }
    }

    public final void a(a aVar) {
        this.sgp = aVar;
        if (this.sgs) {
            this.iLo.setType(3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.sgq = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.sgr = true;
        try {
            this.iLo.removeCallback(this);
        } catch (Exception e) {
        }
        this.iLo = surfaceHolder;
        this.iLo.addCallback(this);
        if (this.sgp != null) {
            this.sgp.a(this.iLo);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.sgq = false;
        this.sgr = false;
    }

    public final boolean bFD() {
        return this.sgq;
    }
}
