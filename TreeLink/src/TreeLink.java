
public class TreeLink {
	int data;		//节点内的元素
	TreeLink leftNode;	//左子树
	TreeLink rightNode;	//右子树
	
	public TreeLink(int data,TreeLink leftNode,TreeLink rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	@Override
	public String toString() {
		return "TreeLink [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}
	
	
}
