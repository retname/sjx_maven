package cn.springAop.singleton;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*Object before=new Object();
		Object now=new Object();
		Object after=new Object();
		
		Thread th1=new Thread(new RunnableTest("�߳�һ", after, before));
		Thread th2=new Thread(new RunnableTest("�̶߳�", before, now));
		Thread th3=new Thread(new RunnableTest("�߳���", now, after));
		
		th1.start();
		th1.sleep(200);
		th2.start();
		th2.sleep(200);
		th3.start();*/
		
		/*while(true){
			Thread thread = new Thread(new RunnableTestTwo());
			thread.start();
			thread.sleep(1000);
		}*/
		
		
		Integer num = 0;
		
		Thread threa1 = new Thread(new RunnableTestThree(++num));
		Thread threa2 = new Thread(new RunnableTestThree(++num));
		Thread threa3 = new Thread(new RunnableTestThree(num--));
		Thread threa4 = new Thread(new RunnableTestThree(num--));
		
		
		
	
		
		
	}

}
