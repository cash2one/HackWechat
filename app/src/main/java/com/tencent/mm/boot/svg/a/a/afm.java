package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afm extends c {
    private final int height = JsApiCreateAudioInstance.CTRL_INDEX;
    private final int width = JsApiCreateAudioInstance.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiCreateAudioInstance.CTRL_INDEX;
            case 1:
                return JsApiCreateAudioInstance.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] a = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.462312f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(145.5f, 290.5377f);
                j.cubicTo(225.85744f, 290.5377f, 291.0f, 225.72247f, 291.0f, 145.76884f);
                j.cubicTo(291.0f, 65.815216f, 225.85744f, 1.0f, 145.5f, 1.0f);
                j.cubicTo(65.14257f, 1.0f, 0.0f, 65.815216f, 0.0f, 145.76884f);
                j.cubicTo(0.0f, 225.72247f, 65.14257f, 290.5377f, 145.5f, 290.5377f);
                j.lineTo(145.5f, 290.5377f);
                j.close();
                j.moveTo(145.5f, 286.3819f);
                j.cubicTo(223.55066f, 286.3819f, 286.82324f, 223.42729f, 286.82324f, 145.76884f);
                j.cubicTo(286.82324f, 68.11039f, 223.55066f, 5.155779f, 145.5f, 5.155779f);
                j.cubicTo(67.44933f, 5.155779f, 4.176768f, 68.11039f, 4.176768f, 145.76884f);
                j.cubicTo(4.176768f, 223.42729f, 67.44933f, 286.3819f, 145.5f, 286.3819f);
                j.lineTo(145.5f, 286.3819f);
                j.close();
                i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.FILL);
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.STROKE);
                i3.setColor(WebView.NIGHT_MODE_COLOR);
                i4.setStrokeWidth(1.0f);
                i4.setStrokeCap(Cap.BUTT);
                i4.setStrokeJoin(Join.MITER);
                i4.setStrokeMiter(4.0f);
                i4.setPathEffect(null);
                float[] a3 = c.a(a, 291.0f, 0.0f, 0.0f, 0.0f, 290.5377f, 1.0f);
                f.reset();
                f.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
