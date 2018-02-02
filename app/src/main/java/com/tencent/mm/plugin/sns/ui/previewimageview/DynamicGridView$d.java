package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

class DynamicGridView$d extends Handler {
    final /* synthetic */ DynamicGridView rRm;

    private DynamicGridView$d(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                DynamicGridView dynamicGridView = this.rRm;
                View childAt = dynamicGridView.getChildAt(dynamicGridView.rRg);
                new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.rRg).append(",lastTouchX ").append(dynamicGridView.rRh).append(",lastTouchY ").append(dynamicGridView.rRi);
                if (!dynamicGridView.rQS && !dynamicGridView.rQT && f.c(childAt, dynamicGridView.rRh, dynamicGridView.rRi)) {
                    dynamicGridView.xV(dynamicGridView.rRg);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
