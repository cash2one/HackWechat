package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aid extends c {
    private final int height = 54;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-8683387);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(22.908676f, 30.950693f);
                j.cubicTo(27.023159f, 35.1021f, 30.232687f, 36.895073f, 32.456608f, 36.895073f);
                j.cubicTo(34.680527f, 36.895073f, 37.381214f, 34.49798f, 39.075436f, 34.45544f);
                j.cubicTo(40.475136f, 34.420296f, 45.419086f, 37.832767f, 45.94186f, 38.32456f);
                j.cubicTo(46.464634f, 38.816353f, 47.099957f, 39.55505f, 46.986763f, 40.05478f);
                j.cubicTo(46.87357f, 40.55451f, 44.11331f, 47.862286f, 38.14088f, 46.915455f);
                j.cubicTo(32.16845f, 45.968628f, 23.842045f, 39.47246f, 19.097456f, 34.797325f);
                j.lineTo(22.908676f, 30.950693f);
                j.close();
                j.moveTo(16.985262f, 21.787113f);
                j.cubicTo(17.054878f, 19.63332f, 19.520647f, 16.662056f, 19.493423f, 14.951664f);
                j.cubicTo(19.463087f, 13.04565f, 16.725452f, 8.970869f, 15.613527f, 7.9975863f);
                j.cubicTo(14.5016f, 7.024304f, 14.318393f, 6.923723f, 13.703174f, 7.037072f);
                j.cubicTo(13.0879545f, 7.150421f, 6.1487045f, 9.55696f, 7.0871115f, 15.582992f);
                j.cubicTo(8.025518f, 21.609024f, 14.463901f, 30.010153f, 19.097456f, 34.797325f);
                j.lineTo(22.911219f, 30.946669f);
                j.cubicTo(18.796738f, 26.79526f, 16.915646f, 23.940908f, 16.985262f, 21.787113f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
