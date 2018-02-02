package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.u.c.g;

public class a {
    private static volatile g iTZ;
    private static volatile g iUa;

    public static g jW(int i) {
        if (i == 1) {
            return acY();
        }
        return acX();
    }

    private static g acX() {
        if (iTZ == null) {
            synchronized (a.class) {
                if (iTZ == null) {
                    g gVar = new g();
                    gVar.a(new b(HardCoderJNI.SCENE_QUIT_CHATTING));
                    gVar.a(new c(303));
                    gVar.a(new d(308));
                    gVar.a(new f());
                    gVar.a(new g());
                    iTZ = gVar;
                }
            }
        }
        return iTZ;
    }

    private static g acY() {
        if (iUa == null) {
            synchronized (a.class) {
                if (iUa == null) {
                    g gVar = new g();
                    gVar.a(new b(262));
                    gVar.a(new c(263));
                    gVar.a(new d(268));
                    gVar.a(new f());
                    gVar.a(new g());
                    gVar.a(new e((byte) 0));
                    iUa = gVar;
                }
            }
        }
        return iUa;
    }
}
