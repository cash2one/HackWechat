package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import java.util.List;

class e$24 extends c<dh> {
    final /* synthetic */ e lLO;

    e$24(e eVar) {
        this.lLO = eVar;
        this.xen = dh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dh dhVar = (dh) bVar;
        long j = dhVar.frQ.fqm;
        String str = dhVar.frQ.frH;
        List<com.tencent.mm.plugin.exdevice.h.b> aEO = ad.aEk().aEO();
        if (aEO.size() > 0) {
            boolean z;
            if (j == -1 || j == Long.MIN_VALUE) {
                z = false;
            } else {
                ar.Hg();
                cf dH = com.tencent.mm.z.c.Fa().dH(j);
                if (dH.field_msgId == 0) {
                    z = false;
                } else {
                    int type = dH.getType();
                    String str2 = dH.field_content;
                    String str3;
                    if (dH.aNc()) {
                        a fT = a.fT(str2);
                        if (fT == null) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                            z = false;
                        } else if (fT.type == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : aEO) {
                                str3 = bVar2.gfT;
                                if (str3 != null && str3.contains("wxmsg_music")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (fT.type == 4) {
                            z = false;
                        } else if (fT.type == 6) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : aEO) {
                                str3 = bVar22.gfT;
                                if (str3 != null && str3.contains("wxmsg_file")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (fT.type == 5) {
                            z = e.e(fT.url, aEO);
                        } else {
                            if (fT.type == 2) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222 : aEO) {
                                    str3 = bVar222.gfT;
                                    if (str3 != null && str3.contains("wxmsg_image")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            }
                            z = false;
                        }
                    } else if (type == 3) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : aEO) {
                            str3 = bVar2222.gfT;
                            if (str3 != null && str3.contains("wxmsg_image")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else if (type == 48) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : aEO) {
                            str3 = bVar22222.gfT;
                            if (str3 != null && str3.contains("wxmsg_poi")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else {
                        if (type == 62) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : aEO) {
                                str3 = bVar222222.gfT;
                                if (str3 != null && str3.contains("wxmsg_video")) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                    }
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                }
            }
            if (z || e.f(str, aEO)) {
                dhVar.frR.frp = true;
                return true;
            }
        }
        dhVar.frR.frp = false;
        return true;
    }
}
