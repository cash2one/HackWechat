package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.a.a;
import com.tencent.mm.ipcinvoker.a.c;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;

class e$1 extends a {
    final /* synthetic */ e gNi;

    e$1(e eVar) {
        this.gNi = eVar;
    }

    public final void a(d dVar) {
        super.a(dVar);
        dVar.a(new c());
        dVar.a(new a());
        dVar.a(new d());
    }

    public final void a(c cVar) {
        cVar.c("com.tencent.mm", MainProcessIPCService.class);
        cVar.c("com.tencent.mm:tools", ToolsProcessIPCService.class);
        cVar.c("com.tencent.mm:support", SupportProcessIPCService.class);
    }
}
