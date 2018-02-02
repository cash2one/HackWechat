package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.am.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public class am$c extends b {
    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048188) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.dek, null);
        view.setTag(new d().dB(view));
        return view;
    }

    protected final boolean cvx() {
        return false;
    }

    public final void a(a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        aVar.ldK.setVisibility(0);
        aVar.ldK.setText(n.o(aVar2.getContext(), auVar.field_createTime));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI.a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, ChattingUI.a aVar, au auVar) {
        return false;
    }
}
