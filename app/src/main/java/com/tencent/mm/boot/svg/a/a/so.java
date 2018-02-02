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

public final class so extends c {
    private final int height = 36;
    private final int width = 33;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 36;
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
                i2.setColor(-4547478);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(30.0f, 12.851442f);
                j.lineTo(30.0f, 33.0f);
                j.lineTo(3.0f, 33.0f);
                j.lineTo(3.0f, 13.013662f);
                j.cubicTo(5.0812554f, 14.928909f, 9.102742f, 16.658638f, 10.767557f, 17.279522f);
                j.cubicTo(10.767557f, 16.999113f, 10.605591f, 15.996458f, 10.828888f, 14.5339985f);
                j.cubicTo(6.8218164f, 12.432947f, 3.0067377f, 8.4492855f, 3.0172813f, 5.8101797f);
                j.cubicTo(3.016516f, 5.641232f, 3.0105f, 5.515129f, 3.0f, 5.427509f);
                j.lineTo(3.0f, 3.0f);
                j.lineTo(30.0f, 3.0f);
                j.lineTo(30.0f, 5.425335f);
                j.cubicTo(29.998358f, 5.479269f, 29.997364f, 5.5399776f, 29.997057f, 5.6077538f);
                j.cubicTo(30.007599f, 8.24686f, 26.007072f, 12.432947f, 22.0f, 14.5339985f);
                j.cubicTo(22.223297f, 15.996458f, 22.06133f, 16.999113f, 22.06133f, 17.279522f);
                j.cubicTo(23.773027f, 16.641155f, 27.97599f, 14.830612f, 30.0f, 12.851442f);
                j.close();
                j.moveTo(0.0f, 3.0074198f);
                j.cubicTo(0.0f, 1.3464677f, 1.3345109f, 0.0f, 3.0013576f, 0.0f);
                j.lineTo(29.998642f, 0.0f);
                j.cubicTo(31.656246f, 0.0f, 33.0f, 1.3455393f, 33.0f, 3.0074198f);
                j.lineTo(33.0f, 32.99258f);
                j.cubicTo(33.0f, 34.653534f, 31.66549f, 36.0f, 29.998642f, 36.0f);
                j.lineTo(3.0013576f, 36.0f);
                j.cubicTo(1.3437536f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                j.lineTo(0.0f, 3.0074198f);
                j.close();
                j.moveTo(16.5f, 21.014084f);
                j.cubicTo(18.985281f, 21.014084f, 21.0f, 18.996214f, 21.0f, 16.507042f);
                j.cubicTo(21.0f, 14.017872f, 18.985281f, 12.0f, 16.5f, 12.0f);
                j.cubicTo(14.014719f, 12.0f, 12.0f, 14.017872f, 12.0f, 16.507042f);
                j.cubicTo(12.0f, 18.996214f, 14.014719f, 21.014084f, 16.5f, 21.014084f);
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
