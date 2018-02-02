package com.tencent.mm.ui.chatting.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.a;

class f$b extends a {
    TextView iir;
    ImageView jCP;
    TextView mxT;
    ImageView myd;
    final /* synthetic */ f yHG;

    public f$b(f fVar, View view) {
        this.yHG = fVar;
        super(view);
        this.jCP = (ImageView) view.findViewById(R.h.cgI);
        this.iir = (TextView) view.findViewById(R.h.cgu);
        this.iir.setVisibility(8);
        this.mxT = (TextView) view.findViewById(R.h.cgZ);
        this.myd = (ImageView) view.findViewById(R.h.cgM);
        this.myd.setImageResource(R.g.bDS);
        this.myd.setVisibility(0);
    }
}
