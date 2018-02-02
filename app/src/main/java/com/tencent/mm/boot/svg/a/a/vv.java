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

public final class vv extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-5592406);
                e = c.a(e, 1.0f, 0.0f, -70.0f, 0.0f, 1.0f, -199.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 98.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 101.67347f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 6.3265305f);
                j.cubicTo(0.0f, 2.9596574f, 2.6835413f, 0.3265306f, 6.0f, 0.3265306f);
                j.lineTo(42.0f, 0.3265306f);
                j.cubicTo(45.31085f, 0.3265306f, 48.0f, 2.9541647f, 48.0f, 6.3265305f);
                j.lineTo(48.0f, 41.32653f);
                j.cubicTo(48.0f, 44.693405f, 45.31646f, 47.32653f, 42.0f, 47.32653f);
                j.lineTo(6.0f, 47.32653f);
                j.cubicTo(2.6891508f, 47.32653f, 0.0f, 44.698895f, 0.0f, 41.32653f);
                j.lineTo(0.0f, 6.3265305f);
                j.lineTo(0.0f, 6.3265305f);
                j.close();
                j.moveTo(4.0f, 6.3265305f);
                j.cubicTo(4.0f, 5.198393f, 4.89154f, 4.3265305f, 6.0f, 4.3265305f);
                j.lineTo(42.0f, 4.3265305f);
                j.cubicTo(43.10578f, 4.3265305f, 44.0f, 5.195782f, 44.0f, 6.3265305f);
                j.lineTo(44.0f, 41.32653f);
                j.cubicTo(44.0f, 42.45467f, 43.10846f, 43.32653f, 42.0f, 43.32653f);
                j.lineTo(6.0f, 43.32653f);
                j.cubicTo(4.894218f, 43.32653f, 4.0f, 42.45728f, 4.0f, 41.32653f);
                j.lineTo(4.0f, 6.3265305f);
                j.lineTo(4.0f, 6.3265305f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
