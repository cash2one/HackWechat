package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private Context context;
    private String fus;
    private String fzW;
    private af handler = new af(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean qQH = false;
    protected SnsPostDescPreloadTextView rrW;
    protected SnsTextView rrX;
    protected TextView rrY;
    private String rrZ;
    private int rrc = 0;
    private String rsa;
    private HashMap<String, Integer> rsb;
    private Runnable rsc = new Runnable(this) {
        final /* synthetic */ CollapsibleTextView rsd;

        {
            this.rsd = r1;
        }

        public final void run() {
            if (this.rsd.rrW != null && (this.rsd.rrW.getTag() instanceof as) && ((as) this.rsd.rrW.getTag()).fzW.equals(this.rsd.fzW)) {
                this.rsd.rrW.setMaxLines(6);
                this.rsd.rrY.setVisibility(0);
                this.rsd.rrY.setText(this.rsd.rrZ);
            }
        }
    };
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rrZ = this.context.getString(j.qKv);
        this.rsa = this.context.getString(j.qKu);
        View inflate = v.fv(this.context).inflate(i$g.qGu, this);
        inflate.setPadding(0, -3, 0, 0);
        this.rrW = (SnsPostDescPreloadTextView) inflate.findViewById(f.caS);
        this.rrY = (TextView) inflate.findViewById(f.gVt);
        this.rrX = (SnsTextView) inflate.findViewById(f.qBW);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, av avVar, String str3, boolean z) {
        this.context = avVar.fmM;
        this.rsb = hashMap;
        this.text = charSequence;
        this.qQH = z;
        this.fus = str;
        this.fzW = str2;
        this.rrc = i;
        this.rrZ = this.context.getString(j.qKv);
        this.rsa = this.context.getString(j.qKu);
        this.rrX.nUp = str3;
        as asVar = new as(this.fzW, this.fus, false, false, 1);
        if (i == 0) {
            this.rrW.setText(str3);
            this.rrX.setVisibility(8);
            this.rrY.setVisibility(0);
            this.rrW.setVisibility(0);
            this.rrW.setOnTouchListener(new l(this.context));
            this.rrW.setTag(asVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.rrY.setVisibility(8);
                this.rrW.setMaxLines(7);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.rrY.setVisibility(8);
                    return;
                case 1:
                    this.rrW.setMaxLines(6);
                    this.rrY.setVisibility(0);
                    this.rrY.setText(this.rrZ);
                    return;
                case 2:
                    this.rrW.setMaxLines(Integer.MAX_VALUE);
                    this.rrY.setVisibility(0);
                    this.rrY.setText(this.rsa);
                    return;
                default:
                    return;
            }
        }
        this.rrX.setText(charSequence, bufferType);
        this.rrX.setTag(asVar);
        this.rrX.setVisibility(0);
        this.rrY.setVisibility(8);
        this.rrW.setVisibility(8);
        this.rrX.setOnClickListener(avVar.qZo.rPK);
    }

    public final int bzi() {
        x.i("MicroMsg.CollapsibleTextView", "count:" + this.rrW.getLineCount() + "  height:" + this.rrW.getLineHeight());
        return (this.rrW.getLineCount() - 6) * this.rrW.getLineHeight();
    }

    public final void j(OnClickListener onClickListener) {
        if (this.rrY != null) {
            this.rrY.setOnClickListener(onClickListener);
        }
    }

    public void setLongClickable(boolean z) {
        this.rrY.setLongClickable(z);
        this.rrX.setLongClickable(z);
        this.rrW.setLongClickable(z);
        super.setLongClickable(z);
    }

    public void setClickable(boolean z) {
        this.rrY.setClickable(z);
        this.rrX.setClickable(z);
        this.rrW.setClickable(z);
        super.setClickable(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rrc == 0 && !this.qQH && !this.hasCheck) {
            this.hasCheck = true;
            if (this.rrW.getLineCount() <= 6) {
                this.rsb.put(this.fus, Integer.valueOf(0));
                return;
            }
            this.rsb.put(this.fus, Integer.valueOf(1));
            this.handler.post(this.rsc);
        }
    }
}
