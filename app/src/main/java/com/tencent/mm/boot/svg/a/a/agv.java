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

public final class agv extends c {
    private final int height = 64;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 64;
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
                i3 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(38.0f, 0.0f);
                j.lineTo(38.0f, 3.1230671f);
                j.lineTo(0.0f, 3.1230671f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(3.9542723f, 13.915369f);
                j.lineTo(5.7826085f, 15.157895f);
                j.lineTo(0.0f, 15.157895f);
                j.lineTo(0.0f, 6.965601f);
                j.lineTo(38.0f, 6.965601f);
                j.lineTo(38.0f, 15.157895f);
                j.lineTo(32.217392f, 15.157895f);
                j.lineTo(34.045727f, 13.915369f);
                j.lineTo(34.924232f, 13.915369f);
                j.lineTo(34.924232f, 10.105263f);
                j.lineTo(3.0557573f, 10.105263f);
                j.lineTo(3.0557573f, 13.915369f);
                j.lineTo(3.9542723f, 13.915369f);
                j.close();
                j.moveTo(32.217392f, 15.157895f);
                j.lineTo(38.0f, 15.157895f);
                j.lineTo(28.086956f, 22.37594f);
                j.lineTo(28.086956f, 64.0f);
                j.lineTo(9.913043f, 64.0f);
                j.lineTo(9.913043f, 22.37594f);
                j.lineTo(0.0f, 15.157895f);
                j.lineTo(5.7826085f, 15.157895f);
                j.lineTo(13.217391f, 20.210526f);
                j.lineTo(24.782608f, 20.210526f);
                j.lineTo(32.217392f, 15.157895f);
                j.close();
                j.moveTo(13.062004f, 20.210526f);
                j.lineTo(24.988686f, 20.210526f);
                j.lineTo(24.988686f, 60.93955f);
                j.lineTo(13.062004f, 60.93955f);
                j.lineTo(13.062004f, 20.210526f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(19.0f, 27.022888f);
                j2.cubicTo(20.368706f, 27.022888f, 21.47826f, 25.816298f, 21.47826f, 24.421053f);
                j2.cubicTo(21.47826f, 23.025806f, 20.368706f, 21.894737f, 19.0f, 21.894737f);
                j2.cubicTo(17.631294f, 21.894737f, 16.52174f, 23.025806f, 16.52174f, 24.421053f);
                j2.cubicTo(16.52174f, 25.816298f, 17.631294f, 27.022888f, 19.0f, 27.022888f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
