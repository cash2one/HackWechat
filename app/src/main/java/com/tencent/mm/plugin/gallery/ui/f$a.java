package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class f$a extends t {
    public ImageView mRX;
    public ImageView mRY;
    public RelativeLayout mRZ;
    public TextView mSa;
    public ImageView mSe;
    public ImageView mSf;
    public ImageView mSg;
    public ImageView mUK;
    public View mUL;
    public int mUM;

    public f$a(View view) {
        super(view);
        this.mUL = view;
        this.mSf = (ImageView) view.findViewById(R.h.cnD);
        this.mSg = (ImageView) view.findViewById(R.h.cdh);
        this.mUK = (ImageView) view.findViewById(R.h.ceM);
        this.mRX = (ImageView) view.findViewById(R.h.cvC);
        this.mRY = (ImageView) view.findViewById(R.h.cvF);
        this.mRZ = (RelativeLayout) view.findViewById(R.h.cVe);
        this.mSa = (TextView) view.findViewById(R.h.cVf);
        this.mSe = (ImageView) view.findViewById(R.h.cvA);
        this.mSe.setBackgroundResource(R.e.bsK);
        this.mSe.setVisibility(8);
    }
}
