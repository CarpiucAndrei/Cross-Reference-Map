
class BinaryNode {
	Object data;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(Object d) {
		data = d;
		left = right = null;
	}
	public Object getData() {
		return data;
	}
} // class BinaryNode

public class BinarySearchTree {

	private BinaryNode root;
	private LinkedList list;

	public BinarySearchTree() {
		root = null;
		//this.list = list;
	}
	
	public BinarySearchTree(LinkedList list) {
		root = null;
		this.list = list;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean search(Object x) {
		if (search(root, x) != null)
			return true;
		else
			return false;
	}

	private BinaryNode search(BinaryNode t, Object x) {
		if (t == null)
			return null;
		if (((Comparable)x).compareTo(t.data) < 0)
			return search(t.left, x);
		else if (((Comparable)x).compareTo(t.data) > 0)
				return search(t.right, x);
			 else
				return t;
	}

	public void insert(Object x) {
		root = insertSubtree(root, x);
	}

	private BinaryNode insertSubtree(BinaryNode t, Object x) {
		if (t == null)
			t = new BinaryNode(x);
		else if (((Comparable)x).compareTo(t.data) < 0)
			t.left = insertSubtree(t.left, x);
		else //if (((Comparable)x).compareTo(t.data) > 0)
			t.right = insertSubtree(t.right, x);
		return t;
	}

	private void visit(BinaryNode t) {
		//System.err.print(t.data + " ");
		boolean search = true;
		ListNode current = list.getHead();
		//System.out.print(current.getData() + " ");
		   //LinkedList node = (LinkedList)current.getData();
		   //ListNode current2 = node.getHead();
		
		   while(current != null && search == true)
		   {
			   //current = current.getNext();
			   //System.out.print(current.getData() + " ");
			   LinkedList node = (LinkedList)current.getData();
			   ListNode current2 = node.getHead();
			   
			   if( t.data.equals(current2.getData()) )
			   {
				   search = false;
				   //System.out.print(t.data + " ");
				   while(current2 != null)
				   {
					   //System.out.print(t.data + " ");
					   System.out.print(current2.getData() + " ");
					   current2 = current2.getNext();
				   }
			   }
			   
			   current = current.getNext();
		   }
		   
		System.out.println();
	}

	public void preorder() {
		preorderSubtree(root);
		System.out.println();
	}

	private void preorderSubtree(BinaryNode t) {
		if (t == null) return;
		visit(t);
		preorderSubtree(t.left);
		preorderSubtree(t.right);
	}

	public void inorder() {
		inorderSubtree(root);
		System.out.println();
	}

	private void inorderSubtree(BinaryNode t) {
		if (t == null) return;
		inorderSubtree(t.left);
		visit(t);
		inorderSubtree(t.right);
	}

	public void postorder() {
		postorderSubtree(root);
		System.out.println();
	}

	private void postorderSubtree(BinaryNode t) {
		if (t == null) return;
		postorderSubtree(t.left);
		postorderSubtree(t.right);
		visit(t);
	}

	public Object getMin() {
		return findMin(root).data;
	}

	private BinaryNode findMin(BinaryNode t) {
		if (t == null)
			return null;
		else if (t.left == null)
				return t;
			 else
				return findMin(t.left);
	}

	public Object getMax() {
		return findMax(root).data;
	}

	private BinaryNode findMax(BinaryNode t) {
		if (t == null)
			return null;
		else if (t.right == null)
				return t;
			 else
				return findMax(t.right);
	}

	public void delete(Object x) {
		root = deleteSubtree(root, x);
	}

	private BinaryNode deleteSubtree(BinaryNode t, Object x) {
		BinaryNode temp, child;

		if (t == null) return null;
		if (((Comparable)x).compareTo(t.data) < 0)
			t.left = deleteSubtree(t.left, x);
		else if (((Comparable)x).compareTo(t.data) > 0)
			t.right = deleteSubtree(t.right, x);
		else if (t.left != null && t.right != null) {
			/* has 2 leaves */
			t.data = findMin(t.right).data;
			t.right = deleteSubtree(t.right, t.data);
		}
		else
			t = (t.left != null) ? t.left : t.right;

		return t;
	}

	public int size() {
		return sizeSubtree(root);
	}

	private int sizeSubtree(BinaryNode t) {
		if (t == null) return 0;
		return sizeSubtree(t.left) + sizeSubtree(t.right) + 1;
	}

	public int height() {
		return heightSubtree(root);
	}

	private int heightSubtree(BinaryNode t) {
		if (t == null) return -1;
		int h = heightSubtree(t.left);
		int k = heightSubtree(t.right);
		return h > k ? h + 1 : k + 1;
	}
	

	
	public BinaryNode getRoot()
	{
		return root;
	}

} // class BinarySearchTree