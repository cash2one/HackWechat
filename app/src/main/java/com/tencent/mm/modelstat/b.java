package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class b {
    public static b hPA = new b();
    private c gyW = new c<ou>(this) {
        final /* synthetic */ b hPD;

        {
            this.hPD = r2;
            this.xen = ou.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ou ouVar = (ou) bVar;
            if (ouVar instanceof ou) {
                this.hPD.f(ouVar.fGM.fnB);
            }
            return false;
        }
    };
    private int hPB = 1;
    private int hPC = 1;
    public log_13835 hPz;
    private boolean hasInit = false;
    public Object lock = new Object();

    static /* synthetic */ void a(b bVar, au auVar, int i) {
        com.tencent.mm.sdk.b.b ovVar = new ov();
        ovVar.fGN.fnB = auVar;
        a.xef.m(ovVar);
        if (bVar.SN()) {
            bVar.a(auVar, b.hPL, i);
        }
    }

    private b() {
        a.xef.a(this.gyW);
    }

    public final boolean ch(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[]{bh.cgy().toString()});
            com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_13913 = new log_13913();
            com_tencent_mm_plugin_report_kvdata_log_13913.scene_ = 1;
            com_tencent_mm_plugin_report_kvdata_log_13913.error_ = r2;
            g.pQN.c(13913, com_tencent_mm_plugin_report_kvdata_log_13913);
            return false;
        }
        if (!(this.hPz == null || this.hPz.currChatName_ == null || this.hPz.currChatName_.equals(str))) {
            wW();
        }
        if (this.hPz == null) {
            this.hPz = new log_13835();
            this.hPz.currChatName_ = str;
        }
        return true;
    }

    public final void wW() {
        if (SN()) {
            int i;
            synchronized (this.lock) {
                i = (this.hPz == null || this.hPz.oplist_.isEmpty()) ? 0 : 1;
            }
            if (i != 0) {
                if (this.hPC != 0) {
                    x.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    g.pQN.c(13835, this.hPz);
                }
                if (this.hPB != 0) {
                    x.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[]{SM()});
                    g.pQN.k(13748, r0);
                }
            }
            this.hPz = null;
        }
    }

    public final void I(String str, boolean z) {
        int i = 1;
        if (SN()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            wW();
            if (ch(str)) {
                synchronized (this.lock) {
                    this.hPz.oplist_.add(iMBehavior);
                }
                wW();
            }
        }
    }

    public final void c(boolean z, String str, boolean z2) {
        int i = 1;
        if (SN()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z2) {
                i = 2;
            }
            iMBehaviorChattingOP.changeTop = i;
            if (z) {
                wW();
            }
            if (ch(str)) {
                synchronized (this.lock) {
                    this.hPz.oplist_.add(iMBehavior);
                }
                if (z) {
                    wW();
                }
            }
        }
    }

    public final void J(String str, boolean z) {
        int i = 1;
        if (SN() && ch(str)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i;
            synchronized (this.lock) {
                this.hPz.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(au auVar, b bVar, int i) {
        if (ch(auVar.field_talker)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 2;
            iMBehavior.msgOp = new IMBehaviorMsgOP();
            iMBehavior.msgOp.msgType = auVar.getType() & 65535;
            if (auVar.aNc()) {
                iMBehavior.msgOp.appMsgInnerType = i;
            }
            iMBehavior.msgOp.msgOpType = bVar.value;
            iMBehavior.msgOp.count = 1;
            synchronized (this.lock) {
                if (iMBehavior.opType == a.hPF.value) {
                    this.hPz.oplist_.add(iMBehavior);
                    return;
                }
                Iterator it = this.hPz.oplist_.iterator();
                while (it.hasNext()) {
                    IMBehavior iMBehavior2 = (IMBehavior) it.next();
                    if (iMBehavior2.opType == a.hPG.value) {
                        IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior2.msgOp;
                        IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                        int i2 = (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) ? 1 : 0;
                        if (i2 != 0) {
                            IMBehaviorMsgOP iMBehaviorMsgOP3 = iMBehavior2.msgOp;
                            iMBehaviorMsgOP3.count++;
                            return;
                        }
                    }
                }
                this.hPz.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(au auVar, int i) {
        new af(Looper.getMainLooper()).post(new 2(this, auVar, i));
    }

    public final void f(au auVar) {
        new af(Looper.getMainLooper()).post(new 3(this, auVar));
    }

    public final void b(au auVar, int i) {
        if (SN()) {
            a(auVar, b.hPM, i);
        }
    }

    public final void u(au auVar) {
        if (SN()) {
            a(auVar, b.hPM, 0);
        }
    }

    public final void c(au auVar, int i) {
        if (SN()) {
            a(auVar, b.hPO, i);
        }
    }

    public final void v(au auVar) {
        if (SN()) {
            a(auVar, b.hPO, 0);
        }
    }

    public final void w(au auVar) {
        if (SN()) {
            a(auVar, b.hPK, 0);
        }
    }

    public final void x(au auVar) {
        if (SN()) {
            a(auVar, b.hPP, 0);
        }
    }

    public final void a(au auVar, boolean z) {
        if (SN() && auVar.cjg()) {
            a(auVar, z ? b.hPQ : b.hPR, 0);
        }
    }

    public final void y(au auVar) {
        if (SN()) {
            a(auVar, b.hPT, 0);
        }
    }

    public final void a(au auVar, boolean z, int i) {
        if (SN()) {
            a(auVar, z ? b.hPU : b.hPV, i);
        }
    }

    private String SM() {
        if (this.hPz == null) {
            return "";
        }
        String str = ",";
        LinkedList linkedList = new LinkedList();
        synchronized (this.lock) {
            linkedList.addAll(this.hPz.oplist_);
        }
        Iterator it = linkedList.iterator();
        int i = 1;
        while (it.hasNext()) {
            StringBuilder append;
            String str2;
            IMBehavior iMBehavior = (IMBehavior) it.next();
            if (i == 0) {
                str = str + "|";
            }
            str = str + iMBehavior.opType + "#";
            if (iMBehavior.opType == 1) {
                append = new StringBuilder().append(str);
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                str2 = "";
                if (iMBehaviorChattingOP.changeUnread != 0) {
                    str2 = str2 + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                }
                if (iMBehaviorChattingOP.changeTop != 0) {
                    str2 = str2 + "changeTop=" + iMBehaviorChattingOP.changeTop;
                }
                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                    str2 = str2 + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                }
                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                    str2 = str2 + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                }
                if (iMBehaviorChattingOP.expose != 0) {
                    str2 = str2 + "expose=" + iMBehaviorChattingOP.expose;
                }
            } else {
                append = new StringBuilder().append(str);
                if (iMBehavior.msgOp.msgType == 49) {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.appMsgInnerType), Integer.valueOf(iMBehavior.msgOp.count)});
                } else {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.count)});
                }
            }
            str = append.append(str2).toString();
            i = 0;
        }
        return str + "," + this.hPz.currChatName_;
    }

    public final boolean SN() {
        if (!this.hasInit) {
            this.hasInit = true;
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100148");
                if (fn.isValid()) {
                    this.hPB = bh.getInt((String) fn.chI().get("needUploadData"), 1);
                }
                fn = com.tencent.mm.z.c.c.IF().fn("100149");
                if (fn.isValid()) {
                    this.hPC = bh.getInt((String) fn.chI().get("needUploadData"), 1);
                }
            } else {
                x.w("MicroMsg.ChattingOperationUitl", "account has not ready");
            }
        }
        return (this.hPB == 0 && this.hPC == 0) ? false : true;
    }
}
