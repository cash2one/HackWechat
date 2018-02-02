package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

public class PaddingImageView extends FrameLayout {
    ImageView lIo;
    ImageView lIp;
    private int lIq;

    public PaddingImageView(Context context) {
        super(context);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lIq = a.aa(getContext(), R.f.bvJ);
        this.lIo = new ImageView(context);
        this.lIo.setPadding(this.lIq, this.lIq, this.lIq, this.lIq);
        this.lIp = new ImageView(context);
    }
}
