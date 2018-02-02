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

public final class apl extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(55.381916f, 0.0f);
                j.lineTo(56.457024f, 0.0f);
                j.cubicTo(56.297745f, 7.262626f, 57.5819f, 14.484849f, 58.0f, 21.727272f);
                j.cubicTo(50.484203f, 22.0f, 42.968407f, 22.222221f, 35.45261f, 22.50505f);
                j.cubicTo(38.090603f, 19.474747f, 40.93765f, 16.626263f, 43.515915f, 13.535354f);
                j.cubicTo(35.60193f, 10.222222f, 26.085238f, 10.989899f, 19.09704f, 16.161615f);
                j.cubicTo(12.01925f, 21.11111f, 8.166781f, 29.89899f, 8.52515f, 38.525253f);
                j.cubicTo(6.036476f, 38.67677f, 3.5577564f, 38.838383f, 1.0690819f, 39.0f);
                j.cubicTo(0.20302321f, 25.969698f, 7.5495906f, 12.848485f, 19.196587f, 7.2222223f);
                j.cubicTo(28.434547f, 2.4747474f, 39.82272f, 2.89899f, 48.921314f, 7.79798f);
                j.cubicTo(50.75298f, 5.79798f, 52.495052f, 3.6969697f, 54.62536f, 2.0f);
                j.cubicTo(54.814495f, 1.5050505f, 55.192776f, 0.5050505f, 55.381916f, 0.0f);
                j.lineTo(55.381916f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(48.933964f, 55.03601f);
                j.cubicTo(55.348537f, 49.984196f, 58.860096f, 41.66891f, 58.411175f, 33.484974f);
                j.cubicTo(60.915154f, 33.323315f, 63.409153f, 33.16166f, 65.90316f, 33.0f);
                j.cubicTo(67.14018f, 48.397926f, 56.386044f, 63.33109f, 41.681408f, 67.190674f);
                j.lineTo(41.491863f, 68.039375f);
                j.lineTo(41.47191f, 67.13005f);
                j.cubicTo(33.65072f, 69.251816f, 25.15116f, 68.00906f, 18.028288f, 64.189896f);
                j.cubicTo(15.614094f, 66.77643f, 13.229828f, 69.403366f, 10.815634f, 72.0f);
                j.cubicTo(10.197121f, 64.59404f, 9.608537f, 57.188084f, 9.0f, 49.782124f);
                j.lineTo(30.927269f, 49.782124f);
                j.cubicTo(28.443243f, 52.631348f, 25.959215f, 55.48057f, 23.415333f, 58.269173f);
                j.cubicTo(31.62559f, 62.21969f, 41.890903f, 60.77487f, 48.933964f, 55.03601f);
                j.lineTo(48.933964f, 55.03601f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
