package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class aj {
    private static LinkedList<View> yxV = new LinkedList();
    private static LinkedList<View> yxW = new LinkedList();

    public static View FB(int i) {
        LinkedList linkedList = i == 1 ? yxV : yxW;
        if (linkedList.size() != 0) {
            return (View) linkedList.removeFirst();
        }
        return null;
    }

    public static void K(View view, int i) {
        LinkedList linkedList = i == 1 ? yxV : yxW;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
    }

    public static void clear() {
        yxV.clear();
        yxW.clear();
    }
}
