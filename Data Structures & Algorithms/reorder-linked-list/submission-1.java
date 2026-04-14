/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;        // 1 over
            fast = fast.next.next;   //  2 over
        }

        
        ListNode second = slow.next;
        slow.next = null; 

        ListNode prev = null;

        while (second != null) {

            ListNode nextTemp = second.next; 
            second.next = prev;              
            prev = second;                  
            second = nextTemp;              
        }

       
        ListNode first = head;
        ListNode secondHalf = prev;

        while (secondHalf != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = temp1;

            first = temp1;
            secondHalf = temp2;
        }
    }
}

        

        
   