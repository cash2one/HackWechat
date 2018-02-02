package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d extends a {
    private TextView tXS;
    private View tXT;
    public LinearLayout tXU;

    public d(View view, k kVar) {
        super(view, kVar);
        this.tXU = (LinearLayout) view.findViewById(R.h.cAQ);
        this.tXU.setVisibility(0);
        this.tXS = (TextView) view.findViewById(R.h.cAS);
        this.tXT = view.findViewById(R.h.cAR);
    }

    public final void a(b bVar, int i, int i2) {
        if (bVar.getType() == -3) {
            if (this.tWs.tUp == 3) {
                this.tXU.setVisibility(8);
                return;
            }
            this.tXU.setVisibility(0);
            com.tencent.mm.plugin.wenote.model.a.d dVar = (com.tencent.mm.plugin.wenote.model.a.d) bVar;
            if (dVar.tRE > 0) {
                Context context = this.tXS.getContext();
                long j = dVar.tRE;
                this.tXS.setText(this.tXS.getContext().getString(R.l.eyk) + " " + (j < 3600000 ? "" : DateFormat.format(context.getString(R.l.efN), j)));
            }
        }
    }

    public final int bXO() {
        return -3;
    }
}
