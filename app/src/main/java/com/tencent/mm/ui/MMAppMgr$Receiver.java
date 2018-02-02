package com.tencent.mm.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.o;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.model.app.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MMAppMgr$Receiver extends BroadcastReceiver {
    private MMAppMgr appMgr;

    public MMAppMgr$Receiver(MMAppMgr mMAppMgr) {
        this.appMgr = mMAppMgr;
    }

    private static boolean ak(Intent intent) {
        if (intent.getBooleanExtra("process_is_mm", false) && intent.getIntExtra("process_id", 0) != Process.myPid()) {
            return false;
        }
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && !ar.GZ() && !ar.Hb()) {
            String action = intent.getAction();
            if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                if (ak(intent)) {
                    MMAppMgr.a(this.appMgr, intent, true);
                    this.appMgr.e(intent, true);
                    return;
                }
                x.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[]{Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid())});
            } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                if (ak(intent)) {
                    o.wW();
                    MMAppMgr.a(this.appMgr, intent, false);
                    this.appMgr.e(intent, false);
                    if (MMAppMgr.xJK != null && MMAppMgr.xJK.length() > 800) {
                        new af(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ MMAppMgr$Receiver xJW;

                            {
                                this.xJW = r1;
                            }

                            public final void run() {
                                MMAppMgr.cnc();
                            }
                        });
                        return;
                    }
                    return;
                }
                x.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[]{Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid())});
            } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                action = intent.getStringExtra("content");
                if (bh.ov(action)) {
                    x.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                } else {
                    if (MMAppMgr.xJK == null) {
                        MMAppMgr.xJK = new StringBuffer(800);
                    }
                    MMAppMgr.xJK.append(action);
                    x.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[]{action});
                }
                if (MMAppMgr.xJK != null && MMAppMgr.xJK.length() > 800) {
                    new af(Looper.getMainLooper()).post(new 2(this));
                }
            } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                int intExtra;
                if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                    intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                    x.d("MicroMsg.MMAppMgr", "silence_update_stat = " + intExtra);
                    if (ar.Hj()) {
                        if (intExtra == 2) {
                            int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                            g.pQN.h(11147, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2)});
                        } else {
                            g.pQN.h(11147, new Object[]{Integer.valueOf(intExtra)});
                        }
                        if (intExtra == 4 && p.bYZ() == 4) {
                            a bYz = a.bYz();
                            if (bYz != null) {
                                bYz.bYB();
                            }
                        }
                    }
                } else {
                    x.d("MicroMsg.MMAppMgr", "incremental_update = " + intent.getIntExtra("intent_extra_opcode", 0));
                    if (ar.Hj()) {
                        g.pQN.h(10328, new Object[]{Integer.valueOf(intExtra)});
                    }
                }
                long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                if (!ar.Hj()) {
                    return;
                }
                if (longExtra != 0 || longExtra2 != 0) {
                    x.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[]{Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra)});
                    if (booleanExtra) {
                        n.B((int) longExtra2, (int) longExtra, 0);
                    } else {
                        n.C((int) longExtra2, (int) longExtra, 0);
                    }
                }
            } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                MMAppMgr.b(context, true);
            } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                com.tencent.mm.pluginsdk.ui.tools.a.ae(intent);
            } else {
                x.e("MicroMsg.MMAppMgr", "unknown broadcast action");
            }
        }
    }
}
