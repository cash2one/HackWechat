package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();
    int mode;

    private class a {
        public ImageView ihQ;
        public TextView ihR;
        public TextView ihS;
        public TextView ihT;
        public TextView ihU;
        public TextView ihV;
        final /* synthetic */ b ihW;

        public a(b bVar, View view) {
            this.ihW = bVar;
            this.ihQ = (ImageView) view.findViewById(f.ued);
            this.ihR = (TextView) view.findViewById(f.uee);
            this.ihS = (TextView) view.findViewById(f.ueh);
            this.ihT = (TextView) view.findViewById(f.uef);
            this.ihU = (TextView) view.findViewById(f.uec);
            this.ihV = (TextView) view.findViewById(f.ueg);
        }
    }

    public b(Context context, int i) {
        this.context = context;
        this.mode = i;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final Object getItem(int i) {
        return this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fv(this.context).inflate(a$g.uAR, viewGroup, false);
            view.setTag(new a(this, view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.ihQ.setImageResource(a$h.uGj);
        com.tencent.mm.pluginsdk.ui.a.b.g(aVar.ihQ, kVar.vCX, a$h.uGj);
        aVar.ihS.setText(i.b(this.context, kVar.title, aVar.ihS.getTextSize()));
        CharSequence gu = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(kVar.vCX);
        if (bh.ov(gu) || gu.endsWith("@chatroom")) {
            gu = this.context.getString(a$i.uGP);
        }
        aVar.ihR.setText(i.b(this.context, gu, aVar.ihR.getTextSize()));
        if (this.mode == 2) {
            aVar.ihT.setText(kVar.vDj);
        } else {
            aVar.ihT.setText(kVar.vDg);
        }
        aVar.ihU.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.fLR) / 100.0f), this.context.getString(a$i.uHq)}));
        aVar.ihV.setVisibility(0);
        if (this.mode != 2) {
            switch (kVar.state) {
                case 1:
                    aVar.ihV.setText(a$i.uHc);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(c.uaE));
                    break;
                case 2:
                    aVar.ihV.setText(a$i.uHa);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(c.uaE));
                    break;
                case 3:
                    aVar.ihV.setText(a$i.uGY);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(c.btB));
                    break;
                case 4:
                    aVar.ihV.setText(a$i.uGZ);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(c.btB));
                    break;
                default:
                    aVar.ihV.setVisibility(4);
                    break;
            }
        }
        switch (kVar.state) {
            case 1:
                aVar.ihV.setText(a$i.uHd);
                aVar.ihV.setTextColor(this.context.getResources().getColor(c.uaE));
                break;
            case 2:
                aVar.ihV.setText(a$i.uHb);
                aVar.ihV.setTextColor(this.context.getResources().getColor(c.uaE));
                break;
            default:
                aVar.ihV.setVisibility(4);
                break;
        }
        return view;
    }

    public final void WP() {
        this.dataList.clear();
    }
}
