package com.tencent.mm.ax;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String hIr = "";
    public static String hIs = "";
    public String TEXT;
    public String TYPE;
    public au fEJ;
    public String hIt = "";
    public String hIu;
    public LinkedList<String> hIv = new LinkedList();
    public LinkedList<Integer> hIw = new LinkedList();
    public LinkedList<Integer> hIx = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> hIy = new HashMap();

        public abstract a a(Map<String, String> map, au auVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (hIy) {
                hIy.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, au auVar) {
            if (map == null) {
                x.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String str = (String) map.get(".sysmsg.$type");
            synchronized (hIy) {
                a aVar = (a) hIy.get(str.toLowerCase());
                if (aVar == null) {
                    x.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", str);
                    return null;
                }
                a a = aVar.a((Map) map, auVar);
                return a;
            }
        }
    }

    public interface b {
        void a(View view, au auVar, a aVar, int i);
    }

    public abstract boolean QA();

    public a(Map<String, String> map, au auVar) {
        this.values = map;
        this.fEJ = auVar;
    }
}
