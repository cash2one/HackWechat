package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class n extends BaseAdapter {
    private Context mContext;
    ArrayList<x> mData = null;
    x sWD = null;

    public final /* synthetic */ Object getItem(int i) {
        return zt(i);
    }

    public n(Context context, ArrayList<x> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    public final x zt(int i) {
        if (this.mData == null || getCount() <= i) {
            return null;
        }
        return (x) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, g.uFX, null);
            a aVar2 = new a(this, (byte) 0);
            aVar2.jpW = (TextView) view.findViewById(f.title);
            aVar2.sWE = (ImageView) view.findViewById(f.uwt);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x zt = zt(i);
        if (zt != null) {
            aVar.jpW.setText(zt.field_wallet_name);
            if (zt.field_wallet_selected == 1) {
                this.sWD = zt;
                aVar.sWE.setImageResource(h.dAr);
            } else {
                aVar.sWE.setImageResource(h.dAq);
            }
        }
        return view;
    }
}
