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

public final class kn extends c {
    private final int height = 115;
    private final int width = 115;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -90.0f, 0.0f, 1.0f, -561.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(6.0f);
                float[] a2 = c.a(e, 1.0f, 0.0f, 90.0f, 0.0f, 1.0f, 561.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(57.391304f, 3.0f);
                j.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                j.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                j.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                j.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a2, 1.0f, 0.0f, 125.0f, 0.0f, 1.0f, 604.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.872f, 0.0f, 1.0f, 0.8736f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(2.88f, 2.8072181E-14f);
                j.lineTo(31.220352f, 1.589265E-14f);
                j.lineTo(31.220352f, 1.4654944E-14f);
                j.cubicTo(32.810932f, 1.436276E-14f, 34.100353f, 1.2894199f, 34.100353f, 2.88f);
                j.lineTo(34.100353f, 24.905472f);
                j.lineTo(34.100353f, 24.905472f);
                j.cubicTo(34.100353f, 26.496052f, 32.810932f, 27.785473f, 31.220352f, 27.785473f);
                j.lineTo(2.88f, 27.785473f);
                j.lineTo(2.88f, 27.785473f);
                j.cubicTo(1.2894199f, 27.785473f, 1.4008289E-13f, 26.496052f, 1.398881E-13f, 24.905472f);
                j.lineTo(2.6364292E-13f, 2.88f);
                j.lineTo(2.793321E-13f, 2.88f);
                j.cubicTo(2.8690727E-13f, 1.2894199f, 1.2894199f, 4.6033374E-14f, 2.88f, 4.574119E-14f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(35.0f, 16.154066f);
                j.cubicTo(38.160763f, 19.019035f, 44.07001f, 24.414022f, 44.533333f, 24.923437f);
                j.cubicTo(45.535843f, 25.16433f, 46.44f, 24.521954f, 46.44f, 23.970104f);
                j.cubicTo(46.44f, 22.993073f, 46.44f, 4.2294707f, 46.44f, 2.9967713f);
                j.cubicTo(46.44f, 2.3139985f, 45.440147f, 1.8522905f, 44.533333f, 2.043438f);
                j.cubicTo(43.86385f, 2.6392634f, 38.086887f, 7.8850446f, 35.0f, 10.734522f);
                j.lineTo(35.0f, 16.154066f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
