package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.i$d;

class e$5 implements OnPreDrawListener {
    final /* synthetic */ View rQA;
    final /* synthetic */ DynamicGridView rQy;
    final /* synthetic */ e rQz;
    final /* synthetic */ Context val$context;

    e$5(e eVar, DynamicGridView dynamicGridView, Context context, View view) {
        this.rQz = eVar;
        this.rQy = dynamicGridView;
        this.val$context = context;
        this.rQA = view;
    }

    public final boolean onPreDraw() {
        this.rQy.getViewTreeObserver().removeOnPreDrawListener(this);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rQy.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.rQA.getHeight() - (this.val$context.getResources().getDimensionPixelSize(i$d.qyN) + (this.val$context.getResources().getDimensionPixelSize(i$d.qyO) * 2)), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        this.rQy.setLayoutParams(marginLayoutParams);
        return true;
    }
}
