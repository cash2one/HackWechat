package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class lv extends c {
    private final int height = 62;
    private final int width = 62;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 62;
            case 1:
                return 62;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setStrokeWidth(3.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-11711155);
                Path j = c.j(looper);
                j.moveTo(11.007507f, 11.458933f);
                j.cubicTo(12.887484f, 9.4437065f, 15.622662f, 7.9247327f, 18.017488f, 7.3999724f);
                j.lineTo(20.244202f, 6.9120493f);
                j.lineTo(18.915043f, 5.060115f);
                j.cubicTo(18.642044f, 4.679744f, 18.492981f, 4.2231226f, 18.492981f, 3.7391305f);
                j.cubicTo(18.492981f, 2.4983008f, 19.479156f, DownloadHelper.SAVE_FATOR, 20.686369f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(21.893581f, DownloadHelper.SAVE_FATOR, 22.879757f, 2.4983008f, 22.879757f, 3.7391305f);
                j.cubicTo(22.879757f, 4.2231226f, 22.730694f, 4.679744f, 22.457695f, 5.060115f);
                j.lineTo(21.128536f, 6.9120493f);
                j.lineTo(23.355251f, 7.3999724f);
                j.cubicTo(29.377106f, 8.719497f, 33.48841f, 13.843313f, 33.95838f, 24.302568f);
                j.cubicTo(33.769905f, 28.412003f, 34.089592f, 31.934727f, 34.821133f, 34.91406f);
                j.lineTo(28.334389f, 28.619492f);
                j.cubicTo(28.294184f, 28.580555f, 28.294184f, 28.580555f, 28.10701f, 28.399086f);
                j.cubicTo(27.850748f, 28.150501f, 27.707758f, 28.011713f, 27.466179f, 27.777033f);
                j.cubicTo(26.775806f, 27.106375f, 26.006472f, 26.357574f, 25.177935f, 25.549345f);
                j.cubicTo(22.810862f, 23.240292f, 20.44387f, 20.917908f, 18.235228f, 18.732124f);
                j.cubicTo(18.06544f, 18.564066f, 18.06544f, 18.564066f, 17.895714f, 18.39596f);
                j.cubicTo(15.029206f, 15.556324f, 12.680043f, 13.193508f, 11.007507f, 11.458933f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-11711155);
                j = c.j(looper);
                j.moveTo(DownloadHelper.SAVE_FATOR, 42.5f);
                j.lineTo(DownloadHelper.SAVE_FATOR, 41.82444f);
                j.cubicTo(1.6038995f, 41.74702f, 1.7123853f, 41.662033f, 1.8249147f, 41.56911f);
                j.cubicTo(2.5979338f, 40.930805f, 3.3558638f, 40.07715f, 4.0502887f, 38.98194f);
                j.cubicTo(6.195145f, 35.59919f, 7.3330913f, 30.618256f, 7.0150514f, 23.757542f);
                j.cubicTo(7.107518f, 21.681265f, 7.2452464f, 20.08475f, 7.466496f, 18.886692f);
                j.cubicTo(14.1708975f, 26.23253f, 20.274372f, 32.6139f, 25.684317f, 38.023556f);
                j.cubicTo(27.371628f, 39.710777f, 28.891684f, 41.203136f, 30.23632f, 42.5f);
                j.lineTo(DownloadHelper.SAVE_FATOR, 42.5f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setColor(-11776948);
                a3.setStrokeCap(Cap.ROUND);
                Path j2 = c.j(looper);
                j2.moveTo(5.3454547f, 6.3454547f);
                j2.lineTo(42.115005f, 43.115005f);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
