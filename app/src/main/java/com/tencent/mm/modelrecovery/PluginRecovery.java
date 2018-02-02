package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery extends f implements c {
    private com.tencent.mm.sdk.b.c<mv> hJX = new com.tencent.mm.sdk.b.c<mv>(this) {
        final /* synthetic */ PluginRecovery hJZ;

        {
            this.hJZ = r2;
            this.xen = mv.class.getName().hashCode();
        }

        private static boolean a(mv mvVar) {
            Context context;
            Builder builder;
            switch (mvVar.fET.action) {
                case 1:
                    context = ac.getContext();
                    builder = new Builder();
                    builder.zRD = WXRecoveryHandleService.class.getName();
                    builder.zRE = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26060235";
                    builder.zRz = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.ned = WXUtil.go(context);
                    RecoveryLogic.a(context, builder.cDm(), new RecoveryContext());
                    break;
                case 2:
                    a.QJ();
                    break;
                case 3:
                    context = ac.getContext();
                    builder = new Builder();
                    builder.zRD = WXRecoveryHandleService.class.getName();
                    builder.zRE = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26060235";
                    builder.zRz = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.ned = WXUtil.go(context);
                    RecoveryLogic.a(context, builder.cDm(), new RecoveryContext());
                    break;
            }
            return false;
        }
    };
    private RecoveryLogImpl hJY = new RecoveryLogImpl(this) {
        final /* synthetic */ PluginRecovery hJZ;

        {
            this.hJZ = r1;
        }

        public final void d(String str, String str2, Object... objArr) {
            x.d(str, str2, objArr);
        }

        public final void v(String str, String str2, Object... objArr) {
            x.v(str, str2, objArr);
        }

        public final void i(String str, String str2, Object... objArr) {
            x.i(str, str2, objArr);
        }

        public final void w(String str, String str2, Object... objArr) {
            x.w(str, str2, objArr);
        }

        public final void e(String str, String str2, Object... objArr) {
            x.e(str, str2, objArr);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            x.printErrStackTrace(str, th, str2, objArr);
        }
    };
    private BroadcastReceiver tP = new 2(this);

    public void configure(g gVar) {
        RecoveryLog.a(this.hJY);
        if (gVar.fR(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            ac.getContext().registerReceiver(this.tP, intentFilter);
            File file = new File(WXConstantsRecovery.zRP);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "version.info");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                FileOp.j(file2.getAbsolutePath(), Integer.toHexString(d.vAz).getBytes());
            } catch (Exception e) {
            }
            x.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        this.hJX.ceO();
    }

    public void onAccountRelease() {
        this.hJX.dead();
    }

    private void postLog() {
        com.tencent.mm.sdk.f.e.post(new 3(this), "RecoveryWriteLogThread");
    }

    private void postReport() {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ PluginRecovery hJZ;

            {
                this.hJZ = r1;
            }

            public final void run() {
                x.i("MicroMsg.Recovery.PluginRecovery", "postReport");
                b.QK();
            }
        }, "RecoveryReportStatusThread");
    }
}
