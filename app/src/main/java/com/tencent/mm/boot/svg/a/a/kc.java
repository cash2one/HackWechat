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

public final class kc extends c {
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
                a.setColor(-2500135);
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.7508265f, 9.118188f);
                j.cubicTo(3.893294f, 5.1235943f, 7.759701f, 2.3841593f, 11.516493f, 0.043187827f);
                j.cubicTo(13.110888f, -0.28554434f, 13.8184f, 1.3381933f, 14.665422f, 2.344313f);
                j.cubicTo(16.967329f, 5.7113276f, 19.49843f, 8.928918f, 21.72062f, 12.355701f);
                j.cubicTo(22.48792f, 13.341898f, 21.899988f, 14.786327f, 20.813807f, 15.254521f);
                j.cubicTo(18.37239f, 16.977875f, 15.622059f, 18.173265f, 12.911589f, 19.398539f);
                j.cubicTo(14.197069f, 23.56248f, 16.658415f, 27.228342f, 19.588116f, 30.416048f);
                j.cubicTo(23.753471f, 34.95853f, 28.58648f, 39.24201f, 34.595356f, 41.0849f);
                j.cubicTo(36.080135f, 38.026695f, 37.35565f, 34.759296f, 39.6177f, 32.169285f);
                j.cubicTo(41.381496f, 31.37236f, 42.7168f, 33.14552f, 44.101933f, 33.922523f);
                j.cubicTo(47.29072f, 36.402958f, 50.828285f, 38.43512f, 53.837704f, 41.13471f);
                j.cubicTo(54.455532f, 42.59906f, 53.160088f, 43.744644f, 52.45257f, 44.880264f);
                j.cubicTo(50.150665f, 47.908585f, 47.70925f, 51.235752f, 44.01225f, 52.61045f);
                j.cubicTo(41.411392f, 53.61657f, 38.66106f, 52.461025f, 36.20968f, 51.54456f);
                j.cubicTo(20.993176f, 45.03965f, 8.477179f, 32.44821f, 2.17932f, 17.127298f);
                j.cubicTo(1.1927884f, 14.616981f, 0.32583636f, 11.658391f, 1.7508265f, 9.118188f);
                j.lineTo(1.7508265f, 9.118188f);
                j.lineTo(1.7508265f, 9.118188f);
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
