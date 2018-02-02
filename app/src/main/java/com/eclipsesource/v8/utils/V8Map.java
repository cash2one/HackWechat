package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Value;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8Map<V> implements Releasable, Map<V8Value, V> {
    private Map<V8Value, V> map = new HashMap();
    private Map<V8Value, V8Value> twinMap = new HashMap();

    public void release() {
        clear();
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public V get(Object obj) {
        return this.map.get(obj);
    }

    public V put(V8Value v8Value, V v) {
        remove(v8Value);
        V8Value twin = v8Value.twin();
        this.twinMap.put(twin, twin);
        return this.map.put(twin, v);
    }

    public V remove(Object obj) {
        V remove = this.map.remove(obj);
        V8Value v8Value = (V8Value) this.twinMap.remove(obj);
        if (v8Value != null) {
            v8Value.release();
        }
        return remove;
    }

    public void putAll(Map<? extends V8Value, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put((V8Value) entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        this.map.clear();
        for (V8Value release : this.twinMap.keySet()) {
            release.release();
        }
        this.twinMap.clear();
    }

    public Set<V8Value> keySet() {
        return this.map.keySet();
    }

    public Collection<V> values() {
        return this.map.values();
    }

    public Set<Entry<V8Value, V>> entrySet() {
        return this.map.entrySet();
    }
}
