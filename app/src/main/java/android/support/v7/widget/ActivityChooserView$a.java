package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.z;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$a extends BaseAdapter {
    final /* synthetic */ ActivityChooserView OK;
    d OL;
    private int OM;
    boolean OO;
    private boolean OP;
    private boolean OQ;

    private ActivityChooserView$a(ActivityChooserView activityChooserView) {
        this.OK = activityChooserView;
        this.OM = 4;
    }

    public final int getItemViewType(int i) {
        if (this.OQ && i == getCount() - 1) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getCount() {
        int ef = this.OL.ef();
        if (!(this.OO || this.OL.eg() == null)) {
            ef--;
        }
        ef = Math.min(ef, this.OM);
        if (this.OQ) {
            return ef + 1;
        }
        return ef;
    }

    public final Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!(this.OO || this.OL.eg() == null)) {
                    i++;
                }
                return this.OL.aJ(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != f.list_item) {
                    view = LayoutInflater.from(this.OK.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.OK.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.OO && i == 0 && this.OP) {
                    z.b(view, true);
                    return view;
                }
                z.b(view, false);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.OK.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(f.title)).setText(this.OK.getContext().getString(i.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final int eq() {
        int i = 0;
        int i2 = this.OM;
        this.OM = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i3 = 0;
        while (i < count) {
            view = getView(i, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
        }
        this.OM = i2;
        return i3;
    }

    public final void aM(int i) {
        if (this.OM != i) {
            this.OM = i;
            notifyDataSetChanged();
        }
    }

    public final void K(boolean z) {
        if (this.OQ != z) {
            this.OQ = z;
            notifyDataSetChanged();
        }
    }

    public final void d(boolean z, boolean z2) {
        if (this.OO != z || this.OP != z2) {
            this.OO = z;
            this.OP = z2;
            notifyDataSetChanged();
        }
    }
}
