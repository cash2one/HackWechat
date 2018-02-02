package com.tencent.mm.plugin.notification.ui;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class FailSendMsgNotification$FailSendMsgNotificationService extends Service {
    protected c oVf = new 1(this);
    protected FailSendMsgNotification oVg = null;

    protected abstract int bgO();

    public void onCreate() {
        super.onCreate();
        x.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
        a.xef.b(this.oVf);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(16)
    public int onStartCommand(Intent intent, int i, int i2) {
        x.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
        if (intent == null || intent.getExtras() == null) {
            x.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
        } else {
            String action = intent.getAction();
            if (bh.ov(action)) {
                x.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
            } else {
                int i3 = intent.getExtras().getInt("notification_type", -1);
                x.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[]{Integer.valueOf(i3)});
                if (f.ul(i3) == null) {
                    x.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                } else {
                    x.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[]{action});
                    this.oVg = f.ul(i3);
                    if (action.startsWith("com.tencent.failnotification.omit")) {
                        if (this.oVg.oUT != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[]{Integer.valueOf(i3)});
                            this.oVg.oUT.bgz();
                        }
                    } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                        if (this.oVg.oUT != null) {
                            boolean z;
                            String str = "MicroMsg.FailSendMsgNotification";
                            String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(i3);
                            objArr[1] = Boolean.valueOf(this.oVg.sx == null);
                            if (this.oVg.oUQ == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[2] = Boolean.valueOf(z);
                            x.d(str, str2, objArr);
                            if (this.oVg != null) {
                                this.oVg.lzK = true;
                            }
                            if (this.oVg.sx != null && VERSION.SDK_INT >= 16) {
                                this.oVg.sx.priority = 0;
                            }
                            if (this.oVg.sx == null) {
                                this.oVg.show();
                            }
                            startForeground(i3, this.oVg.sx);
                            this.oVg.oUT.bgy();
                            x.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[]{Integer.valueOf(i3)});
                        }
                    } else if (action.startsWith("com.tencent.failnotification.click")) {
                        if (this.oVg.oUU != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[]{Integer.valueOf(i3)});
                            this.oVg.oUU.bgA();
                        }
                    } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                        this.oVg.oVc = false;
                        this.oVg.lzK = false;
                        if (this.oVg.oUV != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                            this.oVg.oUV.onDismiss();
                        }
                        stopSelf();
                    }
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
        a.xef.c(this.oVf);
    }
}
