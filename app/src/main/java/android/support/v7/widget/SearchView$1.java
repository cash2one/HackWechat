package android.support.v7.widget;

import android.support.v7.widget.SearchView.a;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

class SearchView$1 implements Runnable {
    final /* synthetic */ SearchView XE;

    SearchView$1(SearchView searchView) {
        this.XE = searchView;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.XE.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            a aVar = SearchView.Xv;
            View view = this.XE;
            if (aVar.XI != null) {
                try {
                    aVar.XI.invoke(inputMethodManager, new Object[]{Integer.valueOf(0), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
