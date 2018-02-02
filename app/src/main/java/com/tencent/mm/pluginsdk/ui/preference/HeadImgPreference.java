package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private int height;
    private ImageView jMv;
    public OnClickListener tZZ;
    private Bitmap vtr;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnA, viewGroup2);
        this.jMv = (ImageView) onCreateView.findViewById(R.h.cph);
        return onCreateView;
    }

    public final void O(Bitmap bitmap) {
        this.vtr = null;
        if (this.jMv != null) {
            this.jMv.setImageBitmap(bitmap);
        } else {
            this.vtr = bitmap;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jMv == null) {
            this.jMv = (ImageView) view.findViewById(R.h.cph);
        }
        if (this.tZZ != null) {
            this.jMv.setOnClickListener(this.tZZ);
        }
        if (this.vtr != null) {
            this.jMv.setImageBitmap(this.vtr);
            this.vtr = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cwo);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
    }
}
