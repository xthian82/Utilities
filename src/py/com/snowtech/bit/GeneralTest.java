package py.com.snowtech.bit;

public class GeneralTest {
	 enum DataPointType {
	    WIND,
	    TEMPERATURE,
	    HUMIDTY,
	    PRESSURE,
	    CLOUDCOVER,
	    PRECIPITATION
	}
	 
	 public static void main(String[] args) {
		 final DataPointType dptype = DataPointType.valueOf("wind".toUpperCase());
		 
		 switch (dptype) {
		 	case WIND:
		 		 System.out.println(dptype);
		 		break;
			case CLOUDCOVER:
				break;
			case HUMIDTY:
				break;
			case PRECIPITATION:
				break;
			case PRESSURE:
				break;
			case TEMPERATURE:
				break;
			default:
				break;
		 }
		
	 }
}
