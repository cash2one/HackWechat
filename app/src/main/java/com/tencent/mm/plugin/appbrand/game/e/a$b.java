package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.magicbrush.engine.c;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

class a$b implements Callable<MBCanvasContentHolder> {
    private a$b() {
    }

    public final /* synthetic */ Object call() {
        x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: before");
        long currentTimeMillis = System.currentTimeMillis();
        MBCanvasContentHolder sC = c.sC();
        x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: capture using : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return sC;
    }
}
