package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AppBrandOpenWeRunSettingUI$1 implements OnClickListener {
    final /* synthetic */ AppBrandOpenWeRunSettingUI jLg;

    AppBrandOpenWeRunSettingUI$1(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        this.jLg = appBrandOpenWeRunSettingUI;
    }

    public final void onClick(View view) {
        d.pY(13);
        Object obj = this.jLg;
        obj.getString(j.dGO);
        obj.jLf = h.a(obj, ((a) g.h(a.class)).bL(obj), true, null);
        obj.jLf.show();
        g.Di().gPJ.a(30, obj);
        List linkedList = new LinkedList();
        linkedList.add("gh_43f2581f6fd6");
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(1));
        g.Di().gPJ.a(new o(1, linkedList, linkedList2, "", ""), 0);
    }
}
