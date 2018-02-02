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

public final class az extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-14776843);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-15177020);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(33.0f, 70.0f);
                j.lineTo(33.0f, 58.0f);
                j.lineTo(21.0f, 58.0f);
                j.cubicTo(19.343145f, 58.0f, 18.0f, 56.656853f, 18.0f, 55.0f);
                j.lineTo(50.0f, 55.0f);
                j.cubicTo(50.0f, 56.656853f, 48.656853f, 58.0f, 47.0f, 58.0f);
                j.lineTo(35.0f, 58.0f);
                j.lineTo(35.0f, 70.0f);
                j.lineTo(41.0f, 70.0f);
                j.cubicTo(41.552284f, 70.0f, 42.0f, 70.447716f, 42.0f, 71.0f);
                j.cubicTo(42.0f, 71.552284f, 41.552284f, 72.0f, 41.0f, 72.0f);
                j.lineTo(27.0f, 72.0f);
                j.cubicTo(26.447716f, 72.0f, 26.0f, 71.552284f, 26.0f, 71.0f);
                j.cubicTo(26.0f, 70.447716f, 26.447716f, 70.0f, 27.0f, 70.0f);
                j.lineTo(33.0f, 70.0f);
                j.close();
                j.moveTo(22.963263f, 40.0f);
                j.lineTo(45.03674f, 40.0f);
                j.cubicTo(45.75458f, 40.0f, 46.371803f, 40.508587f, 46.50906f, 41.213184f);
                j.lineTo(49.0f, 54.0f);
                j.lineTo(19.0f, 54.0f);
                j.lineTo(21.490938f, 41.213184f);
                j.cubicTo(21.628197f, 40.508587f, 22.245419f, 40.0f, 22.963263f, 40.0f);
                j.close();
                j.moveTo(27.941095f, 50.631794f);
                j.lineTo(31.59338f, 47.182507f);
                j.lineTo(34.927055f, 49.438576f);
                j.cubicTo(35.184135f, 49.606796f, 35.52287f, 49.573586f, 35.734356f, 49.359222f);
                j.lineTo(40.37784f, 44.271843f);
                j.lineTo(39.46163f, 43.371574f);
                j.lineTo(35.17892f, 48.090324f);
                j.lineTo(31.900051f, 45.83415f);
                j.cubicTo(31.664028f, 45.665886f, 31.341633f, 45.699165f, 31.127651f, 45.91366f);
                j.lineTo(27.10436f, 49.731842f);
                j.lineTo(27.941095f, 50.631794f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
