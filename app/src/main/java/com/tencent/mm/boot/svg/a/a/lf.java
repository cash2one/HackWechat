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

public final class lf extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-12345829);
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(12.410278f, 0.15388903f);
                j.cubicTo(14.41553f, -0.6171571f, 16.518124f, 1.655927f, 15.885399f, 3.708712f);
                j.cubicTo(14.834102f, 5.3409266f, 13.539449f, 6.762856f, 12.312936f, 8.244867f);
                j.cubicTo(6.297181f, 15.965342f, 4.739704f, 27.150518f, 8.828081f, 36.182774f);
                j.cubicTo(10.093532f, 39.657486f, 12.731508f, 42.271034f, 14.542075f, 45.4153f);
                j.cubicTo(15.252674f, 47.708412f, 12.381076f, 49.99151f, 10.453698f, 48.549553f);
                j.cubicTo(2.3840203f, 39.91784f, -1.295519f, 26.770002f, 2.5008311f, 15.224337f);
                j.cubicTo(4.457412f, 9.516592f, 7.4944916f, 3.6486306f, 12.410278f, 0.15388903f);
                j.lineTo(12.410278f, 0.15388903f);
                j.lineTo(12.410278f, 0.15388903f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.830606f, 8.524314f);
                j.cubicTo(24.278402f, 6.5631638f, 27.568237f, 10.585523f, 25.159607f, 12.666743f);
                j.cubicTo(21.713112f, 16.899225f, 19.421976f, 22.392448f, 20.371721f, 27.995733f);
                j.cubicTo(20.714413f, 31.777952f, 22.9468f, 34.869766f, 24.748379f, 38.041626f);
                j.cubicTo(25.257519f, 39.952747f, 23.279701f, 41.47364f, 21.566244f, 40.86328f);
                j.cubicTo(12.65627f, 32.58843f, 12.881468f, 16.689102f, 21.830606f, 8.524314f);
                j.lineTo(21.830606f, 8.524314f);
                j.lineTo(21.830606f, 8.524314f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(30.849901f, 15.761445f);
                j.cubicTo(32.924084f, 13.731298f, 36.740173f, 16.112816f, 35.874252f, 18.777384f);
                j.cubicTo(34.635784f, 21.149141f, 32.09844f, 23.140247f, 32.51126f, 26.058584f);
                j.cubicTo(32.571674f, 28.303457f, 34.716335f, 29.728464f, 35.229847f, 31.826933f);
                j.cubicTo(35.64267f, 34.47198f, 31.645338f, 36.160515f, 29.953773f, 34.042526f);
                j.cubicTo(25.553688f, 28.801233f, 26.24844f, 20.670887f, 30.849901f, 15.761445f);
                j.lineTo(30.849901f, 15.761445f);
                j.lineTo(30.849901f, 15.761445f);
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
