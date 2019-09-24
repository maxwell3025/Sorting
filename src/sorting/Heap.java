package sorting;

import java.util.Random;

public class Heap {
	static int numbers = 127;
	int[] heapdata = new int[0];

	public Heap() {
	}

	public int child(int position, boolean path) {
		if (path) {
			return position * 2 + 1;
		} else {
			return position * 2 + 2;
		}

	}

	public static void main(String[] args) {
		Heap a = new Heap();
		Random r = new Random();
		int[] b = new int[numbers];
		boolean[] used = new boolean[numbers];
		for (int i = 0; i < numbers; i++) {
			int g=1;
			while(used[g-1]){
				g = r.nextInt(numbers)+1;
			}
			used[g-1]=true;
			b[i]=g;
			
			
			a.add(b[i]);
		}
		int waiting = 1;
		int current = 0;
		for (int i = 0; i < numbers; i++) {
			System.out.print(a.heapdata[i] + " \t");
			current++;
			if(current==waiting){
				current=0;
				waiting*=2;
						System.out.println("");;
			}
		}
	}

	public static boolean untrue() {
		return false;
	}

	public int parent(int position) {
		return (position - 1) / 2;
	}

	public int[] swap(int a, int b, int[] array) {
		int swap = array[b];
		array[b] = array[a];
		array[a] = swap;
		return array;
	}

	public void add(int a) {
		int[] newheap = new int[heapdata.length + 1];
		for (int i = 0; i < heapdata.length; i++) {
			newheap[i] = heapdata[i];
		}
		newheap[newheap.length - 1] = a;
		int currentselected = newheap.length - 1;
		while (newheap[currentselected] > newheap[parent(currentselected)]) {
			newheap = swap(currentselected, parent(currentselected), newheap);
			currentselected = parent(currentselected);
		}
		heapdata = newheap;
	}
	public void remove(int a){
		if(child(a,true)<heapdata.length){
			if(heapdata[child(a,true)]>heapdata[child(a,false)]){
			heapdata[a]=heapdata[child(a,true)];
			remove(child(a,true));
		}else{
			heapdata[a]=heapdata[child(a,false)];
			remove(child(a,false));
		}
		}else if(child(a,false)<heapdata.length){
			
		}
		
	}
}
