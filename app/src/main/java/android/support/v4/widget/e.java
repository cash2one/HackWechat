package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v4.widget.f.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class e extends BaseAdapter implements a, Filterable {
    public Cursor BA;
    protected int BB;
    protected a BC;
    protected DataSetObserver BD;
    protected f BE;
    protected FilterQueryProvider BF;
    protected boolean By;
    protected boolean Bz;
    public Context mContext;

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public final Cursor getCursor() {
        return this.BA;
    }

    public int getCount() {
        if (!this.By || this.BA == null) {
            return 0;
        }
        return this.BA.getCount();
    }

    public Object getItem(int i) {
        if (!this.By || this.BA == null) {
            return null;
        }
        this.BA.moveToPosition(i);
        return this.BA;
    }

    public long getItemId(int i) {
        if (this.By && this.BA != null && this.BA.moveToPosition(i)) {
            return this.BA.getLong(this.BB);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.By) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.BA.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.BA, viewGroup);
            }
            a(view, this.BA);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.By) {
            return null;
        }
        this.BA.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.BA, viewGroup);
        }
        a(view, this.BA);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.BA) {
            cursor2 = null;
        } else {
            cursor2 = this.BA;
            if (cursor2 != null) {
                if (this.BC != null) {
                    cursor2.unregisterContentObserver(this.BC);
                }
                if (this.BD != null) {
                    cursor2.unregisterDataSetObserver(this.BD);
                }
            }
            this.BA = cursor;
            if (cursor != null) {
                if (this.BC != null) {
                    cursor.registerContentObserver(this.BC);
                }
                if (this.BD != null) {
                    cursor.registerDataSetObserver(this.BD);
                }
                this.BB = cursor.getColumnIndexOrThrow("_id");
                this.By = true;
                notifyDataSetChanged();
            } else {
                this.BB = -1;
                this.By = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.BF != null) {
            return this.BF.runQuery(charSequence);
        }
        return this.BA;
    }

    public Filter getFilter() {
        if (this.BE == null) {
            this.BE = new f(this);
        }
        return this.BE;
    }

    protected final void onContentChanged() {
        if (this.Bz && this.BA != null && !this.BA.isClosed()) {
            this.By = this.BA.requery();
        }
    }
}
