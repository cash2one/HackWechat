package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.eb;
import com.tencent.mm.plugin.game.c.ec;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;

public class GameNewClassifyView extends LinearLayout implements OnClickListener {
    private LinearLayout muI;
    private int ndn;
    private LayoutInflater nny;

    public GameNewClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nny = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.muI = (LinearLayout) findViewById(R.h.cmH);
    }

    public final void a(ec ecVar, int i, int i2) {
        if (ecVar == null || bh.cA(ecVar.ngS)) {
            setVisibility(8);
            return;
        }
        this.ndn = i2;
        if (this.nny == null) {
            this.nny = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.muI.removeAllViews();
        while (this.muI.getChildCount() < ecVar.ngS.size()) {
            LinearLayout linearLayout = (LinearLayout) this.nny.inflate(R.i.dkZ, this, false);
            linearLayout.setOnClickListener(this);
            this.muI.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.muI.getChildCount(); i3++) {
            if (i3 < ecVar.ngS.size()) {
                this.muI.getChildAt(i3).setVisibility(0);
            } else {
                this.muI.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < ecVar.ngS.size(); i4++) {
            linearLayout = (LinearLayout) this.muI.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(R.h.ckQ);
            e.aRV().h((ImageView) linearLayout.findViewById(R.h.ckP), ((eb) ecVar.ngS.get(i4)).nfT);
            textView.setText(((eb) ecVar.ngS.get(i4)).fon);
            linearLayout.setTag(new a(((eb) ecVar.ngS.get(i4)).nfg, i4 + 1, ((eb) ecVar.ngS.get(i4)).nfK));
        }
        setVisibility(0);
        if (i == 2) {
            ap.a(getContext(), 10, 1019, 0, null, this.ndn, null);
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (!bh.ov(aVar.url)) {
                c.ac(getContext(), aVar.url);
                ap.a(getContext(), 10, 1019, aVar.position, 7, null, this.ndn, ap.BY(aVar.extInfo));
            }
        }
    }
}
