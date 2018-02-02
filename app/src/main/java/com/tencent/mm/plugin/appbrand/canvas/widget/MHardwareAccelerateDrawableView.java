package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView extends View implements a {
    public final d iLm = new d(this);
    private final Set<OnAttachStateChangeListener> iLn = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(2, null);
    }

    protected void onDraw(Canvas canvas) {
        d(canvas);
    }

    public final void abh() {
        postInvalidate();
    }

    public final void l(Runnable runnable) {
        post(runnable);
    }

    public final boolean d(Canvas canvas) {
        return this.iLm.d(canvas);
    }

    public final void a(JSONArray jSONArray, a$a com_tencent_mm_plugin_appbrand_canvas_widget_a_a) {
        this.iLm.a(jSONArray, com_tencent_mm_plugin_appbrand_canvas_widget_a_a);
    }

    public final void b(JSONArray jSONArray, a$a com_tencent_mm_plugin_appbrand_canvas_widget_a_a) {
        this.iLm.b(jSONArray, com_tencent_mm_plugin_appbrand_canvas_widget_a_a);
    }

    public final void abi() {
        this.iLm.abi();
    }

    public final void qe(String str) {
        this.iLm.qe(str);
    }

    public final int getType() {
        return 0;
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
