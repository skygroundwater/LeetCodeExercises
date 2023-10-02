public class Exercise2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int ints1 = Integer.parseInt(l1.stringWithReversedNumbers());
        int ints2 = Integer.parseInt(l2.stringWithReversedNumbers());

        char[] sum = String.valueOf(ints1 + ints2).toCharArray();

        ListNode listNode = new ListNode();

        for (int i = sum.length - 1; i >= 0; i--) {
            listNode.add(Integer.parseInt(String.valueOf(sum[i])));
        }

        return listNode;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);

        ListNode l2 = new ListNode(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);

        System.out.println(l1.stringWithReversedNumbers());
        System.out.println(l2.stringWithReversedNumbers());

        System.out.println(addTwoNumbers(l1, l2));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public void add(int integer) {
            ListNode listNode = this;
            while (listNode.hasNext()) {
                listNode = listNode.next;
            }
            listNode.next = new ListNode(integer);

        }

        public String stringWithReversedNumbers() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode listNode = this;
            stringBuilder.append(listNode.val);
            while (listNode.hasNext()) {
                listNode = listNode.next;
                stringBuilder.append(listNode.val);
            }
            String numbers = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            char[] chars = numbers.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                stringBuilder.append(chars[i]);
            }
            return stringBuilder.toString();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode listNode = this;
            stringBuilder.append(listNode.val);
            if (this.hasNext()) {
                listNode = this.next;
                stringBuilder.append(listNode.val);
            }
            stringBuilder.append(listNode.val);
            return stringBuilder.toString();
        }

    }
}
