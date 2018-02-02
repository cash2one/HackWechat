package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class s implements Serializable {
    public int fpn;
    public float height;
    public String qZM;
    public String rgK;
    public int rgL;
    public float rgM;
    public float rgN;
    public float rgO;
    public float rgP;
    public float rgQ = -2.0f;
    public float rgR = -2.0f;
    public boolean rgS;
    public String rgT = "";
    public int rgU;
    public int rgV;
    public boolean rgW;
    public boolean rgX;
    public int rgY;
    public boolean rgZ;
    public int rha;
    public int type;
    public String uin;
    public float width;

    public final void wV(int i) {
        this.rgY = i;
        for (s wV : bwM()) {
            wV.wV(i);
        }
    }

    public final void iB(boolean z) {
        this.rgZ = z;
        for (s iB : bwM()) {
            iB.iB(z);
        }
    }

    public final void KW(String str) {
        this.qZM = str;
        for (s KW : bwM()) {
            KW.KW(str);
        }
    }

    public final void KX(String str) {
        this.uin = str;
        for (s KX : bwM()) {
            KX.KX(str);
        }
    }

    public final void wW(int i) {
        this.rha = i;
        for (s wW : bwM()) {
            wW.wW(i);
        }
    }

    protected List<s> bwM() {
        return Collections.emptyList();
    }
}
