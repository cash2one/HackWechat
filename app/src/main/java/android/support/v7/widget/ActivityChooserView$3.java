package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow.b;
import android.view.View;

class ActivityChooserView$3 extends b {
    final /* synthetic */ ActivityChooserView OK;

    ActivityChooserView$3(ActivityChooserView activityChooserView, View view) {
        this.OK = activityChooserView;
        super(view);
    }

    public final ListPopupWindow dp() {
        return ActivityChooserView.b(this.OK);
    }

    protected final boolean dq() {
        ActivityChooserView activityChooserView = this.OK;
        if (!activityChooserView.eo() && activityChooserView.hq) {
            activityChooserView.OH = false;
            activityChooserView.aL(activityChooserView.OI);
        }
        return true;
    }

    protected final boolean eb() {
        this.OK.en();
        return true;
    }
}
