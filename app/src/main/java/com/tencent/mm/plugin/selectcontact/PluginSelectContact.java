package com.tencent.mm.plugin.selectcontact;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.selectcontact.a.a;

public class PluginSelectContact extends f implements a {
    public String name() {
        return "plugin-selectcontact";
    }

    public void installed() {
        alias(PluginSelectContact.class);
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
