package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.ra;
import java.util.LinkedList;

class l$1 implements OnClickListener {
    final /* synthetic */ ra kWE;
    final /* synthetic */ LinkedList kWF;
    final /* synthetic */ LayoutInflater kWG;
    final /* synthetic */ l kWH;

    l$1(l lVar, ra raVar, LinkedList linkedList, LayoutInflater layoutInflater) {
        this.kWH = lVar;
        this.kWE = raVar;
        this.kWF = linkedList;
        this.kWG = layoutInflater;
    }

    public final void onClick(View view) {
        this.kWH.kWD = true;
        this.kWH.kWB.findViewById(R.h.cbp).setVisibility(8);
        for (int i = this.kWE.vZc; i < this.kWF.size(); i++) {
            TextView textView = (TextView) this.kWG.inflate(R.i.dcJ, null, false);
            textView.setText(((oq) this.kWF.get(i)).title);
            this.kWH.kWC.addView(textView);
        }
        this.kWH.kWC.invalidate();
    }
}
