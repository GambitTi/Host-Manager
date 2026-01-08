public class HostBST {
    private TreeNode root;

    public HostBST() {
        root = null;
    }

    public void addHost(String hostName, String ipAddress) {
        if (hostName == null || ipAddress == null) {
            throw new IllegalArgumentException("Hostname and IP address cannot be null");
        }
        root = insert(root, hostName, ipAddress);
    }

    private TreeNode insert(TreeNode node, String hostName, String ipAddress) {
        if (node == null) {
            return new TreeNode(hostName, ipAddress);
        }

        int cmp = hostName.compareTo(node.hostName);
        if (cmp < 0) {
            node.left = insert(node.left, hostName, ipAddress);
        } else if (cmp > 0) {
            node.right = insert(node.right, hostName, ipAddress);
        } else {
            node.ipAddress = ipAddress; // Update IP if host exists
        }
        return node;
    }

    public String getIPAddress(String hostName) {
        if (hostName == null) {
            throw new IllegalArgumentException("Hostname cannot be null");
        }
        return search(root, hostName);
    }

    private String search(TreeNode node, String hostName) {
        if (node == null) return null;

        int cmp = hostName.compareTo(node.hostName);
        if (cmp == 0) return node.ipAddress;

        return (cmp < 0) ? search(node.left, hostName) : search(node.right, hostName);
    }

    public boolean containsHostname(String hostName) {
        return getIPAddress(hostName) != null;
    }
}