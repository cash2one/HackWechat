package com.tencent.mm.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class ServiceNotifySettingsUI$a extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mMode;
    private OnClickListener mOnClickListener;
    private String mSceneId;
    LinkedList<a> xMw = new LinkedList();
    LinkedList<a> xMx = new LinkedList();
    private c xMy;

    public final /* synthetic */ Object getItem(int i) {
        return Ec(i);
    }

    public ServiceNotifySettingsUI$a(Context context, LayoutInflater layoutInflater, final int i, String str) {
        this.mContext = context;
        this.mMode = i;
        this.mSceneId = str;
        this.mLayoutInflater = layoutInflater;
        this.mOnClickListener = new OnClickListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI$a xMA;

            public final void onClick(View view) {
                String str = (String) view.getTag();
                if (!TextUtils.isEmpty(str)) {
                    h.a(view.getContext(), i == 1 ? R.l.ezz : R.l.ezC, 0, i == 1 ? R.l.ezA : R.l.dFU, R.l.cancel, new 1(this, str), new 2(this), R.e.bsE);
                }
            }
        };
        a aVar = new a();
        aVar.hDY = true;
        aVar.hDU = com.tencent.mm.modelappbrand.a.a.Ji();
        this.xMy = aVar.PK();
    }

    public final int getCount() {
        return this.xMw.size();
    }

    private a Ec(int i) {
        return (a) this.xMw.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a Ec = Ec(i);
        if (view == null) {
            view = this.mLayoutInflater.inflate(R.i.drQ, viewGroup, false);
            b bVar2 = new b((byte) 0);
            bVar2.ihQ = (ImageView) view.findViewById(R.h.bLE);
            bVar2.ihS = (TextView) view.findViewById(R.h.cSh);
            bVar2.xMC = (TextView) view.findViewById(R.h.cHQ);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        o.PA().a(Ec.url, bVar.ihQ, this.xMy);
        bVar.ihS.setText(Ec.title);
        if (this.mMode == 1) {
            bVar.xMC.setText(this.mContext.getString(R.l.ezw));
        } else {
            bVar.xMC.setText(this.mContext.getString(R.l.ezx));
        }
        bVar.xMC.setTag(Ec.username);
        bVar.xMC.setOnClickListener(this.mOnClickListener);
        return view;
    }
}
