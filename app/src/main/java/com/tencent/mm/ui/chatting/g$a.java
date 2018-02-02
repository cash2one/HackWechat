package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.mm.ag.j;
import com.tencent.mm.bv.a;
import java.util.List;

public class g$a {
    private static DisplayMetrics yho = null;

    public static a a(Context context, TextPaint textPaint, List<j> list, int i) {
        a aVar = new a();
        if (yho == null) {
            yho = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = yho;
        float f = 0.0f;
        for (j jVar : list) {
            float measureText = textPaint.measureText(jVar.name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix = (a.fromDPToPix(context, 30) * 2) + ((int) f);
        int fromDPToPix2 = a.fromDPToPix(context, 95);
        if (fromDPToPix >= fromDPToPix2) {
            fromDPToPix2 = fromDPToPix;
        }
        if (i - (fromDPToPix2 / 2) < 0) {
            aVar.kbn = 0;
            aVar.kbo = displayMetrics.widthPixels - (fromDPToPix2 + 0);
        } else if (displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i) < 0) {
            aVar.kbn = displayMetrics.widthPixels - (fromDPToPix2 + 0);
            aVar.kbo = 0;
        } else {
            aVar.kbn = i - (fromDPToPix2 / 2);
            aVar.kbo = displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i);
        }
        return aVar;
    }
}
