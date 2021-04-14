public class MyBinaryTree<K extends Comparable<K>> {

	private MyBinaryNode<K> root;

   //USE CSAE 1, 2 - Creation of Binary Tree
	public void add(K key)
	{
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key)
	{
		if(current==null)
			return new MyBinaryNode<>(key);
		int compareResult = key.compareTo(current.key);
	    if(compareResult == 0) return current;
	    if(compareResult < 0)
	    {
	    	current.left = addRecursively(current.left, key);
	    }
	    else
	    {
	    	current.right = addRecursively(current.right, key);
	    }
	    return current;
	}

	public int getSize()
	{
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(MyBinaryNode<K> current)
	{
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
		                               + this.getSizeRecursive(current.right);
	}

   //USE CASE 3 - Search in Binary Tree
   public boolean search(K key)
	{
		if(this.root == key)
		{
			return true;
		}
		else
		{
			return searchRecursively(root, key);
		}
	}

	private boolean searchRecursively(MyBinaryNode<K> current, K key)
	{
		int compareResult = key.compareTo(current.key);
	    if(compareResult == 0) return true;
	    if(compareResult < 0)
	    {
	    	searchRecursively(current.left, key);
	    }
	    else
	    {
	    	searchRecursively(current.right, key);
	    }
	    return true;
	}
}

