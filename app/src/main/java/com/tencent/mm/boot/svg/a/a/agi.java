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

public final class agi extends c {
    private final int height = 186;
    private final int width = 186;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16896);
                Path j = c.j(looper);
                j.moveTo(186.0f, 94.14815f);
                j.cubicTo(186.0f, 41.636444f, 144.36356f, 0.0f, 91.85185f, 0.0f);
                j.cubicTo(41.636444f, 0.0f, 0.0f, 41.636444f, 0.0f, 94.14815f);
                j.cubicTo(0.0f, 144.36356f, 41.636444f, 186.0f, 91.85185f, 186.0f);
                j.cubicTo(144.36356f, 186.0f, 186.0f, 144.36356f, 186.0f, 94.14815f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(107.577896f, 70.84931f);
                j.cubicTo(122.7227f, 70.84931f, 135.0f, 83.19187f, 135.0f, 98.42466f);
                j.cubicTo(135.0f, 113.6541f, 122.72481f, 126.0f, 107.577896f, 126.0f);
                j.lineTo(55.890526f, 126.0f);
                j.cubicTo(55.3987f, 126.0f, 55.0f, 125.58803f, 55.0f, 125.10005f);
                j.lineTo(55.0f, 117.85886f);
                j.cubicTo(55.0f, 117.361824f, 55.39301f, 116.9589f, 55.890583f, 116.9589f);
                j.lineTo(107.58115f, 116.9589f);
                j.cubicTo(117.75454f, 116.9589f, 126.01124f, 108.660835f, 126.01124f, 98.42466f);
                j.cubicTo(126.01124f, 88.186226f, 117.7598f, 79.89041f, 107.58115f, 79.89041f);
                j.lineTo(75.55843f, 79.89041f);
                j.lineTo(75.55843f, 89.56726f);
                j.cubicTo(75.55843f, 90.5657f, 74.91493f, 90.89319f, 74.12114f, 90.29675f);
                j.lineTo(55.596493f, 76.37788f);
                j.cubicTo(54.799637f, 75.779144f, 54.8027f, 74.81443f, 55.596493f, 74.217995f);
                j.lineTo(74.12114f, 60.299118f);
                j.cubicTo(74.918f, 59.700382f, 75.55843f, 60.02929f, 75.55843f, 61.02861f);
                j.lineTo(75.55843f, 70.84931f);
                j.lineTo(107.577896f, 70.84931f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
