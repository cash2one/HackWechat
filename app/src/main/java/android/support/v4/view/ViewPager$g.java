package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$g extends DataSetObserver {
    final /* synthetic */ ViewPager zx;

    private ViewPager$g(ViewPager viewPager) {
        this.zx = viewPager;
    }

    public final void onChanged() {
        this.zx.bR();
    }

    public final void onInvalidated() {
        this.zx.bR();
    }
}
