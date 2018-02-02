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

public final class aod extends c {
    private final int height = 60;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 60;
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
                a.setColor(-3355444);
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(6.095757f, 5.7777686f);
                j.cubicTo(22.562868f, -1.9462895f, 42.458115f, -1.9055293f, 58.93528f, 5.7777686f);
                j.cubicTo(64.454475f, 8.08072f, 64.40421f, 14.979384f, 63.620064f, 20.023458f);
                j.cubicTo(63.13751f, 21.694628f, 63.54969f, 24.11986f, 61.699905f, 24.975822f);
                j.cubicTo(56.512463f, 24.36442f, 51.31497f, 23.528835f, 46.23811f, 22.36717f);
                j.cubicTo(45.956623f, 22.07166f, 45.41375f, 21.460257f, 45.142315f, 21.164745f);
                j.cubicTo(45.464016f, 17.649178f, 46.80109f, 14.357791f, 47.97731f, 11.066404f);
                j.cubicTo(45.293114f, 9.833408f, 42.548595f, 8.671742f, 39.592957f, 8.366041f);
                j.cubicTo(32.032967f, 7.418367f, 23.950207f, 7.499887f, 17.013512f, 11.056214f);
                j.cubicTo(17.958511f, 14.561592f, 20.491913f, 18.454191f, 19.34585f, 22.000328f);
                j.cubicTo(14.580642f, 23.763206f, 9.322828f, 23.946629f, 4.33645f, 24.904493f);
                j.cubicTo(1.8432609f, 25.597416f, 1.8332077f, 22.34679f, 1.4813464f, 20.736763f);
                j.cubicTo(0.6167728f, 15.509267f, 0.29507095f, 8.213191f, 6.095757f, 5.7777686f);
                j.lineTo(6.095757f, 5.7777686f);
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
