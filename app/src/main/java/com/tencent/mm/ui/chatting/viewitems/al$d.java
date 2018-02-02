package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.al.a;
import com.tencent.mm.ui.chatting.viewitems.al.i;

public class al$d extends a {
    public final /* bridge */ /* synthetic */ boolean aXj() {
        return super.aXj();
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 53) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddD);
        view.setTag(new i().dB(view));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        i.a((i) aVar, auVar, true, i, aVar2, A(aVar2), s(aVar2));
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
