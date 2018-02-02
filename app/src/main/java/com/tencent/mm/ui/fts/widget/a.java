package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public final class a extends LinearLayout {
    private View nWi = findViewById(g.bIb);
    public FTSEditTextView zet;
    public a zeu;

    public interface b extends Comparable {
        String getTagName();
    }

    public a(Context context) {
        super(context);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.gXj, this, true);
        this.nWi.setOnClickListener(new 1(this));
        this.zet = (FTSEditTextView) findViewById(g.cki);
    }
}
