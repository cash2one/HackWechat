package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.q;

public final class a {
    private static final int[] kDX = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kDY = new int[]{R.g.byC, R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI};
    private Context context;
    private ImageView kEg;
    private final af kEx = new 1(this);
    private View myF;
    private View myG;
    private View myI;
    private q scp;
    private TextView scq;
    private ImageView scr;
    private View scs;
    private int sct;

    public a(Context context) {
        this.context = context;
        this.sct = b.b(context, 180.0f);
        this.scp = new q(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dtG, null), -1, -2);
        this.kEg = (ImageView) this.scp.getContentView().findViewById(R.h.cWI);
        this.myI = this.scp.getContentView().findViewById(R.h.cWL);
        this.scq = (TextView) this.scp.getContentView().findViewById(R.h.cWN);
        this.scr = (ImageView) this.scp.getContentView().findViewById(R.h.cWM);
        this.scs = this.scp.getContentView().findViewById(R.h.cWO);
        this.myF = this.scp.getContentView().findViewById(R.h.cWP);
        this.myG = this.scp.getContentView().findViewById(R.h.cWQ);
    }
}
