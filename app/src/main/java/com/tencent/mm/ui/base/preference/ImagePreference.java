package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class ImagePreference extends Preference {
    private ImageView pjO;
    private e yiM;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pjO = null;
        this.yiM = new e();
        setLayoutResource(h.gXN);
        setWidgetLayoutResource(h.dod);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fao);
        int resourceId = obtainStyledAttributes.getResourceId(m.gZd, 0);
        if (resourceId > 0) {
            e eVar = this.yiM;
            eVar.mPo = resourceId;
            eVar.bitmap = null;
            this.yiM.e(this.pjO);
        }
        obtainStyledAttributes.recycle();
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.bYQ);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gXN, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pjO = (ImageView) view.findViewById(g.cpk);
        this.yiM.e(this.pjO);
    }
}
