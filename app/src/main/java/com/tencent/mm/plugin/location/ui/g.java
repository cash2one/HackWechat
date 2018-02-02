package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;

public final class g extends RelativeLayout {
    private Context mContext;
    public boolean nSW = false;
    private ImageView nTo;
    public d nTp;

    public g(Context context, d dVar) {
        super(context);
        this.nTp = dVar;
        this.mContext = context;
        this.nTo = (ImageView) View.inflate(this.mContext, R.i.dpo, this).findViewById(R.h.cDc);
    }

    public final void remove() {
        this.nTp.removeView(this);
        this.nSW = false;
    }
}
