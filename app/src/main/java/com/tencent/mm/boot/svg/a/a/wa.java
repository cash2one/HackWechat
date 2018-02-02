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

public final class wa extends c {
    private final int height = 93;
    private final int width = 93;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                e = c.a(e, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 31.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.restore();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                i2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(78.991554f, 14.00827f);
                j.cubicTo(97.66948f, 31.740889f, 97.66948f, 61.25771f, 78.991554f, 78.99145f);
                j.cubicTo(61.258163f, 97.66952f, 31.741741f, 97.66952f, 14.008727f, 78.99145f);
                j.cubicTo(-4.6695757f, 61.25771f, -4.6695757f, 31.740889f, 14.008727f, 14.00827f);
                j.cubicTo(31.740246f, -4.669423f, 61.258163f, -4.669423f, 78.991554f, 14.00827f);
                j.close();
                j.moveTo(86.38453f, 48.423794f);
                j.cubicTo(86.38453f, 25.27637f, 68.759476f, 7.65122f, 48.42406f, 7.65122f);
                j.cubicTo(25.275711f, 7.65122f, 7.6517115f, 25.27637f, 7.6517115f, 48.423794f);
                j.cubicTo(7.6517115f, 68.759315f, 25.276764f, 86.38446f, 45.612175f, 86.38446f);
                j.cubicTo(68.759476f, 86.38446f, 86.38453f, 68.759315f, 86.38453f, 48.423794f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(48.44434f, 43.142254f);
                j2.lineTo(55.190773f, 29.0f);
                j2.lineTo(61.51553f, 29.0f);
                j2.lineTo(54.769096f, 43.142254f);
                j2.lineTo(61.51553f, 43.142254f);
                j2.lineTo(61.51553f, 48.44558f);
                j2.lineTo(49.28777f, 48.44558f);
                j2.lineTo(49.28777f, 53.306904f);
                j2.lineTo(61.51553f, 53.306904f);
                j2.lineTo(61.51553f, 58.61023f);
                j2.lineTo(49.28777f, 58.61023f);
                j2.lineTo(49.28777f, 66.565216f);
                j2.lineTo(44.227966f, 66.565216f);
                j2.lineTo(44.227966f, 58.61023f);
                j2.lineTo(32.0f, 58.61023f);
                j2.lineTo(32.0f, 53.306904f);
                j2.lineTo(44.227966f, 53.306904f);
                j2.lineTo(44.227966f, 48.44558f);
                j2.lineTo(32.0f, 48.44558f);
                j2.lineTo(32.0f, 43.142254f);
                j2.lineTo(38.746433f, 43.142254f);
                j2.lineTo(32.0f, 29.0f);
                j2.lineTo(38.324757f, 29.0f);
                j2.lineTo(45.07119f, 43.142254f);
                j2.lineTo(48.44434f, 43.142254f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
