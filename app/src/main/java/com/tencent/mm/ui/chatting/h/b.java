package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b {
    private Button krY;
    private Button krZ;
    private View lCk;
    Context mContext;
    OptionPicker yIc;
    OptionPicker yId;
    public c yIe;
    private int yIf;
    private BottomSheetBehavior yIg;
    public a yIh;
    ArrayList<Long> yIi = new ArrayList(42);

    public interface a {
        void fX(long j);

        void onCancel();
    }

    public b(Context context) {
        this.mContext = context;
        this.lCk = View.inflate(this.mContext, R.i.dqK, null);
        this.yIe = new c(this.mContext);
        this.yIe.setContentView(this.lCk);
        this.yIe.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ b yIj;

            {
                this.yIj = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.yIj.yIe = null;
            }
        });
        this.yIc = (OptionPicker) this.lCk.findViewById(R.h.cBN);
        this.yId = (OptionPicker) this.lCk.findViewById(R.h.cBO);
        this.yIc.setValue(0);
        this.yIc.KD = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 60);
        this.yId.KD = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 60);
        this.yIc.j(cvw());
        this.yId.j(Gj(0));
        this.yIc.setOnValueChangedListener(new 2(this));
        LayoutParams layoutParams = (LayoutParams) this.lCk.getLayoutParams();
        layoutParams.height = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 288);
        this.lCk.setLayoutParams(layoutParams);
        this.yIf = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 350);
        this.yIg = BottomSheetBehavior.i((View) this.lCk.getParent());
        if (this.yIg != null) {
            this.yIg.q(this.yIf);
            this.yIg.fj = false;
        }
        this.krY = (Button) this.lCk.findViewById(e.cBC);
        this.krY.setOnClickListener(new 3(this));
        this.krZ = (Button) this.lCk.findViewById(e.bPo);
        this.krZ.setOnClickListener(new 4(this));
    }

    public final void hide() {
        if (this.yIe != null) {
            this.yIe.dismiss();
        }
    }

    final String[] Gj(int i) {
        int i2;
        Object arrayList = new ArrayList();
        if (com.tencent.mm.sdk.a.b.ceK()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        switch (i - i2) {
            case -1:
                arrayList.add("after 6 min");
                break;
            case 0:
                int i3 = Calendar.getInstance().get(11);
                for (i2 = 1; i2 <= 24 - i3; i2++) {
                    arrayList.add(this.mContext.getResources().getString(R.l.dDw, new Object[]{Integer.valueOf(i2)}));
                }
                break;
            default:
                i2 = 1;
                while (i2 <= 24) {
                    arrayList.add((i2 < 10 ? "0" + i2 : Integer.valueOf(i2)) + ":00");
                    i2++;
                }
                break;
        }
        return bh.cz(arrayList);
    }

    private String[] cvw() {
        int i = 0;
        this.yIi.clear();
        List arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        int i2 = 0;
        while (i2 < instance.getActualMaximum(5)) {
            if (com.tencent.mm.sdk.a.b.ceK() && i2 == 0) {
                arrayList.add("test");
                this.yIi.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                this.yIi.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.yIi.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String ag = n.ag(this.mContext.getString(R.l.eiw), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(R.l.eiT));
            } else if (i2 == 1) {
                arrayList.add(ag + " " + this.mContext.getResources().getString(R.l.eiU));
            } else if (i2 == 2) {
                arrayList.add(ag + " " + this.mContext.getResources().getString(R.l.eiS));
            } else {
                arrayList.add(ag + " " + n.T(this.mContext, instance.get(7)));
            }
            i2++;
        }
        i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        while (i < 12) {
            if (i3 + i > 12) {
                instance.set(1, i2 + 1);
                instance.set(2, (i3 + i) - 12);
            } else {
                instance.set(2, i3 + i);
            }
            instance.set(5, 1);
            this.yIi.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(n.ag(this.mContext.getString(R.l.eiL), instance.getTimeInMillis() / 1000)));
            i++;
        }
        return bh.cz(arrayList);
    }
}
