package py.com.snowtech.util;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonCreator {
	public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
			throws JSONException {
			// TODO: add parsing code here
	        JSONObject myjson = new JSONObject(weatherJsonStr);
	        JSONObject jsonTemp = myjson.getJSONArray("list").getJSONObject(dayIndex)
	        		.getJSONObject("temp");
	        
	        double max = Double.parseDouble(jsonTemp.get("max").toString());
	        
	        
			return max;
	}
	
	public static void main(String[] args) throws JSONException {
		String json = "{"+
				"\"cod\":\"200\","+
				"\"message\":0.1463,"+
				"\"city\": {"+
				"	\"id\":0,"+
				"	\"name\":\"Lambare\","+
				"	\"coord\":{\"lon\":-57.61284,\"lat\":-25.34826},"+
				"	\"country\":\"Paraguay\","+
				"	\"population\":0"+
				"},"+
				"\"cnt\":7,"+
				"\"list\":["+
				"	{ 	\"dt\":1434812400,"+
				"		\"temp\":{\"day\":20.37,\"min\":13.88,\"max\":20.37,\"night\":13.88,\"eve\":19.83,\"morn\":20.37},"+
				"		\"pressure\":1024.88,"+
				"		\"humidity\":82,"+
				"		\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],"+
				"		\"speed\":4.41,"+
				"		\"deg\":18,"+
				"		\"clouds\":44"+
				"	},"+
				"	{	\"dt\":1434898800,"+
					"	\"temp\":{\"day\":23.55,\"min\":12.82,\"max\":25.7,\"night\":17.77,\"eve\":24.33,\"morn\":12.82},"+
					"	\"pressure\":1026.78,\"humidity\":89,"+
					"	\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],"+
					"	\"speed\":2.16,"+
					"	\"deg\":38,"+
					"	\"clouds\":0"+
					"}"+
				"]"+
			"}";
		System.out.print(getMaxTemperatureForDay(json, 0));
	}
}
