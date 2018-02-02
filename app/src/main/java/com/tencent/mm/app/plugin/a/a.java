package com.tencent.mm.app.plugin.a;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public p fhr;
    public b fhs;
    public a fht;
    private String fhu;
    public Map<String, Boolean> fhv;
    public boolean fhw = true;

    class a extends c<cv> {
        final /* synthetic */ a fhy;

        a(a aVar) {
            this.fhy = aVar;
            this.xen = cv.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((cv) bVar).frd.fhw = this.fhy.fhw;
            return true;
        }
    }

    public a(p pVar) {
        x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.fhr = pVar;
        if (this.fhs == null) {
            this.fhs = new b(this);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.fhs);
        if (this.fht == null) {
            this.fht = new a(this);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.fht);
    }

    final synchronized void e(int i, String str, String str2) {
        x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[]{Integer.valueOf(i)});
        if (this.fhr != null && !bh.ov(str)) {
            d jS = f.jS(str);
            if (a(jS)) {
                if (this.fhv == null) {
                    this.fhv = new HashMap();
                }
                Map map = this.fhv;
                if (!str.equals(this.fhu)) {
                    this.fhu = str;
                    map.clear();
                }
                if (jS.bI(false).Ly().hpb != 1) {
                    x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[]{map, str2});
                    switch (i) {
                        case -1:
                            this.fhr.csq().setMMSubTitle(null);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.fhr.csq().setMMSubTitle(R.l.edd);
                                break;
                            }
                            break;
                        case 1:
                            if (map.size() == 0) {
                                this.fhr.csq().setMMSubTitle(R.l.edc);
                                break;
                            }
                            break;
                        case 2:
                            map.put(str2, Boolean.valueOf(true));
                            this.fhr.csq().setMMSubTitle(this.fhr.csq().getString(R.l.edb, new Object[]{Integer.valueOf(map.size())}));
                            x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[]{str2});
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[]{str2});
                            }
                            this.fhr.csq().setMMSubTitle(this.fhr.csq().getString(R.l.edb, new Object[]{Integer.valueOf(map.size())}));
                            break;
                        default:
                            break;
                    }
                }
                this.fhr.csq().setMMSubTitle(null);
            } else {
                x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[]{str});
            }
        } else {
            x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
        }
    }

    public final void a(final int i, d dVar) {
        if (this.fhr == null) {
            x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
        } else if (s.gF(this.fhr.crz()) && a(dVar)) {
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ a fhy;

                public final void run() {
                    b duVar;
                    if (1 == i) {
                        duVar = new du();
                        duVar.fss.op = 0;
                        duVar.fss.userName = this.fhy.fhr.crz();
                        duVar.fss.context = this.fhy.fhr.csq().getContext();
                        com.tencent.mm.sdk.b.a.xef.m(duVar);
                        if (this.fhy.fhr.crz().equals("gh_43f2581f6fd6")) {
                            duVar = new qo();
                            duVar.fIh.action = 1;
                            com.tencent.mm.sdk.b.a.xef.a(duVar, Looper.getMainLooper());
                        }
                    }
                    duVar = new jc();
                    duVar.fzE.opType = i;
                    duVar.fzE.fzG = 1;
                    duVar.fzE.fzF = this.fhy.fhr.crz();
                    com.tencent.mm.sdk.b.a.xef.m(duVar);
                }
            });
        }
    }

    public static boolean a(d dVar) {
        if (dVar == null || dVar == null) {
            return false;
        }
        d.b bI = dVar.bI(false);
        if (bI == null || bI.Ly() == null || !bI.Ly().LH()) {
            return false;
        }
        return true;
    }
}
