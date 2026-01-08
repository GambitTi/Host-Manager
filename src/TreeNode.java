public class TreeNode {
    String hostName;
    String ipAddress;
    TreeNode left;
    TreeNode right;

    public TreeNode(String hostName, String ipAddress) {
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.left = null;
        this.right = null;
    }
}
