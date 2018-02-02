package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLSurfaceView {
    private static String TAG = "OpenGlView";
    public boolean rgy;
    public boolean suA;
    public boolean suB;
    public int suC;
    WeakReference<OpenGlRender> suD;

    public void dS(int i, int i2) {
        setLayoutParams(new LayoutParams(i, i2));
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.suA = false;
        this.suB = true;
        this.rgy = false;
        this.suC = 1;
        this.suC = OpenGlRender.bID();
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        if (this.suC == 2) {
            setEGLContextFactory(new c());
            setEGLConfigChooser(new b());
        }
    }

    public final void a(OpenGlRender openGlRender) {
        this.suD = new WeakReference(openGlRender);
        super.setRenderer(openGlRender);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i(TAG, "surfaceCreated");
        super.surfaceCreated(surfaceHolder);
        OpenGlRender openGlRender = (OpenGlRender) this.suD.get();
        x.i(OpenGlRender.TAG, "surfaceCreated");
        openGlRender.Init(OpenGlRender.bID(), new WeakReference(openGlRender), openGlRender.mRenderMode);
        openGlRender.setParam(openGlRender.stO, openGlRender.stP, openGlRender.stQ, openGlRender.mRenderMode);
        openGlRender.setMode(((OpenGlView) openGlRender.stY.get()).getWidth(), ((OpenGlView) openGlRender.stY.get()).getHeight(), 0, openGlRender.mRenderMode);
        openGlRender.stV = true;
        openGlRender.stR = true;
        openGlRender.requestRender();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = (OpenGlRender) this.suD.get();
        x.i(OpenGlRender.TAG, "onSurfaceDestroyed");
        openGlRender.stR = false;
        openGlRender.Uninit(openGlRender.mRenderMode);
        x.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
        openGlRender.stM = 0;
        openGlRender.stW = 0;
        openGlRender.stX = 0;
        super.surfaceDestroyed(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void dT(int i, int i2) {
    }
}
