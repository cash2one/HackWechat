package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements SurfaceTextureListener, a {
    public final d iLm = new d(this);
    private final Set<OnAttachStateChangeListener> iLn = new LinkedHashSet();
    private volatile af iLp;
    private Runnable iLq = new 1(this);
    private volatile boolean iLs;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iLm.iKy.iKT = paint;
    }

    public final void abh() {
        if (this.iLp != null) {
            this.iLp.removeCallbacks(this.iLq);
            this.iLp.post(this.iLq);
        }
    }

    public final void l(Runnable runnable) {
        if (this.iLp != null) {
            this.iLp.post(runnable);
        }
    }

    public final boolean d(Canvas canvas) {
        return this.iLm.d(canvas);
    }

    public final void a(JSONArray jSONArray, a aVar) {
        this.iLm.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a aVar) {
        this.iLm.b(jSONArray, aVar);
    }

    public final void abi() {
        this.iLm.abi();
    }

    public final void qe(String str) {
        this.iLm.qe(str);
    }

    public final int getType() {
        return 1;
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        if (!this.iLn.contains(onAttachStateChangeListener)) {
            this.iLn.add(onAttachStateChangeListener);
            super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.iLn.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void onPause() {
        this.iLm.onPause();
    }

    public final void onResume() {
        this.iLm.onResume();
    }

    public final boolean isPaused() {
        return this.iLm.iKC;
    }

    public final void qf(String str) {
        this.iLm.iKB = str;
    }

    public final int abj() {
        return 682;
    }

    public final int abk() {
        return 683;
    }

    public final void setStartTime(long j) {
        this.iLm.iKF = j;
    }

    public final void abl() {
        this.iLm.abl();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.iLp == null) {
            HandlerThread cZ = e.cZ("MTextureView#Rending-Thread", -19);
            cZ.start();
            this.iLp = new af(cZ.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(-1);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.iLp.removeCallbacks(this.iLq);
        this.iLp.getLooper().quit();
        synchronized (this.mLock) {
            if (this.iLs) {
                try {
                    this.mLock.wait(1000);
                } catch (Throwable e) {
                    x.e("MicroMsg.MTextureView", "await error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        this.iLp = null;
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
