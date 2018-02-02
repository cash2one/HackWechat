package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;

public class AppGrid extends GridView {
    Context context;
    private SharedPreferences gZO;
    OnItemClickListener kGC = new OnItemClickListener(this) {
        final /* synthetic */ AppGrid voK;

        {
            this.voK = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.voK.voD.a(this.voK.voD.Ce((this.voK.voH * this.voK.voF) + i), this.voK.voJ.yg(i));
        }
    };
    OnItemLongClickListener mtQ = new OnItemLongClickListener(this) {
        final /* synthetic */ AppGrid voK;

        {
            this.voK = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b c = this.voK.voD;
            int Ce = this.voK.voD.Ce((this.voK.voH * this.voK.voF) + i);
            this.voK.voJ.yg(i);
            c.Cf(Ce);
            return true;
        }
    };
    b voD;
    int voE;
    int voF = 0;
    int voG = 0;
    int voH;
    int voI;
    a voJ;

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public int getCount() {
        return this.voJ.getCount();
    }
}
