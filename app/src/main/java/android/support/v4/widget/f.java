package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class f extends Filter {
    a BH;

    f(a aVar) {
        this.BH = aVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.BH.convertToString((Cursor) obj);
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.BH.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.BH.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.BH.changeCursor((Cursor) filterResults.values);
        }
    }
}
