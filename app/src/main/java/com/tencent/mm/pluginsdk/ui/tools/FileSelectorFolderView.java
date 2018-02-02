package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class FileSelectorFolderView extends LinearLayout implements OnItemClickListener {
    boolean Od = false;
    private FrameLayout mTu;
    private View mTv;
    private ListView mTw;
    private boolean mTy = false;
    a vwR = null;
    private b vwS;

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    final void fr(boolean z) {
        if (this.Od == z) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.Od)});
        } else if (this.mTy) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
        } else if (this.Od) {
            this.mTy = true;
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.bqm);
            r0.setAnimationListener(new 1(this));
            this.mTw.startAnimation(r0);
            this.mTv.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bqa));
        } else {
            this.mTy = true;
            this.mTu.setVisibility(0);
            this.mTv.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bpZ));
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.bqo);
            r0.setAnimationListener(new 2(this));
            this.mTw.startAnimation(r0);
        }
    }

    private void init() {
        setOrientation(1);
        this.mTu = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mTu.setVisibility(8);
        addView(this.mTu, layoutParams);
        this.mTv = new View(getContext());
        this.mTv.setBackgroundColor(-872415232);
        this.mTv.setOnClickListener(new 3(this));
        this.mTu.addView(this.mTv, new FrameLayout.LayoutParams(-1, -1));
        this.mTw = new ListView(getContext());
        this.mTw.setCacheColorHint(0);
        this.mTw.setBackgroundResource(R.e.btq);
        this.mTw.setSelector(R.g.bDJ);
        this.mTw.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvJ);
        this.mTw.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.buG);
        layoutParams.gravity = 80;
        this.mTu.addView(this.mTw, layoutParams);
        this.vwS = new b(getContext());
        this.mTw.setAdapter(this.vwS);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vwR != null) {
            this.vwR.CA(i);
        }
        this.mTv.performClick();
    }
}
