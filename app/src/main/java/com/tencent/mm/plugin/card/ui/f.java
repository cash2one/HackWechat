package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class f {
    View kND;
    private b kOF;
    private int kTo;
    private View kTp;
    private TextView kTq;
    private TextView kTr;
    private ImageView kTs;
    private ImageView[] kTt = new ImageView[3];
    private ImageView kTu;
    private MMActivity kaY;

    public f(MMActivity mMActivity, View view, int i, b bVar) {
        this.kaY = mMActivity;
        this.kND = view;
        this.kTo = i;
        this.kOF = bVar;
        this.kTp = this.kND.findViewById(R.h.bQT);
        this.kTq = (TextView) this.kND.findViewById(R.h.bQV);
        this.kTr = (TextView) this.kND.findViewById(R.h.bQU);
        this.kTs = (ImageView) this.kND.findViewById(R.h.bQW);
        this.kTt[0] = (ImageView) this.kND.findViewById(R.h.bQQ);
        this.kTt[1] = (ImageView) this.kND.findViewById(R.h.bQR);
        this.kTt[2] = (ImageView) this.kND.findViewById(R.h.bQS);
        this.kTu = (ImageView) this.kND.findViewById(R.h.bRO);
        if (this.kTo == 1) {
            this.kTq.setText(this.kaY.getString(R.l.dOE, new Object[]{Integer.valueOf(0)}));
            this.kTs.setImageResource(R.k.dxk);
        } else if (this.kTo == 2) {
            this.kTq.setText(R.l.dPo);
            this.kTs.setImageResource(R.k.dxj);
        } else if (this.kTo == 3) {
            this.kTq.setText(R.l.dPM);
            this.kTs.setImageResource(R.k.dxl);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.kTp.setOnClickListener(onClickListener);
    }

    public final void au() {
        if (this.kTo == 2) {
            l lVar = (l) am.auF().getValue("key_share_card_layout_data");
            if (lVar == null) {
                x.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                return;
            }
            if (bh.ov(lVar.kNs)) {
                this.kTr.setVisibility(8);
            } else {
                this.kTr.setVisibility(0);
                this.kTr.setText(lVar.kNs);
            }
            if (bh.cA(lVar.kNr)) {
                for (int i = 0; i < 3; i++) {
                    this.kTt[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < lVar.kNr.size()) {
                        this.kTt[i2].setVisibility(0);
                        m.a(this.kTt[i2], (String) lVar.kNr.get(i2), this.kaY.getResources().getDimensionPixelSize(R.f.bvw), R.g.bDT, false);
                    } else {
                        this.kTt[i2].setVisibility(8);
                    }
                }
            }
            if (bh.cA(lVar.kNr) || lVar.kNr.size() != 1 || !lVar.fHd || lVar.fHe) {
                this.kTu.setVisibility(8);
            } else {
                this.kTu.setVisibility(0);
            }
        } else if (this.kTo == 3) {
            this.kTq.setText(R.l.dPM);
            this.kND.findViewById(R.h.bQP).setVisibility(8);
            String str = (String) am.auF().getValue("key_card_entrance_tips");
            if (bh.ov(str)) {
                this.kTr.setVisibility(8);
                return;
            }
            this.kTr.setText(str);
            this.kTr.setVisibility(0);
        }
    }
}
