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

public final class iq extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                e = c.a(e, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1766.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2716.0f, 1819.1445f);
                j.lineTo(2716.0f, 1793.4993f);
                j.cubicTo(2716.0f, 1792.396f, 2715.1057f, 1791.5f, 2714.0024f, 1791.5f);
                j.lineTo(2675.9976f, 1791.5f);
                j.cubicTo(2674.8967f, 1791.5f, 2674.0f, 1792.3951f, 2674.0f, 1793.4993f);
                j.lineTo(2674.0f, 1840.5007f);
                j.cubicTo(2674.0f, 1841.604f, 2674.8943f, 1842.5f, 2675.9976f, 1842.5f);
                j.lineTo(2714.0024f, 1842.5f);
                j.cubicTo(2715.1033f, 1842.5f, 2716.0f, 1841.6049f, 2716.0f, 1840.5007f);
                j.lineTo(2716.0f, 1821.9503f);
                j.lineTo(2694.9534f, 1833.2782f);
                j.lineTo(2694.801f, 1833.36f);
                j.cubicTo(2694.6123f, 1833.4487f, 2694.3997f, 1833.5f, 2694.1743f, 1833.5f);
                j.cubicTo(2693.6523f, 1833.5f, 2693.1985f, 1833.2317f, 2692.96f, 1832.836f);
                j.lineTo(2692.8687f, 1832.6495f);
                j.lineTo(2689.067f, 1824.8727f);
                j.cubicTo(2689.0254f, 1824.7877f, 2689.0f, 1824.692f, 2689.0f, 1824.5991f);
                j.cubicTo(2689.0f, 1824.241f, 2689.3118f, 1823.9498f, 2689.6965f, 1823.9498f);
                j.cubicTo(2689.8528f, 1823.9498f, 2689.9968f, 1823.9979f, 2690.113f, 1824.0787f);
                j.lineTo(2694.5994f, 1827.0565f);
                j.cubicTo(2694.9272f, 1827.2567f, 2695.3188f, 1827.3739f, 2695.74f, 1827.3739f);
                j.cubicTo(2695.991f, 1827.3739f, 2696.2307f, 1827.3301f, 2696.4539f, 1827.2546f);
                j.lineTo(2716.0f, 1819.1445f);
                j.close();
                j.moveTo(2695.0f, 1868.0f);
                j.cubicTo(2666.8335f, 1868.0f, 2644.0f, 1845.1665f, 2644.0f, 1817.0f);
                j.cubicTo(2644.0f, 1788.8335f, 2666.8335f, 1766.0f, 2695.0f, 1766.0f);
                j.cubicTo(2723.1665f, 1766.0f, 2746.0f, 1788.8335f, 2746.0f, 1817.0f);
                j.cubicTo(2746.0f, 1845.1665f, 2723.1665f, 1868.0f, 2695.0f, 1868.0f);
                j.close();
                j.moveTo(2695.0f, 1865.0f);
                j.cubicTo(2668.4902f, 1865.0f, 2647.0f, 1843.5096f, 2647.0f, 1817.0f);
                j.cubicTo(2647.0f, 1790.4904f, 2668.4902f, 1769.0f, 2695.0f, 1769.0f);
                j.cubicTo(2721.5098f, 1769.0f, 2743.0f, 1790.4904f, 2743.0f, 1817.0f);
                j.cubicTo(2743.0f, 1843.5096f, 2721.5098f, 1865.0f, 2695.0f, 1865.0f);
                j.close();
                j.moveTo(2681.5f, 1799.0f);
                j.lineTo(2696.5f, 1799.0f);
                j.lineTo(2696.5f, 1802.0f);
                j.lineTo(2681.5f, 1802.0f);
                j.lineTo(2681.5f, 1799.0f);
                j.close();
                j.moveTo(2681.5f, 1806.5f);
                j.lineTo(2696.5f, 1806.5f);
                j.lineTo(2696.5f, 1809.5f);
                j.lineTo(2681.5f, 1809.5f);
                j.lineTo(2681.5f, 1806.5f);
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
