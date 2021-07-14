package leecode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class TwoAdd {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] arr1=listNodeToArr(l1);
        int[] arr2=listNodeToArr(l2);
        int[] arr3=add(arr1,arr2);
        return arrToListNode(arr3);
    }

    public static int[] add(int[] arr1,int[] arr2){
        int a= arr1.length;
        int b=arr2.length;
        int length = Math.max(a, b);
        int[] myArr1=new int[length];
        int[] myArr2;
        if (a > b) {
            System.arraycopy(arr2,0,myArr1,0,b);
            myArr2=arr1;
        }else {
            System.arraycopy(arr1,0,myArr1,0,a);
            myArr2=arr2;
        }
        int[] result1=new int[length+1];
        for (int i = 0; i <length ; i++) {
            if (myArr1[i]+myArr2[i]+result1[i]>9){
                result1[i+1]=1;
            }
            int num = (myArr1[i]+myArr2[i]+result1[i])%10;
            result1[i]=num;
        }
        if (result1[length]==0){
            int[] result = new int[length];
            System.arraycopy(result1,0,result,0,length);
            int[] Fresult=new int[length];
            int x=length-1;
            for (int i = 0; i <length ; i++) {
                Fresult[i] = result[x];
                x=x-1;
            }
            return Fresult;
        }else {
            int[] Fresult=new int[result1.length];
            int x=length;
            for (int i = 0; i <result1.length ; i++) {
                Fresult[i] = result1[x];
                x=x-1;
            }
            return Fresult;
        }
    }

    public static ListNode arrToListNode(int[] arr){
        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            nodes[i] = new ListNode(arr[i]);
        }
        for (int i = nodes.length-1; i >0 ; i--) {
            nodes[i].next = nodes[i-1];
        }
        return nodes[nodes.length-1];
    }

    public static int[] listNodeToArr(ListNode listNode){
        ListNode node = new ListNode();
        node= listNode;
        int[] arr = new int[getListSize(listNode)];

        int i=0;
        while (node!=null){
            arr[i] = node.val;
            node=node.next;
            i++;
        }
        return arr;
    }

    public  static int getListSize(ListNode l1){
        ListNode node=new ListNode();
        node= l1;
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }


    public static long ListToInt(ListNode l1){
        ListNode node=new ListNode();
        node=l1;
        long result=0;
        long multiple=1;
        while (node!=null){
            result+=node.val*multiple;
            multiple=multiple*10;
            node=node.next;
        }
        return result;
    }
    public static ListNode IntToList(long num){
        String nums = num + "";
        char[] numArray = nums.toCharArray();//字符串函数，将字符串分为单个字符并存入数组
        int[] numInt = new int[numArray.length];
        ListNode[] listNode = new ListNode[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            numInt[i] = Integer.parseInt(numArray[i] + "");
            listNode[i] = new ListNode(numInt[i]);
        }
        for (int i = listNode.length-1; i >0 ; i--) {
            listNode[i].next=listNode[i-1];
        }
        return listNode[listNode.length-1];
    }



    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2,listNode);
//        ListNode listNode2 = new ListNode(3,listNode1);
//        ListNode listNode3 = new ListNode(4,listNode2);
//        ListNode listNode4 = new ListNode(5,listNode3);

//        ListNode listNode = IntToList(345);
//
//        ListNode node=new ListNode();
//        node=listNode;
//        while (node!=null){
//            System.out.println(node.val);
//            node=node.next;
//        }
//        ListNode listNode1 = IntToList(345);
//        System.out.println(ListToInt(listNode1));
//        [1000000000000000000000000000001]
//[5,6,4]
//        ListNode listNode1 = IntToList(9);
//        ListNode listNode2 = IntToList(9999999991l);
//        ListNode listNode=addTwoNumbers(listNode1,listNode2);
//
//        int arr[] =listNodeToArr(listNode2);
//
//        System.out.println(getListSize(listNode2));
        int[] arr = {2,4,3};
        int[] arr1={5,6,4};

        int[] arr3=add(arr,arr1);
        System.out.println(arr3);

        ListNode node=new ListNode();
        node=arrToListNode(arr);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }
}
