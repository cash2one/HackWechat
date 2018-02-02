package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class FaceProcessHintView extends LinearLayout {
    private h mnj;
    private int mnk;
    private Animation mnl;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mnj = null;
        this.mnk = 0;
        this.mnl = null;
        setOrientation(0);
        setMinimumHeight(b.b(getContext(), 36.0f));
        this.mnl = AnimationUtils.loadAnimation(context, a.mcs);
        this.mnl.setInterpolator(new AccelerateDecelerateInterpolator());
    }
}
