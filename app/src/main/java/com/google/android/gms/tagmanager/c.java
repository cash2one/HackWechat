package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {
    public static final Object bbm = new Object();
    static final String[] bbn = "gtm.lifetime".toString().split("\\.");
    private static final Pattern bbo = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> bbp;
    private final Map<String, Object> bbq;
    private final ReentrantLock bbr;
    private final LinkedList<Map<String, Object>> bbs;
    private final c bbt;
    private final CountDownLatch bbu;

    c() {
        this(new 1());
    }

    c(c cVar) {
        this.bbt = cVar;
        this.bbp = new ConcurrentHashMap();
        this.bbq = new HashMap();
        this.bbr = new ReentrantLock();
        this.bbs = new LinkedList();
        this.bbu = new CountDownLatch(1);
        this.bbt.a(new 2(this));
    }

    private void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new a(str2, entry.getValue()));
            }
        }
    }

    private void b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                b((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                b((Map) obj, (Map) list2.get(i));
            } else if (obj != bbm) {
                list2.set(i, obj);
            }
        }
    }

    private void b(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                b((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    private static Long bd(String str) {
        Matcher matcher = bbo.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                new StringBuilder("illegal number in _lifetime value: ").append(str);
                parseLong = 0;
                m.qE();
            }
            if (parseLong <= 0) {
                new StringBuilder("non-positive _lifetime: ").append(str);
                m.qF();
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    new StringBuilder("unknown units in _lifetime: ").append(str);
                    m.qE();
                    return null;
            }
        }
        new StringBuilder("unknown _lifetime: ").append(str);
        m.qF();
        return null;
    }

    private void e(Map<String, Object> map) {
        this.bbr.lock();
        try {
            this.bbs.offer(map);
            if (this.bbr.getHoldCount() == 1) {
                int i = 0;
                while (true) {
                    Map map2 = (Map) this.bbs.poll();
                    if (map2 == null) {
                        break;
                    }
                    synchronized (this.bbq) {
                        for (String str : map2.keySet()) {
                            b(j(str, map2.get(str)), this.bbq);
                        }
                    }
                    for (b g : this.bbp.keySet()) {
                        g.g(map2);
                    }
                    int i2 = i + 1;
                    if (i2 > 500) {
                        this.bbs.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                    i = i2;
                }
            }
            Object f = f(map);
            Long bd = f == null ? null : bd(f.toString());
            if (bd != null) {
                List arrayList = new ArrayList();
                a(map, "", arrayList);
                arrayList.remove("gtm.lifetime");
                this.bbt.a(arrayList, bd.longValue());
            }
            this.bbr.unlock();
        } catch (Throwable th) {
            this.bbr.unlock();
        }
    }

    private static Object f(Map<String, Object> map) {
        String[] strArr = bbn;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    static Map<String, Object> j(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    final void a(b bVar) {
        this.bbp.put(bVar, Integer.valueOf(0));
    }

    public final void d(Map<String, Object> map) {
        try {
            this.bbu.await();
        } catch (InterruptedException e) {
            m.qE();
        }
        e(map);
    }

    public final String toString() {
        String stringBuilder;
        synchronized (this.bbq) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.bbq.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
