package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ow extends c {
    private final int height = JsApiSetBackgroundAudioState.CTRL_INDEX;
    private final int width = 235;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 235;
            case 1:
                return JsApiSetBackgroundAudioState.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-12206054);
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(212.0f, 0.0f);
                j.cubicTo(216.63023f, 5.5596924f, 222.31512f, 11.159097f, 228.0f, 16.0f);
                j.cubicTo(200.60638f, 43.807625f, 144.0f, 96.0f, 144.0f, 96.0f);
                j.cubicTo(144.0f, 96.0f, 103.635574f, 139.2875f, 84.0f, 160.0f);
                j.cubicTo(55.03448f, 132.87665f, 27.537401f, 105.75329f, 0.0f, 80.0f);
                j.cubicTo(5.6445622f, 72.9511f, 11.329443f, 67.31199f, 16.0f, 60.0f);
                j.cubicTo(38.94748f, 83.276245f, 60.719364f, 104.83991f, 84.0f, 128.0f);
                j.cubicTo(125.47056f, 84.22934f, 168.12732f, 42.0551f, 212.0f, 0.0f);
                j.lineTo(212.0f, 0.0f);
                j.close();
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
