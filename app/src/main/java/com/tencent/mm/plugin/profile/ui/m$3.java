package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ay.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.FileUtils;

class m$3 implements Runnable {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ ProgressDialog lpj;
    final /* synthetic */ m pjK;

    m$3(m mVar, boolean z, ProgressDialog progressDialog) {
        this.pjK = mVar;
        this.kCv = z;
        this.lpj = progressDialog;
    }

    public final void run() {
        boolean z = this.kCv;
        bo.r(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
        int Gd = q.Gd();
        int i = z ? Gd & -129 : Gd | FileUtils.S_IWUSR;
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.kCv) {
            ba.hS("qqsync");
            ar.Hg();
            c.Fd().WX("qqsync");
        }
        ag.y(new 1(this));
    }
}
