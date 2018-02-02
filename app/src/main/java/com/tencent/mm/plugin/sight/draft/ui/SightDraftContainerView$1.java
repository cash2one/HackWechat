package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SightDraftContainerView$1 implements OnTouchListener {
    final /* synthetic */ SightDraftContainerView qvU;

    SightDraftContainerView$1(SightDraftContainerView sightDraftContainerView) {
        this.qvU = sightDraftContainerView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SightDraftContainerView sightDraftContainerView = this.qvU;
        if (sightDraftContainerView.qvT != null) {
            b bVar = sightDraftContainerView.qvT;
            bVar.a(null);
            bVar.qvw.btn();
        }
        return false;
    }
}
