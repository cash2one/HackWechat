package android.support.v7.widget;

class SearchView$6 implements Runnable {
    final /* synthetic */ SearchView XE;

    SearchView$6(SearchView searchView) {
        this.XE = searchView;
    }

    public final void run() {
        if (SearchView.b(this.XE) != null && (SearchView.b(this.XE) instanceof ak)) {
            SearchView.b(this.XE).changeCursor(null);
        }
    }
}
