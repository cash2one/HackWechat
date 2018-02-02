package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.h;

public class TextButtonPreference extends Preference {
    public TextButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int getLayoutResource() {
        return h.gXD;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        super.onCreateView(viewGroup);
        return v.fv(this.mContext).inflate(h.gXD, viewGroup, false);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
            textView.setEnabled(isEnabled());
        }
    }
}
