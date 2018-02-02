package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements com.tencent.mm.sdk.e.j.a {
    private Context context;
    private List<f> qjF;
    boolean rXA = false;
    private int rXB = 0;

    public a(Context context, int i) {
        this.context = context;
        this.rXB = i;
        init();
    }

    private void init() {
        int i = 0;
        this.qjF = new ArrayList();
        Cursor rawQuery = an.bin().rawQuery("select * from AppInfo where status = " + this.rXB + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                f fVar = new f();
                fVar.b(rawQuery);
                if (g.m(this.context, fVar.field_appId)) {
                    this.qjF.add(fVar);
                }
                i++;
            }
            rawQuery.close();
        }
    }

    public final void iR(boolean z) {
        this.rXA = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, R.i.das, null);
            dVar.jNs = (ImageView) view.findViewById(R.h.bKQ);
            dVar.rXW = (TextView) view.findViewById(R.h.bKP);
            dVar.inw = (TextView) view.findViewById(R.h.bKR);
            dVar.rXX = view.findViewById(R.h.bKS);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.rXX.setVisibility(4);
        if (qY(i)) {
            dVar.jNs.setVisibility(4);
            dVar.rXW.setVisibility(4);
            dVar.inw.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            dVar.jNs.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bv.a.getDensity(this.context));
            if (b == null) {
                dVar.jNs.setBackgroundResource(R.g.byX);
            } else {
                dVar.jNs.setBackgroundDrawable(new BitmapDrawable(b));
            }
            dVar.inw.setVisibility(0);
            dVar.inw.setText(g.a(this.context, fVar, null));
            if (this.rXA) {
                dVar.rXW.setVisibility(0);
            } else {
                dVar.rXW.setVisibility(8);
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
        init();
        super.notifyDataSetChanged();
    }
}
