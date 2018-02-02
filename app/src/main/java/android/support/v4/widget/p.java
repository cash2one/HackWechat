package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class p extends e {
    private int DD;
    private int DE;
    private LayoutInflater DF;

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.DF.inflate(this.DD, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.DF.inflate(this.DE, viewGroup, false);
    }
}
