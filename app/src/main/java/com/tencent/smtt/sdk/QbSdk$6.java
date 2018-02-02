package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

class QbSdk$6 implements u {
    QbSdk$6() {
    }

    public final void kO(int i) {
        if (QbSdk.cDU() != null) {
            QbSdk.cDU().kO(i);
        }
        if (QbSdk.cDT() != null) {
            QbSdk.cDT().kO(i);
        }
    }

    public final void ly(int i) {
        if (p.cEq()) {
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
            p.zXu = true;
            return;
        }
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        p.zXu = false;
        if (QbSdk.cDT() != null) {
            QbSdk.cDT().ly(i);
        }
        if (QbSdk.cDU() != null) {
            QbSdk.cDU().ly(i);
        }
    }

    public final void lz(int i) {
        QbSdk.setTBSInstallingStatus(false);
        p.zXu = false;
        if (p.cEr()) {
            p.zXu = true;
        } else {
            p.zXu = false;
        }
        if (QbSdk.cDT() != null) {
            QbSdk.cDT().lz(i);
        }
        if (QbSdk.cDU() != null) {
            QbSdk.cDU().lz(i);
        }
    }
}
