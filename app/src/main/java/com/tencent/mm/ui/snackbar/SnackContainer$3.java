package com.tencent.mm.ui.snackbar;

class SnackContainer$3 implements Runnable {
    final /* synthetic */ SnackContainer zfQ;

    SnackContainer$3(SnackContainer snackContainer) {
        this.zfQ = snackContainer;
    }

    public final void run() {
        if (this.zfQ.getVisibility() == 0) {
            this.zfQ.startAnimation(SnackContainer.c(this.zfQ));
        }
    }
}
