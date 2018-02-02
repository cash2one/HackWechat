package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class gl extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = i.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return i.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                a.setColor(-15028967);
                Path j = c.j(looper);
                j.moveTo(210.0f, 106.296295f);
                j.cubicTo(210.0f, 47.00889f, 162.9911f, 0.0f, 103.703705f, 0.0f);
                j.cubicTo(47.00889f, 0.0f, 0.0f, 47.00889f, 0.0f, 106.296295f);
                j.cubicTo(0.0f, 162.9911f, 47.00889f, 210.0f, 103.703705f, 210.0f);
                j.cubicTo(162.9911f, 210.0f, 210.0f, 162.9911f, 210.0f, 106.296295f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(54.281837f, 109.439514f);
                j.lineTo(58.17945f, 104.19687f);
                j.lineTo(58.17945f, 104.19687f);
                j.cubicTo(58.640762f, 103.57636f, 59.51775f, 103.44731f, 60.138256f, 103.90862f);
                j.cubicTo(60.141663f, 103.911156f, 60.145058f, 103.913704f, 60.148438f, 103.91627f);
                j.lineTo(84.99948f, 122.74494f);
                j.lineTo(84.99948f, 122.74494f);
                j.cubicTo(85.516304f, 123.13652f, 86.2344f, 123.12196f, 86.73493f, 122.709755f);
                j.lineTo(147.92569f, 72.31694f);
                j.lineTo(147.92569f, 72.31694f);
                j.cubicTo(148.47726f, 71.8627f, 149.28241f, 71.89673f, 149.79369f, 72.39588f);
                j.lineTo(153.3208f, 75.83935f);
                j.lineTo(153.3208f, 75.83935f);
                j.cubicTo(153.87405f, 76.37948f, 153.8847f, 77.26585f, 153.34456f, 77.8191f);
                j.cubicTo(153.33617f, 77.8277f, 153.32767f, 77.83619f, 153.31905f, 77.84457f);
                j.lineTo(86.880226f, 142.48117f);
                j.lineTo(86.880226f, 142.48117f);
                j.cubicTo(86.32694f, 143.01945f, 85.44236f, 143.00832f, 84.902794f, 142.4563f);
                j.lineTo(54.40418f, 111.25338f);
                j.lineTo(54.40418f, 111.25338f);
                j.cubicTo(53.922985f, 110.76107f, 53.871113f, 109.99198f, 54.281837f, 109.439514f);
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
