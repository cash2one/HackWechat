package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h extends e<aqr> {
    private List<aqr> list = new ArrayList();
    private String nQA = "";
    private String path = "";
    private dp rqI;
    private cf rqJ;
    private a rqK;
    private int rqr = 0;
    private int rqs = 0;

    public interface a {
        void a(List<aqr> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dp dpVar);

        void byU();
    }

    public h(a aVar) {
        this.rqK = aVar;
    }

    public final void bT(List<aqr> list) {
        if (this.rqK == null) {
            return;
        }
        if (list != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap.clear();
            hashMap2.clear();
            int size = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "initFixType " + size);
            int i = 0;
            int i2 = 0;
            int i3;
            for (int i4 = 0; i4 < size; i4 = i3 + i4) {
                String str = ((aqr) list.get(i4)).nfe;
                i3 = i4 + 1 < size ? !str.equals(((aqr) list.get(i4 + 1)).nfe) ? 1 : i4 + 2 < size ? !str.equals(((aqr) list.get(i4 + 2)).nfe) ? 2 : 3 : 2 : 1;
                hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                hashMap2.put(Integer.valueOf(i), Integer.valueOf(i3));
                i2 += i3;
                i++;
            }
            this.rqr = i + 1;
            this.rqs = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "icount " + this.rqr);
            this.list = list;
            this.rqK.a(this.list, hashMap, hashMap2, this.rqs, this.rqr, this.rqI);
            return;
        }
        this.rqK.byU();
    }

    public final List<aqr> byT() {
        List<aqr> arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.rqJ = null;
            String str = this.path + this.nQA + "_ARTISTF.mm";
            if (FileOp.bO(str)) {
                this.rqJ = (cf) new cf().aF(FileOp.d(str, 0, -1));
            }
            if (this.rqJ == null) {
                String str2 = this.path + this.nQA + "_ARTIST.mm";
                this.rqJ = com.tencent.mm.plugin.sns.g.a.KQ(new String(FileOp.d(str2, 0, (int) FileOp.me(str2))));
                if (this.rqJ == null) {
                    FileOp.deleteFile(str2);
                    return null;
                }
                FileOp.deleteFile(str);
                FileOp.j(str, this.rqJ.toByteArray());
            }
            if (this.rqJ == null) {
                return null;
            }
            Iterator it = this.rqJ.vHz.iterator();
            while (it.hasNext()) {
                aji com_tencent_mm_protocal_c_aji = (aji) it.next();
                String str3 = com_tencent_mm_protocal_c_aji.nfp;
                Iterator it2 = com_tencent_mm_protocal_c_aji.vYd.iterator();
                while (it2.hasNext()) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) it2.next();
                    com_tencent_mm_protocal_c_aqr.nfe = str3;
                    arrayList.add(com_tencent_mm_protocal_c_aqr);
                }
            }
            this.rqI = this.rqJ.vHy;
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            return null;
        }
    }

    public final void eo(String str, String str2) {
        this.nQA = str;
        this.path = str2;
        fC(true);
    }
}
