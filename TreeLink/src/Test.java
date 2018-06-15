
public class Test {
	
	public static void main(String[] args) {
		int num[] = {4,2,1,3,5,7,6,8};
		TreeLink first = new TreeLink(num[0], null, null);
		
		for(int i=1; i<num.length ; i++) {
			TreeLink next = new TreeLink(num[i], null, null);
			add(next,first);
		}
		
		System.out.println(first);
	}
	
	public static void add(TreeLink next,TreeLink node) {
		if(next.data >= node.data) {
			if(node.rightNode == null) {
				node.rightNode = next;
			}else {
				add(next,node.rightNode);
			}
		}else {
			if(node.leftNode == null) {
				node.leftNode = next;
			}else {
				add(next,node.leftNode);
			}
		}
	}
}



