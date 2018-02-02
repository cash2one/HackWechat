package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.f.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements a, MMTagPanel.a {
    private Context context;
    private int muB = R.e.btv;
    private int muC = R.g.bCd;
    private Set<String> muD = new HashSet();

    public abstract void Am(String str);

    public abstract void An(String str);

    public /* synthetic */ Object getItem(int i) {
        return h.aIq().pI(i);
    }

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        h.aIq();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dhO, null);
            a aVar2 = new a();
            aVar2.kEY = (TextView) view.findViewById(R.h.cgS);
            aVar2.muE = (FavTagPanel) view.findViewById(R.h.chl);
            aVar2.muE.ydL = this;
            aVar2.muE.muC = this.muC;
            aVar2.muE.muB = this.muB;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.muE;
        Collection collection = this.muD;
        List<vo> pI = h.aIq().pI(i);
        if (pI == null || pI.isEmpty()) {
            boolean z;
            String str = "MicroMsg.FavTagPanel";
            String str2 = "setTagListByTagInfo,null == tags ?%B,";
            Object[] objArr = new Object[1];
            if (pI == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[]{Integer.valueOf(pI.size())});
            List linkedList = new LinkedList();
            for (vo voVar : pI) {
                linkedList.add(voVar.tCr);
            }
            favTagPanel.a(collection, linkedList);
        }
        return view;
    }

    public final void yK(String str) {
    }

    public final void yL(String str) {
    }

    public final void yM(String str) {
    }

    public final void aDz() {
    }

    public final void Ao(String str) {
        this.muD.add(str);
        notifyDataSetChanged();
    }

    public final void Ap(String str) {
        this.muD.remove(str);
        notifyDataSetChanged();
    }

    public final void aM(List<String> list) {
        this.muD.clear();
        if (list != null) {
            this.muD.addAll(list);
        }
    }

    public final void yJ(String str) {
        Ao(str);
        Am(str);
    }

    public final void yI(String str) {
        Ap(str);
        An(str);
    }

    public final void aIy() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void aIz() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void j(boolean z, int i) {
    }
}
