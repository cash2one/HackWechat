package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public final class ac extends b {
    private ad yNf = new ad();
    private aa yNg = new aa();
    private ae yNh = new ae();

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == 10000 || i == 10002 || i == 570425393 || i == 64) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.ddM, null);
        b bVar = new b(this);
        bVar.mUL = view;
        bVar.ldK = (TextView) view.findViewById(R.h.bVf);
        bVar.yMh = (TextView) view.findViewById(R.h.bTH);
        view.setTag(bVar);
        return view;
    }

    public final void a(a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        a aVar3;
        if (auVar.getType() == 10002) {
            aVar3 = this.yNg;
        } else if (auVar.getType() == 570425393) {
            aVar3 = this.yNh;
        } else {
            aVar3 = this.yNf;
        }
        aVar3.b(aVar, i, aVar2, auVar);
    }

    protected final boolean cvx() {
        return false;
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
