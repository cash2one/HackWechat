package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class a$d extends t {
    CheckBox mSc;
    View mSd;
    ImageView qqc;
    final /* synthetic */ a yyk;
    View yyo;
    TextView yyp;
    ImageView yyq;
    View yyr;

    public a$d(a aVar, View view) {
        this.yyk = aVar;
        super(view);
        this.qqc = (ImageView) view.findViewById(R.h.cnS);
        this.yyo = view.findViewById(R.h.cVA);
        this.yyr = view.findViewById(R.h.cOt);
        this.yyp = (TextView) view.findViewById(R.h.cVx);
        this.yyq = (ImageView) view.findViewById(R.h.cnV);
        this.mSc = (CheckBox) view.findViewById(R.h.cvv);
        this.mSd = view.findViewById(R.h.cvw);
        this.mSd.setVisibility(8);
        this.mSc.setVisibility(8);
        this.yyo.setVisibility(8);
        this.yyp.setVisibility(8);
        this.yyr.setVisibility(8);
        this.qqc.setOnClickListener(new 1(this, aVar));
        this.mSd.setOnClickListener(new 2(this, aVar));
    }
}
