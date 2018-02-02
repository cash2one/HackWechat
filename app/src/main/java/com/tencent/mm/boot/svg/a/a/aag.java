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
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class aag extends c {
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
                a.setColor(419430400);
                Path j = c.j(looper);
                j.moveTo(36.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(55.053825f, DownloadHelper.SAVE_FATOR, 70.5f, 16.946175f, 70.5f, 36.0f);
                j.cubicTo(70.5f, 55.053825f, 55.053825f, 70.5f, 36.0f, 70.5f);
                j.cubicTo(16.946175f, 70.5f, DownloadHelper.SAVE_FATOR, 55.053825f, DownloadHelper.SAVE_FATOR, 36.0f);
                j.cubicTo(DownloadHelper.SAVE_FATOR, 16.946175f, 16.946175f, DownloadHelper.SAVE_FATOR, 36.0f, DownloadHelper.SAVE_FATOR);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(36.0f, 72.0f);
                j.cubicTo(55.88225f, 72.0f, 72.0f, 55.88225f, 72.0f, 36.0f);
                j.cubicTo(72.0f, 16.117748f, 55.88225f, 0.0f, 36.0f, 0.0f);
                j.cubicTo(16.117748f, 0.0f, 0.0f, 16.117748f, 0.0f, 36.0f);
                j.cubicTo(0.0f, 55.88225f, 16.117748f, 72.0f, 36.0f, 72.0f);
                j.close();
                j.moveTo(36.0f, 67.5f);
                j.cubicTo(53.39697f, 67.5f, 67.5f, 53.39697f, 67.5f, 36.0f);
                j.cubicTo(67.5f, 18.603031f, 53.39697f, 4.5f, 36.0f, 4.5f);
                j.cubicTo(18.603031f, 4.5f, 4.5f, 18.603031f, 4.5f, 36.0f);
                j.cubicTo(4.5f, 53.39697f, 18.603031f, 67.5f, 36.0f, 67.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(24.0f, 27.0f);
                j.cubicTo(24.0f, 25.343145f, 25.343145f, 24.0f, 27.0f, 24.0f);
                j.lineTo(45.0f, 24.0f);
                j.cubicTo(46.656853f, 24.0f, 48.0f, 25.343145f, 48.0f, 27.0f);
                j.lineTo(48.0f, 45.0f);
                j.cubicTo(48.0f, 46.656853f, 46.656853f, 48.0f, 45.0f, 48.0f);
                j.lineTo(27.0f, 48.0f);
                j.cubicTo(25.343145f, 48.0f, 24.0f, 46.656853f, 24.0f, 45.0f);
                j.lineTo(24.0f, 27.0f);
                j.close();
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
