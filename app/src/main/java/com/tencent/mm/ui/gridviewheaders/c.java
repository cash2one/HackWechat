package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean zeB;
    private DataSetObserver BD = new 1(this);
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;
    final b zeC;
    private GridHeadersGridView zeD;
    private final List<View> zeE = new ArrayList();
    private View[] zeF;

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        this.mContext = context;
        this.zeC = bVar;
        this.zeD = gridHeadersGridView;
        bVar.registerDataSetObserver(this.BD);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        this.mCount = 0;
        int cxl = this.zeC.cxl();
        if (cxl == 0) {
            return this.zeC.getCount();
        }
        while (i < cxl) {
            this.mCount += (this.zeC.Gz(i) + GB(i)) + this.mNumColumns;
            i++;
        }
        return this.mCount;
    }

    public final Object getItem(int i) {
        c GC = GC(i);
        if (GC.mPosition == -1 || GC.mPosition == -2) {
            return null;
        }
        return this.zeC.getItem(GC.mPosition);
    }

    public final long getItemId(int i) {
        c GC = GC(i);
        if (GC.mPosition == -2) {
            return -1;
        }
        if (GC.mPosition == -1) {
            return -2;
        }
        return this.zeC.getItemId(GC.mPosition);
    }

    public final int getItemViewType(int i) {
        c GC = GC(i);
        if (GC.mPosition == -2) {
            return 1;
        }
        if (GC.mPosition == -1) {
            return 0;
        }
        int itemViewType = this.zeC.getItemViewType(GC.mPosition);
        return itemViewType != -1 ? itemViewType + 2 : itemViewType;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View bVar;
        if (view instanceof d) {
            view = (d) view;
            childAt = view.getChildAt(0);
        } else {
            childAt = view;
            view = null;
        }
        c GC = GC(i);
        if (GC.mPosition == -2) {
            bVar = new b(this, this.mContext);
            bVar.zeI = this.zeD.getWidth();
            ((b) bVar).zeH = GC.zeJ;
            bVar.setTag(this.zeC.a(GC.zeJ, (View) bVar.getTag(), viewGroup));
        } else if (GC.mPosition == -1) {
            childAt = (a) childAt;
            if (childAt == null) {
                childAt = new a(this, this.mContext);
            }
            bVar = childAt;
        } else {
            bVar = this.zeC.getView(GC.mPosition, childAt, viewGroup);
        }
        if (view == null) {
            view = new d(this, this.mContext);
        }
        view.removeAllViews();
        view.addView(bVar);
        view.mPosition = i;
        view.mNumColumns = this.mNumColumns;
        this.zeF[i % this.mNumColumns] = view;
        if (i % this.mNumColumns == 0) {
            zeB = true;
            for (int i2 = 1; i2 < this.zeF.length; i2++) {
                this.zeF[i2] = getView(i + i2, null, viewGroup);
            }
            zeB = false;
        }
        view.zeF = this.zeF;
        if (!zeB && (i % this.mNumColumns == this.mNumColumns - 1 || i == getCount() - 1)) {
            GA(this.mNumColumns);
        }
        return view;
    }

    public final int getViewTypeCount() {
        return this.zeC.getViewTypeCount() + 2;
    }

    public final boolean hasStableIds() {
        return this.zeC.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.zeC.isEmpty();
    }

    public final boolean isEnabled(int i) {
        c GC = GC(i);
        if (GC.mPosition == -1 || GC.mPosition == -2) {
            return false;
        }
        return this.zeC.isEnabled(GC.mPosition);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.zeC.registerDataSetObserver(dataSetObserver);
    }

    public final void setNumColumns(int i) {
        this.mNumColumns = i;
        GA(i);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.zeC.unregisterDataSetObserver(dataSetObserver);
    }

    private void GA(int i) {
        this.zeF = new View[i];
        Arrays.fill(this.zeF, null);
    }

    private int GB(int i) {
        int Gz = this.zeC.Gz(i) % this.mNumColumns;
        return Gz == 0 ? 0 : this.mNumColumns - Gz;
    }

    protected final long om(int i) {
        return (long) GC(i).zeJ;
    }

    protected final View a(int i, View view, ViewGroup viewGroup) {
        if (this.zeC.cxl() == 0) {
            return null;
        }
        return this.zeC.a(GC(i).zeJ, view, viewGroup);
    }

    protected final c GC(int i) {
        int i2 = 0;
        int cxl = this.zeC.cxl();
        if (cxl != 0) {
            int i3 = i;
            while (i2 < cxl) {
                int Gz = this.zeC.Gz(i2);
                if (i3 == 0) {
                    return new c(this, -2, i2);
                }
                i3 -= this.mNumColumns;
                if (i3 < 0) {
                    return new c(this, -1, i2);
                }
                int i4 = i - this.mNumColumns;
                if (i3 < Gz) {
                    return new c(this, i4, i2);
                }
                int GB = GB(i2);
                i = i4 - GB;
                i2++;
                i3 -= Gz + GB;
            }
            return new c(this, -1, i2);
        } else if (i >= this.zeC.getCount()) {
            return new c(this, -1, 0);
        } else {
            return new c(this, i, 0);
        }
    }
}
