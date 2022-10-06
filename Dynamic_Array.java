package demo;

public class Dynamic_Array {
	
		 int data[];
		 int nextIndex;
		 
		 public Dynamic_Array() {      //remove void
			 data = new int[5];
			 nextIndex=0;
			 
		 }
		 
		 
		 public int size() {
			 return nextIndex;
		 }
		 
		 
		 public void add(int element) { //for just adding elements at the end of the array
			
		if(nextIndex==data.length)	{
			restructure();
		}
		data[nextIndex]=element;
		nextIndex++;
		 }
		 
		 
		 private void restructure() {
			 int temp[] = data;
			 data = new int[data.length*10];
			 for(int i = 0 ; i < temp.length; i++) {
				 data[i]=temp[i];
			 }
		 }
			
			
		 public void set(int index, int element) {
			 if(index > nextIndex && index < 0) {  //add one more condition
				 restructure();
			 }
			 
			 if(index < nextIndex) {
			   data[index] = element;
			 }
			 
			 else {
			     add(element);
			}
		 }
		 
		 public int get(int index) {
			 if(index >= nextIndex || index < 0) {  //>= as nextIndex is for now zero naa so...
				 return -1;
			 }
			return data[index];
			 
		 }
		 
		 public boolean isEmpty() {
			 if(size() == 0) {
				 return true;
			 }
			 
			 else {
			     return false;
		 
			 }
		}
		 
		 
		 public int remove_last() {
			 if(size() == 0)
			 {
				 return -1;
			 }
			// int value = data[nextIndex - 1];  //NO NEED
			 // data[nextIndex - 1] = 0;
			 nextIndex--;
			// return value;
			 return data[nextIndex];
		 }
			
			
		}


