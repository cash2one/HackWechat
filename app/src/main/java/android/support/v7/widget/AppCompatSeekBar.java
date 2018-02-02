package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private k PN;
    private h Pc;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Pc = h.ey();
        this.PN = new k(this, this.Pc);
        this.PN.b(attributeSet, i);
    }
}
