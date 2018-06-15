package AVLTest;



public class TreeLink {
	
	int data;      // �ڵ��е�����  
	int height;       // �ڵ�ĸ߶� 
	TreeLink left;         // �����  
    TreeLink right;        // �Ҷ���  
     
	
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
