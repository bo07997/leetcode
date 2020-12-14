package leetcode.myjob;

import leetcode.myjob.config.PetV1Config;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 18:25
 * 2维数组里的节点
 */
public class Node {
	private NodeType nodeType;
	private PetV1 petV1;

	public Node(NodeType nodeType, PetV1 petV1) {
		this.nodeType = nodeType;
		this.petV1 = petV1;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public PetV1 getPetV1() {
		return petV1;
	}

	public static Node parse(String str) {
		String[] params = str.split(":", -1);
		NodeType nodeType = NodeType.parse(Integer.parseInt(params[0]));
		PetV1 petV1 = PetV1Config.getPetById(Integer.parseInt(params[1]));
		return new Node(nodeType, petV1);
	}

	//0:1:0#0:4:0#0:4:0#0:4:0#0:4:0|0:7:0#0:4:0#0:4:0#0:4:0#0:4:0|0:1:0#0:4:0#0:7:0#0:4:0#0:4:0|0:1:0#0:4:0#0:7:0#0:4:0#0:7:0|0:1:0#0:4:0#0:4:0#0:7:0#0:4:0|0:1:0#0:4:0#0:7:0#0:4:0#0:7:0
	public static Node[][] parseArray(String str) {
		String[] params = str.split("\\|");
		Node[][] result = new Node[params.length][];
		for (int i = 0; i < params.length; i++) {
			String[] params2 = params[i].split("#");
			Node[] tempNode = new Node[params2.length];
			for (int j = 0; j < params2.length; j++) {
				tempNode[j] = parse(params2[j]);
			}
			result[i] = tempNode;
		}
		return result;
	}

	@Override
	public String toString() {
		return nodeType.id + ":" + ((petV1 != null) ? String.valueOf(petV1.id) : "-1");
	}

	public String toTest() {
		return ((petV1 != null) ? String.valueOf(petV1.id) : "-1");
	}

	/**
	 * 业务相关的同色
	 */
	public boolean myEquals(Node obj) {
		return nodeType == obj.nodeType && petV1.id == obj.petV1.id;
	}
}
