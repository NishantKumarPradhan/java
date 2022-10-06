package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex{
		HashMap<String ,Integer> nbrs = new HashMap<>();
	}
	
	private HashMap<String , Vertex> vtces;
	
	public Graph() {
		vtces = new HashMap<>();
	}
	
	public int numVertex() {
		return this.vtces.size();
	}
	
	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}
	
	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}
	
	public void removeVertex(String vname) {
		
		  Vertex vtx = vtces.get(vname);
		  ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		  
		  for (String key : keys) {
			  Vertex nbrVtx = vtces.get(key);
			  nbrVtx.nbrs.remove(vname);
		  }
		  vtces.remove(vname);
	}
	
	public int numEdges() {
		 ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		 int count = 0;
		 for (String key : keys) {
			 
			 Vertex vtx = vtces.get(key);
			 count = count + vtx.nbrs.size();
		 }
		 return count / 2;
	}
	
	public boolean containsEdge(String vname1, String vname2) {
		
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
		 
	}
	
	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1); // 2k
		Vertex vtx2 = vtces.get(vname2);  // 4k
		
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		
		vtx1.nbrs.put(vname2, cost);   // 2k nbrs put C with a given cost
		vtx2.nbrs.put(vname1, cost);   // 4k nbrs put A with a given cost
		
		 
	}
	
	public void removeEdge(String vname1, String vname2) {
		
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);	
	}
	
	public void display() {
		System.out.println("---------------------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " : "  + vtx.nbrs);
		}
		System.out.println("----------------------------");
	}
	
	public boolean hasPath(String vname1, String vname2) {
		HashMap<String, Boolean> processed = new HashMap<>();
		return hasPath(vname1, vname2, processed);
	}
	
	private boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		
		processed.put(vname1, true);
		if (containsEdge(vname1, vname2)) {  //dr
			return true;
		}
		
		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
				return true;
			}
		}
		return false;
	}
	
	private class Pair{
		String vname; 
		String psf ;
		 	
	}
	
	public boolean bfs(String src, String dist) {
		
		LinkedList<Pair> queue = new LinkedList<>();
		
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		
		// put the new pair in queue
		queue.addLast(sp);
		
		//while queue is not empty keep on doing work
		while (!queue.isEmpty()) {
			
			// remove a pair from queue
			Pair rp = queue.removeFirst();
	
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			//processed put
			processed.put(rp.vname, true);
			
			//direct edge if present
			if (containsEdge(rp.vname, dist)) {
				System.out.println(rp.psf);
				return true;
			}
			
			//nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			
			// loop for nbrs
			for (String nbr : nbrs) {
				
				// processed only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					
					//make a new pair of nbr and put it on queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr; 
					queue.addLast(np);
				}
				
			}
			
			
		}
		return false;
	}
	
	public boolean dfs(String src, String dist) {
		
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// create the sp
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		
		// add sp in stack
		stack.addFirst(sp);
		
		while (!stack.isEmpty()) {
			
			Pair rp = stack.removeFirst();
			
			
			if (processed.containsKey(rp.vname)) {
				continue;	
				
			}
			
			processed.put(rp.vname, true);
			
			if (containsEdge(rp.vname, dist)) {
				System.out.println(rp.psf);
				return true;
			}
			
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}
	
	public void bft() {
		
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// if there is two components of  graph
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			
			if (processed.containsKey(key)) {
				continue;
			}
			
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			queue.addLast(sp);
			
			while (!queue.isEmpty()) {
				
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);
				
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
	}
	
	public void dft() {
		
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// if there is two components of  graph
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			
			if (processed.containsKey(key)) {
				continue;
			}
			
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			stack.addFirst(sp);
			
			while (!stack.isEmpty()) {
				
				Pair rp = stack.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);
				
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst  (np);
					}
				}
			}
		}
	}
	
	public boolean iscyclic() {
		
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// if there is two components of  graph
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			
			if (processed.containsKey(key)) {
				continue;
			}
			
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			queue.addLast(sp);
			
			while (!queue.isEmpty()) {
				
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				
				processed.put(rp.vname, true);
				
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		return false;
	}
	
    public boolean isconnected() {
	
		int flag = 0;
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// if there is two components of  graph
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			
			if (processed.containsKey(key)) {
				continue;
			}
			
			flag++;
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			queue.addLast(sp);
			
			while (!queue.isEmpty()) {
				
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				processed.put(rp.vname, true);
				
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		if (flag >= 2) {
			return false;
		}
		else {
			return true;
		}
		
	}
    
    public boolean isTree() {
    	return !iscyclic() && isconnected();
    }
    
    public ArrayList<ArrayList<String>> getCC() {
		
    	ArrayList<ArrayList<String>> ans = new ArrayList<>();
    	
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		
		// if there is two components of  graph
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		for (String key : keys) {
			
			if (processed.containsKey(key)) {
				continue;
			}
			
			ArrayList<String> smallAns = new ArrayList<>();
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			queue.addLast(sp);
			
			while (!queue.isEmpty()) {
				
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				processed.put(rp.vname, true);
				
				smallAns.add(rp.vname);
				
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
			ans.add(smallAns);
		}
		return ans;
	}

    private class PrimsPair implements Comparable<PrimsPair>{
    	String vname;
    	String acqname;
    	int cost;
    	
		@Override
		public int compareTo(PrimsPair o) {
			
			return o.cost - this.cost;
		}
    }
    
    public Graph prims() {
    	
    	Graph mst = new Graph();
    	HashMap<String, PrimsPair> map = new HashMap<>();
    	
    	Heap<PrimsPair> heap = new Heap<>();
    	
    	for (String key : vtces.keySet()) {
    		
    		PrimsPair np = new PrimsPair();
    		np.vname = key;
    		np.acqname = null;
    		np.cost = Integer.MAX_VALUE;
    		
    		heap.add(np);
    		map.put(key, np);
    		
    	}
    	
    	while (!heap.isEmpty()) {
    		
    		PrimsPair rp = heap.remove();
    		map.remove(rp.vname);
    		
    		if (rp.acqname == null) {
    			mst.addVertex(rp.vname);
    		}
    		else {
    			mst.addVertex(rp.vname);
    			mst.addEdge(rp.vname, rp.acqname, rp.cost);
    		}
    		
    		for (String nbr : vtces.get(rp.vname).nbrs.keySet() ) {
    			
    			if (map.containsKey(nbr)) {
    				 
    				int oc = map.get(nbr).cost;
    				int nc = vtces.get(rp.vname).nbrs.get(nbr);
    				
    				if (nc < oc) {
    					
    					PrimsPair gp = map.get(nbr);
    					gp.acqname = rp.vname; 
    					gp.cost = nc;
    					
    					heap.updatePriority(gp);
    				}
    			}
    			
    			
    		}
    		
    		
    		
    		
    		
    		
    	}
    	 
    	
    		
    	
    	
    	return mst;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
