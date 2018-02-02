package com.tencent.mm.plugin.wxpaysdk;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpaysdk.a.a;

public class PluginWxPaySdk extends f implements a {
    public String name() {
        return "plugin-wxpaysdk";
    }

    public void installed() {
        alias(PluginWxPaySdk.class);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        gVar.DS();
    }

    public void execute(g gVar) {
        gVar.DS();
    }
}
