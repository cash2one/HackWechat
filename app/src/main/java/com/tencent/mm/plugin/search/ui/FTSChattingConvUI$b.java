package com.tencent.mm.plugin.search.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;

class FTSChattingConvUI$b extends t {
    TextView imw;
    final /* synthetic */ FTSChattingConvUI qci;

    public FTSChattingConvUI$b(FTSChattingConvUI fTSChattingConvUI, View view) {
        this.qci = fTSChattingConvUI;
        super(view);
        this.imw = (TextView) view.findViewById(R.h.title);
        this.imw.setOnClickListener(fTSChattingConvUI);
    }
}
