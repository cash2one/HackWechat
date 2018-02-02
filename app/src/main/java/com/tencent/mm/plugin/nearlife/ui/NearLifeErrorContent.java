package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private View contentView;
    ListView inm;
    private Context mContext;
    private TextView oRg;
    private View oRh;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.contentView = View.inflate(this.mContext, R.i.doF, this);
        this.oRg = (TextView) this.contentView.findViewById(R.h.cyL);
        this.oRh = this.contentView.findViewById(R.h.czg);
    }

    public final void tU(int i) {
        switch (i) {
            case 0:
                this.oRg.setVisibility(8);
                this.oRh.setVisibility(8);
                this.inm.setVisibility(0);
                return;
            case 1:
                this.oRg.setVisibility(0);
                this.oRh.setVisibility(8);
                this.inm.setVisibility(8);
                return;
            case 2:
                this.oRg.setVisibility(8);
                this.oRh.setVisibility(0);
                this.inm.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
