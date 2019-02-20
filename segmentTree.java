public class segmentTree {

	static long init(long[] a, long[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = a[start];
		}
		else {
			return tree[node] = init(a,tree,node*2,start,(start+end)/2) + init(a, tree, node*2+1, (start+end)/2+1, end);
		}
	}
	static long sum(long[] tree, int node, int start, int end, int left, int right) {
	    if (left > end || right < start) {
	        return 0;
	    }
	    if (left <= start && end <= right) {
	        return tree[node];
	    }
	    return sum(tree, node*2, start, (start+end)/2, left, right) + sum(tree, node*2+1, (start+end)/2+1, end, left, right);
	}
	static void update(long[] tree, int node, int start, int end, int index, long diff) {
	    if (index < start || index > end) return;
	    tree[node] = tree[node] + diff;
	    if (start != end) {
	        update(tree,node*2, start, (start+end)/2, index, diff);
	        update(tree,node*2+1, (start+end)/2+1, end, index, diff);
	    }
	}
	static double baseLog(double x, double base) {
		return Math.log10(x) / Math.log10(base);
	}
}
