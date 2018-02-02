package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference extends Preference {
    Drawable drawable;
    private String qhG;
    String text;

    public SelfVuserPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelfVuserPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.doc, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.cpk);
        if (imageView != null) {
            imageView.setImageDrawable(this.drawable);
            x.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
            if (!bh.ov(this.qhG)) {
                imageView.setContentDescription(this.qhG);
            }
        }
        TextView textView = (TextView) view.findViewById(R.h.cQD);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(this.text);
        }
    }
}
