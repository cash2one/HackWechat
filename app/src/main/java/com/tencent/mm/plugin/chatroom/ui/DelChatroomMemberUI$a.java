package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.ui.DelChatroomMemberUI.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class DelChatroomMemberUI$a extends BaseAdapter {
    final /* synthetic */ DelChatroomMemberUI laP;
    List<x> laQ = new LinkedList();

    DelChatroomMemberUI$a(DelChatroomMemberUI delChatroomMemberUI) {
        this.laP = delChatroomMemberUI;
    }

    public final void as(List<String> list) {
        Object obj = null;
        for (String str : list) {
            Object obj2;
            for (Object obj3 : this.laQ) {
                if (obj3.field_username.equals(str)) {
                    break;
                }
            }
            Object obj32 = null;
            if (obj32 != null) {
                obj2 = 1;
                this.laQ.remove(obj32);
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.laQ.size();
    }

    public final Object getItem(int i) {
        return this.laQ.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.laP, R.i.dcQ, null);
            bVar = new b(this.laP);
            bVar.iip = (ImageView) view.findViewById(R.h.bSG);
            bVar.kBH = (TextView) view.findViewById(R.h.bSH);
            bVar.laU = (TextView) view.findViewById(R.h.bSF);
            bVar.laU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DelChatroomMemberUI$a laR;

                {
                    this.laR = r1;
                }

                public final void onClick(View view) {
                    x xVar = (x) this.laR.getItem(((Integer) view.getTag()).intValue());
                    h.a(this.laR.laP, this.laR.laP.getString(R.l.eFc, new Object[]{this.laR.c(xVar)}), null, this.laR.laP.getString(R.l.eFj), this.laR.laP.getString(R.l.dEn), true, new 1(this, xVar), new 2(this));
                }
            });
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.laU.setTag(Integer.valueOf(i));
        x xVar = (x) getItem(i);
        CharSequence c = c(xVar);
        bVar.kBH.setText(c);
        i.b(this.laP, c, bVar.kBH.getTextSize());
        a.b.a(bVar.iip, xVar.field_username);
        return view;
    }

    public final String c(x xVar) {
        String b;
        if (bh.ov(xVar.field_conRemark)) {
            b = DelChatroomMemberUI.b(this.laP, xVar.field_username);
        } else {
            b = xVar.field_conRemark;
        }
        if (bh.ov(b)) {
            b = xVar.field_conRemark;
        }
        if (bh.ov(b)) {
            return xVar.AP();
        }
        return b;
    }
}
