package com.tencent.mm.r;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    volatile boolean gJJ = false;
    private volatile boolean gJK = false;
    public List<Map<String, String>> gJL = new CopyOnWriteArrayList();

    public final synchronized boolean Bc() {
        boolean z;
        if (this.gJL.size() <= 0) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
            z = false;
        } else if (this.gJK) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
            z = false;
        } else {
            this.gJK = true;
            Map map = (Map) this.gJL.remove(0);
            String str = (String) map.get(".sysmsg.functionmsg.cgi");
            int i = bh.getInt((String) map.get(".sysmsg.functionmsg.cmdid"), 0);
            String str2 = (String) map.get(".sysmsg.functionmsg.functionmsgid");
            long j = bh.getLong((String) map.get(".sysmsg.functionmsg.version"), 0);
            int i2 = bh.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
            String str3 = (String) map.get(".sysmsg.functionmsg.custombuff");
            x.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.functionmsg.retryinterval"), 0)), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.functionmsg.reportid"), 0)), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.functionmsg.successkey"), 0)), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.functionmsg.failkey"), 0)), Integer.valueOf(bh.getInt((String) map.get(".sysmsg.functionmsg.finalfailkey"), 0)), str3});
            com.tencent.mm.sdk.e.c dVar = new d();
            if (!bh.ov(str)) {
                dVar.field_cgi = str;
            }
            dVar.field_cmdid = i;
            if (!bh.ov(str2)) {
                dVar.field_functionmsgid = str2;
            }
            dVar.field_version = j;
            dVar.field_retryinterval = r10;
            dVar.field_reportid = r11;
            dVar.field_successkey = r12;
            dVar.field_failkey = r13;
            dVar.field_finalfailkey = r14;
            if (!bh.ov(str3)) {
                dVar.field_custombuff = str3;
            }
            dVar.field_status = -1;
            dVar.b(null);
            int intValue = Integer.valueOf((String) map.get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
            com.tencent.mm.sdk.e.c fc = i.Bl().fc(dVar.field_functionmsgid);
            if (fc != null) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", new Object[]{Integer.valueOf(fc.field_status), Long.valueOf(fc.field_version), Long.valueOf(fc.field_preVersion)});
            }
            x.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", new Object[]{fc});
            if (i2 == 0) {
                dVar.field_needShow = true;
                if (fc == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", new Object[]{dVar.field_functionmsgid});
                    i.Bl().b(dVar);
                } else if (fc.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", new Object[]{dVar.field_functionmsgid});
                    fc.field_preVersion = fc.field_version;
                    dVar.field_preVersion = fc.field_version;
                    i.Bl().a(fc.field_functionmsgid, dVar);
                }
                Be();
            } else if (i2 == 1) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
                if (fc != null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", new Object[]{fc.field_functionmsgid, Long.valueOf(dVar.field_version), Long.valueOf(fc.field_version)});
                    if (dVar.field_version == fc.field_version || dVar.field_version == 0) {
                        if (fc != null) {
                            try {
                                bw a = a(fc.field_addMsg);
                                str3 = "MicroMsg.FunctionMsgFetcher";
                                r6 = "callbackToDelete, msgContent==null: %s";
                                r7 = new Object[1];
                                r7[0] = Boolean.valueOf(a == null);
                                x.d(str3, r6, r7);
                                if (a != null) {
                                    Map singletonMap = Collections.singletonMap(fc.field_functionmsgid, fc.field_addMsg);
                                    List<f> list = (List) i.Bk().gKa.get(Integer.valueOf(a.ngq));
                                    if (list != null) {
                                        for (f a2 : list) {
                                            a2.a(1, singletonMap, false);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", new Object[]{e.getMessage()});
                            }
                        }
                        i.Bl().a(fc, new String[0]);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", new Object[]{dVar.field_functionmsgid});
                }
                Bf();
            } else if (i2 == 2) {
                dVar.field_needShow = false;
                if (fc == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", new Object[]{dVar.field_functionmsgid});
                    i.Bl().b(dVar);
                } else if (fc.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", new Object[]{dVar.field_functionmsgid, Long.valueOf(fc.field_preVersion)});
                    fc.field_preVersion = fc.field_version;
                    dVar.field_preVersion = fc.field_version;
                    i.Bl().a(fc.field_functionmsgid, dVar);
                }
                Be();
            } else {
                if (i2 == 3) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", new Object[]{dVar.field_functionmsgid, fc});
                    dVar.field_needShow = true;
                    if (fc != null) {
                        str3 = "MicroMsg.FunctionMsgFetcher";
                        r6 = "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s";
                        r7 = new Object[3];
                        r7[0] = Long.valueOf(dVar.field_version);
                        r7[1] = Long.valueOf(fc.field_version);
                        r7[2] = Boolean.valueOf(fc.field_addMsg == null);
                        x.i(str3, r6, r7);
                        if (fc.field_version >= dVar.field_version || dVar.field_version == 0) {
                            fc.field_needShow = true;
                            if (fc.field_addMsg != null) {
                                x.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", new Object[]{Integer.valueOf(intValue)});
                                fc.field_addMsg.pbl = intValue;
                            }
                            i.Bl().a(fc.field_functionmsgid, fc);
                            if (fc.field_addMsg != null) {
                                b(Collections.singletonList(fc), true);
                            }
                        }
                    }
                }
                Bf();
            }
            z = true;
        }
        return z;
    }

    private static bw a(bw bwVar) {
        boolean z = true;
        if (bwVar == null) {
            return null;
        }
        String str = "MicroMsg.FunctionMsgFetcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = bwVar.vGX;
        objArr[1] = Integer.valueOf(bwVar.ngq);
        if (bwVar.vGZ != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        String ou = bh.ou(n.a(bwVar.vGX));
        if ("readerapp".equals(ou)) {
            bwVar.vGX = n.os("newsapp");
            bwVar.ngq = 12399999;
        }
        if (!"blogapp".equals(ou) && !"newsapp".equals(ou)) {
            return bwVar;
        }
        bwVar.ngq = 12399999;
        return bwVar;
    }

    public final synchronized boolean Bd() {
        return this.gJJ;
    }

    public final synchronized void Be() {
        if (this.gJJ) {
            x.k("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
            Bf();
        } else if (an.isNetworkConnected(ac.getContext())) {
            this.gJJ = true;
            List Bg = i.Bl().Bg();
            x.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", new Object[]{Bg});
            if (Bg == null || Bg.size() <= 0) {
                this.gJJ = false;
                Bf();
            } else {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", new Object[]{Integer.valueOf(Bg.size())});
                new b(Bg, new 1(this)).start();
            }
        } else {
            x.k("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
            Bf();
        }
    }

    final void Bf() {
        x.k("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
        this.gJK = false;
        Bc();
    }

    static void b(List<d> list, boolean z) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collection arrayList = new ArrayList();
                    for (d dVar : list) {
                        if (dVar.field_needShow) {
                            dVar.b(a(dVar.field_addMsg));
                            arrayList.add(dVar);
                        }
                    }
                    x.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", new Object[]{Integer.valueOf(arrayList.size()), Boolean.valueOf(z)});
                    Map c = c(arrayList);
                    for (Integer intValue : c.keySet()) {
                        int intValue2 = intValue.intValue();
                        List<d> list2 = (List) c.get(Integer.valueOf(intValue2));
                        Map hashMap = new HashMap();
                        for (d dVar2 : list2) {
                            hashMap.put(dVar2.field_functionmsgid, dVar2.field_addMsg);
                        }
                        List<f> list3 = (List) i.Bk().gKa.get(Integer.valueOf(intValue2));
                        if (list3 != null) {
                            for (f a : list3) {
                                a.a(0, hashMap, z);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private static Map<Integer, List<d>> c(Collection<d> collection) {
        Map<Integer, List<d>> hashMap = new HashMap();
        for (d dVar : collection) {
            if (dVar.field_addMsg != null) {
                List list = (List) hashMap.get(Integer.valueOf(dVar.field_addMsg.ngq));
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(dVar);
                hashMap.put(Integer.valueOf(dVar.field_addMsg.ngq), list);
            }
        }
        return hashMap;
    }
}
