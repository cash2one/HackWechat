package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, k {
    private af handler = new af(Looper.getMainLooper());
    public EditText qwX;
    public TextView qwY;
    public View qwZ;
    private a qxa;
    public InputMethodManager qxb;
    public int qxc = b.qxf;
    public a qxd;

    public final boolean btA() {
        return this.qxc == b.qxe;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.qwX.clearFocus();
            bh.hideVKB(this.qwX);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cJp && btA()) {
            btB();
        }
    }

    public final void btB() {
        if (btA()) {
            btC();
        } else if (!btA()) {
            this.qxc = b.qxe;
            this.qwZ.setVisibility(0);
            if (this.qxd != null) {
                this.qxd.btD();
            }
            this.qwX.requestFocus();
            this.qxb.showSoftInput(this.qwX, 0);
        }
    }

    public final void btC() {
        if (btA()) {
            this.qwX.setText("");
            this.qwX.clearFocus();
            bh.hideVKB(this.qwX);
            this.qxc = b.qxf;
            this.qwZ.setVisibility(8);
            if (this.qxd != null) {
                this.qxd.btE();
            }
        }
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0 && hVar.mMc != null && this.qxd != null) {
            List arrayList = new ArrayList();
            for (j jVar : hVar.mMc) {
                arrayList.add(jVar.mLs);
            }
            this.qxd.bI(arrayList);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!bh.ov(editable.toString())) {
            x.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[]{editable.toString()});
            if (this.qxa != null) {
                ((m) g.k(m.class)).cancelSearchTask(this.qxa);
                this.qxa = null;
            }
            this.qxa = ((m) g.k(m.class)).search(2, com.tencent.mm.plugin.fts.a.a.g.a(r0, new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075}, null, 3, new HashSet(), b.mMz, this, this.handler));
        }
    }
}
