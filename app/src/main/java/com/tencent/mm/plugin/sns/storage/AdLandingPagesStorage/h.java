package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class h {
    private int bgColor;
    private Context context;
    private int kDP;
    private int kDQ;
    private ViewGroup psl;
    private LinkedHashMap<String, i> rmO;
    private LayoutInflater rmP;
    private List<s> rox;

    public h(List<s> list, Context context, int i, ViewGroup viewGroup) {
        this.rox = list;
        this.context = context;
        this.bgColor = i;
        this.psl = viewGroup;
    }

    public final void bP(List<s> list) {
        if (list != null && !list.equals(this.rox)) {
            this.rox = list;
            layout();
        }
    }

    public final void layout() {
        if (this.rox != null && !this.rox.isEmpty()) {
            if (this.rmO == null) {
                this.rmO = new LinkedHashMap();
            }
            if (this.rmP == null) {
                this.rmP = (LayoutInflater) this.context.getSystemService("layout_inflater");
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                this.kDP = windowManager.getDefaultDisplay().getWidth();
                this.kDQ = windowManager.getDefaultDisplay().getHeight();
            }
            for (int i = 0; i < this.rox.size(); i++) {
                s sVar = (s) this.rox.get(i);
                i iVar = (i) this.rmO.get(sVar.rgK);
                if (iVar != null) {
                    iVar.a(sVar);
                } else {
                    iVar = am.a(this.context, sVar, this.psl, this.bgColor);
                    if (iVar != null) {
                        this.rmO.put(sVar.rgK, iVar);
                    }
                }
                try {
                    if (this.psl != iVar.getView().getParent()) {
                        if (this.psl.getChildCount() > i) {
                            this.psl.addView(iVar.getView(), i);
                        } else {
                            this.psl.addView(iVar.getView());
                        }
                    }
                } catch (Throwable e) {
                    x.e("CompRenderer", "component may have same id %s,%s", new Object[]{sVar.rgK, bh.i(e)});
                }
            }
        }
    }

    public final Collection<i> bxH() {
        return this.rmO == null ? Collections.EMPTY_LIST : this.rmO.values();
    }
}
