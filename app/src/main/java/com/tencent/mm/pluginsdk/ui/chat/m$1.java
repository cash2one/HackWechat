package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.m.b;
import com.tencent.mm.sdk.platformtools.af;

class m$1 extends af {
    final /* synthetic */ m vrP;

    m$1(m mVar) {
        this.vrP = mVar;
    }

    public final void handleMessage(Message message) {
        int i = 0;
        switch (message.what) {
            case CdnLogic.kMediaTypeBackupFile /*20001*/:
                this.vrP.hide();
                return;
            case 20002:
                removeMessages(CdnLogic.kMediaTypeBackupFile);
                return;
            case 20003:
                m mVar = this.vrP;
                mVar.mHandler.removeMessages(CdnLogic.kMediaTypeBackupFile);
                if (mVar.vrJ) {
                    b bVar = mVar.vrL;
                    bVar.mData = mVar.lDO;
                    bVar.notifyDataSetInvalidated();
                    if (mVar.lDO != null && mVar.lDO.size() > 2) {
                        mVar.vrE.setWidth(((int) (((double) mVar.vrC) * 2.5d)) + (mVar.vrD * 2));
                    } else if (mVar.lDO == null || mVar.lDO.size() != 2) {
                        mVar.vrE.setWidth(mVar.vrC + (mVar.vrD * 2));
                    } else {
                        mVar.vrE.setWidth((mVar.vrC * 2) + (mVar.vrD * 2));
                    }
                    mVar.ccb();
                    if (mVar.lDO == null || mVar.lDO.size() < 3) {
                        mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                    } else {
                        mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 5000);
                    }
                    g gVar = g.pQN;
                    Object[] objArr = new Object[6];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = mVar.vrH;
                    objArr[2] = "";
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = "";
                    if (mVar.lDO != null) {
                        i = mVar.lDO.size();
                    }
                    objArr[5] = Integer.valueOf(i);
                    gVar.h(10994, objArr);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
