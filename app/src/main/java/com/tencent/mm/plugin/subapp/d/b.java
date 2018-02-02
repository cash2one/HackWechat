package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static void b(String str, int i, int i2, int i3, int i4) {
        x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        g.pQN.h(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i2 + i3), Integer.valueOf(i4), str);
    }
}
