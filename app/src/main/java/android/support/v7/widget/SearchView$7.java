package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class SearchView$7 implements OnFocusChangeListener {
    final /* synthetic */ SearchView XE;

    SearchView$7(SearchView searchView) {
        this.XE = searchView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (SearchView.c(this.XE) != null) {
            SearchView.c(this.XE).onFocusChange(this.XE, z);
        }
    }
}
