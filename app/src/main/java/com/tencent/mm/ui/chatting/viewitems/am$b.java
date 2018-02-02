package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.am.a;
import com.tencent.mm.ui.chatting.viewitems.am.d;

public class am$b extends a {
    public final /* bridge */ /* synthetic */ boolean aXj() {
        return super.aXj();
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048187) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddC);
        view.setTag(new d().dB(view));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        d dVar = (d) aVar;
        OnLongClickListener s = s(chattingUI$a);
        if (dVar != null) {
            dVar.yIy.setTag(new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0));
            dVar.yIy.setOnLongClickListener(s);
            dVar.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }
}
