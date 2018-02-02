package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.p.l;
import java.util.ArrayList;
import java.util.Iterator;

public class a$e {
    public ArrayList<f> fBU = new ArrayList();
    public String hbM;
    public String iML;
    public String iMM;
    public String iMN;
    public String iMO;

    public final boolean qA(String str) {
        Iterator it = this.fBU.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).url.equals(l.uB(str))) {
                return true;
            }
        }
        return false;
    }
}
