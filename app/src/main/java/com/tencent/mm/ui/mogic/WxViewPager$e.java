package com.tencent.mm.ui.mogic;

import android.view.View;
import com.tencent.mm.ui.mogic.WxViewPager.LayoutParams;
import java.util.Comparator;

class WxViewPager$e implements Comparator<View> {
    WxViewPager$e() {
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
