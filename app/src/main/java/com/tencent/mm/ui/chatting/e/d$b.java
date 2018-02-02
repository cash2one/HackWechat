package com.tencent.mm.ui.chatting.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.a;

class d$b extends a {
    TextView iir;
    ImageView jCP;
    final /* synthetic */ d yHr;

    public d$b(d dVar, View view) {
        this.yHr = dVar;
        super(view);
        this.jCP = (ImageView) view.findViewById(R.h.cgI);
        this.iiq.setSingleLine(false);
        this.iiq.setMaxLines(2);
        this.iir = (TextView) view.findViewById(R.h.cgx);
    }
}
