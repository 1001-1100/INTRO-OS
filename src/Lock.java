
public class Lock {
	
	int i;
	
	public void lock_init() {
		i = 1;
	}
	
	public synchronized void lock_acquire() {
		while(i <= 0);
		i -= 1;
	}
	
	public void lock_release() {
		i += 1;
	}
	
}
