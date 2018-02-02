package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class SearchView$2 implements OnItemClickListener {
    final /* synthetic */ SearchView XE;

    SearchView$2(SearchView searchView) {
        this.XE = searchView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SearchView.a(this.XE, i);
    }
}
