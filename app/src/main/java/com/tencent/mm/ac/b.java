package com.tencent.mm.ac;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.g.a.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static String Jx() {
        return new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ab.UZ(System.nanoTime())).toString();
    }

    public static boolean a(String str, a aVar) {
        x.i("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[]{str});
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fnD.action = 1;
        sVar.fnD.fnF = str;
        sVar.fnD.fnH = aVar;
        a.xef.m(sVar);
        return sVar.fnE.fnI;
    }

    public static boolean iK(String str) {
        x.i("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[]{str});
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fnD.action = 2;
        sVar.fnD.fnF = str;
        a.xef.m(sVar);
        return sVar.fnE.fnI;
    }

    public static boolean iL(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fnD.action = 7;
        sVar.fnD.fnF = str;
        a.xef.m(sVar);
        return sVar.fnE.fnI;
    }

    public static boolean iM(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fnD.action = 8;
        sVar.fnD.fnF = str;
        a.xef.m(sVar);
        return sVar.fnE.fnI;
    }

    public static a iN(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fnD.action = 16;
        sVar.fnD.fnF = str;
        a.xef.m(sVar);
        return sVar.fnD.fnH;
    }
}
