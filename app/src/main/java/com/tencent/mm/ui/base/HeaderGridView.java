package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HeaderGridView extends GridView {
    public ArrayList<a> xXO = new ArrayList();

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public final void a(ListAdapter listAdapter) {
        if (this.xXO.size() > 0) {
            ListAdapter cVar = new c(this.xXO, listAdapter);
            if (cVar.mNumColumns != 5) {
                cVar.mNumColumns = 5;
                cVar.mDataSetObservable.notifyChanged();
            }
            super.setAdapter(cVar);
            return;
        }
        super.setAdapter(listAdapter);
    }
}
