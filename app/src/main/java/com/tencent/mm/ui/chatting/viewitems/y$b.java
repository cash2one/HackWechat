package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.chatting.viewitems.y.c;
import com.tencent.wcdb.FileUtils;

public class y$b extends b {
    protected c yMG;
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 48) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dea);
        view.setTag(new y$d().q(view, false));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        this.yqa = chattingUI$a;
        y$d com_tencent_mm_ui_chatting_viewitems_y_d = (y$d) aVar;
        if (this.yMG == null) {
            this.yMG = new c(chattingUI$a);
        }
        y$d.a(com_tencent_mm_ui_chatting_viewitems_y_d, auVar, false, i, chattingUI$a, this.yMG, s(chattingUI$a));
        aVar = (y$d) aVar;
        if (cvy()) {
            if (auVar.field_status == 2 && a(chattingUI$a.ysf, auVar.field_msgId)) {
                if (aVar.yJk != null) {
                    aVar.yJk.setVisibility(0);
                }
            } else if (aVar.yJk != null) {
                aVar.yJk.setVisibility(8);
            }
        }
        a(i, aVar, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.getType() == 48) {
            int i = ((ar) view.getTag()).position;
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
            }
            contextMenu.add(i, 126, 0, view.getContext().getString(R.l.eEC));
            if (f.LQ() && !this.yqa.csV()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
            }
            if (d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
            }
            b dhVar = new dh();
            dhVar.frQ.fqm = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            if (dhVar.frR.frp || g.R(this.yqa.getContext(), auVar.getType())) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
            }
            if (!auVar.ciV() && auVar.aNe() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }
}
