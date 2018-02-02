package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView extends SurfaceView implements Callback, a {
    public final d iLm = new d(this);
    private final Set<OnAttachStateChangeListener> iLn = new LinkedHashSet();
    private SurfaceHolder iLo;
    private af iLp;
    private Runnable iLq = new 1(this);
    private volatile boolean qG;

    public MSurfaceView(Context context) {
        super(context);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iLo = getHolder();
        this.iLo.addCallback(this);
        this.iLo.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iLm.iKy.iKT = paint;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.qG = false;
        if (this.iLp == null) {
            HandlerThread cZ = e.cZ("MSurfaceView#Rending-Thread", -19);
            cZ.start();
            this.iLp = new af(cZ.getLooper());
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[]{Integer.valueOf(hashCode())});
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.qG = true;
        this.iLp.getLooper().quit();
        this.iLp = null;
    }

    public void draw(Canvas canvas) {
        x.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[]{Integer.valueOf(hashCode())});
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
    }

    public final void abh() {
        l(new 2(this));
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
        return 2;
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
        return 667;
    }

    public final int abk() {
        return 668;
    }

    public final void setStartTime(long j) {
        this.iLm.iKF = j;
    }

    public final void abl() {
        this.iLm.abl();
    }
}
