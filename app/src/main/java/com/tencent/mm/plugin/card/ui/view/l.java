package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.ra;
import java.util.LinkedList;

public final class l extends i {
    View kWB;
    LinearLayout kWC;
    boolean kWD = false;

    public final void initView() {
    }

    public final void update() {
        if (this.kWB == null) {
            this.kWB = ((ViewStub) findViewById(R.h.bQu)).inflate();
        }
        ra raVar = this.kWz.avI().atC().vRo;
        ((TextView) this.kWB.findViewById(R.h.cbr)).setText(raVar.title);
        if (raVar.vZd != null && raVar.vZd.size() > 0) {
            this.kWC = (LinearLayout) this.kWB.findViewById(R.h.cbq);
            this.kWC.removeAllViews();
            LinkedList linkedList = raVar.vZd;
            LayoutInflater layoutInflater = (LayoutInflater) this.kWz.avL().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (raVar.vZc >= linkedList.size() || this.kWD) {
                this.kWB.findViewById(R.h.cbp).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(R.i.dcJ, null, false);
                    textView.setText(((oq) linkedList.get(i)).title);
                    this.kWC.addView(textView);
                }
                this.kWC.invalidate();
                return;
            }
            for (i = 0; i < raVar.vZc; i++) {
                textView = (TextView) layoutInflater.inflate(R.i.dcJ, null, false);
                textView.setText(((oq) linkedList.get(i)).title);
                this.kWC.addView(textView);
            }
            this.kWC.invalidate();
            this.kWB.findViewById(R.h.cbp).setVisibility(0);
            this.kWB.findViewById(R.h.cbp).setOnClickListener(new 1(this, raVar, linkedList, layoutInflater));
        }
    }

    public final void awW() {
        if (this.kWB != null) {
            this.kWB.setVisibility(8);
        }
    }
}
