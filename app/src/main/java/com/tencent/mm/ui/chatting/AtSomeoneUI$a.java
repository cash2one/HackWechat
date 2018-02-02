package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.chatting.AtSomeoneUI.b;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

class AtSomeoneUI$a extends o<x> {
    private q kZS;
    private List<String> kiU;
    String ldh;
    private String[] ynf;
    private Bitmap yng;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ar.Hg();
        Object WJ = c.EY().WJ(x.k(cursor));
        if (WJ != null) {
            return WJ;
        }
        x xVar = new x();
        xVar.b(cursor);
        ar.Hg();
        c.EY().O(xVar);
        return xVar;
    }

    protected final /* bridge */ /* synthetic */ Object aRG() {
        return null;
    }

    public AtSomeoneUI$a(Context context, x xVar, q qVar, String[] strArr, List<String> list) {
        super(context, xVar);
        this.kZS = qVar;
        this.ynf = strArr;
        this.kiU = list;
        this.yng = d.u(context.getResources().getDrawable(R.k.dvN));
    }

    protected final int aRF() {
        return AtSomeoneUI.access$100() ? 1 : 0;
    }

    public final boolean qY(int i) {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (view == null) {
            view = View.inflate(this.context, R.i.daB, null);
            b bVar2 = new b((byte) 0);
            bVar2.ldx = (MaskLayout) view.findViewById(R.h.bLk);
            bVar2.kEZ = (TextView) view.findViewById(R.h.bLl);
            bVar2.ynh = (ImageView) view.findViewById(R.h.content);
            view.setTag(bVar2);
            bVar = bVar2;
            view2 = view;
        } else {
            bVar = (b) view.getTag();
            view2 = view;
        }
        if (i == 0 && AtSomeoneUI.access$100()) {
            bVar.ynh.setImageBitmap(this.yng);
            bVar.kEZ.setText(this.context.getResources().getString(R.l.dHk, new Object[]{"@"}));
            return view2;
        }
        CharSequence a;
        x xVar = (x) getItem(i - (AtSomeoneUI.access$100() ? 1 : 0));
        bVar.kEZ.setTextColor(a.Z(this.context, !s.hn(xVar.field_username) ? R.e.bth : R.e.bti));
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) bVar.ldx.view, xVar.field_username);
        if (xVar.field_verifyFlag == 0) {
            bVar.ldx.cpQ();
        } else if (ak.a.hfN != null) {
            String gP = ak.a.hfN.gP(xVar.field_verifyFlag);
            if (gP != null) {
                bVar.ldx.d(m.kf(gP), MaskLayout.a.yfa);
            } else {
                bVar.ldx.cpQ();
            }
        } else {
            bVar.ldx.cpQ();
        }
        if (t.ov(xVar.field_conRemark)) {
            a = AtSomeoneUI.a(this.kZS, xVar.field_username);
        } else {
            a = xVar.field_conRemark;
        }
        if (t.ov(a)) {
            a = xVar.AP();
        }
        bVar.kEZ.setText(i.b(this.context, a, bVar.kEZ.getTextSize()));
        return view2;
    }

    public final void Xy() {
        List list;
        ar.Hg();
        com.tencent.mm.storage.ar EY = c.EY();
        String[] strArr = this.ynf;
        String str = "@all.chatroom";
        String str2 = this.ldh;
        CharSequence charSequence = this.ldh;
        if (this.kZS == null || charSequence == null || this.ynf == null) {
            list = null;
        } else {
            list = new ArrayList();
            for (String str3 : this.ynf) {
                String gu = this.kZS.gu(str3);
                if (gu != null && gu.contains(charSequence)) {
                    list.add(str3);
                }
            }
        }
        setCursor(EY.a(strArr, str, str2, list, this.kiU));
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }
}
