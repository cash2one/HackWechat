package android.support.v4.widget;

class ContentLoadingProgressBar$1 implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar Bx;

    ContentLoadingProgressBar$1(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.Bx = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar.a(this.Bx);
        ContentLoadingProgressBar.a(this.Bx, -1);
        this.Bx.setVisibility(8);
    }
}
