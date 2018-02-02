package android.support.v4.view;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import java.util.Comparator;

class ViewPager$i implements Comparator<View> {
    ViewPager$i() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
        if (layoutParams.zB != layoutParams2.zB) {
            return layoutParams.zB ? 1 : -1;
        } else {
            return layoutParams.position - layoutParams2.position;
        }
    }
}
