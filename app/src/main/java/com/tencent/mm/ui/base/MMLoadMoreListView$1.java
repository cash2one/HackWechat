package com.tencent.mm.ui.base;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class MMLoadMoreListView$1 implements OnScrollListener {
    final /* synthetic */ MMLoadMoreListView ycb;

    MMLoadMoreListView$1(MMLoadMoreListView mMLoadMoreListView) {
        this.ycb = mMLoadMoreListView;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MMLoadMoreListView.a(this.ycb) != null) {
            MMLoadMoreListView.a(this.ycb).axW();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 0 && this.ycb.getChildAt(0) != null && this.ycb.getChildAt(0).getTop() == this.ycb.getPaddingTop()) {
            MMLoadMoreListView.a(this.ycb, true);
        } else {
            MMLoadMoreListView.a(this.ycb, false);
        }
        x.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[]{MMLoadMoreListView.b(this.ycb)});
    }
}
