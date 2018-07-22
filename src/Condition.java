
public class Condition {

	int wait;
	int signal;
	
	public void cond_init() {
		wait = 0;
		signal = 0;
	}
	
	public void cond_wait(Lock lock) {
		lock.lock_release();
		wait += 1;
		while(signal <= 0) {
			try {
				synchronized(this) {
					wait();
				}
			} catch (InterruptedException e) {}
		}
		lock.lock_acquire();
		wait -= 1;
		signal -= 1;
	}
	
	public void cond_signal(Lock lock) {
		if(wait > 0) {
			signal += 1;
			lock.lock_release();
			synchronized(this) {
				notify();
			}
		}
	}
	
	public void cond_broadcast(Lock lock) {
		if(wait > 0) {
			signal = wait;
			lock.lock_release();
			synchronized(this) {
				notifyAll();
			}
		}
	}	

	
}
