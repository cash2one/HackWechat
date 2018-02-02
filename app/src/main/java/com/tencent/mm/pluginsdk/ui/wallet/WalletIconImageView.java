package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletIconImageView extends ImageView {
    private int lT;
    private int vzp;
    private OnClickListener vzq;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vzp = -1;
        this.lT = 4;
        this.vzq = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        this.vzp = i;
        super.setImageResource(i);
    }

    public void setVisibility(int i) {
        this.lT = i;
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.vzq = onClickListener;
    }

    public final void o(OnClickListener onClickListener) {
        super.setVisibility(0);
        super.setImageResource(e.bDo);
        super.setContentDescription(getContext().getString(i.bWg));
        super.setOnClickListener(onClickListener);
    }

    public final void ccS() {
        super.setVisibility(this.lT);
        super.setImageResource(this.vzp);
        super.setOnClickListener(this.vzq);
    }
}
