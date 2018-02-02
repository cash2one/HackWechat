package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

class b$a extends d {
    final /* synthetic */ b thU;

    private b$a(b bVar) {
        this.thU = bVar;
    }

    public final void execute() {
        ar.CG().a(30, this.thU);
        List linkedList = new LinkedList();
        linkedList.add("gh_43f2581f6fd6");
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(1));
        ar.CG().a(new o(1, linkedList, linkedList2, "", ""), 0);
    }

    public final String getName() {
        return "AddContactTask";
    }
}
