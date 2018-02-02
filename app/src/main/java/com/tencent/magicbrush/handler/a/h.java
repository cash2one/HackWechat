package com.tencent.magicbrush.handler.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

final class h {
    private List<k> bnS = new ArrayList();
    g bnX;
    e bnY;
    Canvas bnZ;
    Paint boa;
    char[] bob = new char[1];
    Rect boc = new Rect();
    private Rect bod = new Rect();
    FontMetrics boe = new FontMetrics();

    h(e eVar, g gVar) {
        this.bnY = eVar;
        this.bnZ = new Canvas(this.bnY.bnI);
        this.bnX = gVar;
        this.boa = new Paint(1);
        this.boa.setTextAlign(Align.LEFT);
        this.boa.setColor(-1);
    }

    static float v(List<k> list) {
        if (list == null || list.size() == 0) {
            return 0.0f;
        }
        float f = 0.0f;
        for (k kVar : list) {
            if (kVar != null) {
                f = kVar.bot + f;
            }
        }
        return f;
    }
}
