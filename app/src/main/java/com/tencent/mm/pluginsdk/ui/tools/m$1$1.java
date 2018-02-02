package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.tools.m.1;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class m$1$1 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ 1 vyz;

    m$1$1(1 1, View view) {
        this.vyz = 1;
        this.jLA = view;
    }

    public final void run() {
        int height = (this.jLA.getResources().getDisplayMetrics().heightPixels - this.jLA.getHeight()) >>> 1;
        int height2 = (int) ((((double) height) / 1.618d) - ((double) (this.vyz.vyy.getHeight() >>> 1)));
        if (height2 >= 0) {
            if (m.bl() < 0) {
                m.access$002(b.b(this.jLA.getContext(), 20.0f));
            }
            if ((this.vyz.vyy.getHeight() + height2) + m.bl() > height) {
                height = height2 - (((this.vyz.vyy.getHeight() + height2) + m.bl()) - height);
            } else {
                height = height2;
            }
            LayoutParams layoutParams = (LayoutParams) this.vyz.vyy.getLayoutParams();
            if (height > 0 && height != layoutParams.bottomMargin) {
                x.i("VideoSightHelper", "setting tip marginBottom " + height);
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, height);
                this.vyz.vyy.setLayoutParams(layoutParams);
            }
        }
    }
}
