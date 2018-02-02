package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.bx.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class b extends a {
    private static final int kaN = a.fromDPToPix(ac.getContext(), 48);
    private static final int kaO = a.fromDPToPix(ac.getContext(), 43);

    public final View mj(int i) {
        View view = null;
        Context context = this.kaK;
        c cVar = this.tLf;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.tLn = this;
        dVar.mContext = context;
        dVar.tLf = cVar;
        if (!(dVar.mContext == null || dVar.tLn == null)) {
            view = View.inflate(dVar.mContext, R.i.duh, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).tLf = dVar.tLf;
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int ans = dVar.tLn.ans();
                int ant = dVar.tLn.ant();
                int anu = dVar.tLn.anu();
                int rowCount = dVar.tLn.getRowCount();
                int anv = dVar.tLn.anv();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.XC);
                webViewSmileyGrid.kaS = i2;
                webViewSmileyGrid.kaQ = ans;
                webViewSmileyGrid.kaR = ant;
                webViewSmileyGrid.kaT = anv;
                webViewSmileyGrid.kaU = anu;
                webViewSmileyGrid.kaV = rowCount;
                webViewSmileyGrid.setNumColumns(anu);
                i2 = webViewSmileyGrid.kaT;
                anv = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                ans = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(anv, i2, ans, 0);
                webViewSmileyGrid.tLg = new WebViewSmileyGrid.a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.tLg);
                webViewSmileyGrid.tLg.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int ans() {
        return e.chc().anm();
    }

    public final int ant() {
        return anu() * getRowCount();
    }

    public final int getPageCount() {
        if (ant() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) e.chc().anm()) / ((double) ant()));
    }

    public final int anu() {
        if (this.tLf.kbb) {
            return 7;
        }
        c cVar = this.tLf;
        if (cVar.kbg <= 1) {
            r2 = new int[2];
            Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
            r2[0] = defaultDisplay.getWidth();
            r2[1] = defaultDisplay.getHeight();
            cVar.kbg = r2[0];
        }
        return cVar.kbg / kaO;
    }

    public final int anv() {
        return (this.tLf.kbf - (kaN * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.tLf.kbf / kaN;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
