package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.ui.a$c;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.ui.MMImageView;

public class a$b extends b {
    final /* synthetic */ a moZ;

    public a$b(a aVar) {
        this.moZ = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(a$c.moz, viewGroup, false);
        a$a com_tencent_mm_plugin_fav_ui_a_a_a = this.moZ.moV;
        com_tencent_mm_plugin_fav_ui_a_a_a.moW = (MMImageView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a$b.bLL);
        com_tencent_mm_plugin_fav_ui_a_a_a.iiq = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a$b.cSu);
        com_tencent_mm_plugin_fav_ui_a_a_a.moX = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a$b.moy);
        com_tencent_mm_plugin_fav_ui_a_a_a.moY = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a$b.cPu);
        com_tencent_mm_plugin_fav_ui_a_a_a.contentView = inflate.findViewById(com.tencent.mm.plugin.fav.ui.a$b.cJK);
        inflate.setTag(com_tencent_mm_plugin_fav_ui_a_a_a);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        a$a com_tencent_mm_plugin_fav_ui_a_a_a = (a$a) aVar;
        a aVar2 = (a) bVar;
        cm(com_tencent_mm_plugin_fav_ui_a_a_a.contentView);
        e.a(context, com_tencent_mm_plugin_fav_ui_a_a_a.moW, aVar2.jiK, aVar2.moS, aVar2.moT, com_tencent_mm_plugin_fav_ui_a_a_a.moW.getMeasuredWidth(), com_tencent_mm_plugin_fav_ui_a_a_a.moW.getMeasuredHeight());
        a.a(com_tencent_mm_plugin_fav_ui_a_a_a.iiq, com_tencent_mm_plugin_fav_ui_a_a_a.moX, this.moZ.moP, this.moZ.moQ);
        e.a(this.moZ.moR, com_tencent_mm_plugin_fav_ui_a_a_a.moY);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        a aVar = (a) bVar;
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 10;
        fvVar.fvq.fqk = aVar.iVU.mMf;
        fvVar.fvq.context = context;
        fvVar.fvq.fvB = new vg();
        if (this.moZ.pageType == 1) {
            fvVar.fvq.fvB.scene = 3;
        } else {
            fvVar.fvq.fvB.scene = 4;
        }
        fvVar.fvq.fvB.moj = 3;
        fvVar.fvq.fvB.index = this.moZ.mPz;
        com.tencent.mm.sdk.b.a.xef.m(fvVar);
        return true;
    }
}
