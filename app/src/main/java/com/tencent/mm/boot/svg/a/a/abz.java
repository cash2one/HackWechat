package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class abz extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                i2 = c.a(i2, looper);
                i2.setColor(-564640);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(12.0f, 3.0f);
                j.cubicTo(16.970562f, 3.0f, 21.0f, 7.029437f, 21.0f, 12.0f);
                j.cubicTo(21.0f, 16.970562f, 16.970562f, 21.0f, 12.0f, 21.0f);
                j.cubicTo(7.029437f, 21.0f, 3.0f, 16.970562f, 3.0f, 12.0f);
                j.cubicTo(3.0f, 7.029437f, 7.029437f, 3.0f, 12.0f, 3.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.0f);
                j = c.j(looper);
                j.moveTo(12.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(17.79899f, DownloadHelper.SAVE_FATOR, 22.5f, 6.2010098f, 22.5f, 12.0f);
                j.cubicTo(22.5f, 17.79899f, 17.79899f, 22.5f, 12.0f, 22.5f);
                j.cubicTo(6.2010098f, 22.5f, DownloadHelper.SAVE_FATOR, 17.79899f, DownloadHelper.SAVE_FATOR, 12.0f);
                j.cubicTo(DownloadHelper.SAVE_FATOR, 6.2010098f, 6.2010098f, DownloadHelper.SAVE_FATOR, 12.0f, DownloadHelper.SAVE_FATOR);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
