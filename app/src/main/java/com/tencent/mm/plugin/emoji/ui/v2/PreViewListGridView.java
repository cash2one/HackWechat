package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.af;

public class PreViewListGridView extends ListView {
    private int RT;
    private WindowManager lEi;
    private int lIA;
    private boolean lIB;
    private volatile int lIC = -1;
    private String lID;
    private PopEmojiView lIE;
    private d lIF;
    private boolean lIr = true;
    private LayoutParams lIx;
    private int lIy;
    private int lIz;
    private af mHandler = new af();

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lIE = new PopEmojiView(getContext());
        this.lIy = context.getResources().getDimensionPixelSize(R.f.bxi);
        this.lEi = (WindowManager) context.getSystemService("window");
        this.lIx = new LayoutParams(-1, -1, 2, 8, 1);
        this.lIx.width = this.lIy;
        this.lIx.height = this.lIy;
        this.lIx.gravity = 17;
        this.RT = getResources().getConfiguration().orientation;
        if (this.RT == 2) {
            this.lIz = this.lEi.getDefaultDisplay().getHeight();
            this.lIA = this.lEi.getDefaultDisplay().getWidth();
            return;
        }
        this.lIz = this.lEi.getDefaultDisplay().getWidth();
        this.lIA = this.lEi.getDefaultDisplay().getHeight();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.lIF = (d) listAdapter;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.lIB) {
                    aDA();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void aDA() {
        if (this.lIB) {
            this.lEi.removeView(this.lIE);
            this.lIB = false;
        }
        this.lID = "";
    }
}
