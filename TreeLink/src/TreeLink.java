
public class TreeLink {
	int data;		//�ڵ��ڵ�Ԫ��
	TreeLink leftNode;	//������
	TreeLink rightNode;	//������
	
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
