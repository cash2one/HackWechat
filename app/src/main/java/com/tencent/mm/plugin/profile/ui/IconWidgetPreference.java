package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView pkb;
    private int pkc;
    private Bitmap pkd;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pkb = null;
        this.pkc = -1;
        this.pkd = null;
        setLayoutResource(R.i.dnt);
        setWidgetLayoutResource(0);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dof, viewGroup2);
        return onCreateView;
    }

    public final void A(Bitmap bitmap) {
        this.pkd = bitmap;
        if (this.pkb != null) {
            this.pkb.setImageBitmap(bitmap);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pkb = (ImageView) view.findViewById(R.h.cDm);
        if (this.pkb != null) {
            this.pkb.setVisibility(8);
            if (this.pkc != -1) {
                this.pkb.setImageResource(this.pkc);
                this.pkb.setVisibility(0);
            } else if (this.pkd != null) {
                this.pkb.setImageBitmap(this.pkd);
                this.pkb.setVisibility(0);
            }
        }
    }
}
