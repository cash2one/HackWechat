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

public final class w extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 18.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.6451077f, 57.456924f);
                j.cubicTo(0.8682548f, 56.447308f, 0.4261846f, 54.84723f, 1.1404423f, 52.747314f);
                j.cubicTo(3.0478961f, 47.139404f, 13.988349f, 43.960693f, 19.174664f, 40.685303f);
                j.cubicTo(25.876808f, 36.452595f, 24.291782f, 34.671368f, 23.590298f, 31.302273f);
                j.cubicTo(20.239092f, 27.695724f, 18.048468f, 21.9563f, 18.048468f, 16.399689f);
                j.cubicTo(18.048468f, 7.3423905f, 21.849377f, 0.0f, 31.048468f, 0.0f);
                j.cubicTo(38.435772f, 0.0f, 42.34187f, 4.7349954f, 43.59395f, 11.290666f);
                j.lineTo(43.59395f, 11.290666f);
                j.cubicTo(43.90103f, 12.615256f, 44.048466f, 14.030198f, 44.048466f, 15.5f);
                j.cubicTo(44.048466f, 15.620359f, 44.04695f, 15.740823f, 44.043945f, 15.861356f);
                j.cubicTo(44.046963f, 16.040092f, 44.048466f, 16.219551f, 44.048466f, 16.399689f);
                j.cubicTo(44.048466f, 22.010128f, 41.815193f, 27.806938f, 38.40892f, 31.40648f);
                j.lineTo(38.40892f, 31.40648f);
                j.cubicTo(37.706245f, 34.817593f, 36.132366f, 36.625767f, 42.82694f, 40.915825f);
                j.cubicTo(48.013252f, 44.239353f, 58.953705f, 47.464783f, 60.861156f, 53.15511f);
                j.cubicTo(61.812973f, 55.994576f, 60.73218f, 57.790955f, 59.532192f, 58.536907f);
                j.cubicTo(58.62773f, 59.440388f, 57.379284f, 60.0f, 56.000473f, 60.0f);
                j.lineTo(5.9995284f, 60.0f);
                j.cubicTo(4.1341147f, 60.0f, 2.504199f, 58.97515f, 1.6451077f, 57.456924f);
                j.lineTo(1.6451077f, 57.456924f);
                j.close();
                j.moveTo(31.052347f, 35.0f);
                j.lineTo(31.048468f, 35.935932f);
                j.lineTo(31.048468f, 35.0f);
                j.cubicTo(31.04976f, 35.0f, 31.051054f, 35.0f, 31.052347f, 35.0f);
                j.lineTo(31.052347f, 35.0f);
                j.lineTo(31.052347f, 35.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.6451077f, 57.456924f);
                j.cubicTo(0.8682548f, 56.447308f, 0.4261846f, 54.84723f, 1.1404423f, 52.747314f);
                j.cubicTo(3.0478961f, 47.139404f, 13.988349f, 43.960693f, 19.174664f, 40.685303f);
                j.cubicTo(25.876808f, 36.452595f, 24.291782f, 34.671368f, 23.590298f, 31.302273f);
                j.cubicTo(20.239092f, 27.695724f, 18.048468f, 21.9563f, 18.048468f, 16.399689f);
                j.cubicTo(18.048468f, 7.3423905f, 21.849377f, 0.0f, 31.048468f, 0.0f);
                j.cubicTo(38.435772f, 0.0f, 42.34187f, 4.7349954f, 43.59395f, 11.290666f);
                j.lineTo(43.59395f, 11.290666f);
                j.cubicTo(43.90103f, 12.615256f, 44.048466f, 14.030198f, 44.048466f, 15.5f);
                j.cubicTo(44.048466f, 15.620359f, 44.04695f, 15.740823f, 44.043945f, 15.861356f);
                j.cubicTo(44.046963f, 16.040092f, 44.048466f, 16.219551f, 44.048466f, 16.399689f);
                j.cubicTo(44.048466f, 22.010128f, 41.815193f, 27.806938f, 38.40892f, 31.40648f);
                j.lineTo(38.40892f, 31.40648f);
                j.cubicTo(37.706245f, 34.817593f, 36.132366f, 36.625767f, 42.82694f, 40.915825f);
                j.cubicTo(48.013252f, 44.239353f, 58.953705f, 47.464783f, 60.861156f, 53.15511f);
                j.cubicTo(61.812973f, 55.994576f, 60.73218f, 57.790955f, 59.532192f, 58.536907f);
                j.cubicTo(58.62773f, 59.440388f, 57.379284f, 60.0f, 56.000473f, 60.0f);
                j.lineTo(5.9995284f, 60.0f);
                j.cubicTo(4.1341147f, 60.0f, 2.504199f, 58.97515f, 1.6451077f, 57.456924f);
                j.lineTo(1.6451077f, 57.456924f);
                j.close();
                j.moveTo(31.052347f, 35.0f);
                j.lineTo(31.048468f, 35.935932f);
                j.lineTo(31.048468f, 35.0f);
                j.cubicTo(31.04976f, 35.0f, 31.051054f, 35.0f, 31.052347f, 35.0f);
                j.lineTo(31.052347f, 35.0f);
                j.lineTo(31.052347f, 35.0f);
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
