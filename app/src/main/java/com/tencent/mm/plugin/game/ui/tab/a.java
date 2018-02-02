package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.sdk.platformtools.bh;

public final class a extends BaseAdapter {
    private Context mContext;
    private GameTabData nwI;
    private String nwJ;

    public final /* synthetic */ Object getItem(int i) {
        return (TabItem) this.nwI.aQW().get(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final void a(GameTabData gameTabData, String str) {
        this.nwI = gameTabData;
        this.nwJ = str;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nwI == null ? 0 : this.nwI.aQW().size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dlo, viewGroup, false);
        a aVar = new a(this, inflate);
        TabItem tabItem = (TabItem) this.nwI.aQW().get(i);
        if (tabItem != null) {
            aVar.jpW.setText(tabItem.title);
            String str;
            com.tencent.mm.aq.a.a.c.a aVar2;
            if (bh.ou(this.nwJ).equalsIgnoreCase(tabItem.nei)) {
                if (!bh.ov(tabItem.neo)) {
                    str = as.neu + g.s(tabItem.neo.getBytes());
                    aVar2 = new com.tencent.mm.aq.a.a.c.a();
                    aVar2.hDA = true;
                    aVar2.hDC = str;
                    com.tencent.mm.aq.a.a.PH().a(tabItem.neo, aVar.jMv, aVar2.PK());
                }
            } else if (!bh.ov(tabItem.nen)) {
                str = as.neu + g.s(tabItem.nen.getBytes());
                aVar2 = new com.tencent.mm.aq.a.a.c.a();
                aVar2.hDA = true;
                aVar2.hDC = str;
                com.tencent.mm.aq.a.a.PH().a(tabItem.nen, aVar.jMv, aVar2.PK());
            }
        }
        inflate.setTag(tabItem);
        return inflate;
    }
}
