package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SelectMemberChattingRecordUI$a extends o<au> {
    int hKb = -1;
    String jRw;
    final /* synthetic */ SelectMemberChattingRecordUI ldF;
    String ldG;
    int ldH = -1;
    private q ldI;
    Context mContext;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (au) obj;
        if (obj == null) {
            obj = new au();
        }
        obj.b(cursor);
        return obj;
    }

    public SelectMemberChattingRecordUI$a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, Context context, String str, String str2, int i) {
        this.ldF = selectMemberChattingRecordUI;
        super(context, new au());
        this.mContext = context;
        this.hKb = i;
        this.jRw = str;
        this.ldG = str2;
        ar.Hg();
        this.ldI = c.Fh().hE(SelectMemberChattingRecordUI.b(selectMemberChattingRecordUI));
    }

    public final void Xy() {
        if (this.ldH < 0 || this.ldH > this.hKb) {
            this.ldH = this.hKb - 16;
        }
        if (!bh.ov(SelectMemberChattingRecordUI.c(this.ldF)) && com.tencent.mm.z.q.gr(SelectMemberChattingRecordUI.c(this.ldF))) {
            ar.Hg();
            setCursor(c.Fa().bE(this.jRw, this.hKb - this.ldH));
        } else if (!com.tencent.mm.z.q.gr(SelectMemberChattingRecordUI.c(this.ldF))) {
            ar.Hg();
            setCursor(c.Fa().B(this.jRw, this.ldG, this.hKb - this.ldH));
        }
    }

    protected final void Xz() {
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SelectMemberChattingRecordUI$b selectMemberChattingRecordUI$b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dnj, null, false);
            selectMemberChattingRecordUI$b = new SelectMemberChattingRecordUI$b();
            selectMemberChattingRecordUI$b.iip = (ImageView) view.findViewById(R.h.bLL);
            selectMemberChattingRecordUI$b.kBH = (TextView) view.findViewById(R.h.cAn);
            selectMemberChattingRecordUI$b.ldJ = (TextView) view.findViewById(R.h.cxH);
            selectMemberChattingRecordUI$b.ldK = (TextView) view.findViewById(R.h.cTR);
            view.setTag(selectMemberChattingRecordUI$b);
        }
        au auVar = (au) getItem(i);
        selectMemberChattingRecordUI$b = (SelectMemberChattingRecordUI$b) view.getTag();
        b.a(selectMemberChattingRecordUI$b.iip, this.ldG);
        String str = this.ldG;
        ar.Hg();
        af WO = c.EY().WO(str);
        CharSequence a = !bh.ov(WO.field_conRemark) ? WO.field_conRemark : SelectMemberChattingRecordUI.a(this.ldI, WO.field_username);
        if (bh.ov(a)) {
            a = WO.AP();
        }
        if (!a.fZ(WO.field_type)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(WO.field_username);
            if (!(EZ == null || bh.ov(EZ.field_conRemark))) {
                a = EZ.field_conRemark;
            }
        }
        a(a, selectMemberChattingRecordUI$b.kBH);
        a(SelectMemberChattingRecordUI.a(ac.getContext(), auVar.getType(), auVar.field_content, this.ldG, auVar.field_isSend).trim(), selectMemberChattingRecordUI$b.ldJ);
        a(n.c(this.ldF, auVar.field_createTime, true), selectMemberChattingRecordUI$b.ldK);
        return view;
    }

    private static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(i.a(textView.getContext(), charSequence));
        textView.setVisibility(0);
        return true;
    }
}
