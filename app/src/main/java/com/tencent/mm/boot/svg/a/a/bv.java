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

public final class bv extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-855310);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(21.213203f, 0.54296666f);
                j2.cubicTo(26.642136f, 6.0343003f, 30.0f, 13.620507f, 30.0f, 22.0f);
                j2.cubicTo(30.0f, 30.379494f, 26.642136f, 37.9657f, 21.213203f, 43.457035f);
                j2.lineTo(18.031223f, 40.23848f);
                j2.cubicTo(22.645815f, 35.570847f, 25.5f, 29.122568f, 25.5f, 22.0f);
                j2.cubicTo(25.5f, 14.877431f, 22.645815f, 8.429155f, 18.031223f, 3.7615216f);
                j2.lineTo(21.213203f, 0.54296666f);
                j2.close();
                j2.moveTo(13.788582f, 8.052928f);
                j2.cubicTo(17.317389f, 11.622295f, 19.5f, 16.55333f, 19.5f, 22.0f);
                j2.cubicTo(19.5f, 27.44667f, 17.317389f, 32.377705f, 13.788582f, 35.94707f);
                j2.lineTo(10.606602f, 32.728516f);
                j2.cubicTo(13.321068f, 29.98285f, 15.0f, 26.189747f, 15.0f, 22.0f);
                j2.cubicTo(15.0f, 17.810253f, 13.321068f, 14.01715f, 10.606602f, 11.271483f);
                j2.lineTo(13.788582f, 8.052928f);
                j2.close();
                j2.moveTo(6.363961f, 15.56289f);
                j2.cubicTo(7.9926405f, 17.21029f, 9.0f, 19.486153f, 9.0f, 22.0f);
                j2.cubicTo(9.0f, 24.513847f, 7.9926405f, 26.78971f, 6.363961f, 28.43711f);
                j2.lineTo(0.0f, 22.0f);
                j2.lineTo(6.363961f, 15.56289f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
