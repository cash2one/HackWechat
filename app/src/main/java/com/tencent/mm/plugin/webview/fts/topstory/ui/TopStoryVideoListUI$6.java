package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.sdk.platformtools.x;

class TopStoryVideoListUI$6 extends SimpleOnGestureListener {
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$6(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!(motionEvent == null || motionEvent2 == null)) {
            if (motionEvent2.getY() < motionEvent.getY()) {
                TopStoryVideoListUI.a(this.toU, true);
            } else {
                TopStoryVideoListUI.a(this.toU, false);
            }
        }
        if (Math.abs(f2) > ((float) TopStoryVideoListUI.bPI())) {
            x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "videoListGestureDetector set start scroll");
            ((a) g.h(a.class)).iX(true);
            TopStoryVideoListUI.b(this.toU).removeCallbacks(TopStoryVideoListUI.a(this.toU));
            TopStoryVideoListUI.b(this.toU).postDelayed(TopStoryVideoListUI.a(this.toU), 50);
        } else {
            x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "videoListGestureDetector set start scroll false %f", new Object[]{Float.valueOf(f2)});
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }
}
