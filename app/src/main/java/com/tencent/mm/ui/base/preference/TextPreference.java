package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.w.a.h;

public class TextPreference extends Preference {
    private Context context;
    protected TextView kO;
    protected CharSequence mText;
    protected int ug;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        setLayoutResource(h.dnW);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.kO = (TextView) view.findViewById(16908310);
        au();
    }

    private void au() {
        if (this.kO != null) {
            this.kO.setText(this.mText);
            this.kO.setGravity(this.ug);
        }
    }

    public final void S(CharSequence charSequence) {
        this.mText = charSequence;
        this.ug = 17;
        au();
    }
}
