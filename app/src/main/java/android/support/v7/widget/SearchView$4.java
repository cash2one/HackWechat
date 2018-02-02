package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class SearchView$4 implements TextWatcher {
    final /* synthetic */ SearchView XE;

    SearchView$4(SearchView searchView) {
        this.XE = searchView;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchView.a(this.XE, charSequence);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
