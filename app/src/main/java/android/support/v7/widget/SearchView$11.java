package android.support.v7.widget;

import android.support.v4.view.g;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$11 implements OnKeyListener {
    final /* synthetic */ SearchView XE;

    SearchView$11(SearchView searchView) {
        this.XE = searchView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (SearchView.o(this.XE) == null) {
            return false;
        }
        if (SearchView.m(this.XE).isPopupShowing() && SearchView.m(this.XE).getListSelection() != -1) {
            return SearchView.a(this.XE, i, keyEvent);
        }
        if (SearchView$SearchAutoComplete.a(SearchView.m(this.XE)) || !g.a(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView.a(this.XE, SearchView.m(this.XE).getText().toString());
        return true;
    }
}
