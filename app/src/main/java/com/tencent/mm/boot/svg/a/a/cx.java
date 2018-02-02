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

public final class cx extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
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
                e = c.a(e, 1.0f, 0.0f, -251.0f, 0.0f, 1.0f, -198.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a = c.a(e, 1.0f, 0.0f, 251.0f, 0.0f, 1.0f, 198.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1686720);
                Path j = c.j(looper);
                j.moveTo(30.0f, 60.0f);
                j.cubicTo(46.568542f, 60.0f, 60.0f, 46.568542f, 60.0f, 30.0f);
                j.cubicTo(60.0f, 13.4314575f, 46.568542f, 0.0f, 30.0f, 0.0f);
                j.cubicTo(13.4314575f, 0.0f, 0.0f, 13.4314575f, 0.0f, 30.0f);
                j.cubicTo(0.0f, 46.568542f, 13.4314575f, 60.0f, 30.0f, 60.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a, 0.70710677f, -0.70710677f, 30.0f, 0.70710677f, 0.70710677f, -12.426407f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(31.5f, 28.5f);
                j.lineTo(31.5f, 16.508265f);
                j.cubicTo(31.5f, 15.668654f, 30.828426f, 15.0f, 30.0f, 15.0f);
                j.cubicTo(29.165796f, 15.0f, 28.5f, 15.675273f, 28.5f, 16.508265f);
                j.lineTo(28.5f, 28.5f);
                j.lineTo(16.508265f, 28.5f);
                j.cubicTo(15.668654f, 28.5f, 15.0f, 29.171574f, 15.0f, 30.0f);
                j.cubicTo(15.0f, 30.834204f, 15.675273f, 31.5f, 16.508265f, 31.5f);
                j.lineTo(28.5f, 31.5f);
                j.lineTo(28.5f, 43.491737f);
                j.cubicTo(28.5f, 44.331345f, 29.171574f, 45.0f, 30.0f, 45.0f);
                j.cubicTo(30.834204f, 45.0f, 31.5f, 44.324726f, 31.5f, 43.491737f);
                j.lineTo(31.5f, 31.5f);
                j.lineTo(43.491737f, 31.5f);
                j.cubicTo(44.331345f, 31.5f, 45.0f, 30.828426f, 45.0f, 30.0f);
                j.cubicTo(45.0f, 29.165796f, 44.324726f, 28.5f, 43.491737f, 28.5f);
                j.lineTo(31.5f, 28.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
