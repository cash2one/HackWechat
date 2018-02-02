package android.support.v7.widget;

import android.graphics.Outline;

final class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(Outline outline) {
        if (this.Mx.ME) {
            if (this.Mx.MD != null) {
                this.Mx.MD.getOutline(outline);
            }
        } else if (this.Mx.KT != null) {
            this.Mx.KT.getOutline(outline);
        }
    }
}
