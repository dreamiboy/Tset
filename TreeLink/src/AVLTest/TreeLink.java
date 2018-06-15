package AVLTest;



public class TreeLink {
	
	int data;      // 节点中的数据  
	int height;       // 节点的高度 
	TreeLink left;         // 左儿子  
    TreeLink right;        // 右儿子  
     
	
    TreeLink(int data) {  
         this( data, null, null );  
    }  
	TreeLink(int data, TreeLink left, TreeLink right ) {  
         this.data = data;  
         this.left = left;  
         this.right = right;  
         this.height = 0;  
    }
	@Override
	public String toString() {
		return "TreeLink [data=" + data + ", height=" + height + ", left=" + left + ", right=" + right + "]";
	}
	
	
     
}
