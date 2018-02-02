package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.z.b;
import com.tencent.mm.z.ar;

public class z$a extends b {
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == 35) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.ddx, null);
        b bVar = new b();
        bVar.ldK = (TextView) view.findViewById(R.h.bVf);
        bVar.qhg = (TextView) view.findViewById(R.h.bVk);
        bVar.yKh = (ImageView) view.findViewById(R.h.bUB);
        bVar.yMI = (TextView) view.findViewById(R.h.bVh);
        bVar.yMh = (TextView) view.findViewById(R.h.bTH);
        bVar.yIy = view.findViewById(R.h.bTD);
        view.setTag(bVar);
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        b bVar = (b) aVar;
        ar.Hg();
        c EI = com.tencent.mm.z.c.Fa().EI(auVar.field_content);
        bVar.yMI.setText(EI.title);
        bVar.yMh.setText(EI.content);
        a(bVar, EI.hMK);
        bVar.yKh.setVisibility(EI.muO ? 0 : 8);
        bVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        bVar.yIy.setOnClickListener(t(aVar2));
        bVar.yIy.setOnLongClickListener(s(aVar2));
        bVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
    }

    protected final boolean cvx() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        ar.Hg();
        c EI = com.tencent.mm.z.c.Fa().EI(arVar.fEJ.field_content);
        if (t.ou(EI.pod).length() > 0) {
            d.b(aVar.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", arVar.fEJ.field_msgId));
        } else if (t.ou(EI.xzr).length() > 0) {
            d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(EI.xzr)));
        }
        return true;
    }
}
