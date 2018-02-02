package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2 implements OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView OK;

    ActivityChooserView$2(ActivityChooserView activityChooserView) {
        this.OK = activityChooserView;
    }

    public final void onGlobalLayout() {
        if (!this.OK.eo()) {
            return;
        }
        if (this.OK.isShown()) {
            ActivityChooserView.b(this.OK).show();
            if (this.OK.OC != null) {
                this.OK.OC.o(true);
                return;
            }
            return;
        }
        ActivityChooserView.b(this.OK).dismiss();
    }
}
