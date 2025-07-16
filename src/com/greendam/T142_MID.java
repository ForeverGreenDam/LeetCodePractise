package com.greendam;

import java.util.HashMap;

public class T142_MID {
    class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    }
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode pointer = head;
        while(pointer != null) {
            if(map.containsKey(pointer)) {
                return pointer;
            }
            map.put(pointer, true);
            pointer = pointer.next;
        }
        return null;
    }
}
