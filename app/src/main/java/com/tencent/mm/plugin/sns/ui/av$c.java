package com.tencent.mm.plugin.sns.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;

class av$c implements OnCreateContextMenuListener {
    private String fus;
    private aqr qTV;
    private bnp rsq;
    private m ryi;
    private View targetView;
    private String url;

    av$c() {
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Object tag = view.getTag();
        if (tag instanceof r) {
            r rVar = (r) tag;
            bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
            view.getContext();
            String str = com_tencent_mm_protocal_c_bnp.wQo.nfX;
            String str2 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
            str = av.Md(str);
            if (str != null && str.length() != 0) {
                this.url = str;
                this.fus = rVar.frH;
                this.targetView = view;
                this.qTV = com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0 ? (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0) : null;
                this.ryi = ae.bvv().Lm(this.fus);
                this.rsq = com_tencent_mm_protocal_c_bnp;
                if (com_tencent_mm_protocal_c_bnp.wQo.vYc != 10 && com_tencent_mm_protocal_c_bnp.wQo.vYc != 13) {
                    if (d.OQ("favorite")) {
                        switch (com_tencent_mm_protocal_c_bnp.wQo.vYc) {
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(j.eAd));
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(j.eAd));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(j.eAd));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(j.eAd));
                                break;
                        }
                    }
                    if (this.ryi != null && !this.ryi.field_userName.equals(ae.bvb())) {
                        contextMenu.add(0, 8, 0, view.getContext().getString(j.dVO));
                    }
                }
            }
        }
    }
}
