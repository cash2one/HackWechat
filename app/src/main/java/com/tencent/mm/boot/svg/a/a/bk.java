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

public final class bk extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                j.moveTo(26.302921f, 41.794167f);
                j.lineTo(26.302921f, 19.211407f);
                j.lineTo(42.211685f, 19.211407f);
                j.cubicTo(45.428864f, 19.211407f, 48.29014f, 20.02573f, 49.282246f, 20.948542f);
                j.cubicTo(51.91206f, 23.283072f, 54.585167f, 22.735918f, 54.585167f, 29.634218f);
                j.cubicTo(54.585167f, 36.532516f, 51.91206f, 37.73257f, 49.282246f, 40.05703f);
                j.cubicTo(48.29014f, 41.03853f, 45.428864f, 41.8407f, 42.211685f, 41.794167f);
                j.lineTo(26.302921f, 41.794167f);
                j.close();
                j.moveTo(21.0f, 14.0f);
                j.lineTo(21.0f, 66.11406f);
                j.lineTo(26.302921f, 66.11406f);
                j.lineTo(26.302921f, 47.005573f);
                j.lineTo(43.979324f, 47.005573f);
                j.cubicTo(49.142723f, 47.14359f, 53.855812f, 44.454838f, 56.352806f, 41.794167f);
                j.cubicTo(58.849804f, 39.133495f, 59.88809f, 35.37987f, 59.88809f, 31.371353f);
                j.cubicTo(59.88809f, 25.94755f, 58.53579f, 22.28079f, 56.352806f, 19.211407f);
                j.cubicTo(53.8633f, 15.711034f, 49.142723f, 14.0f, 43.979324f, 14.0f);
                j.lineTo(21.0f, 14.0f);
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
