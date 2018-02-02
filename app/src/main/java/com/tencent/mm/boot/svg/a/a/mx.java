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

public final class mx extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-16139513);
                Path j = c.j(looper);
                j.moveTo(213.0f, 121.14815f);
                j.cubicTo(213.0f, 68.636444f, 171.36356f, 27.0f, 118.85185f, 27.0f);
                j.cubicTo(68.636444f, 27.0f, 27.0f, 68.636444f, 27.0f, 121.14815f);
                j.cubicTo(27.0f, 171.36356f, 68.636444f, 213.0f, 118.85185f, 213.0f);
                j.cubicTo(171.36356f, 213.0f, 213.0f, 171.36356f, 213.0f, 121.14815f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(73.845436f, 126.13097f);
                j.cubicTo(73.46136f, 125.73346f, 73.40951f, 125.05811f, 73.74635f, 124.59977f);
                j.lineTo(77.93406f, 118.90164f);
                j.cubicTo(78.26342f, 118.45349f, 78.884964f, 118.36194f, 79.323456f, 118.69801f);
                j.lineTo(104.235695f, 137.79182f);
                j.cubicTo(104.67368f, 138.1275f, 105.378365f, 138.10837f, 105.79235f, 137.76349f);
                j.lineTo(166.43353f, 87.244484f);
                j.cubicTo(166.85526f, 86.89315f, 167.5176f, 86.92481f, 167.91162f, 87.31395f);
                j.lineTo(171.86308f, 91.2164f);
                j.cubicTo(172.25768f, 91.6061f, 172.26135f, 92.23321f, 171.86464f, 92.623634f);
                j.lineTo(105.73968f, 157.70047f);
                j.cubicTo(105.34595f, 158.08797f, 104.711266f, 158.07556f, 104.33132f, 157.68234f);
                j.lineTo(73.845436f, 126.13097f);
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
