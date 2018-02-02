package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager.e;

class b$2 implements e {
    final /* synthetic */ b mkI;

    b$2(b bVar) {
        this.mkI = bVar;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        if (this.mkI.xS.getParent() != null) {
            this.mkI.xS.getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void af(int i) {
    }
}
