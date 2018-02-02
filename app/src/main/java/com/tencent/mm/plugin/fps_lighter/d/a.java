package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.gmtrace.Constants;
import com.tencent.mm.plugin.fps_lighter.c.b;
import com.tencent.mm.plugin.fps_lighter.c.b$a;
import com.tencent.mm.plugin.fps_lighter.c.c;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public final class a implements Runnable {
    private com.tencent.mm.plugin.fps_lighter.c.a mBE;
    private long[] mBF;
    int mBG;
    public a mBH;
    int mnk;

    public interface a {
        void K(LinkedList<d> linkedList);
    }

    public a(long[] jArr, int i, int i2, long j, long j2, long j3, int i3, int i4, boolean z, long j4, boolean z2) {
        this.mBF = jArr;
        this.mnk = i;
        this.mBG = i2;
        com.tencent.mm.plugin.fps_lighter.c.a aVar = new com.tencent.mm.plugin.fps_lighter.c.a();
        aVar.scene = i4;
        aVar.mBm = j3;
        aVar.mBn = j2;
        aVar.mBo = z;
        aVar.mBq = i3;
        aVar.mBp = (int) j;
        aVar.mBs = j4;
        aVar.mBt = z2;
        x.i("MicroMsg.AsyncAnalyseTask", "[generateFpsInfoItem] %s", new Object[]{aVar.toString()});
        this.mBE = aVar;
    }

    private List<b> a(List<b$a> list, com.tencent.mm.plugin.fps_lighter.c.a aVar) {
        x.i("MicroMsg.AsyncAnalyseTask", "[parseTrace] size:%s fpsInfoItem:%s", new Object[]{Integer.valueOf(list.size()), aVar});
        long currentTimeMillis = System.currentTimeMillis();
        List<b> linkedList = new LinkedList();
        Stack stack = new Stack();
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        for (b$a com_tencent_mm_plugin_fps_lighter_c_b_a : list) {
            int i5;
            int i6;
            if (com_tencent_mm_plugin_fps_lighter_c_b_a.mBx) {
                com_tencent_mm_plugin_fps_lighter_c_b_a.mBw = i3;
                i5 = i4 + 1;
                i3++;
                stack.push(com_tencent_mm_plugin_fps_lighter_c_b_a);
                i6 = i3;
                i4 = i2;
            } else if (stack.size() <= 0) {
                x.w("MicroMsg.AsyncAnalyseTask", "Empty stack, item:%s", new Object[]{com_tencent_mm_plugin_fps_lighter_c_b_a});
            } else {
                b$a com_tencent_mm_plugin_fps_lighter_c_b_a2 = (b$a) stack.peek();
                if (com_tencent_mm_plugin_fps_lighter_c_b_a2.mBv != com_tencent_mm_plugin_fps_lighter_c_b_a.mBv) {
                    x.w("MicroMsg.AsyncAnalyseTask", "No match in rawItem:%s topRawItem:%s", new Object[]{com_tencent_mm_plugin_fps_lighter_c_b_a, com_tencent_mm_plugin_fps_lighter_c_b_a2});
                    stack.pop();
                    i4--;
                    while (stack.size() > 0) {
                        com_tencent_mm_plugin_fps_lighter_c_b_a2 = (b$a) stack.peek();
                        if (com_tencent_mm_plugin_fps_lighter_c_b_a.mBv == com_tencent_mm_plugin_fps_lighter_c_b_a2.mBv) {
                            x.w("MicroMsg.AsyncAnalyseTask", "Find it");
                            break;
                        }
                        stack.pop();
                        i4--;
                    }
                    if (stack.size() == 0) {
                        x.w("MicroMsg.AsyncAnalyseTask", "Still can't find it, ignore this out %s", new Object[]{com_tencent_mm_plugin_fps_lighter_c_b_a});
                    }
                }
                b$a com_tencent_mm_plugin_fps_lighter_c_b_a3 = com_tencent_mm_plugin_fps_lighter_c_b_a2;
                i5 = i4;
                b$a com_tencent_mm_plugin_fps_lighter_c_b_a4 = com_tencent_mm_plugin_fps_lighter_c_b_a3;
                stack.pop();
                i = i5 - 1;
                b bVar = new b();
                bVar.axZ = i;
                if (stack.size() == 0) {
                    bVar.mBu = -1;
                } else {
                    bVar.mBu = ((b$a) stack.peek()).mBv;
                }
                bVar.beginTime = com_tencent_mm_plugin_fps_lighter_c_b_a4.hOG;
                bVar.mBv = com_tencent_mm_plugin_fps_lighter_c_b_a4.mBv;
                bVar.jHU = com_tencent_mm_plugin_fps_lighter_c_b_a.hOG - com_tencent_mm_plugin_fps_lighter_c_b_a4.hOG;
                bVar.mBw = com_tencent_mm_plugin_fps_lighter_c_b_a4.mBw;
                if (bVar.beginTime >= aVar.mBn && bVar.beginTime <= aVar.mBm) {
                    linkedList.add(bVar);
                    i6 = i3;
                    i5 = i;
                    i4 = i2;
                } else if (bVar.beginTime <= aVar.mBn) {
                    i6 = i3;
                    i5 = i;
                    i4 = i2 + 1;
                } else {
                    i6 = i3;
                    i5 = i;
                    i4 = i2;
                }
            }
            i = linkedList.size() + i4;
            i2 = i4;
            i3 = i6;
            i4 = i5;
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceItem] startIndex:%s endIndex:%s pre:%s cur:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(aVar.mBn), Long.valueOf(aVar.mBm)});
        Collections.sort(linkedList, new 1(this));
        x.i("MicroMsg.AsyncAnalyseTask", "[parseTrace]result size:%s rawItemList:%s costTime:%s", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(list.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        list.clear();
        return linkedList;
    }

    private List<c> aO(List<b> list) {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] list size:%s", new Object[]{Integer.valueOf(list.size())});
        List<c> linkedList = new LinkedList();
        HashMap aP = aP(list);
        HashMap hashMap = new HashMap(600);
        for (Entry value : aP.entrySet()) {
            a(hashMap, (List) value.getValue());
        }
        for (Entry value2 : hashMap.entrySet()) {
            linkedList.add(value2.getValue());
        }
        Collections.sort(linkedList, new 2(this));
        hashMap.clear();
        list.clear();
        x.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return linkedList;
    }

    private static void a(HashMap<String, c> hashMap, List<b> list) {
        for (b bVar : list) {
            if (hashMap.containsKey(bVar.getKey())) {
                c cVar = (c) hashMap.get(bVar.getKey());
                cVar.hTi++;
                cVar.mBz.add(bVar.jHU);
                cVar.mBA.add(bVar.beginTime);
                cVar.mBB += bVar.jHU;
            } else {
                hashMap.put(bVar.getKey(), new c(bVar));
            }
        }
    }

    private static HashMap<Integer, List<b>> aP(List<b> list) {
        HashMap<Integer, List<b>> hashMap = new HashMap();
        for (b bVar : list) {
            if (!hashMap.containsKey(Integer.valueOf(bVar.axZ))) {
                hashMap.put(Integer.valueOf(bVar.axZ), new ArrayList());
            }
            ((List) hashMap.get(Integer.valueOf(bVar.axZ))).add(bVar);
        }
        return hashMap;
    }

    private LinkedList<d> a(com.tencent.mm.plugin.fps_lighter.c.a aVar, List<c> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        LinkedList<d> linkedList = new LinkedList();
        for (c cVar : list) {
            d dVar = new d(aVar, cVar);
            hashMap2.put(cVar.getKey(), cVar);
            if (((float) cVar.mBB) >= ((float) aVar.aKP()) * 0.4f && cVar.axZ == 0) {
                dVar.dt(cVar.mBu);
                hashMap.put(Long.valueOf(cVar.mBv), dVar);
            } else if (((float) cVar.mBB) < ((float) aVar.aKP()) * 0.4f && cVar.axZ == 0 && hashMap.size() == 0) {
                if (((double) cVar.mBB) >= 16.6d && hashMap3.size() <= 6) {
                    dVar.dt(cVar.mBu);
                }
            } else if (hashMap.containsKey(Long.valueOf(cVar.mBu))) {
                dVar.a(((d) hashMap.get(Long.valueOf(cVar.mBu))).mBD);
                dVar.dt(cVar.mBu);
                if (((float) cVar.mBB) >= ((float) aVar.aKP()) * 0.4f) {
                    hashMap.remove(Long.valueOf(cVar.mBu));
                    hashMap.put(Long.valueOf(cVar.mBv), dVar);
                } else {
                    if (!hashMap4.containsKey(cVar.aKQ())) {
                        hashMap4.put(cVar.aKQ(), new ArrayList());
                    }
                    List<d> list2 = (List) hashMap4.get(cVar.aKQ());
                    list2.add(dVar);
                    if (6 >= list2.size() && list2.size() >= 2) {
                        Collections.sort(list2, new 3(this));
                        long j = 0;
                        for (d dVar2 : list2) {
                            long j2 = dVar2.mBB + j;
                            if (!hashMap2.containsKey(cVar.aKQ()) || ((float) j2) < ((float) ((c) hashMap2.get(cVar.aKQ())).mBB) * 0.8f) {
                                j = j2;
                            } else {
                                if (((float) dVar2.mBB) >= 1.0f) {
                                    if (hashMap.containsKey(Long.valueOf(cVar.mBu))) {
                                        hashMap.remove(Long.valueOf(cVar.mBu));
                                    }
                                    hashMap3.put(dVar2.mBv + ">" + dVar2.axZ, dVar2);
                                }
                                hashMap4.remove(cVar.aKQ());
                            }
                        }
                        hashMap4.remove(cVar.aKQ());
                    }
                }
            }
            if (hashMap3.containsKey(cVar.aKQ()) && ((float) ((d) hashMap3.get(cVar.aKQ())).mBB) * 0.9f <= ((float) cVar.mBB)) {
                dVar.a(((d) hashMap3.get(cVar.aKQ())).mBD);
                dVar.dt(cVar.mBv);
                hashMap3.remove(cVar.getKey());
                hashMap3.put(cVar.getKey(), dVar);
            }
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] root size:%s", new Object[]{Integer.valueOf(hashMap.size())});
        for (Entry value : hashMap.entrySet()) {
            linkedList.add(value.getValue());
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] nextHashMap size:%s", new Object[]{Integer.valueOf(hashMap3.size())});
        for (Entry value2 : hashMap3.entrySet()) {
            linkedList.add(value2.getValue());
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] reportList size:%s", new Object[]{Integer.valueOf(linkedList.size())});
        hashMap.clear();
        hashMap3.clear();
        hashMap2.clear();
        return linkedList;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = this.mBF;
        int i = this.mBG;
        int i2 = this.mnk;
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] start:%s, end:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        long currentTimeMillis2 = System.currentTimeMillis();
        List linkedList = new LinkedList();
        if (i2 < i) {
            i = jArr.length - i;
            x.d("MicroMsg.AsyncAnalyseTask", "end < start start:%s", new Object[]{Integer.valueOf(i)});
        }
        long j;
        b$a com_tencent_mm_plugin_fps_lighter_c_b_a;
        int i3;
        if (i < 0) {
            for (i += jArr.length; i < jArr.length; i++) {
                if (jArr[i] != 0) {
                    j = jArr[i];
                    com_tencent_mm_plugin_fps_lighter_c_b_a = new b$a();
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBx = ((j >> 63) & 1) == 1;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBy = (j >> 46) & Constants.MAX_THREAD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBv = (j >> 27) & Constants.MAX_METHOD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.hOG = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(com_tencent_mm_plugin_fps_lighter_c_b_a);
                }
            }
            for (i3 = 0; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    com_tencent_mm_plugin_fps_lighter_c_b_a = new b$a();
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBx = ((j >> 63) & 1) == 1;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBy = (j >> 46) & Constants.MAX_THREAD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBv = (j >> 27) & Constants.MAX_METHOD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.hOG = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(com_tencent_mm_plugin_fps_lighter_c_b_a);
                }
            }
        } else {
            for (i3 = i; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    com_tencent_mm_plugin_fps_lighter_c_b_a = new b$a();
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBx = ((j >> 63) & 1) == 1;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBy = (j >> 46) & Constants.MAX_THREAD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.mBv = (j >> 27) & Constants.MAX_METHOD_ID;
                    com_tencent_mm_plugin_fps_lighter_c_b_a.hOG = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(com_tencent_mm_plugin_fps_lighter_c_b_a);
                }
            }
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] size:%s costTime:%s", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        List a = a(linkedList, this.mBE);
        List aO = aO(a);
        LinkedList a2 = a(this.mBE, aO);
        if (this.mBH != null) {
            this.mBH.K(a2);
        } else {
            x.e("MicroMsg.AsyncAnalyseTask", "mIFPSAnalyse is null!");
            a2.clear();
        }
        a.clear();
        aO.clear();
        x.i("MicroMsg.AsyncAnalyseTask", "cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
