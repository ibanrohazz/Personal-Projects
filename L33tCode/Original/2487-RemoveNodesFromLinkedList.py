# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    # given a linked list, remove all nodes that have a value greater than the given value
    def removeNodes(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if not head or not head.next: # if the list is empty or has only one node
            return head

        prev, curr = None, head # initialize the previous and current nodes
        while curr: # reverse the list
            curr.next, prev, curr = prev, curr, curr.next

        curr, prev.next = prev.next, None
        while curr: # remove all nodes with a value greater than the given value
            temp = curr.next
            if curr.val >= prev.val:
                curr.next = prev
                prev = curr
            curr = temp
    
        return prev
        
        