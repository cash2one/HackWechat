package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class h$a {
    public String imS;
    public long mgn;
    public long mgo;
    public boolean mgp;
    public long mgq;
    public String mgr;
    public boolean mgs;
    public boolean mgt;
    public int type;

    public h$a(int i, String str) {
        this.type = i;
        this.mgr = str;
        switch (this.type) {
            case 0:
                this.mgn = 30;
                this.mgo = 7000;
                this.imS = ac.getContext().getString(h.mez);
                this.mgp = true;
                this.mgq = 2500;
                this.mgs = false;
                this.mgt = false;
                return;
            case 1:
                this.mgn = 30;
                this.mgo = 7000;
                this.imS = ac.getContext().getString(h.mdV);
                this.mgp = false;
                this.mgq = -1;
                this.mgs = true;
                this.mgt = true;
                return;
            case 2:
                this.mgn = 30;
                this.mgo = 7000;
                this.imS = ac.getContext().getString(h.mdW);
                this.mgp = false;
                this.mgq = -1;
                this.mgs = true;
                this.mgt = true;
                return;
            case 3:
                this.mgn = 30;
                this.mgo = 7000;
                this.imS = ac.getContext().getString(h.mdU);
                this.mgp = true;
                this.mgq = -1;
                this.mgs = true;
                this.mgt = true;
                return;
            case 4:
                this.mgn = 30;
                this.mgo = 7000;
                this.imS = ac.getContext().getString(h.mdX);
                this.mgp = true;
                this.mgq = 1000;
                this.mgs = true;
                this.mgt = true;
                return;
            default:
                x.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                this.type = 100;
                return;
        }
    }

    public final String toString() {
        return "FaceProcessItem{type=" + this.type + ", frameTween=" + this.mgn + ", hintTween=" + this.mgo + ", hintStr='" + this.imS + '\'' + ", isCheckFace=" + this.mgp + ", minSuccTime=" + this.mgq + ", actionData='" + this.mgr + '\'' + '}';
    }
}
