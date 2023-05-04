package Driver;

import utilities.MyDLL;
import utilities.MyQueue;
import utilities.MyStack;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack myStack = new MyStack();

		MyQueue q1 = new MyQueue();

//		myStack.Stack(10);
//		myStack.push(10);
//		myStack.push(20);
//		myStack.push(30);
//		myStack.push(40);
//
//		myStack.pop();
//
//
//		Object[] stack = myStack.toArray();
//
//		for (int i = 0; i < stack.length; i++) {
//			System.out.println("Element in array: " + stack[i]);
//
//		q1.enqueue("A");
//		q1.enqueue("b");
//		q1.enqueue("C");

		MyDLL<String> d1 = new MyDLL<String>();

		d1.add("A");
		d1.add("B");
		d1.add("C");
		d1.add("X");
		
		d1.remove("B");
		Object[] a = d1.toArray();

		for (int i = 0; i < a.length; i++) {
			System.out.println("Element in array: " + a[i]);
		}
		
//		System.out.println("Does the DLL contain this letter? " + d1.contains("A"));
//
//		System.out.println("Does first DLL = second DLL? " + d1.equals(d2));
//
//		d1.get(1);
//
//		d1.isEmpty();
//
//		d1.remove(0);
//		d1.remove(3);
//
//		d1.remove("B");

//		for (int i = 0; i < d1.size(); i++) {
//			System.out.println(d1.get(i));
//		}

		// String[] a1 = { "yerr", "berr", "jerr" };

	}
}