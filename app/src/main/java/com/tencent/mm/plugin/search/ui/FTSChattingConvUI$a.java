package com.tencent.mm.plugin.search.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.z.s;

class FTSChattingConvUI$a extends a<FTSChattingConvUI$b> {
    final /* synthetic */ FTSChattingConvUI qci;
    String[] qcj;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new FTSChattingConvUI$b(this.qci, LayoutInflater.from(this.qci.mController.xIM).inflate(R.i.diW, null));
    }

    public final /* synthetic */ void a(t tVar, int i) {
        FTSChattingConvUI$b fTSChattingConvUI$b = (FTSChattingConvUI$b) tVar;
        fTSChattingConvUI$b.imw.setTag(Integer.valueOf(i));
        fTSChattingConvUI$b.imw.setText(this.qcj[i]);
    }

    FTSChattingConvUI$a(FTSChattingConvUI fTSChattingConvUI) {
        this.qci = fTSChattingConvUI;
        if (s.eV(FTSChattingConvUI.a(fTSChattingConvUI))) {
            this.qcj = new String[7];
            this.qcj[0] = fTSChattingConvUI.getResources().getString(R.l.eIz);
            this.qcj[1] = fTSChattingConvUI.getResources().getString(R.l.eIw);
            this.qcj[2] = fTSChattingConvUI.getResources().getString(R.l.eIy);
            this.qcj[3] = fTSChattingConvUI.getResources().getString(R.l.eIx);
            this.qcj[4] = fTSChattingConvUI.getResources().getString(R.l.eIC);
            this.qcj[5] = fTSChattingConvUI.getResources().getString(R.l.eIA);
            this.qcj[6] = fTSChattingConvUI.getResources().getString(R.l.eIB);
            return;
        }
        this.qcj = new String[6];
        this.qcj[0] = fTSChattingConvUI.getResources().getString(R.l.eIw);
        this.qcj[1] = fTSChattingConvUI.getResources().getString(R.l.eIy);
        this.qcj[2] = fTSChattingConvUI.getResources().getString(R.l.eIx);
        this.qcj[3] = fTSChattingConvUI.getResources().getString(R.l.eIC);
        this.qcj[4] = fTSChattingConvUI.getResources().getString(R.l.eIA);
        this.qcj[5] = fTSChattingConvUI.getResources().getString(R.l.eIB);
    }

    public final int getItemCount() {
        return this.qcj.length;
    }
}
