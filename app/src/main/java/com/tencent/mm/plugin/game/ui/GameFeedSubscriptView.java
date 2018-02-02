package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedSubscriptView extends LinearLayout implements OnClickListener {
    private ImageView lkk;
    private TextView nqA;
    private TextView nqB;
    private LinearLayout nqC;
    private TextView nqD;
    private TextView nqE;
    private TextView nqF;
    private ag nqz;

    public GameFeedSubscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dkq, this, true);
        this.nqA = (TextView) inflate.findViewById(R.h.csL);
        this.nqB = (TextView) inflate.findViewById(R.h.csM);
        this.nqC = (LinearLayout) inflate.findViewById(R.h.bLP);
        this.lkk = (ImageView) inflate.findViewById(R.h.bLC);
        this.nqD = (TextView) inflate.findViewById(R.h.cAj);
        this.nqE = (TextView) inflate.findViewById(R.h.cUc);
        this.nqF = (TextView) inflate.findViewById(R.h.cIg);
        this.nqA.setOnClickListener(this);
        this.nqB.setOnClickListener(this);
        this.nqC.setOnClickListener(this);
        this.nqF.setOnClickListener(this);
    }

    public final void a(ag agVar) {
        if (agVar == null || (agVar.ngO == null && agVar.ngP == null)) {
            setVisibility(8);
            return;
        }
        this.nqz = agVar;
        setVisibility(0);
        if (agVar.ngO != null) {
            this.nqA.setVisibility(8);
            this.nqB.setVisibility(8);
            this.nqC.setVisibility(8);
            switch (agVar.ngO.nga) {
                case 1:
                    this.nqB.setVisibility(0);
                    this.nqB.setText(agVar.ngO.nfe);
                    break;
                case 2:
                    this.nqA.setVisibility(0);
                    this.nqA.setText(agVar.ngO.nfe);
                    break;
                case 3:
                    this.nqC.setVisibility(0);
                    if (!bh.ov(agVar.ngO.nfZ)) {
                        a aVar = new a();
                        aVar.hDY = true;
                        e.aRV().a(this.lkk, agVar.ngO.nfZ, aVar.aRW());
                        this.lkk.setVisibility(0);
                    }
                    this.nqD.setText(agVar.ngO.nfp);
                    this.nqE.setText(agVar.ngO.nfe);
                    break;
            }
        }
        if (agVar.ngP != null) {
            this.nqF.setText(agVar.ngP.nfe);
            this.nqF.setVisibility(0);
            return;
        }
        this.nqF.setVisibility(8);
    }

    public void onClick(View view) {
        if (this.nqz != null) {
            if (view.getId() == R.h.csL || view.getId() == R.h.csM || view.getId() == R.h.bLP) {
                if (this.nqz.ngO != null && !bh.ov(this.nqz.ngO.nfg)) {
                    c.ac(getContext(), this.nqz.ngO.nfg);
                    qW(1);
                }
            } else if (view.getId() == R.h.cIg && this.nqz.ngP != null && !bh.ov(this.nqz.ngP.nfg)) {
                c.ac(getContext(), this.nqz.ngP.nfg);
                qW(2);
            }
        }
    }

    private void qW(int i) {
        String L;
        if (i == 1) {
            L = ap.L(this.nqz.nfK, "clickType", "leftCorner");
        } else {
            L = ap.L(this.nqz.nfK, "clickType", "rightCorner");
        }
        ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nqz.nfP, 7, this.nqz.ngo, GameIndexListView.aRA(), L);
    }
}
