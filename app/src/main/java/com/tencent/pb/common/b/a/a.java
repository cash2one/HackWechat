package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import org.xwalk.core.R$styleable;

public interface a {

    public static final class ad extends e {
        public String groupId;
        public int slB;
        public long slC;
        public String zMM;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.slB = aVar.ry();
                        continue;
                    case 24:
                        this.slC = aVar.rz();
                        continue;
                    case 34:
                        this.zMM = aVar.readString();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ad() {
            this.groupId = "";
            this.slB = 0;
            this.slC = 0;
            this.zMM = "";
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.slB != 0) {
                bVar.aB(2, this.slB);
            }
            if (this.slC != 0) {
                bVar.k(3, this.slC);
            }
            if (!this.zMM.equals("")) {
                bVar.g(4, this.zMM);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (!this.groupId.equals("")) {
                rL += b.h(1, this.groupId);
            }
            if (this.slB != 0) {
                rL += b.aD(2, this.slB);
            }
            if (this.slC != 0) {
                rL += b.m(3, this.slC);
            }
            if (this.zMM.equals("")) {
                return rL;
            }
            return rL + b.h(4, this.zMM);
        }
    }

    public static final class af extends e {
        public int nDx;
        public long nDy;
        public int zOs;
        public int zOt;
        public int zOu;
        public int zOv;
        public int zOw;
        public int zOx;
        public int zOy;
        public int zOz;

        public af() {
            this.zOs = 0;
            this.nDx = 0;
            this.nDy = 0;
            this.zOt = 0;
            this.zOu = 0;
            this.zOv = 0;
            this.zOw = 0;
            this.zOx = 0;
            this.zOy = -1;
            this.zOz = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.zOs = aVar.ry();
                        continue;
                    case 16:
                        this.nDx = aVar.ry();
                        continue;
                    case 24:
                        this.nDy = aVar.rz();
                        continue;
                    case 32:
                        this.zOt = aVar.ry();
                        continue;
                    case 40:
                        this.zOu = aVar.ry();
                        continue;
                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zOv = aVar.ry();
                        continue;
                    case 56:
                        this.zOw = aVar.ry();
                        continue;
                    case 64:
                        this.zOx = aVar.ry();
                        continue;
                    case 72:
                        this.zOy = aVar.ry();
                        continue;
                    case 80:
                        this.zOz = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(b bVar) {
            if (this.zOs != 0) {
                bVar.aC(1, this.zOs);
            }
            if (this.nDx != 0) {
                bVar.aB(2, this.nDx);
            }
            if (this.nDy != 0) {
                bVar.k(3, this.nDy);
            }
            if (this.zOt != 0) {
                bVar.aC(4, this.zOt);
            }
            if (this.zOu != 0) {
                bVar.aC(5, this.zOu);
            }
            if (this.zOv != 0) {
                bVar.aC(6, this.zOv);
            }
            if (this.zOw != 0) {
                bVar.aC(7, this.zOw);
            }
            if (this.zOx != 0) {
                bVar.aC(8, this.zOx);
            }
            if (this.zOy != -1) {
                bVar.aB(9, this.zOy);
            }
            if (this.zOz != 0) {
                bVar.aB(10, this.zOz);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.zOs != 0) {
                rL += b.aE(1, this.zOs);
            }
            if (this.nDx != 0) {
                rL += b.aD(2, this.nDx);
            }
            if (this.nDy != 0) {
                rL += b.m(3, this.nDy);
            }
            if (this.zOt != 0) {
                rL += b.aE(4, this.zOt);
            }
            if (this.zOu != 0) {
                rL += b.aE(5, this.zOu);
            }
            if (this.zOv != 0) {
                rL += b.aE(6, this.zOv);
            }
            if (this.zOw != 0) {
                rL += b.aE(7, this.zOw);
            }
            if (this.zOx != 0) {
                rL += b.aE(8, this.zOx);
            }
            if (this.zOy != -1) {
                rL += b.aD(9, this.zOy);
            }
            return this.zOz != 0 ? rL + b.aD(10, this.zOz) : rL;
        }
    }

    public static final class am extends e {
        private static volatile am[] zOB;
        public int nEd;
        public int vCD;
        public String zOC;
        public int zOD;

        public am() {
            this.nEd = 0;
            this.zOC = "";
            this.vCD = 0;
            this.zOD = 0;
            this.bfQ = -1;
        }

        public static am[] cCM() {
            if (zOB == null) {
                synchronized (c.bfP) {
                    if (zOB == null) {
                        zOB = new am[0];
                    }
                }
            }
            return zOB;
        }

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.nEd = aVar.ry();
                        continue;
                    case 18:
                        this.zOC = aVar.readString();
                        continue;
                    case 24:
                        this.vCD = aVar.ry();
                        continue;
                    case 32:
                        this.zOD = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(b bVar) {
            if (this.nEd != 0) {
                bVar.aC(1, this.nEd);
            }
            if (!this.zOC.equals("")) {
                bVar.g(2, this.zOC);
            }
            if (this.vCD != 0) {
                bVar.aC(3, this.vCD);
            }
            if (this.zOD != 0) {
                bVar.aC(4, this.zOD);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.nEd != 0) {
                rL += b.aE(1, this.nEd);
            }
            if (!this.zOC.equals("")) {
                rL += b.h(2, this.zOC);
            }
            if (this.vCD != 0) {
                rL += b.aE(3, this.vCD);
            }
            return this.zOD != 0 ? rL + b.aE(4, this.zOD) : rL;
        }
    }

    public static final class at extends e {
        public byte[] bjO;
        public int fvx;
        public String name;
        public byte[] zOX;
        public long zOY;
        public byte[] zOZ;
        public byte[] zPa;
        public byte[] zPb;
        public ax zPc;
        public byte[] zPd;
        public ap zPe;
        public String zPf;
        public String zPg;
        public long zPh;
        public byte[] zPi;
        public byte[] zPj;
        public byte[] zPk;
        public byte[] zPl;
        public int zPm;
        public byte[] zPn;
        public byte[] zPo;
        public int zPp;
        public n[] zPq;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        this.name = aVar.readString();
                        continue;
                    case 18:
                        this.zOX = aVar.readBytes();
                        continue;
                    case 24:
                        this.fvx = aVar.ry();
                        continue;
                    case 32:
                        this.zOY = aVar.rz();
                        continue;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zOZ = aVar.readBytes();
                        continue;
                    case 50:
                        this.zPa = aVar.readBytes();
                        continue;
                    case 58:
                        this.zPb = aVar.readBytes();
                        continue;
                    case 66:
                        if (this.zPc == null) {
                            this.zPc = new ax();
                        }
                        aVar.a(this.zPc);
                        continue;
                    case 74:
                        this.zPd = aVar.readBytes();
                        continue;
                    case 82:
                        if (this.zPe == null) {
                            this.zPe = new ap();
                        }
                        aVar.a(this.zPe);
                        continue;
                    case 802:
                        this.zPf = aVar.readString();
                        continue;
                    case 810:
                        this.zPg = aVar.readString();
                        continue;
                    case 1600:
                        this.zPh = aVar.rz();
                        continue;
                    case 1610:
                        this.zPi = aVar.readBytes();
                        continue;
                    case 1618:
                        this.zPj = aVar.readBytes();
                        continue;
                    case 1626:
                        this.zPk = aVar.readBytes();
                        continue;
                    case 1634:
                        this.zPl = aVar.readBytes();
                        continue;
                    case 1760:
                        this.zPm = aVar.ry();
                        continue;
                    case 1770:
                        this.zPn = aVar.readBytes();
                        continue;
                    case 1778:
                        this.zPo = aVar.readBytes();
                        continue;
                    case 1786:
                        this.bjO = aVar.readBytes();
                        continue;
                    case 1792:
                        this.zPp = aVar.ry();
                        continue;
                    case 1802:
                        int b = g.b(aVar, 1802);
                        rx = this.zPq == null ? 0 : this.zPq.length;
                        Object obj = new n[(b + rx)];
                        if (rx != 0) {
                            System.arraycopy(this.zPq, 0, obj, 0, rx);
                        }
                        while (rx < obj.length - 1) {
                            obj[rx] = new n();
                            aVar.a(obj[rx]);
                            aVar.rx();
                            rx++;
                        }
                        obj[rx] = new n();
                        aVar.a(obj[rx]);
                        this.zPq = obj;
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public at() {
            this.name = "";
            this.zOX = g.bfX;
            this.fvx = 0;
            this.zOY = 0;
            this.zOZ = g.bfX;
            this.zPa = g.bfX;
            this.zPb = g.bfX;
            this.zPc = null;
            this.zPd = g.bfX;
            this.zPe = null;
            this.zPf = "";
            this.zPg = "";
            this.zPh = 0;
            this.zPi = g.bfX;
            this.zPj = g.bfX;
            this.zPk = g.bfX;
            this.zPl = g.bfX;
            this.zPm = 0;
            this.zPn = g.bfX;
            this.zPo = g.bfX;
            this.bjO = g.bfX;
            this.zPp = 0;
            this.zPq = n.cCJ();
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (!this.name.equals("")) {
                bVar.g(1, this.name);
            }
            if (!Arrays.equals(this.zOX, g.bfX)) {
                bVar.a(2, this.zOX);
            }
            if (this.fvx != 0) {
                bVar.aB(3, this.fvx);
            }
            if (this.zOY != 0) {
                bVar.j(4, this.zOY);
            }
            if (!Arrays.equals(this.zOZ, g.bfX)) {
                bVar.a(5, this.zOZ);
            }
            if (!Arrays.equals(this.zPa, g.bfX)) {
                bVar.a(6, this.zPa);
            }
            if (!Arrays.equals(this.zPb, g.bfX)) {
                bVar.a(7, this.zPb);
            }
            if (this.zPc != null) {
                bVar.a(8, this.zPc);
            }
            if (!Arrays.equals(this.zPd, g.bfX)) {
                bVar.a(9, this.zPd);
            }
            if (this.zPe != null) {
                bVar.a(10, this.zPe);
            }
            if (!this.zPf.equals("")) {
                bVar.g(100, this.zPf);
            }
            if (!this.zPg.equals("")) {
                bVar.g(101, this.zPg);
            }
            if (this.zPh != 0) {
                bVar.j(200, this.zPh);
            }
            if (!Arrays.equals(this.zPi, g.bfX)) {
                bVar.a(201, this.zPi);
            }
            if (!Arrays.equals(this.zPj, g.bfX)) {
                bVar.a(202, this.zPj);
            }
            if (!Arrays.equals(this.zPk, g.bfX)) {
                bVar.a(203, this.zPk);
            }
            if (!Arrays.equals(this.zPl, g.bfX)) {
                bVar.a(d.CTRL_INDEX, this.zPl);
            }
            if (this.zPm != 0) {
                bVar.aB(220, this.zPm);
            }
            if (!Arrays.equals(this.zPn, g.bfX)) {
                bVar.a(221, this.zPn);
            }
            if (!Arrays.equals(this.zPo, g.bfX)) {
                bVar.a(222, this.zPo);
            }
            if (!Arrays.equals(this.bjO, g.bfX)) {
                bVar.a(223, this.bjO);
            }
            if (this.zPp != 0) {
                bVar.aC(224, this.zPp);
            }
            if (this.zPq != null && this.zPq.length > 0) {
                for (e eVar : this.zPq) {
                    if (eVar != null) {
                        bVar.a(225, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (!this.name.equals("")) {
                rL += b.h(1, this.name);
            }
            if (!Arrays.equals(this.zOX, g.bfX)) {
                rL += b.b(2, this.zOX);
            }
            if (this.fvx != 0) {
                rL += b.aD(3, this.fvx);
            }
            if (this.zOY != 0) {
                rL += b.l(4, this.zOY);
            }
            if (!Arrays.equals(this.zOZ, g.bfX)) {
                rL += b.b(5, this.zOZ);
            }
            if (!Arrays.equals(this.zPa, g.bfX)) {
                rL += b.b(6, this.zPa);
            }
            if (!Arrays.equals(this.zPb, g.bfX)) {
                rL += b.b(7, this.zPb);
            }
            if (this.zPc != null) {
                rL += b.b(8, this.zPc);
            }
            if (!Arrays.equals(this.zPd, g.bfX)) {
                rL += b.b(9, this.zPd);
            }
            if (this.zPe != null) {
                rL += b.b(10, this.zPe);
            }
            if (!this.zPf.equals("")) {
                rL += b.h(100, this.zPf);
            }
            if (!this.zPg.equals("")) {
                rL += b.h(101, this.zPg);
            }
            if (this.zPh != 0) {
                rL += b.l(200, this.zPh);
            }
            if (!Arrays.equals(this.zPi, g.bfX)) {
                rL += b.b(201, this.zPi);
            }
            if (!Arrays.equals(this.zPj, g.bfX)) {
                rL += b.b(202, this.zPj);
            }
            if (!Arrays.equals(this.zPk, g.bfX)) {
                rL += b.b(203, this.zPk);
            }
            if (!Arrays.equals(this.zPl, g.bfX)) {
                rL += b.b(d.CTRL_INDEX, this.zPl);
            }
            if (this.zPm != 0) {
                rL += b.aD(220, this.zPm);
            }
            if (!Arrays.equals(this.zPn, g.bfX)) {
                rL += b.b(221, this.zPn);
            }
            if (!Arrays.equals(this.zPo, g.bfX)) {
                rL += b.b(222, this.zPo);
            }
            if (!Arrays.equals(this.bjO, g.bfX)) {
                rL += b.b(223, this.bjO);
            }
            if (this.zPp != 0) {
                rL += b.aE(224, this.zPp);
            }
            if (this.zPq == null || this.zPq.length <= 0) {
                return rL;
            }
            int i = rL;
            for (e eVar : this.zPq) {
                if (eVar != null) {
                    i += b.b(225, eVar);
                }
            }
            return i;
        }
    }

    public static final class au extends e {
        private static volatile au[] zPr;
        public String groupId;
        public int slB;
        public long slC;
        public int zMR;
        public av[] zOe;
        public String zPs;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.slB = aVar.ry();
                        continue;
                    case 24:
                        this.slC = aVar.rz();
                        continue;
                    case 34:
                        int b = g.b(aVar, 34);
                        rx = this.zOe == null ? 0 : this.zOe.length;
                        Object obj = new av[(b + rx)];
                        if (rx != 0) {
                            System.arraycopy(this.zOe, 0, obj, 0, rx);
                        }
                        while (rx < obj.length - 1) {
                            obj[rx] = new av();
                            aVar.a(obj[rx]);
                            aVar.rx();
                            rx++;
                        }
                        obj[rx] = new av();
                        aVar.a(obj[rx]);
                        this.zOe = obj;
                        continue;
                    case 40:
                        this.zMR = aVar.ry();
                        continue;
                    case 50:
                        this.zPs = aVar.readString();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static au[] cCP() {
            if (zPr == null) {
                synchronized (c.bfP) {
                    if (zPr == null) {
                        zPr = new au[0];
                    }
                }
            }
            return zPr;
        }

        public au() {
            this.groupId = "";
            this.slB = 0;
            this.slC = 0;
            this.zOe = av.cCQ();
            this.zMR = 0;
            this.zPs = "";
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.slB != 0) {
                bVar.aB(2, this.slB);
            }
            if (this.slC != 0) {
                bVar.k(3, this.slC);
            }
            if (this.zOe != null && this.zOe.length > 0) {
                for (e eVar : this.zOe) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zMR != 0) {
                bVar.aC(5, this.zMR);
            }
            if (!this.zPs.equals("")) {
                bVar.g(6, this.zPs);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (!this.groupId.equals("")) {
                rL += b.h(1, this.groupId);
            }
            if (this.slB != 0) {
                rL += b.aD(2, this.slB);
            }
            if (this.slC != 0) {
                rL += b.m(3, this.slC);
            }
            if (this.zOe != null && this.zOe.length > 0) {
                int i = rL;
                for (e eVar : this.zOe) {
                    if (eVar != null) {
                        i += b.b(4, eVar);
                    }
                }
                rL = i;
            }
            if (this.zMR != 0) {
                rL += b.aE(5, this.zMR);
            }
            if (this.zPs.equals("")) {
                return rL;
            }
            return rL + b.h(6, this.zPs);
        }
    }

    public static final class av extends e {
        private static volatile av[] zPt;
        public int aAk;
        public int nEd;
        public int status;
        public int swC;
        public int vCD;
        public int zMX;
        public byte[] zNc;
        public String zOC;
        public int zPA;
        public int[] zPB;
        public int zPC;
        public int zPD;
        public int zPE;
        public int zPF;
        public an zPG;
        public String zPH;
        public int zPI;
        public s zPJ;
        public int zPK;
        public String zPL;
        public int zPM;
        public int zPN;
        public int zPO;
        public int zPP;
        public int zPu;
        public int zPv;
        public aq zPw;
        public int zPx;
        public String zPy;
        public ar[] zPz;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                int b;
                Object obj;
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.vCD = aVar.ry();
                        continue;
                    case 16:
                        this.zPu = aVar.ry();
                        continue;
                    case 24:
                        this.status = aVar.ry();
                        continue;
                    case 32:
                        this.aAk = aVar.ry();
                        continue;
                    case 40:
                        this.nEd = aVar.ry();
                        continue;
                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zPv = aVar.ry();
                        continue;
                    case 58:
                        if (this.zPw == null) {
                            this.zPw = new aq();
                        }
                        aVar.a(this.zPw);
                        continue;
                    case 64:
                        this.zPx = aVar.ry();
                        continue;
                    case 74:
                        this.zPy = aVar.readString();
                        continue;
                    case 82:
                        b = g.b(aVar, 82);
                        rx = this.zPz == null ? 0 : this.zPz.length;
                        obj = new ar[(b + rx)];
                        if (rx != 0) {
                            System.arraycopy(this.zPz, 0, obj, 0, rx);
                        }
                        while (rx < obj.length - 1) {
                            obj[rx] = new ar();
                            aVar.a(obj[rx]);
                            aVar.rx();
                            rx++;
                        }
                        obj[rx] = new ar();
                        aVar.a(obj[rx]);
                        this.zPz = obj;
                        continue;
                    case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zPA = aVar.ry();
                        continue;
                    case 96:
                        b = g.b(aVar, 96);
                        rx = this.zPB == null ? 0 : this.zPB.length;
                        obj = new int[(b + rx)];
                        if (rx != 0) {
                            System.arraycopy(this.zPB, 0, obj, 0, rx);
                        }
                        while (rx < obj.length - 1) {
                            obj[rx] = aVar.ry();
                            aVar.rx();
                            rx++;
                        }
                        obj[rx] = aVar.ry();
                        this.zPB = obj;
                        continue;
                    case 98:
                        int dQ = aVar.dQ(aVar.ry());
                        b = aVar.getPosition();
                        rx = 0;
                        while (aVar.rB() > 0) {
                            aVar.ry();
                            rx++;
                        }
                        aVar.dS(b);
                        b = this.zPB == null ? 0 : this.zPB.length;
                        Object obj2 = new int[(rx + b)];
                        if (b != 0) {
                            System.arraycopy(this.zPB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.ry();
                            b++;
                        }
                        this.zPB = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 104:
                        this.zPC = aVar.ry();
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.zPD = aVar.ry();
                        continue;
                    case 120:
                        this.zPE = aVar.ry();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.zPF = aVar.ry();
                        continue;
                    case 138:
                        if (this.zPG == null) {
                            this.zPG = new an();
                        }
                        aVar.a(this.zPG);
                        continue;
                    case 802:
                        this.zOC = aVar.readString();
                        continue;
                    case 810:
                        this.zPH = aVar.readString();
                        continue;
                    case 816:
                        this.zPI = aVar.ry();
                        continue;
                    case 1602:
                        this.zNc = aVar.readBytes();
                        continue;
                    case 1610:
                        if (this.zPJ == null) {
                            this.zPJ = new s();
                        }
                        aVar.a(this.zPJ);
                        continue;
                    case 1616:
                        this.zPK = aVar.ry();
                        continue;
                    case 1626:
                        this.zPL = aVar.readString();
                        continue;
                    case 1632:
                        this.zPM = aVar.ry();
                        continue;
                    case 1640:
                        this.zPN = aVar.ry();
                        continue;
                    case 1648:
                        this.swC = aVar.ry();
                        continue;
                    case 1656:
                        this.zPO = aVar.ry();
                        continue;
                    case 1664:
                        this.zPP = aVar.ry();
                        continue;
                    case 1920:
                        this.zMX = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static av[] cCQ() {
            if (zPt == null) {
                synchronized (c.bfP) {
                    if (zPt == null) {
                        zPt = new av[0];
                    }
                }
            }
            return zPt;
        }

        public av() {
            this.vCD = 0;
            this.zPu = 0;
            this.status = 0;
            this.aAk = 0;
            this.nEd = -1;
            this.zPv = 0;
            this.zPw = null;
            this.zPx = 0;
            this.zPy = "";
            this.zPz = ar.cCO();
            this.zPA = 0;
            this.zPB = g.bfR;
            this.zPC = 0;
            this.zPD = 0;
            this.zPE = 0;
            this.zPF = 0;
            this.zPG = null;
            this.zOC = "";
            this.zPH = "";
            this.zPI = 0;
            this.zNc = g.bfX;
            this.zPJ = null;
            this.zPK = -1;
            this.zPL = "";
            this.zPM = 0;
            this.zPN = 0;
            this.swC = 0;
            this.zPO = 0;
            this.zPP = 0;
            this.zMX = 0;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            int i = 0;
            if (this.vCD != 0) {
                bVar.aC(1, this.vCD);
            }
            if (this.zPu != 0) {
                bVar.aC(2, this.zPu);
            }
            if (this.status != 0) {
                bVar.aC(3, this.status);
            }
            if (this.aAk != 0) {
                bVar.aC(4, this.aAk);
            }
            if (this.nEd != -1) {
                bVar.aB(5, this.nEd);
            }
            if (this.zPv != 0) {
                bVar.aC(6, this.zPv);
            }
            if (this.zPw != null) {
                bVar.a(7, this.zPw);
            }
            if (this.zPx != 0) {
                bVar.aC(8, this.zPx);
            }
            if (!this.zPy.equals("")) {
                bVar.g(9, this.zPy);
            }
            if (this.zPz != null && this.zPz.length > 0) {
                for (e eVar : this.zPz) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.zPA != 0) {
                bVar.aC(11, this.zPA);
            }
            if (this.zPB != null && this.zPB.length > 0) {
                while (i < this.zPB.length) {
                    bVar.aC(12, this.zPB[i]);
                    i++;
                }
            }
            if (this.zPC != 0) {
                bVar.aC(13, this.zPC);
            }
            if (this.zPD != 0) {
                bVar.aC(14, this.zPD);
            }
            if (this.zPE != 0) {
                bVar.aC(15, this.zPE);
            }
            if (this.zPF != 0) {
                bVar.aC(16, this.zPF);
            }
            if (this.zPG != null) {
                bVar.a(17, this.zPG);
            }
            if (!this.zOC.equals("")) {
                bVar.g(100, this.zOC);
            }
            if (!this.zPH.equals("")) {
                bVar.g(101, this.zPH);
            }
            if (this.zPI != 0) {
                bVar.aC(102, this.zPI);
            }
            if (!Arrays.equals(this.zNc, g.bfX)) {
                bVar.a(200, this.zNc);
            }
            if (this.zPJ != null) {
                bVar.a(201, this.zPJ);
            }
            if (this.zPK != -1) {
                bVar.aB(202, this.zPK);
            }
            if (!this.zPL.equals("")) {
                bVar.g(203, this.zPL);
            }
            if (this.zPM != 0) {
                bVar.aB(d.CTRL_INDEX, this.zPM);
            }
            if (this.zPN != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, this.zPN);
            }
            if (this.swC != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this.swC);
            }
            if (this.zPO != 0) {
                bVar.aC(207, this.zPO);
            }
            if (this.zPP != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, this.zPP);
            }
            if (this.zMX != 0) {
                bVar.aC(240, this.zMX);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int i;
            int i2 = 0;
            int rL = super.rL();
            if (this.vCD != 0) {
                rL += b.aE(1, this.vCD);
            }
            if (this.zPu != 0) {
                rL += b.aE(2, this.zPu);
            }
            if (this.status != 0) {
                rL += b.aE(3, this.status);
            }
            if (this.aAk != 0) {
                rL += b.aE(4, this.aAk);
            }
            if (this.nEd != -1) {
                rL += b.aD(5, this.nEd);
            }
            if (this.zPv != 0) {
                rL += b.aE(6, this.zPv);
            }
            if (this.zPw != null) {
                rL += b.b(7, this.zPw);
            }
            if (this.zPx != 0) {
                rL += b.aE(8, this.zPx);
            }
            if (!this.zPy.equals("")) {
                rL += b.h(9, this.zPy);
            }
            if (this.zPz != null && this.zPz.length > 0) {
                i = rL;
                for (e eVar : this.zPz) {
                    if (eVar != null) {
                        i += b.b(10, eVar);
                    }
                }
                rL = i;
            }
            if (this.zPA != 0) {
                rL += b.aE(11, this.zPA);
            }
            if (this.zPB != null && this.zPB.length > 0) {
                i = 0;
                while (i2 < this.zPB.length) {
                    i += b.dZ(this.zPB[i2]);
                    i2++;
                }
                rL = (rL + i) + (this.zPB.length * 1);
            }
            if (this.zPC != 0) {
                rL += b.aE(13, this.zPC);
            }
            if (this.zPD != 0) {
                rL += b.aE(14, this.zPD);
            }
            if (this.zPE != 0) {
                rL += b.aE(15, this.zPE);
            }
            if (this.zPF != 0) {
                rL += b.aE(16, this.zPF);
            }
            if (this.zPG != null) {
                rL += b.b(17, this.zPG);
            }
            if (!this.zOC.equals("")) {
                rL += b.h(100, this.zOC);
            }
            if (!this.zPH.equals("")) {
                rL += b.h(101, this.zPH);
            }
            if (this.zPI != 0) {
                rL += b.aE(102, this.zPI);
            }
            if (!Arrays.equals(this.zNc, g.bfX)) {
                rL += b.b(200, this.zNc);
            }
            if (this.zPJ != null) {
                rL += b.b(201, this.zPJ);
            }
            if (this.zPK != -1) {
                rL += b.aD(202, this.zPK);
            }
            if (!this.zPL.equals("")) {
                rL += b.h(203, this.zPL);
            }
            if (this.zPM != 0) {
                rL += b.aD(d.CTRL_INDEX, this.zPM);
            }
            if (this.zPN != 0) {
                rL += b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, this.zPN);
            }
            if (this.swC != 0) {
                rL += b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this.swC);
            }
            if (this.zPO != 0) {
                rL += b.aE(207, this.zPO);
            }
            if (this.zPP != 0) {
                rL += b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, this.zPP);
            }
            if (this.zMX != 0) {
                return rL + b.aE(240, this.zMX);
            }
            return rL;
        }
    }

    public static final class aw extends e {
        private static volatile aw[] zPQ;
        public String pDh;
        public String username;
        public int vCD;
        public long zPR;
        public String zPS;
        public String zPT;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.vCD = aVar.ry();
                        continue;
                    case 18:
                        this.username = aVar.readString();
                        continue;
                    case 26:
                        this.pDh = aVar.readString();
                        continue;
                    case 32:
                        this.zPR = aVar.rz();
                        continue;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zPS = aVar.readString();
                        continue;
                    case 50:
                        this.zPT = aVar.readString();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static aw[] cCR() {
            if (zPQ == null) {
                synchronized (c.bfP) {
                    if (zPQ == null) {
                        zPQ = new aw[0];
                    }
                }
            }
            return zPQ;
        }

        public aw() {
            this.vCD = 0;
            this.username = "";
            this.pDh = "";
            this.zPR = 0;
            this.zPS = "";
            this.zPT = "";
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.vCD != 0) {
                bVar.aC(1, this.vCD);
            }
            if (!this.username.equals("")) {
                bVar.g(2, this.username);
            }
            if (!this.pDh.equals("")) {
                bVar.g(3, this.pDh);
            }
            if (this.zPR != 0) {
                bVar.j(4, this.zPR);
            }
            if (!this.zPS.equals("")) {
                bVar.g(5, this.zPS);
            }
            if (!this.zPT.equals("")) {
                bVar.g(6, this.zPT);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.vCD != 0) {
                rL += b.aE(1, this.vCD);
            }
            if (!this.username.equals("")) {
                rL += b.h(2, this.username);
            }
            if (!this.pDh.equals("")) {
                rL += b.h(3, this.pDh);
            }
            if (this.zPR != 0) {
                rL += b.l(4, this.zPR);
            }
            if (!this.zPS.equals("")) {
                rL += b.h(5, this.zPS);
            }
            if (this.zPT.equals("")) {
                return rL;
            }
            return rL + b.h(6, this.zPT);
        }
    }

    public static final class f extends e {
        public int aAk;
        public String groupId;
        public int slB;
        public long slC;
        public int zNb;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.slB = aVar.ry();
                        continue;
                    case 24:
                        this.slC = aVar.rz();
                        continue;
                    case 32:
                        this.aAk = aVar.ry();
                        continue;
                    case 40:
                        this.zNb = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public f() {
            this.groupId = "";
            this.slB = 0;
            this.slC = 0;
            this.aAk = 0;
            this.zNb = 0;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.slB != 0) {
                bVar.aB(2, this.slB);
            }
            if (this.slC != 0) {
                bVar.k(3, this.slC);
            }
            if (this.aAk != 0) {
                bVar.aB(4, this.aAk);
            }
            if (this.zNb != 0) {
                bVar.aB(5, this.zNb);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (!this.groupId.equals("")) {
                rL += b.h(1, this.groupId);
            }
            if (this.slB != 0) {
                rL += b.aD(2, this.slB);
            }
            if (this.slC != 0) {
                rL += b.m(3, this.slC);
            }
            if (this.aAk != 0) {
                rL += b.aD(4, this.aAk);
            }
            if (this.zNb != 0) {
                return rL + b.aD(5, this.zNb);
            }
            return rL;
        }
    }

    public static final class m extends e {
        private static volatile m[] zNj;
        public String fpL;
        public int vCD;
        public String zNk;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.vCD = aVar.ry();
                        continue;
                    case 18:
                        this.fpL = aVar.readString();
                        continue;
                    case 26:
                        this.zNk = aVar.readString();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static m[] cCI() {
            if (zNj == null) {
                synchronized (c.bfP) {
                    if (zNj == null) {
                        zNj = new m[0];
                    }
                }
            }
            return zNj;
        }

        public m() {
            this.vCD = 0;
            this.fpL = "";
            this.zNk = "";
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.vCD != 0) {
                bVar.aC(1, this.vCD);
            }
            if (!this.fpL.equals("")) {
                bVar.g(2, this.fpL);
            }
            if (!this.zNk.equals("")) {
                bVar.g(3, this.zNk);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.vCD != 0) {
                rL += b.aE(1, this.vCD);
            }
            if (!this.fpL.equals("")) {
                rL += b.h(2, this.fpL);
            }
            if (this.zNk.equals("")) {
                return rL;
            }
            return rL + b.h(3, this.zNk);
        }
    }

    public static final class o extends e {
        private static volatile o[] zNo;
        public int port;
        public int zNp;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.zNp = aVar.ry();
                        continue;
                    case 16:
                        this.port = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static o[] cCK() {
            if (zNo == null) {
                synchronized (c.bfP) {
                    if (zNo == null) {
                        zNo = new o[0];
                    }
                }
            }
            return zNo;
        }

        public o() {
            this.zNp = 0;
            this.port = 0;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.zNp != 0) {
                bVar.aC(1, this.zNp);
            }
            if (this.port != 0) {
                bVar.aB(2, this.port);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.zNp != 0) {
                rL += b.aE(1, this.zNp);
            }
            if (this.port != 0) {
                return rL + b.aD(2, this.port);
            }
            return rL;
        }
    }

    public static final class q extends e {
        public int zNy;

        public q() {
            this.zNy = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.zNy = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(b bVar) {
            bVar.aC(1, this.zNy);
            super.a(bVar);
        }

        protected final int rL() {
            return super.rL() + b.aE(1, this.zNy);
        }
    }

    public static final class s extends e {
        public String username;
        public long vNE;
        public long vNF;
        public String xgZ;
        public String zNA;
        public String zNB;
        public int zNC;
        public String zND;
        public long zNE;
        public int zNF;
        public long zNG;
        public int zNH;
        public String zNk;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.vNE = aVar.rz();
                        continue;
                    case 18:
                        this.zNA = aVar.readString();
                        continue;
                    case 26:
                        this.zNB = aVar.readString();
                        continue;
                    case 32:
                        this.zNC = aVar.ry();
                        continue;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.username = aVar.readString();
                        continue;
                    case 50:
                        this.zND = aVar.readString();
                        continue;
                    case 58:
                        this.zNk = aVar.readString();
                        continue;
                    case 64:
                        this.zNE = aVar.rz();
                        continue;
                    case 72:
                        this.zNF = aVar.ry();
                        continue;
                    case 82:
                        this.xgZ = aVar.readString();
                        continue;
                    case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zNG = aVar.rz();
                        continue;
                    case 96:
                        this.zNH = aVar.ry();
                        continue;
                    case 104:
                        this.vNF = aVar.rz();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public s() {
            this.vNE = 0;
            this.zNA = "";
            this.zNB = "";
            this.zNC = 1;
            this.username = "";
            this.zND = "";
            this.zNk = "";
            this.zNE = 0;
            this.zNF = 0;
            this.xgZ = "";
            this.zNG = 0;
            this.zNH = 0;
            this.vNF = 0;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.vNE != 0) {
                bVar.j(1, this.vNE);
            }
            if (!this.zNA.equals("")) {
                bVar.g(2, this.zNA);
            }
            if (!this.zNB.equals("")) {
                bVar.g(3, this.zNB);
            }
            if (this.zNC != 1) {
                bVar.aB(4, this.zNC);
            }
            if (!this.username.equals("")) {
                bVar.g(5, this.username);
            }
            if (!this.zND.equals("")) {
                bVar.g(6, this.zND);
            }
            if (!this.zNk.equals("")) {
                bVar.g(7, this.zNk);
            }
            if (this.zNE != 0) {
                bVar.j(8, this.zNE);
            }
            if (this.zNF != 0) {
                bVar.aC(9, this.zNF);
            }
            if (!this.xgZ.equals("")) {
                bVar.g(10, this.xgZ);
            }
            if (this.zNG != 0) {
                bVar.j(11, this.zNG);
            }
            if (this.zNH != 0) {
                bVar.aC(12, this.zNH);
            }
            if (this.vNF != 0) {
                bVar.j(13, this.vNF);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.vNE != 0) {
                rL += b.l(1, this.vNE);
            }
            if (!this.zNA.equals("")) {
                rL += b.h(2, this.zNA);
            }
            if (!this.zNB.equals("")) {
                rL += b.h(3, this.zNB);
            }
            if (this.zNC != 1) {
                rL += b.aD(4, this.zNC);
            }
            if (!this.username.equals("")) {
                rL += b.h(5, this.username);
            }
            if (!this.zND.equals("")) {
                rL += b.h(6, this.zND);
            }
            if (!this.zNk.equals("")) {
                rL += b.h(7, this.zNk);
            }
            if (this.zNE != 0) {
                rL += b.l(8, this.zNE);
            }
            if (this.zNF != 0) {
                rL += b.aE(9, this.zNF);
            }
            if (!this.xgZ.equals("")) {
                rL += b.h(10, this.xgZ);
            }
            if (this.zNG != 0) {
                rL += b.l(11, this.zNG);
            }
            if (this.zNH != 0) {
                rL += b.aE(12, this.zNH);
            }
            if (this.vNF != 0) {
                return rL + b.l(13, this.vNF);
            }
            return rL;
        }
    }

    public static final class t extends e {
        public byte[] data;
        public String iconUrl;
        public String lOX;
        public int status;
        public int zNI;
        public byte[] zNJ;
        public byte[] zNK;
        public byte[] zNL;
        public int zNM;
        public int zNN;
        public byte[] zNO;
        public byte[] zNP;
        public byte[] zNQ;
        public byte[] zNR;
        public byte[] zNS;
        public byte[] zNT;
        public byte[] zNU;
        public byte[] zNV;
        public byte[] zNW;
        public byte[] zNX;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 8:
                        this.zNI = aVar.ry();
                        continue;
                    case 18:
                        this.zNJ = aVar.readBytes();
                        continue;
                    case 26:
                        this.iconUrl = aVar.readString();
                        continue;
                    case 34:
                        this.zNK = aVar.readBytes();
                        continue;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zNL = aVar.readBytes();
                        continue;
                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zNM = aVar.ry();
                        continue;
                    case 58:
                        this.data = aVar.readBytes();
                        continue;
                    case 64:
                        this.zNN = aVar.ry();
                        continue;
                    case 74:
                        this.zNO = aVar.readBytes();
                        continue;
                    case 82:
                        this.lOX = aVar.readString();
                        continue;
                    case 90:
                        this.zNP = aVar.readBytes();
                        continue;
                    case 98:
                        this.zNQ = aVar.readBytes();
                        continue;
                    case 106:
                        this.zNR = aVar.readBytes();
                        continue;
                    case 114:
                        this.zNS = aVar.readBytes();
                        continue;
                    case 122:
                        this.zNT = aVar.readBytes();
                        continue;
                    case 130:
                        this.zNU = aVar.readBytes();
                        continue;
                    case 138:
                        this.zNV = aVar.readBytes();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*146*/:
                        this.zNW = aVar.readBytes();
                        continue;
                    case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
                        this.zNX = aVar.readBytes();
                        continue;
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                        this.status = aVar.ry();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public t() {
            this.zNI = 0;
            this.zNJ = g.bfX;
            this.iconUrl = "";
            this.zNK = g.bfX;
            this.zNL = g.bfX;
            this.zNM = 0;
            this.data = g.bfX;
            this.zNN = 0;
            this.zNO = g.bfX;
            this.lOX = "";
            this.zNP = g.bfX;
            this.zNQ = g.bfX;
            this.zNR = g.bfX;
            this.zNS = g.bfX;
            this.zNT = g.bfX;
            this.zNU = g.bfX;
            this.zNV = g.bfX;
            this.zNW = g.bfX;
            this.zNX = g.bfX;
            this.status = 0;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.zNI != 0) {
                bVar.aC(1, this.zNI);
            }
            if (!Arrays.equals(this.zNJ, g.bfX)) {
                bVar.a(2, this.zNJ);
            }
            if (!this.iconUrl.equals("")) {
                bVar.g(3, this.iconUrl);
            }
            if (!Arrays.equals(this.zNK, g.bfX)) {
                bVar.a(4, this.zNK);
            }
            if (!Arrays.equals(this.zNL, g.bfX)) {
                bVar.a(5, this.zNL);
            }
            if (this.zNM != 0) {
                bVar.aC(6, this.zNM);
            }
            if (!Arrays.equals(this.data, g.bfX)) {
                bVar.a(7, this.data);
            }
            if (this.zNN != 0) {
                bVar.aC(8, this.zNN);
            }
            if (!Arrays.equals(this.zNO, g.bfX)) {
                bVar.a(9, this.zNO);
            }
            if (!this.lOX.equals("")) {
                bVar.g(10, this.lOX);
            }
            if (!Arrays.equals(this.zNP, g.bfX)) {
                bVar.a(11, this.zNP);
            }
            if (!Arrays.equals(this.zNQ, g.bfX)) {
                bVar.a(12, this.zNQ);
            }
            if (!Arrays.equals(this.zNR, g.bfX)) {
                bVar.a(13, this.zNR);
            }
            if (!Arrays.equals(this.zNS, g.bfX)) {
                bVar.a(14, this.zNS);
            }
            if (!Arrays.equals(this.zNT, g.bfX)) {
                bVar.a(15, this.zNT);
            }
            if (!Arrays.equals(this.zNU, g.bfX)) {
                bVar.a(16, this.zNU);
            }
            if (!Arrays.equals(this.zNV, g.bfX)) {
                bVar.a(17, this.zNV);
            }
            if (!Arrays.equals(this.zNW, g.bfX)) {
                bVar.a(18, this.zNW);
            }
            if (!Arrays.equals(this.zNX, g.bfX)) {
                bVar.a(19, this.zNX);
            }
            if (this.status != 0) {
                bVar.aC(20, this.status);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.zNI != 0) {
                rL += b.aE(1, this.zNI);
            }
            if (!Arrays.equals(this.zNJ, g.bfX)) {
                rL += b.b(2, this.zNJ);
            }
            if (!this.iconUrl.equals("")) {
                rL += b.h(3, this.iconUrl);
            }
            if (!Arrays.equals(this.zNK, g.bfX)) {
                rL += b.b(4, this.zNK);
            }
            if (!Arrays.equals(this.zNL, g.bfX)) {
                rL += b.b(5, this.zNL);
            }
            if (this.zNM != 0) {
                rL += b.aE(6, this.zNM);
            }
            if (!Arrays.equals(this.data, g.bfX)) {
                rL += b.b(7, this.data);
            }
            if (this.zNN != 0) {
                rL += b.aE(8, this.zNN);
            }
            if (!Arrays.equals(this.zNO, g.bfX)) {
                rL += b.b(9, this.zNO);
            }
            if (!this.lOX.equals("")) {
                rL += b.h(10, this.lOX);
            }
            if (!Arrays.equals(this.zNP, g.bfX)) {
                rL += b.b(11, this.zNP);
            }
            if (!Arrays.equals(this.zNQ, g.bfX)) {
                rL += b.b(12, this.zNQ);
            }
            if (!Arrays.equals(this.zNR, g.bfX)) {
                rL += b.b(13, this.zNR);
            }
            if (!Arrays.equals(this.zNS, g.bfX)) {
                rL += b.b(14, this.zNS);
            }
            if (!Arrays.equals(this.zNT, g.bfX)) {
                rL += b.b(15, this.zNT);
            }
            if (!Arrays.equals(this.zNU, g.bfX)) {
                rL += b.b(16, this.zNU);
            }
            if (!Arrays.equals(this.zNV, g.bfX)) {
                rL += b.b(17, this.zNV);
            }
            if (!Arrays.equals(this.zNW, g.bfX)) {
                rL += b.b(18, this.zNW);
            }
            if (!Arrays.equals(this.zNX, g.bfX)) {
                rL += b.b(19, this.zNX);
            }
            if (this.status != 0) {
                return rL + b.aE(20, this.status);
            }
            return rL;
        }
    }

    public static final class v extends e {
        public byte[] body;
        public u zOa;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        if (this.zOa == null) {
                            this.zOa = new u();
                        }
                        aVar.a(this.zOa);
                        continue;
                    case 18:
                        this.body = aVar.readBytes();
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public v() {
            this.zOa = null;
            this.body = g.bfX;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (this.zOa != null) {
                bVar.a(1, this.zOa);
            }
            if (!Arrays.equals(this.body, g.bfX)) {
                bVar.a(2, this.body);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (this.zOa != null) {
                rL += b.b(1, this.zOa);
            }
            if (Arrays.equals(this.body, g.bfX)) {
                return rL;
            }
            return rL + b.b(2, this.body);
        }
    }

    public static final class x extends e {
        public String groupId;
        public int slB;
        public long slC;
        public at zMO;
        public av[] zOe;

        public final /* synthetic */ e a(com.google.a.a.a aVar) {
            while (true) {
                int rx = aVar.rx();
                switch (rx) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.slB = aVar.ry();
                        continue;
                    case 24:
                        this.slC = aVar.rz();
                        continue;
                    case 34:
                        int b = g.b(aVar, 34);
                        rx = this.zOe == null ? 0 : this.zOe.length;
                        Object obj = new av[(b + rx)];
                        if (rx != 0) {
                            System.arraycopy(this.zOe, 0, obj, 0, rx);
                        }
                        while (rx < obj.length - 1) {
                            obj[rx] = new av();
                            aVar.a(obj[rx]);
                            aVar.rx();
                            rx++;
                        }
                        obj[rx] = new av();
                        aVar.a(obj[rx]);
                        this.zOe = obj;
                        continue;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        if (this.zMO == null) {
                            this.zMO = new at();
                        }
                        aVar.a(this.zMO);
                        continue;
                    default:
                        if (!g.a(aVar, rx)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public x() {
            this.groupId = "";
            this.slB = 0;
            this.slC = 0;
            this.zOe = av.cCQ();
            this.zMO = null;
            this.bfQ = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.slB != 0) {
                bVar.aB(2, this.slB);
            }
            if (this.slC != 0) {
                bVar.k(3, this.slC);
            }
            if (this.zOe != null && this.zOe.length > 0) {
                for (e eVar : this.zOe) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zMO != null) {
                bVar.a(5, this.zMO);
            }
            super.a(bVar);
        }

        protected final int rL() {
            int rL = super.rL();
            if (!this.groupId.equals("")) {
                rL += b.h(1, this.groupId);
            }
            if (this.slB != 0) {
                rL += b.aD(2, this.slB);
            }
            if (this.slC != 0) {
                rL += b.m(3, this.slC);
            }
            if (this.zOe != null && this.zOe.length > 0) {
                int i = rL;
                for (e eVar : this.zOe) {
                    if (eVar != null) {
                        i += b.b(4, eVar);
                    }
                }
                rL = i;
            }
            if (this.zMO != null) {
                return rL + b.b(5, this.zMO);
            }
            return rL;
        }
    }
}
