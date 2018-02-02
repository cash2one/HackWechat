package com.tencent.mm.plugin.audio;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.audio.a.a;
import com.tencent.mm.z.p;

public class PluginVoice extends f implements a {
    public String name() {
        return "plugin-voice";
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            pin(new p(m.class));
        }
    }
}
