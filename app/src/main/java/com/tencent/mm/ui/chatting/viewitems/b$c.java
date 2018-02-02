package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.b;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.g;
import java.util.LinkedList;
import java.util.List;

public class b$c implements OnLongClickListener {
    private int kGp;
    private int kGq;
    private OnCreateContextMenuListener pBx;
    private a yID;
    private View yIE;
    final /* synthetic */ b yIF;
    private a yqa;

    static /* synthetic */ void a(b$c com_tencent_mm_ui_chatting_viewitems_b_c, ContextMenu contextMenu, au auVar, int i) {
        if (contextMenu != null && (contextMenu instanceof n) && auVar.getType() != 318767153) {
            if (auVar.getType() == 49) {
                g.a I = g.a.I(auVar.field_content, auVar.field_reserved);
                if (I == null || I.type == 6 || I.type == 38 || I.type == 39) {
                    return;
                }
            }
            Object obj = contextMenu.findItem(116) != null ? 1 : null;
            n nVar = (n) contextMenu;
            Object linkedList = new LinkedList();
            List<MenuItem> list = nVar.ycc;
            for (MenuItem menuItem : list) {
                o oVar;
                if (menuItem.getItemId() == 116) {
                    oVar = new o(d.CTRL_INDEX, i);
                    oVar.setTitle(com_tencent_mm_ui_chatting_viewitems_b_c.yqa.getMMString(R.l.dRZ));
                    linkedList.add(menuItem);
                    linkedList.add(oVar);
                } else if (obj == null && menuItem.getItemId() == 100) {
                    oVar = new o(d.CTRL_INDEX, i);
                    oVar.setTitle(com_tencent_mm_ui_chatting_viewitems_b_c.yqa.getMMString(R.l.dRZ));
                    linkedList.add(oVar);
                    linkedList.add(menuItem);
                } else {
                    linkedList.add(menuItem);
                }
            }
            list.clear();
            list.addAll(linkedList);
            linkedList.clear();
        }
    }

    public b$c(b bVar, a aVar) {
        this.yIF = bVar;
        this.yqa = aVar;
        if (aVar instanceof AppBrandServiceChattingUI.a) {
            this.pBx = new b(aVar);
        } else {
            this.pBx = new 1(this, bVar);
        }
        this.yID = new a(this);
    }

    public final boolean onLongClick(View view) {
        if (view.getTag(R.h.cSF) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(R.h.cSF);
            l(view, iArr[0], iArr[1]);
        } else if (!(this.kGp == 0 && this.kGq == 0) && this.yIE.equals(view)) {
            l(view, this.kGp, this.kGq);
        } else {
            view.setOnTouchListener(new 2(this));
        }
        return true;
    }

    private void l(View view, int i, int i2) {
        ar arVar = (ar) view.getTag();
        if (arVar != null) {
            this.yID.fnB = arVar.fEJ;
            new i(this.yqa.getContext()).a(view, this.pBx, this.yID, i, i2);
        }
    }
}
