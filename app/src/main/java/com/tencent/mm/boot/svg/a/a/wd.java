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
import com.tencent.wcdb.FileUtils;

public final class wd extends c {
    private final int height = 70;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(69.0f, 50.0f);
                j.lineTo(21.0f, 50.0f);
                j.lineTo(21.0f, 52.008118f);
                j.cubicTo(21.0f, 53.108204f, 20.113445f, 54.0f, 18.994081f, 54.0f);
                j.lineTo(16.005919f, 54.0f);
                j.cubicTo(14.898081f, 54.0f, 14.0f, 53.1066f, 14.0f, 52.008118f);
                j.lineTo(14.0f, 50.0f);
                j.lineTo(0.0f, 50.0f);
                j.lineTo(0.0f, 43.0f);
                j.lineTo(14.0f, 43.0f);
                j.lineTo(14.0f, 43.0f);
                j.lineTo(14.0f, 40.991882f);
                j.cubicTo(14.0f, 39.891796f, 14.886555f, 39.0f, 16.005919f, 39.0f);
                j.lineTo(18.994081f, 39.0f);
                j.cubicTo(20.10192f, 39.0f, 21.0f, 39.8934f, 21.0f, 40.991882f);
                j.lineTo(21.0f, 43.0f);
                j.lineTo(69.0f, 43.0f);
                j.lineTo(69.0f, 40.991882f);
                j.cubicTo(69.0f, 39.891796f, 69.88656f, 39.0f, 71.00592f, 39.0f);
                j.lineTo(73.99408f, 39.0f);
                j.cubicTo(75.10192f, 39.0f, 76.0f, 39.8934f, 76.0f, 40.991882f);
                j.lineTo(76.0f, 43.0f);
                j.lineTo(90.0f, 43.0f);
                j.lineTo(90.0f, 50.0f);
                j.lineTo(76.0f, 50.0f);
                j.lineTo(76.0f, 52.008118f);
                j.cubicTo(76.0f, 53.108204f, 75.11344f, 54.0f, 73.99408f, 54.0f);
                j.lineTo(71.00592f, 54.0f);
                j.cubicTo(69.89808f, 54.0f, 69.0f, 53.1066f, 69.0f, 52.008118f);
                j.lineTo(69.0f, 50.0f);
                j.close();
                j.moveTo(0.0f, 3.99323f);
                j.cubicTo(0.0f, 2.8923995f, 0.8907616f, 2.0f, 2.0059645f, 2.0f);
                j.lineTo(87.99403f, 2.0f);
                j.cubicTo(89.1019f, 2.0f, 90.0f, 2.8954434f, 90.0f, 3.99323f);
                j.lineTo(90.0f, 66.00677f);
                j.cubicTo(90.0f, 67.1076f, 89.10924f, 68.0f, 87.99403f, 68.0f);
                j.lineTo(2.0059645f, 68.0f);
                j.cubicTo(0.898101f, 68.0f, 0.0f, 67.10455f, 0.0f, 66.00677f);
                j.lineTo(0.0f, 3.99323f);
                j.close();
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                i3 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
