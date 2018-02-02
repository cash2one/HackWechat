package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private String lang = w.eL(ac.getContext());
    boolean mYj;
    private String mYk;
    private String mYl;
    private String mYm;
    private String mYn;
    private String mYo;
    private String mYp;

    public a(Bundle bundle) {
        this.mYj = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.mYk = bundle.getString("close_window_confirm_dialog_title_cn");
        this.mYl = bundle.getString("close_window_confirm_dialog_title_eng");
        this.mYm = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.mYn = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.mYo = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.mYp = bundle.getString("close_window_confirm_dialog_cancel_eng");
    }

    public final String aOS() {
        if ("zh_CN".equals(this.lang)) {
            return this.mYk;
        }
        return this.mYl;
    }

    public final String aOT() {
        if ("zh_CN".equals(this.lang)) {
            return this.mYm;
        }
        return this.mYn;
    }

    public final String aOU() {
        if ("zh_CN".equals(this.lang)) {
            return this.mYo;
        }
        return this.mYp;
    }
}
