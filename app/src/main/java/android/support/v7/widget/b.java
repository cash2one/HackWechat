package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer Mx;

    public b(ActionBarContainer actionBarContainer) {
        this.Mx = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.Mx.ME) {
            if (this.Mx.KT != null) {
                this.Mx.KT.draw(canvas);
            }
            if (this.Mx.MC != null && this.Mx.MF) {
                this.Mx.MC.draw(canvas);
            }
        } else if (this.Mx.MD != null) {
            this.Mx.MD.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
