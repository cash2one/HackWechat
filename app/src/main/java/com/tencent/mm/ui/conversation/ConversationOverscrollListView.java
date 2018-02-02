package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;

public class ConversationOverscrollListView extends ListView implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener, a {
    private static final boolean yXr = d.fO(10);
    private int Bf = 0;
    private OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private Rect fD = new Rect();
    private ak ikI;
    private final float yXA = 13.5f;
    private float yXB = 0.0f;
    private b yXC = new b(this);
    private final int yXD = 50;
    private OnItemLongClickListener yXE;
    private c yXs = new c();
    private a yXt;
    private boolean yXu = false;
    private int yXv = 0;
    private int yXw = 0;
    private float yXx = 0.0f;
    private long yXy = 1;
    private final float yXz = 3.5f;

    public ConversationOverscrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        this.ikI = new ak(this, false);
    }

    @TargetApi(11)
    protected void onFinishInflate() {
    }

    @TargetApi(11)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.SY = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.yXE = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.SZ = onItemSelectedListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.yXu = true;
        if (this.SY != null) {
            this.SY.onItemClick(adapterView, view, i, j);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.yXu = true;
        if (this.SZ != null) {
            this.SZ.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        if (this.SZ != null) {
            this.SZ.onNothingSelected(adapterView);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.yXu = true;
        if (this.yXE != null) {
            return this.yXE.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }

    public final boolean uF() {
        return false;
    }
}
