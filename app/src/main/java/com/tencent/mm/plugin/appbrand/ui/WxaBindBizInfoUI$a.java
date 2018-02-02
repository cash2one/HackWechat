package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class WxaBindBizInfoUI$a extends RecyclerView$a {
    private LayoutInflater DF;
    private final List<WxaAttributes$WxaEntryInfo> jNq;
    boolean jNr = true;

    public WxaBindBizInfoUI$a(LayoutInflater layoutInflater) {
        this.DF = layoutInflater;
        this.jNq = new LinkedList();
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new b(this.DF.inflate(h.iwY, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        int i2 = 0;
        WxaAttributes$WxaEntryInfo lC = lC(i);
        if (lC == null) {
            x.i("MicroMsg.WxaBindBizInfoUI", "onBindViewHolder failed, getItem(%d) return null", new Object[]{Integer.valueOf(i)});
            return;
        }
        b bVar = (b) tVar;
        com.tencent.mm.modelappbrand.a.b.Jj().a(bVar.jNs, lC.iconUrl, a.Ji(), f.hkr);
        bVar.ihS.setText(bh.ou(lC.title));
        if (this.jNr) {
            View view = bVar.iiS;
            if (this.jNq.size() - 1 == i) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final int getItemCount() {
        return this.jNq.size();
    }

    public final WxaAttributes$WxaEntryInfo lC(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return (WxaAttributes$WxaEntryInfo) this.jNq.get(i);
    }

    protected final void ac(List<WxaAttributes$WxaEntryInfo> list) {
        if (list != null && !list.isEmpty()) {
            Collection linkedList = new LinkedList();
            for (WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo : list) {
                if (!contains(wxaAttributes$WxaEntryInfo.username)) {
                    linkedList.add(wxaAttributes$WxaEntryInfo);
                }
            }
            this.jNq.addAll(linkedList);
            U(this.jNq.size() - list.size(), list.size());
        }
    }

    private boolean contains(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo : this.jNq) {
            if (str.equals(wxaAttributes$WxaEntryInfo.username)) {
                return true;
            }
        }
        return false;
    }
}
