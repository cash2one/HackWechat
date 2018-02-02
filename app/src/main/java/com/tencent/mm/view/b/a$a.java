package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.tencent.mm.b.b;

class a$a extends b {
    float fN;
    ValueAnimator fcO;
    float fdk;
    float fdl;
    float gr;
    final /* synthetic */ a zEI;
    float zEJ;
    float zEK;
    boolean zEL;
    a$b zEM;

    static /* synthetic */ void a(a$a com_tencent_mm_view_b_a_a) {
        Rect rect = com_tencent_mm_view_b_a_a.zEI.gNA;
        float width = (((float) rect.width()) * 1.0f) / ((float) rect.height());
        if (width < (((float) com_tencent_mm_view_b_a_a.zEI.zEC.width()) * 1.0f) / ((float) com_tencent_mm_view_b_a_a.zEI.zEC.height())) {
            width = ((float) com_tencent_mm_view_b_a_a.zEI.zEC.width()) / width;
            com_tencent_mm_view_b_a_a.zEI.zEC.height();
        } else {
            width = (float) com_tencent_mm_view_b_a_a.zEI.zEC.height();
            com_tencent_mm_view_b_a_a.zEI.zEC.width();
        }
        width = com_tencent_mm_view_b_a_a.zEI.a(com_tencent_mm_view_b_a_a.zEI.fhZ) % 180.0f == 0.0f ? (width * 1.0f) / ((float) rect.height()) : (width * 1.0f) / ((float) rect.width());
        if (com_tencent_mm_view_b_a_a.zEI.zEF < width) {
            com_tencent_mm_view_b_a_a.zEI.zEF = width * 1.2f;
        }
    }

    public a$a(a aVar, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.zEI = aVar;
        this.gr = f;
        this.zEJ = f2;
        this.zEK = f3;
        this.fdk = f4;
        this.fdl = f5;
        this.fN = f6;
        this.zEL = z;
    }
}
