package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.dr;
import com.tencent.mm.plugin.game.c.w;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a$a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.widget.CircleImageView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class GameCommonRecommendView extends LinearLayout implements OnClickListener {
    private LayoutInflater DF;
    private Context mContext;
    int ndn;
    int nnA;
    private View nnB;
    private TextView nnC;
    private TextView nnD;
    private LinearLayout nnE;
    private FrameLayout nnF;
    private TextView nnG;
    private ImageView nnH;
    private View nnI;
    private ImageView nnJ;
    private ImageView nnK;
    private TextView nnL;
    private TextView nnM;
    private View nnN;
    private ImageView nnO;
    private ImageView nnP;
    private TextView nnQ;
    private TextView nnR;

    private static class a {
        String jumpUrl;
        String nbh;
        int position;

        public a(int i, String str, String str2) {
            this.position = i;
            this.jumpUrl = str;
            this.nbh = str2;
        }
    }

    public GameCommonRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nnB = findViewById(R.h.cGP);
        this.nnC = (TextView) findViewById(R.h.cGS);
        this.nnD = (TextView) findViewById(R.h.cGR);
        this.nnE = (LinearLayout) findViewById(R.h.cGN);
        this.nnF = (FrameLayout) findViewById(R.h.cGO);
        this.nnG = (TextView) findViewById(R.h.cGM);
        this.nnH = (ImageView) findViewById(R.h.cGQ);
        this.nnI = findViewById(R.h.cGF);
        this.nnJ = (ImageView) findViewById(R.h.cGC);
        this.nnK = (ImageView) findViewById(R.h.cGE);
        this.nnL = (TextView) findViewById(R.h.cGG);
        this.nnM = (TextView) findViewById(R.h.cGD);
        this.nnN = findViewById(R.h.cGK);
        this.nnO = (ImageView) findViewById(R.h.cGH);
        this.nnP = (ImageView) findViewById(R.h.cGJ);
        this.nnQ = (TextView) findViewById(R.h.cGL);
        this.nnR = (TextView) findViewById(R.h.cGI);
        if (c.getScreenWidth(this.mContext) < 720) {
            this.nnL.setTextSize((float) com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12));
            this.nnM.setTextSize((float) com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12));
            this.nnQ.setTextSize((float) com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12));
            this.nnR.setTextSize((float) com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12));
        }
        x.i("MicroMsg.GameCommonRecommendView", "initView finished");
    }

    final void a(dr drVar) {
        this.nnC.setText(drVar.nkc.fon);
        if (!bh.ov(drVar.nkc.nfL)) {
            this.nnD.setText(drVar.nkc.nfL);
        }
        if (bh.cA(drVar.nkc.nfM)) {
            this.nnG.setText(drVar.nkc.nfe);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            this.nnF.removeAllViews();
            this.nnF.setVisibility(8);
            Iterator it = drVar.nkc.nfM.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (wVar != null) {
                    if (!(bh.ov(wVar.nfZ) || bh.ov(wVar.kub))) {
                        LinearLayout linearLayout = (LinearLayout) this.DF.inflate(R.i.dtw, this.nnF, false);
                        CircleImageView circleImageView = (CircleImageView) linearLayout.findViewById(R.h.cIB);
                        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                        layoutParams.leftMargin = this.nnF.getChildCount() * com.tencent.mm.bv.a.fromDPToPix(this.mContext, 15);
                        linearLayout.setLayoutParams(layoutParams);
                        e$a$a com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                        com_tencent_mm_plugin_game_d_e_a_a.nxw = R.g.bCC;
                        e.aRV().a(circleImageView, wVar.nfZ, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                        this.nnF.addView(linearLayout, 0);
                        stringBuffer.append(wVar.kub);
                        stringBuffer.append("、");
                    }
                    if (this.nnF.getChildCount() >= 3) {
                        break;
                    }
                }
            }
            if (this.nnF.getChildCount() > 0) {
                this.nnF.setVisibility(0);
            }
            this.nnG.setText(i.b(this.mContext, stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "", this.nnG.getTextSize()));
        }
        if (!bh.ov(drVar.nkc.nff)) {
            e.aRV().h(this.nnH, drVar.nkc.nff);
        }
        this.nnB.setTag(new a(1, drVar.nkc.nfg, drVar.nkc.nfK));
        this.nnB.setOnClickListener(this);
        if (this.nnA == 2) {
            ap.a(this.mContext, 10, 1018, 1, null, this.ndn, ap.BY(drVar.nkc.nfK));
        }
        if (!bh.ov(drVar.nkd.nkb)) {
            this.nnJ.setVisibility(0);
            e.aRV().h(this.nnJ, drVar.nkd.nkb);
        }
        if (!bh.ov(drVar.nkd.nfT)) {
            e.aRV().h(this.nnK, drVar.nkd.nfT);
        }
        this.nnL.setText(drVar.nkd.fon);
        this.nnM.setText(drVar.nkd.nfe);
        this.nnI.setTag(new a(2, drVar.nkd.nfg, drVar.nkd.nfK));
        this.nnI.setOnClickListener(this);
        if (this.nnA == 2) {
            ap.a(this.mContext, 10, 1018, 2, null, this.ndn, ap.BY(drVar.nkd.nfK));
        }
        if (!bh.ov(drVar.nke.nkb)) {
            this.nnO.setVisibility(0);
            e.aRV().h(this.nnO, drVar.nke.nkb);
        }
        if (!bh.ov(drVar.nke.nfT)) {
            e.aRV().h(this.nnP, drVar.nke.nfT);
        }
        this.nnQ.setText(drVar.nke.fon);
        this.nnR.setText(drVar.nke.nfe);
        this.nnN.setTag(new a(3, drVar.nke.nfg, drVar.nke.nfK));
        this.nnN.setOnClickListener(this);
        if (this.nnA == 2) {
            ap.a(this.mContext, 10, 1018, 3, null, this.ndn, ap.BY(drVar.nke.nfK));
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            ap.a(this.mContext, 10, 1018, aVar.position, c.ac(this.mContext, aVar.jumpUrl), this.ndn, ap.BY(aVar.nbh));
        }
    }
}
