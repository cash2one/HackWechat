package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.z.d;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    boolean lzK = false;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    public d oUQ = null;
    private Intent oUR = null;
    private int oUS = 0;
    public a oUT = null;
    public b oUU = null;
    public c oUV = null;
    public String oUW = null;
    public String oUX = null;
    private PendingIntent oUY = null;
    private PendingIntent oUZ = null;
    private PendingIntent oVa = null;
    private PendingIntent oVb = null;
    public boolean oVc = false;
    public boolean oVd = false;
    public boolean oVe = true;
    Notification sx = null;

    public FailSendMsgNotification(int i) {
        boolean z;
        this.mType = i;
        this.mContext = ac.getContext();
        this.oUQ = new d(this.mContext);
        this.oVe = true;
        this.oUX = "";
        try {
            if (this.oVe) {
                bgJ();
            }
            bgK();
            this.mIsInit = true;
        } catch (Exception e) {
            x.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[]{e.getMessage()});
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (this.mContext == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        this.oVc = false;
    }

    private void bgJ() {
        this.oUQ.ss = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oVa = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oUQ.a(R.g.bEs, this.mContext.getString(R.l.eyM), this.oVa);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        this.oVb = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oUQ.a(R.g.bEt, this.mContext.getString(R.l.eyN), this.oVb);
    }

    public final void bgK() {
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oUY = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oUQ.sa = this.oUY;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oUZ = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oUQ.sx.deleteIntent = this.oUZ;
    }

    public final void GO(String str) {
        this.oUW = str;
        show();
    }

    public final void bgL() {
        x.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[]{Boolean.valueOf(false)});
        this.lzK = false;
    }

    @TargetApi(16)
    public final void show() {
        if (this.mIsInit) {
            this.oUQ.c(this.oUX);
            this.oUQ.a(this.mContext.getText(R.l.app_name));
            this.oUQ.U(VERSION.SDK_INT < 19 ? R.g.bEp : R.g.bEq);
            this.oUQ.b(this.oUW);
            this.oUQ.n(false);
            this.sx = this.oUQ.build();
            if (VERSION.SDK_INT >= 16 && !this.lzK) {
                this.sx.priority = 2;
                x.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            x.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[]{Boolean.valueOf(this.lzK)});
            ar.getNotification().a(this.mType, this.sx, false);
            this.oVc = true;
            return;
        }
        x.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
    }

    public final void dismiss() {
        ar.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.lzK = false;
        this.oVc = false;
    }

    public final void bgM() {
        this.oUQ.c(2, false);
        this.oVd = false;
        show();
        x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    }

    public final void bgN() {
        this.oVe = true;
        this.oUQ = new d(this.mContext);
        bgJ();
        bgK();
    }
}
