package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;

public final class a {
    private static HashMap<Integer, d> mXJ = new HashMap();

    public static void a(d dVar) {
        mXJ.put(Integer.valueOf(dVar.hashCode()), dVar);
    }

    public static void b(d dVar) {
        mXJ.remove(Integer.valueOf(dVar.hashCode()));
    }

    public static d qF(int i) {
        return (d) mXJ.get(Integer.valueOf(i));
    }

    public static void cleanup() {
        mXJ.clear();
    }
}
