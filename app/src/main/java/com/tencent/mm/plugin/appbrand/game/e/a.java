package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public enum a {
    ;

    private a(String str) {
    }

    public final MBCanvasContentHolder kk(int i) {
        return b(new a(i, (byte) 0));
    }

    public final MBCanvasContentHolder aeQ() {
        return b(new b((byte) 0));
    }

    public static MBCanvasContentHolder kl(int i) {
        MBCanvasContentHolder mBCanvasContentHolder = null;
        if (aeR()) {
            try {
                mBCanvasContentHolder = new a(i, (byte) 0).aeS();
            } catch (Exception e) {
                x.e("MicroMsg.WAGameCanvasSnapshotHandler", "getScreenCanvas Direct [%s]", new Object[]{e});
            }
        } else {
            x.e("MicroMsg.WAGameCanvasSnapshotHandler", "CurrentThread is not glThread, please post to GLThread. [%s]", new Object[]{Thread.currentThread()});
        }
        return mBCanvasContentHolder;
    }

    private MBCanvasContentHolder b(Callable<MBCanvasContentHolder> callable) {
        h hVar = null;
        int i = 0;
        if (aeR()) {
            x.e("MicroMsg.WAGameCanvasSnapshotHandler", "Current thread is [%s], dismiss this task", new Object[]{Thread.currentThread()});
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        final FutureTask futureTask = new FutureTask(callable);
        com.tencent.mm.plugin.appbrand.game.h.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.game.h.a(this) {
            final /* synthetic */ a jak;

            public final void adR() {
                futureTask.run();
            }
        };
        h hVar2 = h.iXm;
        if (!hVar2.iXn.contains(anonymousClass1)) {
            hVar2.iXn.add(anonymousClass1);
        }
        try {
            MBCanvasContentHolder mBCanvasContentHolder = (MBCanvasContentHolder) futureTask.get(2500, TimeUnit.MILLISECONDS);
            if (mBCanvasContentHolder != null) {
                return mBCanvasContentHolder;
            }
            futureTask.cancel(true);
            x.w("MicroMsg.WAGameCanvasSnapshotHandler", "postGetCanvasShotSyncOnRenderThread bitmap is null");
            h.iXm.a(anonymousClass1);
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e, "hy: AppBrandGame getScreenShotsBitmap InterruptedException", new Object[0]);
            futureTask.cancel(true);
            return hVar;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e2, "hy: AppBrandGame getScreenShotsBitmap ExecutionException", new Object[0]);
            futureTask.cancel(true);
            return hVar;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e22, "hy: AppBrandGame getScreenShotsBitmap TimeoutException", new Object[0]);
            futureTask.cancel(true);
            return hVar;
        } finally {
            hVar = h.iXm;
            hVar.a(anonymousClass1);
        }
    }

    private static boolean aeR() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("GLThread");
    }
}
