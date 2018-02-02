package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
    List<a> gxL;
    long poD = 0;
    private e poE;
    a poF;
    private int poG = 0;
    int poH = 1;
    private int poI = 2;
    int poJ = 3;
    int status = this.poG;

    j(String str) {
        this.poE = new e(str, 1);
        byte[] readFromFile = e.readFromFile(this.poE.pol + "address");
        if (readFromFile != null) {
            this.poE.a("address", null, readFromFile);
            b.deleteFile(this.poE.pol + "address");
        } else {
            readFromFile = this.poE.k("address", null);
        }
        if (readFromFile != null) {
            try {
                this.poF = new a().aE(readFromFile);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.poF = new a();
                this.poF.HE("");
            }
        } else {
            this.poF = new a();
            this.poF.HE("");
        }
        this.gxL = new ArrayList();
    }

    protected final void finalize() {
        this.gxL.clear();
    }

    public final List<i> HJ(String str) {
        List<i> list = this.poF.pnY;
        if (this.status <= this.poH) {
            bki();
            return list;
        } else if (str == null || str.length() == 0) {
            return list;
        } else {
            List<i> arrayList = new ArrayList();
            for (i iVar : list) {
                if (iVar != null && ((iVar.name != null && iVar.name.contains(str)) || ((iVar.poC != null && iVar.poC.contains(str)) || (iVar.nQt != null && iVar.nQt.contains(str))))) {
                    a.b(iVar);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
    }

    public final void bki() {
        if (this.status != this.poI) {
            if (bh.Wp() - this.poD <= 600000) {
                for (a onComplete : this.gxL) {
                    onComplete.onComplete();
                }
                return;
            }
            this.status = this.poI;
            Map hashMap = new HashMap();
            hashMap.put("syncinfo", this.poF.pnW == null ? "" : this.poF.pnW);
            x.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[]{"sync~~~"});
            w.bks().b("/cgi-bin/syncaddrlist", hashMap, new c(), new 1(this));
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.gxL) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.gxL.add(aVar);
    }

    public final void b(a aVar) {
        for (a aVar2 : this.gxL) {
            if (aVar2 == aVar) {
                this.gxL.remove(aVar2);
                return;
            }
        }
    }

    public final void bp(List<i> list) {
        a aVar = this.poF;
        if (!(list == null || list.size() == 0)) {
            for (i iVar : list) {
                Iterator it = aVar.pnY.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i iVar2 = (i) it.next();
                    if (iVar2.nQt.equalsIgnoreCase(iVar.nQt)) {
                        aVar.uY(i);
                        iVar2.poB++;
                        aVar.a(iVar2);
                        break;
                    }
                    i++;
                }
            }
        }
        save();
    }

    final void save() {
        try {
            this.poE.a("address", null, this.poF.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
        }
    }

    public static i HK(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            return null;
        }
        i iVar = new i();
        iVar.name = trim.substring(0, lastIndexOf);
        iVar.nQt = trim.substring(lastIndexOf + 1);
        return iVar;
    }
}
