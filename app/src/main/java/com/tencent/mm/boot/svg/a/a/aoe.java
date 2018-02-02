package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aoe extends c {
    private final int height = 60;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 60;
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
                a.setColor(-8534461);
                e = c.a(e, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(11.019414f, 3.995966f);
                j.cubicTo(27.591017f, -1.7228311f, 46.26551f, -1.3263807f, 62.484955f, 5.333986f);
                j.cubicTo(65.40285f, 6.5431595f, 68.52197f, 8.347009f, 69.34703f, 11.587991f);
                j.cubicTo(70.634926f, 16.315662f, 69.80987f, 21.370405f, 68.662834f, 26.04852f);
                j.cubicTo(68.330795f, 26.286388f, 67.65666f, 26.76213f, 67.31457f, 27.0f);
                j.cubicTo(61.639774f, 26.276478f, 55.94486f, 25.384464f, 50.35056f, 24.205025f);
                j.cubicTo(48.680317f, 23.640083f, 49.12303f, 21.717299f, 49.42488f, 20.448658f);
                j.cubicTo(50.109077f, 17.55457f, 51.13537f, 14.749682f, 52.181786f, 11.964619f);
                j.cubicTo(46.335945f, 8.852483f, 39.53424f, 8.35692f, 33.02433f, 8.5155f);
                j.cubicTo(27.79225f, 8.674081f, 22.449493f, 9.45707f, 17.821115f, 11.994352f);
                j.cubicTo(19.068766f, 15.35427f, 20.447216f, 18.734009f, 20.87987f, 22.311974f);
                j.cubicTo(21.141474f, 24.175291f, 18.837347f, 24.47263f, 17.499142f, 24.72041f);
                j.cubicTo(12.538729f, 25.42411f, 7.6286244f, 26.514349f, 2.6380265f, 27.0f);
                j.cubicTo(0.70618194f, 26.246744f, 0.93760085f, 23.986977f, 0.53513324f, 22.35162f);
                j.cubicTo(-0.038383055f, 17.901463f, -0.7728864f, 12.816987f, 2.034325f, 8.931773f);
                j.cubicTo(4.338452f, 6.3052893f, 7.8298583f, 5.195228f, 11.019414f, 3.995966f);
                j.lineTo(11.019414f, 3.995966f);
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
