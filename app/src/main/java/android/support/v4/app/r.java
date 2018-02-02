package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class r {

    static class AnonymousClass2 implements OnPreDrawListener {
        final /* synthetic */ View ro;
        final /* synthetic */ Transition rp;
        final /* synthetic */ View rq;
        final /* synthetic */ b rr;
        final /* synthetic */ Map rs;
        final /* synthetic */ Map rt;
        final /* synthetic */ ArrayList ru;

        AnonymousClass2(View view, Transition transition, View view2, b bVar, Map map, Map map2, ArrayList arrayList) {
            this.ro = view;
            this.rp = transition;
            this.rq = view2;
            this.rr = bVar;
            this.rs = map;
            this.rt = map2;
            this.ru = arrayList;
        }

        public final boolean onPreDraw() {
            this.ro.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.rp != null) {
                this.rp.removeTarget(this.rq);
            }
            View view = this.rr.getView();
            if (view != null) {
                if (!this.rs.isEmpty()) {
                    r.a(this.rt, view);
                    this.rt.keySet().retainAll(this.rs.values());
                    for (Entry entry : this.rs.entrySet()) {
                        View view2 = (View) this.rt.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.rp != null) {
                    r.a(this.ru, view);
                    this.ru.removeAll(this.rt.values());
                    this.ru.add(this.rq);
                    r.b(this.rp, this.ru);
                }
            }
            return true;
        }
    }

    static class AnonymousClass3 extends EpicenterCallback {
        private Rect rv;
        final /* synthetic */ a rw;

        AnonymousClass3(a aVar) {
            this.rw = aVar;
        }

        public final Rect onGetEpicenter(Transition transition) {
            if (this.rv == null && this.rw.rC != null) {
                this.rv = r.x(this.rw.rC);
            }
            return this.rv;
        }
    }

    static class AnonymousClass4 implements OnPreDrawListener {
        final /* synthetic */ View pA;
        final /* synthetic */ ArrayList pC;
        final /* synthetic */ ArrayList rA;
        final /* synthetic */ Transition rB;
        final /* synthetic */ Transition rp;
        final /* synthetic */ View rq;
        final /* synthetic */ Map rt;
        final /* synthetic */ ArrayList ru;
        final /* synthetic */ Transition rx;
        final /* synthetic */ ArrayList ry;
        final /* synthetic */ Transition rz;

        AnonymousClass4(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.pA = view;
            this.rp = transition;
            this.ru = arrayList;
            this.rx = transition2;
            this.ry = arrayList2;
            this.rz = transition3;
            this.pC = arrayList3;
            this.rt = map;
            this.rA = arrayList4;
            this.rB = transition4;
            this.rq = view2;
        }

        public final boolean onPreDraw() {
            this.pA.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.rp != null) {
                r.a(this.rp, this.ru);
            }
            if (this.rx != null) {
                r.a(this.rx, this.ry);
            }
            if (this.rz != null) {
                r.a(this.rz, this.pC);
            }
            for (Entry entry : this.rt.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.rA.size();
            for (int i = 0; i < size; i++) {
                this.rB.excludeTarget((View) this.rA.get(i), false);
            }
            this.rB.excludeTarget(this.rq, false);
            return true;
        }
    }

    public static class a {
        public View rC;
    }

    public interface b {
        View getView();
    }

    public static Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect x = x(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public final Rect onGetEpicenter(Transition transition) {
                return x;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            int size2 = targets.size();
            if (!a(targets, view2, size2)) {
                targets.add(view2);
                for (int i2 = size2; i2 < targets.size(); i2++) {
                    view2 = (View) targets.get(i2);
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!a(targets, childAt, size2)) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    static Rect x(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    static void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (!a(transition) && e(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean a(Transition transition) {
        return (e(transition.getTargetIds()) && e(transition.getTargetNames()) && e(transition.getTargetTypes())) ? false : true;
    }

    private static boolean e(List list) {
        return list == null || list.isEmpty();
    }
}
