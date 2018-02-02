package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final Drawable jY;
    final int jZ;
    final CharSequence mText;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap a = ap.a(context, attributeSet, i.dk);
        this.mText = a.getText(i.dn);
        this.jY = a.getDrawable(i.dl);
        this.jZ = a.getResourceId(i.dm, 0);
        a.Zu.recycle();
    }
}
