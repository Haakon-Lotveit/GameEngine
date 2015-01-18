package game.graphics;

/**
 * A simple thread that tries to paint sixty times a second.
 * (That is, 60 fps. PC master race, etc.)
 * 
 * Since two PaintingThread are equal IFF they are the same object,
 * neither equals nor hashcode methods are overridden.
 *  
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public class PaintingThread extends Thread{
	GameCanvas gameCanvas;
	
	/**
	 * Creates a new painting thread, which paints a GameCanvas.Lager en ny malertråd, som maler et GameCanvas.
	 * @param gameCanvas the GameCanvas to be painted
	 * @throws NullPointerException if you do something dumb like passing a null.
	 */
	public PaintingThread(GameCanvas gameCanvas) throws NullPointerException {
		super();
		if(null == gameCanvas){
			throw new NullPointerException("GameCanvas can not be null");
		}
		
		this.gameCanvas = gameCanvas;
		this.start();
	}
	
	@Override
	public void run(){
		/*
		 * A word of warning is needed here, about timestamps.
		 * System.currentTimeMillis sounds like a decent choice here, but it isn't.
		 * The reason is that it says what time it currently is, and time does not always go forward.
		 * Think about time zones for instance, or daylight savings time.
		 * We don't need, nor care about the exact time it is, we care about how much time has passed.
		 * Therefore, our timestamps must be monotonously increasing, and the devil take the date.
		 * Every time a certain amount of time has passed, we need the timestamp to increase by as much.
		 * The precise values are only of academic interest.
		 * 
		 * Another thing that should be pointed out here is that the thread is spinlocked, which is not the greatest idea ever.
		 * It does work, and that's all that's required of it.
		 * Therefore, if it is a bottleneck, you might want to choose a different locking mechanism.
		 * (It will also drain laptop batteries pretty fast.)
		 */
		System.out.println("PaintingThread started");
		
		long timestamp = System.nanoTime();
		long paintFrequency = 1_000_000_000L / 60L; // 60 times per second.
		
		while(!Thread.interrupted()){ /* Interrupting the thread means that it will exit. */
			long timeSinceLastPaint = System.nanoTime() - timestamp;

			if(timeSinceLastPaint >= paintFrequency){
				gameCanvas.render();
				timestamp = System.nanoTime();
			}
		}
		
	}
}
