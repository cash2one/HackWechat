package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.f;

class e$4 implements f {
    final /* synthetic */ View rQA;
    final /* synthetic */ DynamicGridView rQy;
    final /* synthetic */ e rQz;

    e$4(e eVar, DynamicGridView dynamicGridView, View view) {
        this.rQz = eVar;
        this.rQy = dynamicGridView;
        this.rQA = view;
    }

    public final void bCt() {
        DynamicGridView dynamicGridView = this.rQy;
        dynamicGridView.lUO = false;
        dynamicGridView.requestDisallowInterceptTouchEvent(false);
        if (DynamicGridView.bCy() && dynamicGridView.rQU) {
            dynamicGridView.iP(true);
        }
        if (VERSION.SDK_INT >= 21) {
            this.rQy.setElevation(this.rQz.rQt);
        } else {
            this.rQA.bringToFront();
        }
    }
}
