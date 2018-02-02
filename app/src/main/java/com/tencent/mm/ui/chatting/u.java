package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;

public final class u extends o<au> {
    private String hlJ;
    private String kEO;
    private String talker;
    private boolean ypn;
    public a yuy;

    public interface a {
        void Fx(int i);
    }

    private static class b {
        public ImageView iip;
        public TextView kBH;
        public TextView kBI;
        public TextView yuz;

        private b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (au) obj;
        if (obj == null) {
            obj = new au();
        }
        obj.b(cursor);
        return obj;
    }

    public u(Context context, au auVar, String str, String str2, boolean z) {
        super(context, auVar);
        this.talker = str;
        this.hlJ = str2;
        this.ypn = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.drq, null);
            bVar = new b();
            bVar.iip = (ImageView) view.findViewById(R.h.bLL);
            bVar.kBH = (TextView) view.findViewById(R.h.cAn);
            bVar.kBI = (TextView) view.findViewById(R.h.cTR);
            bVar.yuz = (TextView) view.findViewById(R.h.cxH);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        au auVar = (au) getItem(i);
        if (auVar != null) {
            if (this.ypn && auVar.field_isSend == 0) {
                String str = auVar.field_content;
                String hP = ba.hP(str);
                if (!t.ov(hP)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(bVar.iip, hP);
                    bVar.kBH.setText(i.b(this.context, r.gu(hP), bVar.kBH.getTextSize()));
                }
                bVar.kBI.setText(ay(auVar));
                bVar.yuz.setText(i.b(this.context, ba.hQ(str), bVar.yuz.getTextSize()));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(bVar.iip, ax(auVar));
                bVar.kBH.setText(i.b(this.context, r.gu(ax(auVar)), bVar.kBH.getTextSize()));
                bVar.kBI.setText(ay(auVar));
                bVar.yuz.setText(i.b(this.context, auVar.field_content, bVar.yuz.getTextSize()));
            }
        }
        return view;
    }

    public final void CN(String str) {
        this.kEO = str;
        if (!t.ov(this.kEO)) {
            aUn();
            Xy();
        }
    }

    private String ax(au auVar) {
        return auVar.field_isSend == 1 ? this.hlJ : this.talker;
    }

    public final void Xy() {
        ar.Hg();
        setCursor(c.Fa().dl(this.talker, this.kEO));
        if (!(this.yuy == null || t.ov(this.kEO))) {
            this.yuy.Fx(getCount());
        }
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    private CharSequence ay(au auVar) {
        return auVar.field_createTime == Long.MAX_VALUE ? "" : n.c(this.context, auVar.field_createTime, true);
    }
}
