package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.viewitems.b.c;
import com.tencent.mm.z.ar;

class b$c$1 implements OnCreateContextMenuListener {
    final /* synthetic */ b yIG;
    final /* synthetic */ c yIH;

    b$c$1(c cVar, b bVar) {
        this.yIH = cVar;
        this.yIG = bVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ar arVar = (ar) view.getTag();
        if (arVar != null) {
            int i = arVar.position;
            au auVar = arVar.fEJ;
            if (auVar == null) {
                x.e("MicroMsg.ChattingItem", "msg is null!");
                return;
            }
            boolean a = this.yIH.yIF.a(contextMenu, view, auVar);
            if (com.tencent.mm.storage.x.Wz(c.a(this.yIH).crz()) || com.tencent.mm.storage.x.Wx(c.a(this.yIH).crz())) {
                x.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                contextMenu.removeItem(116);
            }
            if (a) {
                if (c.a(this.yIH).csV()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
                }
                if ((this.yIH.yIF.cvz() && c.a(this.yIH).csV()) || c.a(this.yIH).fAh.cia()) {
                    contextMenu.add(i, 122, 0, c.a(this.yIH).getMMString(R.l.dRK));
                }
                if (contextMenu.findItem(123) != null) {
                    contextMenu.removeItem(100);
                }
                c.a(this.yIH, contextMenu, auVar, i);
                return;
            }
            if (auVar.cje()) {
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                    v vVar = c.a(this.yIH).yvT;
                    contextMenu.add(i, 100, 0, vVar.fhr.csq().getMMString(R.l.dRG));
                    e eVar = null;
                    if (auVar.field_msgId > 0) {
                        eVar = o.Pw().bi(auVar.field_msgId);
                    }
                    if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                        eVar = o.Pw().bh(auVar.field_msgSvrId);
                    }
                    if (auVar.field_isSend == 1 || (eVar != null && auVar.field_isSend == 0 && eVar.offset >= eVar.hlp && eVar.hlp != 0)) {
                        contextMenu.add(i, 110, 0, vVar.fhr.csq().getMMString(R.l.eEC));
                    }
                    String m = eVar == null ? "" : o.Pw().m(eVar.hzQ, "", "");
                    if (eVar != null && com.tencent.mm.a.e.bO(m)) {
                        contextMenu.add(i, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 0, vVar.fhr.csq().getMMString(R.l.dQK));
                    }
                    if (auVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, c.a(this.yIH).getMMString(R.l.dRP));
                        f.c(o.Pw().n(auVar));
                    }
                    if (contextMenu.findItem(123) != null) {
                        contextMenu.removeItem(100);
                    }
                    c.a(this.yIH, contextMenu, auVar, i);
                }
            }
            if (auVar.cja()) {
                contextMenu.add(i, 100, 0, c.a(this.yIH).getMMString(R.l.dRH));
            }
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, c.a(this.yIH).getMMString(R.l.dRP));
                f.c(o.Pw().n(auVar));
            }
            if (contextMenu.findItem(123) != null) {
                contextMenu.removeItem(100);
            }
            c.a(this.yIH, contextMenu, auVar, i);
        }
    }
}
