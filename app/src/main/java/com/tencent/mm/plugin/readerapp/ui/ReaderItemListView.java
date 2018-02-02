package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ListView;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.bf;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater nny;
    p$d onK;
    List<bf> pBv = new ArrayList();
    a pBw;
    OnCreateContextMenuListener pBx;
    private DisplayMetrics pBy;
    int position = 0;
    int type = 0;

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        boolean z = false;
        this.context = context;
        this.nny = v.fv(context);
        this.type = ((Activity) context).getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        if (bf.gT(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.pBy = getResources().getDisplayMetrics();
        this.pBw = new a(this);
        setAdapter(this.pBw);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
