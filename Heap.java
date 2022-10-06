package demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap<T extends Comparable<T>>{

	
    ArrayList<T> data = new ArrayList<>();
    HashMap<T, Integer> map = new HashMap<>();
	
	public void add(T item) {
		data.add(item);
		map.put(item, this.data.size() - 1);
		upheapify(this.data.size() - 1);	
	}
	
	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (isLarger(data.get(pi) ,data.get(ci)) >  0) {
			swap (pi, ci);
			upheapify(pi); 
		}
	}
	  
	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
		
		map.put(ith, j);
		map.put(jth, i);
	}
	
	public void display() {
		System.out.println(data);
	}
	
	public int size () {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.data.size() == 0;	
	}
	
	public T remove() {
		swap(0, this.data.size() - 1);
		T v = this.data.remove(data.size() - 1);
		downheapify(0);
		map.remove(v);
		return v;
	}
	
	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && isLarger(data.get(mini) , data.get(lci)) > 0) {
			mini = lci;
		}
		if (rci < data.size() && isLarger(data.get(mini) , data.get(rci)) > 0) {
			mini = rci;
		}
		
		if (mini != pi) {
			swap(mini , pi);
			downheapify(mini);
		}
	}
	
	public T get() {
		return data.get(0);
	}
	
	// if  t is having high priority then return +ve value
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}
	
	public void updatePriority(T pair) {
		 
		int index = map.get(pair);
		upheapify(index);
	}
}
