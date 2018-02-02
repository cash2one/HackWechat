package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class PreferenceInfoCategory extends Preference {
    public int xJs;
    public OnClickListener yjR;
    public OnClickListener yjS;

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yjR = null;
        this.yjS = null;
        this.xJs = 0;
        setLayoutResource(h.gXP);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            if (getTitle() == null || getTitle().length() <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(getTitle());
                textView.setOnClickListener(this.yjS);
            }
            ImageView imageView = (ImageView) view.findViewById(g.gVk);
            imageView.setOnClickListener(this.yjR);
            if (this.xJs > 0) {
                imageView.setImageResource(this.xJs);
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
