public class Monitor {
	
	int i;
	Lock monitorLock;
	Condition cond;
	
	public Monitor() {
		(monitorLock = new Lock()).lock_init();
		(cond = new Condition()).cond_init();
		i = 0;
	}
	
	public void increment() {
		monitorLock.lock_acquire();
		i += 1;
		cond.cond_wait(monitorLock);
		monitorLock.lock_release();
	}
	
	public int decrement(int count) {
		monitorLock.lock_acquire();
		while(i > 0 && count > 0) {
			i -= 1;
			count -= 1;
			cond.cond_signal(monitorLock);
			monitorLock.lock_acquire();
		}
		monitorLock.lock_release();
		return count;
	}
	
}
