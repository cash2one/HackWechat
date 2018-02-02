package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

class WebView$7 extends Thread {
    WebView$7() {
    }

    public final void run() {
        if (WebView.cFf() == null) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            return;
        }
        h.nO(true);
        if (h.zWr) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
        }
        n gF = n.gF(WebView.cFf());
        int abf = gF.abf("install_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + abf);
        if (abf == 2) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            h.abd(String.valueOf(gF.abg("install_core_ver")));
            h.cDX();
            return;
        }
        int abf2 = gF.abf("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + abf2);
        if (abf2 == 1) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            h.abd(String.valueOf(gF.abg("copy_core_ver")));
            h.cDX();
        } else if (!af.cFg().cFh()) {
            if (abf == 3 || abf2 == 3) {
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                h.abd(String.valueOf(h.cDW()));
                h.cDX();
            }
        }
    }
}
