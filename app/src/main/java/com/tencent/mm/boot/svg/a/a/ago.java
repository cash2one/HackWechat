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

public final class ago extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 18.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(5.0f, 5.0f);
                j.lineTo(5.0f, 34.0f);
                j.lineTo(34.0f, 34.0f);
                j.lineTo(34.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
                j.close();
                j.moveTo(0.0f, 1.5049495f);
                j.cubicTo(0.0f, 0.67378885f, 0.676918f, 0.0f, 1.5049495f, 0.0f);
                j.lineTo(37.495052f, 0.0f);
                j.cubicTo(38.32621f, 0.0f, 39.0f, 0.676918f, 39.0f, 1.5049495f);
                j.lineTo(39.0f, 37.495052f);
                j.cubicTo(39.0f, 38.32621f, 38.323082f, 39.0f, 37.495052f, 39.0f);
                j.lineTo(1.5049495f, 39.0f);
                j.cubicTo(0.67378885f, 39.0f, 0.0f, 38.323082f, 0.0f, 37.495052f);
                j.lineTo(0.0f, 1.5049495f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(52.925938f, 23.0f);
                j.cubicTo(52.974922f, 22.49169f, 53.0f, 21.976135f, 53.0f, 21.454546f);
                j.cubicTo(53.0f, 12.919235f, 46.28427f, 6.0f, 38.0f, 6.0f);
                j.cubicTo(35.866688f, 6.0f, 33.837387f, 6.4588375f, 32.0f, 7.285953f);
                j.lineTo(32.0f, 10.252686f);
                j.cubicTo(33.60105f, 9.50638f, 35.378433f, 9.090909f, 37.25f, 9.090909f);
                j.cubicTo(44.29163f, 9.090909f, 50.0f, 14.9722595f, 50.0f, 22.227272f);
                j.cubicTo(50.0f, 22.486673f, 49.992702f, 22.744318f, 49.978306f, 23.0f);
                j.lineTo(52.925938f, 23.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(35.0f, 0.0f);
                j2.lineTo(26.0f, 7.4431515f);
                j2.lineTo(34.865273f, 15.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
