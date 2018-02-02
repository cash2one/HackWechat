package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.magicbrush.engine.c;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

class a$a implements Callable<MBCanvasContentHolder> {
    private int jal;

    public final /* synthetic */ Object call() {
        return aeS();
    }

    private a$a(int i) {
        this.jal = i;
    }

    public final MBCanvasContentHolder aeS() {
        x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: before");
        long currentTimeMillis = System.currentTimeMillis();
        MBCanvasContentHolder eg = c.eg(this.jal);
        x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: capture using : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return eg;
    }
}
