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

public final class afe extends c {
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(27.334614f, 45.865097f);
                j.cubicTo(25.343315f, 46.87897f, 21.187138f, 52.730484f, 20.731934f, 57.04248f);
                j.cubicTo(20.231934f, 61.77881f, 21.082403f, 65.68994f, 22.739258f, 65.68994f);
                j.cubicTo(23.691587f, 65.68994f, 25.924526f, 64.05116f, 27.651304f, 61.766052f);
                j.cubicTo(28.861832f, 64.05024f, 30.447872f, 66.10601f, 32.327477f, 67.851654f);
                j.cubicTo(28.999271f, 69.187904f, 26.0f, 71.20011f, 26.0f, 73.5f);
                j.cubicTo(26.0f, 77.52051f, 31.528564f, 80.11182f, 35.64502f, 80.11182f);
                j.cubicTo(38.9312f, 80.11182f, 45.607635f, 78.17335f, 48.0f, 75.37939f);
                j.lineTo(48.0f, 75.37939f);
                j.cubicTo(50.392365f, 78.17335f, 57.0688f, 80.11182f, 60.35498f, 80.11182f);
                j.cubicTo(64.471436f, 80.11182f, 70.0f, 77.52051f, 70.0f, 73.5f);
                j.cubicTo(70.0f, 71.20011f, 67.000725f, 69.187904f, 63.672523f, 67.851654f);
                j.lineTo(63.672523f, 67.851654f);
                j.cubicTo(65.605f, 66.0569f, 67.22717f, 63.934326f, 68.44997f, 61.57273f);
                j.cubicTo(70.38834f, 63.95817f, 72.97974f, 65.68994f, 74.06749f, 65.68994f);
                j.cubicTo(75.90844f, 65.68994f, 76.85341f, 61.77881f, 76.29785f, 57.04248f);
                j.cubicTo(75.76961f, 52.539017f, 70.75588f, 46.356285f, 68.68161f, 45.759216f);
                j.cubicTo(68.89081f, 44.375946f, 69.0f, 42.95274f, 69.0f, 41.5f);
                j.cubicTo(69.0f, 27.969023f, 59.59798f, 17.0f, 48.0f, 17.0f);
                j.cubicTo(36.40202f, 17.0f, 27.0f, 27.969023f, 27.0f, 41.5f);
                j.cubicTo(27.0f, 42.989834f, 27.11484f, 44.448605f, 27.334614f, 45.865097f);
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
