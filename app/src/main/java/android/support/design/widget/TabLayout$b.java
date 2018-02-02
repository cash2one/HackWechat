package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout.c;
import android.view.View;

public final class TabLayout$b {
    Drawable jY;
    CharSequence kJ;
    View kK;
    TabLayout kL;
    c kM;
    int mPosition;
    CharSequence mText;

    private TabLayout$b() {
        this.mPosition = -1;
    }

    public final void select() {
        if (this.kL == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        this.kL.a(this);
    }

    final void au() {
        if (this.kM != null) {
            this.kM.update();
        }
    }
}
