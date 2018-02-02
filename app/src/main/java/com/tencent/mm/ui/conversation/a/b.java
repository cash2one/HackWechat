package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.j.a.a;
import com.tencent.mm.ui.o;
import java.util.ArrayList;

public final class b extends o<c> {
    private ArrayList<c> xRC = new ArrayList();
    a zar = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        return Gu(i);
    }

    public b(Context context) {
        super(context, null);
        Xz();
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        this.xRC.clear();
        if (this.zar != null) {
            this.xRC.add(new c(this.zar));
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.xRC.size();
    }

    public final c Gu(int i) {
        return (c) this.xRC.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        c cVar = (c) this.xRC.get(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.dad, null);
            d dVar2 = new d();
            dVar2.zat = view;
            dVar2.zau = (Button) view.findViewById(R.h.bIY);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            return null;
        }
        return view;
    }
}
