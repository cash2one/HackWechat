package com.tencent.mm.ui.account;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;

public final class a extends BaseAdapter {
    private LayoutInflater nny;
    private String[] xNl;
    private Drawable xNm = null;
    private OnTouchListener xNn = new 1(this);

    public a(Context context, String[] strArr) {
        this.xNl = strArr;
        this.nny = LayoutInflater.from(context);
        this.xNm = context.getResources().getDrawable(R.g.bGo);
        this.xNm.setBounds(0, 0, this.xNm.getIntrinsicWidth(), this.xNm.getIntrinsicHeight());
    }

    public final int getCount() {
        return this.xNl.length;
    }

    public final Object getItem(int i) {
        return this.xNl[i];
    }

    private boolean Ee(int i) {
        if (i == this.xNl.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 1;
        if (view == null) {
            view = this.nny.inflate(R.i.dae, null);
        }
        TextView textView = (TextView) view.findViewById(R.h.bJZ);
        view.setOnTouchListener(this.xNn);
        if ((i == 0 ? 1 : 0) == 0 || !Ee(i)) {
            if (i != 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.xNm, null);
            } else if (Ee(i)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.xNm, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.xNl[i]);
        return view;
    }
}
