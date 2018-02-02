package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray kZa;
    private a kZb;
    protected b laF;
    protected int laG;
    protected long laH;
    protected int laI;
    private k laJ;
    private Collection<com.tencent.mm.plugin.chatroom.d.a> laK;
    long laL;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.laG = 0;
        this.laI = 0;
        this.laL = -1;
        if (!isInEditMode()) {
            this.kZa = context.obtainStyledAttributes(attributeSet, R.n.eZF);
            setLayoutParams(new RecyclerView$LayoutParams(-1, -1));
            a(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            this.UC = this.laJ;
            setFadingEdgeLength(0);
            this.laJ = new k(this) {
                final /* synthetic */ DayPickerView laM;

                {
                    this.laM = r1;
                }

                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    if (((b) recyclerView.getChildAt(0)) != null) {
                        this.laM.laH = (long) i2;
                        this.laM.laI = this.laM.laG;
                    }
                }
            };
        }
    }

    public final void a(a aVar, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.laK = collection;
        this.kZb = aVar;
        if (this.laF == null) {
            this.laF = new b(getContext(), this.kZb, this.kZa, this.laL, collection);
        }
        a(this.laF);
        be(this.laF.getItemCount() - 1);
        this.laF.UR.notifyChanged();
    }
}
