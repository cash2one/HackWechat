package org.xwalk.core;

import org.xwalk.core.XWalkLibraryLoader.ActivateListener;
import org.xwalk.core.XWalkLibraryLoader.DecompressListener;

class XWalkInitializer$XWalkLibraryListener implements ActivateListener, DecompressListener {
    final /* synthetic */ XWalkInitializer this$0;

    private XWalkInitializer$XWalkLibraryListener(XWalkInitializer xWalkInitializer) {
        this.this$0 = xWalkInitializer;
    }

    public void onDecompressStarted() {
    }

    public void onDecompressCancelled() {
        XWalkInitializer.access$000(this.this$0).onXWalkInitCancelled();
    }

    public void onDecompressCompleted() {
    }

    public void onActivateStarted() {
    }

    public void onActivateFailed() {
        XWalkInitializer.access$000(this.this$0).onXWalkInitFailed();
    }

    public void onActivateCompleted() {
        XWalkInitializer.access$102(this.this$0, true);
        XWalkLibraryLoader.finishInit(XWalkInitializer.access$200(this.this$0));
        XWalkInitializer.access$000(this.this$0).onXWalkInitCompleted();
    }
}
