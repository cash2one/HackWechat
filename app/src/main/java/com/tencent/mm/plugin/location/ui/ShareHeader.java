package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView ihS;
    private Context mContext;
    public ViewGroup nTA;
    public MMImageButton nTB;
    public MMImageButton nTC;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.cNL, this);
        this.nTA = (ViewGroup) inflate.findViewById(R.h.coo);
        this.nTB = (MMImageButton) inflate.findViewById(R.h.cSp);
        this.nTC = (MMImageButton) inflate.findViewById(R.h.cSr);
        this.ihS = (TextView) inflate.findViewById(R.h.title);
    }
}
