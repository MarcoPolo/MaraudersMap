package algorithm;

public interface SignalListener {
	public void signalReceived(int sensor, boolean isBlocked);
}
