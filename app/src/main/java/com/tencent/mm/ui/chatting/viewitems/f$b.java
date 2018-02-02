package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;
import java.net.URLDecoder;

public class f$b extends b {
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 503316529) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddz);
        view.setTag(new f.a().q(view, true));
        return view;
    }

    protected final boolean r(a aVar) {
        return aVar.ypn;
    }

    private static String Zr(String str) {
        try {
            g.a fT = g.a.fT(str);
            if (fT != null) {
                return URLDecoder.decode(fT.content, "UTF-8");
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[]{e.getMessage()});
        }
        return "";
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String trim;
        CharSequence Zr;
        TextView textView;
        int type;
        this.yqa = aVar2;
        f.a aVar3 = (f.a) aVar;
        String str2 = auVar.field_content;
        String str3 = aVar2.ysf.talker;
        aVar3.yJZ.mG(true);
        if (aVar2.ypn && !aVar2.ywd.vnK) {
            int hO = ba.hO(str2);
            if (hO != -1) {
                trim = str2.substring(0, hO).trim();
                if (trim == null || trim.length() <= 0) {
                    trim = str3;
                }
                str3 = trim;
                trim = str2.substring(hO + 1).trim();
                Zr = Zr(trim);
                a(aVar3, aVar2, auVar, str3);
                a(aVar3, aVar2, str3, auVar);
                aVar3.yJY.setText(Zr);
                textView = aVar3.yJY;
                type = auVar.getType();
                str2 = aVar2.crz();
                if (type != 301989937) {
                    i.a(textView, str2);
                }
                textView.getText();
                aVar3.yJY.setTag(ar.b(auVar, aVar2.ypn, i));
                aVar3.yJY.setOnLongClickListener(s(aVar2));
                aVar3.yJY.yxa = aVar2.ysf.ysX;
            }
        }
        trim = str2;
        Zr = Zr(trim);
        a(aVar3, aVar2, auVar, str3);
        a(aVar3, aVar2, str3, auVar);
        aVar3.yJY.setText(Zr);
        textView = aVar3.yJY;
        type = auVar.getType();
        str2 = aVar2.crz();
        if (type != 301989937) {
            i.a(textView, str2);
        }
        textView.getText();
        aVar3.yJY.setTag(ar.b(auVar, aVar2.ypn, i));
        aVar3.yJY.setOnLongClickListener(s(aVar2));
        aVar3.yJY.yxa = aVar2.ysf.ysX;
    }

    protected final boolean cvx() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRH));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }
}
