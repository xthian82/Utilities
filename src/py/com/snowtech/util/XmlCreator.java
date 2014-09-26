package py.com.snowtech.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlCreator {
	private static Marshaller getMarshaller(Object T) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(T.getClass());
        Marshaller m = context.createMarshaller();
        
        //for pretty-print XML in JAXB
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        return m;
	}
	public static <T> T XMLToObject(T o, final String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Unmarshaller un = context.createUnmarshaller();
            @SuppressWarnings("unchecked")
			T emp = (T)un.unmarshal(new File(fileName));
            
            return emp;
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
			e.printStackTrace();
		}
        return null;
    }
 
 
    public static void ObjectToXML(Object T, Writer ptr) {
 
        try {
        	getMarshaller(T).marshal(T, ptr);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public static void ObjectToXML(Object T, PrintStream ptr) {
    	 
        try {
        	getMarshaller(T).marshal(T, ptr);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String... args) throws IOException {
    	Employee emp = new Employee();
    	Schedule s = new Schedule();
    	
    	s.setDays(5);
    	s.setHours(3);
    	
    	emp.setAge(3);
    	emp.setGender("Female");
    	emp.setId(1);
    	emp.setName("Agustina");
    	emp.setRole("Boss");
    	emp.setSchedule(s);
    	
    	XmlCreator.ObjectToXML(emp, new FileWriter("emp-jab.xml"));
    	//XmlCreator.ObjectToXML(emp, System.out);
    	System.out.println("--------------");
    	Employee m = (Employee) XmlCreator.XMLToObject(emp, "emp-jab.xml");
    	
    	System.out.println(m);
    }
}
