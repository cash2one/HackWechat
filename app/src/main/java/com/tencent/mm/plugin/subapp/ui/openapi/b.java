package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    private List<f> qjF;
    boolean rXA = false;

    public b(Context context, List<f> list) {
        this.context = context;
        this.qjF = list;
    }

    public final void iR(boolean z) {
        this.rXA = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.i.das, null);
            cVar.jNs = (ImageView) view.findViewById(R.h.bKQ);
            cVar.rXW = (TextView) view.findViewById(R.h.bKP);
            cVar.inw = (TextView) view.findViewById(R.h.bKR);
            cVar.rXX = view.findViewById(R.h.bKS);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.rXX.setVisibility(4);
        if (qY(i)) {
            cVar.jNs.setVisibility(4);
            cVar.rXW.setVisibility(4);
            cVar.inw.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            cVar.jNs.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bv.a.getDensity(this.context));
            if (b == null) {
                cVar.jNs.setBackgroundResource(R.g.byX);
            } else {
                cVar.jNs.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.inw.setVisibility(0);
            cVar.inw.setText(g.a(this.context, fVar, null));
            if (this.rXA) {
                cVar.rXW.setVisibility(0);
            } else {
                cVar.rXW.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return aCQ() + aRF();
    }

    public final boolean qY(int i) {
        int size = this.qjF.size();
        return i >= size && i < size + aRF();
    }

    public final Object getItem(int i) {
        if (qY(i)) {
            return null;
        }
        return this.qjF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int aCQ() {
        return this.qjF.size();
    }

    private int aRF() {
        return (4 - (aCQ() % 4)) % 4;
    }

    public final void a(String str, l lVar) {
        notifyDataSetChanged();
    }
}
