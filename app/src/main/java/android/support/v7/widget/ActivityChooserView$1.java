package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1 extends DataSetObserver {
    final /* synthetic */ ActivityChooserView OK;

    ActivityChooserView$1(ActivityChooserView activityChooserView) {
        this.OK = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        ActivityChooserView.a(this.OK).notifyDataSetChanged();
    }

    public final void onInvalidated() {
        super.onInvalidated();
        ActivityChooserView.a(this.OK).notifyDataSetInvalidated();
    }
}
