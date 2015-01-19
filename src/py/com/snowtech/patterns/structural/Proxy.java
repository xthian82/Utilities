package py.com.snowtech.patterns.structural;


/**
 * In proxy pattern, a class represents functionality of another class. This type of design 
 * pattern comes under structural pattern. 
 * 
 * In proxy pattern, we create object having original object to interface its functionality 
 * to outer world.
 * 
 * @author cristhian
 *
 */
interface Image {
	public void displayImage();
}

class RealImage implements Image {
	 
    private String filename = null;
    /**
     * Constructor
     * @param filename
     */
    public RealImage(final String filename) { 
        this.filename = filename;
        loadImageFromDisk();
    }
 
    /**
     * Loads the image from the disk
     */
    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }
 
    /**
     * Displays the image
     */
    public void displayImage() { 
        System.out.println("Displaying " + filename); 
    }
}

class ProxyImage implements Image {
	 
    private RealImage image = null;
    private String filename = null;
    /**
     * Constructor
     * @param filename 
     */
    public ProxyImage(final String filename) { 
        this.filename = filename; 
    }
 
    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
           image = new RealImage(filename);
        } 
        image.displayImage();
    }
 
}

public class Proxy {
	public static void main(String[] args) {
		final Image IMAGE1 = new ProxyImage("HiRes_10MB_Photo1");
	    final Image IMAGE2 = new ProxyImage("HiRes_10MB_Photo2");
	    
	    IMAGE1.displayImage(); // loading necessary
	    IMAGE1.displayImage(); // loading unnecessary
	    IMAGE2.displayImage(); // loading necessary
	    IMAGE2.displayImage(); // loading unnecessary
	    IMAGE1.displayImage(); // loading unnecessary
	}
}
