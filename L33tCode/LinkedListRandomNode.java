import java.util.Random;

public class LinkedListRandomNode {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {     
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        private ListNode head;
        private Random random;

        // instantiates the object with the head of the linked list
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }
        
        public int getRandom() {
            int count = 0, result = 0;
            ListNode current = head;
            
            while (current != null) {
                count++;
                if (random.nextInt(count) == 0) {
                    result = current.val;
                }
                current = current.next;
            }
            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}