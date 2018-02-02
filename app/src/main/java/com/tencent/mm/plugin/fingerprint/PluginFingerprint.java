package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fingerprint.a.a;

public class PluginFingerprint extends f implements a {
    public String name() {
        return "plugin-fingerprint";
    }

    public void installed() {
        alias(PluginFingerprint.class);
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
