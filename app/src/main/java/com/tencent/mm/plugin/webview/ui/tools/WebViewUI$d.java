package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;

final class WebViewUI$d {
    private String lang;
    private String mYk;
    private String mYl;
    private String mYm;
    private String mYn;
    private String mYo;
    private String mYp;
    String tBu;

    public WebViewUI$d(Bundle bundle) {
        this.tBu = bundle.getString("close_window_confirm_dialog_switch");
        this.mYk = bundle.getString("close_window_confirm_dialog_title_cn");
        this.mYl = bundle.getString("close_window_confirm_dialog_title_eng");
        this.mYm = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.mYn = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.mYo = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.mYp = bundle.getString("close_window_confirm_dialog_cancel_eng");
        this.lang = bundle.getString("application_language");
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
