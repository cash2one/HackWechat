package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.v;
import java.util.List;

class SnsSelectContactDialog$a extends BaseAdapter {
    private Context context;
    private List<String> hiv;
    final /* synthetic */ SnsSelectContactDialog rEU;
    private int rqr = 0;
    private int type;

    public SnsSelectContactDialog$a(SnsSelectContactDialog snsSelectContactDialog, Context context, int i) {
        this.rEU = snsSelectContactDialog;
        this.hiv = i;
        this.context = context;
        this.type = 0;
        refresh();
    }

    public final void refresh() {
        if (this.hiv == null) {
            this.rqr = 0;
        } else {
            this.rqr = this.hiv.size();
        }
        this.rqr++;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.rqr;
    }

    public final Object getItem(int i) {
        return this.hiv.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SnsSelectContactDialog$b snsSelectContactDialog$b;
        if (view == null) {
            View inflate;
            SnsSelectContactDialog$b snsSelectContactDialog$b2 = new SnsSelectContactDialog$b();
            if (this.type == 0) {
                inflate = View.inflate(this.context, g.qIg, null);
            } else {
                inflate = View.inflate(this.context, g.qHa, null);
            }
            snsSelectContactDialog$b2.lCl = (ImageView) inflate.findViewById(f.image);
            snsSelectContactDialog$b2.rEV = (ImageView) inflate.findViewById(f.qCA);
            inflate.setTag(snsSelectContactDialog$b2);
            view = inflate;
            snsSelectContactDialog$b = snsSelectContactDialog$b2;
        } else {
            snsSelectContactDialog$b = (SnsSelectContactDialog$b) view.getTag();
        }
        view.setVisibility(0);
        if (i == this.rqr - 1) {
            snsSelectContactDialog$b.lCl.setBackgroundDrawable(null);
            snsSelectContactDialog$b.lCl.setImageResource(e.qzI);
            snsSelectContactDialog$b.rEV.setVisibility(8);
            if (this.hiv.size() >= v.xmH) {
                view.setVisibility(8);
            }
        } else {
            snsSelectContactDialog$b.lCl.setBackgroundDrawable(null);
            snsSelectContactDialog$b.rEV.setVisibility(0);
            if (this.type == 0) {
                b.a(snsSelectContactDialog$b.lCl, (String) this.hiv.get(i));
            } else {
                snsSelectContactDialog$b.lCl.setImageBitmap(d.d((String) this.hiv.get(i), ae.bvD(), ae.bvD(), true));
            }
        }
        snsSelectContactDialog$b.lCl.setScaleType(ScaleType.CENTER_CROP);
        return view;
    }
}
