package com.tencent.mm.plugin.profile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

class BizBindWxaInfoUI$a extends BaseAdapter {
    private LayoutInflater DF;
    private List<WxaEntryInfo> jNq = new LinkedList();

    public final /* synthetic */ Object getItem(int i) {
        return lC(i);
    }

    public BizBindWxaInfoUI$a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
        this.DF = layoutInflater;
        if (list != null) {
            this.jNq.addAll(list);
        }
    }

    public final int getCount() {
        return this.jNq.size();
    }

    private WxaEntryInfo lC(int i) {
        return (WxaEntryInfo) this.jNq.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(h.iwY, viewGroup, false);
            a aVar2 = new a((byte) 0);
            aVar2.jNs = (ImageView) view.findViewById(q$g.icon);
            aVar2.ihS = (TextView) view.findViewById(q$g.iwf);
            aVar2.iiS = view.findViewById(q$g.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        WxaEntryInfo lC = lC(i);
        b.Jj().a(aVar.jNs, lC.iconUrl, a.Ji(), f.hkr);
        aVar.ihS.setText(bh.ou(lC.title));
        if (this.jNq != null) {
            int i2;
            View view2 = aVar.iiS;
            if (this.jNq.size() - 1 == i) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view2.setVisibility(i2);
        }
        return view;
    }
}
