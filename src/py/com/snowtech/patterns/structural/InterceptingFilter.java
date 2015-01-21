package py.com.snowtech.patterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * The intercepting filter design pattern is used when we want to do some 
 * pre-processing / post-processing with request or response of the application. 
 * Filters are defined and applied on the request before passing the request to 
 * actual target application. Filters can do the authentication/authorization/ 
 * logging or tracking of request and then pass the requests to corresponding 
 * handlers. 
 * 
 * Following are the entities of this type of design pattern.
 * 
 * Filter         - Filter which will performs certain task prior or after 
 *                  execution of request by request handler.
 * 
 * Filter Chain   - Filter Chain carries multiple filters and help to execute 
 *                  them in defined order on target.
 *
 * Target         - Target object is the request handler.
 * 
 * Filter Manager - Filter Manager manages the filters and Filter Chain.
 * 
 * Client         - Client is the object who sends request to the Target object.

 * @author xpy0035
 *
 */

interface IFilter {
	public void execute(String request);
}

class AuthenticationFilter implements IFilter {
	public void execute(String request) {
		System.out.println("Authenticating request: " + request);
	}
}

class DebugFilter implements IFilter {
	public void execute(String request) {
		System.out.println("request log: " + request);
	}
}

class Target {
	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}

class FilterChain {
	private List<IFilter> filters = new ArrayList<IFilter>();
	private Target target;

	public void addFilter(IFilter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (IFilter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}

class FilterManager {
	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(IFilter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}
}

class FilterClient {
	FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}
}

public class InterceptingFilter {

	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());

		FilterClient client = new FilterClient();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}

}
