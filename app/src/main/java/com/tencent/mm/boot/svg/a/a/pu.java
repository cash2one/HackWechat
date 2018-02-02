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

public final class pu extends c {
    private final int height = 53;
    private final int width = 53;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 53;
            case 1:
                return 53;
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
                e = c.a(e, 1.0f, 0.0f, 0.434783f, 0.0f, 1.0f, 0.391304f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16896);
                Path j = c.j(looper);
                j.moveTo(52.173912f, 26.27763f);
                j.cubicTo(52.173912f, 11.621121f, 40.494686f, 0.0f, 25.764894f, 0.0f);
                j.cubicTo(11.679227f, 0.0f, 0.0f, 11.621121f, 0.0f, 26.27763f);
                j.cubicTo(0.0f, 40.29322f, 11.679227f, 51.91434f, 25.764894f, 51.91434f);
                j.cubicTo(40.494686f, 51.91434f, 52.173912f, 40.29322f, 52.173912f, 26.27763f);
                j.lineTo(52.173912f, 26.27763f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(23.805798f, 13.323138f);
                j.lineTo(23.805798f, 13.323138f);
                j.cubicTo(23.804459f, 13.294402f, 23.80379f, 13.265638f, 23.80379f, 13.23687f);
                j.cubicTo(23.80379f, 12.213226f, 24.633615f, 11.383399f, 25.657259f, 11.383399f);
                j.lineTo(25.657259f, 11.383399f);
                j.lineTo(27.465271f, 11.383399f);
                j.cubicTo(27.494038f, 11.383399f, 27.522802f, 11.384069f, 27.551538f, 11.385408f);
                j.cubicTo(28.574074f, 11.433053f, 29.364378f, 12.300605f, 29.316732f, 13.323138f);
                j.lineTo(29.316732f, 13.323138f);
                j.lineTo(28.500492f, 30.840899f);
                j.cubicTo(28.47699f, 31.345303f, 28.0612f, 31.74217f, 27.556248f, 31.74217f);
                j.lineTo(27.556248f, 31.74217f);
                j.lineTo(25.566282f, 31.74217f);
                j.cubicTo(25.06133f, 31.74217f, 24.64554f, 31.345303f, 24.622036f, 30.840899f);
                j.lineTo(23.805798f, 13.323138f);
                j.lineTo(23.805798f, 13.323138f);
                j.close();
                j.moveTo(26.561264f, 40.790512f);
                j.cubicTo(24.989546f, 40.790512f, 23.715414f, 39.52455f, 23.715414f, 37.962906f);
                j.cubicTo(23.715414f, 36.401264f, 24.989546f, 35.1353f, 26.561264f, 35.1353f);
                j.cubicTo(28.132984f, 35.1353f, 29.407114f, 36.401264f, 29.407114f, 37.962906f);
                j.cubicTo(29.407114f, 39.52455f, 28.132984f, 40.790512f, 26.561264f, 40.790512f);
                j.lineTo(26.561264f, 40.790512f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
