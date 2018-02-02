package com.tencent.mm.ui.widget;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.ui.widget.g.b;

public class g$b$a extends t implements OnClickListener {
    ImageView jMv;
    TextView jpW;
    TextView riU;
    RadioButton ztD;
    ImageView ztE;
    LinearLayout ztF;
    final /* synthetic */ b ztG;

    public g$b$a(b bVar, View view) {
        this.ztG = bVar;
        super(view);
        view.setOnClickListener(this);
        this.jpW = (TextView) view.findViewById(e.title);
        this.jMv = (ImageView) view.findViewById(e.icon);
        this.ztF = (LinearLayout) view.findViewById(e.cIu);
        if (g.u(bVar.ztC) || g.w(bVar.ztC)) {
            this.riU = (TextView) view.findViewById(e.caP);
            this.ztD = (RadioButton) view.findViewById(e.radio);
            this.ztE = (ImageView) view.findViewById(e.divider);
        }
    }

    public final void onClick(View view) {
        if (this.ztG.SY != null) {
            this.ztG.SY.onItemClick(null, view, getPosition(), (long) getPosition());
        }
    }
}
