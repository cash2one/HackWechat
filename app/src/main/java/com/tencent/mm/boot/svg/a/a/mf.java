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
import com.tencent.wcdb.FileUtils;

public final class mf extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.333333f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(0.6666667f, 80.666664f);
                j.cubicTo(0.6666667f, 36.554592f, 36.554333f, 0.6666667f, 80.666664f, 0.6666667f);
                j.cubicTo(124.779f, 0.6666667f, 160.66667f, 36.554592f, 160.66667f, 80.666664f);
                j.cubicTo(160.66667f, 124.77874f, 124.779f, 160.66667f, 80.666664f, 160.66667f);
                j.cubicTo(36.554333f, 160.66667f, 0.6666667f, 124.77874f, 0.6666667f, 80.666664f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-11711155);
                j = c.j(looper);
                j.moveTo(106.666664f, 96.666664f);
                j.cubicTo(106.666664f, 101.28787f, 104.28978f, 103.666664f, 99.666664f, 103.666664f);
                j.lineTo(60.666668f, 103.666664f);
                j.cubicTo(56.043552f, 103.666664f, 53.666668f, 101.28787f, 53.666668f, 96.666664f);
                j.lineTo(53.666668f, 57.666668f);
                j.lineTo(71.666664f, 57.666668f);
                j.lineTo(77.666664f, 64.666664f);
                j.lineTo(106.666664f, 64.666664f);
                j.lineTo(106.666664f, 98.666664f);
                j.lineTo(106.666664f, 96.666664f);
                j.close();
                j.moveTo(79.666664f, 61.666668f);
                j.lineTo(73.666664f, 54.666668f);
                j.lineTo(53.666668f, 54.666668f);
                j.cubicTo(52.0857f, 54.666668f, 50.666668f, 56.086094f, 50.666668f, 57.666668f);
                j.lineTo(50.666668f, 96.666664f);
                j.cubicTo(50.666668f, 102.8492f, 54.57398f, 106.666664f, 60.666668f, 106.666664f);
                j.lineTo(99.666664f, 106.666664f);
                j.cubicTo(105.75935f, 106.666664f, 109.666664f, 102.8492f, 109.666664f, 96.666664f);
                j.lineTo(109.666664f, 64.666664f);
                j.cubicTo(109.666664f, 62.701645f, 108.24101f, 61.27891f, 106.666664f, 61.666668f);
                j.lineTo(79.666664f, 61.666668f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-11711155);
                Path j2 = c.j(looper);
                j2.moveTo(59.666668f, 78.666664f);
                j2.lineTo(100.666664f, 78.666664f);
                j2.lineTo(100.666664f, 75.666664f);
                j2.lineTo(59.666668f, 75.666664f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
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
