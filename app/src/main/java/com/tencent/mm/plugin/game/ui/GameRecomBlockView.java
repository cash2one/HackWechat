package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.do;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class GameRecomBlockView extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    private ViewGroup mContainer = this;
    private Context mContext;
    int ndn;

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameRecomBlockView", "initView finished");
    }

    final void a(ak akVar, int i, int i2) {
        this.mContainer.removeAllViews();
        if (bh.cA(akVar.ngS)) {
            setVisibility(8);
            return;
        }
        View view;
        if (i == 2) {
            ap.a(this.mContext, 10, 1021, 0, null, i2, ap.BY(akVar.nfK));
        }
        this.DF.inflate(R.i.djC, this, true);
        TextView textView = (TextView) findViewById(R.h.cGz);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cGw);
        View findViewById = findViewById(R.h.cGA);
        TextView textView2 = (TextView) findViewById(R.h.cGB);
        if (bh.ov(akVar.nfO)) {
            textView.setVisibility(8);
        } else {
            textView.setText(akVar.nfO);
        }
        if (bh.ov(akVar.ngT)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(akVar.ngT);
        }
        findViewById.setTag(new a(null, 999, akVar.ngU, akVar.nfK, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i3 = 0;
        for (int i4 = 0; i4 < akVar.ngS.size(); i4++) {
            do doVar = (do) akVar.ngS.get(i4);
            if (doVar != null) {
                if (linearLayout.getChildCount() < 3) {
                    i3++;
                    LinearLayout linearLayout2 = (LinearLayout) this.DF.inflate(R.i.djD, this, false);
                    linearLayout2.setTag(new a(doVar.ngo, i3, doVar.nfg, doVar.nfK, "game_center_mygame_rank"));
                    linearLayout2.setOnClickListener(this);
                    linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                    textView = (TextView) linearLayout2.findViewById(R.h.cGy);
                    ImageView imageView = (ImageView) linearLayout2.findViewById(R.h.cGv);
                    TextView textView3 = (TextView) linearLayout2.findViewById(R.h.cGx);
                    TextView textView4 = (TextView) linearLayout2.findViewById(R.h.cGu);
                    switch (i4) {
                        case 0:
                            textView.setTextColor(this.mContext.getResources().getColor(R.e.bsu));
                            break;
                        case 1:
                            textView.setTextColor(this.mContext.getResources().getColor(R.e.bsv));
                            break;
                        case 2:
                            textView.setTextColor(this.mContext.getResources().getColor(R.e.bsw));
                            break;
                    }
                    textView.setText(doVar.fon);
                    e.aRV().h(imageView, doVar.nff);
                    textView3.setText(doVar.niZ);
                    if (bh.ov(doVar.nfe)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(doVar.nfe);
                    }
                    if (i == 2) {
                        ap.a(this.mContext, 10, 1021, i3, doVar.ngo, i2, ap.BY(doVar.nfK));
                    }
                } else {
                    view = new View(getContext());
                    view.setBackgroundColor(getContext().getResources().getColor(R.e.bsr));
                    addView(view, new LayoutParams(-1, a.fromDPToPix(getContext(), 5)));
                }
            }
        }
        view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(R.e.bsr));
        addView(view, new LayoutParams(-1, a.fromDPToPix(getContext(), 5)));
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameRecomBlockView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bh.ov(aVar.jumpUrl)) {
            x.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1021, aVar.ner, c.p(this.mContext, aVar.jumpUrl, aVar.fGF), aVar.appId, this.ndn, ap.BY(aVar.nbh));
    }
}
