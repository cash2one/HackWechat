package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, CollectSession> gMU = new a();
    private Map<String, Set<CollectSession>> iLQ = new a();

    private boolean a(String str, CollectSession collectSession) {
        if (str == null || str.length() == 0 || collectSession == null) {
            return false;
        }
        Set set = (Set) this.iLQ.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.iLQ.put(str, set);
        }
        return set.add(collectSession);
    }

    private Set<CollectSession> qu(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (Set) this.iLQ.get(str);
    }

    public final void clear() {
        this.gMU.clear();
        this.iLQ.clear();
    }

    private CollectSession qv(String str) {
        CollectSession collectSession = (CollectSession) this.gMU.get(str);
        if (collectSession != null) {
            return collectSession;
        }
        collectSession = new CollectSession(str);
        this.gMU.put(str, collectSession);
        return collectSession;
    }

    public final void a(CollectSession collectSession) {
        String str = collectSession.id;
        CollectSession collectSession2 = (CollectSession) this.gMU.get(str);
        if (collectSession2 == null) {
            this.gMU.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            return;
        }
        TimePoint timePoint = collectSession.iLG;
        if (collectSession2.iLG == null) {
            collectSession2.iLG = timePoint;
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.iLS.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession qv = qv(str);
                if (qv.iLG == null) {
                    qv.qk(str2);
                    qv.iLG.iLS.set(j);
                } else {
                    TimePoint timePoint2 = (TimePoint) qv.iLI.get(str2);
                    if (timePoint2 == null) {
                        qv.ql(str2);
                        qv.iLH.iLS.set(j);
                    } else {
                        timePoint2.iLS.set((j + (timePoint2.iLS.get() * ((long) timePoint2.iLR.get()))) / ((long) (timePoint2.iLR.get() + 1)));
                        timePoint2.iLR.getAndIncrement();
                    }
                }
            }
            timePoint = (TimePoint) timePoint.iLT.get();
        }
    }

    public final CollectSession aR(String str, String str2) {
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return null;
        }
        CollectSession qv = qv(str);
        if (qv.iLG == null) {
            qv.qk(str2);
            return qv;
        }
        qv.ql(str2);
        return qv;
    }

    public final void c(String str, String str2, boolean z) {
        if (!z) {
            return;
        }
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return;
        }
        CollectSession qv = qv(str);
        if (qv.iLG == null) {
            qv.qk(str2);
        } else {
            qv.ql(str2);
        }
    }

    public final void b(String str, String str2, String str3, boolean z) {
        if (!z) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str3});
        } else if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[]{str3});
        } else {
            CollectSession qv = qv(str2);
            if (qv.iLG == null) {
                qv.groupId = str;
                a(str, qv);
                qv.qk(str3);
                return;
            }
            qv.ql(str3);
        }
    }

    public final CollectSession qm(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.gMU.get(str);
    }

    public final CollectSession qn(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.gMU.remove(str);
    }

    public final void aS(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[]{str, str2});
            return;
        }
        CollectSession collectSession = (CollectSession) this.gMU.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[]{str, str2});
            return;
        }
        collectSession.iLJ = str2;
    }

    public final void print(String str) {
        CollectSession collectSession = (CollectSession) this.gMU.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[]{str});
            return;
        }
        TimePoint timePoint = collectSession.iLG;
        if (timePoint == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[]{str});
            return;
        }
        e.a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.id}));
        x.i("MicroMsg.SumCostTimeCollector", "%s", new Object[]{r1.toString()});
    }

    public final StringBuilder qo(String str) {
        Collection qu = qu(str);
        if (qu == null || qu.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
        }
        Set<CollectSession> linkedHashSet = new LinkedHashSet(qu);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.iLH == null || !(collectSession.iLJ == null || collectSession.iLH.name.equals(collectSession.iLJ))) {
                x.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[]{collectSession.id});
            } else {
                TimePoint timePoint2 = collectSession.iLG;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    timePoint3.iLS.set(((timePoint3.iLS.get() * ((long) timePoint3.iLR.get())) + timePoint2.iLS.get()) / ((long) timePoint3.iLR.incrementAndGet()));
                    timePoint3.name = timePoint2.name;
                    timePoint2 = (TimePoint) timePoint2.iLT.get();
                    if (timePoint3.iLT.get() == null && timePoint2 != null) {
                        timePoint3.iLT.set(new TimePoint());
                    }
                    timePoint3 = (TimePoint) timePoint3.iLT.get();
                }
            }
        }
        StringBuilder a = e.a(timePoint);
        a.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        return a;
    }

    public final int aT(String str, String str2) {
        Collection qu = qu(str);
        if (qu == null || qu.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (CollectSession collectSession : new LinkedHashSet(qu)) {
            int i3 = collectSession.fxd.getInt(str2);
            if (i3 != 0) {
                i2 += i3;
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }
}
