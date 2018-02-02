package com.tencent.mm.az;

import android.os.Looper;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.m;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.k.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.ae.k implements m, com.tencent.mm.network.k {
    private int flags;
    private int fqo;
    private b gJQ;
    private e gJT;
    private boolean hJG;

    public k(boolean z) {
        this.hJG = false;
        this.flags = -1;
        this.fqo = 26;
        this.hJG = false;
        x.d("MicroMsg.NetSceneGetPackageList", new StringBuilder("Init dkregcode:26").toString());
        x.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
    }

    public k(int i) {
        this.hJG = false;
        this.flags = -1;
        this.fqo = i;
        this.hJG = false;
        x.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.fqo);
        a aVar = new a();
        aVar.hmj = new aec();
        aVar.hmk = new aed();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.hmi = JsApiGetBackgroundAudioState.CTRL_INDEX;
        aVar.hml = 51;
        aVar.hmm = 1000000051;
        this.gJQ = aVar.JZ();
        aec com_tencent_mm_protocal_c_aec = (aec) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        if (!g.Dh().Cy()) {
            return -1;
        }
        m[] ik = r.QH().ik(this.fqo);
        if (ik != null && ik.length > 0) {
            for (int i = 0; i < ik.length; i++) {
                avi com_tencent_mm_protocal_c_avi = new avi();
                com_tencent_mm_protocal_c_avi.nkn = ik[i].id;
                if (r.idj && this.fqo == 7) {
                    x.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                    com_tencent_mm_protocal_c_avi.ktM = 0;
                } else {
                    com_tencent_mm_protocal_c_avi.ktM = ik[i].version;
                }
                x.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_avi.nkn), Integer.valueOf(com_tencent_mm_protocal_c_avi.ktM));
                linkedList.add(com_tencent_mm_protocal_c_avi);
            }
        }
        com_tencent_mm_protocal_c_aec.ksP = linkedList;
        com_tencent_mm_protocal_c_aec.ksO = linkedList.size();
        com_tencent_mm_protocal_c_aec.ktN = this.fqo;
        if (this.flags != -1) {
            com_tencent_mm_protocal_c_aec.vGN = this.flags;
        }
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 20;
    }

    protected final void a(a aVar) {
    }

    public final boolean Kd() {
        return true;
    }

    private m a(avi com_tencent_mm_protocal_c_avi) {
        m mVar = new m();
        mVar.id = com_tencent_mm_protocal_c_avi.nkn;
        mVar.version = com_tencent_mm_protocal_c_avi.ktM;
        mVar.name = com_tencent_mm_protocal_c_avi.nfp;
        mVar.size = com_tencent_mm_protocal_c_avi.ktH;
        mVar.hJL = com_tencent_mm_protocal_c_avi.war;
        mVar.status = 5;
        mVar.fvM = this.fqo;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fqo), str);
        if (i2 == 0 || i3 == 0) {
            aed com_tencent_mm_protocal_c_aed = (aed) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_aed.ktN != this.fqo) {
                x.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(com_tencent_mm_protocal_c_aed.ktN));
                this.gJT.a(3, -1, "", this);
                return;
            }
            LinkedList linkedList = com_tencent_mm_protocal_c_aed.ksP;
            x.v("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.fqo + " resp.Type: " + com_tencent_mm_protocal_c_aed.ktN);
            if (this.fqo == 2) {
                i(linkedList);
            } else if (this.fqo == 1) {
                h(linkedList);
            } else if (this.fqo == 4) {
                j(linkedList);
            } else if (this.fqo == 6) {
                x.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.fqo == 7) {
                k(linkedList);
            } else if (this.fqo == 8) {
                if (linkedList == null || linkedList.size() <= 0) {
                    x.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
                } else {
                    x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (avi) linkedList.get(0);
                    r3 = r.QH().be(r1.nkn, this.fqo);
                    r4 = a(r1);
                    r4.fDt = -1;
                    if (r3 == null) {
                        r.QH().a(r4);
                    } else {
                        r.QH().b(r4);
                    }
                    x.d("MicroMsg.NetSceneGetPackageList", r1.nfp + " - " + r1.nkn + " - " + r1.war + " - " + r1.ktH);
                }
            } else if (this.fqo == 9) {
                g(linkedList);
            } else if (this.fqo == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    x.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (avi) linkedList.get(0);
                    r3 = r.QH().be(r1.nkn, this.fqo);
                    r1 = a(r1);
                    r1.fDt = -1;
                    if (r3 == null) {
                        r.QH().a(r1);
                    } else {
                        r.QH().b(r1);
                    }
                }
            } else if (this.fqo != 11) {
                if (this.fqo == 12) {
                    m(linkedList);
                } else if (this.fqo == 5) {
                    n(linkedList);
                } else if (this.fqo == 20) {
                    l(linkedList);
                } else if (this.fqo == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        x.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        r1 = (avi) linkedList.get(0);
                        x.d("MicroMsg.NetSceneGetPackageList", r1.nfp + " - " + r1.nkn + " - " + r1.war + " - " + r1.ktH);
                        r3 = r.QH().be(r1.nkn, this.fqo);
                        r4 = a(r1);
                        r4.fDt = -1;
                        if (r3 == null) {
                            r.QH().a(r4);
                        } else {
                            r.QH().b(r4);
                        }
                        com.tencent.mm.sdk.b.b lsVar = new ls();
                        try {
                            lsVar.fDf.content = n.a(r1.vHV);
                            if (lsVar.fDf.content != null) {
                                com.tencent.mm.sdk.b.a.xef.a(lsVar, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.fqo != 18) {
                    if (this.fqo == 19) {
                        S(linkedList);
                    } else if (this.fqo == 21) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                        } else {
                            r1 = (avi) linkedList.get(0);
                            x.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + r1 + "|id = " + r1.nkn + "|Name = " + r1.nfp + "|PackName = " + r1.war + "|Size = " + r1.ktH + "|Version = " + r1.ktM);
                            r3 = r.QH().be(r1.nkn, this.fqo);
                            r1 = a(r1);
                            r1.fDt = -1;
                            if (r3 == null) {
                                r.QH().a(r1);
                            } else if (r3.version < r1.version) {
                                r.QH().b(r1);
                            } else {
                                x.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(r3.version), Integer.valueOf(r1.version));
                            }
                        }
                    } else if (23 == this.fqo) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                        } else {
                            r1 = (avi) linkedList.get(0);
                            x.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + r1 + "|id = " + r1.nkn + "|Name = " + r1.nfp + "|PackName = " + r1.war + "|Size = " + r1.ktH + "|Version = " + r1.ktM);
                            r3 = r.QH().be(r1.nkn, this.fqo);
                            r1 = a(r1);
                            r1.fDt = -1;
                            if (r3 == null) {
                                r.QH().a(r1);
                            } else if (r3.version < r1.version) {
                                r.QH().b(r1);
                            }
                        }
                    } else if (this.fqo == 26) {
                        T(linkedList);
                    } else if (this.fqo == 36) {
                        U(linkedList);
                    } else if (this.fqo == 37) {
                        o(linkedList);
                    }
                }
            }
            com.tencent.mm.sdk.b.b sbVar = new sb();
            sbVar.fJN.fJO = linkedList;
            sbVar.fJN.fqo = this.fqo;
            com.tencent.mm.sdk.b.a.xef.m(sbVar);
            if (com_tencent_mm_protocal_c_aed.vPq <= 0) {
                this.gJT.a(i2, i3, str, this);
                return;
            } else if (a(this.hmA, this.gJT) == -1) {
                this.gJT.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    protected final boolean b(com.tencent.mm.ae.k kVar) {
        if ((kVar instanceof k) && this.fqo == ((k) kVar).fqo) {
            return false;
        }
        return true;
    }

    private void g(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            return;
        }
        r.QH();
        String QE = n.QE();
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                com.tencent.mm.loader.stub.b.deleteFile(QE + r.QH().bg(com_tencent_mm_protocal_c_avi.nkn, this.fqo));
                m a = a(com_tencent_mm_protocal_c_avi);
                a.fDt = -1;
                if (be == null) {
                    r.QH().a(a);
                } else {
                    r.QH().b(a);
                }
                g.Di().gPJ.a(new j(a.id, 9), 0);
            }
            if (n.a(com_tencent_mm_protocal_c_avi.vHV) != null) {
                x.v("MicroMsg.NetSceneGetPackageList", "xml:" + new String(n.a(com_tencent_mm_protocal_c_avi.vHV)));
            }
            if (n.a(com_tencent_mm_protocal_c_avi.wCY) != null) {
                x.v("MicroMsg.NetSceneGetPackageList", "xml2:" + new String(n.a(com_tencent_mm_protocal_c_avi.wCY)));
            }
            x.v("MicroMsg.NetSceneGetPackageList", "xml3:" + com_tencent_mm_protocal_c_avi.toString());
            x.v("MicroMsg.NetSceneGetPackageList", "xml4:" + com_tencent_mm_protocal_c_avi.nfp);
            x.v("MicroMsg.NetSceneGetPackageList", "xml5:" + com_tencent_mm_protocal_c_avi.war);
        }
    }

    private void h(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            return;
        }
        r.QH();
        String QE = n.QE();
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                com.tencent.mm.loader.stub.b.deleteFile(QE + r.QH().bg(com_tencent_mm_protocal_c_avi.nkn, this.fqo));
                m a = a(com_tencent_mm_protocal_c_avi);
                a.fDt = -1;
                if (be == null) {
                    r.QH().a(a);
                } else {
                    r.QH().b(a);
                }
            }
            byte[] a2 = n.a(com_tencent_mm_protocal_c_avi.vHV);
            if (a2 != null && a2.length > 0) {
                r.QH();
                String bf = n.bf(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
                com.tencent.mm.loader.stub.b.deleteFile(QE + bf);
                com.tencent.mm.a.e.a(QE, bf, a2);
            }
        }
    }

    @Deprecated
    private void i(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            m a = a(com_tencent_mm_protocal_c_avi);
            a.fDt = -1;
            if (be == null) {
                r.QH().a(a);
            } else {
                r.QH().b(a);
            }
            byte[] a2 = n.a(com_tencent_mm_protocal_c_avi.vHV);
            if (a2 != null && a2.length > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new String(a2));
                arrayList.size();
            }
        }
    }

    private void j(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        r.QH();
        String QE = n.QE();
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            byte[] a = n.a(com_tencent_mm_protocal_c_avi.vHV);
            if (com_tencent_mm_protocal_c_avi.vHV == null) {
                x.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
            } else {
                if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                    String str = new String(a);
                    String str2 = "zh_CN";
                    if (str.indexOf(str2) < 0) {
                        str2 = "en";
                        if (str.indexOf(str2) < 0) {
                            str2 = "zh_TW";
                            if (str.indexOf(str2) < 0) {
                                str2 = "en";
                            }
                        }
                    }
                    str = str2 + "_ARTIST.mm";
                    com.tencent.mm.loader.stub.b.deleteFile(QE + str);
                    com.tencent.mm.loader.stub.b.deleteFile(QE + str2 + "_ARTISTF.mm");
                    com.tencent.mm.a.e.a(QE, str, a);
                }
                m a2 = a(com_tencent_mm_protocal_c_avi);
                a2.fDt = -1;
                if (be == null) {
                    r.QH().a(a2);
                } else {
                    r.QH().b(a2);
                }
                x.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_avi.nfp + " - " + com_tencent_mm_protocal_c_avi.nkn + " - " + com_tencent_mm_protocal_c_avi.war + " - " + com_tencent_mm_protocal_c_avi.ktH);
            }
        }
    }

    private void k(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            m a = a(com_tencent_mm_protocal_c_avi);
            a.fDt = -1;
            if (be == null) {
                r.QH().a(a);
            } else {
                r.QH().b(a);
            }
            x.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_avi.nfp + " - " + com_tencent_mm_protocal_c_avi.nkn + " - " + com_tencent_mm_protocal_c_avi.war + " - " + com_tencent_mm_protocal_c_avi.ktH);
            byte[] a2 = n.a(com_tencent_mm_protocal_c_avi.vHV);
            x.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + new String(a2));
            c zZ = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zZ();
            int i2 = com_tencent_mm_protocal_c_avi.nkn;
            File file = new File(c.gId);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(c.fP(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.tencent.mm.a.e.b(c.fP(i2), a2, a2.length);
                zZ.p(i2, new String(a2));
            } catch (Throwable e) {
                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e));
            }
        }
    }

    private void l(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            avi com_tencent_mm_protocal_c_avi = (avi) it.next();
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            m a = a(com_tencent_mm_protocal_c_avi);
            a.fDt = -1;
            if (be == null) {
                r.QH().a(a);
            } else {
                r.QH().b(a);
            }
            x.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_avi.nfp + " - " + com_tencent_mm_protocal_c_avi.nkn + " - " + com_tencent_mm_protocal_c_avi.war + " - " + com_tencent_mm_protocal_c_avi.ktH);
        }
    }

    private void m(LinkedList<avi> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) linkedList.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            m a = a(com_tencent_mm_protocal_c_avi);
            a.fDt = -1;
            if (be == null) {
                r.QH().a(a);
            } else {
                r.QH().b(a);
            }
            g.Di().gPJ.a(new j(a.id, 12), 0);
        }
    }

    private void S(List<avi> list) {
        if (list == null || list.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            return;
        }
        r.QH();
        String QE = n.QE();
        for (int i = 0; i < list.size(); i++) {
            avi com_tencent_mm_protocal_c_avi = (avi) list.get(i);
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                com.tencent.mm.loader.stub.b.deleteFile(QE + r.QH().bg(com_tencent_mm_protocal_c_avi.nkn, this.fqo));
                m a = a(com_tencent_mm_protocal_c_avi);
                a.fDt = -1;
                if (be == null) {
                    r.QH().a(a);
                } else {
                    r.QH().b(a);
                }
                g.Di().gPJ.a(new j(a.id, 19), 0);
            }
            x.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", com_tencent_mm_protocal_c_avi.nfp, com_tencent_mm_protocal_c_avi.war);
        }
    }

    private void T(List<avi> list) {
        if (list == null || list.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        int intValue = ((Integer) g.Dj().CU().get(w.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(-1))).intValue();
        x.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue != -1) {
            m be = r.QH().be(intValue, this.fqo);
            for (avi a : list) {
                m a2 = a(a);
                x.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.id), Integer.valueOf(a2.version));
                if (be != null && a2.id == intValue) {
                    x.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                    r.QH().b(a2);
                    return;
                } else if (be == null && a2.id == intValue) {
                    x.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                    r.QH().a(a2);
                    return;
                }
            }
        }
    }

    private void U(List<avi> list) {
        if (list == null || list.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (avi com_tencent_mm_protocal_c_avi : list) {
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                m a = a(com_tencent_mm_protocal_c_avi);
                a.fDt = -1;
                if (be == null) {
                    r.QH().a(a);
                } else {
                    r.QH().b(a);
                }
                g.Di().gPJ.a(new j(a.id, 36), 0);
            }
        }
    }

    private void n(LinkedList<avi> linkedList) {
        x.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            avi com_tencent_mm_protocal_c_avi = (avi) it.next();
            x.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", com_tencent_mm_protocal_c_avi.toString());
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            m a = a(com_tencent_mm_protocal_c_avi);
            a.fDt = -1;
            if (be == null) {
                r.QH().a(a);
            } else {
                r.QH().b(a);
            }
        }
    }

    private void o(LinkedList<avi> linkedList) {
        x.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            avi com_tencent_mm_protocal_c_avi = (avi) it.next();
            m be = r.QH().be(com_tencent_mm_protocal_c_avi.nkn, this.fqo);
            if (be == null || be.version != com_tencent_mm_protocal_c_avi.ktM) {
                m a = a(com_tencent_mm_protocal_c_avi);
                a.fDt = -1;
                if (be == null) {
                    r.QH().a(a);
                } else {
                    r.QH().b(a);
                }
                g.Di().gPJ.a(new j(a.id, 37), 0);
            }
        }
    }

    public final int getType() {
        return JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    public final int Kl() {
        return this.fqo;
    }
}
