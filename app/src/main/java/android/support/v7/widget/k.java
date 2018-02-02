package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k extends j {
    private static final int[] KP = new int[]{16843074};
    private final SeekBar PO;

    k(SeekBar seekBar, h hVar) {
        super(seekBar, hVar);
        this.PO = seekBar;
    }

    final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        ap a = ap.a(this.PO.getContext(), attributeSet, KP, i);
        Drawable bN = a.bN(0);
        if (bN != null) {
            this.PO.setThumb(bN);
        }
        a.Zu.recycle();
    }
}
