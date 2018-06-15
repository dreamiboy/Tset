package AVLTest;



public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
		int num[] = {50,51,53,52,54,56};
		TreeLink first = new TreeLink(num[0]);
		
		for(int i=1; i<num.length ; i++) {
			TreeLink next = new TreeLink(num[i]);
			first = test.insert(next, first);
		}
		
		System.out.println(first);
	}
	//�ڵ�Ĳ������
	private TreeLink insert(TreeLink next, TreeLink node ) {  
        //���nodeΪ�գ����next�ڵ�ɹ�����
		if(node == null) {
			node = next;
			return node;
		}
        int compareResult = next.data - node.data;            
        if( compareResult <= 0 ) {  
            node.left = insert( next, node.left );//��next������������  
            if( height( node.left ) - height( node.right ) == 2 )//����ƽ��  
                if( next.data - node.left.data  < 0 )//LL�ͣ������ͣ�  
                    node = rotateWithLeftChild( node );  
                else   //LR�ͣ������ͣ�  
                    node = doubleWithLeftChild( node );  
        }  
        else if( compareResult > 0 ) {  
        	
            node.right = insert( next, node.right );//��next������������  
            if( height( node.right ) - height( node.left ) == 2 )//����ƽ��  
                if( next.data - node.right.data > 0 )//RR�ͣ������ͣ�  
                	node = rotateWithRightChild( node );  
                else                           //RL��  �������ͣ�
                	node = doubleWithRightChild( node );  
        }  
        
        node.height = Math.max( height( node.left ), height( node.right ) ) + 1;//���¸߶�  
        return node;  
    }
	//��ڵ�ĸ߶�
	private int height(TreeLink t) {  
	   return t == null ? -1 : t.height;  
	}
	//����ת��������LL��  
	private TreeLink rotateWithLeftChild(TreeLink k2) {  
        TreeLink k1 = k2.left;  
        k2.left = k1.right;  
        k1.right = k2;  
        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;  
        k1.height = Math.max( height( k1.left ), k2.height ) + 1;  
        return k1;  
    }
	//����ת��������RR��  
	private TreeLink rotateWithRightChild(TreeLink k1) {  
        TreeLink k2 = k1.right;  
        k1.right = k2.left;  
        k2.left = k1;  
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;  
        k2.height = Math.max( height( k2.right ), k1.height ) + 1;  
        return k2;  
    }
	
	//˫��ת��������LR��  
    private TreeLink doubleWithLeftChild(TreeLink k3) {  
        k3.left = rotateWithRightChild( k3.left );  
        return rotateWithLeftChild( k3 );  
    }  
    //˫��ת,������RL��  
    private TreeLink doubleWithRightChild(TreeLink k1) {  
        k1.right = rotateWithLeftChild( k1.right );  
        return rotateWithRightChild( k1 );  
    }
}
