package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private int RT;
    private View jCL;
    CustomViewCallback jCM;
    private int jCN = 0;
    private Set<x> jCO = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;

    c(Context context) {
        this.mContext = context;
    }

    final void r(View view, int i) {
        aiK();
        this.jCL = view;
        MMActivity mMActivity = (MMActivity) this.mContext;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        this.jCN = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (d.fN(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4102);
        }
        mMActivity.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.RT = mMActivity.getRequestedOrientation();
        switch (i) {
            case -90:
                mMActivity.setRequestedOrientation(8);
                break;
            case 0:
                mMActivity.setRequestedOrientation(1);
                break;
            case 90:
                mMActivity.setRequestedOrientation(0);
                break;
            default:
                mMActivity.setRequestedOrientation(9);
                break;
        }
        aiL();
    }

    final boolean aiK() {
        if (this.jCL == null) {
            return false;
        }
        if (this.jCM != null) {
            this.jCM.onCustomViewHidden();
        }
        MMActivity mMActivity = (MMActivity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.jCN);
        viewGroup.removeView(this.jCL);
        mMActivity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        mMActivity.setRequestedOrientation(this.RT);
        this.jCL = null;
        this.jCM = null;
        for (x agt : this.jCO) {
            agt.agt();
        }
        return true;
    }

    final void a(x xVar) {
        this.jCO.add(xVar);
    }

    private void aiL() {
        Iterator it = this.jCO.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
