package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.aj;
import com.tencent.mm.plugin.game.c.l;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class g extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private String mAppId;
    private Context mContext;
    private int ndn;

    public g(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(0);
    }

    public final void a(aj ajVar, String str, int i, int i2) {
        if (ajVar == null || bh.cA(ajVar.ngS)) {
            setVisibility(8);
            return;
        }
        if (ajVar.ngS.size() == 1) {
            ajVar.ngS.add(null);
            ajVar.ngS.add(null);
        } else if (ajVar.ngS.size() == 2) {
            ajVar.ngS.add(null);
        }
        this.mAppId = str;
        this.ndn = i2;
        Iterator it = ajVar.ngS.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            LinearLayout linearLayout = (LinearLayout) this.DF.inflate(R.i.djz, this, false);
            addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.h.ceH);
            TextView textView = (TextView) linearLayout.findViewById(R.h.ceI);
            TextView textView2 = (TextView) linearLayout.findViewById(R.h.ceG);
            if (lVar == null) {
                imageView.setImageResource(R.g.bCN);
                textView.setText(R.l.bCN);
                textView.setTextColor(this.mContext.getResources().getColor(R.e.bsz));
            } else {
                linearLayout.setOnClickListener(this);
                e.aRV().h(imageView, lVar.nfT);
                textView.setText(lVar.fon);
                if (bh.ov(lVar.nfe)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(lVar.nfe);
                    textView2.setVisibility(0);
                }
                linearLayout.setTag(lVar);
                if (i == 2) {
                    ap.a(this.mContext, 10, 1002, lVar.nfP, str, i2, ap.BY(lVar.nfK));
                }
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof l)) {
            x.w("MicroMsg.GameBlockEntranceView", "getTag is null");
            return;
        }
        l lVar = (l) view.getTag();
        if (bh.ov(lVar.nfg)) {
            x.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, lVar.nfP, c.p(this.mContext, lVar.nfg, "game_center_mygame_comm"), this.mAppId, this.ndn, ap.BY(lVar.nfK));
    }
}
