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
	//节点的插入操作
	private TreeLink insert(TreeLink next, TreeLink node ) {  
        //如果node为空，则把next节点成功插入
		if(node == null) {
			node = next;
			return node;
		}
        int compareResult = next.data - node.data;            
        if( compareResult <= 0 ) {  
            node.left = insert( next, node.left );//将next插入左子树中  
            if( height( node.left ) - height( node.right ) == 2 )//打破平衡  
                if( next.data - node.left.data  < 0 )//LL型（左左型）  
                    node = rotateWithLeftChild( node );  
                else   //LR型（左右型）  
                    node = doubleWithLeftChild( node );  
        }  
        else if( compareResult > 0 ) {  
        	
            node.right = insert( next, node.right );//将next插入右子树中  
            if( height( node.right ) - height( node.left ) == 2 )//打破平衡  
                if( next.data - node.right.data > 0 )//RR型（右右型）  
                	node = rotateWithRightChild( node );  
                else                           //RL型  （右左型）
                	node = doubleWithRightChild( node );  
        }  
        
        node.height = Math.max( height( node.left ), height( node.right ) ) + 1;//更新高度  
        return node;  
    }
	//求节点的高度
	private int height(TreeLink t) {  
	   return t == null ? -1 : t.height;  
	}
	//单旋转，适用于LL型  
	private TreeLink rotateWithLeftChild(TreeLink k2) {  
        TreeLink k1 = k2.left;  
        k2.left = k1.right;  
        k1.right = k2;  
        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;  
        k1.height = Math.max( height( k1.left ), k2.height ) + 1;  
        return k1;  
    }
	//单旋转，适用于RR型  
	private TreeLink rotateWithRightChild(TreeLink k1) {  
        TreeLink k2 = k1.right;  
        k1.right = k2.left;  
        k2.left = k1;  
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;  
        k2.height = Math.max( height( k2.right ), k1.height ) + 1;  
        return k2;  
    }
	
	//双旋转，适用于LR型  
    private TreeLink doubleWithLeftChild(TreeLink k3) {  
        k3.left = rotateWithRightChild( k3.left );  
        return rotateWithLeftChild( k3 );  
    }  
    //双旋转,适用于RL型  
    private TreeLink doubleWithRightChild(TreeLink k1) {  
        k1.right = rotateWithLeftChild( k1.right );  
        return rotateWithRightChild( k1 );  
    }
}
