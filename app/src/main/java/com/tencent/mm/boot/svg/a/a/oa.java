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

public final class oa extends c {
    private final int height = 480;
    private final int width = 480;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                i3 = c.a(i2, looper);
                i3.setColor(-16337763);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(480.0f, 0.0f);
                j.lineTo(480.0f, 480.0f);
                j.lineTo(0.0f, 480.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(110.0f, 114.0f);
                j2.cubicTo(110.0f, 111.79086f, 111.79086f, 110.0f, 114.0f, 110.0f);
                j2.lineTo(366.0f, 110.0f);
                j2.cubicTo(368.20914f, 110.0f, 370.0f, 111.79086f, 370.0f, 114.0f);
                j2.lineTo(370.0f, 366.0f);
                j2.cubicTo(370.0f, 368.20914f, 368.20914f, 370.0f, 366.0f, 370.0f);
                j2.lineTo(114.0f, 370.0f);
                j2.cubicTo(111.79086f, 370.0f, 110.0f, 368.20914f, 110.0f, 366.0f);
                j2.lineTo(110.0f, 114.0f);
                j2.close();
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-16337763);
                j2 = c.j(looper);
                j2.moveTo(240.0f, 156.0f);
                j2.cubicTo(262.0914f, 156.0f, 280.0f, 173.90862f, 280.0f, 196.0f);
                j2.cubicTo(280.0f, 218.09138f, 262.0914f, 236.0f, 240.0f, 236.0f);
                j2.cubicTo(217.90862f, 236.0f, 200.0f, 218.09138f, 200.0f, 196.0f);
                j2.cubicTo(200.0f, 173.90862f, 217.90862f, 156.0f, 240.0f, 156.0f);
                j2.close();
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-16337763);
                j2 = c.j(looper);
                j2.moveTo(191.0f, 244.0f);
                j2.cubicTo(213.09138f, 244.0f, 231.0f, 261.9086f, 231.0f, 284.0f);
                j2.cubicTo(231.0f, 306.0914f, 213.09138f, 324.0f, 191.0f, 324.0f);
                j2.cubicTo(168.90862f, 324.0f, 151.0f, 306.0914f, 151.0f, 284.0f);
                j2.cubicTo(151.0f, 261.9086f, 168.90862f, 244.0f, 191.0f, 244.0f);
                j2.close();
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-16337763);
                j2 = c.j(looper);
                j2.moveTo(289.0f, 324.0f);
                j2.cubicTo(311.0914f, 324.0f, 329.0f, 306.0914f, 329.0f, 284.0f);
                j2.cubicTo(329.0f, 261.9086f, 311.0914f, 244.0f, 289.0f, 244.0f);
                j2.cubicTo(266.9086f, 244.0f, 249.0f, 261.9086f, 249.0f, 284.0f);
                j2.cubicTo(249.0f, 306.0914f, 266.9086f, 324.0f, 289.0f, 324.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
