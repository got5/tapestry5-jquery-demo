package org.got5.tapestry5.jquery.data;

import java.util.List;
import java.util.UUID;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.tree.DefaultTreeModel;
import org.apache.tapestry5.tree.TreeModel;
import org.apache.tapestry5.tree.TreeModelAdapter;

public class TreeNode<T> {

	/**** ATTRIBUTS ****/
	public final String uuid;

	private String nom;
	
	private boolean selected;

	public final List<TreeNode> children = CollectionFactory.newList();

	public static final TreeNode ROOT= new TreeNode("<root>",null);
	
	
	
	/**** CONSTRUCTOR ****/
	public TreeNode(String nom, String ref) {
		super();
		this.nom = nom;
		if(ref!=null){
			this.uuid = ref;
		}else{
			this.uuid = UUID.randomUUID().toString();
		}
	}
	
	/**** GETTER AND SETTER ****/
	/**
	 * Get Root Node
	 */
	public static TreeNode getRootNode(){
		return ROOT;
	}
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * 
	 * @return A children node list
	 */
	public List<TreeNode> getChildren() {
		return children;
	}

	/**** OTHER METHOD ****/
	/**
	 * 
	 * @param names
	 * @return
	 */
	public TreeNode addChildrenNamed(String... names) {

		for (String name : names) {
			children.add(new TreeNode(name,null));
		}
		return this;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public TreeNode addChild(TreeNode node) {

		children.add(node);

		return this;
	}

	/**
	 * 
	 * @param uuid
	 * @return
	 */
	public TreeNode seek(String uuid) {

		if (this.uuid.equals(uuid))
			return this;

		for (TreeNode child : children) {
			TreeNode match = child.seek(uuid);

			if (match != null)
				return match;
		}

		return null;
	}

	
	static {
		
		ROOT.addChild(new TreeNode("Renault", "1")
						.addChild(new TreeNode("Mégane", "2"))
						.addChild(new TreeNode("Clio", "3")
							.addChildrenNamed("Clio Campus", "Clio Sport")
						)
					 )
			.addChild(new TreeNode("Ferarri", "4").addChildrenNamed("F430", "California"));
		
	}
	
	public static TreeModel<TreeNode> createTreeModel() {

		ValueEncoder encoder = new ValueEncoder<TreeNode>() {

			public String toClient(TreeNode arg0) {
				return arg0.uuid;
			}

			public TreeNode toValue(String arg0) {
				return TreeNode.ROOT.seek(arg0);
			}
		};

		TreeModelAdapter<TreeNode> adapter = new TreeModelAdapter<TreeNode>() {

			public List<TreeNode> getChildren(TreeNode arg0) {
				return arg0.children;
			}

			public String getLabel(TreeNode arg0) {
				return arg0.getNom();
			}

			public boolean hasChildren(TreeNode arg0) {
				return !arg0.children.isEmpty();
			}

			public boolean isLeaf(TreeNode arg0) {
				return arg0.children.isEmpty();
			}

		};

		return new DefaultTreeModel<TreeNode>(encoder, adapter, TreeNode.ROOT.children);

	}
	
	
}
