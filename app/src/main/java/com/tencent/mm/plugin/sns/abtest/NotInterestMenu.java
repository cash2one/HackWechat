package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.ui.v;

public class NotInterestMenu extends LinearLayout {
    private static int[] qNy = new int[]{j.qLb, j.qKZ, j.qLa};
    private Context mContext = null;
    b qNA = null;
    private ListView qNx;
    c qNz = null;
    m qyg = null;

    public NotInterestMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        v.fv(this.mContext).inflate(g.qGC, this);
        this.qNx = (ListView) findViewById(f.qCV);
        this.qNx.setAdapter(new a(this));
        this.qNx.setOnItemClickListener(new 1(this));
    }
}
