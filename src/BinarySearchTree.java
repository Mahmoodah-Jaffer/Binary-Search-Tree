/**
This class uses a BinarySearchTree to read in data from a CSV file as well as being able to find details for a datetime that the user enters
@author Patrick Marais - modified by @author Mahmoodah Jaffer
@author SJ (via https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/) - modified by @author Mahmoodah Jaffer
@author Mahmoodah Jaffer - JFFMAH001
@since 28 February 2019
*/

public class BinarySearchTree {

/**
BinarySearchTree class takes in given datetime, power and voltage and stores it in a Binary Tree where the data can later be searched for/retrieved 
using the functions of the BinarySearchTree 
*/
		
		public static  BinaryTreeNode root;		
		public static int opCount = 0;

	public BinarySearchTree(){
		this.root = null;	
    }
	
	public PowerStation find ( String d )
	{
	/**
	Method find class returns object of type Powerstation if the String d is the the same as a datetime node in the BinarySearchTree
	@para d String
	@Returns PowerStation
	*/
		if (root == null)
			return null;
		else
			return find (d, root);
	}
	public PowerStation find ( String d, BinaryTreeNode node )
	{	
	/**
	Method find returns object of type Powerstation if the String d is the the same as a datetime node in the BinarySearchTree
	@para d String
	@para node BinaryTreeNode
	@Returns PowerStation
	*/
		if (d.compareTo (node.data.getDateTime()) == 0){
			opCount++;
			return node.data;
		}
		else if (d.compareTo (node.data.getDateTime())< 0){
			opCount++;
			return (node.left == null) ? null : find (d, node.left);
		}
		else{
			return (node.right == null) ? null : find (d, node.right);
		}
	}

	public void insert ( PowerStation d )
 	{
 	/**
	Method insert takes in  object of type Powerstation and stores it in a node in the BinarySearchTree
	@para d Powerstation
	@Returns void
	*/
 		if (root == null)
 			root = new BinaryTreeNode (d, null, null);
 		else
 			insert (d, root);
 	}

 	public void insert ( PowerStation d, BinaryTreeNode node )
 	{
 		 /**
		Method insert takes in  object of type Powerstation and stores it in a node in the BinarySearchTree
		@para d Powerstation
		@Returns void
		*/
 		if ((d.getDateTime()).compareTo (node.data.getDateTime()) <= 0)
 		{
 			if (node.left == null)
				 node.left = new BinaryTreeNode (d, null, null);
 			else
 				insert (d, node.left);
 		}
 		else
 		{
 			if (node.right == null)
 				node.right = new BinaryTreeNode (d, null, null);
			 else
 			insert (d, node.right);
 		}
 	}

 	public void display(){
 		/**
		Method display calls on display function in the BinarySearchTree class
		@para None
		@Returns void
		*/
 		display(root);
 	}


	public void display(BinaryTreeNode root){
		/**
		Method display returns the entire BinarySearchTree
		@para None
		@Returns void
		*/
		if(root!=null){
			display(root.left);
			System.out.println(root.data);
			display(root.right);
		}
	}

	public int Counter(){
		/**
		Method Counter returns value of opCount that is in the class BinaySearchTree
		@para None
		@Returns integer temp that is the temporary placekeeper for opCount
		*/
		int temp = opCount;
		opCount = 0;
		return temp;
	}

class BinaryTreeNode
{
		/**
		BinaryTreeNode is an innerclass of the class BinarySearchTree that creates each node in the tree and allows it store type PowerStation
		*/
	PowerStation data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode ( PowerStation d, BinaryTreeNode l,BinaryTreeNode r )
	{
		/**
		BinaryTreeNode Method takes in an object of type PowerStation and will store it as the value of a node in the BinaryTree
		@param d PowerStation
		@param l BinaryTreeNode
		@param r BinaryTreeNode
		@Returns none
		*/
		data = d;
		left = l;
		right = r;
	}
}

}