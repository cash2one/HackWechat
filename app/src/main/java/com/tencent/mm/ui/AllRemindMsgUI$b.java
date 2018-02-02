package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.AllRemindMsgUI.d;

class AllRemindMsgUI$b extends a {
    final /* synthetic */ AllRemindMsgUI xDG;

    AllRemindMsgUI$b(AllRemindMsgUI allRemindMsgUI) {
        this.xDG = allRemindMsgUI;
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new AllRemindMsgUI$c(this.xDG, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dqL, viewGroup, false));
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        d dVar = (d) AllRemindMsgUI.d(this.xDG).get(i);
        ((AllRemindMsgUI$c) recyclerView$t).VU.setTag(dVar);
        ((AllRemindMsgUI$c) recyclerView$t).qmh.setText(i.b(this.xDG.mController.xIM, dVar.fpL, ((AllRemindMsgUI$c) recyclerView$t).qmh.getTextSize()));
        ((AllRemindMsgUI$c) recyclerView$t).ihS.setText(i.b(this.xDG.mController.xIM, dVar.title, ((AllRemindMsgUI$c) recyclerView$t).ihS.getTextSize()));
        long currentTimeMillis = System.currentTimeMillis();
        if (dVar.timestamp - currentTimeMillis < 60000) {
            ((AllRemindMsgUI$c) recyclerView$t).tEW.setText(this.xDG.mController.xIM.getString(R.l.eiH, new Object[]{Integer.valueOf(1)}));
        } else if (dVar.timestamp - currentTimeMillis < 3600000) {
            ((AllRemindMsgUI$c) recyclerView$t).tEW.setText(this.xDG.mController.xIM.getString(R.l.eiH, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 60000)}));
        } else if (dVar.timestamp - currentTimeMillis < 10800000) {
            ((AllRemindMsgUI$c) recyclerView$t).tEW.setText(this.xDG.mController.xIM.getString(R.l.eiG, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 3600000), Long.valueOf(((dVar.timestamp - currentTimeMillis) - (((dVar.timestamp - currentTimeMillis) / 3600000) * 3600000)) / 60000)}));
        } else {
            ((AllRemindMsgUI$c) recyclerView$t).tEW.setText(n.c(this.xDG.mController.xIM, dVar.timestamp, true));
        }
        if (dVar.fpn == 2) {
            ((AllRemindMsgUI$c) recyclerView$t).hvY.setImageDrawable(this.xDG.mController.xIM.getResources().getDrawable(R.g.byU));
        } else {
            b.a(((AllRemindMsgUI$c) recyclerView$t).hvY, dVar.username);
        }
    }

    public final int getItemCount() {
        return AllRemindMsgUI.d(this.xDG) == null ? 0 : AllRemindMsgUI.d(this.xDG).size();
    }
}
