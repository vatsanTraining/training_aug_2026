package com.training;


class Demo implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<10;i++) {
			System.out.println(i);
		}
		
	}
	
	
}
public class UsingLambdas {

	public static void main(String[] args) {

		
//		class Demo implements Runnable{
//
//			@Override
//			public void run() {
//				for(int i=1;i<10;i++) {
//					System.out.println(i);
//				}
//				
//			}
//			
//			
//		}
		
		
		// i don't have class declaration, no @overide no method name
		
		
		Runnable lambda = () -> {
			for(int i=1;i<10;i++) {
				System.out.println(i);
			}
		};
		
		Thread t1 = new Thread(lambda);
		t1.start();
		
		
		Thread t2 = new Thread(new Demo());
		t2.start();
	}

}
